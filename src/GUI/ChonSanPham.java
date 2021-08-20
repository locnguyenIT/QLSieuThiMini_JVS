/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.LoaiSpBUS;
import BUS.SanPhamBUS;
import DTO.LoaiSpDTO;
import DTO.SanPhamDTO;
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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Enumeration;
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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ntloc
 */
public class ChonSanPham extends JDialog implements ActionListener{
    
    private JPanel pChonSP;
    private JLabel lbThongtin, lbMasp, lbTensp, lbSl, lbDongia, lbDvt,lbLoai, lbSearch,iconSearch;
    private JTextField txtMasp, txtTensp, txtSl, txtDongia, txtDvt, txtLoai, txtSearch;
    private JButton btnConfirm, btnCancel;
    private JLabel lbImage;
    private DefaultTableModel model;
    private JTable table;
    private JScrollPane scroll;
    private String imgName = null;
    private SanPhamBUS spBUS = new SanPhamBUS();
    private ArrayList<String> data = new ArrayList<>();
    public ChonSanPham()
    {
        spBUS.DanhSachSanPham();
        setModal(true);
        Init();
    }
    public void Init()
    {
        Font font0 = new Font("Segoe UI",Font.BOLD,13);
        Font font1 = new Font("Segoe UI",Font.PLAIN,13);
        Font fontSeacrh = new Font("Segoe UI",Font.ITALIC,12);
        setSize(950,500);
        setLayout(null);
        setTitle("CHỌN SẢN PHẨM");
        setBackground(Color.WHITE);
        
        //Panel_Center
        pChonSP = new JPanel(null);
        pChonSP.setBounds(new Rectangle(0,0,950,700));
        pChonSP.setBackground(Color.WHITE);
        
                lbThongtin = new JLabel("Thông tin Sản Phẩm");
                lbThongtin.setBounds(new Rectangle(90, 15,150,30));
                lbThongtin.setFont(font1);
                
                lbImage = new JLabel("IMG",JLabel.CENTER);
                lbImage.setBounds(new Rectangle(30, 60, 200, 230));
                lbImage.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                lbImage.setFont(font1);
                
                lbMasp = new JLabel("Mã sản phẩm ");
                lbMasp.setBounds(new Rectangle(30,60,100,30));
                lbMasp.setFont(font1);
                txtMasp = new JTextField("");
                txtMasp.setBounds(new Rectangle(150,60,150,30));
                txtMasp.setFont(font1);

                lbTensp = new JLabel("Tên sản phẩm ");
                lbTensp.setBounds(new Rectangle(30, 100,100,30));
                lbTensp.setFont(font1);
                txtTensp = new JTextField("");
                txtTensp.setBounds(new Rectangle(150,100,150,30));
                txtTensp.setFont(font1);

                lbDongia = new JLabel("Đơn giá");
                lbDongia.setBounds(new Rectangle(30, 140, 100, 30));
                lbDongia.setFont(font1);
                txtDongia = new JTextField("");
                txtDongia.setBounds(new Rectangle(150,140,150,30));
                txtDongia.setFont(font1);

                lbSl = new JLabel("Số lượng");
                lbSl.setBounds(new Rectangle(30,180, 100, 30));
                lbSl.setFont(font1);
                txtSl = new JTextField("");
                txtSl.setBounds(new Rectangle(150,180,150,30));
                txtSl.setFont(font1);

                lbDvt = new JLabel("Đơn vị tính");
                lbDvt.setBounds(new Rectangle(30,220, 150, 30));
                lbDvt.setFont(font1);
                txtDvt = new JTextField("");
                txtDvt.setBounds(new Rectangle(150,220,150,30));
                txtDvt.setBackground(null);
                txtDvt.setFont(font1);

                lbLoai = new JLabel("Loại");
                lbLoai.setBounds(new Rectangle(30, 260, 100, 30));
                lbLoai.setFont(font1);
                txtLoai = new JTextField("");
                txtLoai.setBounds(new Rectangle(150,260,150, 30));
                txtLoai.setFont(font1);

                btnConfirm = new JButton(new ImageIcon("./src/image/btnConfirm_25px.png"));
                btnConfirm.setBounds(new Rectangle(30,375,115,35));
                btnConfirm.setBackground(null);
                btnConfirm.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                btnCancel  = new JButton(new ImageIcon("./src/image/btnCancel_25px.png"));
                btnCancel.setBounds(new Rectangle(160,375,115,35));
                btnCancel.setBackground(null);
                btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));

                lbSearch = new JLabel("Tìm kiếm");
                lbSearch.setBounds(new Rectangle(350, 15,80, 30));
                lbSearch.setFont(font1);
                
                txtSearch = new JTextField("Nhập mã sản phẩm");
                txtSearch.setBounds(new Rectangle(420, 15,200, 30));
                txtSearch.setFont(fontSeacrh);
                
                iconSearch = new JLabel(new ImageIcon("./src/image/search_26px.png"));
                iconSearch.setBounds(new Rectangle(630, 15, 50,30));
                iconSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        
                        
                Vector header = new Vector();
                header.add("Mã sản phẩm");
                header.add("Tên sản phẩm");
                header.add("Đơn giá");
                header.add("Số lượng ");
                header.add("ĐVT");
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
                table.setShowVerticalLines(false);
                table.setFont(font1);
                table.getColumnModel().getColumn(1).setPreferredWidth(150);
                table.getColumnModel().getColumn(0).setPreferredWidth(100);
                scroll = new JScrollPane(table);
                scroll.setBounds(new Rectangle(350, 60,550, 350));
                scroll.setBackground(null);
                scroll.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                
                outModel(model, spBUS.getDssp());
                
            table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e)
            {
                int i = table.getSelectedRow();
                //System.out.println(i);
                if(table.getRowSorter() != null)
                {
                    i = table.getRowSorter().convertRowIndexToModel(i);
                }
                imgName =  table.getModel().getValueAt(i, 5).toString();
                Image newImage = new ImageIcon("./src/image/image_SanPham/"+imgName).getImage().getScaledInstance(200, 230, Image.SCALE_DEFAULT);
                
                lbImage.setText("");
                lbImage.setIcon(new ImageIcon(newImage));
  
            }
            });
                
                
                
                
                
                
                txtSearch.addKeyListener(new KeyAdapter() {
                     public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {   
                        String masp = txtSearch.getText();
                        Search(masp);
                    }
                }
                });
                txtSearch.addMouseListener(new MouseAdapter() {
                     public void mousePressed(MouseEvent e)
                    {
                    txtSearch.setText("");
                    }
                });
                iconSearch.addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e)
                    {
                        String masp = txtSearch.getText();
                        Search(masp);
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
                        outModel(model, spBUS.getDssp());
                        rowSorter.setRowFilter(null);       
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
                    //Tạo ArrayList để lưu Vector
                    Vector vec;
                    vec = model.getDataVector().elementAt(table.getSelectedRow());
                    Enumeration enu = vec.elements();  
                    while(enu.hasMoreElements())
                    {
                        String abc = enu.nextElement().toString();
                        data.add(abc);          
                    }
                    setVisible(false);
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
                });
                
                btnCancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(!table.getSelectionModel().isSelectionEmpty()) //Kiểm tra xem có dòng nào được chọn hay không
                    {
                    //Tạo ArrayList để lưu tạm
                        Vector vec;
                        vec = model.getDataVector().elementAt(table.getSelectedRow());
                        Enumeration enu = vec.elements();
                        while(enu.hasMoreElements())
                        {
                            String abc = enu.nextElement().toString();

                            data.add(abc);
                        }
                        //Sau khi add tạm thì xóa hết phần tử để reset lại ArrayList
                        data.clear();
                        setVisible(false);   
                    }
                    else
                    {
                         setVisible(false);
                    }
                   
                    
                   //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
                });
                
        pChonSP.add(lbImage);        
//        pChonSP.add(lbThongtin);
//        
//        pChonSP.add(lbMasp);
//        pChonSP.add(txtMasp);
//        pChonSP.add(lbTensp);
//        pChonSP.add(txtTensp);
//        pChonSP.add(lbDongia);
//        pChonSP.add(txtDongia);
//        pChonSP.add(lbSl);
//        pChonSP.add(txtSl);
//        pChonSP.add(lbDvt);
//        pChonSP.add(txtDvt);
//        pChonSP.add(lbLoai);
//        pChonSP.add(txtLoai);
        pChonSP.add(btnConfirm);
        pChonSP.add(btnCancel);
        pChonSP.add(lbSearch);
        pChonSP.add(txtSearch);
        pChonSP.add(iconSearch);
        pChonSP.add(scroll);
        add(pChonSP);
        setLocationRelativeTo(null);
        setVisible(true);
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
    public void outModel(DefaultTableModel model , ArrayList<SanPhamDTO> dssp) // Xuất ra Table từ ArrayList
    { 
       Vector data;
       model.setRowCount(0);
      DecimalFormat formatter = new DecimalFormat("###,###,###.##");
        for(SanPhamDTO s: dssp)
        {
            data = new Vector();
            data.add(s.getMasp());
            data.add(s.getTensp());
            data.add(formatter.format(s.getDongia()));
            data.add(s.getSl());
            data.add(s.getDvt());
            data.add(s.getImage());
            model.addRow(data);
        }
        table.setModel(model);
    }
    public ArrayList<String> getDulieu()
    {
        return data;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
