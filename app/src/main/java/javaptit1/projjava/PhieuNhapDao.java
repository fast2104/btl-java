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
import java.util.List;
public class PhieuNhapDao {

    // ham nhan ma NCC, ma NV, tong tien, DS chi tiet hang(ma SP, sl, gia)
    public boolean taoPhieuNhap(String maNCC, String maNV, int tongTien, List<String[]> chiTietHang) throws SQLException {
        Connection c = null; // Khai báo ở ngoài để finally có thể truy cập
        PreparedStatement psPhieu = null;
        PreparedStatement psChiTiet = null;
        PreparedStatement psCapNhatKho = null;

        try {
            c = JDBCUtil.getConnection();
            // 1. Tắt chế độ tự động lưu để đảm bảo an toàn (Transaction)
            c.setAutoCommit(false);

            // 2. Tạo Mã Phiếu (Tự tăng hoặc random số)
            int maPhieu = (int) (System.currentTimeMillis() / 1000); // Lấy số giây hiện tại làm mã phiếu cho đơn giản

            // 3. Insert vào bảng phieunhaphang
            String sqlPhieu = "INSERT INTO phieunhaphang(maphieu, ngaynhap, tongtien, manhanvien, madonvi) VALUES(?, NOW(), ?, ?, ?)";
            psPhieu = c.prepareStatement(sqlPhieu);
            psPhieu.setInt(1, maPhieu);
            psPhieu.setInt(2, tongTien);
            psPhieu.setString(3, maNV); 
            psPhieu.setString(4, maNCC);
            psPhieu.executeUpdate();

            // 4. Duyệt qua danh sách hàng để Insert Chi Tiết & Cập nhật kho
            String sqlChiTiet = "INSERT INTO chitietphieunhap(maphieu, masanpham, soluong, dongia, thanhtien) VALUES(?, ?, ?, ?, ?)";
            String sqlKho = "UPDATE sanpham SET tonkho = tonkho + ? WHERE masanpham = ?";
            
            psChiTiet = c.prepareStatement(sqlChiTiet);
            psCapNhatKho = c.prepareStatement(sqlKho);

            for (String[] hang : chiTietHang) {
                String maSP = hang[0];
                int soLuong = Integer.parseInt(hang[1]);
                int donGia = Integer.parseInt(hang[2]);
                int thanhTien = Integer.parseInt(hang[3]);

                // Lưu chi tiết
                psChiTiet.setInt(1, maPhieu);
                psChiTiet.setString(2, maSP);
                psChiTiet.setInt(3, soLuong);
                psChiTiet.setInt(4, donGia);
                psChiTiet.setInt(5, thanhTien);
                psChiTiet.executeUpdate();

                // Cập nhật tồn kho
                psCapNhatKho.setInt(1, soLuong);
                psCapNhatKho.setString(2, maSP);
                psCapNhatKho.executeUpdate();
            }

            // 5. Nếu mọi thứ OK thì LƯU (Commit)
            c.commit();
            return true;

        } catch (SQLException e) {
            if (c != null) {
                try {
                    c.rollback(); // Nếu có lỗi thì hủy bỏ mọi thay đổi
                } catch (SQLException ex) {
                    // Ghi log hoặc xử lý lỗi rollback nếu cần
                }
            }
            throw e; // Ném lại lỗi để lớp gọi xử lý
        } finally {
            JDBCUtil.closeConnection(c);
        }
    }
    
    public java.util.List<PhieuNhap> getAll() throws SQLException {
        java.util.List<PhieuNhap> list = new java.util.ArrayList<>();
        String sql = "SELECT p.*, n.tendonvi FROM phieunhaphang p " + "JOIN donvicungcap n ON p.madonvi = n.madonvi " + "ORDER BY p.ngaynhap DESC";
        
        try (Connection c = JDBCUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                PhieuNhap pn = new PhieuNhap();
                pn.setMaPhieu(rs.getInt("maphieu"));
                pn.setNgayNhap(rs.getString("ngaynhap"));
                pn.setTongTien(rs.getInt("tongtien"));
                pn.setMaNhanVien(rs.getString("manhanvien"));
                pn.setMaDonVi(rs.getString("madonvi"));
                pn.setTenNhaCungCap(rs.getString("tendonvi"));
                list.add(pn);
            }
        }
        return list;
    }    
}