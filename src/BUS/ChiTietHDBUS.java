/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ChiTietHDDAO;
import DAO.SanPhamDAO;
import DTO.ChiTietHDDTO;
import java.util.ArrayList;

/**
 *
 * @author ntloc
 */
public class ChiTietHDBUS {
    
    private ArrayList<ChiTietHDDTO> dscthd;
    private ChiTietHDDAO cthdDAO;

    public ChiTietHDBUS() {}
    
    public void DanhSachCTHD()
    {
        cthdDAO = new ChiTietHDDAO();
        dscthd = new ArrayList<>();
        dscthd = cthdDAO.DanhSachChiTietHD();
    }
    public void Add(ChiTietHDDTO cthd)
    {
            cthdDAO = new ChiTietHDDAO();
            cthdDAO.Add(cthd);

    }
    public ArrayList<ChiTietHDDTO> getDscthd()
    {
        return dscthd;
    }
    public ArrayList<ChiTietHDDTO> DanhSachCTHD(String mahd)
    {
        
        ArrayList<ChiTietHDDTO> ds = new ArrayList<>();
        for(ChiTietHDDTO cthd : dscthd)
        {
            if(cthd.getMahd().equals(mahd))
            {
                ds.add(cthd);
            }
        }
        return ds;
    }
    public void Delete(String mahd)
    {
        for(ChiTietHDDTO cthd : dscthd)
        {
            if(cthd.getMahd().equals(mahd))
            {
                dscthd.remove(cthd);
                cthdDAO = new ChiTietHDDAO();
                cthdDAO.Delete(mahd);
                return;
            }
        } 
    }
    public void Delete_CTHD(ChiTietHDDTO cthd)
    {
        cthdDAO = new ChiTietHDDAO();
        //dscthd.remove(cthd);
        cthdDAO.Delete_CTHD(cthd);
       
    }
    public void Delete_Mahd_Masp(String mahd, String masp)
    {
        cthdDAO = new ChiTietHDDAO();
        cthdDAO.Delete_Mahd_Masp(mahd, masp);
    }
    public void Set(ChiTietHDDTO cthd, String value)
    {
        cthdDAO = new ChiTietHDDAO();
        cthdDAO.Set(cthd,value);
    }
 
}
