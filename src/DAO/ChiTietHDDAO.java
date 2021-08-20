/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.MySQLConnect;
import DTO.ChiTietHDDTO;
import DTO.SanPhamDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ntloc
 */
public class ChiTietHDDAO {
    private MySQLConnect mySQL = new MySQLConnect();
    private static int sl = 0; 
    public ChiTietHDDAO() {}
    
    public ArrayList<ChiTietHDDTO> DanhSachChiTietHD()
    {
        ArrayList<ChiTietHDDTO> dscthd = new ArrayList<>();
        try {
            String Query = "SELECT * FROM chitiethd";
            ResultSet result = mySQL.excuteQuery(Query);
            while(result.next())
            {
                String mahd = result.getString("mahd");
                String masp = result.getString("masp");
                String tensp = result.getString("tensp");
                int dongia = result.getInt("dongia");
                int soluong = result.getInt("soluong");
                int thanhtien = result.getInt("thanhtien");
                int giamgia = result.getInt("giamgia");
                int tongtien = result.getInt("tongtien");
                
                ChiTietHDDTO cthd = new ChiTietHDDTO(mahd,masp, tensp, dongia, soluong, thanhtien, giamgia, tongtien);
                dscthd.add(cthd);
            }
            System.out.println("Query: "+Query);
            result.close();
            mySQL.DisConnect();
           
               
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return dscthd;
    }
    public void Add(ChiTietHDDTO cthd)
    {
         String query = "INSERT INTO chitiethd VALUES(";
               query += "'"+cthd.getMahd()+"',"; 
               query += "'"+cthd.getMasp()+"',";
               query += "N'"+cthd.getTensp()+"',";
               query += "'"+cthd.getDongia()+"',";
               query += "'"+cthd.getSl()+"',";
               query += "'"+cthd.getThanhtien()+"',";
               query += "'"+cthd.getGiamgia()+"',";
               query += "'"+cthd.getTongtien()+"')";
        System.out.println("Query: "+query);
        mySQL.excuteUpdate(query);
    }
    public void Delete(String  mahd)
    {
        String query = "DELETE FROM chitiethd WHERE mahd = '"+mahd+"'";
        System.out.println(query);
        mySQL.excuteUpdate(query);
    }
     public void Delete_Mahd_Masp(String  mahd, String masp)
    {
        String query = "DELETE FROM chitiethd WHERE mahd = '"+mahd+"'";
                query+=" AND masp = '"+masp+"'";
        System.out.println(query);
        mySQL.excuteUpdate(query);
    }
    public void Delete_CTHD(ChiTietHDDTO cthd)
    {
        String query = "DELETE FROM chitiethd";
               query+=" WHERE mahd = '"+cthd.getMahd()+"'";
               query+=" AND masp = '"+cthd.getMasp()+"'";
        System.out.println(query);
        mySQL.excuteUpdate(query);
    }
    public void Set(ChiTietHDDTO cthd, String value)
    {
        
        String query = "UPDATE chitiethd SET ";
               query += "mahd = '"+cthd.getMahd()+"',"; 
               query += "masp = '"+cthd.getMasp()+"',";
               query += "tensp = N'"+cthd.getTensp()+"',";
               query += "dongia = '"+cthd.getDongia()+"',";
               query += "soluong = '"+cthd.getSl()+"',";
               query += "thanhtien= '"+cthd.getThanhtien()+"',";
               query += "giamgia = '"+cthd.getGiamgia()+"',";
               query += "tongtien = '"+cthd.getTongtien()+"' ";
               query += "WHERE mahd = '"+cthd.getMahd()+"' ";
               query += "AND masp = '"+value+"';";
        System.out.println("Query: "+query);
        mySQL.excuteUpdate(query);     
    }
 
 
}
