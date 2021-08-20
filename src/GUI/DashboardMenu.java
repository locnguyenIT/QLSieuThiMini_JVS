/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ntloc
 */
public class DashboardMenu extends JPanel implements MouseListener{
    
    private Rectangle pRec, iconRec, nameRec;
    private JLabel lbName, lbIcon;
    private String nameItem,iconWhite, iconBlack;
    private boolean enable;
    private Color normal = new Color(85,93,110);
    private Color hover = new Color(100, 113, 140);
    public DashboardMenu(Rectangle pRec, Rectangle iconRec, Rectangle nameRec,String nameItem, String iconWhite, String iconBlack)
    {
        this.pRec = pRec;
        this.iconRec = iconRec;
        this.nameRec = nameRec;
        this.nameItem = nameItem;  
        this.iconWhite = iconWhite;
        this.iconBlack = iconBlack;
        Init();
    }
    public void Init()
    {
        addMouseListener(this);
        Font fontName = new Font("Segoe UI",Font.BOLD,14);
        setLayout(null);
        setBounds(pRec);
        setBackground(normal);
        setBorder(BorderFactory.createMatteBorder(0,1,0,1, Color.BLACK));
            lbName = new JLabel(nameItem);
            lbName.setBounds(nameRec);
            lbName.setForeground(Color.WHITE);
            lbName.setFont(fontName);
            
            lbIcon = new JLabel(new ImageIcon("./src/image/"+iconWhite));
            lbIcon.setBounds(iconRec);

        add(lbName);
        add(lbIcon);
    }
    public void Enable()
    {
        enable = true;
        setBackground(Color.WHITE);
        lbName.setForeground(Color.BLACK);
        lbIcon.setIcon(new ImageIcon("./src/image/"+iconBlack));
    }
    public void Block()
    {
        enable = false;
        setBackground(normal);
        lbName.setForeground(Color.WHITE);
        lbIcon.setIcon(new ImageIcon("./src/image/"+iconWhite));
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        if(enable == false)
        {
            setBackground(hover);
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
         if(enable == false)
        {
            setBackground(normal);
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     
}
