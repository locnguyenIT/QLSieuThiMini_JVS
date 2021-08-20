/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.NguoiDungBUS;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import Connection.MySQLConnect;
import DTO.NguoiDungDTO;
import java.awt.Cursor;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author ntloc
 */
public class QLSieuThiMini extends JFrame implements MouseListener{
    
    int mpX, mpY;
    private JPanel pLogo_Menu,pContent,pHeader; 
    private JPanel pLogo, pMenu;
    private JLabel lbLogo;          
    private JLabel lbHeader, IconHeader,lbChao, lbUser, iconDown,iconExit,iconLogout;
    private JPanel pHeaderDown, pHeaderExit,pHeaderLogout;
    private int DEFAULT_WIDTH = 1300;
    private int DEFAULT_HEIGH = 735;
    private ArrayList<JPanel> Menu_Item = new ArrayList<>();
    private ArrayList<JLabel> Menu_Label = new ArrayList<>();
    private ArrayList<JLabel> Menu_Icon = new ArrayList<>();
    private Color normal = new Color(85,93,110);
    private Color hover = new Color(100, 113, 140);
    private ArrayList<String> itemInfo = new ArrayList<>();
    private ArrayList<DashboardMenu> dbMenu = new ArrayList<>();
    private ArrayList<String> Icon_White = new ArrayList<>();
    private NguoiDungDTO nd;
    public QLSieuThiMini(NguoiDungDTO nguoidung)
    {
        Toolkit screen = Toolkit.getDefaultToolkit();
        this.nd = nguoidung;
        Init();
    }
    public void Init()
    {   
        Font fontHeader = new Font("Segoe UI",Font.BOLD,14);
        Font fontUser = new Font("Segoe UI",Font.BOLD,16);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGH);
        setLayout(null);
        setTitle("QUẢN LÝ SIÊU THỊ");
        setIconImage(new ImageIcon("./src/image/super_market_45px.png").getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        pHeader = new JPanel(null);
        pHeader.setBounds(new Rectangle(0,0,1300,35));
        pHeader.setBackground(Color.WHITE);
        pHeader.setBorder(BorderFactory.createMatteBorder(1,1,0, 1, Color.BLACK));
            IconHeader = new JLabel(new ImageIcon("./src/image/super_market_30px.png"));
            IconHeader.setBounds(new Rectangle(5,2,50,30));
            lbHeader = new JLabel("QUẢN LÝ SIÊU THỊ");
            lbHeader.setBounds(new Rectangle(60,2,200, 30));
            lbHeader.setFont(fontHeader);
            
            lbChao = new JLabel("Chào, "+nd.getUsername());
            lbChao.setBounds(new Rectangle(1040,2,100, 30));
            lbChao.setFont(fontUser);
           
            
            pHeaderLogout = new JPanel(null);
            pHeaderLogout.setBounds(new Rectangle(1165,1,45,45));
            pHeaderLogout.setBackground(Color.WHITE);
                iconLogout = new JLabel(new ImageIcon("./src/image/exit_25px.png"));
                iconLogout.setBounds(new Rectangle(5,3,30,30));
            pHeaderLogout.add(iconLogout);
            pHeaderLogout.addMouseListener(this);
            
            pHeaderDown = new JPanel(null);
            pHeaderDown.setBounds(new Rectangle(1210,1,45,35));
            pHeaderDown.setBackground(Color.WHITE);
            
                iconDown = new JLabel(new ImageIcon("./src/image/minimize_15px.png"));
                iconDown.setBounds(new Rectangle(5,3,30,30));
            pHeaderDown.add(iconDown);
            pHeaderDown.addMouseListener(this);
            
            pHeaderExit = new JPanel(null);
            pHeaderExit.setBounds(new Rectangle(1255,1,45,35));
            pHeaderExit.setBorder(BorderFactory.createMatteBorder(0,0,0,1,Color.BLACK));
            pHeaderExit.setBackground(Color.WHITE);
            
                iconExit = new JLabel(new ImageIcon("./src/image/close_20px.png"));
                iconExit.setBounds(new Rectangle(7,3,30,30));
            pHeaderExit.add(iconExit);
            pHeaderExit.addMouseListener(this);
            
            pHeader.add(pHeaderExit);
            pHeader.add(pHeaderLogout);
            pHeader.add(pHeaderDown);
            
            
            
            
        pHeader.add(IconHeader);
        pHeader.add(lbHeader);
        pHeader.add(lbChao);
        
        //Panel Logo_menu
        pLogo_Menu = new JPanel(null);
        pLogo_Menu.setBounds(new Rectangle(0,35,DEFAULT_WIDTH - 1070 , DEFAULT_HEIGH));
        pLogo_Menu.setBorder(BorderFactory.createMatteBorder(1,0,1,0,Color.BLACK));
        //pLogo_Menu.setPreferredSize(new Dimension(DEFAULT_WIDTH-1070, DEFAULT_HEIGH));
        
            //Pannel Logo
            pLogo = new JPanel();
            pLogo.setLayout(null);
            pLogo.setBounds(0, 0, 230,200);
            pLogo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            pLogo.setBackground(new Color(67, 76, 94));
            lbLogo = new JLabel(new ImageIcon("./src/image/logo_28.png"),JLabel.CENTER);
            lbLogo.setBounds(new Rectangle(0,0, 230, 200));
            pLogo.add(lbLogo);
           
            //Panel Menu
            pMenu = new JPanel();
            pMenu.setLayout(null);
            pMenu.setBounds(0, 200, 230, 500);
            //pMenu.setBounds(0, 150, 230, 550);
                //Add Chuỗi chứa info Panel 
               
                itemInfo.add("Bán Hàng:shopping_cart_white_30px.png:shopping_cart_black_30px.png");
                itemInfo.add("Nhập Hàng:container_truck_white_25px.png:container_truck_black_25px.png");
                itemInfo.add("Sản Phẩm:product_white_20px.png:product_black_20px.png");
                itemInfo.add("Nhân Viên:staff_white_25px.png:staff_black_25px.png");
                itemInfo.add("Khách Hàng:customer_white_25px.png:customer_black_25px.png"); 
                itemInfo.add("Hóa Đơn:invoice_white_25px.png:invoice_black_25px.png");
                itemInfo.add("Nhà Cung Cấp:supplier_white_25px.png:supplier_black_25px.png");
                itemInfo.add("Phiếu Nhập Hàng:supply_chain_white_25px.png:supply_chain_black_25px.png");
                itemInfo.add("Thống Kê:statistics_white_25px.png:statistics_black_25px.png");
                itemInfo.add("Tài Khoản:account_white_25px.png:account_black_25px.png");
                for(int i=0 ;i <itemInfo.size();i++)
                {
                    String [] info = itemInfo.get(i).split(":"); //sau đó split(":") để cắt chuỗi có chứa :
                    String name = info[0];
                    String inconWhite = info[1];
                    String iconBlack = info[2];
                    //dbBmenu add DashboardMenu( Panel ) 
                    dbMenu.add(new DashboardMenu(new Rectangle(0,50*i,230,50),new Rectangle(15, 10,30,30),new Rectangle(70, 10, 220, 30),name,inconWhite,iconBlack));
                    dbMenu.get(i).addMouseListener(this); // gắn listener vào cho từng Item Panel trong ArrayList
                    dbMenu.get(i).setCursor(new Cursor(Cursor.HAND_CURSOR));
                    if(i == 9)
                    {
                        dbMenu.get(i).setBorder(BorderFactory.createMatteBorder(0, 1, 1,1,Color.BLACK));
                    }
                    pMenu.add(dbMenu.get(i));

                }
        pLogo_Menu.add(pLogo);
        pLogo_Menu.add(pMenu);
        
        //Pannel Content
        pContent = new JPanel(null);
        pContent.setBounds(new Rectangle(DEFAULT_WIDTH-1070, 35, DEFAULT_WIDTH-230,700));
        pContent.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        pContent.setBackground(Color.WHITE);
        
        dbMenu.get(0).Enable();
        ChangeMenuPanel(0);
        
        pHeader.addMouseListener( new MouseAdapter() {
        @Override
        public void mousePressed( MouseEvent e ) {
          mpX = e.getX();
          mpY = e.getY();
        }
        
    } );
        pHeader.addMouseMotionListener( new MouseMotionAdapter() {
        @Override
        public void mouseDragged( MouseEvent e ) {
          setLocation(
              getLocation().x + e.getX() - mpX,
              getLocation().y + e.getY() - mpY );
        }
    } );
      
        
        add(pHeader);
        add(pLogo_Menu);
        add(pContent);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setVisible(true);// hiển thị cửa sổ
          
        
    
        //ChangeMenuPanel(0,pMenu_banhang,lbBanhang,iconBH);
    }
     public void ChangeMenuPanel(int i)
    {
            if(i == 0 )  // BÁN HÀNG
            {
                        pContent.removeAll();
                        pContent.add(new BanHangGUI(DEFAULT_WIDTH,DEFAULT_HEIGH));
                        pContent.revalidate(); //Reset new component;
                        pContent.repaint();  //refresh component mới;
            }
            if(i == 1 ) // NHẬP HÀNG
            {
                        pContent.removeAll();
                        pContent.add(new NhapHangGUI(DEFAULT_WIDTH,DEFAULT_HEIGH));
                        pContent.revalidate(); //Reset new component;
                        pContent.repaint();  //refresh component mới;
            }
            if(i == 2) //SẢN PHẨM
            {

                    pContent.removeAll();
                    pContent.add(new SanPhamGUI(DEFAULT_WIDTH,DEFAULT_HEIGH));
                    pContent.revalidate();//Xoa component;
                    pContent.repaint();  //Vẽ lại component mới; 
            }
            if(i == 3) //NHÂN VIÊN
            {
                    pContent.removeAll();
                    pContent.add(new NhanVienGUI(DEFAULT_WIDTH,DEFAULT_HEIGH));
                    pContent.revalidate();//Xoa component;
                    pContent.repaint();  //Vẽ lại component mới; 
            }
            if(i == 4) //NHÂN VIÊN
            {
                    pContent.removeAll();
                    pContent.add(new KhachHangGUI(DEFAULT_WIDTH,DEFAULT_HEIGH));
                    pContent.revalidate();//Xoa component;
                    pContent.repaint();  //Vẽ lại component mới; 
            }
            if(i == 5 ) //HÓA ĐƠN
            {
                  pContent.removeAll();
                  pContent.add(new HoaDonGUI(DEFAULT_WIDTH,DEFAULT_HEIGH));
                  pContent.revalidate(); //Xoa component;
                  pContent.repaint();  //Vẽ lại component mới;  
            } 
            if(i == 6 ) //NHÀ CUNG CẤP
            {
                  pContent.removeAll();
                  pContent.add(new NhaCungCapGUI(DEFAULT_WIDTH,DEFAULT_HEIGH));
                  pContent.revalidate(); //Xoa component;
                  pContent.repaint();  //Vẽ lại component mới;  
            } 
            if(i == 7 ) //PHIẾU NHẬP HÀNG
            {
                  pContent.removeAll();
                  pContent.add(new PhieuNhapHangGUI(DEFAULT_WIDTH,DEFAULT_HEIGH));
                  pContent.revalidate(); //Xoa component;
                  pContent.repaint();  //Vẽ lại component mới;  
            } 
            if(i == 8 && nd.getPassword().equals("Admin")) //THỐNG KÊ
            {
                  pContent.removeAll();
                  pContent.add(new ThongKeGUI(DEFAULT_WIDTH,DEFAULT_HEIGH));
                  pContent.revalidate(); //Xoa component;
                  pContent.repaint();  //Vẽ lại component mới;  
            }
            else if(i == 8 && nd.getPassword().equals("Staff"))
                {
                  dbMenu.get(i).Block();
                  JOptionPane.showMessageDialog(null,"Quyền của bạn không cho phép truy cập");
                }
            if(i == 9 && nd.getPassword().equals("Admin"))
            {
                  pContent.removeAll();
                  pContent.add(new TaiKhoanGUI(DEFAULT_WIDTH,DEFAULT_HEIGH));
                  pContent.revalidate(); //Xoa component;
                  pContent.repaint();  //Vẽ lại component mới;  
            }
            else if(i == 9 && nd.getPassword().equals("Staff"))
            {
                dbMenu.get(i).Block();
                JOptionPane.showMessageDialog(null,"Quyền của bạn không cho phép truy cập");
                 
            }
        
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        for(int i =0; i < dbMenu.size(); i++)
        {
            DashboardMenu item = dbMenu.get(i);
            if(e.getSource() == item)
            {
                item.Enable();
                ChangeMenuPanel(i);
            }
            else
            {
                 item.Block();
            }
        }

        //Close Program
        if(e.getSource() == pHeaderExit)
        {
            
            int option = JOptionPane.showConfirmDialog (null, "Thoát chương trình ?","WARNING",JOptionPane.YES_NO_OPTION);
            if(option == JOptionPane.YES_OPTION)
            {
                System.exit(0);
            }
        }
        //Down JFrame
        if(e.getSource() == pHeaderDown)
        {
            setState(JFrame.ICONIFIED);
        }
        if(e.getSource() == pHeaderLogout)
        {
            dispose();
            Login login = new Login();
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == pHeaderLogout)
        {
            pHeaderLogout.setBackground(new Color(232, 232, 232));
            iconLogout.setIcon(new ImageIcon("./src/image/exit_black_25px.png"));
        }
        if(e.getSource() == pHeaderDown)
        {
            pHeaderDown.setBackground(new Color(232, 232, 232));
        }
        if(e.getSource() == pHeaderExit)
        {
            pHeaderExit.setBackground(new Color(240, 71, 74));
            iconExit.setIcon(new ImageIcon("./src/image/close_20px_white.png"));
        }
      
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == pHeaderLogout)
        {
            pHeaderLogout.setBackground(Color.WHITE);
             iconLogout.setIcon(new ImageIcon("./src/image/exit_25px.png"));
        }
        if(e.getSource() == pHeaderDown)
        {
            pHeaderDown.setBackground(Color.WHITE);
        }
         if(e.getSource() == pHeaderExit)
        {
            pHeaderExit.setBackground(Color.WHITE);
            iconExit.setIcon(new ImageIcon("./src/image/close_20px.png"));
        }
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
