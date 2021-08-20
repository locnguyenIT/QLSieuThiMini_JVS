/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.NhaCungCapBUS;
import BUS.SanPhamBUS;
import DTO.LoaiSpDTO;
import DTO.NhaCungCapDTO;
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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ntloc
 */
public class AddSanPham extends JDialog{
    
    private SanPhamBUS spBUS = new SanPhamBUS();
    private NhaCungCapBUS nccBUS = new NhaCungCapBUS();
    private JPanel pAdd;
    private JLabel lbMasp, lbTensp, lbSl, lbDongia, lbDvt,lbNcc, lbLoai,lbImage;
    private String imgName = "null";
    private JTextField txtMasp, txtTensp, txtSl, txtDongia;
    private JComboBox cbbDvt, cbbNcc, cbbLoai;
    private JButton btnChoose, btnSave, btnCancel;
    private BufferedImage i = null;//Hình ảnh chọn từ file
    public AddSanPham()
    {
        spBUS.DanhSachSanPham();
        nccBUS.DanhSachNCC();
        setModal(true);
        Init();
    }
    public void Init()
    {
        Font font0 = new Font("Segoe UI",Font.BOLD,13);
        Font font1 = new Font("Segoe UI",Font.PLAIN,13);
        setSize(720,500);
        setLayout(null);
        setTitle("THÊM SẢN PHẨM");
        setBackground(Color.WHITE);
        
        pAdd = new JPanel(null);
        pAdd.setBounds(0,0,720,500);
        pAdd.setBackground(Color.WHITE);
        
            lbMasp = new JLabel("Mã sản phẩm");
            lbMasp.setBounds(new Rectangle(30, 30,100,30));
            lbMasp.setFont(font0);
            txtMasp = new JTextField("");
            txtMasp.setBounds(new Rectangle(130, 30,150,30));
            txtMasp.setFont(font1);
            txtMasp.setText(spBUS.NextMaSP());
            txtMasp.setEnabled(false);
            
            lbTensp = new JLabel("Tên sản phẩm");
            lbTensp.setBounds(new Rectangle(30, 70, 100,30));
            lbTensp.setFont(font0);
            txtTensp = new JTextField("");
            txtTensp.setBounds(new Rectangle(130,70,150,30));
            txtTensp.setFont(font1);
            
            lbSl = new JLabel("Số lượng");
            lbSl.setBounds(new Rectangle( 30, 150, 100,30));
            lbSl.setFont(font0);
            txtSl = new JTextField("");
            txtSl.setBounds(new Rectangle(130,150,150,30));
            txtSl.setFont(font1);
           
            lbDongia = new JLabel("Đơn giá");
            lbDongia.setBounds(new Rectangle(30, 110, 100,30));
            lbDongia.setFont(font0);
            txtDongia = new JTextField("");
            txtDongia.setBounds(new Rectangle(130,110,150,30));
            txtDongia.setFont(font1);
            
            lbDvt = new JLabel("Đơn vị tính");
            lbDvt.setBounds(new Rectangle(30, 190, 100,30));
            lbDvt.setFont(font0);
            String[] dvt ={"--Chọn--","Lon", "Chai", "Quả","Gói","Hộp"};
            cbbDvt = new JComboBox(dvt);
            cbbDvt.setBounds(new Rectangle(130,190,150,30));
            cbbDvt.setBackground(null);
            cbbDvt.setFont(font1);
            
            lbLoai = new JLabel("Loại sản phẩm");
            lbLoai.setBounds(new Rectangle(30, 230, 100,30));
            lbLoai.setFont(font0);
            //String[] loai ={"--Chọn--","A01", "A02", "A03"};
            String[] loai ={"--Chọn--","A01 - Thức ăn", "A02 - Thức uống", "A03 - Hàng gia dụng"};
            cbbLoai = new JComboBox(loai);
            cbbLoai.setBounds(new Rectangle(130,230,150,30));
            cbbLoai.setBackground(null);
            cbbLoai.setFont(font1);
            
            lbNcc = new JLabel("Nhà cung cấp");
            lbNcc.setBounds(new Rectangle(30, 270, 100,30));
            lbNcc.setFont(font0);
            ArrayList<NhaCungCapDTO> dsncc = nccBUS.getDsncc();
            String[] items = new String[dsncc.size()];
            for(int i =0; i<items.length; i++)
            {
                items[i] = dsncc.get(i).getMancc()+" - "+dsncc.get(i).getTenncc();
            }
           
            cbbNcc = new JComboBox(items);
            cbbNcc.setBounds(new Rectangle(130,270,150,30));
            cbbNcc.setBackground(null);
            cbbNcc.setFont(font1);
            
           
            
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
            btnCancel.setBounds(new Rectangle(530,400,116,35));
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
                        imgName = txtMasp.getText().concat(".png"); //Tên hình
                        
                        // Thay đổi hình hiển thị
                        lbImage.setIcon(new ImageIcon(i.getScaledInstance(200, 230, Image.SCALE_DEFAULT)));

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
                
                String masp = txtMasp.getText();
                String tensp = txtTensp.getText();
                int sl = Integer.parseInt(txtSl.getText());
                int dongia = Integer.parseInt(txtDongia.getText());
                String dvt = cbbDvt.getSelectedItem().toString();
                String ncc = cbbNcc.getSelectedItem().toString();
                System.out.println(ncc);
                String[] partNcc = ncc.split(" - "); //Tách chuỗi để lưu mã
                String mancc = partNcc[0];
                //String tenncc = partNcc[1];
                String loai = cbbLoai.getSelectedItem().toString();
                String[] partLoai = loai.split(" - ");
                String maloai = partLoai[0];
                String image = imgName;
                
                //Add SanPhamDTO vao data
                SanPhamDTO sp = new SanPhamDTO(masp,  tensp,dongia, sl,  dvt,maloai,mancc,image);
                
                spBUS.Add(sp);
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
        pAdd.add(lbMasp);
        pAdd.add(txtMasp);
        pAdd.add(lbTensp);
        pAdd.add(txtTensp);
        pAdd.add(lbSl);
        pAdd.add(txtSl);
        pAdd.add(lbDongia);
        pAdd.add(txtDongia);
        pAdd.add(lbDvt);
        pAdd.add(cbbDvt);
        pAdd.add(lbNcc);
        pAdd.add(cbbNcc);
        pAdd.add(lbLoai);
        pAdd.add(cbbLoai);
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
                File save = new File("./src/image/image_SanPham/"+ imgName);//Tạo file
                ImageIO.write(i,"png",save); // Lưu hình i vào đường dẫn file save

                i = null; //Xóa hình trong bộ nhớ 
            }
        } catch (IOException ex) {
            Logger.getLogger(SanPhamGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String getMasp()
    {
        return txtMasp.getText();
    }
}
