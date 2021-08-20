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
public class PhieuNhapHangDTO {
    private String mapnh;
    private String manv;
    private String tennv;
    private String mancc;
    private String tenncc;
    private int tongtien;
    private String thanhtoan;
    private String date;
    private String ghichu;

    public PhieuNhapHangDTO(){}
    
    public PhieuNhapHangDTO(String mapnh, String manv, String tennv, String mancc, String tenncc, int tongtien, String thanhtoan, String date, String ghichu) {
        this.mapnh = mapnh;
        this.manv = manv;
        this.tennv = tennv;
        this.mancc = mancc;
        this.tenncc = tenncc;
        this.tongtien = tongtien;
        this.thanhtoan = thanhtoan;
        this.date = date;
        this.ghichu = ghichu;
    }

    public String getMapnh() {
        return mapnh;
    }

    public void setMapnh(String mapnh) {
        this.mapnh = mapnh;
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

    public String getMancc() {
        return mancc;
    }

    public void setMancc(String mancc) {
        this.mancc = mancc;
    }

    public String getTenncc() {
        return tenncc;
    }

    public void setTenncc(String tenncc) {
        this.tenncc = tenncc;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public String getThanhtoan() {
        return thanhtoan;
    }

    public void setThanhtoan(String thanhtoan) {
        this.thanhtoan = thanhtoan;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }
    
    
}
