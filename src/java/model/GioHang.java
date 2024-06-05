/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS ROG
 */
public class GioHang {
    private String maSP, tentk;
    private int soLuongGH, tongTien;
    private String sizeSP;

    public GioHang() {
    }

    public GioHang(String maSP, String tentk, int soLuongGH, int tongTien, String sizeSP) {
        this.maSP = maSP;
        this.tentk = tentk;
        this.soLuongGH = soLuongGH;
        this.tongTien = tongTien;
        this.sizeSP = sizeSP;
    }

    public String getSizeSP() {
        return sizeSP;
    }

    public void setSizeSP(String sizeSP) {
        this.sizeSP = sizeSP;
    }

    

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTentk() {
        return tentk;
    }

    public void setTentk(String tentk) {
        this.tentk = tentk;
    }

    public int getSoLuongGH() {
        return soLuongGH;
    }

    public void setSoLuongGH(int soLuongGH) {
        this.soLuongGH = soLuongGH;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }
    
    
}
