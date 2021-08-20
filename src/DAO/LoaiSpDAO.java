/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.MySQLConnect;
import DTO.LoaiSpDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ntloc
 */
public class LoaiSpDAO {
     private MySQLConnect mySQL = new MySQLConnect();
     public LoaiSpDAO(){}
     
    public ArrayList<LoaiSpDTO> DanhSachLoaiSP()
    {
        ArrayList<LoaiSpDTO> dsloaisp = new ArrayList<>();
        try {
            String Query = "SELECT * FROM loaisp";
            ResultSet result = mySQL.excuteQuery(Query);
            while(result.next())
            {
                String maloai = result.getString("maloai");
                String tenloai = result.getString("tenloai");
               
                
                LoaiSpDTO loai = new LoaiSpDTO(maloai, tenloai);
                dsloaisp.add(loai);
            }
            System.out.println("Query: "+Query);
            result.close();
            mySQL.DisConnect();
           
               
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }   
         return dsloaisp;
    }
      
}
