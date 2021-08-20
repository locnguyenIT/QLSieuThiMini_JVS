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
public class NhaCungCapDTO {
    private String mancc;
    private String tenncc;
    private String diachi;
    private String mst;
    private String fax;
    public NhaCungCapDTO(){}

    public NhaCungCapDTO(String mancc, String tenncc, String diachi, String mst, String fax) {
        this.mancc = mancc;
        this.tenncc = tenncc;
        this.diachi = diachi;
        this.mst = mst;
        this.fax = fax;
    }

    public String getMst() {
        return mst;
    }

    public void setMst(String mst) {
        this.mst = mst;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    
    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
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

    @Override
    public String toString() {
        return  tenncc;
    }
    
    
}
