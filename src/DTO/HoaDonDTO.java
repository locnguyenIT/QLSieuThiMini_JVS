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
public class HoaDonDTO {
    private String mahd;
    private String makh;
    private String manv;
    private String tennv;
    private String tenkh;
    private int tongtien;
    private String thanhtoan;
    private String date;
    private String ghichu;
    
    public HoaDonDTO(){}
    
    public HoaDonDTO(String mahd,String manv, String tennv, String makh,String tenkh,int tongtien,  String thanhtoan, String date,String ghichu) {
        this.mahd = mahd;
        this.makh = makh;
        this.manv = manv;
        this.tennv = tennv;
        this.tenkh = tenkh;
        this.date = date;
        this.thanhtoan = thanhtoan;
        this.tongtien = tongtien;
        this.ghichu = ghichu;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getThanhtoan() {
        return thanhtoan;
    }

    public void setThanhtoan(String thanhtoan) {
        this.thanhtoan = thanhtoan;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }
    
    
}
