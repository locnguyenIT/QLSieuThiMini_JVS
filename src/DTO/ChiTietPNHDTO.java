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
public class ChiTietPNHDTO {
    private String mapnh;
    private String masp;
    private String tensp;
    private int dongia;
    private int sl;
    private int thanhtien;
    private int giamgia;
    private int tongtien;

    public ChiTietPNHDTO(){}
    
    public ChiTietPNHDTO(String mapnh, String masp, String tensp,int dongia,int sl,  int thanhtien, int giamgia, int tongtien) {
        this.mapnh = mapnh;
        this.masp = masp;
        this.tensp = tensp;
        this.sl = sl;
        this.dongia = dongia;
        this.thanhtien = thanhtien;
        this.giamgia = giamgia;
        this.tongtien = tongtien;
    }

    public String getMapnh() {
        return mapnh;
    }

    public void setMapnh(String mapnh) {
        this.mapnh = mapnh;
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

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public int getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }

    public int getGiamgia() {
        return giamgia;
    }

    public void setGiamgia(int giamgia) {
        this.giamgia = giamgia;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }
    
}
