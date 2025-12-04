package javaptit1.projjava.gui;

import javaptit1.projjava.Session;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class HeaderPanel extends JPanel {

    // Bỏ tham số truyền vào, lấy trực tiếp từ Session
    public HeaderPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(33, 150, 243));
        setPreferredSize(new Dimension(100, 60));
        setBorder(new EmptyBorder(10, 20, 10, 20));

        // Bên trái: Logo và Tên PM
        JPanel pnlLeft = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
        pnlLeft.setOpaque(false);
        JLabel lblTitle = new JLabel("QUẢN LÝ KHO - NHÓM 6");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitle.setForeground(Color.WHITE);
        pnlLeft.add(lblTitle);

        // Bên phải: Thông tin User
        JPanel pnlRight = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 0));
        pnlRight.setOpaque(false);
        
        // Lấy thông tin từ Session
        String userName = "Admin";
        String role = "Quản trị";

        if (Session.user != null) {
            userName = Session.user.getHoTen();
            role = Session.user.getVaiTro();
        }

        JLabel lblUser = new JLabel("<html><div style='text-align: right; color: white;'>" +
                "Xin chào, <b>" + userName + "</b><br>" +
                "<i style='font-size: 10px;'>" + role + "</i></div></html>");
        
        JButton btnLogout = new JButton("Đăng xuất");
        btnLogout.setBackground(new Color(255, 82, 82));
        btnLogout.setForeground(Color.BLACK);
        btnLogout.setFocusPainted(false);
        btnLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // --- Xử lý Đăng xuất ---
        btnLogout.addActionListener(e -> {
            int choice = JOptionPane.showConfirmDialog(
                    this,
                    "Bạn có chắc chắn muốn đăng xuất?",
                    "Xác nhận",
                    JOptionPane.YES_NO_OPTION
            );

            if (choice == JOptionPane.YES_OPTION) {
                // Xóa session
                Session.user = null;

                // Đóng cửa sổ MainFrame đang dc mở
                Window currentWindow = SwingUtilities.getWindowAncestor(this);
                if (currentWindow != null) {
                    currentWindow.dispose();
                }

                // Mở lại LoginDialog
                LoginDialog login = new LoginDialog(null);
                login.setVisible(true);

                // Nếu đăng nhập lại thành công thì Mở MainFrame mới
                if (login.isLoginSuccess) {
                    new MainFrame().setVisible(true);
                }
            }
        });

        pnlRight.add(lblUser);
        pnlRight.add(btnLogout);

        add(pnlLeft, BorderLayout.WEST);
        add(pnlRight, BorderLayout.EAST);
    }
}