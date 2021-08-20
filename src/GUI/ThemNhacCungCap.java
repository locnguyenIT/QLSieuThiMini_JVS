/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.KhachHangBUS;
import BUS.NhaCungCapBUS;
import DTO.KhachHangDTO;
import DTO.NhaCungCapDTO;
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
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ntloc
 */
public class ThemNhacCungCap extends JDialog{
     private JLabel lbMancc,lbTenncc,lbDiachi,lbMst, lbFax,lbThongtin;
    private JTextField txtMancc,txtTenncc,txtDiachi,txtMst,txtFax;
    private JButton btnSave,btnCancel;
    private JPanel pAddKH;
    private NhaCungCapBUS nccBUS = new NhaCungCapBUS();
    public ThemNhacCungCap() 
    {
        nccBUS.DanhSachNCC();
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
        setTitle("THÊM NHÀ CUNG CẤP");
        setBackground(Color.WHITE);
            
            pAddKH = new JPanel(null);
            pAddKH.setBounds(new Rectangle(0, 0, 650, 450));
            pAddKH.setBackground(Color.WHITE);
                
                JPanel pInfo = new JPanel(null);
                pInfo.setBounds(new Rectangle(0,0,650,50));
                pInfo.setBackground(new Color(85,93,110));
                
                lbThongtin = new JLabel("THÔNG TIN NHÀ CUNG CẤP");
                lbThongtin.setBounds(new Rectangle(200,12,300,30));
                lbThongtin.setForeground(Color.WHITE);
                lbThongtin.setHorizontalAlignment(JLabel.CENTER);
                lbThongtin.setFont(info);
                pInfo.add(lbThongtin);    
                
                lbMancc = new JLabel("Mã NCC");
                lbMancc.setBounds(new Rectangle(170,60,100,30));
                lbMancc.setFont(font1);
                txtMancc = new JTextField("");
                txtMancc.setBounds(new Rectangle(270,60,200,30));
                txtMancc.setFont(font1);
                txtMancc.setText(nccBUS.NextMancc());
                txtMancc.setEnabled(false);
                
                lbTenncc = new JLabel("Tên NCC ");
                lbTenncc.setBounds(new Rectangle(170, 100,100,30));
                lbTenncc.setFont(font1);
                txtTenncc = new JTextField("");
                txtTenncc.setBounds(new Rectangle(270,100,200,30));
                txtTenncc.setFont(font1);

                lbDiachi= new JLabel("Địa chỉ");
                lbDiachi.setBounds(new Rectangle(170, 140, 100, 30));
                lbDiachi.setFont(font1);
                txtDiachi = new JTextField("");
                txtDiachi.setBounds(new Rectangle(270,140,200,30));
                txtDiachi.setFont(font1);

                lbMst = new JLabel("Mã số thuế");
                lbMst.setBounds(new Rectangle(170,180,100, 30));
                lbMst.setFont(font1);
                txtMst = new JTextField("");
                txtMst.setBounds(new Rectangle(270,180,200,30));
                txtMst.setFont(font1);

                lbFax = new JLabel("Fax");
                lbFax.setBounds(new Rectangle(170,220, 150, 30));
                lbFax.setFont(font1);
                txtFax = new JTextField("");
                txtFax.setBounds(new Rectangle(270,220,200,30));
                txtFax.setBackground(null);
                txtFax.setFont(font1);
                
                btnSave = new JButton(new ImageIcon("./src/image/btnSave_30px.png"));
                btnSave.setBounds(new Rectangle(200,300,115,35));
                btnSave.setBackground(null);
                btnSave.setFont(font1);
                btnSave.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                btnCancel = new JButton(new ImageIcon("./src/image/btnCancel_30px.png"));
                btnCancel.setBounds(new Rectangle(330,300,116,35));
                btnCancel.setBackground(null);
                btnCancel.setFont(font1);
                btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                JPanel pFooter = new JPanel(null);
                pFooter.setBounds(new Rectangle(0,363, 650, 50));
                pFooter.setBackground(new Color(85,93,110));
                
                
                btnSave.addActionListener(new ActionListener() {      
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    String mancc = txtMancc.getText();
                    String tenncc = txtTenncc.getText();
                    String diachi = txtDiachi.getText();
                    String mst = txtMst.getText();
                    String fax = txtFax.getText();
                    
                    NhaCungCapDTO ncc = new NhaCungCapDTO(mancc, tenncc, diachi, mst, fax);
                    nccBUS.Add(ncc);
                    setVisible(false);
                   // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
                });
                
         
                btnCancel.addActionListener(new ActionListener() {      
                @Override
                public void actionPerformed(ActionEvent e) {
                    txtMancc.setText("");
                    setVisible(false);
                   // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
                });
                pAddKH.add(pInfo);
                pAddKH.add(pFooter);
            pAddKH.add(lbMancc);
            pAddKH.add(txtMancc);
            pAddKH.add(lbTenncc);
            pAddKH.add(txtTenncc);
            pAddKH.add(lbDiachi);
            pAddKH.add(txtDiachi);
            pAddKH.add(lbMst);
            pAddKH.add(txtMst);
            pAddKH.add(lbFax);
            pAddKH.add(txtFax);
            pAddKH.add(btnSave);
            pAddKH.add(btnCancel); 
        add(pAddKH);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public String getData()
    {
        return txtTenncc.getText();
    }
}
