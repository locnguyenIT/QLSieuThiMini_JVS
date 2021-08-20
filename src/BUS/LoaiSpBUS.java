/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.LoaiSpDAO;
import DTO.LoaiSpDTO;
import java.util.ArrayList;

/**
 *
 * @author ntloc
 */
public class LoaiSpBUS {
    private ArrayList<LoaiSpDTO> dsloaisp;
    private LoaiSpDAO loaiDAO;

    public LoaiSpBUS() {}
    
    public void DanhSachLoaiSp()
    {
        loaiDAO = new LoaiSpDAO();
        dsloaisp = new ArrayList<>();
        dsloaisp = loaiDAO.DanhSachLoaiSP();
    }
    
    public Object SearchLoaiSP(String maloai)
    {
        for(LoaiSpDTO loai: dsloaisp)
        {
            if(loai.getMaloai().equals(maloai))
            {
                return loai;
            }
        }
        return null;
    }
    public ArrayList<LoaiSpDTO> getDSLSP()
    {
        return dsloaisp;
    }
    
}
