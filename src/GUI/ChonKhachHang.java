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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ntloc
 */
public class ChonKhachHang extends JDialog{
    
    private JLabel lbThongtin, lbMakh,lbHokh, lbTenkh, lbDiachi, lbSDT, lbEmail,lbSearch,lbIconSearch;
    private JTextField txtMakh,txtHokh, txtTenkh,txtDiachi, txtSDT,txtEmail, txtSearch;
    private JButton btnConfirm, btnCancel;
    private JTable table;
    private JScrollPane scroll;
    private KhachHangBUS khBUS = new KhachHangBUS();
    private JPanel pChonKH;
    private DefaultTableModel model;
    private ArrayList<String> data = new ArrayList<>();
    public ChonKhachHang() 
    {
        setModal(true);
        khBUS.DanhSachKhachHang();
        Init();
    }
    
    public void Init()
    {
        Font font0 = new Font("Segoe UI",Font.BOLD,13);
        Font font1 = new Font("Segoe UI",Font.PLAIN,13);
        Font fontSeacrh = new Font("Segoe UI",Font.ITALIC,12);
        setSize(1000,500);
        setLayout(null);
        setTitle("CHỌN KHÁCH HÀNG");
        setBackground(Color.WHITE);
        
            pChonKH = new JPanel(null);
            pChonKH.setBounds(new Rectangle(0,0,1000,500));
            pChonKH.setBackground(Color.WHITE);
                
                lbThongtin = new JLabel("Thông tin Khách hàng");
                lbThongtin.setBounds(new Rectangle(90, 15,150,30));
                lbThongtin.setFont(font1);

                lbMakh = new JLabel("Mã KH ");
                lbMakh.setBounds(new Rectangle(30,60,100,30));
                lbMakh.setFont(font1);
                txtMakh = new JTextField("");
                txtMakh.setBounds(new Rectangle(100,60,200,30));
                txtMakh.setFont(font1);
                txtMakh.setEnabled(false);
                
                lbHokh = new JLabel("Họ ");
                lbHokh.setBounds(new Rectangle(30, 100,100,30));
                lbHokh.setFont(font1);
                txtHokh = new JTextField("");
                txtHokh.setBounds(new Rectangle(100,100,200,30));
                txtHokh.setFont(font1);
                txtHokh.setEnabled(false);
                
                lbTenkh = new JLabel("Tên");
                lbTenkh.setBounds(new Rectangle(30, 140, 100, 30));
                lbTenkh.setFont(font1);
                txtTenkh = new JTextField("");
                txtTenkh.setBounds(new Rectangle(100,140,200,30));
                txtTenkh.setFont(font1);
                txtTenkh.setEnabled(false);

                lbDiachi = new JLabel("Địa chỉ");
                lbDiachi.setBounds(new Rectangle(30,180,100, 30));
                lbDiachi.setFont(font1);
                txtDiachi = new JTextField("");
                txtDiachi.setBounds(new Rectangle(100,180,200,30));
                txtDiachi.setFont(font1);
                txtDiachi.setEnabled(false);
                
                lbSDT = new JLabel("SĐT");
                lbSDT.setBounds(new Rectangle(30,220, 150, 30));
                lbSDT.setFont(font1);
                txtSDT = new JTextField("");
                txtSDT.setBounds(new Rectangle(100,220,200,30));
                txtSDT.setFont(font1);
                txtSDT.setEnabled(false);
                
                lbEmail = new JLabel("Email");
                lbEmail.setBounds(new Rectangle(30,260, 150, 30));
                lbEmail.setFont(font1);
                txtEmail = new JTextField("");
                txtEmail.setBounds(new Rectangle(100,260,200,30));
                txtEmail.setFont(font1);
                txtEmail.setEnabled(false);
                
                btnConfirm = new JButton(new ImageIcon("./src/image/btnConfirm_25px.png"));
                btnConfirm.setBounds(new Rectangle(30,375,115,35));
                btnConfirm.setBackground(null);
                btnConfirm.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                btnCancel  = new JButton(new ImageIcon("./src/image/btnCancel_25px.png"));
                btnCancel.setBounds(new Rectangle(190,375,116,35));
                btnCancel.setBackground(null);
                btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                lbSearch = new JLabel("Tìm kiếm");
                lbSearch.setBounds(new Rectangle(350, 15,80, 30));
                lbSearch.setFont(font1);

                txtSearch = new JTextField("Nhập mã khách hàng");
                txtSearch.setBounds(new Rectangle(420, 15,200, 30));
                txtSearch.setFont(fontSeacrh);

                lbIconSearch = new JLabel(new ImageIcon("./src/image/search_26px.png"));
                lbIconSearch.setBounds(new Rectangle(620, 15, 50,30));
                lbIconSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                Vector header = new Vector();
                header.add("Mã KH");
                header.add("Họ");
                header.add("Tên");
                header.add("Địa chỉ");
                header.add("SĐT");
                header.add("Email");
                model = new DefaultTableModel(header,0);
                
                table = new JTable(model);
                table.getTableHeader().setFont(font0);
                table.getTableHeader().setOpaque(false);
                table.getTableHeader().setBackground(new Color(232,57,99));
                table.getTableHeader().setForeground(new Color(255,255,225));
                //table.setShowVerticalLines(false);   
                table.setSelectionBackground(new Color(32,136,203));
                table.setRowHeight(22);
                table.setShowVerticalLines(false);
                table.setFont(font1);
                table.getColumnModel().getColumn(3).setPreferredWidth(200);
                scroll = new JScrollPane(table);
                scroll.setBounds(new Rectangle(350, 60,600, 350));
                scroll.setBackground(null);
                scroll.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                
                outModel(model, khBUS.getDskh());
                
                table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e)
                {

                    int i = table.getSelectedRow();
                    //System.out.println(i);
                    if(table.getRowSorter() != null)
                    {
                        i = table.getRowSorter().convertRowIndexToModel(i);
                    }
                    txtMakh.setText(table.getModel().getValueAt(i, 0).toString());
                    txtHokh.setText(table.getModel().getValueAt(i, 1).toString());
                    txtTenkh.setText(table.getModel().getValueAt(i, 2).toString());
                    txtDiachi.setText(table.getModel().getValueAt(i, 3).toString());
                    txtSDT.setText(table.getModel().getValueAt(i, 4).toString());
                    txtEmail.setText(table.getModel().getValueAt(i, 5).toString());
                }
                });
                
                 txtSearch.addKeyListener(new KeyAdapter() {
                     public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {   
                        String makh = txtSearch.getText();
                        Search(makh);
                    }
                }
                });
                  txtSearch.addMouseListener(new MouseAdapter() {
                     public void mousePressed(MouseEvent e)
                    {
                    txtSearch.setText("");
                    }
                });
                lbIconSearch.addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e)
                    {
                        String makh = txtSearch.getText();
                        Search(makh);
                    }
                });
                
                txtSearch.getDocument().addDocumentListener(new DocumentListener(){
                @Override
                public void insertUpdate(DocumentEvent e) {

                }

                @Override
                public void removeUpdate(DocumentEvent e) { //setModel ban đầu khi txtSearch == null
                    String text = txtSearch.getText();

                    if (text.equals("")) {
                        outModel(model, khBUS.getDskh());
                    } 

                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                });
                btnConfirm.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
                });
                btnCancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {   
                    txtMakh.setText("");
                    setVisible(false);
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
                });

            pChonKH.add(lbThongtin);    
            pChonKH.add(lbMakh);
            pChonKH.add(txtMakh);
            pChonKH.add(lbHokh);
            pChonKH.add(txtHokh);
            pChonKH.add(lbTenkh);
            pChonKH.add(txtTenkh);
            pChonKH.add(lbDiachi);
            pChonKH.add(txtDiachi);
            pChonKH.add(lbSDT);
            pChonKH.add(txtSDT);
            pChonKH.add(lbEmail);
            pChonKH.add(txtEmail);
            pChonKH.add(btnConfirm);
            pChonKH.add(btnCancel);
            pChonKH.add(lbSearch);
            pChonKH.add(txtSearch);
            pChonKH.add(lbIconSearch);
            pChonKH.add(scroll);
            
            
        add(pChonKH);
        setLocationRelativeTo(null);
        setVisible(true);
                
    }
    public void outModel(DefaultTableModel model , ArrayList<KhachHangDTO> dskh) // Xuất ra Table từ ArrayList
    { 
       Vector data;
       model.setRowCount(0);
        for(KhachHangDTO kh: dskh)
        {
            data = new Vector();
            data.add(kh.getMakh());
            data.add(kh.getHokh());
            data.add(kh.getTenkh());
            data.add(kh.getDiachi());
            data.add(kh.getSdt());
            data.add(kh.getEmail());
            model.addRow(data);
        }
        table.setModel(model);
    }
    public void Search(String makh)
    {
      
        ArrayList<KhachHangDTO> search = new ArrayList<>(); //Tạo Arraylist add Object select để load model
        KhachHangDTO kh = khBUS.Search(makh);
        if(kh!= null)
        {
            search.add(kh);
            outModel(model, search); //Table filter ra Object Select những ko ảnh hưởng tới dssp ban đầu
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Không có khách hàng "+txtSearch.getText()+" trong danh sách");
            txtSearch.setText("");
        }
    }
    public String getData()
    {
        return txtMakh.getText();
    }
}
