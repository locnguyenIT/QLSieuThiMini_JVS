/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.MySQLConnect;
import DTO.LoaiSpDTO;
import DTO.NhaCungCapDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ntloc
 */
public class NhaCungCapDAO {
     private MySQLConnect mySQL = new MySQLConnect();
     public NhaCungCapDAO(){}
     
    public ArrayList<NhaCungCapDTO> DanhSachNCC()
    {
        ArrayList<NhaCungCapDTO> dsncc = new ArrayList<>();
        try {
            String Query = "SELECT * FROM nhacungcap";
            ResultSet result = mySQL.excuteQuery(Query);
            while(result.next())
            {
                String mancc = result.getString("mancc");
                String tenncc = result.getString("tenncc");
                String diachi = result.getString("diachi");
                String mst = result.getString("mst");
                String fax = result.getString("fax");
                NhaCungCapDTO ncc = new NhaCungCapDTO(mancc, tenncc,diachi,mst,fax);
                dsncc.add(ncc);
            }
            System.out.println("Query: "+Query);
            result.close();
            mySQL.DisConnect();
           
               
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }   
         return dsncc;
    }
    public void Add(NhaCungCapDTO ncc)
    {
        String query = "INSERT INTO nhacungcap VALUES(";
               query += "'"+ncc.getMancc()+"',";
               query += "N'"+ncc.getTenncc()+"',";
               query += "N'"+ncc.getDiachi()+"',";
               query += "'"+ncc.getMst()+"',";
               query += "'"+ncc.getFax()+"')";
        System.out.println("Query: "+query);
        mySQL.excuteUpdate(query);
    }
    public void Delete(String  mancc)
    {
        String query = "DELETE FROM nhacungcap WHERE mancc = '"+mancc+"'";
        System.out.println(query);
        mySQL.excuteUpdate(query);
    }
     public void Set(NhaCungCapDTO ncc)
    {
        String query = "UPDATE nhacungcap SET ";
               query += "mancc = '"+ncc.getMancc()+"',";
               query += "tenncc = N'"+ncc.getTenncc()+"',";
               query += "diachi = N'"+ncc.getDiachi()+"',";
               query += "mst = '"+ncc.getMst()+"',";
               query += "fax = '"+ncc.getFax()+"'";
               query += "WHERE mancc = '"+ncc.getMancc()+"';";
        System.out.println("Query: "+query);
        mySQL.excuteUpdate(query);     
    }
}
