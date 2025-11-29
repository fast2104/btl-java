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

public class DonViCungCapDao {
    public List<DonViCungCap> getAll() throws SQLException {
        List<DonViCungCap> list = new ArrayList<>();
        String sql = "SELECT * FROM donvicungcap";
        try (Connection c = JDBCUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                DonViCungCap ncc = new DonViCungCap();
                ncc.setMaDonVi(rs.getString("madonvi"));
                ncc.setTenDonVi(rs.getString("tendonvi"));
                ncc.setMatHang(rs.getString("mathang"));
                ncc.setDiaChi(rs.getString("diachi"));
                list.add(ncc);
            }
        }
        return list;
    }

    public boolean insert(DonViCungCap ncc) throws SQLException {
        String sql = "INSERT INTO donvicungcap(madonvi, tendonvi, mathang, diachi) VALUES(?,?,?,?)";
        try (Connection c = JDBCUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, ncc.getMaDonVi());
            ps.setString(2, ncc.getTenDonVi());
            ps.setString(3, ncc.getMatHang());
            ps.setString(4, ncc.getDiaChi());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean delete(String maNCC) throws SQLException {
        String sql = "DELETE FROM donvicungcap WHERE madonvi=?";
        try (Connection c = JDBCUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, maNCC);
            return ps.executeUpdate() > 0;
        }
    }
}