/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.MySQLConnect;
import DTO.KhachHangDTO;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author ntloc
 */
public class KhachHangDAO {
     private MySQLConnect mySQL = new MySQLConnect();
    
    public KhachHangDAO(){}
    
    public ArrayList<KhachHangDTO> DanhSachKhachHang()
    {
        mySQL.Connect();
        ArrayList<KhachHangDTO> dskh = new ArrayList<>();
        try {
            String Query = "SELECT * FROM khachhang";
            System.out.println(Query);
            ResultSet result = mySQL.excuteQuery(Query);
            while(result.next())
            {
                String manv = result.getString("makh");
                String honv = result.getString("hokh");
                String tennv = result.getString("tenkh");
                String diachi = result.getString("diachi");
                String sdt = result.getString("sdt");
                String email = result.getString("email");
                
                KhachHangDTO kh = new KhachHangDTO(manv, honv, tennv, diachi, sdt,email);
                dskh.add(kh);
            }
            result.close();
            mySQL.DisConnect();
           
               
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         return dskh;
    }
      public void Add(KhachHangDTO kh)
    {
        String query = "INSERT INTO khachhang VALUES(";
               query += "'"+kh.getMakh()+"',";
               query += "N'"+kh.getHokh()+"',";
               query += "N'"+kh.getTenkh()+"',";
               query += "N'"+kh.getDiachi()+"',";
               query += "'"+kh.getSdt()+"',";
               query += "'"+kh.getEmail()+"')";
        System.out.println("Query: "+query);
        mySQL.excuteUpdate(query);
    }
    public void Delete(String  makh)
    {
        String query = "DELETE FROM khachhang WHERE makh = '"+makh+"'";
        System.out.println(query);
        mySQL.excuteUpdate(query);
    }
     public void Set(KhachHangDTO kh)
    {
        String query = "UPDATE khachhang SET ";
               query += "makh = '"+kh.getMakh()+"',";
               query += "hokh = N'"+kh.getHokh()+"',";
               query += "tenkh = N'"+kh.getTenkh()+"',";
               query += "diachi = N'"+kh.getDiachi()+"',";
               query += "sdt = '"+kh.getSdt()+"',";
               query += "email = '"+kh.getEmail()+"'";
               query += "WHERE makh = '"+kh.getMakh()+"';";
        System.out.println("Query: "+query);
        mySQL.excuteUpdate(query);     
    }
}
