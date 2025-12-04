package javaptit1.projjava.gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel pnlContent;
    
    // Giữ tham chiếu đến các panel cần tương tác
    private ProductPanel productPanel;
    private ImportPanel importPanel;
    private SupplierPanel supplierPanel;

    public MainFrame() {
        setTitle("Quản Lý Kho - Nhóm 6");
        setSize(1200, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // 1. Add Header (North) - không cần truyền parameter
        add(new HeaderPanel(), BorderLayout.NORTH);

        // 2. Add Sidebar (West)
        add(new SidebarPanel(this), BorderLayout.WEST);

        // 3. Add Content (Center) - CardLayout
        cardLayout = new CardLayout();
        pnlContent = new JPanel(cardLayout);

        // Khởi tạo các panel
        productPanel = new ProductPanel(this);
        importPanel = new ImportPanel(this); 
        supplierPanel = new SupplierPanel(this);

        // Thêm các màn hình vào Card
        pnlContent.add(new DashboardPanel(), "HOME");
        pnlContent.add(productPanel, "PRODUCT");
        pnlContent.add(importPanel, "IMPORT");
        pnlContent.add(new EmployeePanel(), "EMPLOYEE");
        pnlContent.add(supplierPanel, "SUPPLIER");

        add(pnlContent, BorderLayout.CENTER);
    }

    // Hàm chuyển trang được gọi từ Sidebar
    public void switchPanel(String cardName) {
        cardLayout.show(pnlContent, cardName);
    }

    // Hàm để ImportPanel gọi sau khi nhập hàng thành công
    public void onImportSuccess() {
        // Tải lại dữ liệu trên ProductPanel
        if (productPanel != null) {
            productPanel.loadData();
        }
    }
    
    // Hàm để SupplierPanel hoặc ProductPanel gọi sau khi có thay đổi
    public void onSupplierOrProductUpdate() {
        if (importPanel != null) {
            importPanel.loadSuppliers();
            importPanel.loadProducts();
        }
    }
}