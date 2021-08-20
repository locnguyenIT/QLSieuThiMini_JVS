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
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ntloc
 */
public class KhachHangGUI extends JPanel implements ActionListener{
    private int DEFAULT_WIDTH;
    private int DEFAULT_HEIGH;
    private JPanel pInfo;
    private JLabel lbMakh, lbHokh, lbTenkh, lbDiachi, lbSdt, lbEmail, lbSearch;
    private JTextField txtMakh, txtHokh, txtTenkh, txtDiachi,txtEmail, txtSearch,txtSdt;
    private JButton btnAdd, btnDelete, btnFix, btnReset,btnSearch ,btnLuu,btnCancel;
    private DefaultTableModel model;
    private JTable table;
    private KhachHangBUS khBUS = new KhachHangBUS();
    public KhachHangGUI(){}
    
    public KhachHangGUI(int WIDTH, int HEIGH)
    {
        
        DEFAULT_WIDTH = WIDTH;
        DEFAULT_HEIGH = HEIGH;
        Init();
    }
    public void Init()
    {
        Font fontSeacrh = new Font("Segoe UI",Font.ITALIC,12);
        Font fontB = new Font("Segoe UI",Font.BOLD,13);
        Font fontP = new Font("Segoe UI",Font.PLAIN,13);
        setLayout(null);
        setBounds(new Rectangle(0,0, this.DEFAULT_WIDTH - 230, this.DEFAULT_HEIGH)); //QLST
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBackground(Color.WHITE);
            pInfo = new JPanel(null);
            pInfo.setBounds(new Rectangle(50,10,900,230));
            pInfo.setBackground(Color.WHITE);
                lbMakh = new JLabel("Mã KH");
                lbMakh.setBounds(new Rectangle(50,30,50,30));
                lbMakh.setFont(fontB);
                txtMakh = new JTextField("");
                txtMakh.setBounds(new Rectangle(110,30,200,30));
                txtMakh.setFont(fontP);
                txtMakh.setEnabled(false);
                
                lbSdt = new JLabel("SĐT");
                lbSdt.setBounds(new Rectangle(350,30,50,30));
                lbSdt.setFont(fontB);
                txtSdt = new JTextField("");
                txtSdt.setBounds(new Rectangle(410,30,200,30));
                txtSdt.setFont(fontP);
                txtSdt.setEnabled(false);
                
                lbHokh = new JLabel("Họ");
                lbHokh.setBounds(new Rectangle(50,80,50,30));
                lbHokh.setFont(fontB);
                txtHokh = new JTextField("");
                txtHokh.setBounds(new Rectangle(110,80,200,30));
                txtHokh.setFont(fontP);
                txtHokh.setEnabled(false);
                
                lbTenkh = new JLabel("Tên");
                lbTenkh.setBounds(new Rectangle(350,80,50,30));
                lbTenkh.setFont(fontB);
                txtTenkh = new JTextField("");
                txtTenkh.setBounds(new Rectangle(410,80,200,30));
                txtTenkh.setFont(fontP);
                txtTenkh.setEnabled(false);
                
                lbDiachi = new JLabel("Địa chỉ");
                lbDiachi.setBounds(new Rectangle(50,130,50,30));
                lbDiachi.setFont(fontB);
                txtDiachi = new JTextField("");
                txtDiachi.setBounds(new Rectangle(110,130,500,30));
                txtDiachi.setFont(fontP);
                txtDiachi.setEnabled(false);
                
                lbEmail = new JLabel("Email");
                lbEmail.setBounds(new Rectangle(50,180,50,30));
                lbEmail.setFont(fontB);
                txtEmail = new JTextField("");
                txtEmail.setBounds(new Rectangle(110,180,500,30));
                txtEmail.setFont(fontP);
                txtEmail.setEnabled(false);
                
                btnAdd = new JButton(new ImageIcon("./src/image/btnAdd.png"));
                btnAdd.setBounds(new Rectangle(750, 30,115,34));
                btnAdd.setBackground(null);
                btnAdd.addActionListener(this); //Lắng nghe return của JDialog
                btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));

                
                btnDelete = new JButton(new ImageIcon("./src/image/btnDelete.png"));
                btnDelete.setBounds(new Rectangle(750,80, 114,34));
                btnDelete.setBackground(null);
                btnDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                btnFix = new JButton(new ImageIcon("./src/image/btnFix.png"));
                btnFix.setBounds(new Rectangle(750,130, 114,34));
                btnFix.setBackground(null);
                btnFix.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                btnReset = new JButton(new ImageIcon("./src/image/btnReset.png"));
                btnReset.setBounds(new Rectangle(750,180, 114,34));
                btnReset.setBackground(null);
                btnReset.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                btnLuu = new JButton(new ImageIcon("./src/image/btnSave_30px.png"));
                btnLuu.setBounds(new Rectangle(750, 30, 115,35));
                btnLuu.setBackground(null);
                btnLuu.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btnLuu.setVisible(false);
                
                btnCancel = new JButton(new ImageIcon("./src/image/btnCancel_30px.png"));
                btnCancel.setBounds(new Rectangle(750,80, 116,35));
                btnCancel.setBackground(null);
                btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btnCancel.setVisible(false);
                
            pInfo.add(lbMakh);
            pInfo.add(txtMakh);
            pInfo.add(lbSdt);
            pInfo.add(txtSdt);
            pInfo.add(lbHokh);
            pInfo.add(txtHokh);
            pInfo.add(lbTenkh);
            pInfo.add(txtTenkh);
            pInfo.add(lbDiachi);
            pInfo.add(txtDiachi);
            pInfo.add(lbEmail);
            pInfo.add(txtEmail);
            pInfo.add(btnAdd);
            pInfo.add(btnDelete);
            pInfo.add(btnFix);
            pInfo.add(btnReset);
            pInfo.add(btnLuu);
            pInfo.add(btnCancel);
            
                lbSearch = new JLabel("Tìm kiếm");
                lbSearch.setBounds(new Rectangle(100,270,80,30));
                lbSearch.setFont(fontB);
                txtSearch = new JTextField("Tìm Mã khách hàng");
                txtSearch.setBounds(new Rectangle(190,270,150,30));
                txtSearch.setFont(fontSeacrh);
            
                btnSearch = new JButton(new ImageIcon("./src/image/search_26px.png"));
                btnSearch.setBounds(new Rectangle(350, 270,35,30));
                btnSearch.setBackground(null);
                btnSearch.setBorderPainted(false);
                btnSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                Vector header = new Vector();
                header.add("Mã KH");
                header.add("Họ");
                header.add("Tên");
                header.add("Địa chỉ");
                header.add("SĐT");
                header.add("Email");
               
                model = new DefaultTableModel(header,0);
                
                table = new JTable(model);
                table.getTableHeader().setFont(fontB);
                table.getTableHeader().setOpaque(false);
                table.getTableHeader().setBackground(new Color(232,57,99));
                table.getTableHeader().setForeground(new Color(255,255,225));
                //table.setShowVerticalLines(false);   
                table.setSelectionBackground(new Color(32,136,203));
                table.setRowHeight(25);
                table.setFont(fontP);
                table.setShowVerticalLines(false);
                table.getColumnModel().getColumn(0).setPreferredWidth(50);
                table.getColumnModel().getColumn(1).setPreferredWidth(50);
                table.getColumnModel().getColumn(2).setPreferredWidth(100);
                table.getColumnModel().getColumn(3).setPreferredWidth(200);
                JScrollPane scroll = new JScrollPane(table);
                scroll.setBounds(new Rectangle(100,320,820, 340));
                scroll.setBackground(null);
                scroll.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(pInfo);
        add(scroll);
        add(lbSearch);
        add(txtSearch);
        add(btnSearch);
        DanhSachKhachHang();
        //--------------------------------Table listenner----------------//
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
                txtSdt.setText(table.getModel().getValueAt(i, 4).toString());              
                txtEmail.setText(table.getModel().getValueAt(i, 5).toString()); 
            }
        });
         
        //--------------------------Thêm KH--------------------------// 
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddKhachHang themKH = new AddKhachHang();
                DanhSachKhachHang();
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        //--------------------------Xóa KH--------------------------------//
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String manv = txtMakh.getText();
                if(manv.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Vui lòng chọn khách hàng cần xóa");
                    return;
                }
                else
                {
                    int  option = JOptionPane.showConfirmDialog(null,"Xác nhận xóa" ,"Xóa khách hàng",JOptionPane.YES_NO_OPTION);
                    if(option == 0)
                    {
                        khBUS.Delete(manv);
                        table.clearSelection();
                        DanhSachKhachHang();
                        Clean();
                    }
                    else
                    {
                        Clean();
                        return;
                    }
                 }
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            });
        //--------------------------SỬA KH------------------------------------//
            btnFix.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(txtMakh.getText().equals(""))
                    {
                        JOptionPane.showMessageDialog(null,"Vui lòng chọn khách hàng cần sửa");
                        return;
                    }
                    else
                    {
                        btnAdd.setVisible(false);
                        btnDelete.setVisible(false);
                        btnFix.setVisible(false);
                        btnReset.setVisible(false);
                        btnLuu.setVisible(true);
                        btnCancel.setVisible(true);
                        Enable();
                    }
                       
                       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
            
            btnLuu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Enable();
                String makh = txtMakh.getText();
                String hokh = txtHokh.getText();
                String tenkh = txtTenkh.getText();
                String diachi = txtDiachi.getText();
                String sdt = txtSdt.getText();
                String email = txtEmail.getText();
                
                KhachHangDTO kh = new KhachHangDTO(makh, hokh, tenkh, diachi, sdt, email);
                khBUS.Set(kh);
                JOptionPane.showMessageDialog(null,"Sửa thành công !!!");
                btnAdd.setVisible(true);
                btnDelete.setVisible(true);
                btnFix.setVisible(true);
                btnReset.setVisible(true);
                btnLuu.setVisible(false);
                btnCancel.setVisible(false);
                Clean();
                Block();
                DanhSachKhachHang();
                
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            });
            btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnAdd.setVisible(true);
                btnDelete.setVisible(true);
                btnFix.setVisible(true);
                btnReset.setVisible(true);
                btnLuu.setVisible(false);
                btnCancel.setVisible(false);
                Clean();
                Block();
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            });
        //-------------------------RESET----------------------------------------//
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Clean();
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        //--------------------------Search------------------------------------//
         txtSearch.addMouseListener((new MouseAdapter() {
                public void mousePressed(MouseEvent e)
                {
                    txtSearch.setText("");
                }
                }));
                
                btnSearch.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //String tensp =txtSearch.getText();
                    String makh = txtSearch.getText();
                    Search(makh);
                        //SearchTen(tensp);
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
                });
                txtSearch.addKeyListener(new KeyAdapter() {
                     public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//                        String tensp =txtSearch.getText();
//                        SearchTen(tensp);
                        String masp = txtSearch.getText();
                        Search(masp);
                    }
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
    
        
         
    }
    public void DanhSachKhachHang() //Load DanhSachSanPham lên table
    {
        khBUS.DanhSachKhachHang();
        ArrayList<KhachHangDTO> dskh = khBUS.getDskh(); //get Data 
        model.setRowCount(0);
        outModel(model, dskh);  
    }
      public void outModel(DefaultTableModel model , ArrayList<KhachHangDTO> dsnv) // Xuất ra Table từ ArrayList
    { 
       Vector data;
       model.setRowCount(0);
        for(KhachHangDTO s: dsnv)
        {
            data = new Vector();
            data.add(s.getMakh());
            data.add(s.getHokh());
            data.add(s.getTenkh());
            data.add(s.getDiachi());
            data.add(s.getSdt());
            data.add(s.getEmail());
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
    public void Clean()
    {
        txtMakh.setText("");
        txtHokh.setText("");
        txtTenkh.setText("");
        txtDiachi.setText("");
        txtSdt.setText("");
        txtEmail.setText("");
    }
    public void Enable()
    {
        txtHokh.setEnabled(true);
        txtTenkh.setEnabled(true);
        txtDiachi.setEnabled(true);
        txtSdt.setEnabled(true);
        txtEmail.setEnabled(true);
    }
    public void Block()
    {
        txtHokh.setEnabled(false);
        txtTenkh.setEnabled(false);
        txtDiachi.setEnabled(false);
        txtSdt.setEnabled(false);
        txtEmail.setEnabled(false);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
