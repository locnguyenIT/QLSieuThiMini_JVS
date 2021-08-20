/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.NguoiDungBUS;
import DTO.NguoiDungDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.KeyboardFocusManager;
import java.awt.Rectangle;
import java.awt.SplashScreen;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 *
 * @author ntloc
 */
public class Login extends JFrame implements MouseListener,KeyListener{
    
    private JPanel pLogin, pClose, pBtnLogin;
    private JLabel lbLogin, icon, iconUser, iconPass, lbClose ,btnLogin;
    private JTextField txtUser ,txtMatkhau;
    private JPasswordField txtPass;
    private JSeparator sep_User, sep_Pass;
    private NguoiDungBUS ndBUS = new NguoiDungBUS();
    private ArrayList<NguoiDungDTO> dsnd = new  ArrayList<>();
    private QLSieuThiMini qlst;

    public Login()
    {
        ndBUS.DanhSachNguoiDung();
        Init();
    }
    public void Init()
    {
    
        setLayout(null); 
        setSize(400,600);
        setBackground(null);
        setIconImage(new ImageIcon("./src/image/super_market_45px.png").getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font fontB = new Font("Segoe UI",Font.BOLD,16);
        Font fontL = new Font("Segoe UI",Font.PLAIN,14);
        Font fontLogin = new Font("Segoe UI",Font.BOLD,16);
        setLayout(null);
            
            pLogin = new JPanel(null);
            pLogin.setBounds(new Rectangle(0,0,400,600));
            pLogin.setBackground(new Color(242, 242, 242));
            pLogin.setBorder(BorderFactory.createLineBorder(Color.BLUE));
            //pLogin.setBackground(Color.WHITE);
            //pLogin.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            
                    
                pClose = new JPanel(null);
                pClose.setBounds(new Rectangle(365,1,34,30));
                pClose.addMouseListener(this);
                    lbClose = new JLabel(new ImageIcon("./src/image/close_20px.png"),JLabel.CENTER);
                    lbClose.setBounds(new Rectangle(3,0,30,30));
                pClose.add(lbClose);
                    lbLogin = new JLabel("SIÊU THỊ MINI POPPY");
                    lbLogin.setBounds(new Rectangle(120,70,200,30));
                    lbLogin.setFont(fontLogin);
                    
                    icon = new JLabel(new ImageIcon("./src/image/super_market_45px.png"));
                    icon.setBounds(new Rectangle(150,100,100,50));
                    
                    iconUser = new JLabel(new ImageIcon("./src/image/user_30px.png"));
                    iconUser.setBounds(new Rectangle(50,200,50,30));
                    txtUser = new JTextField("Tên đăng nhập");
                    txtUser.setBounds(new Rectangle(100,200,200,30));
                    txtUser.setBackground(new Color(242, 242, 242));
                    txtUser.setBorder(BorderFactory.createEmptyBorder());
                    txtUser.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,Collections.EMPTY_SET);
                    txtUser.setFont(fontL);
                    sep_User = new JSeparator();
                    sep_User.setBounds(new Rectangle(60,235,270,20));
                    
                    iconPass = new JLabel(new ImageIcon("./src/image/lock_30px.png"));
                    iconPass.setBounds(new Rectangle(50,280,50,30));
                    
                    txtMatkhau = new JTextField("Mật khẩu");
                    txtMatkhau.setBounds(new Rectangle(100,280,200,30));
                    txtMatkhau.setBackground(new Color(242, 242, 242));
                    txtMatkhau.setBorder(BorderFactory.createEmptyBorder());
                    txtMatkhau.addKeyListener(this);
                    txtMatkhau.setFont(fontL);
                   
                    
                    txtPass = new JPasswordField("");
                    txtPass.setBounds(new Rectangle(100,280,200,30));
                    txtPass.setBackground(new Color(242, 242, 242));
                    txtPass.setBorder(BorderFactory.createEmptyBorder());
                    txtPass.setFont(fontL);
                    txtPass.addKeyListener(this);
                    txtPass.setVisible(false);
                    
                    sep_Pass = new JSeparator();
                    sep_Pass.setBounds(new Rectangle(60,320,270,20));
                    
                    pBtnLogin = new JPanel(null);
                    pBtnLogin.setBounds(new Rectangle(60,500,270,40));
                    pBtnLogin.setBackground(new Color(179, 202, 226));
                    pBtnLogin.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    pBtnLogin.addMouseListener(this);
                        btnLogin = new JLabel("Đăng nhập");    
                        btnLogin.setBounds(new Rectangle(100,5,150,30));
                        btnLogin.setFont(fontB);
                    pBtnLogin.add(btnLogin);
                   
                    
             pLogin.add(pClose);       
             pLogin.add(lbLogin);
             pLogin.add(pBtnLogin);
             pLogin.add(icon);  
             pLogin.add(iconUser);
             pLogin.add(txtUser);
             pLogin.add(sep_User);
             pLogin.add(iconPass);
             pLogin.add(txtPass);
             pLogin.add(sep_Pass);
             pLogin.add(txtMatkhau);
        add(pLogin);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setVisible(true);
        
                
                txtUser.addMouseListener(new MouseAdapter() {
                     public void mouseClicked(MouseEvent e) {
                         txtUser.setText("");
                     }
                });
                txtMatkhau.addMouseListener(new MouseAdapter() {
                     public void mouseClicked(MouseEvent e) {
                         
                         txtMatkhau.setVisible(false);
                         txtPass.setVisible(true);
                         txtPass.setText("");
                     }
                });
                txtMatkhau.addMouseListener(new MouseAdapter() {
                     public void mouseClicked(MouseEvent e) {
                         txtMatkhau.setVisible(false);
                         txtPass.setVisible(true);
                         txtPass.requestFocus();
                     }
                });
                txtUser.addKeyListener(new KeyAdapter() {
                    public void keyPressed(KeyEvent e)
                    {
                         if(e.getKeyCode() == KeyEvent.VK_TAB)
                         {
                            txtMatkhau.setVisible(false);
                            txtPass.setVisible(true);
                            txtPass.requestFocus();
                         }
                    }
                    });
                
                txtUser.addKeyListener(new KeyAdapter() {
                    public void keyPressed(KeyEvent e)
                    {
                        if(e.getKeyCode() == KeyEvent.VK_ENTER)
                        {
                            String user = txtUser.getText();
                            char[] pass = txtPass.getPassword();
                            NguoiDungDTO nd =  ndBUS.CheckUser(user, pass);
                            if(nd == null)
                            {
                                JOptionPane.showMessageDialog(null,"Sai tài khoản hoặc mật khẩu !!!");
                                txtUser.setText("Tên đăng nhập");
                                txtPass.setText("");
                                txtPass.setVisible(false);
                                txtMatkhau.setVisible(true);
                                txtMatkhau.setText("Mật khẩu");
                                txtUser.requestFocus();
                                return;
                            }
                            else
                            { 
                                LoginSplashScreen  SplashScreen= new LoginSplashScreen(nd);
                                //LoginSplashScreen  SplashScreen= new LoginSplashScreen();
                                dispose();
                                
                            }
                            
                        }
                    }
                    });
                
                //Enter Login
                
                txtPass.addKeyListener(new KeyAdapter() {
                    public void keyPressed(KeyEvent e)
                    {
                     
                        if(e.getKeyCode() == KeyEvent.VK_ENTER)
                        {
                            String user = txtUser.getText();
                            char[] pass = txtPass.getPassword();
                            NguoiDungDTO nd =  ndBUS.CheckUser(user, pass);
                            if(nd == null)
                            {
                                JOptionPane.showMessageDialog(null,"Sai tài khoản hoặc mật khẩu !!!");
                                txtUser.setText("Tên đăng nhập");
                                txtPass.setText("");
                                txtPass.setVisible(false);
                                txtMatkhau.setVisible(true);
                                txtMatkhau.setText("Mật khẩu");
                                txtUser.requestFocus();
                                return;
                            }
                            else
                            {  
                                //QLSieuThiMini qlst = new QLSieuThiMini();
                               // LoginSplashScreen  SplashScreen= new LoginSplashScreen(nd.getId(),nd.getUsername(),nd.getRole());
                                LoginSplashScreen  SplashScreen= new LoginSplashScreen(nd);
                                dispose(); 
                                
                            }
                           
                        }
                    }
                    });
    }
  
     public static void main(String[] args) {
      try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            Login login = new Login();
        }catch(Exception e)
        { 
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == pClose)
        {
            System.exit(0);
        }
        if(e.getSource() == pBtnLogin)
        {
            String user = txtUser.getText();
            char[] pass = txtPass.getPassword();
            NguoiDungDTO nd =  ndBUS.CheckUser(user, pass);
            if(nd == null)
            {
                JOptionPane.showMessageDialog(null,"Sai tài khoản hoặc mật khẩu !!!");
                txtUser.setText("Tên đăng nhập");
                txtPass.setText("");
                txtPass.setVisible(false);
                txtMatkhau.setVisible(true);
                txtMatkhau.setText("Mật khẩu");
                txtUser.requestFocus();
                return;
            }
            else
            {
                LoginSplashScreen  SplashScreen= new LoginSplashScreen(nd);
                //LoginSplashScreen  SplashScreen= new LoginSplashScreen();
                dispose();      
            }
            
        }
                
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == pClose)
        {
            pClose.setBackground(Color.red);
            lbClose.setIcon(new ImageIcon("./src/image/close_20px_white.png"));
        }
        if(e.getSource() == pBtnLogin)
        {
            pBtnLogin.setBackground(new Color(217, 228, 240));
        }
        
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == pClose)
        {
            pClose.setBackground(new Color(242, 242, 242));
            lbClose.setIcon(new ImageIcon("./src/image/close_20px.png"));
        }
        if(e.getSource() == pBtnLogin)
        {
            pBtnLogin.setBackground(new Color(179, 202, 226));
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
//        Object user = e.getSource();
//        if(user.equals(txtUser))
//        if(e.getKeyCode() == KeyEvent.VK_ENTER)
//        {
//            JOptionPane.showMessageDialog(null,"Xin chào");
//        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
