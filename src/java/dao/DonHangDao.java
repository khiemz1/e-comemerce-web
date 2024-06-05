/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import model.ChiTietDonHang;
import model.DonHang;

/**
 *
 * @author ASUS ROG
 */
public class DonHangDao extends DBcontext {

    public String taoMaDH(String tentk) {
        String id = "";
        String sql = "SELECT COUNT(*) AS SoLuongDong FROM DonHang WHERE tentk=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, tentk);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int i = rs.getInt("SoLuongDong") + 1;
                id = String.valueOf(i);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        String maDH = "DH" + id;
        return maDH;
    }

    public void taoDH(String maDH, String tentk, int tong, String hinhThucThanhToan, String diaChi, String nganHang, String stk) {
        try {
            // Sử dụng PreparedStatement để tránh các vấn đề bảo mật và tối ưu hóa hiệu suất
            String sql = "INSERT INTO DonHang (maDH, tenTK, ngayDatHang, tongBill, hinhThucThanhToan, tinhTrangDH, diaChiGiaoHang, nganHang, soTaiKhoan) "
                    + "VALUES (?, ?, GETDATE(), ?, ?, '0', ?, ?, ?)";

            try ( PreparedStatement statement = connection.prepareStatement(sql)) {
                // Đặt các giá trị tham số trong lệnh SQL
                statement.setString(1, maDH);
                statement.setString(2, tentk);
                statement.setInt(3, tong);
                statement.setString(4, hinhThucThanhToan);
                statement.setString(5, diaChi);
                statement.setString(6, nganHang);
                statement.setString(7, stk);

                // Thực hiện lệnh SQL INSERT
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Hoặc xử lý bất kỳ ngoại lệ nào bạn muốn ở đây
        }
    }

    public void taoChiTietDH(String maDH, String tentk, String maSP, String size, int quantity, int tong) {
        try {
            // Sử dụng PreparedStatement để tránh các vấn đề bảo mật và tối ưu hóa hiệu suất
            String sql = "INSERT INTO ChiTietDonHang (maDH, tenTK, maSP, sizeSP, soLuongDH, tongTien) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";

            try ( PreparedStatement statement = connection.prepareStatement(sql)) {
                // Đặt các giá trị tham số trong lệnh SQL
                statement.setString(1, maDH);
                statement.setString(2, tentk);
                statement.setString(3, maSP);
                statement.setString(4, size);
                statement.setInt(5, quantity);
                statement.setInt(6, tong);

                // Thực hiện lệnh SQL INSERT
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Hoặc xử lý bất kỳ ngoại lệ nào bạn muốn ở đây
        }
    }

    public List<DonHang> getDonHangbyTentk(String tentk) {
        List<DonHang> list = new ArrayList<>();
        String sql = "select * from DonHang where TenTk=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, tentk);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                DonHang c = new DonHang(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<DonHang> getAllDonHang() {
        List<DonHang> list = new ArrayList<>();
        String sql = "select * from DonHang";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                DonHang c = new DonHang(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<ChiTietDonHang> getChiTietDonHangbyId(String tentk) {
        List<ChiTietDonHang> list = new ArrayList<>();
        String sql = "select * from ChiTietDonHang where TenTk=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, tentk);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ChiTietDonHang c = new ChiTietDonHang(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void updateDH(String tentk, String maDH, String confirm) {
        String sql = "";
        if (confirm.equals("4")) {
            sql = "Delete [dbo].[DonHang]  where tentk=? AND maDH=?";
        } else {
            sql = "UPDATE [dbo].[DonHang] SET tinhTrangDH=? where tentk=? AND maDH=?";
        }

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            if (confirm.equals("4")) {
                st.setString(1, tentk);
                st.setString(2, maDH);
            } else {
                st.setString(1, confirm);
                st.setString(2, tentk);
                st.setString(3, maDH);
            }

            int rowsAffected = st.executeUpdate();
            st.close();
            connection.close();
        } catch (SQLException e) {

        }
    }

    public int getSoLuongDonHang() {
        int soLuongTaiKhoan = 0;
        String sql = "SELECT COUNT(*) AS SoLuong\n"
                + "FROM DonHang;";
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

    public int doanhThuThang() {
        int doanhThuThang1 = 0;
        String sql = "SELECT SUM(TongBill) AS TongBillThang1\n"
                + "FROM DonHang\n"
                + "WHERE Month(NgayDatHang) = 1;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                doanhThuThang1 = rs.getInt("TongBillThang1");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return doanhThuThang1;
    }

    public int doanhThuNam() {
        int doanhThuNam2024 = 0;
        String sql = "SELECT SUM(TongBill) AS TongBill2024\n"
                + "FROM DonHang\n"
                + "WHERE YEAR(NgayDatHang) = 2024;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                doanhThuNam2024 = rs.getInt("TongBill2024");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return doanhThuNam2024;
    }

}
