/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS ROG
 */
public class SanPham {
    private String maSP, tenSP, anhSP;
    private int giaSP;
    private String brandSP, moTaSP;
    private int soluongDaBan;
    
    

    public SanPham() {
    }

    public SanPham(String maSP, String tenSP, String anhSP, int giaSP, String brandSP, String moTaSP, int soluongDaBan) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.anhSP = anhSP;
        this.giaSP = giaSP;
        this.brandSP = brandSP;
        this.moTaSP = moTaSP;
        this.soluongDaBan = soluongDaBan;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getAnhSP() {
        return anhSP;
    }

    public void setAnhSP(String anhSP) {
        this.anhSP = anhSP;
    }

    public int getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(int giaSP) {
        this.giaSP = giaSP;
    }

    public String getBrandSP() {
        return brandSP;
    }

    public void setBrandSP(String brandSP) {
        this.brandSP = brandSP;
    }

    public String getMoTaSP() {
        return moTaSP;
    }

    public void setMoTaSP(String moTaSP) {
        this.moTaSP = moTaSP;
    }

    public int getSoluongDaBan() {
        return soluongDaBan;
    }

    public void setSoluongDaBan(int soluongDaBan) {
        this.soluongDaBan = soluongDaBan;
    }

    @Override
    public String toString() {
        return "SanPham{" + "maSP=" + maSP + ", tenSP=" + tenSP + ", anhSP=" + anhSP + ", giaSP=" + giaSP + ", brandSP=" + brandSP + ", moTaSP=" + moTaSP + ", soluongDaBan=" + soluongDaBan + '}';
    }
    
    
}
