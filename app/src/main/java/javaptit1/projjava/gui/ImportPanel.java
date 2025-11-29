package javaptit1.projjava.gui;

import javaptit1.projjava.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

public class ImportPanel extends JPanel {
    // DAO
    private SanPhamDao spDao = new SanPhamDao();
    private DonViCungCapDao nccDao = new DonViCungCapDao();
    private PhieuNhapDao pnDao = new PhieuNhapDao();

    // Components
    private JComboBox<DonViCungCap> cboNCC;
    private JComboBox<SanPham> cboSanPham;
    private JTextField txtSoLuong;
    private JTable tblCart, tblHistory;
    private DefaultTableModel modelCart, modelHistory;
    private JLabel lblTongTien;
    
    // Tham chiếu đến MainFrame để gọi lại
    private MainFrame mainFrame;
    
    // Dữ liệu tạm (Giỏ hàng)
    private List<String[]> cartList = new ArrayList<>(); // Lưu: {MaSP, SoLuong, DonGia, ThanhTien, TenSP}
    private long totalAmount = 0;
    private DecimalFormat df = new DecimalFormat("#,###");

    public ImportPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame; // Lưu tham chiếu
        setLayout(new BorderLayout());
        
        // --- PHẦN TRÁI: LỊCH SỬ NHẬP ---
        JPanel pnlHistory = new JPanel(new BorderLayout());
        pnlHistory.setBorder(new TitledBorder("Lịch sử phiếu nhập"));
        String[] colsPhieu = {"Mã Phiếu", "Ngày nhập", "Nhà CC", "Tổng tiền"};
        modelHistory = new DefaultTableModel(colsPhieu, 0);
        tblHistory = new JTable(modelHistory);
        loadHistory(); // Load dữ liệu lịch sử
        pnlHistory.add(new JScrollPane(tblHistory), BorderLayout.CENTER);

        // --- PHẦN PHẢI: TẠO PHIẾU MỚI ---
        JPanel pnlNew = new JPanel(new BorderLayout());
        pnlNew.setBorder(new TitledBorder("Tạo phiếu nhập mới"));

        // 1. Form thông tin chung (Header)
        JPanel pnlInfo = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); gbc.fill = GridBagConstraints.HORIZONTAL;

        // Load NCC vào ComboBox
        cboNCC = new JComboBox<>();
        loadSuppliers();

        gbc.gridx = 0; gbc.gridy = 0; pnlInfo.add(new JLabel("Nhà cung cấp:"), gbc);
        gbc.gridx = 1; pnlInfo.add(cboNCC, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1; pnlInfo.add(new JLabel("Nhân viên:"), gbc);
        gbc.gridx = 1; pnlInfo.add(new JLabel(Session.user.getHoTen()), gbc);

        pnlNew.add(pnlInfo, BorderLayout.NORTH);

        // 2. Khu vực chọn sản phẩm thêm vào giỏ
        JPanel pnlAddProduct = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlAddProduct.setBorder(BorderFactory.createTitledBorder("Chọn hàng nhập"));
        
        cboSanPham = new JComboBox<>();
        loadProducts();
        
        txtSoLuong = new JTextField(5);
        JButton btnAdd = new JButton("Thêm vào phiếu");
        
        pnlAddProduct.add(new JLabel("Sản phẩm:")); pnlAddProduct.add(cboSanPham);
        pnlAddProduct.add(new JLabel("SL:")); pnlAddProduct.add(txtSoLuong);
        pnlAddProduct.add(btnAdd);

        // 3. Bảng giỏ hàng (Cart)
        String[] colsDetail = {"Mã SP", "Tên SP", "Số lượng", "Đơn giá", "Thành tiền"};
        modelCart = new DefaultTableModel(colsDetail, 0);
        tblCart = new JTable(modelCart);
        
        JPanel pnlCenter = new JPanel(new BorderLayout());
        pnlCenter.add(pnlAddProduct, BorderLayout.NORTH);
        pnlCenter.add(new JScrollPane(tblCart), BorderLayout.CENTER);
        pnlNew.add(pnlCenter, BorderLayout.CENTER);

        // 4. Footer (Tổng tiền & Nút Lưu)
        JPanel pnlBot = new JPanel(new BorderLayout());
        JPanel pnlTotal = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        lblTongTien = new JLabel("Tổng tiền: 0 đ");
        lblTongTien.setFont(new Font("Arial", Font.BOLD, 16));
        lblTongTien.setForeground(Color.RED);
        
        JButton btnSave = new JButton("LƯU PHIẾU NHẬP");
        btnSave.setBackground(new Color(0, 150, 0));
        btnSave.setForeground(Color.BLACK); // Đổi màu chữ thành màu đen
        btnSave.setFont(new Font("Arial", Font.BOLD, 12));
        
        JButton btnDelRow = new JButton("Xóa dòng chọn");

        pnlBot.add(btnDelRow, BorderLayout.WEST);
        pnlTotal.add(lblTongTien);
        pnlTotal.add(btnSave);
        pnlBot.add(pnlTotal, BorderLayout.EAST);
        pnlNew.add(pnlBot, BorderLayout.SOUTH);

        // --- SỰ KIỆN ---
        // Sự kiện: Nút Thêm vào giỏ
        btnAdd.addActionListener(e -> {
            try {
                SanPham sp = (SanPham) cboSanPham.getSelectedItem();
                if (sp == null) {
                    JOptionPane.showMessageDialog(this, "Vui lòng chọn một sản phẩm!");
                    return;
                }
                int sl = Integer.parseInt(txtSoLuong.getText());
                int gia = sp.getGiaMua(); // Tự động lấy giá mua từ sản phẩm
                int thanhTien = sl * gia;

                // Thêm vào list tạm
                String[] row = {sp.getMaSanPham(), String.valueOf(sl), String.valueOf(gia), String.valueOf(thanhTien), sp.getTenSanPham()};
                cartList.add(row);
                
                // Hiển thị lên bảng
                modelCart.addRow(new Object[]{sp.getMaSanPham(), sp.getTenSanPham(), sl, df.format(gia), df.format(thanhTien)});
                
                updateTotal();
                txtSoLuong.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng hợp lệ!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi: " + ex.getMessage());
            }
        });

        // Sự kiện: Nút Lưu phiếu
        btnSave.addActionListener(e -> {
            if(cartList.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Giỏ hàng đang trống!");
                return;
            }
            
            DonViCungCap ncc = (DonViCungCap) cboNCC.getSelectedItem();
            String maNV = Session.user.getMaNhanVien();
            
            try {
                if(pnDao.taoPhieuNhap(ncc.getMaDonVi(), maNV, (int)totalAmount, cartList)) {
                    JOptionPane.showMessageDialog(this, "Nhập hàng thành công!");
                    
                    // Gọi lại MainFrame để thông báo cho các panel khác
                    if (mainFrame != null) {
                        mainFrame.onImportSuccess();
                    }
                    
                    // Reset giao diện
                    modelCart.setRowCount(0);
                    cartList.clear();
                    updateTotal();
                    loadHistory(); // Load lại lịch sử để thấy phiếu vừa tạo
                    loadProducts(); // Tải lại sản phẩm để cập nhật tồn kho
                } else {
                    JOptionPane.showMessageDialog(this, "Lỗi khi lưu phiếu!");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Lỗi cơ sở dữ liệu khi lưu phiếu: " + ex.getMessage());
                ex.printStackTrace(); // In chi tiết lỗi ra console để debug
            }
        });

        // Split Pane
        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnlHistory, pnlNew);
        split.setResizeWeight(0.4);
        add(split, BorderLayout.CENTER);
    }

    private void updateTotal() {
        totalAmount = 0;
        for (String[] item : cartList) {
            totalAmount += Long.parseLong(item[3]);
        }
        lblTongTien.setText("Tổng tiền: " + df.format(totalAmount) + " đ");
    }

    private void loadHistory() {
        try {
            modelHistory.setRowCount(0);
            List<PhieuNhap> list = pnDao.getAll();
            for (PhieuNhap pn : list) {
                modelHistory.addRow(new Object[]{
                    pn.getMaPhieu(), pn.getNgayNhap(), pn.getTenNhaCungCap(), df.format(pn.getTongTien())
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi tải lịch sử nhập hàng: " + e.getMessage());
        }
    }
    
    public void loadSuppliers() {
        try {
            cboNCC.removeAllItems();
            List<DonViCungCap> listNCC = nccDao.getAll();
            for(DonViCungCap ncc : listNCC) cboNCC.addItem(ncc);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi tải nhà cung cấp: " + e.getMessage());
        }
    }
    
    public void loadProducts() {
        try {
            cboSanPham.removeAllItems();
            List<SanPham> listSP = spDao.getAll();
            for(SanPham sp : listSP) cboSanPham.addItem(sp);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi tải sản phẩm: " + e.getMessage());
        }
    }
}