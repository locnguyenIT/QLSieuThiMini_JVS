/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import Connection.MySQLConnect;
import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.util.ArrayList;
import java.sql.ResultSet;
/**
 *
 * @author ntloc
 */
public class NhanVienBUS {
    

    private ArrayList<NhanVienDTO> dsnv;
    private NhanVienDAO nvDAO;
    
    public NhanVienBUS(){}
    
    public void DanhSachNhanVien()
    {
        nvDAO = new NhanVienDAO();
        dsnv = new ArrayList<>();
        dsnv = nvDAO.DanhSachNhanVien();
    }
    public void Add(NhanVienDTO nv)
    {
        nvDAO = new NhanVienDAO();
        nvDAO.Add(nv);
        
    }
    public void Delete(String manv)
    {
        nvDAO = new NhanVienDAO();
        nvDAO.Delete(manv);
    }
    public void Set(NhanVienDTO nv)
    {
        nvDAO = new NhanVienDAO();
        nvDAO.Set(nv);
    }
    public String SearchManv(String tennv)
    {
        for(NhanVienDTO nv: dsnv)
        {
            if(tennv.contains(nv.getTennv()))
            {
                return nv.getManv();
            }
        }
        return null;
    }
    public NhanVienDTO Search(String manv)
    {
        for(NhanVienDTO nv: dsnv)
        {
            if(nv.getManv().contains(manv))
            {
                return nv;
            }
        }
        return null;
    }
    public String SearchTennv(String manv)
    {
        for(NhanVienDTO nv: dsnv)
        {
            if(nv.getManv().equals(manv))
            {
                return nv.getHonv()+" "+nv.getTennv();
            }
        }
        return null;
    }
    public ArrayList<NhanVienDTO> getDsnv()
    {
        return dsnv;
    }
    
    public String NextManv()
    {
        int max = 0;
        String s ="";
        for(NhanVienDTO nv : dsnv)
        {
            int id = Integer.parseInt(nv.getManv());
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
