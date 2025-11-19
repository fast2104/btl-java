package javaptit1.projjava.gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ImportPanel extends JPanel {

    public ImportPanel() {
        setLayout(new BorderLayout());
        
        // --- PHẦN TRÁI: LỊCH SỬ ---
        JPanel pnlHistory = new JPanel(new BorderLayout());
        pnlHistory.setBorder(new TitledBorder("Lịch sử phiếu nhập"));
        String[] colsPhieu = {"Mã Phiếu", "Ngày nhập", "Nhà CC", "Tổng tiền"};
        pnlHistory.add(new JScrollPane(new JTable(new Object[][]{}, colsPhieu)), BorderLayout.CENTER);

        // --- PHẦN PHẢI: TẠO PHIẾU ---
        JPanel pnlNew = new JPanel(new BorderLayout());
        pnlNew.setBorder(new TitledBorder("Tạo phiếu nhập"));

        // Form thông tin chung
        JPanel pnlInfo = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0; pnlInfo.add(new JLabel("Nhà cung cấp:"), gbc);
        gbc.gridx = 1; pnlInfo.add(new JComboBox<>(new String[]{"NCC Samsung", "NCC Apple"}), gbc);
        
        gbc.gridx = 0; gbc.gridy = 1; pnlInfo.add(new JLabel("Nhân viên:"), gbc);
        gbc.gridx = 1; pnlInfo.add(new JTextField("Tự động lấy tên NV"), gbc); // Readonly

        pnlNew.add(pnlInfo, BorderLayout.NORTH);

        // Bảng giỏ hàng chi tiết
        String[] colsDetail = {"Sản phẩm", "Số lượng", "Đơn giá", "Thành tiền"};
        pnlNew.add(new JScrollPane(new JTable(new Object[][]{}, colsDetail)), BorderLayout.CENTER);

        // Nút chức năng dưới cùng
        JPanel pnlBot = new JPanel(new BorderLayout());
        JPanel pnlAct = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlAct.add(new JButton("Chọn sản phẩm"));
        pnlAct.add(new JButton("Xóa dòng"));
        
        JPanel pnlTotal = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel lblTotal = new JLabel("Tổng tiền: 0 đ");
        lblTotal.setFont(new Font("Arial", Font.BOLD, 14));
        lblTotal.setForeground(Color.RED);
        JButton btnSave = new JButton("LƯU PHIẾU");
        btnSave.setBackground(new Color(0, 150, 0));
        btnSave.setForeground(Color.WHITE);
        
        pnlTotal.add(lblTotal);
        pnlTotal.add(btnSave);

        pnlBot.add(pnlAct, BorderLayout.WEST);
        pnlBot.add(pnlTotal, BorderLayout.EAST);
        pnlNew.add(pnlBot, BorderLayout.SOUTH);

        // Split Pane
        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnlHistory, pnlNew);
        split.setResizeWeight(0.4); // Trái 40%, Phải 60%
        add(split, BorderLayout.CENTER);
    }
}