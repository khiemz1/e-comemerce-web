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
import model.DsTaiKhoanKhach;
import model.KhachHang;

/**
 *
 * @author ASUS ROG
 */
public class KhachHangDAO extends DBcontext {

    public void themKhachHang(String tentk) {
        String sql = "INSERT INTO [dbo].[KhachHang]\n"
                + "           ([TenTK]\n"
                + "           ,[HoTen]\n"
                + "           ,[Diachi]\n"
                + "           ,[email])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,''\n"
                + "           ,''\n"
                + "           ,'')";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, tentk);
            int rowsAffected = st.executeUpdate();
            System.out.println(rowsAffected + " row(s) inserted.");
            st.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Lỗi tạo tài khoản: " + e.getMessage());
        }
    }
    public KhachHang getKHbyTentk(String tentk) {
        String sql = "Select * from KhachHang where TenTK=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, tentk);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new KhachHang(rs.getString(1), 
                                    rs.getString(2), 
                                    rs.getString(3), 
                                    rs.getString(4));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    public void updateIfnor(String tentk, String hoTen, String diaChi, String email) {
        String sql = "UPDATE [dbo].[KhachHang] SET hoTen=?, diaChi=?, email = ? where tentk=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, hoTen);
            st.setString(2, diaChi);
            st.setString(3, email);
            st.setString(4, tentk);
            int rowsAffected = st.executeUpdate();
            st.close();
            connection.close();
        } catch (SQLException e) {
           
        }
    }
    public List<DsTaiKhoanKhach> getAllTaiKhoanKhach(){
        List<DsTaiKhoanKhach> list = new ArrayList<>();
        String sql = "SELECT  KhachHang.hoTen,TaiKhoan.tenTK,KhachHang.email, TaiKhoan.Sdt, KhachHang.diaChi\n" +
                    "FROM TaiKhoan,KhachHang\n" +
                    "WHERE TaiKhoan.tenTK = KhachHang.tenTK;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                list.add(new DsTaiKhoanKhach(
                        rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public void deleteKhachHang(String tenTK){
        String sql = "delete from TaiKhoan\n" +
                "where tenTK = ?;"
                + "delete from KhachHang\n" +
                "where tenTK = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, tenTK);
            st.setString(2, tenTK);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
    public List<KhachHang> getKH(){
        List<KhachHang> list = new ArrayList<>();
        String sql = "SELECT * from KhachHang";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                KhachHang c = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                list.add(c);
            }
        } catch (Exception e) {
        }
        return list;
    }
}
