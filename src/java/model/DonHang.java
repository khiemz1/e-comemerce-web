/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS ROG
 */
public class DonHang {
    private String maDH, tentk, ngayDatHang;
    private int tongBill;
    private String hinhThucThanhToan, tinhTrangDH, diaChi, nganHang, soTaiKhoan;

    public DonHang() {
    }

    public DonHang(String maDH, String tentk, String ngayDatHang, int tongBill, String hinhThucThanhToan, String tinhTrangDH, String diaChi, String nganHang, String soTaiKhoan) {
        this.maDH = maDH;
        this.tentk = tentk;
        this.ngayDatHang = ngayDatHang;
        this.tongBill = tongBill;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.tinhTrangDH = tinhTrangDH;
        this.diaChi = diaChi;
        this.nganHang = nganHang;
        this.soTaiKhoan = soTaiKhoan;
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

    public String getNgayDatHang() {
        return ngayDatHang;
    }

    public void setNgayDatHang(String ngayDatHang) {
        this.ngayDatHang = ngayDatHang;
    }

    public int getTongBill() {
        return tongBill;
    }

    public void setTongBill(int tongBill) {
        this.tongBill = tongBill;
    }

    public String getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public void setHinhThucThanhToan(String hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public String getTinhTrangDH() {
        return tinhTrangDH;
    }

    public void setTinhTrangDH(String tinhTrangDH) {
        this.tinhTrangDH = tinhTrangDH;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getNganHang() {
        return nganHang;
    }

    public void setNganHang(String nganHang) {
        this.nganHang = nganHang;
    }

    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public void setSoTaiKhoan(String soTaiKhoan) {
        this.soTaiKhoan = soTaiKhoan;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DonHang{");
        sb.append("maDH=").append(maDH);
        sb.append(", tentk=").append(tentk);
        sb.append(", ngayDatHang=").append(ngayDatHang);
        sb.append(", tongBill=").append(tongBill);
        sb.append(", hinhThucThanhToan=").append(hinhThucThanhToan);
        sb.append(", tinhTrangDH=").append(tinhTrangDH);
        sb.append(", diaChi=").append(diaChi);
        sb.append(", nganHang=").append(nganHang);
        sb.append(", soTaiKhoan=").append(soTaiKhoan);
        sb.append('}');
        return sb.toString();
    }

    
    
}
