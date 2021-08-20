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
public class NhaCungCapGUI extends JPanel{
     private int DEFAULT_WIDTH;
    private int DEFAULT_HEIGH;
    private JPanel pInfo;
    private JLabel lbMancc, lbTenncc, lbDiachi, lbMst, lbFax, lbSearch;
    private JTextField txtMancc, txtTenncc, txtDiachi,txtMst, txtFax, txtSearch;
    private JButton btnAdd, btnDelete, btnFix, btnReset,btnSearch ,btnLuu,btnCancel;
    private DefaultTableModel model;
    private JTable table;
    private NhaCungCapBUS nccBUS = new NhaCungCapBUS();
    public NhaCungCapGUI(){}
    
    public NhaCungCapGUI(int WIDTH, int HEIGH)
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
            pInfo.setBounds(new Rectangle(50,10,950,200));
            pInfo.setBackground(Color.WHITE);
                lbMancc = new JLabel("Mã NCC");
                lbMancc.setBounds(new Rectangle(50,30,50,30));
                lbMancc.setFont(fontB);
                txtMancc = new JTextField("");
                txtMancc.setBounds(new Rectangle(110,30,200,30));
                txtMancc.setFont(fontP);
                txtMancc.setEnabled(false);
                
                lbTenncc = new JLabel("Tên");
                lbTenncc.setBounds(new Rectangle(350,30,50,30));
                lbTenncc.setFont(fontB);
                txtTenncc = new JTextField("");
                txtTenncc.setBounds(new Rectangle(410,30,200,30));
                txtTenncc.setFont(fontP);
                txtTenncc.setEnabled(false);
                
                lbMst = new JLabel("MST");
                lbMst.setBounds(new Rectangle(50,80,50,30));
                lbMst.setFont(fontB);
                txtMst = new JTextField("");
                txtMst.setBounds(new Rectangle(110,80,200,30));
                txtMst.setFont(fontP);
                txtMst.setEnabled(false);
                
                lbFax = new JLabel("FAX");
                lbFax.setBounds(new Rectangle(350,80,50,30));
                lbFax.setFont(fontB);
                txtFax = new JTextField("");
                txtFax.setBounds(new Rectangle(410,80,200,30));
                txtFax.setFont(fontP);
                txtFax.setEnabled(false);
                
                lbDiachi = new JLabel("Địa chỉ");
                lbDiachi.setBounds(new Rectangle(50,130,50,30));
                lbDiachi.setFont(fontB);
                txtDiachi = new JTextField("");
                txtDiachi.setBounds(new Rectangle(110,130,500,30));
                txtDiachi.setFont(fontP);
                txtDiachi.setEnabled(false);

                btnAdd = new JButton(new ImageIcon("./src/image/btnAdd.png"));
                btnAdd.setBounds(new Rectangle(680, 30,115,34));
                btnAdd.setBackground(null);
                btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));

                
                btnDelete = new JButton(new ImageIcon("./src/image/btnDelete.png"));
                btnDelete.setBounds(new Rectangle(820,30, 114,34));
                btnDelete.setBackground(null);
                btnDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                btnFix = new JButton(new ImageIcon("./src/image/btnFix.png"));
                btnFix.setBounds(new Rectangle(680,70, 114,34));
                btnFix.setBackground(null);
                btnFix.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                btnReset = new JButton(new ImageIcon("./src/image/btnReset.png"));
                btnReset.setBounds(new Rectangle(820,70, 114,34));
                btnReset.setBackground(null);
                btnReset.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                btnLuu = new JButton(new ImageIcon("./src/image/btnSave_30px.png"));
                btnLuu.setBounds(new Rectangle(680, 30, 115,35));
                btnLuu.setBackground(null);
                btnLuu.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btnLuu.setVisible(false);
                
                btnCancel = new JButton(new ImageIcon("./src/image/btnCancel_30px.png"));
                btnCancel.setBounds(new Rectangle(820,30, 116,35));
                btnCancel.setBackground(null);
                btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btnCancel.setVisible(false);
                
            pInfo.add(lbMancc);
            pInfo.add(txtMancc);
            pInfo.add(lbTenncc);
            pInfo.add(txtTenncc);
            pInfo.add(lbMst);
            pInfo.add(txtMst);
            pInfo.add(lbFax);
            pInfo.add(txtFax);
            pInfo.add(lbDiachi);
            pInfo.add(txtDiachi);
            pInfo.add(btnAdd);
            pInfo.add(btnDelete);
            pInfo.add(btnFix);
            pInfo.add(btnReset);
            pInfo.add(btnLuu);
            pInfo.add(btnCancel);
            
                lbSearch = new JLabel("Tìm kiếm");
                lbSearch.setBounds(new Rectangle(100,230,80,30));
                lbSearch.setFont(fontB);
                txtSearch = new JTextField("Tìm nhà cung cấp");
                txtSearch.setBounds(new Rectangle(190,230,150,30));
                txtSearch.setFont(fontSeacrh);
            
                btnSearch = new JButton(new ImageIcon("./src/image/search_26px.png"));
                btnSearch.setBounds(new Rectangle(350, 230,35,30));
                btnSearch.setBackground(null);
                btnSearch.setBorderPainted(false);
                btnSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                Vector header = new Vector();
                header.add("Mã NCC");
                header.add("Tên");
                header.add("Địa chỉ");
                header.add("MST");
                header.add("FAX");
               
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
                table.getColumnModel().getColumn(2).setPreferredWidth(200);
                JScrollPane scroll = new JScrollPane(table);
                scroll.setBounds(new Rectangle(100,280,880, 380));
                scroll.setBackground(null);
                scroll.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(pInfo);
        add(scroll);
        add(lbSearch);
        add(txtSearch);
        add(btnSearch);
        DanhSachNhaCungCap();
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
                txtMancc.setText(table.getModel().getValueAt(i, 0).toString());
                txtTenncc.setText(table.getModel().getValueAt(i, 1).toString());
                txtDiachi.setText(table.getModel().getValueAt(i, 2).toString());
                txtMst.setText(table.getModel().getValueAt(i, 3).toString());
                txtFax.setText(table.getModel().getValueAt(i, 4).toString());              
            }
        });
         
        //--------------------------Thêm KH--------------------------// 
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ThemNhacCungCap themNCC = new ThemNhacCungCap();
                DanhSachNhaCungCap();
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        //--------------------------Xóa KH--------------------------------//
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mancc = txtMancc.getText();
                if(mancc.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Vui lòng chọn nhà cung cấp cần xóa");
                    return;
                }
                else
                {
                    int  option = JOptionPane.showConfirmDialog(null,"Xác nhận xóa" ,"Xóa nhà cung cấp",JOptionPane.YES_NO_OPTION);
                    if(option == 0)
                    {
                        nccBUS.Delete(mancc);
                        table.clearSelection();
                        DanhSachNhaCungCap();
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
                    if(txtMancc.getText().equals(""))
                    {
                        JOptionPane.showMessageDialog(null,"Vui lòng chọn nhà cung cấp cần sửa");
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
                String mancc = txtMancc.getText();
                String tenncc = txtTenncc.getText();
                String diachi = txtDiachi.getText();
                String mst = txtMst.getText();
                String fax = txtFax.getText();
                
                NhaCungCapDTO ncc = new NhaCungCapDTO(mancc, tenncc, diachi, mst,fax);
                nccBUS.Set(ncc);
                JOptionPane.showMessageDialog(null,"Sửa thành công !!!");
                btnAdd.setVisible(true);
                btnDelete.setVisible(true);
                btnFix.setVisible(true);
                btnReset.setVisible(true);
                btnLuu.setVisible(false);
                btnCancel.setVisible(false);
                Clean();
                Block();
                DanhSachNhaCungCap();
                
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
                    String mancc = txtSearch.getText();
                    Search(mancc);
                        //SearchTen(tensp);
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
                });
                txtSearch.addKeyListener(new KeyAdapter() {
                     public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//                        String tensp =txtSearch.getText();
//                        SearchTen(tensp);
                        String mancc  = txtSearch.getText();
                        Search(mancc);
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
                        outModel(model, nccBUS.getDsncc());      
                    } 

                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

            });
    
        
         
    }
    public void DanhSachNhaCungCap() //Load DanhSachSanPham lên table
    {
        nccBUS.DanhSachNCC();
        ArrayList<NhaCungCapDTO> dsncc = nccBUS.getDsncc(); //get Data 
        model.setRowCount(0);
        outModel(model, dsncc);  
    }
      public void outModel(DefaultTableModel model , ArrayList<NhaCungCapDTO> dsncc) // Xuất ra Table từ ArrayList
    { 
       Vector data;
       model.setRowCount(0);
        for(NhaCungCapDTO s: dsncc)
        {
            data = new Vector();
            data.add(s.getMancc());
            data.add(s.getTenncc());
            data.add(s.getDiachi());
            data.add(s.getMst());
            data.add(s.getFax());
            model.addRow(data);
        }
        table.setModel(model);
    }
    public void Search(String mancc)
    {
        ArrayList<NhaCungCapDTO> search = new ArrayList<>(); //Tạo Arraylist add Object select để load model
        NhaCungCapDTO ncc = nccBUS.SearchNCC(mancc);
        if(ncc != null)
        {
            search.add(ncc);
            outModel(model, search); //Table filter ra Object Select những ko ảnh hưởng tới dssp ban đầu
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Không có nhà cung cấp "+txtSearch.getText()+" trong danh sách");
            txtSearch.setText("");
        }
    }
    public void Clean()
    {
        txtMancc.setText("");
        txtTenncc.setText("");
        txtDiachi.setText("");
        txtMst.setText("");
        txtFax.setText("");
    }
    public void Enable()
    {
        txtTenncc.setEnabled(true);
        txtDiachi.setEnabled(true);
        txtMst.setEnabled(true);
        txtFax.setEnabled(true);
    }
    public void Block()
    {
        txtMancc.setEnabled(false);
        txtTenncc.setEnabled(false);
        txtDiachi.setEnabled(false);
        txtMst.setEnabled(false);
        txtFax.setEnabled(false);
    }
}
