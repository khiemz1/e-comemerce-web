/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import model.DonHang;
import model.GioHang;
import model.SanPham;
import model.SizeSP;

/**
 *
 * @author ASUS ROG
 */
public class SanPhamDAO extends DBcontext {

    public List<SanPham> getAll() {
        List<SanPham> list = new ArrayList<>();
        String sql = "select * from SanPham";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                SanPham c = new SanPham(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<SanPham> searchByName(String txtSearch) {
        List<SanPham> list1 = new ArrayList<>();
        String sql = "select * from SanPham\n"
                + "where tenSP like ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + txtSearch + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                SanPham c = new SanPham(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
                list1.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list1;
    }

    public List<SizeSP> getAllSize() {
        List<SizeSP> list = new ArrayList<>();
        String sql = "select * from SanPham_Size";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                SizeSP c = new SizeSP(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<String> getAllBrand() {
        List<String> list = new ArrayList<>();
        String sql = "SELECT DISTINCT BrandSP\n"
                + "FROM SanPham;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String c = rs.getString(1);
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public SanPham getSanPhambyId(String id) {
        String sql = "select * from SanPham WHERE MaSP = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new SanPham(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<SanPham> getAllbyID(List<GioHang> c) {
        List<SanPham> list = new ArrayList<>();
        String sql = "select * from SanPham where maSP=?";
        for (GioHang c1 : c) {
            try {
                PreparedStatement st = connection.prepareStatement(sql);
                st.setString(1, c1.getMaSP());
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    SanPham c2 = new SanPham(rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getInt(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getInt(7));
                    list.add(c2);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return list;
    }

    public List<SanPham> getAllbyBrand(String brand) {
        List<SanPham> list = new ArrayList<>();
        String sql = "select * from SanPham where BrandSP=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, brand);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                SanPham c = new SanPham(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void sapXepTheoGiaSP(List<SanPham> danhSachSanPham) {
        Collections.sort(danhSachSanPham, new Comparator<SanPham>() {
            @Override
            public int compare(SanPham sp1, SanPham sp2) {
                return Integer.compare(sp1.getGiaSP(), sp2.getGiaSP());
            }
        });
    }

    public void sapXepTheoSoLuongDaBan(List<SanPham> danhSachSanPham) {
        Collections.sort(danhSachSanPham, new Comparator<SanPham>() {
            @Override
            public int compare(SanPham sp1, SanPham sp2) {
                return Integer.compare(sp1.getSoluongDaBan(), sp2.getSoluongDaBan());
            }
        });
    }

    public List<String> getAnhMinhHoabyID(String maSP) {
        List<String> list = new ArrayList<>();
        String sql = "select anhMinhHoaSP from SanPham_Anh where maSP=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, maSP);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String c2 = rs.getString(1);
                list.add(c2);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<SizeSP> getSizebyId(String maSP) {
        List<SizeSP> list = new ArrayList<>();
        String sql = "select * from SanPham_Size where maSP=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, maSP);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                SizeSP c = new SizeSP(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public int checkSoLuongTrongKho(String maSP, String sizeSP, int soLuongSP) {
        String sql = "select soLuongSP from SanPham_Size where maSP=? AND sizeSP=?";
        int soLuongtrongKho = 0;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, maSP);
            st.setString(2, sizeSP);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                soLuongtrongKho = rs.getInt(1);
            }
            if (soLuongtrongKho < soLuongSP) {
                return 1;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    public void updateSizeSP(String maSP, String size, int quantity) {
        String sql = "UPDATE SanPham_Size\n"
                + "SET SoLuongSP = SoLuongSP - ?\n"
                + "WHERE MaSP = ?  AND sizeSP=?;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, quantity);
            st.setString(2, maSP);
            st.setString(3, size);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateSoLuongDaBan(String maSP, int quantity) {
        String sql = "UPDATE SanPham\n"
                + "SET SoLuongDaBan = SoLuongDaBan + ?\n"
                + "WHERE MaSP = ? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, quantity);
            st.setString(2, maSP);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteSP(String maSP) {
        String sql = "DELETE SanPham\n"
                + "WHERE MaSP = ? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, maSP);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void themSizeSP(String maSP, String sizeSP, int quantity) {
        String sql = "INSERT INTO [dbo].[SanPham_Size]\n"
                + "           ([maSP]\n"
                + "           ,[sizeSP]\n"
                + "           ,[soLuongSP])\n"
                + "     VALUES\n"
                + "           (?, ?, ?)";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, maSP);
            st.setString(2, sizeSP);
            st.setInt(3, quantity);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public int checkSize(String maSP, String size) {
        String sql = "select * from SanPham_Size Where maSp=? AND sizeSP=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, maSP);
            st.setString(2, size);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return 1;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    public void updateSoLuongSize(String maSP, String size, int quantity) {
        String sql = "UPDATE SanPham_Size\n"
                + "SET SoLuongSP = SoLuongSP + ?\n"
                + "WHERE MaSP = ? AND sizeSP=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, quantity);
            st.setString(2, maSP);
            st.setString(3, size);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateSanPham(String maSP, String tenSP, String anhSP, String brand, String giaSP, String moTaSP) {
        String sql = "UPDATE [dbo].[SanPham]\n"
                + "   SET \n"
                + "      [tenSP] = ?\n"
                + "      ,[anhSP] = ?\n"
                + "      ,[giaSP] = ?\n"
                + "      ,[brandSP] = ?\n"
                + "      ,[describeSP] = ?\n"
                + " WHERE [maSP] = ?";
        try ( PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, tenSP);
            st.setString(2, anhSP);
            st.setString(3, giaSP);
            st.setString(4, brand);
            st.setString(5, moTaSP);
            st.setString(6, maSP);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Thay vì in lên console, bạn có thể log hoặc xử lý thông báo lỗi theo nhu cầu.
        }
    }

    public void addSanPham(String maSP, String tenSP, String anhSP, String brand, String giaSP, String moTaSP) {
        String sql = "INSERT INTO [dbo].[SanPham]\n"
                + "           ([maSP]\n"
                + "           ,[tenSP]\n"
                + "           ,[anhSP]\n"
                + "           ,[giaSP]\n"
                + "           ,[brandSP]\n"
                + "           ,[describeSP]\n"
                + "           ,[soLuongDaBan])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try ( PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, maSP);
            st.setString(2, tenSP);
            st.setString(3, anhSP);
            st.setString(4, giaSP);
            st.setString(5, brand);
            st.setString(6, moTaSP);
            st.setString(7, "0");
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Thay vì in lên console, bạn có thể log hoặc xử lý thông báo lỗi theo nhu cầu.
        }
    }

    public void addAnhSanPham( String maSP, String anhSP1, String anhSP2, String anhSP3) {
        String sql = "INSERT INTO [dbo].[SanPham_Anh]\n"
                + "           ([maSp]\n"
                + "           ,[anhminhhoaSP]\n"
                + "           ,[thuTu])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?)";
        int i=1;
        while (i<4) {
            try ( PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, maSP);
            st.setString(2, anhSP1);
            st.setInt(3, i);
            st.executeUpdate();
            i++;
        } catch (SQLException e) {
            e.printStackTrace(); // Thay vì in lên console, bạn có thể log hoặc xử lý thông báo lỗi theo nhu cầu.
        }
        }
        
    }
}
