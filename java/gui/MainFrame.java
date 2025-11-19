package javaptit1.projjava.gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel pnlContent;

    public MainFrame() {
        setTitle("Quản Lý Kho - Nhóm 6");
        setSize(1200, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // 1. Add Header (North)
        // Giả sử đang login với User admin
        add(new HeaderPanel("Admin User", "Quản trị viên"), BorderLayout.NORTH);

        // 2. Add Sidebar (West)
        add(new SidebarPanel(this), BorderLayout.WEST);

        // 3. Add Content (Center) - CardLayout
        cardLayout = new CardLayout();
        pnlContent = new JPanel(cardLayout);

        // Thêm các màn hình vào Card
        pnlContent.add(new DashboardPanel(), "HOME");
        pnlContent.add(new ProductPanel(), "PRODUCT");
        pnlContent.add(new ImportPanel(), "IMPORT");
        pnlContent.add(new EmployeePanel(), "EMPLOYEE");

        add(pnlContent, BorderLayout.CENTER);
    }

    // Hàm chuyển trang được gọi từ Sidebar
    public void switchPanel(String cardName) {
        cardLayout.show(pnlContent, cardName);
    }
}