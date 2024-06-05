/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.KhachHang;
import model.account;

/**
 *
 * @author ASUS ROG
 */
public class AccountDAO extends DBcontext {

    public int check(String tentk, String mk) {
        String sql = "select * from TaiKhoan WHERE TenTK = ? AND matKhau=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, tentk);
            st.setString(2, mk);
            try ( ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    return 1;
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    public int checkTentk(String tentk) {
        String sql = "select * from TaiKhoan WHERE TenTK = ? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, tentk);
            try ( ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    return 1;
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    public int checkLoaiTK(String tentk, String mk) {
        String sql = "select LoaiTK from TaiKhoan WHERE TenTk = ? AND matKhau=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, tentk);
            st.setString(2, mk);
            try ( ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    String loaiTK = rs.getString(1);
                    if ("admin".equals(loaiTK)) {
                        return 1;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 2;
    }

    public account GetTK(String tentk) {
        String sql = "select * from TaiKhoan WHERE TenTk = ? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, tentk);
            try ( ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    return new account(rs.getString(1), rs.getString(2),
                            rs.getString(3), rs.getString(4));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public int checkSdt(String sdt) {
        String sql = "select * from TaiKhoan WHERE Sdt=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, sdt);
            try ( ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    return 1;
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    public void taoTaiKhoanKhachHang(String tentk, String mk, String sdt) {
        String sql = "INSERT INTO [dbo].[TaiKhoan] ([TenTK], [matKhau], [Sdt], [LoaiTK]) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, tentk);
            st.setString(2, mk);
            st.setString(3, sdt);
            st.setString(4, "khachhang");
            int rowsAffected = st.executeUpdate();
            System.out.println(rowsAffected + " row(s) inserted.");
            st.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Lỗi tạo tài khoản: " + e.getMessage());
        }
    }

    public void doiMatKhau(String tentk, String mk) {
        String sql = "UPDATE [dbo].[TaiKhoan] SET matKhau=? where tentk=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, mk);
            st.setString(2, tentk);
            int rowsAffected = st.executeUpdate();
            st.close();
            connection.close();
        } catch (SQLException e) {

        }
    }

    public void updateSdt(String tentk, String sdt) {
        String sql = "UPDATE [dbo].[TaiKhoan] SET sdt=? where tentk=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, sdt);
            st.setString(2, tentk);
            int rowsAffected = st.executeUpdate();
            st.close();
            connection.close();
        } catch (SQLException e) {

        }
    }

    public account getTKbyTentk(String tentk) {
        String sql = "Select * from TaiKhoan where TenTK=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, tentk);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new account(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public int getSoLuongTaiKhoan() {
        int soLuongTaiKhoan = 0;
        String sql = "SELECT COUNT(*) AS SoLuong FROM KhachHang";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                soLuongTaiKhoan = rs.getInt("SoLuong");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return soLuongTaiKhoan;
    }
}
