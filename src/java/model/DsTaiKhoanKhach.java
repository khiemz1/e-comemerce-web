/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class DsTaiKhoanKhach {
    private String hoTen;
    private String tenTK;
    private String emial;
    private String sdt;
    private String diaChi;

    public DsTaiKhoanKhach() {
    }

    public DsTaiKhoanKhach(String hoTen, String tenTK, String emial, String sdt, String diaChi) {
        this.hoTen = hoTen;
        this.tenTK = tenTK;
        this.emial = emial;
        this.sdt = sdt;
        this.diaChi = diaChi;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getTenTK() {
        return tenTK;
    }

    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }

    public String getEmial() {
        return emial;
    }

    public void setEmial(String emial) {
        this.emial = emial;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "DsTaiKhoanKhach{" + "hoTen=" + hoTen + ", tenTK=" + tenTK + ", emial=" + emial + ", sdt=" + sdt + ", diaChi=" + diaChi + '}';
    }
    
    
    
    
}
