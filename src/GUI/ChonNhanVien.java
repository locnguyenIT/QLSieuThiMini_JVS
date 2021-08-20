/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.KhachHangBUS;
import BUS.NhanVienBUS;
import DTO.NhanVienDTO;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
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
public class ChonNhanVien extends JDialog{
    private JTextField  txtSearch;
    private JLabel lbImage, lbSearch,iconSearch;
    private JButton btnConfirm, btnCancel;
    private JTable table;
    private JScrollPane scroll;
    private DefaultTableModel model;
    private ArrayList<String> data = new ArrayList<>();
    private NhanVienBUS nvBUS = new NhanVienBUS();
    private JPanel pChonNV;
    private String imgName = null;
    public ChonNhanVien()
    {
        nvBUS.DanhSachNhanVien();
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
        setTitle("CHỌN NHÂN VIÊN");
        setBackground(Color.WHITE);
        
        //Panel_Center
        pChonNV = new JPanel(null);
        pChonNV.setBounds(new Rectangle(0,0,950,700));
        pChonNV.setBackground(Color.WHITE);
                
                lbImage = new JLabel("IMG");
                lbImage.setBounds(new Rectangle(30, 60, 200, 230));
                lbImage.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                lbImage.setHorizontalAlignment(JLabel.CENTER);
                
                lbSearch = new JLabel("Tìm kiếm");
                lbSearch.setBounds(new Rectangle(350, 15,80, 30));
                lbSearch.setFont(font1);
                
                txtSearch = new JTextField("Nhập mã nhân viên");
                txtSearch.setBounds(new Rectangle(420, 15,200, 30));
                txtSearch.setFont(fontSeacrh);
                
                iconSearch = new JLabel(new ImageIcon("./src/image/search_26px.png"));
                iconSearch.setBounds(new Rectangle(630, 15, 50,30));
                iconSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                btnConfirm = new JButton(new ImageIcon("./src/image/btnConfirm_25px.png"));
                btnConfirm.setBounds(new Rectangle(30,375,115,35));
                btnConfirm.setBackground(null);
                btnConfirm.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                btnCancel  = new JButton(new ImageIcon("./src/image/btnCancel_25px.png"));
                btnCancel.setBounds(new Rectangle(190,375,116,35));
                btnCancel.setBackground(null);
                btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        
                Vector header = new Vector();
                header.add("Mã NV");
                header.add("Họ");
                header.add("Tên");
                header.add("Giới tính");
                header.add("SĐT");
                header.add("IMG");
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

                table.getColumnModel().getColumn(2).setPreferredWidth(100);
                scroll = new JScrollPane(table);
                scroll.setBounds(new Rectangle(350, 60,550, 350));
                scroll.setBackground(null);
                scroll.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                
                outModel(model, nvBUS.getDsnv());// Out dsnv
                
                 table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e)
            {
                int i = table.getSelectedRow();
                //System.out.println(i);
                imgName =  table.getModel().getValueAt(i, 5).toString();
                Image newImage = new ImageIcon("./src/image/NhanVien/"+imgName).getImage().getScaledInstance(200, 230, Image.SCALE_DEFAULT);
                
                lbImage.setText("");
                lbImage.setIcon(new ImageIcon(newImage));
  
            }
            });
                
                
                
                btnConfirm.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
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
                
            pChonNV.add(lbImage);
            pChonNV.add(lbSearch);
            pChonNV.add(txtSearch);
            pChonNV.add(iconSearch);
            pChonNV.add(btnConfirm);
            pChonNV.add(btnCancel);
            pChonNV.add(scroll);
                
        add(pChonNV);
        setLocationRelativeTo(null);
        setVisible(true);    
    }
     public void outModel(DefaultTableModel model , ArrayList<NhanVienDTO> dsnv) // Xuất ra Table từ ArrayList
    { 
       Vector data;
       model.setRowCount(0);
        for(NhanVienDTO nv: dsnv)
        {
            data = new Vector();
            data.add(nv.getManv());
            data.add(nv.getHonv());
            data.add(nv.getTennv());
            data.add(nv.getGioitinh());
            data.add(nv.getSdt());
            data.add(nv.getImage());
            model.addRow(data);
        }
        table.setModel(model);
    }
     public ArrayList<String> getDulieu()
    {
        return data;
    }
}
