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
public class KhachHangDTO {
    
    private String makh;
    private String hokh;
    private String tenkh;
    private String diachi;
    private String sdt;
    private String email;
    public KhachHangDTO() {
    }

    
    public KhachHangDTO(String makh, String hokh, String tenkh, String diachi, String sdt, String email) {
        this.makh = makh;
        this.hokh = hokh;
        this.tenkh = tenkh;
        this.diachi = diachi;
        this.sdt = sdt;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getHokh() {
        return hokh;
    }

    public void setHokh(String hokh) {
        this.hokh = hokh;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    
    
    
}

