/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.GioHang;
import model.SanPham;

/**
 *
 * @author ASUS ROG
 */
public class GioHangDao extends DBcontext {

    public boolean checkGioHang(String maSP, String sizeSP, String tentk) {
        String sql = "SELECT COUNT(*) AS count FROM GioHang WHERE maSP = ? AND sizeSP = ? AND tenTK = ?";
        
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, maSP);
            statement.setString(2, sizeSP);
            statement.setString(3, tentk);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return false;
    }

    public void themVaoGioHang(String tentk, String maSP, int soLuong, String sizeSP) {
        String sql = "INSERT INTO GioHang (maSP, tenTK, soLuongSP, tongTien, sizeSP)\n"
                + "SELECT\n"
                + "    ?,\n"
                + "    ?,\n"
                + "    ?,\n"
                + "    ? * giaSP,\n"
                + "    ?\n"
                + "FROM SanPham\n"
                + "WHERE MaSP = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, maSP);
            st.setString(2, tentk);
            st.setInt(3, soLuong);
            st.setInt(4, soLuong);
            st.setString(5, sizeSP);
            st.setString(6, maSP);
            ResultSet rs = st.executeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateGioHang(String tentk, String maSP, int soLuongMoi, String size) {
        String sql = "UPDATE GioHang\n"
                + "SET SoLuongSP = SoLuongSP + ?,\n"
                + "    tongTien = (SoLuongSP + ?) * (SELECT GiaSP FROM SanPham WHERE MaSP = ?)\n"
                + "WHERE MaSP = ? AND tentK = ? AND sizeSP=?;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, soLuongMoi);
            st.setInt(2, soLuongMoi);
            st.setString(3, maSP);
            st.setString(4, maSP);
            st.setString(5, tentk);
            st.setString(6, size);
            ResultSet rs = st.executeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateGioHangtrongCart(String tentk, String maSP, int soLuongMoi, String size) {
        String sql = "UPDATE GioHang\n"
                + "SET SoLuongSP = ?,\n"
                + "    tongTien = ? * (SELECT GiaSP FROM SanPham WHERE MaSP = ?)\n"
                + "WHERE MaSP = ? AND TenTk = ? AND sizeSP = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, soLuongMoi);
            st.setInt(2, soLuongMoi);
            st.setString(3, maSP);
            st.setString(4, maSP);
            st.setString(5, tentk);
            st.setString(6, size);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteGioHangbyId(String tentk, String maSP, String size) {
        String sql = "DELETE FROM [dbo].[GioHang] WHERE MaSP = ? AND TenTK = ? AND sizeSP = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, maSP);
            st.setString(2, tentk);
            st.setString(3, size);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<GioHang> getGioHangbyTentk(String tentk) {
        List<GioHang> list = new ArrayList<>();
        String sql = "select * from GioHang where TenTk=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, tentk);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                GioHang c = new GioHang(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public GioHang getGioHangforCheckOut(String tentk, String maSP, String size) {
        String sql = "SELECT * FROM GioHang WHERE maSP = ? AND tenTK = ? And sizeSP=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, maSP);
            st.setString(2, tentk);
            st.setString(3, size);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                return new GioHang(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

}
