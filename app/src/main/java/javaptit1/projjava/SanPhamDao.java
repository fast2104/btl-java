/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaptit1.projjava;

/**
 *
 * @author Admin
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SanPhamDao {
    public List<SanPham> getAll() throws SQLException {
        List<SanPham> list = new ArrayList<>();
        String sql = "SELECT * FROM sanpham";
        try (Connection c = JDBCUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSanPham(rs.getString("masanpham"));
                sp.setTenSanPham(rs.getString("tensanpham"));
                sp.setLoaiSanpham(rs.getString("loaisanpham"));
                sp.setNguonGoc(rs.getString("nguongoc"));
                sp.setMoTa(rs.getString("mota"));
                sp.setDonVi(rs.getString("donvi"));
                sp.setGiaBan(rs.getInt("giaban"));
                sp.setGiaMua(rs.getInt("giamua"));
                sp.setTonKho(rs.getInt("tonkho"));
                sp.setDaBan(rs.getInt("daban"));
                list.add(sp);
            }
        }
        return list;
    }

    public boolean insert(SanPham sp) throws SQLException {
        String sql = "INSERT INTO sanpham(masanpham, tensanpham, loaisanpham, nguongoc, mota, donvi, giaban, giamua, tonkho, daban) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try (Connection c = JDBCUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, sp.getMaSanPham());
            ps.setString(2, sp.getTenSanPham());
            ps.setString(3, sp.getLoaiSanpham());
            ps.setString(4, sp.getNguonGoc());
            ps.setString(5, sp.getMoTa());
            ps.setString(6, sp.getDonVi());
            ps.setInt(7, sp.getGiaBan());
            ps.setInt(8, sp.getGiaMua());
            ps.setInt(9, sp.getTonKho());
            ps.setInt(10, sp.getDaBan()); 
            return ps.executeUpdate() > 0;
        }
    }

    public boolean delete(String maSP) throws SQLException {
        try (Connection c = JDBCUtil.getConnection();
             PreparedStatement ps = c.prepareStatement("DELETE FROM sanpham WHERE masanpham=?")) {
            ps.setString(1, maSP);
            return ps.executeUpdate() > 0;
        }
    }
}