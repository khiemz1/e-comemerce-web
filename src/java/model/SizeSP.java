/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS ROG
 */
public class SizeSP {
    private String maSP, size;
    private int soLuongSize;

    public SizeSP() {
    }

    public SizeSP(String maSP, String size, int soLuongSize) {
        this.maSP = maSP;
        this.size = size;
        this.soLuongSize = soLuongSize;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getSoLuongSize() {
        return soLuongSize;
    }

    public void setSoLuongSize(int soLuongSize) {
        this.soLuongSize = soLuongSize;
    }

    @Override
    public String toString() {
        return "SizeSP{" + "maSP=" + maSP + ", size=" + size + ", soLuongSize=" + soLuongSize + '}';
    }
    
}
