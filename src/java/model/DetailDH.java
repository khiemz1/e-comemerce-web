/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS ROG
 */
public class DetailDH {
    private String maDH, tentk, maSP,  tenSp, anhSP, sizeSP;
    private int giaSP, soLuongDH, tongTien;

    public DetailDH() {
    }

    public DetailDH(String maDH, String tentk, String maSP, String tenSp, String anhSP, String sizeSP, int giaSP, int soLuongDH, int tongTien) {
        this.maDH = maDH;
        this.tentk = tentk;
        this.maSP = maSP;
        this.tenSp = tenSp;
        this.anhSP = anhSP;
        this.sizeSP = sizeSP;
        this.giaSP = giaSP;
        this.soLuongDH = soLuongDH;
        this.tongTien = tongTien;
    }

    public String getMaDH() {
        return maDH;
    }

    public void setMaDH(String maDH) {
        this.maDH = maDH;
    }

    public String getTentk() {
        return tentk;
    }

    public void setTentk(String tentk) {
        this.tentk = tentk;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public String getAnhSP() {
        return anhSP;
    }

    public void setAnhSP(String anhSP) {
        this.anhSP = anhSP;
    }

    public String getSizeSP() {
        return sizeSP;
    }

    public void setSizeSP(String sizeSP) {
        this.sizeSP = sizeSP;
    }

    public int getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(int giaSP) {
        this.giaSP = giaSP;
    }

    public int getSoLuongDH() {
        return soLuongDH;
    }

    public void setSoLuongDH(int soLuongDH) {
        this.soLuongDH = soLuongDH;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }
    
}
