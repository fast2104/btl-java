package javaptit1.projjava.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SidebarPanel extends JPanel {
    private MainFrame mainFrame;

    public SidebarPanel(MainFrame frame) {
        this.mainFrame = frame;
        setLayout(new GridLayout(10, 1, 0, 5));
        setBackground(new Color(60, 63, 65));
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setPreferredSize(new Dimension(200, 0));

        addMenuButton("Trang chủ", "HOME");
        addMenuButton("Sản phẩm", "PRODUCT");
        addMenuButton("Nhập hàng", "IMPORT");
        addMenuButton("Nhân viên", "EMPLOYEE");
    }

    private void addMenuButton(String text, String cardName) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Arial", Font.BOLD, 14));
        btn.setBackground(new Color(75, 110, 175));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setOpaque(true); // Force paint background
        btn.setBorderPainted(false); // Remove border for cleaner look

        btn.addActionListener(e -> mainFrame.switchPanel(cardName));

        add(btn);
    }
}
