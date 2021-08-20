/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Connection.MySQLConnect;
import java.util.ArrayList;
import DTO.NhanVienDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ntloc
 */
public class NhanVienDAO {
    private MySQLConnect mySQL = new MySQLConnect();
    
    public NhanVienDAO(){}
    
    public ArrayList<NhanVienDTO> DanhSachNhanVien()
    {
        mySQL.Connect();
        ArrayList<NhanVienDTO> dsnv = new ArrayList<>();
        try {
            String Query = "SELECT * FROM nhanvien";
            System.out.println(Query);
            ResultSet result = mySQL.excuteQuery(Query);
            while(result.next())
            {
                String manv = result.getString("manv");
                String honv = result.getString("honv");
                String tennv = result.getString("tennv");
                String diachi = result.getString("diachi");
                String sdt = result.getString("sdt");
                String gioitinh = result.getString("gioitinh");
                int namsinh = result.getInt("namsinh");
                String image = result.getString("image");
                
                NhanVienDTO nv = new NhanVienDTO(manv, honv, tennv, diachi,sdt,gioitinh,namsinh,  image);
                dsnv.add(nv);
            }
            result.close();
            mySQL.DisConnect();
           
               
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         return dsnv;
    }
      public void Add(NhanVienDTO nv)
    {
        String query = "INSERT INTO nhanvien VALUES(";
               query += "'"+nv.getManv()+"',";
               query += "N'"+nv.getHonv()+"',";
                query += "'"+nv.getTennv()+"',";
               query += "'"+nv.getDiachi()+"',";
               query += "N'"+nv.getSdt()+"',";
               query += "'"+nv.getGioitinh()+"',";
               query += "'"+nv.getNamsinh()+"',";
               query += "'"+nv.getImage()+"')";
        System.out.println("Query: "+query);
        mySQL.excuteUpdate(query);
    }
    public void Delete(String  manv)
    {
        String query = "DELETE FROM nhanvien WHERE manv = '"+manv+"'";
        System.out.println(query);
        mySQL.excuteUpdate(query);
    }
    public void Set(NhanVienDTO nv)
    {
        String query = "UPDATE nhanvien SET ";
               query += "manv = '"+nv.getManv()+"',";
               query += "honv = N'"+nv.getHonv()+"',";
               query += "tennv = N'"+nv.getTennv()+"',";
               query += "diachi = N'"+nv.getDiachi()+"',";
               query += "sdt = N'"+nv.getSdt()+"',";
               query += "gioitinh = '"+nv.getGioitinh()+"',";
               query += "namsinh = '"+nv.getNamsinh()+"',";
               query += "image = '"+nv.getImage()+"' ";
               query += "WHERE manv = '"+nv.getManv()+"';";
        System.out.println("Query: "+query);
        mySQL.excuteUpdate(query);     
    }
}
