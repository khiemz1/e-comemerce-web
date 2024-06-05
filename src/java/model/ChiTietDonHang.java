/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS ROG
 */
public class ChiTietDonHang {
    private String maDH, tentk, maSP, sizeSP;
    private int soLuongDH, tongTien;

    public ChiTietDonHang() {
    }

    public ChiTietDonHang(String maDH, String tentk, String maSP, String sizeSP, int soLuongDH, int tongTien) {
        this.maDH = maDH;
        this.tentk = tentk;
        this.maSP = maSP;
        this.sizeSP = sizeSP;
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

    public String getSizeSP() {
        return sizeSP;
    }

    public void setSizeSP(String sizeSP) {
        this.sizeSP = sizeSP;
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

    @Override
    public String toString() {
        return "ChiTietDonHang{" + "maDH=" + maDH + ", tentk=" + tentk + ", maSP=" + maSP + ", sizeSP=" + sizeSP + ", soLuongDH=" + soLuongDH + ", tongTien=" + tongTien + '}';
    }
    
}
