/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.KhachHangBUS;
import DTO.KhachHangDTO;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ntloc
 */
public class AddKhachHang extends JDialog{
    
    private JLabel lbMakh, lbHokh,lbTenkh,lbDiachi,lbSDT,lbEmail,lbThongtin;
    private JTextField txtMakh,txtHokh,txtTenkh,txtDiachi,txtEmail,txtSDT;
    private JButton btnSave,btnCancel;
    private JPanel pAddKH;
    private KhachHangBUS khBUS = new KhachHangBUS();
    public AddKhachHang() 
    {
        khBUS.DanhSachKhachHang();
        setModal(true);
        Init();
    }
    public void Init()
    {
        Font font0 = new Font("Segoe UI",Font.BOLD,13);
        Font font1 = new Font("Segoe UI",Font.PLAIN,13);
        Font info = new Font("Segoe UI",Font.BOLD,22);
        setSize(650,450);
        setLayout(null);
        setTitle("THÊM KHÁCH HÀNG");
        setBackground(Color.WHITE);
            
            pAddKH = new JPanel(null);
            pAddKH.setBounds(new Rectangle(0, 0, 650, 450));
            pAddKH.setBackground(Color.WHITE);
                
                JPanel pInfo = new JPanel(null);
                pInfo.setBounds(new Rectangle(0,0,650,50));
                pInfo.setBackground(new Color(85,93,110));
                
                lbThongtin = new JLabel("THÔNG TIN KHÁCH HÀNG");
                lbThongtin.setBounds(new Rectangle(200,12,300,30));
                lbThongtin.setForeground(Color.WHITE);
                lbThongtin.setHorizontalAlignment(JLabel.CENTER);
                lbThongtin.setFont(info);
                pInfo.add(lbThongtin);    
                
                lbMakh = new JLabel("Mã khách hàng");
                lbMakh.setBounds(new Rectangle(170,60,100,30));
                lbMakh.setFont(font1);
                txtMakh = new JTextField("");
                txtMakh.setBounds(new Rectangle(270,60,200,30));
                txtMakh.setFont(font1);
                txtMakh.setText(khBUS.NextMakh());
                txtMakh.setEnabled(false);

                lbHokh = new JLabel("Họ ");
                lbHokh.setBounds(new Rectangle(170, 100,100,30));
                lbHokh.setFont(font1);
                txtHokh = new JTextField("");
                txtHokh.setBounds(new Rectangle(270,100,200,30));
                txtHokh.setFont(font1);

                lbTenkh = new JLabel("Tên");
                lbTenkh.setBounds(new Rectangle(170, 140, 100, 30));
                lbTenkh.setFont(font1);
                txtTenkh = new JTextField("");
                txtTenkh.setBounds(new Rectangle(270,140,200,30));
                txtTenkh.setFont(font1);

                lbDiachi = new JLabel("Địa chỉ");
                lbDiachi.setBounds(new Rectangle(170,180,100, 30));
                lbDiachi.setFont(font1);
                txtDiachi = new JTextField("");
                txtDiachi.setBounds(new Rectangle(270,180,200,30));
                txtDiachi.setFont(font1);

                lbSDT = new JLabel("Số điện thoại");
                lbSDT.setBounds(new Rectangle(170,220, 150, 30));
                lbSDT.setFont(font1);
                txtSDT = new JTextField("");
                txtSDT.setBounds(new Rectangle(270,220,200,30));
                txtSDT.setBackground(null);
                txtSDT.setFont(font1);
                
                lbEmail = new JLabel("Email");
                lbEmail.setBounds(new Rectangle(170,260, 150, 30));
                lbEmail.setFont(font1);
                txtEmail = new JTextField("");
                txtEmail.setBounds(new Rectangle(270,260,200,30));
                txtEmail.setBackground(null);
                txtEmail.setFont(font1);
                
                btnSave = new JButton(new ImageIcon("./src/image/btnSave_30px.png"));
                btnSave.setBounds(new Rectangle(200,320,115,35));
                btnSave.setBackground(null);
                btnSave.setCursor(new Cursor(Cursor.HAND_CURSOR));
               
                btnCancel = new JButton(new ImageIcon("./src/image/btnCancel_30px.png"));
                btnCancel.setBounds(new Rectangle(330,320,116,35));
                btnCancel.setBackground(null);
                btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                
                JPanel pFooter = new JPanel(null);
                pFooter.setBounds(new Rectangle(0,363, 650, 50));
                pFooter.setBackground(new Color(85,93,110));
                
                
                btnSave.addActionListener(new ActionListener() {      
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    String makh = txtMakh.getText();
                    String hokh = txtHokh.getText();
                    String tenkh = txtTenkh.getText();
                    String diachi = txtDiachi.getText();
                    String sdt = txtSDT.getText();
                    String email = txtEmail.getText();
                    KhachHangDTO kh = new KhachHangDTO(makh, hokh, tenkh, diachi, sdt,email);
                    khBUS.Add(kh);
                    JOptionPane.showMessageDialog(null,"Thêm thành công");
                    dispose();
                   // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
                });
 
                btnCancel.addActionListener(new ActionListener() {      
                @Override
                public void actionPerformed(ActionEvent e) {
                    txtMakh.setText("");
                    dispose();
                   // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
                });
                pAddKH.add(pInfo);
                pAddKH.add(pFooter);
            pAddKH.add(lbMakh);
            pAddKH.add(txtMakh);
            pAddKH.add(lbHokh);
            pAddKH.add(txtHokh);
            pAddKH.add(lbTenkh);
            pAddKH.add(txtTenkh);
            pAddKH.add(lbDiachi);
            pAddKH.add(txtDiachi);
            pAddKH.add(lbSDT);
            pAddKH.add(txtSDT);
            pAddKH.add(lbEmail);
            pAddKH.add(txtEmail);
            pAddKH.add(btnSave);
            pAddKH.add(btnCancel); 
        add(pAddKH);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public String getData()
    {
        return txtMakh.getText();
    }
    
    
}
