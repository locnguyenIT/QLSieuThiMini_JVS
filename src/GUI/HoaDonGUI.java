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
import BUS.PostBill;
import DTO.ChiTietHDDTO;
import DTO.HoaDonDTO;
import com.toedter.calendar.JDateChooser;
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
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
public class HoaDonGUI extends JPanel{
    
    private JLabel lbMahd, lbManv, lbMakh, lbThoigian, lbTennv, lbTenkh, lbPTTT, lbTongtien, lbGhichu;
    private JLabel lbSearch,lbIconSearch;
    private JTextField txtMahd, txtManv, txtMakh, txtThoigian, txtTennv, txtTenkh,txtTongtien, txtGhichu;
    private JTextField txtSearch;
    private JButton btnXoa, btnSua, btnCTHD, btnBill,btnLuu,btnCancel;
    private JTable table;
    private JScrollPane scroll;
    private JPanel pTop, pBottom;
    private JButton btnKh,btnNv;
    private DefaultTableModel model;
    private int WITDH, HEIGHT;
    private JDateChooser datechooser;
    private JComboBox cbbPTTT;
    private HoaDonBUS hdBUS = new HoaDonBUS();
    private ChiTietHDBUS cthdBUS = new ChiTietHDBUS();
    private KhachHangBUS khBUS = new KhachHangBUS();
    private NhanVienBUS nvBUS = new NhanVienBUS();
    private DecimalFormat formatter = new DecimalFormat("###,###,###.##"); //Format number
    public HoaDonGUI(int WITDH, int HEIGHT)
    {
       nvBUS.DanhSachNhanVien();
       khBUS.DanhSachKhachHang();
       cthdBUS.DanhSachCTHD();
       this.WITDH = WITDH;
       this.HEIGHT = HEIGHT;
       Init();
    }
    public void Init()
    {
        Font fontSeacrh = new Font("Segoe UI",Font.ITALIC,12);
        Font font0 = new Font("Segoe UI",Font.BOLD,13);
        Font font1 = new Font("Segoe UI",Font.PLAIN,13);
        setLayout(null);
        setBounds(new Rectangle(0,0, this.WITDH - 230, this.HEIGHT)); //QLST
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBackground(Color.WHITE);
        
        //------------------------JPANEL TOP-------------------------------//
        
            pTop = new JPanel(null);
            pTop.setBounds(new Rectangle(2,2,1050, 200));
            pTop.setBackground(null);
                
                lbMahd = new JLabel("Mã HD");
                lbMahd.setBounds(new Rectangle(50,30,70,30));
                lbMahd.setFont(font0);
                txtMahd = new JTextField("");
                txtMahd.setBounds(new Rectangle(120,30,70,30));
                txtMahd.setFont(font1);
                txtMahd.setEnabled(false);
                
                lbManv = new JLabel("Mã NV");
                lbManv.setBounds(new Rectangle(50,70,70,30));
                lbManv.setFont(font0);
                txtManv = new JTextField("");
                txtManv.setBounds(new Rectangle(120,70,70,30));
                txtManv.setFont(font1);
                txtManv.setEnabled(false);
                btnNv = new JButton("...");
                btnNv.setBounds(new Rectangle(191,70,30,30));
                btnNv.setBackground(null);
                btnNv.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btnNv.setVisible(false);
                
                
                lbMakh = new JLabel("Mã KH");
                lbMakh.setBounds(new Rectangle(50,110,70,30));
                lbMakh.setFont(font0);
                txtMakh = new JTextField("");
                txtMakh.setBounds(new Rectangle(120,110,70,30));
                txtMakh.setFont(font1);
                txtMakh.setEnabled(false);
                btnKh = new JButton("...");
                btnKh.setBounds(new Rectangle(191,110,30,30));
                btnKh.setBackground(null);
                btnKh.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btnKh.setVisible(false);
                
                
                lbThoigian = new JLabel("Thời gian");
                lbThoigian.setBounds(new Rectangle(250,30,70,30));
                lbThoigian.setFont(font0);
                txtThoigian = new JTextField("");
                txtThoigian.setBounds(new Rectangle(320,30,150,30));
                txtThoigian.setFont(font1);
                txtThoigian.setEnabled(false);
                
                datechooser = new JDateChooser();
                datechooser.setBounds(new Rectangle(320,30,150,30));
                datechooser.setVisible(false);
                

                lbTennv = new JLabel("Tên NV");
                lbTennv.setBounds(new Rectangle(250,70,70,30));
                lbTennv.setFont(font0);
                txtTennv = new JTextField("");
                txtTennv.setBounds(new Rectangle(320,70,150,30));
                txtTennv.setFont(font1);
                txtTennv.setEnabled(false);
                
                
                
                lbTenkh = new JLabel("Tên KH");
                lbTenkh.setBounds(new Rectangle(250,110,70,30));
                lbTenkh.setFont(font0);
                txtTenkh = new JTextField("");
                txtTenkh.setBounds(new Rectangle(320,110,150,30));
                txtTenkh.setFont(font1);
                txtTenkh.setEnabled(false);
                
                
                lbPTTT = new JLabel("PT Thanh toán");
                lbPTTT.setBounds(new Rectangle(500,70,100,30));
                lbPTTT.setFont(font0);
                String[] pttt = {"---Chọn---","ATM","CASH"};
                cbbPTTT = new JComboBox(pttt);
                cbbPTTT.setBounds(new Rectangle(600,70,150,30));
                cbbPTTT.setFont(font1);
                cbbPTTT.setBackground(null);
                cbbPTTT.setEnabled(false);
                
                lbTongtien = new JLabel("Tổng tiền");
                lbTongtien.setBounds(new Rectangle(500,30,100,30));
                lbTongtien.setFont(font0);
                txtTongtien = new JTextField("");
                txtTongtien.setBounds(new Rectangle(600,30,150,30));
                txtTongtien.setFont(font1);
                txtTongtien.setEnabled(false);
                
                lbGhichu = new JLabel("Ghi chú");
                lbGhichu.setBounds(new Rectangle(500,110,70,30));
                lbGhichu.setFont(font0);
                txtGhichu = new JTextField("");
                txtGhichu.setBounds(new Rectangle(600,110,150,30));
                txtGhichu.setFont(font1);
                txtGhichu.setEnabled(false);
                
                
                btnBill = new JButton(new ImageIcon("./src/image/btnBill.png"));
                btnBill.setBounds(new Rectangle(800, 30, 115,33));
                btnBill.setFont(font1);
                btnBill.setBackground(null);
                btnBill.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                btnXoa = new JButton(new ImageIcon("./src/image/btnDelete.png"));
                btnXoa.setBounds(new Rectangle(930, 30, 115,35));
                btnXoa.setFont(font1);
                btnXoa.setBackground(null);
                btnXoa.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                btnCTHD = new JButton(new ImageIcon("./src/image/btnCTHD_30px.png"));
                btnCTHD.setBounds(new Rectangle(800, 70, 115,35));
                btnCTHD.setFont(font1);
                btnCTHD.setBackground(null);
                btnCTHD.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                btnSua = new JButton(new ImageIcon("./src/image/btnFix.png"));
                btnSua.setBounds(new Rectangle(930, 70, 115,35));
                btnSua.setFont(font1);
                btnSua.setBackground(null);
                btnSua.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                btnLuu = new JButton(new ImageIcon("./src/image/btnSave_30px.png"));
                btnLuu.setBounds(new Rectangle(800, 30, 115,35));
                btnLuu.setFont(font1);
                btnLuu.setBackground(null);
                btnLuu.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btnLuu.setVisible(false);
                
                btnCancel = new JButton(new ImageIcon("./src/image/btnCancel_30px.png"));
                btnCancel.setBounds(new Rectangle(930,30, 116,35));
                btnCancel.setBackground(null);
                btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btnCancel.setVisible(false);
                
            pTop.add(lbMahd);
            pTop.add(txtMahd);
            pTop.add(lbManv);
            pTop.add(txtManv);
            pTop.add(lbMakh);
            pTop.add(txtMakh);
            pTop.add(lbThoigian);
            pTop.add(txtThoigian);
            pTop.add(lbTennv);
            pTop.add(txtTennv);
            pTop.add(lbTenkh);
            pTop.add(txtTenkh);
            pTop.add(lbPTTT);
            pTop.add(cbbPTTT);
            pTop.add(txtTongtien);
            pTop.add(lbTongtien);
            pTop.add(lbGhichu);
            pTop.add(txtGhichu);
            pTop.add(btnBill);
            pTop.add(btnCTHD);
            pTop.add(btnXoa);
            pTop.add(btnSua);
            pTop.add(btnLuu);
            pTop.add(btnCancel);
            pTop.add(datechooser);
            pTop.add(btnKh);
            pTop.add(btnNv);
            
            
        //-------------------------------JPANEL BOTTOM-----------------------------------//    
            
            pBottom = new JPanel(null);
            pBottom.setBounds(new Rectangle(0,200, 1070, 500));
            pBottom.setBorder(BorderFactory.createMatteBorder(0,1,1,1, Color.BLACK));
            pBottom.setBackground(null);
            
                lbSearch = new JLabel("Tìm kiếm");
                lbSearch.setBounds(new Rectangle(50,20,100, 30));
                lbSearch.setFont(font0);
                txtSearch = new JTextField("Nhập Mã hóa đơn");
                txtSearch.setBounds(new Rectangle(120, 20,150, 30));
                txtSearch.setFont(fontSeacrh);
                lbIconSearch = new JLabel(new ImageIcon("./src/image/search_26px.png"));
                lbIconSearch.setBounds(new Rectangle(280,20,30, 30));
                lbIconSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                Vector header = new Vector();
                header.add("Mã HD");
                header.add("Mã NV");
                header.add("Tên NV");
                header.add("Mã KH");
                header.add("Tên KH");
                header.add("Tổng tiền");
                header.add("PTTT");
                header.add("Thời gian");
                header.add("Ghi chú");
                model = new DefaultTableModel(header,0);
                table = new JTable(model);
                TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>(model);
                table.setRowSorter(rowSorter);
                table.setRowHeight(30);
                table.getTableHeader().setFont(font0);
                table.getTableHeader().setOpaque(false);
                table.getTableHeader().setBackground(new Color(232,57,99));
                table.getTableHeader().setForeground(new Color(255,255,225));
                table.setShowVerticalLines(false);   
                table.setSelectionBackground(new Color(32,136,203));
                table.setRowHeight(22);
                table.setShowVerticalLines(false);
                table.setFont(font1);
                table.getColumnModel().getColumn(0).setPreferredWidth(20);
                table.getColumnModel().getColumn(1).setPreferredWidth(20);
                table.getColumnModel().getColumn(2).setPreferredWidth(100);
                table.getColumnModel().getColumn(3).setPreferredWidth(20);
                table.getColumnModel().getColumn(4).setPreferredWidth(100);
                table.getColumnModel().getColumn(5).setPreferredWidth(50);
                table.getColumnModel().getColumn(6).setPreferredWidth(30);
                table.getColumnModel().getColumn(7).setPreferredWidth(100);
                table.getColumnModel().getColumn(8).setPreferredWidth(50);
                scroll = new JScrollPane(table);
                scroll.setBounds(new Rectangle(50,70,1000,400));
                scroll.setBackground(null);
                scroll.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                DanhSachHoaDon(); //Load Danh sach hoa don len table

            pBottom.add(lbSearch);
            pBottom.add(txtSearch);
            pBottom.add(lbIconSearch);
            pBottom.add(scroll);
            
        add(pTop);
        add(pBottom);
        
        
        //---------------------------EVENT JPANEL TOP-------------------//
            //CTHD
            btnCTHD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mahd = txtMahd.getText();
                if(mahd.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Vui lòng chọn hóa đơn cần xem CTHD");
                    return;
                }
                else
                {
                    ChiTietHDGUI cthd = new ChiTietHDGUI(txtMahd.getText());
                    int tongtienhd = cthd.getTongtienHD(mahd);
                    //System.out.println(tongtienhd);
                    hdBUS.Set_TongtienHD(mahd, tongtienhd); //Set lai TongtienHD
                    DanhSachHoaDon();
                    Clean();
                }
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            });
            
            //CHỌN NHÂN VIÊN
            btnNv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == btnNv)
                {
                    ChonNhanVien chon = new ChonNhanVien();
                    ArrayList<String> vector = chon.getDulieu();
                    if(!vector.isEmpty())//Kiểm tra 2 Button nhấn bên JDialog Sản phẩm xem có Array lưu Vector
                    {
                        txtManv.setText(vector.get(0));
                        txtTennv.setText(vector.get(1)+" "+vector.get(2));
                    }
                    else
                    {
                        return;  
                    }
                }
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            });
            
            //CHỌN KHÁCH HÀNG
            btnKh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == btnKh)
                {
                    ChonKhachHang chon = new ChonKhachHang();
                    String makh = chon.getData();
                    if(!makh.equals(""))
                    {
                        txtMakh.setText(makh);
                        txtTenkh.setText(khBUS.SearchTenkh(makh));
                    }
                    return;
                }
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            });
            
            //IN BILL
            btnBill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mahd = txtMahd.getText();
                if(mahd.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Vui lòng chọn hóa đơn để in Bill");
                    return;
                }
                else
                {  
                    String manv = txtManv.getText();
                    String tennv = txtTennv.getText();
                    String makh = txtMakh.getText();
                    String tenkh = txtTenkh.getText();
                    int tongtien = Integer.parseInt(txtTongtien.getText().replaceAll(",",""));
                    String pttt = cbbPTTT.getSelectedItem().toString();
                    String thoigian = txtThoigian.getText();
                    String ghichu = txtGhichu.getText();
                    HoaDonDTO hd = new HoaDonDTO(mahd, manv,tennv,makh,tenkh,tongtien,pttt,thoigian,ghichu);
                    //ChiTietHDBUS cthdBUS = new ChiTietHDBUS();
                    cthdBUS.DanhSachCTHD();
                    ArrayList<ChiTietHDDTO> cthd = cthdBUS.DanhSachCTHD(mahd);
                    PostBill post = new PostBill(hd,cthd);
                    post.PrintBill();
                }
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            });
            
            
            //SỬA HÓA ĐƠN
            btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtMahd.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Vui lòng chọn hóa đơn cần sửa");
                    return;
                }
                else
                {
                Enable();
                }
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            });
            
            
            //XÓA HÓA ĐƠN
            btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mahd = txtMahd.getText();
                if(mahd.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Vui lòng chọn hóa đơn cần xóa");
                    return;
                }
                else
                {
                    int  option = JOptionPane.showConfirmDialog(null,"Xác nhận xóa" ,"Xóa Hóa đơn",JOptionPane.YES_NO_OPTION);
                    if(option == 0)
                    {
                        cthdBUS.Delete(mahd);
                        hdBUS.Delete(mahd);
                        table.clearSelection();
                        outModel(model,hdBUS.getDshd());
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
            
            
            //LƯU HÓA ĐƠN SAU KHI CLICK SỬA
            btnLuu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mahd = txtMahd.getText();
                
                    String manv = txtManv.getText();
                    String tennv = txtTennv.getText();
                    String makh = txtMakh.getText();
                    String tenkh = txtTenkh.getText();
                    String thoigian = txtThoigian.getText();
                    if(datechooser.getCalendar() != null)
                    {
                        Date time = Timestamp.valueOf(txtThoigian.getText());
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTimeInMillis(time.getTime());
                        int dd = datechooser.getCalendar().get(Calendar.DATE);
                        int mm = datechooser.getCalendar().get(Calendar.MONTH);
                        int yyy = datechooser.getCalendar().get(Calendar.YEAR);
                        calendar.set(yyy,mm,dd);
                        Timestamp newTime = new Timestamp(calendar.getTime().getTime());

                        thoigian = newTime.toString();
                    } 
                    int tongtien = Integer.parseInt(txtTongtien.getText().replaceAll(",",""));
                    String pttt = cbbPTTT.getSelectedItem().toString();
                    String ghichu = txtGhichu.getText();

                    HoaDonDTO hd = new HoaDonDTO(mahd, manv, tennv, makh, tenkh, tongtien,pttt, thoigian,ghichu);

                    hdBUS.Set(hd);
                    JOptionPane.showMessageDialog(null," Lưu thành công !!!");
                    hdBUS.DanhSachHD();
                    outModel(model, hdBUS.getDshd());
                    Clean();
                    Block();
                
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Clean();
                Block();
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        //---------------------------EVENT JPANEL BOTTOM------------------------//
        
            //CLICK TABLE
             table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e)
                {

                int i = table.getSelectedRow();
                if(table.getRowSorter() != null)
                {
                    i = table.getRowSorter().convertRowIndexToModel(i);
                }
                txtMahd.setText(table.getModel().getValueAt(i, 0).toString());
                txtManv.setText(table.getModel().getValueAt(i, 1).toString());
                txtTennv.setText(table.getModel().getValueAt(i, 2).toString());
                txtMakh.setText(table.getModel().getValueAt(i, 3).toString());
                txtTenkh.setText(table.getModel().getValueAt(i, 4).toString());
                txtTongtien.setText(table.getModel().getValueAt(i, 5).toString());
                cbbPTTT.setSelectedItem(table.getModel().getValueAt(i, 6).toString());
                txtThoigian.setText(table.getModel().getValueAt(i, 7).toString());
                txtGhichu.setText(table.getModel().getValueAt(i, 8).toString());
                }
                });
            
            //SEARCH
            txtSearch.addKeyListener(new KeyAdapter() {
             public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {   
                String mahd = txtSearch.getText();
                Search_Mahd(mahd);
            }
            }
            });
            
            //SEARCH
            txtSearch.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e)
            {
                    txtSearch.setText("");
            }
            });
            
            //SEARCH
            lbIconSearch.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e)
                {
                    String mahd = txtSearch.getText();
                    Search_Mahd(mahd);
                }
            });
            
            //SẮP XẾP DSHD SAU KHI SEARCH XONG
            txtSearch.getDocument().addDocumentListener(new DocumentListener(){
                @Override
                public void insertUpdate(DocumentEvent e) {

                }

                @Override
                public void removeUpdate(DocumentEvent e) { //setModel ban đầu khi txtSearch == null
                    String text = txtSearch.getText();

                    if (text.equals("")) {
                        outModel(model, hdBUS.getDshd());
                        rowSorter.setRowFilter(null);       
                    } 

                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

            });
            
    }
    public void DanhSachHoaDon() //Load DanhSachSanPham lên table
    {  
        hdBUS.DanhSachHD();
        ArrayList<HoaDonDTO> dshd = hdBUS.getDshd(); //get Data 
        model.setRowCount(0);
        outModel(model, dshd); 
          
    }
    public void Clean()
    {
        txtMahd.setText("");
        txtManv.setText("");
        txtTennv.setText("");
        txtMakh.setText("");
        txtTenkh.setText("");
        txtThoigian.setText("");
        txtTongtien.setText("");
        cbbPTTT.setSelectedIndex(0);
        txtGhichu.setText("");
    }
    public void Block()
    {
        txtManv.setEnabled(false);
        txtMakh.setEnabled(false);
        datechooser.setVisible(false);
        txtThoigian.setVisible(true);
        cbbPTTT.setEnabled(false);
        txtGhichu.setEnabled(false);
        btnKh.setVisible(false);
        btnNv.setVisible(false);
        btnSua.setVisible(true);
        btnBill.setVisible(true);
        btnCTHD.setVisible(true);
        btnXoa.setVisible(true);
        btnLuu.setVisible(false);
        btnCancel.setVisible(false);
    }
    public void Enable()
    {
        txtManv.setEnabled(true);
        txtMakh.setEnabled(true);
        btnKh.setVisible(true);
        btnNv.setVisible(true);
        cbbPTTT.setEnabled(true);
        txtGhichu.setEnabled(true);
        txtThoigian.setVisible(false);
        datechooser.setVisible(true);
        btnSua.setVisible(false);
        btnBill.setVisible(false);
        btnCTHD.setVisible(false);
        btnXoa.setVisible(false);
        btnLuu.setVisible(true);
        btnCancel.setVisible(true);
    }
    public void outModel(DefaultTableModel model , ArrayList<HoaDonDTO> dshd) // Xuất ra Table từ ArrayList
    { 
       Vector data;
       model.setRowCount(0);
       
        for(HoaDonDTO hd: dshd)
        {
            data = new Vector();
            data.add(hd.getMahd());
            data.add(hd.getManv());
            data.add(hd.getTennv());
            data.add(hd.getMakh());
            data.add(hd.getTenkh());
            data.add(formatter.format(hd.getTongtien()));
            data.add(hd.getThanhtoan());
            data.add(hd.getDate());
            data.add(hd.getGhichu());
            model.addRow(data);
        }
        table.setModel(model);
    }
     public void Search_Mahd(String mahd)
    {  
        ArrayList<HoaDonDTO> searchHD = new ArrayList<>(); //Tạo Arraylist add Object select để load model
        HoaDonDTO hd = hdBUS.Search_Mahd(mahd); //Object Select
        if(hd != null)
        {
            searchHD.add(hd);
            outModel(model,searchHD); //Table filter ra Object Select những ko ảnh hưởng tới dssp ban đầu
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Không có hóa đơn "+txtSearch.getText()+" trong danh sách");
            txtSearch.setText("");
        }
    }
}
