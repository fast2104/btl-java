package javaptit1.projjava; // Đổi package theo project của bạn

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    public static Connection getConnection() {
        Connection c = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            
            String url = "jdbc:mysql://localhost:3306/QuanLyCuaHang";
            String username = "root"; 
            String password = "";    
            
            c = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
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