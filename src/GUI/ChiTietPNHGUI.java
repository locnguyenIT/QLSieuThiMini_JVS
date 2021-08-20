/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.ChiTietPNHBUS;
import BUS.PhieuNhapHangBUS;
import DTO.ChiTietPNHDTO;
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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ntloc
 */
public class ChiTietPNHGUI extends JDialog{
    
    private JLabel lbCTPNH, lbMasp, lbTensp, lbDongia, lbSl, lbThanhtien, lbGiamgia, lbTongtien;
    private JTextField txtMasp,txtTensp,txtDongia,txtSl,txtThanhtien,txtGiamgia,txtTongtien;
    private JButton btnXoa, btnSua,btnThem,btnBack, btnLuu,btnCancel, btnDssp;
    private JTable table;
    private JScrollPane scroll;
    private DefaultTableModel model;
    private JPanel pTop, pBottom,pCenter;
    private boolean Flag = true; //Xét cờ để Setting ThêmCTHD or SửaCTHD | THÊM CTHD Flag = true, SửaCHTD Flag = false
    private ChiTietPNHBUS ctpnhBUS = new ChiTietPNHBUS();
    private PhieuNhapHangBUS pnhBUS = new PhieuNhapHangBUS();
    DecimalFormat formatter = new DecimalFormat("###,###,###.##");

    public ChiTietPNHGUI(String mapnh) 
    {
        setModal(true);
        Init(mapnh);
    }
    public void Init(String mapnh)
    {
        Font font0 = new Font("Segoe UI",Font.BOLD,13);
        Font font1 = new Font("Segoe UI",Font.PLAIN,13);
        Font info = new Font("Segoe UI",Font.BOLD,22);
        setSize(1100,600);
        setLayout(null);
        setTitle("CHI TIẾT PHIẾU NHẬP HÀNG");
        setBackground(Color.WHITE);
        //----------------------------JPANEL TOP-------------------------------//
            pTop = new JPanel(null);
            pTop.setBounds(new Rectangle(0,0,1100,50));
            pTop.setBackground(new Color(85,93,110));
            
                lbCTPNH = new JLabel("CHI TIẾT PHIẾU NHẬP HÀNG: "+mapnh,JLabel.CENTER);
                lbCTPNH.setBounds(new Rectangle(350,12, 370, 30));
                lbCTPNH.setForeground(Color.WHITE);
                lbCTPNH.setFont(info);
            pTop.add(lbCTPNH);
        //---------------------------JPANNEL CENTER-----------------------------//    
            pCenter = new JPanel(null);
            pCenter.setBounds(new Rectangle(0,50,1100,465));
            pCenter.setBackground(Color.WHITE);
            
                lbMasp = new JLabel("Mã sản phẩm");
                lbMasp.setBounds(new Rectangle(20,20,100,30));
                lbMasp.setFont(font1);
                txtMasp = new JTextField("");
                txtMasp.setBounds(new Rectangle(120,20,145,30));
                txtMasp.setFont(font1);
                txtMasp.setEnabled(false);
                
                btnDssp = new JButton("...");
                btnDssp.setBounds(new Rectangle(266,20,30,30));
                btnDssp.setBackground(null);
                btnDssp.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btnDssp.setVisible(false);
                
                lbTensp = new JLabel("Tên sản phẩm");
                lbTensp.setBounds(new Rectangle(20,60,100,30));
                lbTensp.setFont(font1);
                txtTensp = new JTextField("");
                txtTensp.setBounds(new Rectangle(120,60,145,30));
                txtTensp.setFont(font1);
                txtTensp.setEnabled(false);
                
                lbDongia = new JLabel("Đơn giá");
                lbDongia.setBounds(new Rectangle(20,100,100,30));
                lbDongia.setFont(font1);
                txtDongia = new JTextField("");
                txtDongia.setBounds(new Rectangle(120,100,145,30));
                txtDongia.setFont(font1);
                txtDongia.setEnabled(false);
                
                lbSl = new JLabel("Số lượng");
                lbSl.setBounds(new Rectangle(20,140,100,30));
                lbSl.setFont(font1);
                txtSl = new JTextField("");
                txtSl.setBounds(new Rectangle(120,140,145,30));
                txtSl.setFont(font1);
                txtSl.setEnabled(false);
               
                
                lbThanhtien = new JLabel("Thành tiền");
                lbThanhtien.setBounds(new Rectangle(20,180,100,30));
                lbThanhtien.setFont(font1);
                txtThanhtien = new JTextField("");
                txtThanhtien.setBounds(new Rectangle(120,180,145,30));
                txtThanhtien.setFont(font1);
                txtThanhtien.setEnabled(false);
                
                lbGiamgia = new JLabel("Giảm giá (%)");
                lbGiamgia.setBounds(new Rectangle(20,220,100,30));
                lbGiamgia.setFont(font1);
                txtGiamgia = new JTextField("");
                txtGiamgia.setBounds(new Rectangle(120,220,145,30));
                txtGiamgia.setFont(font1);
                txtGiamgia.setEnabled(false);
                
           
                
                lbTongtien = new JLabel("Tổng tiền");
                lbTongtien.setBounds(new Rectangle(20,260,100,30));
                lbTongtien.setFont(font1);
                txtTongtien = new JTextField("");
                txtTongtien.setBounds(new Rectangle(120,260,145,30));
                txtTongtien.setFont(font1);
                txtTongtien.setEnabled(false);
                
                btnThem = new JButton(new ImageIcon("./src/image/btnAdd.png"));
                btnThem.setBounds(new Rectangle(20, 320, 115,35));
                btnThem.setBackground(null);
                btnThem.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                btnXoa = new JButton(new ImageIcon("./src/image/btnDelete.png"));
                btnXoa.setBounds(new Rectangle(150, 320, 115,35));
                btnXoa.setBackground(null);
                btnXoa.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                btnSua = new JButton(new ImageIcon("./src/image/btnFix.png"));
                btnSua.setBounds(new Rectangle(20, 388, 115,35));
                btnSua.setBackground(null);
                btnSua.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                btnBack = new JButton(new ImageIcon("./src/image/btnBack_30px.png"));
                btnBack.setBounds(new Rectangle(150, 388, 115,35));
                btnBack.setBackground(null);
                btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                btnLuu = new JButton(new ImageIcon("./src/image/btnSave_30px.png"));
                btnLuu.setBounds(new Rectangle(20, 388, 115,35));
                btnLuu.setBackground(null);
                btnLuu.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btnLuu.setVisible(false);
                
                btnCancel = new JButton(new ImageIcon("./src/image/btnCancel_30px.png"));
                btnCancel.setBounds(new Rectangle(150, 388, 116,35));
                btnCancel.setBackground(null);
                btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btnCancel.setVisible(false);
                
                
                
                
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
                table.setShowVerticalLines(false);   
                table.setSelectionBackground(new Color(32,136,203));
                table.setRowHeight(25);
                table.setFont(font1);
                table.getColumnModel().getColumn(1).setPreferredWidth(130);
                scroll = new JScrollPane(table);
                scroll.setBounds(new Rectangle(330,20,730,400));
                scroll.setBackground(null);
                scroll.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                
                DanhSachCTPNH(mapnh); //Load ChiTietHD(Mahd)
                
            pCenter.add(lbMasp);
            pCenter.add(txtMasp);
            pCenter.add(lbTensp);
            pCenter.add(txtTensp);
            pCenter.add(lbDongia);
            pCenter.add(txtDongia);
            pCenter.add(lbSl);
            pCenter.add(txtSl);
            pCenter.add(lbThanhtien);
            pCenter.add(txtThanhtien);
            pCenter.add(lbGiamgia);
            pCenter.add(txtGiamgia);
            pCenter.add(lbTongtien);
            pCenter.add(txtTongtien);
            pCenter.add(scroll);
            pCenter.add(btnXoa);
            pCenter.add(btnSua);
            pCenter.add(btnLuu);
            pCenter.add(btnBack);
            pCenter.add(btnThem);
            pCenter.add(btnCancel);
            pCenter.add(btnDssp);    
             
       //--------------------------------JPANEL BOTTOM----------------------------------//    
            pBottom = new JPanel(null);
            pBottom.setBounds(new Rectangle(0,515,1100,50));
            pBottom.setBackground(new Color(85,93,110));
            
      
            
        //--------------------------EVENT JPANEL CENTER----------------------------------//  
        
            //CLICK TABLE
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
                txtTongtien.setText(table.getModel().getValueAt(i, 6).toString());
                
                }
                });
             
            
            //CHỌN SẢN PHẨM
            btnDssp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == btnDssp)
                {
                    
                    if(Flag == true) //Thêm CTHD
                    {
                        ChonSanPham themCTHD = new ChonSanPham();
                        ArrayList<String> vector_ThemCTHD = themCTHD.getDulieu();
                        if(!vector_ThemCTHD.isEmpty())//Kiểm tra 2 Button nhấn bên JDialog Sản phẩm xem có Array lưu Vector
                        {
                           txtMasp.setText(vector_ThemCTHD.get(0));
                           txtTensp.setText(vector_ThemCTHD.get(1));
                           txtDongia.setText(vector_ThemCTHD.get(2));
                           txtSl.requestFocus();
                        }
                        else
                        {
                            return;  
                        }
                    }
                    else    //Flag == false Sửa CTHD
                    {
                        ChonSanPham SuaCTHD = new ChonSanPham();
                        ArrayList<String> vector_SuaCTHD = SuaCTHD.getDulieu();
                        if(!vector_SuaCTHD.isEmpty())//Kiểm tra 2 Button nhấn bên JDialog Sản phẩm xem có Array lưu Vector
                        {
                           txtMasp.setText(vector_SuaCTHD.get(0));
                           txtTensp.setText(vector_SuaCTHD.get(1));
                           txtDongia.setText(vector_SuaCTHD.get(2));
                           int dongia = Integer.parseInt(txtDongia.getText().replaceAll(",",""));
                           int sl = Integer.parseInt(txtSl.getText());
                           txtThanhtien.setText(String.valueOf(formatter.format(dongia * sl)));
                           int thanhtien = Integer.parseInt(txtThanhtien.getText().replaceAll(",",""));
                           int giamgia = Integer.parseInt(txtGiamgia.getText());
                           int tongtiencthd = thanhtien-(thanhtien*giamgia)/100;
                           txtTongtien.setText(String.valueOf(formatter.format(tongtiencthd)));
                        }
                        else
                        {
                            return;  
                        }
                    }
                   
                }
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            });
            
            //SỐ LƯỢNG
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
                       else //Sửa CTHD
                       {
                           int dongia = Integer.parseInt(txtDongia.getText().replaceAll(",",""));
                           int sl = Integer.parseInt(txtSl.getText());
                           txtThanhtien.setText(String.valueOf(formatter.format(dongia * sl)));
                           int thanhtien = Integer.parseInt(txtThanhtien.getText().replaceAll(",",""));
                           int giamgia = Integer.parseInt(txtGiamgia.getText());
                           int tongtiencthd = thanhtien-(thanhtien*giamgia)/100;
                           txtTongtien.setText(String.valueOf(formatter.format(tongtiencthd)));
                       }
                       
                       //txtGiamgia.requestFocus();
                    }
                }
            });
            
            //GIẢM GIÁ
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
                           txtTongtien.setText(String.valueOf(formatter.format(tongtiencthd)));
                        }
                        else    //Sửa CTHD
                        {
                           int thanhtien = Integer.parseInt(txtThanhtien.getText().replaceAll(",",""));
                           int giamgia = Integer.parseInt(txtGiamgia.getText());
                           int tongtiencthd = thanhtien-(thanhtien*giamgia)/100;
                           txtTongtien.setText(String.valueOf(formatter.format(tongtiencthd))); 
                        }
                      
                       //txtGiamgia.requestFocus();
                    }
                }
            });
         
            //Thêm CTHD
            btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Flag = true; //Chuẩn bị cờ cho btnLuu ThêmCTHD
                Enable_AddOrUpdateCTHD();
                table.clearSelection();
                Clean_CTHD();
                txtMasp.requestFocus();
                
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            });
            
            //XÓA CTHD
            btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtMasp.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Vui lòng chọn sản phẩm cần xóa");
                    return;
                }
                else
                {
                    int  option = JOptionPane.showConfirmDialog(null,"Xác nhận xóa" ,"Xóa sản phẩm",JOptionPane.YES_NO_OPTION);
                    if(option == 0)
                    {
                        String masp = txtMasp.getText();
                        ctpnhBUS.Delete_CTPNH(mapnh,masp);
                        JOptionPane.showMessageDialog(null,"Xóa thành công !!!");
                        DanhSachCTPNH(mapnh);
                        Clean_CTHD();
                        int count = table.getModel().getRowCount();
                        if(count == 0)
                        {
                            ctpnhBUS.Delete(mapnh);
                            pnhBUS.Delete(mapnh);
                            dispose();
                        }
                    }
                    else
                    {
                        table.clearSelection();
                        Clean_CTHD();
                    }
                    
                }
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            });
            
            //Sửa CTHD
            btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtMasp.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Vui lòng chọn sản phẩm cần sửa");
                    return;
                }
                else
                {
                   Flag = false; //Chuẩn bị cờ cho btnLuu SuaCTHD
                   Enable_AddOrUpdateCTHD();
                }
                
              
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            });
            
            //BACK
            btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                setVisible(false);
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            }); 
            
            //LƯU
            btnLuu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Flag == true) //Thêm CTHD
                {
                    String masp = txtMasp.getText();
                    String tensp =txtTensp.getText();
                    int dongia = Integer.parseInt(txtDongia.getText().replaceAll(",",""));
                    int sl = Integer.parseInt(txtSl.getText());
                    int thanhtien = Integer.parseInt(txtThanhtien.getText().replaceAll(",",""));
                    int giamgia = Integer.parseInt(txtGiamgia.getText());
                    int tongtiencthd = Integer.parseInt(txtTongtien.getText().replaceAll(",",""));
                    
                    ChiTietPNHDTO ctpnh = new ChiTietPNHDTO(mapnh, masp, tensp, dongia, sl, thanhtien, giamgia,tongtiencthd );

                    ctpnhBUS.Add(ctpnh);
                    System.out.println("true");
                    JOptionPane.showMessageDialog(null,"Thêm thành công!!!");
                    DanhSachCTPNH(mapnh);
                    Block_ThemCTHD();
                    
                }
                else        //Sửa CTHD
                {
                    String masp = txtMasp.getText();
                    String tensp =txtTensp.getText();
                    int dongia = Integer.parseInt(txtDongia.getText().replaceAll(",",""));
                    int sl = Integer.parseInt(txtSl.getText());
                    int thanhtien = Integer.parseInt(txtThanhtien.getText().replaceAll(",",""));
                    int giamgia = Integer.parseInt(txtGiamgia.getText());
                    int tongtiencthd = Integer.parseInt(txtTongtien.getText().replaceAll(",",""));

                    int column = 0;
                    int row = table.getSelectedRow();
                    String value = table.getModel().getValueAt(row, column).toString(); //get masp trong table muốn sửa


                    ChiTietPNHDTO pnh = new ChiTietPNHDTO(mapnh, masp, tensp, dongia, sl, thanhtien, giamgia, tongtiencthd);
                    ctpnhBUS.Set_SL_SP(mapnh, masp); 
                    ctpnhBUS.Set(pnh,value);    //Update CTHD
                    ctpnhBUS.Update_SLSP_AfterDeleteCTHD(mapnh, masp);
                    JOptionPane.showMessageDialog(null,"Sửa thành công !!!");
                    DanhSachCTPNH(mapnh);
                    Block_SuaCTHD();
                    
                }
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            });
            
            
            //HỦY BỎ
            btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Flag == true)
                {
                    Enable_Cancel();
                    table.clearSelection();
                }
                else
                {
                    Enable_Cancel();
                    table.clearSelection();
                }
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            });
        add(pTop);
        add(pBottom);
        add(pCenter);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);        
    }
    public void Block_ThemCTHD()
    {
        btnDssp.setVisible(false);
        txtMasp.setText("");
        txtMasp.setEnabled(false);
        txtTensp.setText("");
        txtDongia.setText("");
        txtSl.setText("");
        txtSl.setEnabled(false);
        txtGiamgia.setText("");
        txtGiamgia.setEnabled(false);
        txtThanhtien.setText("");
        txtTongtien.setText("");
        btnLuu.setVisible(false);
        btnCancel.setVisible(false);
        btnThem.setVisible(true);
        btnBack.setVisible(true);
        btnXoa.setVisible(true);
        btnSua.setVisible(true);
    }
    public void Clean_CTHD()
    {
        txtMasp.setText("");
        txtTensp.setText("");
        txtDongia.setText("");
        txtSl.setText("");
        txtThanhtien.setText("");
        txtGiamgia.setText("");
        txtTongtien.setText("");
    }
    public void Block_SuaCTHD()
    {
        txtMasp.setText("");
        txtTensp.setText("");
        txtDongia.setText("");
        txtSl.setText("");
        txtThanhtien.setText("");
        txtGiamgia.setText("");
        txtTongtien.setText("");
        btnDssp.setVisible(false);
        txtMasp.setEnabled(false);
        txtSl.setEnabled(false);
        txtGiamgia.setEnabled(false);
        btnLuu.setVisible(false);
        btnCancel.setVisible(false);
        btnThem.setVisible(true);
        btnBack.setVisible(true);
        btnXoa.setVisible(true);
        btnSua.setVisible(true);
    }
    public void Enable_AddCTHD()
    {
        txtMasp.setEnabled(true);
        btnDssp.setVisible(true);
        txtSl.setEnabled(true);
        txtGiamgia.setEnabled(true);
        btnThem.setVisible(false);
        btnXoa.setVisible(false);
        btnSua.setVisible(false);
        btnBack.setVisible(false);
        btnLuu.setVisible(true);
        btnCancel.setVisible(true);   
    }
    public void Enable_AddOrUpdateCTHD()
    {
        txtMasp.setEnabled(true);
        btnDssp.setVisible(true);
        txtSl.setEnabled(true);
        txtGiamgia.setEnabled(true);
        btnThem.setVisible(false);
        btnXoa.setVisible(false);
        btnSua.setVisible(false);
        btnBack.setVisible(false);
        btnLuu.setVisible(true);
        btnCancel.setVisible(true);   
    }
    public void Enable_Cancel()
    {
        btnDssp.setVisible(false);
        btnLuu.setVisible(false);
        btnCancel.setVisible(false);
        txtMasp.setText("");
        txtMasp.setEnabled(false);
        txtTensp.setText("");
        txtTensp.setEnabled(false);
        txtDongia.setText("");
        txtSl.setText("");
        txtSl.setEnabled(false);
        txtGiamgia.setText("");
        txtGiamgia.setEnabled(false);
        txtThanhtien.setText("");
        txtTongtien.setText("");
        btnThem.setVisible(true);
        btnXoa.setVisible(true);
        btnSua.setVisible(true);
        btnBack.setVisible(true);
    }

    public void DanhSachCTPNH(String mapnh) //Load DanhSachSanPham lên table
    {   
        ctpnhBUS.DanhSachCTPNH(mapnh);
        ArrayList<ChiTietPNHDTO> dsctpnh = ctpnhBUS.getDsctpnh(); //get Data 
        model.setRowCount(0);
        outModel(model,dsctpnh);
    }
    public int getTongtienHD(String mahd)
    {
        int tongtienhd = 0;
        ArrayList<ChiTietPNHDTO> dscthd = ctpnhBUS.getDsctpnh();
        for(ChiTietPNHDTO cthd : dscthd)
        {
            if(cthd.getMapnh().equals(mahd))
            {
                    tongtienhd += cthd.getTongtien();
            }
        }
        return tongtienhd;
    }
   
    public void outModel(DefaultTableModel model , ArrayList<ChiTietPNHDTO> dscthd) // Xuất ra Table từ ArrayList
    { 
       Vector data;
       model.setRowCount(0);
       DecimalFormat formatter = new DecimalFormat("###,###,###.##");
        for(ChiTietPNHDTO s: dscthd)
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
    
}
