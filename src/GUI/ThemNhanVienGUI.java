/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.NhanVienBUS;
import BUS.SanPhamBUS;
import DTO.NhanVienDTO;
import DTO.SanPhamDTO;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author ntloc
 */
public class ThemNhanVienGUI extends JDialog{
     
   
    private JPanel pAdd;
    private JLabel lbImage, lbManv, lbHonv,lbTennv, lbDiachi, lbSdt, lbGioitinh, lbNamsinh;
    private String imgName = "null";
    private JTextField txtManv, txtHonv, txtTennv,txtDiachi,txtSdt;
    private JComboBox cbbGioitinh,cbbNamsinh;
    private JButton btnChoose, btnSave, btnCancel;
    private BufferedImage i = null;//Hình ảnh chọn từ file
    private NhanVienBUS nvBUS = new NhanVienBUS();
    public ThemNhanVienGUI()
    {
        setModal(true);
        nvBUS.DanhSachNhanVien();
        Init();
    }
    public void Init()
    {
        Font font0 = new Font("Segoe UI",Font.BOLD,13);
        Font font1 = new Font("Segoe UI",Font.PLAIN,13);
        setSize(720,500);
        setLayout(null);
        setTitle("THÊM NHÂN VIÊN");
        setBackground(Color.WHITE);
        
        pAdd = new JPanel(null);
        pAdd.setBounds(0,0,720,500);
        pAdd.setBackground(Color.WHITE);
        
            lbManv = new JLabel("Mã NV");
            lbManv.setBounds(new Rectangle(30, 30,100,30));
            lbManv.setFont(font0);
            txtManv = new JTextField("");
            txtManv.setBounds(new Rectangle(130, 30,150,30));
            txtManv.setFont(font1);
            txtManv.setText(nvBUS.NextManv());
            txtManv.setEnabled(false);
            
            lbHonv = new JLabel("Họ");
            lbHonv.setBounds(new Rectangle(30, 70, 100,30));
            lbHonv.setFont(font0);
            txtHonv = new JTextField("");
            txtHonv.setBounds(new Rectangle(130,70,150,30));
            txtHonv.setFont(font1);
            
            lbTennv = new JLabel("Tên");
            lbTennv.setBounds(new Rectangle( 30, 110, 100,30));
            lbTennv.setFont(font0);
            txtTennv = new JTextField("");
            txtTennv.setBounds(new Rectangle(130,110,150,30));
            txtTennv.setFont(font1);
           
            lbDiachi = new JLabel("Địa chỉ");
            lbDiachi.setBounds(new Rectangle(30, 150, 100,30));
            lbDiachi.setFont(font0);
            txtDiachi = new JTextField("");
            txtDiachi.setBounds(new Rectangle(130,150,150,30));
            txtDiachi.setFont(font1);
            
            lbSdt = new JLabel("SĐT");
            lbSdt.setBounds(new Rectangle(30, 190, 100,30));
            lbSdt.setFont(font0);
            txtSdt = new JTextField("");
            txtSdt.setBounds(new Rectangle(130,190,150,30));
            txtSdt.setBackground(null);
            txtSdt.setFont(font1);
            
            lbGioitinh = new JLabel("Giới tính");
            lbGioitinh.setBounds(new Rectangle(30,230,150,30));
            lbGioitinh.setBackground(null);
            lbGioitinh.setFont(font0);       
            String[] gioitinh ={"--Chọn--","Nam", "Nữ"};
            cbbGioitinh = new JComboBox(gioitinh);
            cbbGioitinh.setBounds(new Rectangle(130,230,150,30));
            cbbGioitinh.setBackground(null);
            cbbGioitinh.setFont(font1);
            
            lbNamsinh = new JLabel("Năm sinh");
            lbNamsinh.setBounds(new Rectangle(30, 270, 100,30));
            lbNamsinh.setFont(font0);
            ArrayList<Integer> year = new ArrayList<>();
            for(int i= 1970; i<= Calendar.getInstance().get(Calendar.YEAR); i++)
            {
                year.add(i);
            }
            cbbNamsinh = new JComboBox(year.toArray());
            cbbNamsinh .setBounds(new Rectangle(130,270,150,30));
            cbbNamsinh .setBackground(null);
            cbbNamsinh .setFont(font1);
            
            lbImage = new JLabel("IMG",JLabel.CENTER);
            lbImage.setBounds(new Rectangle(400, 30, 200, 230));
            //lbImage.setHorizontalAlignment(JLabel.CENTER);
            lbImage.setBackground(null);
            lbImage.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            
            btnChoose = new JButton("Chọn");
            btnChoose.setBounds(new Rectangle(400, 270,80,30));
            btnChoose.setBackground(null);
            btnChoose.setCursor(new Cursor(Cursor.HAND_CURSOR));
             
            btnSave = new JButton(new ImageIcon("./src/image/btnSave_30px.png"));
            btnSave.setBounds(new Rectangle(400, 400,115, 35));
            btnSave.setBackground(null);
            btnSave.setCursor(new Cursor(Cursor.HAND_CURSOR));
            
            btnCancel = new JButton(new ImageIcon("./src/image/btnCancel_30px.png"));
            btnCancel.setBounds(new Rectangle(530,400,116, 35));
            btnCancel.setBackground(null);
            btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            
            btnChoose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                JFileChooser fc = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & PNG images", "jpg", "png");
                fc.setFileFilter(filter);
                int result = fc.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) 
                {
                    try {
                        File file = fc.getSelectedFile(); //Lấy URL hình
                        i = ImageIO.read(file); // Lấy hình
                        imgName = txtManv.getText().concat(".png"); //Tên hình
                        
                        // Thay đổi hình hiển thị
                        lbImage.setIcon(new ImageIcon(i.getScaledInstance(200, 230, Image.SCALE_DEFAULT)));
                        
//                        revalidate();
//                        repaint();
                    } catch (IOException ex) {
                        Logger.getLogger(SanPhamGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            });
            
            
            btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String manv = txtManv.getText();
                String honv = txtHonv.getText();
                String tennv = txtTennv.getText();
                String diachi = txtDiachi.getText();
                String sdt = txtSdt.getText();
                String gioitinh = cbbGioitinh.getSelectedItem().toString();
                int namsinh = (int)cbbNamsinh.getSelectedItem();
               
//                for(int i =0;i <dssp.size();i++)
//                {
//                    System.out.println("aaa "+dssp.get(i));
//                }
//                if(spBUS.Check(masp))
//                {
//                    JOptionPane.showMessageDialog(null,"Mã sản phẩm "+masp+"đã tồn tại. Vui lòng nhập lại");
//                }
                //String tenloai = partLoai[1];
//                NhaCungCapDTO ncc = (NhaCungCapDTO)cbbNcc.getSelectedItem();
//                String mancc = ncc.getMancc();
//                LoaiSpDTO loai = (LoaiSpDTO)cbbLoai.getSelectedItem();
//                String maloai = loai.getMaloai();
                String image = imgName;
                
                //Add SanPhamDTO vao data
                NhanVienDTO nv = new NhanVienDTO(manv, honv, tennv, diachi, sdt, gioitinh,namsinh, image);
                
                nvBUS.Add(nv);
                saveIMG();
                JOptionPane.showMessageDialog(null,"Thêm thành công !!!");
                dispose();
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            });

         
            btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            });
        pAdd.add(lbManv);
        pAdd.add(txtManv);
        pAdd.add(lbTennv);
        pAdd.add(txtTennv);
        pAdd.add(lbHonv);
        pAdd.add(txtHonv);
        pAdd.add(lbDiachi);
        pAdd.add(txtDiachi);
        pAdd.add(lbSdt);
        pAdd.add(txtSdt);
        pAdd.add(lbGioitinh);
        pAdd.add(cbbGioitinh);
        pAdd.add(lbNamsinh);
        pAdd.add(cbbNamsinh);
        pAdd.add(lbImage);
        pAdd.add(btnChoose);
        pAdd.add(btnSave);
        pAdd.add(btnCancel);
        add(pAdd);
        setLocationRelativeTo(null);
        setVisible(true);

    }
    public void saveIMG()
    {
        try {
            if(i != null)
            {
                File save = new File("./src/image/NhanVien/"+ imgName);//Tạo file
                ImageIO.write(i,"png",save); // Lưu hình i vào đường dẫn file save

                i = null; //Xóa hình trong bộ nhớ 
            }
        } catch (IOException ex) {
            Logger.getLogger(SanPhamGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String getMasp()
    {
        return txtManv.getText();
    }
}
