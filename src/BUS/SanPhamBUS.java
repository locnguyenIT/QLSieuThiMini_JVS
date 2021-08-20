/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import DAO.SanPhamDAO;
import DTO.SanPhamDTO;
import java.util.ArrayList;
import Connection.MySQLConnect;
import java.io.File;
import javax.swing.JOptionPane;
/**
 *
 * @author ntloc
 */
public class SanPhamBUS {
    
    private ArrayList<SanPhamDTO> dssp;
    private SanPhamDAO spDAO;
    public SanPhamBUS(){}
    
    public void DanhSachSanPham()
    {
        spDAO = new SanPhamDAO();
        dssp = new ArrayList<>();
        dssp = spDAO.DanhSachSanPham();
    }
    public void Add(SanPhamDTO sp)
    {
        spDAO = new SanPhamDAO();
        spDAO.Add(sp);
    }
    public void Delete(String masp)
    {
        for(SanPhamDTO sp : dssp)
        {
            if(sp.getMasp().equals(masp))
            {
                dssp.remove(sp);
                spDAO = new SanPhamDAO();
                spDAO.Delete(masp);
                return;
            }
        } 
    }
    public void Set(SanPhamDTO sp)
    {
        spDAO = new SanPhamDAO();
        spDAO.Set(sp);
    }
    public void Set_SLSP(String masp, int sl)
    {
        spDAO = new SanPhamDAO();
        spDAO.Set_SLSP(masp,sl);
    }
    public SanPhamDTO Search(String masp)
    {
        for(SanPhamDTO sp : dssp)
        {
            if(sp.getMasp().equals(masp))
            {
                return sp;
            }
        }
        return null;
    }

    public SanPhamDTO SearchTensp(String tensp)
    {
        for(SanPhamDTO sp : dssp)
        {
            if(sp.getTensp().equals(tensp))
            {
                return sp;
            }
        }
        return null;
    }
    public boolean CheckSLSP(String masp, int sl)
    {
        for(SanPhamDTO sp : dssp)
        {
            if(sp.getMasp().equals(masp))
            {
                if(sp.getSl() < sl)
                {
                    JOptionPane.showMessageDialog(null,"Không đủ hàng. Vui lòng nhập lại");
                    return false;
                }
            }
        }
        return true;
    }
    public ArrayList<SanPhamDTO> getDssp()
    {
        return dssp;
    }
    public void Export()
    {
        spDAO = new SanPhamDAO();
        spDAO.Export();
    }
    public void Import(File file)
    {
        spDAO = new SanPhamDAO();
        spDAO.Import(file);
    }
    public String NextMaSP()
    {
        int max = 0;
        String s ="";
        for(SanPhamDTO sp : dssp)
        {
            int id = Integer.parseInt(sp.getMasp());
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
