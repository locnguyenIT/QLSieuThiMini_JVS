/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.NguoiDungDAO;
import DTO.NguoiDungDTO;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author ntloc
 */
public class NguoiDungBUS {
    
    private ArrayList<NguoiDungDTO> dsnd;
    private NguoiDungDAO ndDAO;
     
    public NguoiDungBUS() {}
      
    public void DanhSachNguoiDung()
    {
        ndDAO = new NguoiDungDAO();
        dsnd = new ArrayList<>();
        dsnd = ndDAO.DanhSachNguoiDung();
    }
    public NguoiDungDTO CheckUser(String user, char[] pass)
    {
        for(NguoiDungDTO nd : dsnd)
        {
            char[] correctPass = nd.getPassword().toCharArray();
            if(nd.getUsername().equals(user) && Arrays.equals(pass,correctPass))
            {
                return nd;
            }
        }
        return null;
    }
     public void Add(NguoiDungDTO nd)
    {
        ndDAO = new NguoiDungDAO();
        ndDAO.Add(nd);
    }
    public void Delete(String id)
    {
        ndDAO= new NguoiDungDAO();
        ndDAO.Delete(id);
    }
    public void Set(NguoiDungDTO nd)
    {
        ndDAO = new NguoiDungDAO();
        ndDAO.Set(nd);
    }
    public ArrayList<NguoiDungDTO> getDsnd()
    {
        return dsnd;
    }
    
}
