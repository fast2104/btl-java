package javaptit1.projjava.gui;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {}

            // Hiện form đăng nhập
            LoginDialog login = new LoginDialog(null);
            login.setVisible(true);

            // Nếu đăng nhập thành công thì mở MainFrame
            if (login.isLoginSuccess) {
                new MainFrame().setVisible(true);
            }
        });
    }
}