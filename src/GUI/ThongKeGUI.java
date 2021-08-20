/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.ThongKeBUS;
import DTO.ThongKeDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.apache.poi.hslf.blip.JPEG;

/**
 *
 * @author ntloc
 */
public class ThongKeGUI extends JPanel implements ActionListener{
    private int WITDH, HEIGHT;
    private JPanel pThongkeTop,pContent;
    private JLabel lbStart,lbEnd, lbBaocao, lbBc_From,lbBc_To, lb_From, lb_To;
    private JRadioButton rbtnBanHang, rbtnNhapHang,rbtnSanPham,rbtnTopChay,rbtnTopCham;
    private JDateChooser Startdate, Enddate;
    private JButton btnThongke;
    private JTable table;
    private JScrollPane scroll;
    private DefaultTableModel model;
    private ButtonGroup btnGroup;
    private Color normal = new Color(85,93,110);
    private Color hover = new Color(100, 113, 140);
    private ThongKeBUS tkBUS = new ThongKeBUS();
    private DecimalFormat formatter = new DecimalFormat("###,###,###.##"); //Format number
    public ThongKeGUI(int WITDH, int HEIGHT)
    {
       this.WITDH = WITDH;
       this.HEIGHT = HEIGHT;
       Init();
    }
    public void Init()
    {
        
        Font fontB = new Font("Segoe UI",Font.BOLD,14);
        Font fontTK = new Font("Segoe UI",Font.BOLD,16);
        Font fontP = new Font("Segoe UI",Font.PLAIN,13);
        setLayout(null);
        setBounds(new Rectangle(0,0, this.WITDH - 230, this.HEIGHT)); //QLST
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBackground(Color.WHITE);
        
        
            //-------------------------Panel Thống Kê-----------------------------------//
                pThongkeTop = new JPanel(null);
                pThongkeTop.setBounds(new Rectangle(20,20,1000,180));
                pThongkeTop.setBackground(null);
                    rbtnBanHang = new JRadioButton("Bán hàng");
                    rbtnBanHang.setBounds(new Rectangle(50, 20,100,30));
                    rbtnBanHang.setFont(fontP);
                    rbtnBanHang.setBackground(null);
                    
                    rbtnNhapHang = new JRadioButton("Nhập hàng");
                    rbtnNhapHang.setFont(fontP);
                    rbtnNhapHang.setBounds(new Rectangle(230, 20,100,30));
                    rbtnNhapHang.setBackground(null);

                    
                    rbtnSanPham = new JRadioButton("Sản phẩm");
                    rbtnSanPham.setFont(fontP);
                    rbtnSanPham.setBounds(new Rectangle(410,20, 100,30));
                    rbtnSanPham.setBackground(null);
                    
                    rbtnTopChay = new JRadioButton("Top 5 SP bán chạy");
                    rbtnTopChay.setFont(fontP);
                    rbtnTopChay.setBounds(new Rectangle(590, 20,150,30));
                    rbtnTopChay.setBackground(null);
                    
                    
                    rbtnTopCham = new JRadioButton("Top 5 SP bán chậm");
                    rbtnTopCham.setFont(fontP);
                    rbtnTopCham.setBounds(new Rectangle(810, 20, 150,30));
                    rbtnTopCham.setBackground(null);
                    
                    btnGroup = new ButtonGroup();
                    btnGroup.add(rbtnBanHang);
                    btnGroup.add(rbtnNhapHang);
                    btnGroup.add(rbtnSanPham);
                    btnGroup.add(rbtnTopChay);
                    btnGroup.add(rbtnTopCham);
                     
                    lbStart = new JLabel("Từ ngày");
                    lbStart.setBounds(new Rectangle(250,70, 70, 30));
                    lbStart.setFont(fontP);
                    Startdate = new JDateChooser();
                    Startdate.setBounds(new Rectangle(330, 70, 120, 30));
                    Startdate.setFont(fontP);
         
                    lbEnd = new JLabel("Đến ngày");
                    lbEnd.setBounds(new Rectangle(500,70, 70, 30));
                    lbEnd.setFont(fontP);
                    Enddate = new JDateChooser();
                    Enddate.setBounds(new Rectangle(580,70, 120, 30));
                    Enddate.setFont(fontP);
                    
                    btnThongke = new JButton("Thống kê");
                    btnThongke.setBounds(new Rectangle(50,130,900,40));
                    btnThongke.setBackground(null);
                    btnThongke.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    btnThongke.setFont(fontB);
                    btnThongke.addActionListener(this);
                    
                pThongkeTop.add(rbtnBanHang);
                pThongkeTop.add(rbtnNhapHang);
                pThongkeTop.add(rbtnSanPham);
                pThongkeTop.add(rbtnTopChay);
                pThongkeTop.add(rbtnTopCham);
                pThongkeTop.add(lbStart);
                pThongkeTop.add(Startdate);
                pThongkeTop.add(lbEnd);
                pThongkeTop.add(Enddate);
                pThongkeTop.add(btnThongke);
   
            //--------------------------Panel Content--------------------------------------//
            pContent = new JPanel(null);
            pContent.setBounds(new Rectangle(20,190,1000,650));
            pContent.setBackground(null);
                lbBaocao = new JLabel("Thống kê");
                lbBaocao .setBounds(new Rectangle(200,10,550,30));
                lbBaocao.setHorizontalAlignment(JLabel.CENTER);
                lbBaocao.setFont(fontTK);
                
                lbBc_From = new JLabel("Từ ngày:");
                lbBc_From.setBounds(new Rectangle(300,50,60,30));
                lbBc_From.setFont(fontP);
                
                lb_From = new JLabel("");
                lb_From.setBounds(new Rectangle(370,50,120,30));
                lb_From.setFont(fontP);
                
                lbBc_To = new JLabel("Đến ngày:");
                lbBc_To.setBounds(new Rectangle(550,50,60,30));
                lbBc_To.setFont(fontP);

                lb_To = new JLabel("");
                lb_To.setBounds(new Rectangle(620,50,120,30));
                lb_To.setFont(fontP);
                
                Vector header = new Vector();
                header.add("Mã SP");
                header.add("Tên SP");
                header.add("SLSP");
                header.add("Doanh thu");
                model = new DefaultTableModel(header,0);
                table = new JTable(model);
                table.setRowHeight(30);
                table.getTableHeader().setFont(fontB);
                table.getTableHeader().setOpaque(false);
                table.getTableHeader().setBackground(new Color(232,57,99));
                table.getTableHeader().setForeground(new Color(255,255,225));
                table.setShowVerticalLines(false);   
                table.setSelectionBackground(new Color(32,136,203));
                table.setFont(fontP);
                scroll = new JScrollPane(table);
                scroll.setBounds(new Rectangle(50,100,900,400));
                scroll.setBackground(null);
                scroll.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                
            pContent.add(lbBaocao);
            pContent.add(lbBc_From);
            pContent.add(lbBc_To);
            pContent.add(lb_From);
            pContent.add(lb_To);
            pContent.add(scroll);
        add(pThongkeTop);
        add(pContent);
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == btnThongke)
        {
            if(!rbtnBanHang.isSelected() && !rbtnNhapHang.isSelected() && !rbtnSanPham.isSelected() && !rbtnTopChay.isSelected() && !rbtnTopCham.isSelected())
            {
                JOptionPane.showMessageDialog(null,"Chưa chọn danh mục thống kê");
                return;
            }
            if(Startdate.getDate() == null || Enddate.getDate() == null)
            {
                JOptionPane.showMessageDialog(null,"Chưa chọn ngày");
                return;
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String StartFormat = dateFormat.format(Startdate.getDate());
            String From = StartFormat +" 00:00:00";
            String EndFormat = dateFormat.format(Enddate.getDate());
            String To =  EndFormat+" 23:59:59";
            if(rbtnBanHang.isSelected()) //BÁN HÀNG
            {
                
                lbBaocao.setText("Thống kê hóa đơn bán hàng");
                lb_From.setText(From);
                lb_To.setText(To);
                tkBUS.StatisticalBanHang(From, To);
                
                ArrayList<ThongKeDTO> dstksp = tkBUS.getStatistical();
                
                Vector header = new Vector();
                header.add("Mã HD");
                header.add("SLSP");
                header.add("PTTT");
                header.add("Doanh thu");
                header.add("Thời gian");
                model = new DefaultTableModel(header,0);
                Vector data;
                for(ThongKeDTO tk: dstksp)
                {
                    data = new Vector();
                    data.add(tk.getMahd());
                    data.add(tk.getSlsp());
                    data.add(tk.getThanhtoan());
                    data.add(formatter.format(tk.getTongtienhd()));
                    data.add(tk.getThoigian());
                    model.addRow(data);
                }
                table.setModel(model);
            }
            if(rbtnNhapHang.isSelected()) //NHẬP HÀNG
            {
                 lbBaocao.setText("Thống kê số lượng sản phẩm đã nhập");
                lb_From.setText(From);
                lb_To.setText(To);
                
                tkBUS.StatisticalNhapHang(From, To);
                
                ArrayList<ThongKeDTO> dstksp = tkBUS.getStatistical();
                
                Vector header = new Vector();
                header.add("Mã PNH");
                header.add("SLSP");
                header.add("PTTT");
                header.add("Doanh thu");
                header.add("Thời gian");
                model = new DefaultTableModel(header,0);
                Vector data;
                for(ThongKeDTO tk: dstksp)
                {
                    data = new Vector();
                    data.add(tk.getMahd());
                    data.add(tk.getSlsp());
                    data.add(tk.getThanhtoan());
                    data.add(formatter.format(tk.getTongtienhd()));
                    data.add(tk.getThoigian());
                    model.addRow(data);
                }
                table.setModel(model);
            }
            if(rbtnSanPham.isSelected()) //SẢN PHẨM
            {
               
                lbBaocao.setText("Thống kê sản phẩm đã bán");
                lb_From.setText(From);
                lb_To.setText(To);
                
                
                tkBUS.StatisticalSP(From, To);
                ArrayList<ThongKeDTO> dstksp = tkBUS.getStatistical();
                Vector header = new Vector();
                header.add("Mã SP");
                header.add("Tên SP");
                header.add("SLSP");
                header.add("Doanh thu");
                model = new DefaultTableModel(header,0);
                Vector data;
                for(ThongKeDTO tk: dstksp)
                {
                    data = new Vector();
                    data.add(tk.getMasp());
                    data.add(tk.getTensp());
                    data.add(tk.getSlsp());
                    data.add(formatter.format(tk.getDoanhthu()));
                    model.addRow(data);
                }
                table.setModel(model);   
            }
            if(rbtnTopChay.isSelected()) //TOP 5 SP BANS CHẠY NHẤT
            {
                lbBaocao.setText("Thống kê Top 5 SP bán chạy nhất");
                lb_From.setText(From);
                lb_To.setText(To);
                
                
                tkBUS.Statistical_Top5SPBChay(From, To);
                ArrayList<ThongKeDTO> dstksp = tkBUS.getStatistical();
                Vector header = new Vector();
                header.add("Mã SP");
                header.add("Tên SP");
                header.add("SLSP");
                header.add("Doanh thu");
                model = new DefaultTableModel(header,0);
                Vector data;
                for(ThongKeDTO tk: dstksp)
                {
                    data = new Vector();
                    data.add(tk.getMasp());
                    data.add(tk.getTensp());
                    data.add(tk.getSlsp());
                    data.add(formatter.format(tk.getDoanhthu()));
                    model.addRow(data);
                }
                table.setModel(model);   
            }
            if(rbtnTopCham.isSelected()) // TOP 5 SP BÁN CHẬM NHẤT
            {
                lbBaocao.setText("Thống kê Top 5 SP bán chậm nhất");
                lb_From.setText(From);
                lb_To.setText(To);
                tkBUS.Statistical_Top5SPBCham(From, To);
                ArrayList<ThongKeDTO> dstksp = tkBUS.getStatistical();
                Vector header = new Vector();
                header.add("Mã SP");
                header.add("Tên SP");
                header.add("SLSP");
                header.add("Doanh thu");
                model = new DefaultTableModel(header,0);
                Vector data;
                for(ThongKeDTO tk: dstksp)
                {
                    data = new Vector();
                    data.add(tk.getMasp());
                    data.add(tk.getTensp());
                    data.add(tk.getSlsp());
                    data.add(formatter.format(tk.getDoanhthu()));
                    model.addRow(data);
                }
                table.setModel(model);   
            }
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
}

