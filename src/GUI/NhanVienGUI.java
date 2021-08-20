/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.LoaiSpBUS;
import BUS.NhaCungCapBUS;
import BUS.NhanVienBUS;
import BUS.SanPhamBUS;
import DTO.LoaiSpDTO;
import DTO.NhaCungCapDTO;
import DTO.NhanVienDTO;
import DTO.SanPhamDTO;
import java.awt.Color;
import java.awt.Component;
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
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ntloc
 */
public class NhanVienGUI extends JPanel implements ActionListener{
    
    private int DEFAULT_WIDTH;
    private int DEFAULT_HEIGH;
    private JPanel pMenu_Info, pMenu_SP;
    private JTable table;
    private JButton btnAdd, btnDelete, btnFix, btnReset;
    private JLabel lbImage, lbManv, lbHonv,lbTennv,  lbGioitinh,lbDiachi, lbNamsinh, lbSdt, lbSearch, iconSearch; 
    private JTextField txtManv, txtHonv, txtTennv, txtGioitinh,txtDiachi, txtNamsinh, txtSdt,txtSearch;
    private String imgName = "null";
    private DefaultTableModel model;
   
    private JButton btnSearch;
    private NhanVienBUS nvBUS = new NhanVienBUS();
    public NhanVienGUI(){}
    
    public NhanVienGUI(int WIDTH, int HEIGH)
    {
        
        DEFAULT_WIDTH = WIDTH;
        DEFAULT_HEIGH = HEIGH;
        Init();
      
    }
    public void Init()
    { 
        Font fontSeacrh = new Font("Segoe UI",Font.ITALIC,12);
        Font font0 = new Font("Segoe UI",Font.BOLD,13);
        Font font1 = new Font("Segoe UI",Font.PLAIN,13);
        setLayout(null);

        setBounds(new Rectangle(0,0, this.DEFAULT_WIDTH - 230, this.DEFAULT_HEIGH)); //QLST
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBackground(Color.WHITE);
        
            //Panel_Item
            pMenu_Info = new JPanel(null);
            pMenu_Info.setBounds(new Rectangle(100,10, 850, 260));
            pMenu_Info.setBackground(Color.WHITE);

                lbImage = new JLabel("IMG",JLabel.CENTER);
                lbImage.setBounds(new Rectangle(0, 20, 200, 230));
                lbImage.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                
                lbManv = new JLabel("Mã nhân viên");
                lbManv.setBounds(new Rectangle(300, 20, 100, 30));
                lbManv.setFont(font0);
                txtManv = new JTextField("");
                txtManv.setBounds(new Rectangle(400, 20, 200, 30));
                txtManv.setFont(font1);
                txtManv.setEnabled(false);
                
                lbHonv = new JLabel("Họ");
                lbHonv.setBounds(new Rectangle(300, 60, 100, 30));
                lbHonv.setFont(font0);
                txtHonv = new JTextField("");
                txtHonv.setBounds(new Rectangle(400, 60, 200, 30));
                txtHonv.setFont(font1);
                txtHonv.setEnabled(false);
                
                lbTennv = new JLabel("Tên");
                lbTennv.setBounds(new Rectangle(300, 100, 100, 30));
                lbTennv.setFont(font0);
                txtTennv = new JTextField("");
                txtTennv.setBounds(new Rectangle(400, 100, 200, 30));
                txtTennv.setFont(font1);
                txtTennv.setEnabled(false);
                
                lbDiachi = new JLabel("Địa chỉ");
                lbDiachi.setBounds(new Rectangle(300, 140, 100, 30));
                lbDiachi.setFont(font0);
                txtDiachi = new JTextField("");
                txtDiachi.setBounds(new Rectangle(400, 140, 200, 30));
                txtDiachi.setFont(font1);
                txtDiachi.setEnabled(false);
                
                lbSdt = new JLabel("SĐT");
                lbSdt.setBounds(new Rectangle(300, 180, 100, 30));
                lbSdt.setFont(font0);
                txtSdt = new JTextField("");
                txtSdt.setBounds(new Rectangle(400, 180, 200, 30));
                txtSdt.setFont(font1);
                txtSdt.setEnabled(false);
                
                lbGioitinh = new JLabel("Giới tính");
                lbGioitinh.setBounds(new Rectangle(260, 220, 100, 30));
                lbGioitinh.setFont(font0);
                txtGioitinh = new JTextField("");
                txtGioitinh.setBounds(new Rectangle(330, 220,100, 30));
                txtGioitinh.setFont(font1);
                txtGioitinh.setEnabled(false);
                
                
                lbNamsinh = new JLabel("Năm sinh");
                lbNamsinh.setBounds(new Rectangle(435, 220, 100, 30));
                lbNamsinh.setFont(font0);
                txtNamsinh = new JTextField("");
                txtNamsinh.setBounds(new Rectangle(500, 220,100, 30));
                txtNamsinh.setFont(font1);
                txtNamsinh.setEnabled(false);

                btnAdd = new JButton(new ImageIcon("./src/image/btnAdd.png"));
                btnAdd.setBounds(new Rectangle(730, 20,115,34));
                btnAdd.setBackground(null);
                btnAdd.addActionListener(this); //Lắng nghe return của JDialog
                btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));

                
                btnDelete = new JButton(new ImageIcon("./src/image/btnDelete.png"));
                btnDelete.setBounds(new Rectangle(730,70, 114,34));
                btnDelete.setBackground(null);
                btnDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                btnFix = new JButton(new ImageIcon("./src/image/btnFix.png"));
                btnFix.setBounds(new Rectangle(730,120, 114,34));
                btnFix.setBackground(null);
                btnFix.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                btnReset = new JButton(new ImageIcon("./src/image/btnReset.png"));
                btnReset.setBounds(new Rectangle(730,170, 114,34));
                btnReset.setBackground(null);
                btnReset.setCursor(new Cursor(Cursor.HAND_CURSOR));
               
                
            pMenu_Info.add(lbImage);  
            pMenu_Info.add(lbManv);
            pMenu_Info.add(txtManv);
            pMenu_Info.add(lbHonv);
            pMenu_Info.add(txtHonv);
            pMenu_Info.add(lbTennv);
            pMenu_Info.add(txtTennv);
            pMenu_Info.add(lbDiachi);
            pMenu_Info.add(txtDiachi);
            pMenu_Info.add(lbSdt);
            pMenu_Info.add(txtSdt);
            pMenu_Info.add(lbGioitinh);
            pMenu_Info.add(txtGioitinh);
            pMenu_Info.add(lbNamsinh);
            pMenu_Info.add(txtNamsinh);
            pMenu_Info.add((btnAdd));
            pMenu_Info.add(btnAdd);
            pMenu_Info.add(btnDelete);
            pMenu_Info.add(btnFix);
            pMenu_Info.add(btnReset);
            
            
           
            
            btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table.clearSelection();
                ThemNhanVienGUI themNV = new ThemNhanVienGUI();
                if(e.getSource() == btnAdd) //Return kết quả trả về từ Jdialog
                {  
                    DanhSachNhanvien();
                }
                
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            });
            btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String manv = txtManv.getText();
                if(manv.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Vui lòng chọn nhân viên cần xóa");
                    return;
                }
                else
                {
                    int  option = JOptionPane.showConfirmDialog(null,"Xác nhận xóa" ,"Xóa nhân viên",JOptionPane.YES_NO_OPTION);
                    if(option == 0)
                    {
                        nvBUS.Delete(manv);
                        table.clearSelection();
                        DanhSachNhanvien();
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
            
            btnFix.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(txtManv.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Vui lòng chọn nhân viên cần sửa");
                    return;
                }
                else
                {
                    String manv = txtManv.getText();
                    String honv = txtHonv.getText();
                    String tennv = txtTennv.getText();
                    String diachi = txtDiachi.getText();
                    String sdt = txtSdt.getText();
                    String gioitinh = txtGioitinh.getText();
                    int namsinh = Integer.parseInt(txtNamsinh.getText());
                    String image = imgName;
                    UpdateNhanVienGUI update = new UpdateNhanVienGUI(manv, honv, tennv, diachi, sdt, gioitinh, namsinh, image);
                    if(e.getSource() == btnFix)
                    {
                         DanhSachNhanvien();
                         Clean();
                    }
                }
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            });
            
            btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Clean();
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            });
            
           
            pMenu_SP = new JPanel(null);
            pMenu_SP.setBounds(new Rectangle(0, 280, 1070, 420));
            pMenu_SP.setBackground(null);
            pMenu_SP.setBorder(BorderFactory.createMatteBorder(0,1,1,1, Color.BLACK));
                lbSearch = new JLabel("Tìm kiếm:");
                lbSearch.setBounds(new Rectangle(100, 20, 200, 30));
                lbSearch.setFont(font0);
                txtSearch = new JTextField("Nhập mã nhân viên");
                txtSearch.setBounds(new Rectangle(170, 20,150, 30));
                txtSearch.setFont(fontSeacrh);
                
                btnSearch = new JButton(new ImageIcon("./src/image/search_26px.png"));
                btnSearch.setBounds(new Rectangle(330, 20,35,30));
                btnSearch.setBackground(null);
                btnSearch.setBorderPainted(false);
                btnSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
                

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
                    String masp = txtSearch.getText();
                    Search(masp);
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
    

//                lbSearch = new JLabel("Tìm kiếm:");
//                lbSearch.setBounds(new Rectangle(0, 20, 200, 30));
//                lbSearch.setFont(font0);
//                txtSearch = new JTextField("");
//                txtSearch.setBounds(new Rectangle(70, 20,130, 30));
//                txtSearch.setFont(font1);
//                iconSearch = new JLabel(new ImageIcon("./src/image/search_26px.png"));
//                iconSearch.setBounds(new Rectangle(205, 20,50,30));
//                iconSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));

                Vector header = new Vector();
                header.add("Mã NV");
                header.add("Họ");
                header.add("Tên");
                header.add("Địa chỉ");
                header.add("SĐT");
                header.add("Giới tính");
                header.add("Năm sinh");
                header.add("IMG");
                model = new DefaultTableModel(header,0);
                
                table = new JTable(model);
                table.getTableHeader().setFont(font0);
                table.getTableHeader().setOpaque(false);
                table.getTableHeader().setBackground(new Color(232,57,99));
                table.getTableHeader().setForeground(new Color(255,255,225));
                //table.setShowVerticalLines(false);   
                table.setSelectionBackground(new Color(32,136,203));
                table.setRowHeight(25);
                table.setFont(font1);
                table.setShowVerticalLines(false);
                table.getColumnModel().getColumn(0).setPreferredWidth(50);
                table.getColumnModel().getColumn(1).setPreferredWidth(50);
                table.getColumnModel().getColumn(2).setPreferredWidth(100);
                table.getColumnModel().getColumn(3).setPreferredWidth(200);
                JScrollPane scroll = new JScrollPane(table);
                scroll.setBounds(new Rectangle(100, 70, 850, 340));
                scroll.setBackground(null);
                scroll.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                DanhSachNhanvien();
                
                txtSearch.getDocument().addDocumentListener(new DocumentListener(){
                @Override
                public void insertUpdate(DocumentEvent e) {

                }

                @Override
                public void removeUpdate(DocumentEvent e) { //setModel ban đầu khi txtSearch == null
                    String text = txtSearch.getText();

                    if (text.equals("")) {
                        outModel(model, nvBUS.getDsnv());      
                    } 

                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

            });
            pMenu_SP.add(lbSearch);
            pMenu_SP.add(txtSearch);
            pMenu_SP.add(btnSearch);
            pMenu_SP.add(scroll);
            
        add(pMenu_Info);
        add(pMenu_SP);
        
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e)
            {
                int i = table.getSelectedRow();
                //System.out.println(i);
                if(table.getRowSorter() != null)
                {
                    i = table.getRowSorter().convertRowIndexToModel(i);
                }
                txtManv.setText(table.getModel().getValueAt(i, 0).toString());
                txtHonv.setText(table.getModel().getValueAt(i, 1).toString());
                txtTennv.setText(table.getModel().getValueAt(i, 2).toString());
                txtDiachi.setText(table.getModel().getValueAt(i, 3).toString());
                txtSdt.setText(table.getModel().getValueAt(i, 4).toString());              
                txtGioitinh.setText(table.getModel().getValueAt(i, 5).toString());
                txtNamsinh.setText(table.getModel().getValueAt(i, 6).toString());
                
                imgName =  table.getModel().getValueAt(i, 7).toString();
                Image newImage = new ImageIcon("./src/image/NhanVien/"+imgName).getImage().getScaledInstance(200, 230, Image.SCALE_DEFAULT);
                lbImage.setIcon(new ImageIcon(newImage));
                
                
            }
        });
    }
    public int getData()
    {
        int i = table.getSelectedRow();

        return i;
    }
    public void outModel(DefaultTableModel model , ArrayList<NhanVienDTO> dsnv) // Xuất ra Table từ ArrayList
    { 
       Vector data;
       model.setRowCount(0);
//       DecimalFormat formatter = new DecimalFormat("###,###,###.##");
        for(NhanVienDTO s: dsnv)
        {
            data = new Vector();
            data.add(s.getManv());
            data.add(s.getHonv());
            data.add(s.getTennv());
            data.add(s.getDiachi());
            data.add(s.getSdt());
            data.add(s.getGioitinh());
            data.add(s.getNamsinh());
            data.add(s.getImage());
            model.addRow(data);
        }
        table.setModel(model);
    }
    public void DanhSachNhanvien() //Load DanhSachSanPham lên table
    {
        
            nvBUS.DanhSachNhanVien();
            ArrayList<NhanVienDTO> dsnv = nvBUS.getDsnv(); //get Data 
            model.setRowCount(0);
            outModel(model, dsnv);  
          
    }
    public void Search(String manv)
    {
        ArrayList<NhanVienDTO> search = new ArrayList<>(); //Tạo Arraylist add Object select để load model
        NhanVienDTO nv = nvBUS.Search(manv);
        if(nv != null)
        {
            search.add(nv);
            outModel(model, search); //Table filter ra Object Select những ko ảnh hưởng tới dssp ban đầu
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Không có nhân viên "+txtSearch.getText()+" trong danh sách");
            txtSearch.setText("");
        }
       
    }
    public void Clean()
    {
        txtManv.setText("");
        txtHonv.setText("");
        txtTennv.setText("");
        txtDiachi.setText("");
        txtSdt.setText("");
        txtGioitinh.setText("");
        txtNamsinh.setText("");
        lbImage.setText("IMG");
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
       
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
