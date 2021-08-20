/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.HoaDonDAO;
import DTO.HoaDonDTO;
import java.util.ArrayList;

/**
 *
 * @author ntloc
 */
public class HoaDonBUS {
    
    private ArrayList<HoaDonDTO> dshd;
    private HoaDonDAO hdDAO;

    public HoaDonBUS() {}
    
    public void DanhSachHD()
    {
        hdDAO = new HoaDonDAO();
        dshd = new ArrayList<>();
        dshd = hdDAO.DanhSachHD();
    }
    public void Add(HoaDonDTO hd)
    {
            hdDAO = new HoaDonDAO();
            hdDAO.Add(hd);
    }
    
    public void Delete(String mahd)
    {
        for(HoaDonDTO hd : dshd)
        {
            if(hd.getMahd().equals(mahd))
            {
                dshd.remove(hd);
                hdDAO = new HoaDonDAO();
                hdDAO.Delete(mahd);
                return;
            }
        } 
    }
    public void Set(HoaDonDTO hd)
    {
        hdDAO = new HoaDonDAO();
        hdDAO.Set(hd);
    }
    public void Set_TongtienHD(String mahd, int tongtienhd)
    {
        hdDAO = new HoaDonDAO();
        hdDAO.Set_TongtienHD(mahd,tongtienhd);
    }
    public String NextMaHD()
    {
        int max = 0;
        String s ="";
        for(HoaDonDTO hd : dshd)
        {
            int id = Integer.parseInt(hd.getMahd());
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
    public HoaDonDTO Search_Mahd(String mahd)
    {
        for(HoaDonDTO hd : dshd)
        {
            if(hd.getMahd().equals(mahd))
            {
                return hd;
            }
        }
        return null;
    }
    public ArrayList<HoaDonDTO> getDshd()
    {
        return dshd;
    }
    
}
