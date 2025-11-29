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

public class NhanVienDao {

    // 1. Kiểm tra đăng nhập
    public NhanVien checkLogin(String user, String pass) throws SQLException {
        String sql = "SELECT * FROM nhanvien WHERE username = ? AND password = ?";
        try (Connection c = JDBCUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNhanVien(rs.getString("manhanvien")); 
                nv.setHoTen(rs.getString("hoten"));
                nv.setVaiTro(rs.getString("vaitro"));
                return nv;
            }
        } catch (SQLException e) {
            // Ném lại ngoại lệ để lớp giao diện có thể bắt và hiển thị thông báo
            throw e;
        }
        return null;
    }

    // 2. Lấy danh sách nhân viên
    public List<NhanVien> getAll() throws SQLException {
        List<NhanVien> list = new ArrayList<>();
        String sql = "SELECT * FROM nhanvien";
        
        try (Connection c = JDBCUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNhanVien(rs.getString("manhanvien")); 
                nv.setHoTen(rs.getString("hoten"));
                nv.setCccd(rs.getString("cccd"));
                nv.setSoDienThoai(rs.getString("sodienthoai"));
                nv.setGioiTinh(rs.getString("gioitinh"));
                nv.setVaiTro(rs.getString("vaitro"));
                nv.setUsername(rs.getString("username"));
                nv.setPassword(rs.getString("password"));
                nv.setLuong(rs.getLong("luong"));
                nv.setNgaySinh(rs.getString("ngaysinh"));
                nv.setDiaChi(rs.getString("diachi"));
                nv.setTrangThai(rs.getString("trangthai"));
                
                list.add(nv);
            }
        } catch (SQLException e) {
            throw e;
        }
        return list;
    }

    // 3. Thêm nhân viên mới
    public boolean insert(NhanVien nv) throws SQLException {
        String sql = "INSERT INTO nhanvien(manhanvien, hoten, cccd, sodienthoai, gioitinh, vaitro, username, password, luong, ngaysinh, diachi, trangthai) " +
                     "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection c = JDBCUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            
            ps.setString(1, nv.getMaNhanVien());
            ps.setString(2, nv.getHoTen());
            ps.setString(3, nv.getCccd());
            ps.setString(4, nv.getSoDienThoai());
            ps.setString(5, nv.getGioiTinh());
            ps.setString(6, nv.getVaiTro());
            ps.setString(7, nv.getUsername());
            ps.setString(8, nv.getPassword());
            ps.setLong(9, nv.getLuong());
            ps.setString(10, nv.getNgaySinh());
            ps.setString(11, nv.getDiaChi());
            ps.setString(12, nv.getTrangThai());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw e;
        }
    }

    // 4. Xóa nhân viên
    public boolean delete(String maNhanVien) throws SQLException {
        String sql = "DELETE FROM nhanvien WHERE manhanvien = ?";
        try (Connection c = JDBCUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, maNhanVien);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw e;
        }
    }

    // 5. Cập nhật nhân viên
    public boolean update(NhanVien nv) throws SQLException {
        String sql = "UPDATE nhanvien SET hoten=?, cccd=?, sodienthoai=?, gioitinh=?, vaitro=?, username=?, password=?, luong=?, ngaysinh=?, diachi=?, trangthai=? " +
                     "WHERE manhanvien=?";
        
        try (Connection c = JDBCUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, nv.getHoTen());
            ps.setString(2, nv.getCccd());
            ps.setString(3, nv.getSoDienThoai());
            ps.setString(4, nv.getGioiTinh());
            ps.setString(5, nv.getVaiTro());
            ps.setString(6, nv.getUsername());
            ps.setString(7, nv.getPassword());
            ps.setLong(8, nv.getLuong());
            ps.setString(9, nv.getNgaySinh());
            ps.setString(10, nv.getDiaChi());
            ps.setString(11, nv.getTrangThai());
            ps.setString(12, nv.getMaNhanVien());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw e;
        }
    }
}