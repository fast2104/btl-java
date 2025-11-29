package javaptit1.projjava.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class HeaderPanel extends JPanel {

    public HeaderPanel(String userName, String role) {
        setLayout(new BorderLayout());
        setBackground(new Color(33, 150, 243)); // Xanh dương
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
        
        JLabel lblUser = new JLabel("<html><div style='text-align: right; color: white;'>" +
                "Xin chào, <b>" + userName + "</b><br>" +
                "<i style='font-size: 10px;'>" + role + "</i></div></html>");
        
        pnlRight.add(lblUser);

        add(pnlLeft, BorderLayout.WEST);
        add(pnlRight, BorderLayout.EAST);
    }
}