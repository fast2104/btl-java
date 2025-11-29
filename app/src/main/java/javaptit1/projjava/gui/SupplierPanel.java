/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaptit1.projjava.gui;

/**
 *
 * @author Admin
 */
import javaptit1.projjava.DonViCungCap;
import javaptit1.projjava.DonViCungCapDao;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.sql.SQLException;

public class SupplierPanel extends JPanel {
    private JTextField txtMa, txtTen, txtMatHang, txtDiaChi;
    private JTable table;
    private DefaultTableModel tableModel;
    private DonViCungCapDao dao = new DonViCungCapDao();
    private MainFrame mainFrame;

    public SupplierPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout(10, 10));
        setBorder(new EmptyBorder(10, 10, 10, 10));

        // 1. Bảng danh sách
        String[] columns = {"Mã NCC", "Tên Nhà Cung Cấp", "Mặt Hàng", "Địa Chỉ"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        
        // Sự kiện click vào bảng để sửa
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table.getSelectedRow();
                if (row >= 0) {
                    txtMa.setText(table.getValueAt(row, 0).toString());
                    txtTen.setText(table.getValueAt(row, 1).toString());
                    txtMatHang.setText(table.getValueAt(row, 2).toString());
                    txtDiaChi.setText(table.getValueAt(row, 3).toString());
                }
            }
        });
        
        loadData();
        add(new JScrollPane(table), BorderLayout.CENTER);

        // 2. Form nhập liệu
        JPanel pnlRight = new JPanel(new BorderLayout());
        pnlRight.setPreferredSize(new Dimension(300, 0));
        
        JPanel pnlForm = new JPanel(new GridBagLayout());
        pnlForm.setBorder(new TitledBorder("Thông tin NCC"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); gbc.fill = GridBagConstraints.HORIZONTAL;
        
        txtMa = new JTextField();
        txtTen = new JTextField();
        txtMatHang = new JTextField();
        txtDiaChi = new JTextField();

        addFormItem(pnlForm, gbc, 0, "Mã NCC:", txtMa);
        addFormItem(pnlForm, gbc, 1, "Tên NCC:", txtTen);
        addFormItem(pnlForm, gbc, 2, "Mặt hàng:", txtMatHang);
        addFormItem(pnlForm, gbc, 3, "Địa chỉ:", txtDiaChi);

        JPanel pnlButtons = new JPanel(new FlowLayout());
        JButton btnAdd = new JButton("Thêm");
        JButton btnDel = new JButton("Xóa");
        JButton btnClear = new JButton("Làm mới");

        // --- Xử lý sự kiện ---
        btnAdd.addActionListener(e -> {
            try {
                if(txtMa.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Vui lòng nhập mã!");
                    return;
                }
                DonViCungCap ncc = new DonViCungCap();
                ncc.setMaDonVi(txtMa.getText());
                ncc.setTenDonVi(txtTen.getText());
                ncc.setMatHang(txtMatHang.getText());
                ncc.setDiaChi(txtDiaChi.getText());
                
                if(dao.insert(ncc)) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công!");
                    loadData();
                    clearForm();
                    mainFrame.onSupplierOrProductUpdate(); // Thông báo cho MainFrame
                } else {
                    JOptionPane.showMessageDialog(this, "Lỗi thêm (Trùng mã?)");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Lỗi cơ sở dữ liệu: " + ex.getMessage());
            }
        });

        btnDel.addActionListener(e -> {
            String ma = txtMa.getText();
            if(!ma.isEmpty()) {
                try {
                    if(dao.delete(ma)) {
                        JOptionPane.showMessageDialog(this, "Đã xóa!");
                        loadData();
                        clearForm();
                        mainFrame.onSupplierOrProductUpdate(); // Thông báo cho MainFrame
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Lỗi cơ sở dữ liệu: " + ex.getMessage());
                }
            }
        });
        
        btnClear.addActionListener(e -> clearForm());

        pnlButtons.add(btnAdd);
        pnlButtons.add(btnDel);
        pnlButtons.add(btnClear);

        pnlRight.add(pnlForm, BorderLayout.NORTH);
        pnlRight.add(pnlButtons, BorderLayout.CENTER);
        add(pnlRight, BorderLayout.EAST);
    }

    private void loadData() {
        try {
            tableModel.setRowCount(0);
            List<DonViCungCap> list = dao.getAll();
            for (DonViCungCap ncc : list) {
                tableModel.addRow(new Object[]{
                    ncc.getMaDonVi(), ncc.getTenDonVi(), ncc.getMatHang(), ncc.getDiaChi()
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi tải dữ liệu: " + e.getMessage());
        }
    }
    
    private void clearForm() {
        txtMa.setText(""); txtTen.setText(""); txtMatHang.setText(""); txtDiaChi.setText("");
    }

    private void addFormItem(JPanel pnl, GridBagConstraints gbc, int row, String label, JComponent comp) {
        gbc.gridx = 0; gbc.gridy = row; gbc.weightx = 0.3;
        pnl.add(new JLabel(label), gbc);
        gbc.gridx = 1; gbc.weightx = 0.7;
        pnl.add(comp, gbc);
    }
}