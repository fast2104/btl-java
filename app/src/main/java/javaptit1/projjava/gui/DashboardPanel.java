package javaptit1.projjava.gui;

import javax.swing.*;
import java.awt.*;

public class DashboardPanel extends JPanel {
    public DashboardPanel() {
        setLayout(new GridBagLayout());
        JLabel lblWelcome = new JLabel("Chào mừng đến với Hệ thống Quản lý Kho");
        lblWelcome.setFont(new Font("Arial", Font.BOLD, 24));
        lblWelcome.setForeground(Color.GRAY);
        add(lblWelcome);
    }
}