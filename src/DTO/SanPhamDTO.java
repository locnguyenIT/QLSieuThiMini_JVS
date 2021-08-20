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
public class SanPhamDTO {
    private String masp;
    private String tensp;
    private int sl;
    private int dongia;
    private String dvt;
    private String maloai;
    private String mancc;
    private String image;
    
    public SanPhamDTO(){}

    public SanPhamDTO(String masp, String tensp, int dongia, int sl, String dvt,String maloai,String mancc,String image) {
        this.masp = masp;
        this.tensp = tensp;
        this.sl = sl;
        this.dongia = dongia;
        this.dvt = dvt;
        this.maloai = maloai;
        this.mancc = mancc;
        this.image = image;
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

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public String getDvt() {
        return dvt;
    }

    public void setDvt(String dvt) {
        this.dvt = dvt;
    }

    public String getMaloai() {
        return maloai;
    }

    public void setMaloai(String maloai) {
        this.maloai = maloai;
    }

    public String getMancc() {
        return mancc;
    }

    public void setMancc(String mancc) {
        this.mancc = mancc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
}
