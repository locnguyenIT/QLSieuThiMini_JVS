/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.MySQLConnect;
import DTO.ChiTietHDDTO;
import DTO.ChiTietPNHDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ntloc
 */
public class ChiTietPNHDAO {
     private MySQLConnect mySQL = new MySQLConnect();
     private static int sl = 0; 
    public ChiTietPNHDAO() {}
    
    public ArrayList<ChiTietPNHDTO> DanhSachChiTietPNH(String pnh)
    {
        ArrayList<ChiTietPNHDTO> dscthd = new ArrayList<>();
        try {
            String Query = "SELECT * FROM chitietpnh WHERE mapnh ='"+pnh+"'";
            ResultSet result = mySQL.excuteQuery(Query);
            while(result.next())
            {
                String mapnh = result.getString("mapnh");
                String masp = result.getString("masp");
                String tensp = result.getString("tensp");
                int dongia = result.getInt("dongia");
                int soluong = result.getInt("soluong");
                int thanhtien = result.getInt("thanhtien");
                int giamgia = result.getInt("giamgia");
                int tongtien = result.getInt("tongtien");
                
                ChiTietPNHDTO ctpnh = new ChiTietPNHDTO(mapnh,masp, tensp, dongia, soluong, thanhtien, giamgia, tongtien);
                dscthd.add(ctpnh);
            }
            System.out.println("Query: "+Query);
            result.close();
            mySQL.DisConnect();
           
               
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return dscthd;
    }
    public void Add(ChiTietPNHDTO ctpnh)
    {
         String query = "INSERT INTO chitietpnh VALUES(";
               query += "'"+ctpnh.getMapnh()+"',"; 
               query += "'"+ctpnh.getMasp()+"',";
               query += "N'"+ctpnh.getTensp()+"',";
               query += "'"+ctpnh.getDongia()+"',";
               query += "'"+ctpnh.getSl()+"',";
               query += "'"+ctpnh.getThanhtien()+"',";
               query += "'"+ctpnh.getGiamgia()+"',";
               query += "'"+ctpnh.getTongtien()+"')";
        System.out.println("Query: "+query);
        mySQL.excuteUpdate(query);
    }
    public void Delete(String  mapnh)
    {
        String query = "DELETE FROM chitietpnh WHERE mapnh = '"+mapnh+"'";
        System.out.println(query);
        mySQL.excuteUpdate(query);
    }
    public void Delete_CTPNH(String mapnh, String masp)
    {
        String query = "DELETE FROM chitietpnh";
               query+=" WHERE mapnh = '"+mapnh+"'";
               query+=" AND masp = '"+masp+"'";
        System.out.println(query);
        mySQL.excuteUpdate(query);
    }
    public void Set(ChiTietPNHDTO ctpnh, String value)
    {
        
        String query = "UPDATE chitietpnh SET ";
               query += "mapnh = '"+ctpnh.getMapnh()+"',"; 
               query += "masp = '"+ctpnh.getMasp()+"',";
               query += "tensp = N'"+ctpnh.getTensp()+"',";
               query += "dongia = '"+ctpnh.getDongia()+"',";
               query += "soluong = '"+ctpnh.getSl()+"',";
               query += "thanhtien= '"+ctpnh.getThanhtien()+"',";
               query += "giamgia = '"+ctpnh.getGiamgia()+"',";
               query += "tongtien = '"+ctpnh.getTongtien()+"' ";
               query += "WHERE mapnh = '"+ctpnh.getMapnh()+"'";
               query += "AND masp = '"+value+"';";
        System.out.println("Query: "+query);
        mySQL.excuteUpdate(query);     
    }
      public int Set_SL_SP(String mapnh, String masp)
    {
        try {
            String query ="SELECT SUM(sp.soluong - cthd.soluong) AS SL\n" +
                    "                        FROM `sanpham`  AS sp, `chitietpnh` AS cthd \n" +
                    "                        WHERE sp.masp = cthd.masp \n" +
                    "                        AND cthd.mapnh= '"+mapnh+"' \n" +
                    "                        AND cthd.masp = '"+masp+"'";
            System.out.println("Query: "+query);
            ResultSet result = mySQL.excuteQuery(query);
            while(result.next())
            {
               sl = result.getInt("SL");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHDDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println("so luong: "+ sl);
        return sl ;
    }
    public void Update_SLSP_AfterDeleteCTHD(String mapnh, String masp)
    {
            String query ="UPDATE `sanpham`\n" +
                          "SET sanpham.soluong = (SELECT SUM("+sl+"+ cthd.soluong) \n" +
                          "                       FROM `sanpham`  AS sp, `chitietpnh` AS cthd \n" +
                          "                       WHERE sp.masp = cthd.masp \n" +
                          "                       AND cthd.mapnh= '"+mapnh+"' \n" +
                          "                       AND cthd.masp = '"+masp+"')\n" +
                          "WHERE sanpham.masp = '"+masp+"'";
            System.out.println("Query: "+query);
           mySQL.excuteUpdate(query);
    }
}
