/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ChiTietPNHDAO;
import DTO.ChiTietPNHDTO;
import java.util.ArrayList;

/**
 *
 * @author ntloc
 */
public class ChiTietPNHBUS {
     private ArrayList<ChiTietPNHDTO> dsctpnh;
    private ChiTietPNHDAO ctpnhDAO;

    public ChiTietPNHBUS() {}
    
    public void DanhSachCTPNH(String mapnh)
    {
        ctpnhDAO = new ChiTietPNHDAO();
        dsctpnh= new ArrayList<>();
        dsctpnh= ctpnhDAO.DanhSachChiTietPNH(mapnh);
    }
    public void Add(ChiTietPNHDTO ctpnh)
    {
            ctpnhDAO = new ChiTietPNHDAO();
            ctpnhDAO.Add(ctpnh);

    }
    public ArrayList<ChiTietPNHDTO> getDsctpnh()
    {
        return dsctpnh;
    }
    public void Delete(String mapnh)
    {
        ctpnhDAO = new ChiTietPNHDAO();
        ctpnhDAO.Delete(mapnh);

    }
    public void Delete_CTPNH(String mapnh, String masp)
    {
        ctpnhDAO = new ChiTietPNHDAO();
        //dscthd.remove(cthd);
        ctpnhDAO.Delete_CTPNH(mapnh,masp);
       
    }
    public void Set(ChiTietPNHDTO ctpnh, String value)
    {
        ctpnhDAO = new ChiTietPNHDAO();
        ctpnhDAO.Set(ctpnh,value);
    }
     public void Set_SL_SP(String mahd, String masp)
    {
         ctpnhDAO = new ChiTietPNHDAO();
        ctpnhDAO.Set_SL_SP(mahd, masp);
    }
    public void Update_SLSP_AfterDeleteCTHD(String mahd, String masp)
    {
         ctpnhDAO = new ChiTietPNHDAO();
        ctpnhDAO.Update_SLSP_AfterDeleteCTHD(mahd, masp);
    }
}
