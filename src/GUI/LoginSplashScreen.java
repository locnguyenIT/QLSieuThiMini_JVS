/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.NguoiDungDTO;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author ntloc
 */
public class LoginSplashScreen extends JFrame{
    
    private JPanel pSlashScreen;
    private JLabel  lbName, lbGif, lbIconShop;
    private JLabel lbCount;
    private JProgressBar bar;
    private String Id;
    private String Username;
    private String role;

    public LoginSplashScreen(NguoiDungDTO nd)
    {
        Toolkit screen = Toolkit.getDefaultToolkit();
        Init(nd);
    }
  
    public void Init(NguoiDungDTO nd)
    {
        Font fontP = new Font("Segoe UI",Font.PLAIN,13);
        Font fontB = new Font("Segoe UI",Font.BOLD,13);
        Font fontHeader = new Font("Segoe UI",Font.BOLD,16);
        setLayout(null);
        setTitle("SpashScreen");
        setSize(480,360);
        setBackground(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("./src/image/super_market_45px.png").getImage());
        
             pSlashScreen = new JPanel(null);
             pSlashScreen.setBounds(new Rectangle(0, 0,480,360));
             pSlashScreen.setBackground(null);
             
                  
                   
                   lbName = new JLabel("SIÊU THỊ MINI POPPY",JLabel.CENTER);
                   lbName.setBounds(new Rectangle(145, 40, 200, 30));
                   lbName.setFont(fontHeader);
                   
                   lbIconShop = new JLabel(new ImageIcon("./src/image/super_market_45px.png"));
                   lbIconShop.setBounds(new Rectangle(215, 70, 50, 50));
                   
                   lbCount = new JLabel("Application is loading, please wait . . .");
                   lbCount.setBounds(new Rectangle(140, 260,300,30));
                   lbCount.setFont(fontP);
                   
                   bar = new JProgressBar();
                   bar.setBounds(new Rectangle(120,300, 240, 30));
                   bar.setStringPainted(true);
                   bar.setFont(fontB);
                   bar.setForeground(new Color(143, 177, 213));
                   lbGif = new JLabel(new ImageIcon("./src/image/giphy.gif"));
                   lbGif.setBounds(new Rectangle(0, 0, 480, 360));
                   lbGif.setBorder(BorderFactory.createLineBorder(Color.BLUE));
   
            pSlashScreen.add(lbName);
            pSlashScreen.add(lbIconShop);
            pSlashScreen.add(lbCount);
            pSlashScreen.add(bar);
            pSlashScreen.add(lbGif);

        add(pSlashScreen);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setVisible(true);
              
        SpashScreen(nd);
        
    }
    public void SpashScreen(NguoiDungDTO nd)
    {
        Runnable runner = new Runnable()
        {
        public void run() {
        //Your original code with the loop here.
               for(int i=0; i<=100; i++)
                {
                   try {
                       Thread.sleep(35);
                       bar.setValue(i);
                       if(i == 100)
                       {
                           Thread.sleep(1000);
                           dispose();
                           QLSieuThiMini qlst = new QLSieuThiMini(nd);
                           //QLSieuThiMini qlst = new QLSieuThiMini();
                       }
                   } catch (InterruptedException ex) {
                       Logger.getLogger(LoginSplashScreen.class.getName()).log(Level.SEVERE, null, ex);
                   }
                }  
        }
        };
        Thread t = new Thread(runner, "Code Executer");
    t.start();
    }

 
}
