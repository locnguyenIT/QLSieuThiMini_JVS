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
public class NhanVienDTO {
    private String manv;
    private String honv;
    private String tennv;
    private String gioitinh;
    private String diachi;
    private int namsinh;
    private String sdt;
    private String image;

    public NhanVienDTO(String manv, String honv, String tennv,  String diachi,String sdt, String gioitinh,int namsinh,String image) {
        this.manv = manv;
        this.honv = honv;
        this.tennv = tennv;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.namsinh = namsinh;
        this.sdt = sdt;
        this.image = image;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getHonv() {
        return honv;
    }

    public void setHonv(String honv) {
        this.honv = honv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public int getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(int namsinh) {
        this.namsinh = namsinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
}
