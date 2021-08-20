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
public class ChonNhaCungCap extends JDialog{
    private JLabel lbThongtin, lbMancc,lbTenncc, lbDiachi, lbMst,lbFax, lbSearch,lbIconSearch;
    private JTextField txtMancc,txtTenncc,txtDiachi, txtMst,txtFax, txtSearch;
    private JButton btnConfirm, btnCancel;
    private JTable table;
    private JScrollPane scroll;
    private NhaCungCapBUS nccBUS = new NhaCungCapBUS();
    private JPanel pChonKH;
    private DefaultTableModel model;
    private ArrayList<String> data = new ArrayList<>();
    public ChonNhaCungCap() 
    {
        setModal(true);
        nccBUS.DanhSachNCC();
        Init();
    }
    
    public void Init()
    {
        Font font0 = new Font("Segoe UI",Font.BOLD,13);
        Font font1 = new Font("Segoe UI",Font.PLAIN,13);
        Font fontSeacrh = new Font("Segoe UI",Font.ITALIC,12);
        setSize(1050,500);
        setLayout(null);
        setTitle("CHỌN NHÀ CUNG CẤP");
        setBackground(Color.WHITE);
        
            pChonKH = new JPanel(null);
            pChonKH.setBounds(new Rectangle(0,0, 1050,500));
            pChonKH.setBackground(Color.WHITE);
                
                lbThongtin = new JLabel("Thông tin Nhà cung cấp");
                lbThongtin.setBounds(new Rectangle(90, 15,150,30));
                lbThongtin.setFont(font1);

                lbMancc = new JLabel("Mã NCC ");
                lbMancc.setBounds(new Rectangle(30,60,100,30));
                lbMancc.setFont(font1);
                txtMancc = new JTextField("");
                txtMancc.setBounds(new Rectangle(100,60,200,30));
                txtMancc.setFont(font1);
                txtMancc.setEnabled(false);
                
                lbTenncc = new JLabel("Tên NCC ");
                lbTenncc.setBounds(new Rectangle(30, 100,100,30));
                lbTenncc.setFont(font1);
                txtTenncc = new JTextField("");
                txtTenncc.setBounds(new Rectangle(100,100,200,30));
                txtTenncc.setFont(font1);
                txtTenncc.setEnabled(false);

                lbDiachi = new JLabel("Địa chỉ");
                lbDiachi.setBounds(new Rectangle(30, 140, 100, 30));
                lbDiachi.setFont(font1);
                txtDiachi = new JTextField("");
                txtDiachi.setBounds(new Rectangle(100,140,200,30));
                txtDiachi.setFont(font1);
                txtDiachi.setEnabled(false);

                lbMst = new JLabel("Mã số thuế");
                lbMst.setBounds(new Rectangle(30,180,100, 30));
                lbMst.setFont(font1);
                txtMst = new JTextField("");
                txtMst.setBounds(new Rectangle(100,180,200,30));
                txtMst.setFont(font1);
                txtMst.setEnabled(false);
                
                lbFax = new JLabel("Fax");
                lbFax.setBounds(new Rectangle(30,220, 150, 30));
                lbFax.setFont(font1);
                txtFax = new JTextField("");
                txtFax.setBounds(new Rectangle(100,220,200,30));
                txtFax.setFont(font1);
                txtFax.setEnabled(false);

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

                txtSearch = new JTextField("Nhập Mã nhà cung cấp");
                txtSearch.setBounds(new Rectangle(420, 15,200, 30));
                txtSearch.setFont(fontSeacrh);

                lbIconSearch = new JLabel(new ImageIcon("./src/image/search_26px.png"));
                lbIconSearch.setBounds(new Rectangle(620, 15, 50,30));
                lbIconSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                Vector header = new Vector();
                header.add("Mã NCC");
                header.add("Tên NCC");
                header.add("Địa chỉ");
                header.add("MST");
                header.add("Fax");
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
                table.getColumnModel().getColumn(0).setPreferredWidth(30);
                table.getColumnModel().getColumn(1).setPreferredWidth(100);
                table.getColumnModel().getColumn(2).setPreferredWidth(200);
                scroll = new JScrollPane(table);
                scroll.setBounds(new Rectangle(350, 60,650, 350));
                scroll.setBackground(null);
                scroll.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                
                outModel(model, nccBUS.getDsncc());
                
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
                        outModel(model, nccBUS.getDsncc());
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
                    setVisible(false);
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
                });
                btnCancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {   
                    txtMancc.setText("");
                    setVisible(false);
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
                });

            pChonKH.add(lbThongtin);    
            pChonKH.add(lbMancc);
            pChonKH.add(txtMancc);
            pChonKH.add(lbTenncc);
            pChonKH.add(txtTenncc);
            pChonKH.add(lbDiachi);
            pChonKH.add(txtDiachi);
            pChonKH.add(lbMst);
            pChonKH.add(txtMst);
            pChonKH.add(lbFax);
            pChonKH.add(txtFax);
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
    public void outModel(DefaultTableModel model , ArrayList<NhaCungCapDTO> dskh) // Xuất ra Table từ ArrayList
    { 
       Vector data;
       model.setRowCount(0);
        for(NhaCungCapDTO kh: dskh)
        {
            data = new Vector();
            data.add(kh.getMancc());
            data.add(kh.getTenncc());
            data.add(kh.getDiachi());
            data.add(kh.getMst());
            data.add(kh.getFax());
            model.addRow(data);
        }
        table.setModel(model);
    }
    public void Search(String mancc)
    {
        ArrayList<NhaCungCapDTO> searchNCC = new ArrayList<>(); //Tạo Arraylist add Object select để load model
        NhaCungCapDTO search = nccBUS.SearchNCC(mancc); //Object Select
       if(search != null)
        {
            searchNCC .add(search);
            outModel(model, searchNCC ); //Table filter ra Object Select những ko ảnh hưởng tới dssp ban đầu
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Không có sản phẩm "+txtSearch.getText()+" trong danh sách");
            txtSearch.setText("");
        }
    }
    public String getData()
    {
        return txtMancc.getText();
    }
}
