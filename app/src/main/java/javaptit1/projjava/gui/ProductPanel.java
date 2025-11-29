package javaptit1.projjava.gui;

import javaptit1.projjava.SanPham;
import javaptit1.projjava.SanPhamDao;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.List;
import java.sql.SQLException;

public class ProductPanel extends JPanel {
    private JTextField txtMaSP, txtTenSP, txtGiaBan, txtGiaMua, txtTonKho, txtNguonGoc, txtMoTa, txtDonVi, txtDaBan;
    private JComboBox<String> cboLoai;
    private JTable table;
    private DefaultTableModel tableModel;
    private SanPhamDao dao = new SanPhamDao();
    private DecimalFormat df = new DecimalFormat("#,###");
    private MainFrame mainFrame;

    public ProductPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout(10, 10));
        setBorder(new EmptyBorder(10, 10, 10, 10));

        // Bảng danh sách
        String[] columns = {"Mã SP", "Tên SP", "Loại", "Giá bán", "Giá mua", "Tồn kho", "Nguồn gốc", "Mô tả", "Đơn vị", "Đã bán"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        
        // Sự kiện click bảng -> Đổ dữ liệu lên form
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table.getSelectedRow();
                if (row >= 0) {
                    txtMaSP.setText(table.getValueAt(row, 0).toString());
                    txtTenSP.setText(table.getValueAt(row, 1).toString());
                    cboLoai.setSelectedItem(table.getValueAt(row, 2).toString());
                    // Xóa dấu phẩy tiền tệ để hiển thị lên ô nhập
                    txtGiaBan.setText(table.getValueAt(row, 3).toString().replace(",", "").replace(".", ""));
                    txtGiaMua.setText(table.getValueAt(row, 4).toString().replace(",", "").replace(".", ""));
                    txtTonKho.setText(table.getValueAt(row, 5).toString());
                    txtNguonGoc.setText(table.getValueAt(row, 6).toString());
                    txtMoTa.setText(table.getValueAt(row, 7).toString());
                    txtDonVi.setText(table.getValueAt(row, 8).toString());
                    txtDaBan.setText(table.getValueAt(row, 9).toString());
                }
            }
        });
        
        loadData(); // Tải dữ liệu từ DB lên bảng
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Form nhập liệu bên phải
        JPanel pnlRight = new JPanel(new BorderLayout());
        pnlRight.setPreferredSize(new Dimension(300, 0));
        
        JPanel pnlForm = new JPanel(new GridBagLayout());
        pnlForm.setBorder(new TitledBorder("Thông tin sản phẩm"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); gbc.fill = GridBagConstraints.HORIZONTAL;
        
        txtMaSP = new JTextField();
        txtTenSP = new JTextField();
        cboLoai = new JComboBox<>(new String[]{"Điện tử", "Gia dụng", "Thực phẩm", "Thời trang"});
        txtGiaBan = new JTextField("0");
        txtGiaMua = new JTextField("0");
        txtTonKho = new JTextField("0");
        txtNguonGoc = new JTextField();
        txtMoTa = new JTextField();
        txtDonVi = new JTextField();
        txtDaBan = new JTextField("0");


        addFormItem(pnlForm, gbc, 0, "Mã SP:", txtMaSP);
        addFormItem(pnlForm, gbc, 1, "Tên SP:", txtTenSP);
        addFormItem(pnlForm, gbc, 2, "Loại:", cboLoai);
        addFormItem(pnlForm, gbc, 3, "Giá bán:", txtGiaBan);
        addFormItem(pnlForm, gbc, 4, "Giá mua:", txtGiaMua);
        addFormItem(pnlForm, gbc, 5, "Tồn kho:", txtTonKho);
        addFormItem(pnlForm, gbc, 6, "Nguồn gốc:", txtNguonGoc);
        addFormItem(pnlForm, gbc, 7, "Mô tả:", txtMoTa);
        addFormItem(pnlForm, gbc, 8, "Đơn vị:", txtDonVi);
        addFormItem(pnlForm, gbc, 9, "Đã bán:", txtDaBan);

        // Panel chứa nút bấm
        JPanel pnlButtons = new JPanel(new FlowLayout());
        JButton btnAdd = new JButton("Thêm");
        JButton btnDelete = new JButton("Xóa");
        JButton btnClear = new JButton("Làm mới");

        // --- XỬ LÝ SỰ KIỆN NÚT BẤM ---
        btnAdd.addActionListener(e -> {
            try {
                // Kiểm tra rỗng
                if(txtMaSP.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Chưa nhập mã sản phẩm!");
                    return;
                }
                SanPham sp = new SanPham();
                sp.setMaSanPham(txtMaSP.getText());
                sp.setTenSanPham(txtTenSP.getText());
                sp.setLoaiSanpham(cboLoai.getSelectedItem().toString());
                sp.setGiaBan(Integer.parseInt(txtGiaBan.getText()));
                sp.setGiaMua(Integer.parseInt(txtGiaMua.getText()));
                sp.setTonKho(Integer.parseInt(txtTonKho.getText()));
                sp.setNguonGoc(txtNguonGoc.getText());
                sp.setMoTa(txtMoTa.getText());
                sp.setDonVi(txtDonVi.getText());
                sp.setDaBan(Integer.parseInt(txtDaBan.getText()));
                
                if(dao.insert(sp)) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công!");
                    loadData();
                    clearForm();
                    mainFrame.onSupplierOrProductUpdate(); // Thông báo cho MainFrame
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại (Trùng mã?)");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Lỗi cơ sở dữ liệu: " + ex.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Lỗi nhập liệu (Giá phải là số): " + ex.getMessage());
            }
        });

        btnDelete.addActionListener(e -> {
            String ma = txtMaSP.getText();
            if(ma.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm để xóa!");
                return;
            }
            if(JOptionPane.showConfirmDialog(this, "Bạn chắc chắn xóa SP: " + ma + "?") == JOptionPane.YES_OPTION) {
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
        pnlButtons.add(btnDelete);
        pnlButtons.add(btnClear);

        pnlRight.add(pnlForm, BorderLayout.NORTH);
        pnlRight.add(pnlButtons, BorderLayout.CENTER);
        add(pnlRight, BorderLayout.EAST);
    }

    public void loadData() {
        try {
            tableModel.setRowCount(0);
            List<SanPham> list = dao.getAll();
            for (SanPham sp : list) {
                tableModel.addRow(new Object[]{
                    sp.getMaSanPham(), sp.getTenSanPham(), sp.getLoaiSanpham(),
                    df.format(sp.getGiaBan()), df.format(sp.getGiaMua()), sp.getTonKho(),
                    sp.getNguonGoc(), sp.getMoTa(), sp.getDonVi(), sp.getDaBan()
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi tải dữ liệu: " + e.getMessage());
        }
    }
    
    private void clearForm() {
        txtMaSP.setText(""); txtTenSP.setText(""); 
        txtGiaBan.setText("0"); txtGiaMua.setText("0"); txtTonKho.setText("0");
        txtNguonGoc.setText(""); txtMoTa.setText(""); txtDonVi.setText(""); txtDaBan.setText("0");
        table.clearSelection();
    }

    private void addFormItem(JPanel pnl, GridBagConstraints gbc, int row, String label, JComponent comp) {
        gbc.gridx = 0; gbc.gridy = row; gbc.weightx = 0.3;
        pnl.add(new JLabel(label), gbc);
        gbc.gridx = 1; gbc.weightx = 0.7;
        pnl.add(comp, gbc);
    }
}