/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;


import DAO.NhaCungCapDAO;
import DTO.NhaCungCapDTO;
import java.util.ArrayList;

/**
 *
 * @author ntloc
 */
public class NhaCungCapBUS {
    private ArrayList<NhaCungCapDTO> dsncc;
    private NhaCungCapDAO nccDAO;

    public NhaCungCapBUS() {}
    
    public void DanhSachNCC()
    {
        nccDAO = new NhaCungCapDAO();
        dsncc = new ArrayList<>();
        dsncc = nccDAO.DanhSachNCC();
    }
    public NhaCungCapDTO SearchNCC(String mancc)
    {
        for(NhaCungCapDTO ncc : dsncc)
        {
            if(ncc.getMancc().equals(mancc))
            {
                return ncc;
            }
        }
        return null;
    }
     public String SearchMaNCC(String tenncc)
    {
        for(NhaCungCapDTO ncc : dsncc)
        {
            if(ncc.getTenncc().equals(tenncc))
            {
                return ncc.getMancc();
            }
        }
        return null;
    }
      public String SearchTenNCC(String mancc)
    {
        for(NhaCungCapDTO ncc : dsncc)
        {
            if(ncc.getMancc().equals(mancc))
            {
                return ncc.getTenncc();
            }
        }
        return null;
    }
   public void Add(NhaCungCapDTO ncc)
    {
        nccDAO = new NhaCungCapDAO();
        nccDAO.Add(ncc);
    }
    public void Delete(String mancc)
    {
        nccDAO = new NhaCungCapDAO();
        nccDAO.Delete(mancc);
    }
    public void Set(NhaCungCapDTO ncc)
    {
        nccDAO = new NhaCungCapDAO();
        nccDAO.Set(ncc);
    }
    
    public ArrayList<NhaCungCapDTO> getDsncc()
    {
        return dsncc;
    }
     public String NextMancc()
    {
        int max = 0;
        String s ="";
        for(NhaCungCapDTO ncc : dsncc)
        {
            int id = Integer.parseInt(ncc.getMancc());
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
