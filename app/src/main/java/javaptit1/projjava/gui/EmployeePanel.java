package javaptit1.projjava.gui;

import javaptit1.projjava.NhanVien;
import javaptit1.projjava.NhanVienDao;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.text.DecimalFormat;
import java.sql.SQLException;

public class EmployeePanel extends JPanel {
    // Khai báo các component giao diện
    private JTextField txtMaNV, txtHoTen, txtCCCD, txtSDT, txtUser, txtNgaySinh, txtDiaChi, txtLuong;
    private JPasswordField txtPass;
    private JComboBox<String> cboVaiTro, cboTrangThai;
    private JRadioButton rdNam, rdNu;
    private JTable table;
    private DefaultTableModel tableModel;
    
    // Gọi lớp xử lý dữ liệu
    private NhanVienDao dao = new NhanVienDao();
    private DecimalFormat df = new DecimalFormat("#,###"); // Định dạng tiền tệ

    public EmployeePanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(new EmptyBorder(10, 10, 10, 10));

        // --- 1. BẢNG DỮ LIỆU (CENTER) ---
        String[] columns = {"Mã NV", "Họ tên", "SĐT", "Vai trò", "Lương", "Trạng thái", "Ngày sinh", "Địa chỉ"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        
        // Sự kiện: Khi bấm vào bảng -> Đổ dữ liệu lên các ô nhập
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                if(row >= 0) {
                    txtMaNV.setText(safeString(table.getValueAt(row, 0)));
                    txtMaNV.setEditable(false); // Khi đang sửa thì không cho sửa Mã NV (khóa chính)
                    
                    txtHoTen.setText(safeString(table.getValueAt(row, 1)));
                    txtSDT.setText(safeString(table.getValueAt(row, 2)));
                    cboVaiTro.setSelectedItem(safeString(table.getValueAt(row, 3)));
                    
                    // Xử lý tiền lương (xóa dấu chấm/phẩy khi hiển thị lại vào ô nhập)
                    String luongTrenBang = safeString(table.getValueAt(row, 4));
                    txtLuong.setText(luongTrenBang.replace(".", "").replace(",", ""));
                    
                    cboTrangThai.setSelectedItem(safeString(table.getValueAt(row, 5)));
                    txtNgaySinh.setText(safeString(table.getValueAt(row, 6)));
                    txtDiaChi.setText(safeString(table.getValueAt(row, 7)));
                }
            }
        });
        
        loadDataToTable(); // Tải dữ liệu ngay khi mở
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel pnlRight = new JPanel(new BorderLayout());
        pnlRight.setPreferredSize(new Dimension(350, 0));
        
        JPanel pnlForm = new JPanel(new GridBagLayout());
        pnlForm.setBorder(new TitledBorder("Thông tin nhân viên"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Khởi tạo các ô nhập
        txtMaNV = new JTextField();
        txtHoTen = new JTextField();
        txtCCCD = new JTextField();
        txtSDT = new JTextField();
        txtNgaySinh = new JTextField(); 
        txtDiaChi = new JTextField();   
        txtLuong = new JTextField("0"); 
        
        txtUser = new JTextField();
        txtPass = new JPasswordField();
        cboVaiTro = new JComboBox<>(new String[]{"Nhân viên", "Quản trị"});
        cboTrangThai = new JComboBox<>(new String[]{"Đang làm việc", "Đã nghỉ"}); 
        
        // Sắp xếp các ô nhập lên form
        addFormItem(pnlForm, gbc, 0, "Mã NV:", txtMaNV);
        addFormItem(pnlForm, gbc, 1, "Họ tên:", txtHoTen);
        addFormItem(pnlForm, gbc, 2, "CCCD:", txtCCCD);
        addFormItem(pnlForm, gbc, 3, "SĐT:", txtSDT);
        addFormItem(pnlForm, gbc, 4, "Ngày sinh:", txtNgaySinh);
        addFormItem(pnlForm, gbc, 5, "Địa chỉ:", txtDiaChi);
        
        // Giới tính (Radio Button)
        gbc.gridx = 0; gbc.gridy = 6;
        pnlForm.add(new JLabel("Giới tính:"), gbc);
        JPanel pnlGender = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        ButtonGroup bg = new ButtonGroup();
        rdNam = new JRadioButton("Nam", true);
        rdNu = new JRadioButton("Nữ");
        bg.add(rdNam); bg.add(rdNu);
        pnlGender.add(rdNam); pnlGender.add(rdNu);
        gbc.gridx = 1;
        pnlForm.add(pnlGender, gbc);

        addFormItem(pnlForm, gbc, 7, "Vai trò:", cboVaiTro);
        addFormItem(pnlForm, gbc, 8, "Trạng thái:", cboTrangThai);
        addFormItem(pnlForm, gbc, 9, "Lương (VNĐ):", txtLuong);
        addFormItem(pnlForm, gbc, 10, "Username:", txtUser);
        addFormItem(pnlForm, gbc, 11, "Password:", txtPass);

        JPanel pnlButtons = new JPanel(new FlowLayout());
        JButton btnAdd = new JButton("Thêm");
        JButton btnEdit = new JButton("Sửa");
        JButton btnDelete = new JButton("Xóa");
        JButton btnReset = new JButton("Làm mới");
        btnAdd.addActionListener((ActionEvent e) -> {
            try {
                NhanVien nv = getModelFromForm(); // Lấy dữ liệu từ form
                if(dao.insert(nv)) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công!");
                    loadDataToTable();
                    resetForm();
                } else {
                    JOptionPane.showMessageDialog(this, "Lỗi thêm! Kiểm tra xem Mã NV hoặc Username có bị trùng không.");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Lỗi cơ sở dữ liệu: " + ex.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Lỗi dữ liệu: " + ex.getMessage());
            }
        });
        btnEdit.addActionListener((ActionEvent e) -> {
            try {
                if(txtMaNV.getText().isEmpty() || txtMaNV.isEditable()) {
                    JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên cần sửa trên bảng trước!");
                    return;
                }
                
                NhanVien nv = getModelFromForm();
                
                if(JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn cập nhật thông tin?") == JOptionPane.YES_OPTION) {
                    if(dao.update(nv)) {
                        JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
                        loadDataToTable();
                        resetForm();
                    } else {
                        JOptionPane.showMessageDialog(this, "Lỗi cập nhật!");
                    }
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Lỗi cơ sở dữ liệu: " + ex.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Lỗi dữ liệu: " + ex.getMessage());
            }
        });
        btnDelete.addActionListener(e -> {
            int row = table.getSelectedRow();
            if(row >= 0) {
                String maNV = table.getValueAt(row, 0).toString();
                if(JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa nhân viên " + maNV + "?") == JOptionPane.YES_OPTION){
                    try {
                        if(dao.delete(maNV)) {
                            JOptionPane.showMessageDialog(this, "Đã xóa thành công!");
                            loadDataToTable();
                            resetForm();
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(this, "Lỗi cơ sở dữ liệu: " + ex.getMessage());
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xóa!");
            }
        });
        btnReset.addActionListener(e -> resetForm());

        // Thêm nút vào giao diện
        pnlButtons.add(btnAdd);
        pnlButtons.add(btnEdit);
        pnlButtons.add(btnDelete);
        pnlButtons.add(btnReset);

        pnlRight.add(pnlForm, BorderLayout.NORTH);
        pnlRight.add(pnlButtons, BorderLayout.CENTER);
        add(pnlRight, BorderLayout.EAST);
    }

    // Hàm phụ: Lấy dữ liệu từ Form đóng gói thành đối tượng NhanVien
    private NhanVien getModelFromForm() throws Exception {
        NhanVien nv = new NhanVien();
        nv.setMaNhanVien(txtMaNV.getText());
        nv.setHoTen(txtHoTen.getText());
        nv.setCccd(txtCCCD.getText());
        nv.setSoDienThoai(txtSDT.getText());
        nv.setNgaySinh(txtNgaySinh.getText()); 
        nv.setDiaChi(txtDiaChi.getText());
        nv.setGioiTinh(rdNam.isSelected() ? "Nam" : "Nữ");
        nv.setVaiTro(cboVaiTro.getSelectedItem().toString());
        nv.setTrangThai(cboTrangThai.getSelectedItem().toString());
        
        // Xử lý lương (chuyển chuỗi thành số)
        String luongStr = txtLuong.getText().replace(",", "").replace(".", "");
        if(luongStr.trim().isEmpty()) luongStr = "0";
        nv.setLuong(Long.parseLong(luongStr)); 
        
        nv.setUsername(txtUser.getText());
        nv.setPassword(new String(txtPass.getPassword()));
        return nv;
    }

    // Hàm phụ: Tải dữ liệu từ DB lên bảng
    private void loadDataToTable() {
        try {
            tableModel.setRowCount(0); // Xóa trắng bảng
            List<NhanVien> list = dao.getAll();
            for (NhanVien nv : list) {
                tableModel.addRow(new Object[]{
                    nv.getMaNhanVien(), 
                    nv.getHoTen(), 
                    nv.getSoDienThoai(), 
                    nv.getVaiTro(), 
                    df.format(nv.getLuong()), 
                    nv.getTrangThai(),
                    nv.getNgaySinh(),
                    nv.getDiaChi()
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi tải dữ liệu: " + e.getMessage());
        }
    }
    
    private void resetForm() {
        txtMaNV.setText(""); txtMaNV.setEditable(true);
        txtHoTen.setText(""); txtCCCD.setText("");
        txtSDT.setText(""); txtNgaySinh.setText(""); txtDiaChi.setText("");
        txtUser.setText(""); txtPass.setText(""); txtLuong.setText("0");
        cboTrangThai.setSelectedIndex(0);
        table.clearSelection();
    }
    
    // Hàm phụ: Chống lỗi null khi lấy dữ liệu từ bảng
    private String safeString(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    // Hàm phụ: Thêm component vào GridBagLayout cho gọn code
    private void addFormItem(JPanel pnl, GridBagConstraints gbc, int row, String label, JComponent comp) {
        gbc.gridx = 0; gbc.gridy = row; gbc.weightx = 0.3;
        pnl.add(new JLabel(label), gbc);
        gbc.gridx = 1; gbc.weightx = 0.7;
        pnl.add(comp, gbc);
    }
}