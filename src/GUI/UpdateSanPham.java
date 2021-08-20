/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.NhaCungCapBUS;
import BUS.SanPhamBUS;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ntloc
 */
public class UpdateSanPham extends JDialog{
    private SanPhamBUS spBUS = new SanPhamBUS();
    private NhaCungCapBUS nccBUS = new NhaCungCapBUS();
    private JPanel pUpdate;
    private JLabel lbMasp, lbTensp, lbSl, lbDongia, lbDvt,lbNcc, lbLoai,lbImage;
    private JTextField txtMasp, txtTensp, txtSl, txtDongia;
    private JComboBox cbbDvt, cbbNcc, cbbLoai;
    private JButton btnChoose, btnSave, btnCancel;
    private BufferedImage i = null;//Hình ảnh chọn từ file
    private String imgName = "null";
    public UpdateSanPham(String masp,String tensp, int dongia, int sl,String dvtinh,String maloai, String mancc, String image)
    {
        spBUS.DanhSachSanPham();
        nccBUS.DanhSachNCC();
        this.imgName = image;
        setModal(true);
        Init(masp,tensp,dongia,sl,dvtinh,maloai,mancc,image);
    }
    public void Init(String masp,String tensp,int dongia,int sl, String dvtinh, String maloai, String mancc, String image)
    {
        
        Font font0 = new Font("Segoe UI",Font.BOLD,13);
        Font font1 = new Font("Segoe UI",Font.PLAIN,13);
        setSize(720,500);
        setLayout(null);
        setTitle("SỬA SẢN PHẨM");
        setBackground(Color.WHITE);
        
        pUpdate = new JPanel(null);
        pUpdate.setBounds(0,0,720,500);
        pUpdate.setBackground(Color.WHITE);
        
            lbMasp = new JLabel("Mã sản phẩm");
            lbMasp.setBounds(new Rectangle(30, 30,100,30));
            lbMasp.setFont(font0);
            txtMasp = new JTextField(masp);
            txtMasp.setBounds(new Rectangle(130, 30,150,30));
            txtMasp.setFont(font1);
            txtMasp.setEnabled(false);
            
            lbTensp = new JLabel("Tên sản phẩm");
            lbTensp.setBounds(new Rectangle(30, 70, 100,30));
            lbTensp.setFont(font0);
            txtTensp = new JTextField(tensp);
            txtTensp.setBounds(new Rectangle(130,70,150,30));
            txtTensp.setFont(font1);
            
            lbSl = new JLabel("Số lượng");
            lbSl.setBounds(new Rectangle(30, 150, 100,30));
            lbSl.setFont(font0);
            txtSl = new JTextField(Integer.toString(sl));
            txtSl.setBounds(new Rectangle(130,150,150,30));
            txtSl.setFont(font1);
            
            
            lbDongia = new JLabel("Đơn giá");
            lbDongia.setBounds(new Rectangle(30, 110, 100,30));
            lbDongia.setFont(font0);
            txtDongia = new JTextField(Integer.toString(dongia));
            txtDongia.setBounds(new Rectangle(130,110,150,30));
            txtDongia.setFont(font1);
            
            lbDvt = new JLabel("Đơn vị tính");
            lbDvt.setBounds(new Rectangle(30, 190, 100,30));
            lbDvt.setFont(font0);
            String[] dvt ={"--Chọn--","Lon", "Chai", "Quả","Gói","Hộp"};
            cbbDvt = new JComboBox(dvt);
            cbbDvt.setBounds(new Rectangle(130,190,150,30));
            cbbDvt.setSelectedItem(dvtinh);
            cbbDvt.setBackground(null);
            cbbDvt.setFont(font1);
            
            lbLoai = new JLabel("Loại sản phẩm");
            lbLoai.setBounds(new Rectangle(30, 230, 100,30));
            lbLoai.setFont(font0);
            String[] loai ={"--Chọn--","A01 - Thức ăn", "A02 - Thức uống", "A03 - Hàng gia dụng"};
            
            cbbLoai = new JComboBox(loai);
            cbbLoai.setBounds(new Rectangle(130,230,150,30));
            cbbLoai.setSelectedItem(maloai);
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
            cbbNcc.setSelectedItem(mancc);
            cbbNcc.setBackground(null);
            cbbNcc.setFont(font1);
            
           
             Image newImage = new ImageIcon("./src/image/image_SanPham/"+image).getImage().getScaledInstance(200, 230, Image.SCALE_DEFAULT);
            lbImage = new JLabel();
            lbImage.setBounds(new Rectangle(400, 30, 200, 230));
            lbImage.setIcon(new ImageIcon(newImage));
            lbImage.setBorder(BorderFactory.createLineBorder(Color.BLACK));
           
            
            btnChoose = new JButton("Chọn");
            btnChoose.setBounds(new Rectangle(400, 270,80,30));
            btnChoose.setBackground(null);
            btnChoose.setCursor(new Cursor(Cursor.HAND_CURSOR));
             
            btnSave = new JButton(new ImageIcon("./src/image/btnSave_30px.png"));
            btnSave.setBounds(new Rectangle(400,400,115, 35));
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
                        
                        revalidate();
                        repaint();
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
                String loai = cbbLoai.getSelectedItem().toString();
                System.out.println(loai);
                String[] partLoai = loai.split(" - ");
                String maloai = partLoai[0];
                String ncc = cbbNcc.getSelectedItem().toString();
                String[] partNcc = ncc.split(" - "); //Tách chuỗi để lưu mã
                String mancc = partNcc[0];
                String image = imgName;
                SanPhamDTO sp = new SanPhamDTO(masp,  tensp, dongia,sl,  dvt,maloai,mancc,image);
                
                saveIMG(); //Lưu file IMG
                spBUS.Set(sp);
                JOptionPane.showMessageDialog(null,"Cập nhật hoàn tất !!!");
                dispose();
                }
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            
            });
            
    
            btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            });
            
            
        pUpdate.add(lbMasp);
        pUpdate.add(txtMasp);
        pUpdate.add(lbTensp);
        pUpdate.add(txtTensp);
        pUpdate.add(lbSl);
        pUpdate.add(txtSl);
        pUpdate.add(lbDongia);
        pUpdate.add(txtDongia);
        pUpdate.add(lbDvt);
        pUpdate.add(cbbDvt);
        pUpdate.add(lbNcc);
        pUpdate.add(cbbNcc);
        pUpdate.add(lbLoai);
        pUpdate.add(cbbLoai);
        pUpdate.add(lbImage);
        pUpdate.add(btnChoose);
        pUpdate.add(btnSave);
        pUpdate.add(btnCancel);
        add(pUpdate);
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
}
