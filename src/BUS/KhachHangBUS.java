/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.KhachHangDAO;
import DAO.NhanVienDAO;
import DTO.KhachHangDTO;
import java.util.ArrayList;

/**
 *
 * @author ntloc
 */
public class KhachHangBUS {
     private ArrayList<KhachHangDTO> dskh;
    private KhachHangDAO khDAO;
    
    public KhachHangBUS(){}
    
    public void DanhSachKhachHang()
    {
        khDAO = new KhachHangDAO();
        dskh = new ArrayList<>();
        dskh = khDAO.DanhSachKhachHang();
    }
    
    public void Add(KhachHangDTO kh)
    {
        khDAO = new KhachHangDAO();
        khDAO.Add(kh);
    }
    public void Delete(String makh)
    {
        khDAO = new KhachHangDAO();
        khDAO.Delete(makh);
    }
     public void Set(KhachHangDTO kh)
    {
        khDAO = new KhachHangDAO();
        khDAO.Set(kh);
    }
    public KhachHangDTO Search(String makh)
    {
        for(KhachHangDTO kh: dskh)
        {
            if(kh.getMakh().equals(makh))
            {
                return kh;
            }
        }
        return null;
    }
    public String SearchTenkh(String makh)
    {
        for(KhachHangDTO kh: dskh)
        {
            if(kh.getMakh().equals(makh))
            {
                return kh.getHokh()+" "+kh.getTenkh();
            }
        }
        return null;
    }
    public String SearchMakh(String tenkh)
    {
        for(KhachHangDTO kh: dskh)
        {
            if(tenkh.contains(kh.getTenkh()))
            {
                return kh.getMakh();
            }
        }
        return null;
    }
    public ArrayList<KhachHangDTO> getDskh()
    {
        return dskh;
    }
    public String NextMakh()
    {
        int max = 0;
        String s ="";
        for(KhachHangDTO kh : dskh)
        {
            int id = Integer.parseInt(kh.getMakh());
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
}
