/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author ntloc
 */
public class ThongKeDTO {
    private String mahd;
    private String masp;
    private String tensp;
    private int slsp;
    private String thoigian;
    private String thanhtoan;
    private int tongtienhd;
    private int doanhthu;

    public ThongKeDTO(){}
    
    public ThongKeDTO(String masp, String tensp, int slsp, int doanhthu)  //Thống kê SP, Top 5 SPBChay, Top 5 SPBCham
    {
        this.masp = masp;
        this.tensp = tensp;
        this.slsp = slsp;
        this.doanhthu = doanhthu;
    }
    public ThongKeDTO(String mahd,int slsp,String thanhtoan, int tongtienhd,String thoigian) //Thống kê BanHang, Nhap Hang
    {
        this.mahd = mahd;
        this.slsp = slsp;
        this.thanhtoan = thanhtoan;
        this.tongtienhd = tongtienhd;
        this.thoigian = thoigian;
    }

    
    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getThoigian() {
        return thoigian;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }

    public String getThanhtoan() {
        return thanhtoan;
    }

    public void setThanhtoan(String thanhtoan) {
        this.thanhtoan = thanhtoan;
    }

    public int getTongtienhd() {
        return tongtienhd;
    }

    public void setTongtienhd(int tongtienhd) {
        this.tongtienhd = tongtienhd;
    }
    
    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getSlsp() {
        return slsp;
    }

    public void setSlsp(int slsp) {
        this.slsp = slsp;
    }

    public int getDoanhthu() {
        return doanhthu;
    }

    public void setDoanhthu(int doanhthu) {
        this.doanhthu = doanhthu;
    }
    
    
}
