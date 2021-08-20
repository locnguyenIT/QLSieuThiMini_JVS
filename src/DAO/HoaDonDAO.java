/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.MySQLConnect;
import DTO.ChiTietHDDTO;
import DTO.HoaDonDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ntloc
 */
public class HoaDonDAO {
     private MySQLConnect mySQL = new MySQLConnect();

    public HoaDonDAO() {}
    
    public ArrayList<HoaDonDTO> DanhSachHD()
    {
        ArrayList<HoaDonDTO> dshd = new ArrayList<>();
        try {
            String Query = "SELECT * FROM hoadon";
            ResultSet result = mySQL.excuteQuery(Query);
            while(result.next())
            {
                String mahd = result.getString("mahd");
                String manv = result.getString("manv");
                String tennv = result.getString("tennv");
                String makh = result.getString("makh");
                String tenkh = result.getString("tenkh");
                int tongtien = result.getInt("tongtienhd");
                String thanhtoan = result.getString("thanhtoan");
                String thoigian = result.getTimestamp("thoigian").toString();
                String ghichu = result.getString("ghichu");
                HoaDonDTO hd = new HoaDonDTO(mahd, manv, tennv, makh, tenkh, tongtien, thanhtoan,thoigian,ghichu);
                dshd.add(hd);
                
            }
            System.out.println("Query: "+Query);
            result.close();
            mySQL.DisConnect();
           
               
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return dshd;
    }
   
    public void Add(HoaDonDTO hd)
    {
         String query = "INSERT INTO hoadon VALUES(";
               query += "'"+hd.getMahd()+"',"; 
               query += "'"+hd.getManv()+"',";
               query += "N'"+hd.getTennv()+"',";
               query += "'"+hd.getMakh()+"',";
               query += "N'"+hd.getTenkh()+"',";
               query += "'"+hd.getTongtien()+"',";
               query += "'"+hd.getThanhtoan()+"',";
               query += "'"+hd.getDate()+"',";
               query += "N'"+hd.getGhichu()+"')";
        System.out.println("Query: "+query);
        mySQL.excuteUpdate(query);
    }
     public void Delete(String  mahd)
    {
        String query = "DELETE FROM hoadon WHERE mahd = '"+mahd+"'";
        System.out.println(query);
        mySQL.excuteUpdate(query);
    }
    public void Set(HoaDonDTO hd)
    {
        String query = "UPDATE hoadon SET ";
               query += "mahd = '"+hd.getMahd()+"',";
               query += "manv = '"+hd.getManv()+"',";
               query += "tennv = N'"+hd.getTennv()+"',";
               query += "makh = '"+hd.getMakh()+"',";
               query += "tenkh = N'"+hd.getTenkh()+"',";
               query += "tongtienhd = '"+hd.getTongtien()+"',";
               query += "thanhtoan = '"+hd.getThanhtoan()+"',";
               query += "thoigian = '"+hd.getDate()+"',";
               query += "ghichu = N'"+hd.getGhichu()+"'";
               query += "WHERE mahd = '"+hd.getMahd()+"';";
        System.out.println("Query: "+query);
        mySQL.excuteUpdate(query);     
    } 
    public void Set_TongtienHD(String mahd, int tongtienhd)
    {
       
         String query = "UPDATE hoadon SET ";
             query += "tongtienhd = '"+tongtienhd+"' ";
             query += "WHERE mahd = '"+mahd+"';";
        System.out.println("Query: "+query);
        mySQL.excuteUpdate(query);     
    }
}
