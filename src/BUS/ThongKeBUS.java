/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ThongKeDAO;
import DTO.ThongKeDTO;
import java.util.ArrayList;

/**
 *
 * @author ntloc
 */
public class ThongKeBUS {
    private ArrayList<ThongKeDTO> dssp;
    private ThongKeDAO tkDAO;
    
    public ThongKeBUS(){}
    
    public void StatisticalBanHang(String FromDate, String ToDate)
    {
        tkDAO = new ThongKeDAO();
        dssp = new ArrayList<>();
        dssp = tkDAO.StatisticalBanHang(FromDate,ToDate);
    }
    public void StatisticalNhapHang(String FromDate, String ToDate)
    {
        tkDAO = new ThongKeDAO();
        dssp = new ArrayList<>();
        dssp = tkDAO.StatisticalNhapHang(FromDate,ToDate);
    }
    
    public void StatisticalSP(String FromDate, String ToDate)
    {
        tkDAO = new ThongKeDAO();
        dssp = new ArrayList<>();
        dssp = tkDAO.StatisticalSanPham(FromDate,ToDate);
    }
    
    public void Statistical_Top5SPBChay(String FromDate, String ToDate)
    {
        tkDAO = new ThongKeDAO();
        dssp = new ArrayList<>();
        dssp = tkDAO.StatisticalTop5_SPBChay(FromDate, ToDate);
    }
    public void Statistical_Top5SPBCham(String FromDate, String ToDate)
    {
        tkDAO = new ThongKeDAO();
        dssp = new ArrayList<>();
        dssp = tkDAO.StatisticalTop5_SPBCham(FromDate, ToDate);
    }
   
    public ArrayList<ThongKeDTO> getStatistical()
    {
        return dssp;
    }
}
