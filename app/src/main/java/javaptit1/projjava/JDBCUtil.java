/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaptit1.projjava;

/**
 *
 * @author Admin
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    public static Connection getConnection() throws SQLException {
        Connection c = null;
        try {
            // Đăng ký Driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/QuanLyCuaHang";
            String username = "root"; 
            String password = "";
            
            c = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            // Ném lại SQLException để lớp gọi có thể xử lý
            throw new SQLException("Không thể kết nối tới cơ sở dữ liệu. Vui lòng kiểm tra thông tin kết nối và đảm bảo MySQL server đang chạy.", e);
        }
        return c;
    }
    
    public static void closeConnection(Connection c) {
        try {
            if(c != null) c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
