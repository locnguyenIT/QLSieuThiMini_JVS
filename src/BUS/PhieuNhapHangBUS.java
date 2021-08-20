/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;


import DAO.PhieuNhapHangDAO;
import DTO.PhieuNhapHangDTO;
import java.util.ArrayList;

/**
 *
 * @author ntloc
 */
public class PhieuNhapHangBUS {
     private ArrayList<PhieuNhapHangDTO> dspnh;
    private PhieuNhapHangDAO pnhDAO;

    public PhieuNhapHangBUS() {}
    
    public void DanhSachPNH()
    {
        pnhDAO = new PhieuNhapHangDAO();
        dspnh = new ArrayList<>();
        dspnh = pnhDAO.DanhSachPNH();
    }
    public void Add(PhieuNhapHangDTO pnh)
    {
            pnhDAO = new PhieuNhapHangDAO();
            pnhDAO.Add(pnh);
    }
    
    public void Delete(String mahd)
    {
        for(PhieuNhapHangDTO hd : dspnh)
        {
            if(hd.getMapnh().equals(mahd))
            {
                dspnh.remove(hd);
                pnhDAO = new PhieuNhapHangDAO();
                pnhDAO.Delete(mahd);
                return;
            }
        } 
    }
    public void Set(PhieuNhapHangDTO hd)
    {
        pnhDAO = new PhieuNhapHangDAO();
        pnhDAO.Set(hd);
    }
    public void Set_TongtienHD(String mahd, int tongtienhd)
    {
        pnhDAO = new PhieuNhapHangDAO();
        pnhDAO.Set_TongtienPNH(mahd,tongtienhd);
    }
    public String NextMaHD()
    {
        int max = 0;
        String s ="";
        for(PhieuNhapHangDTO hd : dspnh)
        {
            int id = Integer.parseInt(hd.getMapnh());
            if(id > max)
            {
                max = id;
            }
        }
        for(int i = 0 ; i < 3-String.valueOf(max+1).length();i++ )
        {
            s+="0";
        }
        return s+(max+1);
    }
       public PhieuNhapHangDTO Search_Mapnh(String mapnh)
    {
        for(PhieuNhapHangDTO pnh : dspnh)
        {
            if(pnh.getMapnh().equals(mapnh))
            {
                return pnh;
            }
        }
        return null;
    }
    public ArrayList<PhieuNhapHangDTO> getDspnh()
    {
        return dspnh;
    }
}
