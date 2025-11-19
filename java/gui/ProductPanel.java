package javaptit1.projjava.gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ProductPanel extends JPanel {

    public ProductPanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(new EmptyBorder(10, 10, 10, 10));

        // 1. Header tìm kiếm
        JPanel pnlSearch = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlSearch.add(new JLabel("Tìm kiếm:"));
        pnlSearch.add(new JTextField(20));
        pnlSearch.add(new JButton("Tìm"));
        add(pnlSearch, BorderLayout.NORTH);

        // 2. Bảng danh sách (Center)
        String[] columns = {"Mã SP", "Tên SP", "Loại", "Giá bán", "Tồn kho"};
        Object[][] data = {{"SP001", "Laptop Dell", "Laptop", "15.000.000", "10"}}; // Data mẫu
        JTable table = new JTable(data, columns);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // 3. Form nhập liệu (East)
        JPanel pnlRight = new JPanel(new BorderLayout());
        pnlRight.setPreferredSize(new Dimension(300, 0));
        
        JPanel pnlForm = new JPanel(new GridBagLayout());
        pnlForm.setBorder(new TitledBorder("Thông tin sản phẩm"));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Helper thêm component
        addFormItem(pnlForm, gbc, 0, "Mã SP:", new JTextField());
        addFormItem(pnlForm, gbc, 1, "Tên SP:", new JTextField());
        addFormItem(pnlForm, gbc, 2, "Loại:", new JComboBox<>(new String[]{"Điện tử", "Gia dụng"}));
        addFormItem(pnlForm, gbc, 3, "Giá bán:", new JTextField());
        addFormItem(pnlForm, gbc, 4, "Giá mua:", new JTextField());
        addFormItem(pnlForm, gbc, 5, "Tồn kho:", new JTextField());

        // Panel Nút bấm
        JPanel pnlButtons = new JPanel(new FlowLayout());
        pnlButtons.add(new JButton("Thêm"));
        pnlButtons.add(new JButton("Sửa"));
        pnlButtons.add(new JButton("Xóa"));

        pnlRight.add(pnlForm, BorderLayout.NORTH);
        pnlRight.add(pnlButtons, BorderLayout.CENTER);

        add(pnlRight, BorderLayout.EAST);
    }

    private void addFormItem(JPanel pnl, GridBagConstraints gbc, int row, String label, JComponent comp) {
        gbc.gridx = 0; gbc.gridy = row; gbc.weightx = 0.3;
        pnl.add(new JLabel(label), gbc);
        gbc.gridx = 1; gbc.weightx = 0.7;
        pnl.add(comp, gbc);
    }
}