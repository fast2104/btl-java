package javaptit1.projjava.gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class EmployeePanel extends JPanel {

    public EmployeePanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(new EmptyBorder(10, 10, 10, 10));

        // Table
        String[] columns = {"Mã NV", "Họ tên", "SĐT", "Vai trò", "Trạng thái"};
        Object[][] data = {{"NV001", "Nguyen Van A", "0909123456", "Quản trị", "Đang làm"}};
        add(new JScrollPane(new JTable(data, columns)), BorderLayout.CENTER);

        // Form Right
        JPanel pnlRight = new JPanel(new BorderLayout());
        pnlRight.setPreferredSize(new Dimension(320, 0));
        
        JPanel pnlForm = new JPanel(new GridBagLayout());
        pnlForm.setBorder(new TitledBorder("Thông tin nhân viên"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        addFormItem(pnlForm, gbc, 0, "Mã NV:", new JTextField());
        addFormItem(pnlForm, gbc, 1, "Họ tên:", new JTextField());
        addFormItem(pnlForm, gbc, 2, "CCCD:", new JTextField());
        addFormItem(pnlForm, gbc, 3, "SĐT:", new JTextField());
        
        // Giới tính
        gbc.gridx = 0; gbc.gridy = 4;
        pnlForm.add(new JLabel("Giới tính:"), gbc);
        JPanel pnlGender = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        ButtonGroup bg = new ButtonGroup();
        JRadioButton rdNam = new JRadioButton("Nam", true);
        JRadioButton rdNu = new JRadioButton("Nữ");
        bg.add(rdNam); bg.add(rdNu);
        pnlGender.add(rdNam); pnlGender.add(rdNu);
        gbc.gridx = 1;
        pnlForm.add(pnlGender, gbc);

        addFormItem(pnlForm, gbc, 5, "Vai trò:", new JComboBox<>(new String[]{"Nhân viên", "Quản trị"}));
        addFormItem(pnlForm, gbc, 6, "Username:", new JTextField());
        addFormItem(pnlForm, gbc, 7, "Password:", new JPasswordField());

        // Buttons
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