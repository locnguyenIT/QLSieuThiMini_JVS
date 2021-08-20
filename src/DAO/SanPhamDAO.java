/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Connection.MySQLConnect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import DTO.SanPhamDTO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author ntloc
 */
public class SanPhamDAO {
    private MySQLConnect mySQL = new MySQLConnect();
    public SanPhamDAO(){}
    public ArrayList<SanPhamDTO> DanhSachSanPham()
    {
       ArrayList<SanPhamDTO> dssp = new ArrayList<>();
        try {
            String Query = "SELECT * FROM sanpham";
            ResultSet result = mySQL.excuteQuery(Query);
            while(result.next())
            {
                String masp = result.getString("masp");
                String tensp = result.getString("tensp");
                int dongia = result.getInt("dongia");
                int soluong = result.getInt("soluong");
                String donvitinh = result.getString("donvitinh");
                String maloai = result.getString("maloai");
                String mancc= result.getString("mancc");
                String image = result.getString("image");
                
                SanPhamDTO sp = new SanPhamDTO(masp, tensp,dongia, soluong,  donvitinh, maloai, mancc, image);
                dssp.add(sp);
            }
            System.out.println("Query: "+Query);
            result.close();
            mySQL.DisConnect();
           
               
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return dssp;
    }
    public void Add(SanPhamDTO sp)
    {
        String query = "INSERT INTO sanpham VALUES(";
               query += "'"+sp.getMasp()+"',";
               query += "N'"+sp.getTensp()+"',";
                query += "'"+sp.getDongia()+"',";
               query += "'"+sp.getSl()+"',";
               query += "N'"+sp.getDvt()+"',";
               query += "'"+sp.getMaloai()+"',";
               query += "'"+sp.getMancc()+"',";
               query += "'"+sp.getImage()+"')";
        System.out.println("Query: "+query);
        mySQL.excuteUpdate(query);
    }
    public void Delete(String  masp)
    {
        String query = "DELETE FROM sanpham WHERE masp = '"+masp+"'";
        System.out.println(query);
        mySQL.excuteUpdate(query);
    }
    public void Set_SLSP(String masp, int sl)
    {
        String query = "UPDATE sanpham SET ";
               query += "soluong = '"+sl+"' ";
               query += "WHERE masp = '"+masp+"'";
        System.out.println("Query: "+query);
        mySQL.excuteUpdate(query);     
    }
    public void Set(SanPhamDTO sp)
    {
        String query = "UPDATE sanpham SET ";
               query += "masp = '"+sp.getMasp()+"',";
               query += "tensp = N'"+sp.getTensp()+"',";
               query += "dongia = '"+sp.getDongia()+"',";
               query += "soluong = '"+sp.getSl()+"',";
               query += "donvitinh = N'"+sp.getDvt()+"',";
               query += "maloai = '"+sp.getMaloai()+"',";
               query += "mancc = '"+sp.getMancc()+"',";
               query += "image = '"+sp.getImage()+"' ";
               query += "WHERE masp = '"+sp.getMasp()+"';";
        System.out.println("Query: "+query);
        mySQL.excuteUpdate(query);     
    }
    
    public SanPhamDTO Search(String masp)
    {
        SanPhamDTO search = null;  //Tạo object để lưu Result
        String query = "SELECT * FROM sanpham ";
               query += "WHERE masp LIKE '%"+masp+"%';";
        System.out.println(query);
        ResultSet result = mySQL.excuteQuery(query);
        try {
            while(result.next())
            {
                masp = result.getString("masp");
                String tensp = result.getString("tensp");
                int dongia = result.getInt("dongia");
                int soluong = result.getInt("soluong");
                String donvitinh = result.getString("donvitinh");
                String maloai = result.getString("maloai");
                String mancc= result.getString("mancc");
                String image = result.getString("image");
                
                search = new SanPhamDTO(masp, tensp,dongia, soluong,  donvitinh, maloai, mancc, image);
            }
            result.close();
            mySQL.DisConnect();
            
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return search; //Sau khi Select xong trả về Object
    }
    public void Export()
    {
        try {
            String query = "SELECT * FROM sanpham";
            ResultSet result = mySQL.excuteQuery(query);
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet();
            
                    
            XSSFFont font = workbook.createFont();
            font.setFontHeightInPoints((short) 12);
            font.setBold(true);
        
            XSSFCellStyle style = workbook.createCellStyle();
            style.setFont(font);
            
            XSSFRow row = sheet.createRow(0);
            XSSFCell cell;
            cell = row.createCell(0);
            cell.setCellValue("Mã sản phẩm");
            cell.setCellStyle(style);
            cell = row.createCell(1);
            cell.setCellValue("Tên sản phẩm");
            cell.setCellStyle(style);
            cell = row.createCell(2);
            cell.setCellValue("Đơn giá");
            cell.setCellStyle(style);
            cell = row.createCell(3);
            cell.setCellValue("Đơn giá");
            cell.setCellStyle(style);
            cell = row.createCell(4);
            cell.setCellValue("Đơn vị tính");
            cell.setCellStyle(style);
            cell = row.createCell(5);
            cell.setCellValue("Mã loại");
            cell.setCellStyle(style);
            cell = row.createCell(6);
            cell.setCellValue("Mã NCC");
            cell.setCellStyle(style);
            cell = row.createCell(7);
            cell.setCellValue("Image");
            cell.setCellStyle(style);
            int i = 1;
            while(result.next())
            {
                row = sheet.createRow(i);
                cell = row.createCell(0);
                cell.setCellValue(result.getString("masp"));
                cell = row.createCell(1);
                cell.setCellValue(result.getString("tensp"));
                cell = row.createCell(2);
                cell.setCellValue(result.getInt("dongia"));
                cell = row.createCell(3);
                cell.setCellValue(result.getInt("soluong"));
                cell = row.createCell(4);
                cell.setCellValue(result.getString("donvitinh"));
                cell = row.createCell(5);
                cell.setCellValue(result.getString("maloai"));
                cell = row.createCell(6);
                cell.setCellValue(result.getString("mancc"));
                cell = row.createCell(7);
                cell.setCellValue(result.getString("image"));
                i++;    
            }
            for(int colNum = 0;colNum < row.getLastCellNum();colNum++) {
            sheet.autoSizeColumn((short) (colNum));
        }
        
        FileOutputStream out = new FileOutputStream(new File("./data/DanhSachSanPham.xlsx"));
        workbook.write(out);
        out.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         catch (FileNotFoundException ex) {
                Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         catch (IOException ex) {
                Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    public void Import(File file) //1. Import cùng masp thì sẽ update sản phẩm đó
                                  //2. Import masp mới thì insert sản phẩm đó
    {
        try {

            FileInputStream input = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(input);
            XSSFSheet sheet = wb.getSheetAt(0);
            Row row;
            for(int i=1; i<=sheet.getLastRowNum(); i++)
            {
                row = sheet.getRow(i);
                String masp = row.getCell(0).getStringCellValue();
                String tensp = row.getCell(1).getStringCellValue();
                int dongia = (int)row.getCell(2).getNumericCellValue();
                int sl = (int)row.getCell(3).getNumericCellValue();
                String dvt = row.getCell(4).getStringCellValue();
                String maloai = row.getCell(5).getStringCellValue();
                String mancc = row.getCell(6).getStringCellValue();
                String image = row.getCell(7).getStringCellValue();

                String sql = "SELECT * FROM sanpham WHERE masp = '"+masp+"'";
                ResultSet result = mySQL.excuteQuery(sql);
                if(!result.next())
                { 
                     String query = "INSERT INTO sanpham VALUES(";
                       query += "'"+masp+"',";
                       query += "N'"+tensp+"',";
                       query += "'"+dongia+"',";
                       query += "'"+sl+"',";
                       query += "N'"+dvt+"',";
                       query += "'"+maloai+"',";
                       query += "'"+mancc+"',";
                       query += "'"+image+"')";
                System.out.println("Query: "+query);
                mySQL.excuteUpdate(query);
                }
                else
                {
                    String query = "UPDATE sanpham SET ";
                           query += "masp = '"+masp+"',";
                           query += "tensp = N'"+tensp+"',";
                           query += "dongia = '"+dongia+"',";
                           query += "soluong = '"+sl+"',";
                           query += "donvitinh = N'"+dvt+"',";
                           query += "maloai = '"+maloai+"',";
                           query += "mancc = '"+mancc+"',";
                           query += "image = '"+image+"'";
                           query += "WHERE masp = '"+masp+"';";
                    System.out.println("Query: "+query);
                    mySQL.excuteUpdate(query);     
                }
              
                System.out.println("Import thành công");
            }
            input.close();
            //System.out.println("Success import excel to mysql table");
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}
