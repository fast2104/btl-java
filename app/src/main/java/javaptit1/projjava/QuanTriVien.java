package javaptit1.projjava;

import java.sql.*;
import java.util.*;
import java.util.Scanner;

public class QuanTriVien extends NhanVien {
    
    public QuanTriVien() {
    }

    public void input(Scanner sc) {
        super.input(sc);
    }

    public void output() {
        super.output();
    public void themNhanVien() {
        Scanner sc = new Scanner(System.in);
        NhanVien nv = new NhanVien();
        System.out.println("\n--- NHAP THONG TIN NHAN VIEN MOI ---");
        nv.input(sc); 
        
        Connection c = null;
        PreparedStatement ps = null;

        try {
            c = JDBCUtil.getConnection();
            String sql = "INSERT INTO NhanVien (maNhanVien, hoTen, cccd, diaChi, soDienThoai, ngaySinh, gioiTinh, vaiTro, trangThai, username, password, quyenHan, luong) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            ps = c.prepareStatement(sql);
            ps.setString(1, nv.maNhanVien);
            ps.setString(2, nv.hoTen);
            ps.setString(3, nv.cccd);
            ps.setString(4, nv.diaChi);
            ps.setString(5, nv.soDienThoai);
            ps.setString(6, nv.doB);
            ps.setString(7, nv.gioiTinh);
            ps.setString(8, nv.vaitro);
            ps.setString(9, nv.trangthai);
            ps.setString(10, nv.user);
            ps.setString(11, nv.password);
            ps.setString(12, nv.quyenhan);
            ps.setLong(13, nv.luong);
            
            int ketqua = ps.executeUpdate();
            if (ketqua > 0) {
                System.out.println("Thêm nhân viên thành công vào Database!");
            } else {
                System.out.println("Thêm thất bại!");
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            System.err.println("Lỗi: Mã nhân viên hoặc Username đã tồn tại.");
        } catch (SQLException e) {
            System.err.println("Lỗi SQL khi thêm nhân viên: " + e.getMessage());
        } finally {
            JDBCUtil.closeConnection(c);
        }
    }

    public void hienThiTatCaNhanVien() {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = JDBCUtil.getConnection();
            String sql = "SELECT maNhanVien, hoTen, soDienThoai, luong, quyenHan FROM NhanVien";
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();

            System.out.println("\n--- DANH SÁCH NHÂN VIÊN TỪ DATABASE ---");
            System.out.println("-----------------------------------------------------------------");
            System.out.printf("%-15s | %-25s | %-15s | %-10s%n", "Mã NV", "Họ Tên", "SĐT", "Lương");
            System.out.println("-----------------------------------------------------------------");
            
            while (rs.next()) {
                String ma = rs.getString("maNhanVien");
                String ten = rs.getString("hoTen");
                String sdt = rs.getString("soDienThoai");
                long luong = rs.getLong("luong");
                
                System.out.printf("%-15s | %-25s | %-15s | %,d%n", ma, ten, sdt, luong);
            }
            System.out.println("-----------------------------------------------------------------");
        } catch (SQLException e) {
            System.err.println("Lỗi SQL khi hiển thị: " + e.getMessage());
        } finally {
            JDBCUtil.closeConnection(c);
        }
    }
    
    public void xoaNhanVien() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma nhan vien can xoa: ");
        String ma = sc.nextLine();
        
        Connection c = null;
        PreparedStatement ps = null;
        
        try {
            c = JDBCUtil.getConnection();
            String sql = "DELETE FROM NhanVien WHERE maNhanVien = ?";
            ps = c.prepareStatement(sql);
            ps.setString(1, ma);
            
            int kq = ps.executeUpdate();
            if (kq > 0) {
                System.out.println("Đã xóa nhân viên có mã " + ma + " thành công.");
            } else {
                System.out.println("Không tìm thấy mã nhân viên cần xóa.");
            }
        } catch (SQLException e) {
            System.err.println("Lỗi SQL khi xóa nhân viên: " + e.getMessage());
        } finally {
            JDBCUtil.closeConnection(c);
        }
    }
    
    public void suaNhanVien() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma nhan vien can sua: ");
        String ma = sc.nextLine();
        
        Connection c = null;
        PreparedStatement ps = null;
        
        try {
            System.out.println("Nhap thong tin moi (de trong de giu nguyen):");
            System.out.print("Nhap ho ten moi: ");
            String hoTenMoi = sc.nextLine();
            System.out.print("Nhap luong moi (nhap 0 de giu nguyen): ");
            long luongMoi = sc.nextLong();
            sc.nextLine(); 
            c = JDBCUtil.getConnection();

            String sql = "UPDATE NhanVien SET hoTen = IFNULL(NULLIF(?, ''), hoTen), luong = IF(? > 0, ?, luong) WHERE maNhanVien = ?";
            
            ps = c.prepareStatement(sql);
            ps.setString(1, hoTenMoi.isEmpty() ? null : hoTenMoi); 
            ps.setLong(2, luongMoi);
            ps.setLong(3, luongMoi);
            ps.setString(4, ma);
            
            int kq = ps.executeUpdate();
            
            if (kq > 0) {
                System.out.println("Đã cập nhật thông tin nhân viên có mã " + ma + ".");
            } else {
                System.out.println("Không tìm thấy mã nhân viên hoặc không có thay đổi.");
            }
        } catch (SQLException e) {
            System.err.println("Lỗi SQL khi cập nhật: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.err.println("Lỗi nhập dữ liệu (nhập số cho lương).");
            sc.nextLine(); 
        } finally {
            JDBCUtil.closeConnection(c);
        }
    }

    public void timnhanvien() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma nhan vien can tim: ");
        String ma = sc.nextLine();
        
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = JDBCUtil.getConnection();
            String sql = "SELECT * FROM NhanVien WHERE maNhanVien = ?";
            ps = c.prepareStatement(sql);
            ps.setString(1, ma);
            rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("\n--- THÔNG TIN NHÂN VIÊN ĐƯỢC TÌM THẤY ---");
                System.out.println("Mã NV: " + rs.getString("maNhanVien"));
                System.out.println("Họ tên: " + rs.getString("hoTen"));
                System.out.println("CCCD: " + rs.getString("cccd"));
                System.out.println("Địa chỉ: " + rs.getString("diaChi"));
                System.out.println("SĐT: " + rs.getString("soDienThoai"));
                System.out.println("Ngày sinh: " + rs.getString("ngaySinh"));
                System.out.println("Vai trò: " + rs.getString("vaiTro"));
                System.out.println("Lương: " + rs.getLong("luong"));

            } else {
                System.out.println("Không tìm thấy nhân viên có mã " + ma);
            }
        } catch (SQLException e) {
            System.err.println("Lỗi SQL khi tìm kiếm: " + e.getMessage());
        } finally {
            JDBCUtil.closeConnection(c);
        }
    }
}