/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaptit1.projjava.gui;

/**
 *
 * @author Admin
 */
import javaptit1.projjava.NhanVien;
import javaptit1.projjava.NhanVienDao;
import javaptit1.projjava.Session;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class LoginDialog extends JDialog {
    private JTextField txtUser;
    private JPasswordField txtPass;
    private NhanVienDao dao = new NhanVienDao();
    public boolean isLoginSuccess = false;

    public LoginDialog(Frame parent) {
        super(parent, "Đăng nhập hệ thống", true);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Logo hoặc Tiêu đề
        JLabel lblTitle = new JLabel("QUẢN LÝ KHO HÀNG", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitle.setForeground(Color.BLUE);
        
        gbc.gridwidth = 2; gbc.gridx = 0; gbc.gridy = 0;
        add(lblTitle, gbc);

        // Input
        gbc.gridwidth = 1; gbc.gridy = 1;
        add(new JLabel("Tài khoản:"), gbc);
        gbc.gridx = 1; 
        txtUser = new JTextField(15);
        add(txtUser, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        add(new JLabel("Mật khẩu:"), gbc);
        gbc.gridx = 1;
        txtPass = new JPasswordField(15);
        add(txtPass, gbc);

        // Button
        JButton btnLogin = new JButton("Đăng nhập");
        JButton btnExit = new JButton("Thoát");
        
        JPanel pnlBtn = new JPanel();
        pnlBtn.add(btnLogin);
        pnlBtn.add(btnExit);
        
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        add(pnlBtn, gbc);

        // Sự kiện
        btnLogin.addActionListener(e -> {
            String u = txtUser.getText();
            String p = new String(txtPass.getPassword());
            
            try {
                NhanVien nv = dao.checkLogin(u, p);
                if (nv != null) {
                    Session.user = nv; // LƯU VÀO SESSION
                    isLoginSuccess = true;
                    dispose(); // Tắt form login
                } else {
                    JOptionPane.showMessageDialog(this, "Sai tài khoản hoặc mật khẩu!");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Lỗi kết nối cơ sở dữ liệu: " + ex.getMessage());
            }
        });
        
        btnExit.addActionListener(e -> System.exit(0));
    }
}