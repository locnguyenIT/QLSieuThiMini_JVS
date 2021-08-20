/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.LoaiSpBUS;
import BUS.NhaCungCapBUS;
import BUS.SanPhamBUS;
import DTO.LoaiSpDTO;
import DTO.NhaCungCapDTO;
import DTO.SanPhamDTO;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableColumnModel;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author ntloc
 */
public class SanPhamGUI extends JPanel implements ActionListener, KeyListener{

    private int DEFAULT_WIDTH;
    private int DEFAULT_HEIGH;
    private JPanel pMenu_Info, pMenu_SP;
    private JTable table;
    private JButton btnAdd, btnDelete, btnFix, btnReset, btnExport, btnImport;
    private JLabel lbImage, lbMasp, lbTensp, lbSl, lbDongia,lbDvt, lbMancc, lbTenLoai, lbSearch, iconSearch; 
    private JTextField txtMasp, txtTensp, txtSl, txtDongia,txtDvt, txtTenncc, txtTenloai,txtSearch;
    private String imgName = "null";
    private DefaultTableModel model;
    private SanPhamBUS spBUS = new SanPhamBUS();;
    private LoaiSpBUS loaiBUS = new LoaiSpBUS();
    private NhaCungCapBUS nccBUS = new NhaCungCapBUS();
    private JButton btnSearch;
    
    public SanPhamGUI(){}
    
    public SanPhamGUI(int WIDTH, int HEIGH)
    {
        loaiBUS.DanhSachLoaiSp();
        nccBUS.DanhSachNCC();
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

                lbImage = new JLabel("Img",JLabel.CENTER);
                lbImage.setBounds(new Rectangle(0, 20, 200, 230));
                lbImage.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                
                lbMasp = new JLabel("Mã sản phẩm");
                lbMasp.setBounds(new Rectangle(300, 20, 100, 30));
                lbMasp.setFont(font0);
                txtMasp = new JTextField("");
                txtMasp.setBounds(new Rectangle(400, 20, 200, 30));
                txtMasp.setFont(font1);
                txtMasp.setEnabled(false);
                
                lbTensp = new JLabel("Tên sản phẩm");
                lbTensp.setBounds(new Rectangle(300, 60, 100, 30));
                lbTensp.setFont(font0);
                txtTensp = new JTextField("");
                txtTensp.setBounds(new Rectangle(400, 60, 200, 30));
                txtTensp.setFont(font1);
                txtTensp.setEnabled(false);
                
                lbSl = new JLabel("Số lượng");
                lbSl.setBounds(new Rectangle(300, 140, 100, 30));
                lbSl.setFont(font0);
                txtSl = new JTextField("");
                txtSl.setBounds(new Rectangle(400, 140, 200, 30));
                txtSl.setFont(font1);
                txtSl.setEnabled(false);
                
                lbDongia = new JLabel("Đơn giá");
                lbDongia.setBounds(new Rectangle(300, 100, 100, 30));
                lbDongia.setFont(font0);
                txtDongia = new JTextField("");
                txtDongia.setBounds(new Rectangle(400, 100, 200, 30));
                txtDongia.setFont(font1);
                txtDongia.setEnabled(false);
                
                lbDvt = new JLabel("Đơn vị tính");
                lbDvt.setBounds(new Rectangle(300, 180, 100, 30));
                lbDvt.setFont(font0);
                txtDvt = new JTextField("");
                txtDvt.setBounds(new Rectangle(400, 180, 200, 30));
                txtDvt.setFont(font1);
                txtDvt.setEnabled(false);
                
                lbTenLoai = new JLabel("Tên Loại");
                lbTenLoai.setBounds(new Rectangle(260, 220, 100, 30));
                lbTenLoai.setFont(font0);
                txtTenloai = new JTextField("");
                txtTenloai.setBounds(new Rectangle(330, 220,100, 30));
                txtTenloai.setFont(font1);
                txtTenloai.setEnabled(false);
                
                lbMancc = new JLabel("Tên NCC");
                lbMancc.setBounds(new Rectangle(435, 220, 100, 30));
                lbMancc.setFont(font0);
                txtTenncc = new JTextField("");
                txtTenncc.setBounds(new Rectangle(500, 220,100, 30));
                txtTenncc.setFont(font1);
                txtTenncc.setEnabled(false);

                btnAdd = new JButton(new ImageIcon("./src/image/btnAdd.png"));
                btnAdd.setBounds(new Rectangle(700, 20,115,34));
                btnAdd.setBackground(null);
                btnAdd.addActionListener(this); //Lắng nghe return của JDialog
                btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));

                
                btnDelete = new JButton(new ImageIcon("./src/image/btnDelete.png"));
                btnDelete.setBounds(new Rectangle(700,70, 114,34));
                btnDelete.setBackground(null);
                btnDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                btnFix = new JButton(new ImageIcon("./src/image/btnFix.png"));
                btnFix.setBounds(new Rectangle(700,120, 114,34));
                btnFix.setBackground(null);
                btnFix.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                btnReset = new JButton(new ImageIcon("./src/image/btnReset.png"));
                btnReset.setBounds(new Rectangle(700,170, 114,34));
                btnReset.setBackground(null);
                btnReset.setCursor(new Cursor(Cursor.HAND_CURSOR));
               
                
            pMenu_Info.add(lbImage);  
            pMenu_Info.add(lbMasp);
            pMenu_Info.add(txtMasp);
            pMenu_Info.add(lbTensp);
            pMenu_Info.add(txtTensp);
            pMenu_Info.add(lbSl);
            pMenu_Info.add(txtSl);
            pMenu_Info.add(lbDongia);
            pMenu_Info.add(txtDongia);
            pMenu_Info.add(lbDvt);
            pMenu_Info.add(txtDvt);
            pMenu_Info.add(lbMancc);
            pMenu_Info.add(txtTenncc);
            pMenu_Info.add(lbTenLoai);
            pMenu_Info.add(txtTenloai);
            pMenu_Info.add((btnAdd));
            pMenu_Info.add(btnAdd);
            pMenu_Info.add(btnDelete);
            pMenu_Info.add(btnFix);
            pMenu_Info.add(btnReset);
            
            
           
            
            btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table.clearSelection();
                AddSanPham add = new AddSanPham();
                if(e.getSource() == btnAdd) //Return kết quả trả về từ Jdialog
                {  
                    DanhSachSanPham();
                }
                
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            });
            btnDelete.addActionListener(new ActionListener() {
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
                    int  option = JOptionPane.showConfirmDialog(null,"Xác nhận xóa" ,"Xóa sản phẩm",JOptionPane.YES_NO_OPTION);
                    if(option == 0)
                    {
                        spBUS.Delete(masp);
                        table.clearSelection();
                        outModel(model,spBUS.getDssp());
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
                
                if(txtMasp.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Vui lòng chọn sản phẩm cần sửa");
                    return;
                }
                else
                {
                    String masp = txtMasp.getText();
                    String tensp = txtTensp.getText();
                    int sl = Integer.parseInt(txtSl.getText());
                    int dongia = Integer.parseInt(txtDongia.getText());
                    String dvt = txtDvt.getText();
                    int i = table.getSelectedRow();
                    String loai = table.getModel().getValueAt(i, 5).toString()+" - "+txtTenloai.getText(); //Nối chuỗi mã + tên
                    //System.out.println(loai);
                    String ncc = table.getModel().getValueAt(i, 6).toString()+" - "+txtTenncc.getText();
                    String image = imgName;
                    UpdateSanPham update = new UpdateSanPham(masp,tensp,dongia,sl,dvt,loai,ncc,image);
                    if(e.getSource() == btnFix)
                    {
                         DanhSachSanPham();
                         Clean();
                    }
                }
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            });
            
            btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtMasp.setText("");
                txtTensp.setText("");
                txtSl.setText("");
                txtDongia.setText("");
                txtDvt.setText("");
                txtTenncc.setText("");
                txtTenloai.setText("");
                lbImage.setText("");
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
                txtSearch = new JTextField("Nhập mã sản phẩm");
                txtSearch.setBounds(new Rectangle(170, 20,150, 30));
                txtSearch.setFont(fontSeacrh);
                
                btnSearch = new JButton(new ImageIcon("./src/image/search_26px.png"));
                btnSearch.setBounds(new Rectangle(340, 20,35,30));
                btnSearch.setBackground(null);
                btnSearch.setBorderPainted(false);
                btnSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                btnExport = new JButton(new ImageIcon("./src/image/export_30px.png"));
                btnExport.setBounds(new Rectangle(640, 20,120,35));
                btnExport.setBackground(null);
                btnExport.setBorderPainted(false);
                btnExport.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btnExport.addActionListener(this);
                
                btnImport = new JButton(new ImageIcon("./src/image/import_30px.png"));
                btnImport.setBounds(new Rectangle(795, 20,120,35));
                btnImport.setBackground(null);
                btnImport.setBorderPainted(false);
                btnImport.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btnImport.addActionListener(this);
                
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
                header.add("Mã sản phẩm");
                header.add("Tên sản phẩm");
                header.add("Đơn giá");
                header.add("Số lượng");
                header.add("Đơn vị tính");
                header.add("Mã Loại");
                header.add("Mã NCC");
                header.add("IMG");
                model = new DefaultTableModel(header,0);
                
                table = new JTable(model);
                TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>(model);
                table.setRowSorter(rowSorter);
                
                table.getTableHeader().setFont(font0);
                table.getTableHeader().setOpaque(false);
                table.getTableHeader().setBackground(new Color(232,57,99));
                table.getTableHeader().setForeground(new Color(255,255,225));
                //table.setShowVerticalLines(false);   
                table.setSelectionBackground(new Color(32,136,203));
                table.setRowHeight(22);
                table.setFont(font1);
                table.setShowVerticalLines(false);
                table.getColumnModel().getColumn(1).setPreferredWidth(150);
                table.getColumnModel().getColumn(0).setPreferredWidth(80);
                JScrollPane scroll = new JScrollPane(table);
                scroll.setBounds(new Rectangle(100, 70, 810, 340));
                scroll.setBackground(null);
                scroll.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                DanhSachSanPham();
                
                txtSearch.getDocument().addDocumentListener(new DocumentListener(){
                @Override
                public void insertUpdate(DocumentEvent e) {
//                    String text = txtSearch.getText();
//
//                    if (text.trim().length() == 0) {
//                        rowSorter.setRowFilter(null);
//                    } else {
//                        rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
//                    }
                }

                @Override
                public void removeUpdate(DocumentEvent e) { //setModel ban đầu khi txtSearch == null
                    String text = txtSearch.getText();

                    if (text.equals("")) {
                        outModel(model, spBUS.getDssp());
                        rowSorter.setRowFilter(null);       
                    } 

                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

            });
            pMenu_SP.add(lbSearch);
            pMenu_SP.add(txtSearch);
            //pMenu_SP.add(iconSearch);
            pMenu_SP.add(btnSearch);
             pMenu_SP.add(btnExport);
              pMenu_SP.add(btnImport);
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
                txtMasp.setText(table.getModel().getValueAt(i, 0).toString());
                txtTensp.setText(table.getModel().getValueAt(i, 1).toString());
                txtDongia.setText(table.getModel().getValueAt(i, 2).toString());
                txtSl.setText(table.getModel().getValueAt(i, 3).toString());
                txtDvt.setText(table.getModel().getValueAt(i, 4).toString());              
                txtTenloai.setText(setTxtTenLoai(table.getModel().getValueAt(i, 5).toString()));
                txtTenncc.setText(setTxtTenNCC(table.getModel().getValueAt(i, 6).toString()));
                
                imgName =  table.getModel().getValueAt(i, 7).toString();
                Image newImage = new ImageIcon("./src/image/image_SanPham/"+imgName).getImage().getScaledInstance(200, 230, Image.SCALE_DEFAULT);
                lbImage.setIcon(new ImageIcon(newImage));
                
                
            }
        });
    }
    public int getData()
    {
        int i = table.getSelectedRow();

        return i;
    }
    public void outModel(DefaultTableModel model , ArrayList<SanPhamDTO> dssp) // Xuất ra Table từ ArrayList
    { 
       Vector data;
       model.setRowCount(0);
//       DecimalFormat formatter = new DecimalFormat("###,###,###.##");
        for(SanPhamDTO s: dssp)
        {
            data = new Vector();
            data.add(s.getMasp());
            data.add(s.getTensp());
            data.add(s.getDongia());
            data.add(s.getSl());
            data.add(s.getDvt());
            data.add(s.getMaloai());
            data.add(s.getMancc());
            data.add(s.getImage());
            model.addRow(data);
        }
        table.setModel(model);
    }
    public void DanhSachSanPham() //Load DanhSachSanPham lên table
    {
        
            spBUS.DanhSachSanPham();
            ArrayList<SanPhamDTO> dssp = spBUS.getDssp(); //get Data 
            model.setRowCount(0);
            outModel(model, dssp);  
       
          
    }
    public void Search(String masp)
    {
        ArrayList<SanPhamDTO> searchSP = new ArrayList<>(); //Tạo Arraylist add Object select để load model
        SanPhamDTO search = spBUS.Search(masp); //Object Select
        if(search != null)
        {
            searchSP.add(search);
            outModel(model, searchSP); //Table filter ra Object Select những ko ảnh hưởng tới dssp ban đầu
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Không có sản phẩm "+txtSearch.getText()+" trong danh sách");
        }
             
    }
   public void SearchTen(String tensp)
   {
        ArrayList<SanPhamDTO> searchSP = new ArrayList<>(); //Tạo Arraylist add Object select để load model
        SanPhamDTO search = spBUS.SearchTensp(tensp); //Object Select
       if(search.getTensp().contains(tensp))
        {
            searchSP.add(search);
            outModel(model, searchSP); //Table filter ra Object Select những ko ảnh hưởng tới dssp ban đầu
        }

           
      
   }
    public void Clean()
    {
        txtMasp.setText("");
        txtTensp.setText("");
        txtSl.setText("");
        txtDongia.setText("");
        txtDvt.setText("");
        txtTenloai.setText("");
        txtTenncc.setText("");
    }
    public String setTxtTenLoai(String maloai) //Load dsncc đồng thời setTextField TenLoai khi click lên table
    {

        ArrayList<LoaiSpDTO> dsloaisp = loaiBUS.getDSLSP(); //load dsncc
        for(LoaiSpDTO loai: dsloaisp)
        {
            if(loai.getMaloai().equals(maloai)) //Click vào table có Mã Loại -> Tên loại để setText Tenloai
            {
                return loai.getTenloai();  
            }
        }

        return null;  
    }
    public String setTxtTenNCC(String mancc)
    {
        ArrayList<NhaCungCapDTO> dsncc = nccBUS.getDsncc();
        for(NhaCungCapDTO ncc: dsncc)
        {
            if(ncc.getMancc().equals(mancc))
            {
                return ncc.getTenncc();
            }
        }
        return null;  
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnExport)
        {
            spBUS.Export();
            JOptionPane.showMessageDialog(null,"Xuất file Exel thành công !!!");
        }
        if(e.getSource() == btnImport)
        {
            JFileChooser fc = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel", "xlsx");
            fc.setFileFilter(filter);
            int result = fc.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) 
            {
                File file = fc.getSelectedFile(); //Lấy URL
                spBUS.Import(file);
                spBUS.DanhSachSanPham();
                outModel(model, spBUS.getDssp());
                JOptionPane.showMessageDialog(null, "Nhap file excel thanh cong");
            }
        }
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
            
}
