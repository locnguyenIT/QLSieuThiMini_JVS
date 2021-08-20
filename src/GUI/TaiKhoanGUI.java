/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.NguoiDungBUS;
import DTO.NguoiDungDTO;
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
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author ntloc
 */
public class TaiKhoanGUI extends JPanel{
    
    private int DEFAULT_WIDTH;
    private int DEFAULT_HEIGH;
    private JPanel pInfo;
    private JLabel lbId, lbUser,lbPass,lbRole;
    private JTextField txtId, txtUser, txtPass;
    private JComboBox cbbRole;
    private JButton btnAdd, btnDelete, btnFix, btnReset, btnLuu,btnCancel;
    private DefaultTableModel model;
    private JTable table;
    private JScrollPane  scroll;
    private NguoiDungBUS ndBUS = new NguoiDungBUS();
    private boolean  Flag = true;
    public TaiKhoanGUI(){}
    public TaiKhoanGUI(int WIDTH, int HEIGH)
    {
        DEFAULT_WIDTH = WIDTH;
        DEFAULT_HEIGH = HEIGH;
        Init();
    }
    public void Init()
    {
        Font fontB = new Font("Segoe UI",Font.BOLD,13);
        Font fontP = new Font("Segoe UI",Font.PLAIN,13);
        setLayout(null);
        setBounds(new Rectangle(0,0, this.DEFAULT_WIDTH - 230, this.DEFAULT_HEIGH)); //QLST
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBackground(Color.WHITE);
            pInfo = new JPanel(null);
            pInfo.setBounds(new Rectangle(40, 20, 1000, 550));
            pInfo.setBackground(Color.WHITE);
                
                lbId = new JLabel("ID");
                lbId.setBounds(new Rectangle(30,30,50,30));
                lbId.setFont(fontB);
                txtId = new JTextField("");
                txtId.setBounds(new Rectangle(140,30,200,30));
                txtId.setFont(fontP);
                txtId.setEnabled(false);
                
                lbUser = new JLabel("Tên đăng nhập");
                lbUser.setBounds(new Rectangle(30,80,100,30));
                lbUser.setFont(fontB);
                txtUser = new JTextField("");
                txtUser.setBounds(new Rectangle(140,80,200,30));
                txtUser.setFont(fontP);
                txtUser.setEnabled(false);
                
                lbPass = new JLabel("Mật khẩu");
                lbPass.setBounds(new Rectangle(30,130,100,30));
                lbPass.setFont(fontB);
                txtPass = new JTextField("");
                txtPass.setBounds(new Rectangle(140,130,200,30));
                txtPass.setFont(fontP);
                txtPass.setEnabled(false);
                
                lbRole = new JLabel("Quyền");
                lbRole.setBounds(new Rectangle(30,180,100,30));
                lbRole.setFont(fontB);
                
                String[] role ={"---Chọn---","Admin","Staff"};
                cbbRole = new JComboBox<>(role);
                cbbRole.setBounds(new Rectangle(140,180,200,30));
                cbbRole.setFont(fontP);
                cbbRole.setEnabled(false);
                
                btnAdd = new JButton(new ImageIcon("./src/image/btnAdd.png"));
                btnAdd.setBounds(new Rectangle(30,300,115,34));
                btnAdd.setBackground(null);
                btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));

                
                btnDelete = new JButton(new ImageIcon("./src/image/btnDelete.png"));
                btnDelete.setBounds(new Rectangle(220,300, 114,34));
                btnDelete.setBackground(null);
                btnDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                btnFix = new JButton(new ImageIcon("./src/image/btnFix.png"));
                btnFix.setBounds(new Rectangle(30,350, 114,34));
                btnFix.setBackground(null);
                btnFix.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                btnReset = new JButton(new ImageIcon("./src/image/btnReset.png"));
                btnReset.setBounds(new Rectangle(220,350, 114,34));
                btnReset.setBackground(null);
                btnReset.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                btnLuu = new JButton(new ImageIcon("./src/image/btnSave_30px.png"));
                btnLuu.setBounds(new Rectangle(30, 400, 115,35));
                btnLuu.setBackground(null);
                btnLuu.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btnLuu.setVisible(false);
                
                btnCancel = new JButton(new ImageIcon("./src/image/btnCancel_30px.png"));
                btnCancel.setBounds(new Rectangle(220,400, 116,35));
                btnCancel.setBackground(null);
                btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btnCancel.setVisible(false);
                
                Vector header = new Vector();
                header.add("ID");
                header.add("Tên đăng nhập");
                header.add("Mật khẩu");
                header.add("Role");
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
                table.getColumnModel().getColumn(1).setPreferredWidth(100);
                table.getColumnModel().getColumn(2).setPreferredWidth(100);
                scroll = new JScrollPane(table);
                scroll.setBounds(new Rectangle(400, 30,550,355));
                scroll.setBackground(null);
                scroll.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            pInfo.add(lbId);
            pInfo.add(txtId);
            pInfo.add(lbUser);
            pInfo.add(txtUser);
            pInfo.add(lbPass);
            pInfo.add(txtPass);
            pInfo.add(lbRole);
            pInfo.add(cbbRole);
            pInfo.add(btnAdd);
            pInfo.add(btnDelete);
            pInfo.add(btnFix);
            pInfo.add(btnReset);
            pInfo.add(btnLuu);
            pInfo.add(btnCancel);
            pInfo.add(scroll);
        add(pInfo);
        DanhSachNguoiDung();
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
                txtId.setText(table.getModel().getValueAt(i, 0).toString());
                txtUser.setText(table.getModel().getValueAt(i, 1).toString());
                txtPass.setText(table.getModel().getValueAt(i, 2).toString());
                cbbRole.setSelectedItem(table.getModel().getValueAt(i, 3).toString());
                
            }
        });
         
        //--------------------------Thêm KH--------------------------// 
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Flag = true;
                btnAdd.setVisible(false);
                btnDelete.setVisible(false);
                btnFix.setVisible(false);
                btnReset.setVisible(false);
                btnLuu.setVisible(true);
                btnCancel.setVisible(true);
                Enable();
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        //--------------------------Xóa KH--------------------------------//
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String manv = txtId.getText();
                if(manv.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Vui lòng chọn tài khoản  cần xóa");
                    return;
                }
                else
                {
                    int  option = JOptionPane.showConfirmDialog(null,"Xác nhận xóa" ,"Xóa tài khoản ",JOptionPane.YES_NO_OPTION);
                    if(option == 0)
                    {
                        ndBUS.Delete(manv);
                        table.clearSelection();
                        DanhSachNguoiDung();
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
                    if(txtId.getText().equals(""))
                    {
                        JOptionPane.showMessageDialog(null,"Vui lòng chọn tài khoản cần sửa");
                        return;
                    }
                    else
                    {
                        Flag = false;
                        btnAdd.setVisible(false);
                        btnDelete.setVisible(false);
                        btnFix.setVisible(false);
                        btnReset.setVisible(false);
                        btnLuu.setVisible(true);
                        btnCancel.setVisible(true);
                        txtId.setEnabled(false);
                        Enable();
                    }
                       
                       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
            
            btnLuu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = txtId.getText();
                String user = txtUser.getText();
                String pass = txtPass.getText();
                String role = cbbRole.getSelectedItem().toString();
                NguoiDungDTO nd = new NguoiDungDTO(id, user, pass, role);
                if(Flag == true)
                {
                    ndBUS.Add(nd);
                    JOptionPane.showMessageDialog(null,"Thêm thành công !!!");
                    btnAdd.setVisible(true);
                    btnDelete.setVisible(true);
                    btnFix.setVisible(true);
                    btnReset.setVisible(true);
                    btnLuu.setVisible(false);
                    btnCancel.setVisible(false);
                    Clean();
                    Block();
                    DanhSachNguoiDung();
                }
                else 
                {
                    ndBUS.Set(nd);
                    JOptionPane.showMessageDialog(null,"Sửa thành công !!!");
                    btnAdd.setVisible(true);
                    btnDelete.setVisible(true);
                    btnFix.setVisible(true);
                    btnReset.setVisible(true);
                    btnLuu.setVisible(false);
                    btnCancel.setVisible(false);
                    Clean();
                    Block();
                    DanhSachNguoiDung();
                }
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
  
    }
     public void DanhSachNguoiDung() //Load DanhSachSanPham lên table
    {
        ndBUS.DanhSachNguoiDung();
        ArrayList<NguoiDungDTO> dskh = ndBUS.getDsnd(); //get Data 
        model.setRowCount(0);
        outModel(model, dskh);  
    }
      public void outModel(DefaultTableModel model , ArrayList<NguoiDungDTO> dsnd) // Xuất ra Table từ ArrayList
    { 
       Vector data;
       model.setRowCount(0);
        for(NguoiDungDTO s: dsnd)
        {
            data = new Vector();
            data.add(s.getId());
            data.add(s.getUsername());
            data.add(s.getPassword());
            data.add(s.getRole());
           
            model.addRow(data);
        }
        table.setModel(model);
    }
   
    public void Clean()
    {
        txtId.setText("");
        txtUser.setText("");
        txtPass.setText("");
        cbbRole.setSelectedIndex(0);
    }
    public void Enable()
    {
        txtUser.setEnabled(true);
        txtPass.setEnabled(true);
        cbbRole.setEnabled(true);
    }
    public void Block()
    {
       txtId.setEnabled(false);
       txtUser.setEnabled(false);
       txtPass.setEnabled(false);
       cbbRole.setEnabled(false);

    }
    
}
