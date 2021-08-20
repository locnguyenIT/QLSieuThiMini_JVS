/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.ChiTietHDBUS;
import BUS.HoaDonBUS;
import BUS.KhachHangBUS;
import BUS.NhanVienBUS;
import BUS.SanPhamBUS;
import DTO.ChiTietHDDTO;
import DTO.HoaDonDTO;
import DTO.KhachHangDTO;
import DTO.NhanVienDTO;
import DTO.SanPhamDTO;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ntloc
 */
public class BanHangGUI extends JPanel implements MouseListener{
    private int DEFAULT_WIDTH;
    private int DEFAULT_HEIGH;
    private JPanel pMenu_Hoadon;
    private JPanel pMenu_CTHD;
    private JPanel pThanhtoan, pCancel;
    private JLabel lbMahd,lbDate, lbIconNV, lbIconKH, lbTongtien, lbPTTT, lbKhachtra, lbTienthua, lbGhichu;
    private JLabel lbSearch, lbMaCTHD,iconSearch, lbMasp, lbTensp, lbDongia,lbSl, lbThanhtien, lbGiamgia,lbTienCTHD;
    private JTextField  txtSearch,txtMaCTHD,txtMasp, txtTensp, txtDongia,txtSl, txtThanhtien, txtGiamgia,txtTienCTHD, txtEditSl,txtEditGiamgia;
    private JButton btnDssp, btnXoaCTHD, btnThemCTHD,btnSuaCTHD, btnLuuCTHD;
    private JTable table;
    private JScrollPane scroll;
    private DefaultTableModel model;
    private JTextField txtMahd, txtKH, txtTongtien, txtKhachtra, txtTienthua;
    private JTextArea txtGhichu;
    private JButton btnAddKH,btnDskh;
    private JSeparator sep_hd, sep_cthd;
    private JComboBox cbbNV, cbbPTTT;
    private SanPhamBUS spBUS = new SanPhamBUS();
    private NhanVienBUS nvBUS = new NhanVienBUS();
    private KhachHangBUS khBUS = new KhachHangBUS();
    private ChiTietHDBUS cthdBUS = new ChiTietHDBUS();
    private HoaDonBUS hdBUS = new HoaDonBUS();
    private ArrayList<ChiTietHDDTO> dscthd = new ArrayList<>(); //Tạo Arraylist để lưu tạm CHTD trên table
    DecimalFormat formatter = new DecimalFormat("###,###,###.##");
    private boolean Flag = true; //Xét ThêmCTHD or SửaCTHD | Thêm Flag = true, Sửa Flag = false
    public BanHangGUI(int WIDTH, int HEIGH)
    {
        DEFAULT_WIDTH = WIDTH;
        DEFAULT_HEIGH = HEIGH;
        nvBUS.DanhSachNhanVien();
        khBUS.DanhSachKhachHang();
        spBUS.DanhSachSanPham();
        hdBUS.DanhSachHD();
             
        Init();
    }
     public void Init()
    {    
        Font font0 = new Font("Segoe UI",Font.BOLD,13);
        Font font1 = new Font("Segoe UI",Font.PLAIN,13);
        Font font2 = new Font("Segoe UI",Font.ITALIC,12);
        Font fontTT_Cancel = new Font("Segoe UI",Font.BOLD,14);
        setLayout(null);
        setBounds(new Rectangle(0,0,DEFAULT_WIDTH-230,700)); //QPSL
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBackground(Color.WHITE);
        

        pMenu_Hoadon = new JPanel(null);
        pMenu_Hoadon.setBounds(new Rectangle(790,0,280,700));
        pMenu_Hoadon.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        pMenu_Hoadon.setBackground(Color.WHITE);
        //----------------------Panel Hóa đơn-------------------------//
            lbMahd = new JLabel("Mã HD");
            lbMahd.setBounds(new Rectangle(20, 20, 50, 30));
            lbMahd.setFont(font1);
            txtMahd = new JTextField("");
            txtMahd.setBounds(new Rectangle(80, 20, 60, 30));
            txtMahd.setHorizontalAlignment(JTextField.CENTER);
            txtMahd.setFont(font1);
            txtMahd.setEnabled(false);
            txtMahd.setText(hdBUS.NextMaHD());
            
            lbDate = new JLabel("");
            lbDate.setBounds(new Rectangle(165, 20,200, 30));
            lbDate.setFont(font2);
            
            Date date = Timestamp.valueOf(LocalDateTime.now());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String formattedDate = sdf.format(date);
            lbDate.setText(formattedDate);
            
            
            
            lbIconNV = new JLabel(new ImageIcon("./src/image/user_25px.png"));
            lbIconNV.setBounds(new Rectangle(20, 70, 50, 30));
            lbIconNV.setHorizontalAlignment(JLabel.LEADING);
            //lbIconNV.setBackground(null);
            ArrayList<NhanVienDTO> dsnv = nvBUS.getDsnv();
            String[] items = new String[dsnv.size()];
            for(int i =0; i<items.length; i++)
            {
                items[i] = dsnv.get(i).getHonv()+" "+dsnv.get(i).getTennv();
            }
            cbbNV = new JComboBox(items);
            cbbNV.setBounds(60, 70, 160,30);
            cbbNV.setBackground(null);
            cbbNV.setFont(font1);
            
            lbIconKH = new JLabel(new ImageIcon("./src/image/customer_25px.png"));
            lbIconKH.setBounds(new Rectangle(20,120,  50, 30));
            lbIconKH.setHorizontalAlignment(JLabel.LEADING);
            txtKH = new JTextField(" ");
            txtKH.setBounds(new Rectangle(60, 120, 130, 30));
            txtKH.setBorder(BorderFactory.createMatteBorder(1,1,1,0,Color.BLACK));
            txtKH.setFont(font1);
            
            btnDskh = new JButton("...");
            btnDskh.setBounds(new Rectangle(190,120,30,30));
            btnDskh.setBorder(BorderFactory.createMatteBorder(1,0,1,1,Color.BLACK));
            btnDskh.setBackground(null);
            btnDskh.setCursor(new Cursor(Cursor.HAND_CURSOR));
            
            btnAddKH = new JButton(new ImageIcon("./src/image/plus_math_18px.png"));
            btnAddKH.setBounds(new Rectangle(230,120,30,30));
            btnAddKH.setBackground(null);
            btnAddKH.setCursor(new Cursor(Cursor.HAND_CURSOR));
            
            sep_hd = new JSeparator();
            sep_hd.setBounds(new Rectangle(20,160, 240, 10));
            
            lbTongtien = new JLabel("Tổng tiền (VND)");
            lbTongtien.setBounds(new Rectangle(20,180,100,30));
            lbTongtien.setFont(font1);
            txtTongtien = new JTextField("0");
            txtTongtien.setBounds(new Rectangle(150, 180, 110, 30));
            txtTongtien.setHorizontalAlignment(JTextField.CENTER);
            txtTongtien.setFont(font1);
            txtTongtien.setEnabled(false);
            
            lbPTTT = new JLabel("PT Thanh toán");
            lbPTTT.setBounds(new Rectangle(20,240,100,30));
            lbPTTT.setFont(font1);
            String[] pttt = {"---Chọn---","ATM","CASH"};
            cbbPTTT = new JComboBox(pttt);
            cbbPTTT.setBounds(new Rectangle(150, 240, 110, 30));
            cbbPTTT.setFont(font1);
            cbbPTTT.setBackground(null);
            
            lbKhachtra = new JLabel("Khách thanh toán");
            lbKhachtra.setBounds(new Rectangle(20, 300, 100, 30));
            lbKhachtra.setFont(font1);
            txtKhachtra = new JTextField("");
            txtKhachtra.setBounds(new Rectangle(150, 300, 110, 30));
            txtKhachtra.setFont(font1);
            
            lbTienthua = new JLabel("Tiền thừa trả khách");
            lbTienthua.setBounds(new Rectangle(20,360,120,30));
            lbTienthua.setFont(font1);
            txtTienthua = new JTextField("");
            txtTienthua.setBounds(new Rectangle(150, 360, 110, 30));
            txtTienthua.setFont(font1);
            txtTienthua.setEnabled(false);
            
            lbGhichu = new JLabel("Ghi chú");
            lbGhichu.setBounds(new Rectangle(20,410,100,30));
            lbGhichu.setFont(font1);
            txtGhichu = new JTextArea("");
            txtGhichu.setFont(font1);
            txtGhichu.setWrapStyleWord(true);
            txtGhichu.setLineWrap(true);
            JScrollPane scrollPane = new JScrollPane(txtGhichu);
            scrollPane.setBounds(new Rectangle(100,420,160,90));
            scrollPane.setBackground(null);
            scrollPane.setFont(font1);
            scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          

                    pThanhtoan = new JPanel(null);
                    pThanhtoan.setBounds(new Rectangle(20,630,100,50));
                    pThanhtoan.setBackground(new Color(179, 202, 226));
                    pThanhtoan.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    pThanhtoan.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    pThanhtoan.addMouseListener(this);
                        JLabel lbThanhtoan = new JLabel("Thanh toán",JLabel.CENTER);    
                        lbThanhtoan.setBounds(new Rectangle(0,0,100,50));
                        lbThanhtoan.setFont(fontTT_Cancel);
                    pThanhtoan.add(lbThanhtoan);
                    
                    pCancel = new JPanel(null);
                    pCancel.setBounds(new Rectangle(160,630,100,50));
                    pCancel.setBackground(new Color(255, 212, 181));
                    pCancel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    pCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    pCancel.addMouseListener(this);
                        JLabel lbCancel = new JLabel("Hủy bỏ",JLabel.CENTER);    
                        lbCancel.setBounds(new Rectangle(0,0,100,50));
                        lbCancel.setFont(fontTT_Cancel);
                    pCancel.add(lbCancel);
                      
        pMenu_Hoadon.add(lbDate);    
        pMenu_Hoadon.add(lbMahd);
        pMenu_Hoadon.add(txtMahd);
        pMenu_Hoadon.add(lbIconNV);
        pMenu_Hoadon.add(cbbNV);
        pMenu_Hoadon.add(lbIconKH);    
        pMenu_Hoadon.add(txtKH);
        pMenu_Hoadon.add(btnDskh);
        pMenu_Hoadon.add(btnAddKH);
        pMenu_Hoadon.add(sep_hd);
        pMenu_Hoadon.add(lbTongtien);
        pMenu_Hoadon.add(txtTongtien);
        pMenu_Hoadon.add(lbPTTT);
        pMenu_Hoadon.add(cbbPTTT);
        pMenu_Hoadon.add(lbKhachtra);
        pMenu_Hoadon.add(txtKhachtra);
        pMenu_Hoadon.add(lbTienthua);
        pMenu_Hoadon.add(txtTienthua);
        pMenu_Hoadon.add(lbGhichu);
        pMenu_Hoadon.add(scrollPane);
        pMenu_Hoadon.add(pThanhtoan);
        pMenu_Hoadon.add(pCancel);
        
        
        //-------------------------JPanel CTHD-----------------------------//
        pMenu_CTHD = new JPanel(null);
        pMenu_CTHD.setBounds(new Rectangle(0, 0, 780, 700));
        pMenu_CTHD.setBorder(BorderFactory.createMatteBorder(1,1,1,0,Color.BLACK));
        pMenu_CTHD.setBackground(Color.WHITE);

                lbSearch = new JLabel("Tìm kiếm:");
                lbSearch.setBounds(new Rectangle(20,20,80,30));
                lbSearch.setFont(font1);
                txtSearch = new JTextField("Nhập mã sản phẩm");
                txtSearch.setBounds(new Rectangle(90,20,200,30));
                txtSearch.setBorder(BorderFactory.createMatteBorder(1,1,1,0,Color.BLACK));
                txtSearch.setFont(font2);
                
                btnDssp = new JButton("...");
                btnDssp.setBounds(new Rectangle(290,20,30,30));
                btnDssp.setBorder(BorderFactory.createMatteBorder(1,0,1,1,Color.BLACK));
                btnDssp.setBackground(null);
                btnDssp.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                iconSearch = new JLabel(new ImageIcon("./src/image/search_26px.png"));
                iconSearch.setBounds(new Rectangle(340,20,30, 30));
                iconSearch.setBackground(null);
                iconSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                lbMaCTHD = new JLabel("Mã HD");
                lbMaCTHD.setBounds(new Rectangle(20,70,50,30));
                lbMaCTHD.setFont(font1);
                txtMaCTHD = new JTextField("");
                txtMaCTHD.setBounds(new Rectangle(80,70,50,30));
                txtMaCTHD.setHorizontalAlignment(JTextField.CENTER);
                txtMaCTHD.setFont(font1);
                txtMaCTHD.setEnabled(false);
                txtMaCTHD.setText(hdBUS.NextMaHD());
                
                lbMasp = new JLabel("Mã SP");
                lbMasp.setBounds(new Rectangle(20,120,50,30));
                lbMasp.setFont(font1);
                txtMasp = new JTextField("");
                txtMasp.setBounds(new Rectangle(80,120,50,30));
                txtMasp.setFont(font1);
                txtMasp.setEnabled(false);
                
                lbTensp = new JLabel("Tên SP");
                lbTensp.setBounds(new Rectangle(150,70,50,30));
                lbTensp.setFont(font1);
                txtTensp = new JTextField("");
                txtTensp.setBounds(new Rectangle(200,70,150,30));
                txtTensp.setFont(font1);
                txtTensp.setEnabled(false);
                
                lbDongia= new JLabel("Đơn giá");
                lbDongia.setBounds(new Rectangle(150,120,50,30));
                lbDongia.setFont(font1);
                txtDongia = new JTextField("");
                txtDongia.setBounds(new Rectangle(200,120,150,30));
                txtDongia.setFont(font1);
                txtDongia.setEnabled(false);
                
                
                lbSl = new JLabel("Số lượng");
                lbSl.setBounds(new Rectangle(370,70,50,30));
                lbSl.setFont(font1);
                txtSl = new JTextField("");
                txtSl.setBounds(new Rectangle(440,70,100,30));
                txtSl.setFont(font1);
                txtSl.setEnabled(false);
                
               
                
                lbThanhtien = new JLabel("Thành tiền");
                lbThanhtien.setBounds(new Rectangle(370,120,70,30));
                lbThanhtien.setFont(font1);
                txtThanhtien = new JTextField("");
                txtThanhtien.setBounds(new Rectangle(440,120,100,30));
                txtThanhtien.setFont(font1);
                txtThanhtien.setEnabled(false);
                
                lbGiamgia = new JLabel("Giảm giá");
                lbGiamgia.setBounds(new Rectangle(560,70,50,30));
                lbGiamgia.setFont(font1);
                txtGiamgia = new JTextField("");
                txtGiamgia.setBounds(new Rectangle(660,70,100,30));
                txtGiamgia.setFont(font1);
                txtGiamgia.setEnabled(false);
              
                
                lbTienCTHD = new JLabel("Tổng tiền CTHD");
                lbTienCTHD.setBounds(new Rectangle(560,120,100,30));
                lbTienCTHD.setFont(font1);
                txtTienCTHD = new JTextField("");
                txtTienCTHD.setBounds(new Rectangle(660,120,100,30));
                txtTienCTHD.setFont(font1);
                txtTienCTHD.setEnabled(false);
//                
                
                btnSuaCTHD = new JButton("Sửa CTHD");
                btnSuaCTHD.setBounds(new Rectangle(660,20,100,30));
                btnSuaCTHD.setFont(font1);
                btnSuaCTHD.setBackground(null);
                btnSuaCTHD.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                btnLuuCTHD = new JButton("Lưu CTHD");
                btnLuuCTHD.setBounds(new Rectangle(660,20,100,30));
                btnLuuCTHD.setFont(font1);
                btnLuuCTHD.setBackground(null);
                btnLuuCTHD.setVisible(false);
                btnLuuCTHD.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                btnThemCTHD = new JButton("Thêm CTHD");
                btnThemCTHD.setBounds(new Rectangle( 430,20,100,30));
                btnThemCTHD.setFont(font1);
                btnThemCTHD.setBackground(null);
                btnThemCTHD.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                btnXoaCTHD = new JButton("Xóa CTHD");
                btnXoaCTHD.setBounds(new Rectangle(545, 20, 100, 30));
                btnXoaCTHD.setFont(font1);
                btnXoaCTHD.setBackground(null);
                btnXoaCTHD.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                
                sep_cthd = new JSeparator();
                sep_cthd.setBounds(new Rectangle(20,160, 740, 10));
                

                
                Vector header = new Vector();
                header.add("Mã sản phẩm");
                header.add("Tên sản phẩm");
                header.add("Đơn giá");
                header.add("Số lượng");
                header.add("Thành tiền");
                header.add("Giảm giá (%)");
                header.add("Tổng tiền");
                model = new DefaultTableModel(header,0);
                table = new JTable(model);
                TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>(model);
                table.setRowSorter(rowSorter);
                table.setRowHeight(30);
                table.getTableHeader().setFont(font0);
                table.getTableHeader().setOpaque(false);
                table.getTableHeader().setBackground(new Color(232,57,99));
                table.getTableHeader().setForeground(new Color(255,255,225));
                //table.setShowVerticalLines(false);   
                table.setSelectionBackground(new Color(32,136,203));
                table.setRowHeight(25);
                table.setShowVerticalLines(false);
                table.setFont(font1);
                table.getColumnModel().getColumn(1).setPreferredWidth(150);
                table.getColumnModel().getColumn(0).setPreferredWidth(80);
                scroll = new JScrollPane(table);
                scroll.setBounds(new Rectangle(20,175,740,505));
                scroll.setBackground(null);
                scroll.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                
                
        pMenu_CTHD.add(lbSearch);
        pMenu_CTHD.add(txtSearch);
        pMenu_CTHD.add(btnDssp);
        pMenu_CTHD.add(btnThemCTHD);
        pMenu_CTHD.add(btnXoaCTHD);
        pMenu_CTHD.add(btnSuaCTHD);
        pMenu_CTHD.add(sep_cthd);
        pMenu_CTHD.add(scroll);
        pMenu_CTHD.add(iconSearch);
        pMenu_CTHD.add(lbMasp);
        pMenu_CTHD.add(txtMasp);
        pMenu_CTHD.add(txtMaCTHD);
        pMenu_CTHD.add(lbMaCTHD);
        pMenu_CTHD.add(lbTensp);
        pMenu_CTHD.add(txtTensp);
        pMenu_CTHD.add(lbDongia);
        pMenu_CTHD.add(txtDongia);
        pMenu_CTHD.add(lbSl);
        pMenu_CTHD.add(txtSl);
        pMenu_CTHD.add(lbThanhtien);
        pMenu_CTHD.add(txtThanhtien);
        pMenu_CTHD.add(lbGiamgia);
        pMenu_CTHD.add(txtGiamgia);
        pMenu_CTHD.add(lbTienCTHD);
        pMenu_CTHD.add(txtTienCTHD);
        pMenu_CTHD.add(btnLuuCTHD);
        
    add(pMenu_Hoadon);
    add(pMenu_CTHD);  
    
    //------------------------------------EVENT-----------------------------------------//
                
            
           //-------------------------EVENT JPANEL HÓA ĐƠN------------------//
                
                btnAddKH.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(e.getSource() == btnAddKH)
                    {  
                        AddKhachHang kh = new AddKhachHang();
                        String makh = kh.getData();
                        khBUS.DanhSachKhachHang();
                        if(!makh.equals(""))
                        {
                            txtKH.setText(khBUS.SearchTenkh(makh));
                        }
                        return;
                    }
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
                });
                
                //Chọn Khách hàng
                btnDskh.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(e.getSource() == btnDskh)
                    {
                        ChonKhachHang kh = new ChonKhachHang();
                        String makh = kh.getData();
                        if(!makh.equals(""))
                        {
                            txtKH.setText(khBUS.SearchTenkh(makh));
                        }
                        return;
                    }
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
                });
                
                //Tiền khách trả
                txtKhachtra.addKeyListener(new KeyAdapter() {
                     public void keyPressed(KeyEvent e)
                    {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            int tongtienhd = Integer.parseInt(txtTongtien.getText().replaceAll(",",""));
                            int khachtra = Integer.parseInt(txtKhachtra.getText());
                            txtTienthua.setText(String.valueOf(khachtra - tongtienhd));
                            
                    }
                    }
                });
                
                //Thanh toán
                pThanhtoan.addMouseListener(new MouseAdapter() {
                     public void mouseClicked(MouseEvent e) {
                         String mahd = txtMahd.getText();
                    String manv = nvBUS.SearchManv(cbbNV.getSelectedItem().toString());
                    String tennv = cbbNV.getSelectedItem().toString();
                    String makh = khBUS.SearchMakh(txtKH.getText());
                    String tenkh = txtKH.getText(); 
                    int tongtienhd = Integer.parseInt(txtTongtien.getText().replaceAll(",","")); //Xoa "," ra khỏi chuỗi
                    String pttt= cbbPTTT.getSelectedItem().toString();
                    String thoigian = lbDate.getText();
                    String ghichu = txtGhichu.getText();
                    
                    if(tenkh.equals("") || tongtienhd == 0 || pttt.equals("---Chọn---") || dscthd.isEmpty())
                    {
                        JOptionPane.showMessageDialog(null,"Chưa có dữ liệu !!!");
                        return;
                    }
                    else
                    {
                        HoaDonDTO hd = new HoaDonDTO(mahd, manv, tennv, makh, tenkh,tongtienhd,pttt ,thoigian,ghichu);
                        hdBUS.Add(hd);

                        for(ChiTietHDDTO cthd : dscthd)
                        {
                                cthdBUS.Add(cthd);
                                //System.out.println(cthd.getMahd());
                        }
                        JOptionPane.showMessageDialog(null,"Thanh toán hoàn tất !!!");
                        dscthd.clear();
                        model.getDataVector().removeAllElements(); //Xóa trằng table
                        model.fireTableDataChanged();
                        
                        hdBUS.DanhSachHD();
                        txtMahd.setText(hdBUS.NextMaHD());
                        txtMaCTHD.setText(hdBUS.NextMaHD());
                        Clean_HD();
                        Clean_CTHD();
                    }
                     }
                });

            
                //Hủy bỏ
                pCancel.addMouseListener(new MouseAdapter() {
                     public void mouseClicked(MouseEvent e) {
                          ArrayList<ChiTietHDDTO> cthd = getDscthd();
                    cthd.clear();
                    model.getDataVector().removeAllElements(); //Xóa trằng table
                    model.fireTableDataChanged();
                    Clean_CTHD();
                    Clean_HD();
                     }
                });
                
            //-------------------------EVENT JPANEL CTHD------------------//
            
                //Table
                table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e)
                {

                    int i = table.getSelectedRow();
                    //System.out.println(i);
                    if(table.getRowSorter() != null)
                    {
                        i = table.getRowSorter().convertRowIndexToModel(i);
                    }
                    txtMasp.setText(table.getModel().getValueAt(i, 0).toString());
                    txtTensp.setText(table.getModel().getValueAt(i, 1).toString());
                    txtDongia.setText(table.getModel().getValueAt(i, 2).toString());
                    txtSl.setText(table.getModel().getValueAt(i, 3).toString());
                    txtThanhtien.setText(table.getModel().getValueAt(i, 4).toString());
                    txtGiamgia.setText(table.getModel().getValueAt(i, 5).toString());
                    txtTienCTHD.setText(table.getModel().getValueAt(i, 6).toString());

                    }
                });
                
                //SetTxtSearch
                txtSearch.addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e)
                    {
                        txtSearch.setText("");
                    }
                });
                //Click icon Search
                iconSearch.addMouseListener(new MouseAdapter() {
                     public void mousePressed(MouseEvent e)
                    {
                        String masp = txtSearch.getText();
                        Search(masp);
                    }
                });
                
                //Enter txtSearch
                txtSearch.addKeyListener(new KeyAdapter() {
                    public void keyPressed(KeyEvent e)
                    {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            
                            String masp = txtSearch.getText();
                            Search(masp);
                            
                        
                    }
                    }
                });
                
                //Chọn sản phẩm
                btnDssp.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {             
                    if(e.getSource() == btnDssp)
                    {
                        Flag = true; //Thêm CTHD
                        ChonSanPham chon = new ChonSanPham();
                        ArrayList<String> vector = chon.getDulieu();
                        if(!vector.isEmpty())//Kiểm tra 2 Button nhấn bên JDialog Sản phẩm xem có Array lưu Vector
                        {
                            txtSearch.setText(vector.get(0));
                            txtSearch.requestFocus();
                        }
                        else
                        {
                            return;  
                        }
                    }
                    
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
                });
                
                //Chọn SL
                txtSl.addKeyListener(new KeyAdapter() {
                    public void keyPressed(KeyEvent e)
                    {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) 
                        {
                            if(Flag == true) //Thêm CTHD
                            {
                               int dongia = Integer.parseInt(txtDongia.getText().replaceAll(",",""));
                               int sl = Integer.parseInt(txtSl.getText());
                               txtThanhtien.setText(String.valueOf(formatter.format(dongia * sl)));
                               txtGiamgia.requestFocus();
                            }
                            else    //Sửa CTHD
                            {
                               int dongia = Integer.parseInt(txtDongia.getText().replaceAll(",",""));
                               int sl = Integer.parseInt(txtSl.getText());
                               txtThanhtien.setText(String.valueOf(formatter.format(dongia * sl)));
                               int thanhtien = Integer.parseInt(txtThanhtien.getText().replaceAll(",",""));
                               int giamgia = Integer.parseInt(txtGiamgia.getText());
                               int tongtiencthd = thanhtien-(thanhtien*giamgia)/100;
                               txtTienCTHD.setText(String.valueOf(formatter.format(tongtiencthd)));
                            }
                          
                        }
                    }
                });
                
                //Chọn Giảm giá
                txtGiamgia.addKeyListener(new KeyAdapter() {
                    public void keyPressed(KeyEvent e)
                    {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) 
                        {
                           if(Flag == true) //Thêm CTHD
                           {
                               int thanhtien = Integer.parseInt(txtThanhtien.getText().replaceAll(",",""));
                               int giamgia = Integer.parseInt(txtGiamgia.getText());
                               int tongtiencthd = thanhtien-(thanhtien*giamgia)/100;
                               txtTienCTHD.setText(String.valueOf(formatter.format(tongtiencthd)));
                           }
                           else     //Sửa CTHD
                           {
                                int thanhtien = Integer.parseInt(txtThanhtien.getText().replaceAll(",",""));
                                int giamgia = Integer.parseInt(txtGiamgia.getText());
                                int tongtiencthd = thanhtien-(thanhtien*giamgia)/100;
                                txtTienCTHD.setText(String.valueOf(formatter.format(tongtiencthd)));
                           }
                          
                        }
                    }
                });
                
                //Thêm CTHD
                btnThemCTHD.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(txtMasp.getText().isEmpty())
                    {
                        JOptionPane.showMessageDialog(null,"Chưa chọn sản phẩm");
                        return;
                    }
                    String mahd = txtMaCTHD.getText();
                    String masp = txtMasp.getText();
                    String tensp = txtTensp.getText();
                    int dongia = Integer.parseInt(txtDongia.getText().replaceAll(",","")); //Xoa "," ra khỏi chuỗi
                    int sl = Integer.parseInt(txtSl.getText());
                    int thanhtien = Integer.parseInt(txtThanhtien.getText().replaceAll(",",""));
                    int giamgia = Integer.parseInt(txtGiamgia.getText());
                    int tongtienCTHD = Integer.parseInt(txtTienCTHD.getText().replaceAll(",",""));
                    if(!spBUS.CheckSLSP(masp, sl))
                    {
                        return;
                    }
                    ChiTietHDDTO cthd = new ChiTietHDDTO(mahd,masp, tensp, dongia, sl, thanhtien, giamgia, tongtienCTHD);
                    dscthd.add(cthd);
                
                    outModel(model,dscthd);
                    txtTongtien.setText(String.valueOf(formatter.format(setTongtienHD())));
                    txtSearch.setText("Nhập mã sản phẩm");
                    Clean_CTHD();
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
                });
                
                //Xóa CTHD
                btnXoaCTHD.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String masp = txtMasp.getText();
                    if(masp.equals(""))
                    {
                        JOptionPane.showMessageDialog(null,"Vui lòng chọn sản phẩm cần xóa");
                        return;
                    }
                    else
                    {
                        int i = table.getSelectedRow();
                        if(table.getRowSorter() != null)
                        {
                            i = table.getRowSorter().convertRowIndexToModel(i);
                        }
                        dscthd.remove(i);
                        model.removeRow(i);
                        txtTongtien.setText(String.valueOf(setTongtienHD()));
                        Clean_CTHD();
                    }
                    
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
                });
                
                
                //Sửa CTHD
                btnSuaCTHD.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        String masp = txtMasp.getText();
                        if(masp.equals(""))
                        {
                            JOptionPane.showMessageDialog(null,"Vui lòng chọn sản phẩm cần sửa");
                            return;
                        }
                            Flag = false; //Set Flag
                            btnSuaCTHD.setVisible(false);
                            btnLuuCTHD.setVisible(true);
                            txtSl.setEnabled(true);
                            txtGiamgia.setEnabled(true);
                            txtSl.requestFocus();
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
                });

               
                //Lưu CTHD khi sửa CTHD
                btnLuuCTHD.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                     String masp = txtMasp.getText();
                     int sl = Integer.parseInt(txtSl.getText());
                     int giamgia = Integer.parseInt(txtGiamgia.getText());
                     int thanhtien = Integer.parseInt(txtThanhtien.getText().replaceAll(",",""));
                     int tongtiencthd = Integer.parseInt(txtTienCTHD.getText().replaceAll(",",""));
                            for(ChiTietHDDTO cthd : dscthd)
                            {
                                if(cthd.getMasp().equals(masp))
                                {
                                    cthd.setThanhtien(thanhtien);
                                    cthd.setTongtien(tongtiencthd);
                                    cthd.setGiamgia(giamgia);
                                    cthd.setSl(sl);
                                }
                            }
                    JOptionPane.showMessageDialog(null,"Cập nhật hoàn tất !!!");
                    outModel(model, dscthd);
                    txtTongtien.setText(String.valueOf(formatter.format(setTongtienHD())));
                    Clean_CTHD();
                    txtSl.setEnabled(false);
                    txtGiamgia.setEnabled(false);
                    btnSuaCTHD.setVisible(true);
                    btnLuuCTHD.setVisible(false);
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
                });

        
    }
    public ArrayList<ChiTietHDDTO> getDscthd()
    {
        return dscthd;
    }
    public void outModel(DefaultTableModel model , ArrayList<ChiTietHDDTO> dscthd) // Xuất ra Table từ ArrayList
    { 
       Vector data;
       model.setRowCount(0);
        for(ChiTietHDDTO s: dscthd)
        {
            data = new Vector();
            //data.add(s.getMahd());
            data.add(s.getMasp());
            data.add(s.getTensp());
            data.add(formatter.format(s.getDongia()));
            data.add(s.getSl());
            data.add(formatter.format(s.getThanhtien()));
            data.add(s.getGiamgia());
            data.add(formatter.format(s.getTongtien()));
            //data.add((s.getSl() * s.getDongia())-(s.getSl() * s.getDongia() * 0) / 100);
            model.addRow(data);
        }
        table.setModel(model);
    }
    public int setTongtienHD()
    {
        int tong =0;
        for(int i=0;i<dscthd.size();i++)
        {
            tong+= dscthd.get(i).getTongtien();
        }
        return tong;
    }
    public void Search(String masp)
    {
        SanPhamDTO search = spBUS.Search(masp); //Object Select
        if(search != null)
        {
            txtMasp.setText(search.getMasp());
            txtTensp.setText(search.getTensp());
            txtDongia.setText(String.valueOf(formatter.format(search.getDongia())));
            txtSl.requestFocus();
            txtSl.setEnabled(true);
            txtGiamgia.setEnabled(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Không có sản phẩm "+txtSearch.getText()+" trong danh sách");
            txtSearch.setText("");
        }
        
    }
    public void Clean_CTHD()
    {
        txtMasp.setText("");
        txtTensp.setText("");
        txtDongia.setText("");
        txtSl.setText("");
        txtSl.setEnabled(false);
        txtThanhtien.setText("");
        txtGiamgia.setText("");
        txtGiamgia.setEnabled(false);
        txtTienCTHD.setText("");
        
    }
            
    public void Clean_HD()
    {
        cbbNV.setSelectedIndex(0);
        txtKH.setText("");
        txtTongtien.setText("0");
        cbbPTTT.setSelectedIndex(0);
        txtKhachtra.setText("");
        txtTienthua.setText("");
        txtGhichu.setText("");
    }
    @Override
    public void mouseClicked(MouseEvent e) {
   
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == pThanhtoan)
        {
            pThanhtoan.setBackground(new Color(217, 228, 240));
        }
        if(e.getSource() == pCancel)
        {
            pCancel.setBackground(new Color(255, 234, 218));
        }
      
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == pThanhtoan)
        {
            pThanhtoan.setBackground(new Color(179, 202, 226));
        }
        if(e.getSource() == pCancel)
        {
            pCancel.setBackground(new Color(255, 212, 181));
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
