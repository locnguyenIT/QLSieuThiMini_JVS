/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.MySQLConnect;
import DTO.NguoiDungDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ntloc
 */
public class NguoiDungDAO {
    
     private MySQLConnect mySQL = new MySQLConnect();
     
     public NguoiDungDAO(){}
     
     public ArrayList<NguoiDungDTO> DanhSachNguoiDung()
    {
        ArrayList<NguoiDungDTO> dsnd = new ArrayList<>();
        try {
            String Query = "SELECT * FROM nguoidung";
            ResultSet result = mySQL.excuteQuery(Query);
            while(result.next())
            {
                String id = result.getString("id");
                String username = result.getString("username");
                String password = result.getString("password");
                String role = result.getString("role");
                NguoiDungDTO nd = new NguoiDungDTO(id, username, password, role);
                dsnd.add(nd);
            }
            System.out.println("Query: "+Query);
            result.close();
            mySQL.DisConnect();
           
               
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }   
         return dsnd;
    }
      public void Add(NguoiDungDTO nd)
    {
        String query = "INSERT INTO nguoidung VALUES(";
               query += "'"+nd.getId()+"',";
               query += "N'"+nd.getUsername()+"',";
               query += "N'"+nd.getPassword()+"',";
               query += "'"+nd.getRole()+"')";
        System.out.println("Query: "+query);
        mySQL.excuteUpdate(query);
    }
    public void Delete(String id)
    {
        String query = "DELETE FROM nguoidung  WHERE id = '"+id+"'";
        System.out.println(query);
        mySQL.excuteUpdate(query);
    }
    public void Set(NguoiDungDTO nd)
    {
        String query = "UPDATE nguoidung SET ";
               query += "id = '"+nd.getId()+"',";
               query += "username = N'"+nd.getUsername()+"',";
               query += "password = N'"+nd.getPassword()+"',";
               query += "role = '"+nd.getRole()+"' ";
               query += "WHERE id = '"+nd.getId()+"';";
        System.out.println("Query: "+query);
        mySQL.excuteUpdate(query);     
    }
}
