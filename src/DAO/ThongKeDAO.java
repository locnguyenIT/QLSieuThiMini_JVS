/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.MySQLConnect;
import DTO.ThongKeDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ntloc
 */
public class ThongKeDAO {
     private MySQLConnect mySQL = new MySQLConnect();
     
     public ThongKeDAO(){}
     
     public ArrayList<ThongKeDTO> StatisticalSanPham(String FromDate, String ToDate)
     {
        ArrayList<ThongKeDTO> dssp = new ArrayList<>();
        try {
        String query = "SELECT cthd.masp,cthd.tensp, SUM(cthd.soluong) AS SLSP, SUM(cthd.tongtien) AS DoanhThu \n" +
                       "FROM `chitiethd` AS cthd, `hoadon` AS hd \n" +
                       "WHERE cthd.mahd = hd.mahd \n" +
                       "AND hd.thoigian BETWEEN '"+FromDate+"' AND '"+ToDate+"' \n" +
                       "GROUP BY cthd.masp";
         System.out.println(query);
         ResultSet result = mySQL.excuteQuery(query);
         while(result.next())
         {
             String masp = result.getString("masp");
             String tensp = result.getString("tensp");
             int slsp = result.getInt("SLSP");
             int doanhthu = result.getInt("DoanhThu");

             ThongKeDTO thongke = new ThongKeDTO(masp, tensp, slsp, doanhthu);
             dssp.add(thongke);
         }
         } catch (SQLException ex) {
             Logger.getLogger(ThongKeDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         return  dssp;
     }
    public ArrayList<ThongKeDTO> StatisticalBanHang(String FromDate, String ToDate)
    {
        ArrayList<ThongKeDTO> dssp = new ArrayList<>();
        try {
        String query = "SELECT hd.mahd, SUM(cthd.soluong) AS SLSP, hd.thanhtoan,hd.tongtienhd, hd.thoigian\n" +
                       "FROM `chitiethd` AS cthd, `hoadon` AS hd\n" +
                       "WHERE cthd.mahd = hd.mahd\n" +
                       "AND hd.thoigian BETWEEN '"+FromDate+"' AND '"+ToDate+"' \n" +
                       "GROUP BY hd.mahd";
         System.out.println(query);
         ResultSet result = mySQL.excuteQuery(query);
         while(result.next())
         {
             String mahd = result.getString("mahd");
             int slsp = result.getInt("SLSP");
             String thanhtoan = result.getString("thanhtoan");
             int doanhthu = result.getInt("tongtienhd");
             String thoigian = result.getString("thoigian");

             ThongKeDTO thongke = new ThongKeDTO(mahd,slsp,thanhtoan,doanhthu, thoigian);
             dssp.add(thongke);
         }
         } catch (SQLException ex) {
             Logger.getLogger(ThongKeDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         return  dssp;
     }
    public ArrayList<ThongKeDTO> StatisticalNhapHang(String FromDate, String ToDate)
    {
        ArrayList<ThongKeDTO> dssp = new ArrayList<>();
        try {
        String query = "SELECT pnh.mapnh, SUM(ctpnh.soluong) AS SLSP, pnh.thanhtoan,pnh.tongtienpnh,pnh.thoigian \n" +
                       "FROM `chitietpnh` AS ctpnh, `phieunhaphang` AS pnh\n" +
                       "WHERE ctpnh.mapnh = pnh.mapnh\n" +
                       "AND pnh.thoigian BETWEEN '"+FromDate+"' AND '"+ToDate+"' \n" +
                       "GROUP BY pnh.mapnh";
         System.out.println(query);
         ResultSet result = mySQL.excuteQuery(query);
         while(result.next())
         {
             String mapnh = result.getString("mapnh");
             int slsp = result.getInt("SLSP");
             String thanhtoan = result.getString("thanhtoan");
             int doanhthu = result.getInt("tongtienpnh");
             String thoigian = result.getString("thoigian");

             ThongKeDTO thongke = new ThongKeDTO(mapnh,slsp,thanhtoan,doanhthu, thoigian);
             dssp.add(thongke);
         }
         } catch (SQLException ex) {
             Logger.getLogger(ThongKeDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         return  dssp;
     }
    public ArrayList<ThongKeDTO> StatisticalTop5_SPBChay(String FromDate, String ToDate)
    {
        ArrayList<ThongKeDTO> dssp = new ArrayList<>();
        try {
        String query = "SELECT  cthd.masp, cthd.tensp, SUM(soluong) AS SLSP, SUM(tongtien) AS Doanhthu\n" +
                       "FROM `chitiethd` AS cthd, `hoadon` AS hd \n" +
                       "WHERE cthd.mahd = hd.mahd\n" +
                       "AND hd.thoigian BETWEEN '"+FromDate+"' AND '"+ToDate+"' \n" +
                       "GROUP BY cthd.masp\n" +
                       "ORDER BY SUM(soluong) DESC\n" +
                       "LIMIT 5 ";
         System.out.println(query);
         ResultSet result = mySQL.excuteQuery(query);
         while(result.next())
         {
             String masp = result.getString("masp");
             String tensp = result.getString("tensp");
             int slsp = result.getInt("SLSP");
             int doanhthu = result.getInt("Doanhthu");

             ThongKeDTO thongke = new ThongKeDTO(masp, tensp, slsp, doanhthu);
             dssp.add(thongke);
         }
         } catch (SQLException ex) {
             Logger.getLogger(ThongKeDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         return  dssp;
     }
    public ArrayList<ThongKeDTO> StatisticalTop5_SPBCham(String FromDate, String ToDate)
    {
        ArrayList<ThongKeDTO> dssp = new ArrayList<>();
        try {
        String query = "SELECT  cthd.masp, cthd.tensp, SUM(soluong) AS SLSP, SUM(tongtien) AS Doanhthu\n" +
                       "FROM `chitiethd` AS cthd, `hoadon` AS hd \n" +
                       "WHERE cthd.mahd = hd.mahd\n" +
                       "AND hd.thoigian BETWEEN '"+FromDate+"' AND '"+ToDate+"' \n" +
                       "GROUP BY cthd.masp\n" +
                       "ORDER BY SUM(soluong) ASC\n" +
                       "LIMIT 5 ";
         System.out.println(query);
         ResultSet result = mySQL.excuteQuery(query);
         while(result.next())
         {
             String masp = result.getString("masp");
             String tensp = result.getString("tensp");
             int slsp = result.getInt("SLSP");
             int doanhthu = result.getInt("Doanhthu");

             ThongKeDTO thongke = new ThongKeDTO(masp, tensp, slsp, doanhthu);
             dssp.add(thongke);
         }
         } catch (SQLException ex) {
             Logger.getLogger(ThongKeDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         return  dssp;
     }
    

}
