/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.MySQLConnect;
import DTO.PhieuNhapHangDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ntloc
 */
public class PhieuNhapHangDAO {
       private MySQLConnect mySQL = new MySQLConnect();

    public PhieuNhapHangDAO() {}
    
    public ArrayList<PhieuNhapHangDTO> DanhSachPNH()
    {
        ArrayList<PhieuNhapHangDTO> dspnh = new ArrayList<>();
        try {
            String Query = "SELECT * FROM phieunhaphang";
            ResultSet result = mySQL.excuteQuery(Query);
            while(result.next())
            {
                String mapnh = result.getString("mapnh");
                String manv = result.getString("manv");
                String tennv = result.getString("tennv");
                String mancc = result.getString("mancc");
                String tenncc = result.getString("tenncc");
                int tongtien = result.getInt("tongtienpnh");
                String thanhtoan = result.getString("thanhtoan");
                String thoigian = result.getTimestamp("thoigian").toString();
                String ghichu = result.getString("ghichu");
                PhieuNhapHangDTO pnh = new PhieuNhapHangDTO(mapnh, manv, tennv, mancc, tenncc, tongtien, thanhtoan, thoigian, ghichu);
                dspnh.add(pnh);
                
            }
            System.out.println("Query: "+Query);
            result.close();
            mySQL.DisConnect();
           
               
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return dspnh;
    }
   
    public void Add(PhieuNhapHangDTO hd)
    {
         String query = "INSERT INTO phieunhaphang VALUES(";
               query += "'"+hd.getMapnh()+"',"; 
               query += "'"+hd.getManv()+"',";
               query += "N'"+hd.getTennv()+"',";
               query += "'"+hd.getMancc()+"',";
               query += "N'"+hd.getTenncc()+"',";
               query += "'"+hd.getTongtien()+"',";
               query += "'"+hd.getThanhtoan()+"',";
               query += "'"+hd.getDate()+"',";
               query += "N'"+hd.getGhichu()+"')";
        System.out.println("Query: "+query);
        mySQL.excuteUpdate(query);
    }
     public void Delete(String  mapnh)
    {
        String query = "DELETE FROM phieunhaphang WHERE mapnh = '"+mapnh+"'";
        System.out.println(query);
        mySQL.excuteUpdate(query);
    }
    public void Set(PhieuNhapHangDTO hd)
    {
        String query = "UPDATE phieunhaphang SET ";
               query += "mapnh = '"+hd.getMapnh()+"',";
               query += "manv = '"+hd.getManv()+"',";
               query += "tennv = N'"+hd.getTennv()+"',";
               query += "mancc = '"+hd.getMancc()+"',";
               query += "tenncc = N'"+hd.getTenncc()+"',";
               query += "tongtienpnh = '"+hd.getTongtien()+"',";
               query += "thanhtoan = '"+hd.getThanhtoan()+"',";
               query += "thoigian = '"+hd.getDate()+"',";
               query += "ghichu = N'"+hd.getGhichu()+"'";
               query += "WHERE mapnh = '"+hd.getMapnh()+"';";
        System.out.println("Query: "+query);
        mySQL.excuteUpdate(query);     
    } 
    public void Set_TongtienPNH(String mahd, int tongtienhd)
    {
       
         String query = "UPDATE phieunhaphang SET ";
             query += "tongtienpnh = '"+tongtienhd+"' ";
             query += "WHERE mapnh = '"+mahd+"';";
        System.out.println("Query: "+query);
        mySQL.excuteUpdate(query);     
    }
}
