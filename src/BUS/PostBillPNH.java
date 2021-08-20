/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;



import DTO.ChiTietPNHDTO;
import DTO.PhieuNhapHangDTO;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import static com.itextpdf.text.PageSize.A4;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ntloc
 */
public class PostBillPNH {
    
    private String file ="";
    private ArrayList<ChiTietPNHDTO> dsctpnh = new ArrayList<>();
    private PhieuNhapHangDTO pnh;
    private BaseFont bf;
    private DecimalFormat formatter = new DecimalFormat("###,###,###.##"); //Format number
    String uderline = "--";
    public PostBillPNH()
    {
        
    }
    public PostBillPNH(PhieuNhapHangDTO pnh, ArrayList<ChiTietPNHDTO> dsctpnh)
    {
        this.pnh = pnh;
        this.file = "./billPNH/PNH_"+pnh.getMapnh()+".pdf";
        this.dsctpnh= dsctpnh;
    }
    public void PrintBill() 
    {
        
        Document document = new Document(A4, 15, 15, 10, 10); //Tao Document
        try {
            bf = BaseFont.createFont("./font/times.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            PdfWriter.getInstance(document,new FileOutputStream(file)); //Tao PdfWriter để ghi
            document.open();
            Paragraph header = new Paragraph("SIÊU THỊ MINI POPPY\n",new Font(bf,25,Font.BOLD));
            header.setAlignment(Element.ALIGN_CENTER);
            
            Image img = Image.getInstance("./src/image/super_market_45px.png");
            img.setAlignment(Element.ALIGN_CENTER);
            
            Paragraph diachi = new Paragraph("122 An Bình, P5, Q5, TP.HCM",new Font(bf,16,Font.NORMAL));
            diachi.setAlignment(Element.ALIGN_CENTER);
            
            
            
            Paragraph sdt = new Paragraph("Tel: 0369257620",new Font(bf,16,Font.NORMAL));
            sdt.setAlignment(Element.ALIGN_CENTER);
            
            Paragraph email = new Paragraph("Emai: ntloc.developer@gmail.com",new Font(bf,16,Font.NORMAL));
            email.setAlignment(Element.ALIGN_CENTER);
            
            Paragraph title = new Paragraph("PHIẾU NHẬP HÀNG",new Font(bf,18,Font.BOLD));
            title.setAlignment(Element.ALIGN_CENTER);
            
            Paragraph input = new Paragraph("Mã PNH: "+pnh.getMapnh()+"            Ngày: "+pnh.getDate()+"",new Font(bf,14,Font.NORMAL));
            input.setAlignment(Element.ALIGN_CENTER);
            
            Paragraph ttnv = new Paragraph("THÔNG TIN NHÂN VIÊN",new Font(bf,14,Font.NORMAL));
            ttnv.setAlignment(Element.ALIGN_LEFT);

            Paragraph manv = new Paragraph("Mã NV :    "+pnh.getManv(),new Font(bf,14,Font.NORMAL));
            manv.setAlignment(Element.ALIGN_LEFT);
            
            Paragraph tennv = new Paragraph("Tên NV:    "+pnh.getTennv(),new Font(bf,14,Font.NORMAL));
            tennv.setAlignment(Element.ALIGN_LEFT);
            String line = PrintLine(document);
            Paragraph l = new Paragraph(line);
            
            String[] cellHeader = {"Mã SP","Tên SP","Đơn giá","SL","Thành tiền","Giảm giá (%)","Tổng tiền"};
            PdfPTable table = new PdfPTable(cellHeader.length);
            table.setWidthPercentage(100);
            table.setSpacingBefore(0f);
            table.setSpacingAfter(0f);
            int[] relativeWidths = {20,70,30,20,40,40,40};
            table.setWidths(relativeWidths);
            
           for(String s : cellHeader)
            {
                table.addCell(createCell(s, new Font(bf,13))); //Create header table
            }    
            for(ChiTietPNHDTO cthd : dsctpnh)         //Create cell table
            {
                table.addCell( createCell(cthd.getMasp()));
                table.addCell( createCell(cthd.getTensp()) );
                table.addCell( createCell(String.valueOf(formatter.format(cthd.getDongia()))));
                table.addCell( createCell(String.valueOf(cthd.getSl())));
                table.addCell( createCell(String.valueOf(formatter.format(cthd.getThanhtien()))));
                table.addCell( createCell(String.valueOf(cthd.getGiamgia())));
                table.addCell( createCell(String.valueOf(formatter.format(cthd.getTongtien())))).setHorizontalAlignment(Element.ALIGN_RIGHT);
            }
            String line_1 = PrintLine(document);
            Paragraph l_1 = new Paragraph(line_1);
            int sl = TotalSL();
            Paragraph slsp = new Paragraph("Tổng SLSP:               "+sl+"",new Font(bf,14,Font.NORMAL));
            slsp.setAlignment(Element.ALIGN_LEFT);
            int tt = TotalTien();
            Paragraph tongtien = new Paragraph("Tổng tiền PNH:           "+formatter.format(tt)+"",new Font(bf,14,Font.NORMAL));
            tongtien.setAlignment(Element.ALIGN_LEFT);
           
            Paragraph pttt = new Paragraph("PT Thanh toán:          "+pnh.getThanhtoan()+"",new Font(bf,14,Font.NORMAL));
            pttt.setAlignment(Element.ALIGN_LEFT);
            
            String line_2 = PrintLine(document);
            Paragraph l_2 = new Paragraph(line_2);
            
            Paragraph ttkh = new Paragraph("THÔNG TIN NHÀ CUNG CẤP",new Font(bf,14,Font.NORMAL));
            ttkh.setAlignment(Element.ALIGN_LEFT);
            
            Paragraph makh = new Paragraph("Mã NCC :    "+pnh.getMancc(),new Font(bf,14,Font.NORMAL));
            makh.setAlignment(Element.ALIGN_LEFT);
            Paragraph tenkh = new Paragraph("Tên NCC:    "+pnh.getTenncc(),new Font(bf,14,Font.NORMAL));
            tenkh.setAlignment(Element.ALIGN_LEFT);
            
            Paragraph line_out = new Paragraph("-------------------------------------------"
                                                + "-----------------------");
            line_out.setAlignment(Element.ALIGN_CENTER);
            
            Paragraph thanks = new Paragraph("Cảm ơn Quý khách",new Font(bf,14,Font.NORMAL));
            thanks.setAlignment(Element.ALIGN_CENTER);
            
            Paragraph again = new Paragraph("Hẹn gặp lại",new Font(bf,14,Font.NORMAL));
            again.setAlignment(Element.ALIGN_CENTER);
            
            document.add(header);
            document.add(img);
            document.add(diachi);
            document.add(sdt);
            document.add(email);
            document.add(title);
            document.add(input);
            document.add(ttnv);
            document.add(manv);
            document.add(tennv);
            document.add(l);
            document.add(table);
            document.add(l_1);
            document.add(slsp);
            document.add(tongtien);
            document.add(pttt);
            document.add(l_2);
            document.add(ttkh);
            document.add(makh);
            document.add(tenkh);
            document.add(line_out);
            document.add(thanks);
            document.add(again);
            document.close();
            
            JOptionPane.showMessageDialog(null, "In Bill hoàn tất");
            
            
        } catch (Exception ex) {
            Logger.getLogger(PostBill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String PrintLine(Document document)
    {
            String line = "";
            for(int i = 0 ; i < document.getPageSize().getWidth()/8.5; i++)
            {
                line += uderline;
            }
            return line;
    }
     public PdfPCell createCell(String s)
    {
        PdfPCell cell = new PdfPCell(new Phrase(s,new Font(bf,13)));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPaddingBottom(10);
        
        return cell;
    }
     public PdfPCell createCell(String s,Font font)
    {
        PdfPCell cell = new PdfPCell(new Phrase(s,font));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPaddingBottom(10);
        return cell;
    }
     public int TotalSL()
     {
         int count =0;
         for(ChiTietPNHDTO cthd : dsctpnh)
         {
             count += cthd.getSl();
         }
         return count;
     }
     public int TotalTien()
     {
         int count =0;
         for(ChiTietPNHDTO cthd : dsctpnh)
         {
             count += cthd.getTongtien();
         }
         return count;
     }
}
