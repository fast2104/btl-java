import java.util.*;

public class main {

    // ====== Lớp SanPham ======
    static class SanPham {
        private String maSanPham;
        private String tenSanPham;
        private String loaiSanPham;
        private String nguonGoc;
        private String moTa;
        private String donVi;
        private long giaBan;
        private long giaMua;
        private int tonKho;
        private int daBan;

        public void input(Scanner sc) {
            System.out.print("Nhập mã sản phẩm: ");
            maSanPham = sc.nextLine();
            System.out.print("Nhập tên sản phẩm: ");
            tenSanPham = sc.nextLine();
            System.out.print("Nhập loại sản phẩm: ");
            loaiSanPham = sc.nextLine();
            System.out.print("Nhập nguồn gốc: ");
            nguonGoc = sc.nextLine();
            System.out.print("Nhập mô tả: ");
            moTa = sc.nextLine();
            System.out.print("Nhập đơn vị: ");
            donVi = sc.nextLine();
            System.out.print("Nhập giá bán: ");
            giaBan = sc.nextLong();
            System.out.print("Nhập giá mua: ");
            giaMua = sc.nextLong();
            System.out.print("Nhập tồn kho: ");
            tonKho = sc.nextInt();
            System.out.print("Nhập đã bán: ");
            daBan = sc.nextInt();
            sc.nextLine();
        }

        public void output() {
            System.out.println("Mã SP: " + maSanPham + " | Tên: " + tenSanPham +
                    " | Loại: " + loaiSanPham + " | Giá bán: " + giaBan +
                    " | Giá mua: " + giaMua + " | Tồn kho: " + tonKho + " | Đã bán: " + daBan);
        }
    }

    // ====== Lớp NhanVien ======
    static class NhanVien {
        private String hoTen, cccd, diaChi, soDienThoai, gioiTinh, vaiTro, trangThai, user, password, quyenHan, maNhanVien;
        private Date DoB;
        private long luong;

        public void input(Scanner sc) {
            System.out.print("Nhập họ tên: ");
            hoTen = sc.nextLine();
            System.out.print("Nhập CCCD: ");
            cccd = sc.nextLine();
            System.out.print("Nhập địa chỉ: ");
            diaChi = sc.nextLine();
            System.out.print("Nhập số điện thoại: ");
            soDienThoai = sc.nextLine();
            System.out.print("Nhập giới tính: ");
            gioiTinh = sc.nextLine();
            System.out.print("Nhập vai trò: ");
            vaiTro = sc.nextLine();
            System.out.print("Nhập trạng thái: ");
            trangThai = sc.nextLine();
            System.out.print("Nhập username: ");
            user = sc.nextLine();
            System.out.print("Nhập password: ");
            password = sc.nextLine();
            System.out.print("Nhập quyền hạn: ");
            quyenHan = sc.nextLine();
            System.out.print("Nhập mã nhân viên: ");
            maNhanVien = sc.nextLine();
            System.out.print("Nhập lương: ");
            luong = sc.nextLong();
            sc.nextLine();
        }

        public void output() {
            System.out.println("Nhân viên: " + hoTen + " | CCCD: " + cccd +
                    " | SDT: " + soDienThoai + " | Vai trò: " + vaiTro + " | Lương: " + luong);
        }
    }

    // ====== Lớp QuanTriVien kế thừa NhanVien ======
    static class QuanTriVien extends NhanVien {
        private ArrayList<NhanVien> dsNhanVien = new ArrayList<>();

        public void themNhanVien(NhanVien nv) {
            dsNhanVien.add(nv);
        }

        public void xoaNhanVien(String ma) {
            dsNhanVien.removeIf(nv -> nv.maNhanVien.equals(ma));
        }

        public void suaNhanVien(String ma, String tenMoi) {
            for (NhanVien nv : dsNhanVien) {
                if (nv.maNhanVien.equals(ma)) {
                    nv.hoTen = tenMoi;
                }
            }
        }

        public NhanVien timKiemNhanVien(String ma) {
            for (NhanVien nv : dsNhanVien) {
                if (nv.maNhanVien.equals(ma)) return nv;
            }
            return null;
        }
    }

    // ====== Lớp DonViCungCap ======
    static class DonViCungCap {
        private String maDonVi, tenDonVi, diaChi;
        private Vector<String> matHang = new Vector<>();
    }

    // ====== Lớp ChiTietPhieuNhap ======
    static class ChiTietPhieuNhap {
        private SanPham sanPham;
        private int soLuong;
        private long donGia;
    }

    // ====== Lớp PhieuNhapHang ======
    static class PhieuNhapHang {
        private int maPhieu;
        private Date ngayNhap;
        private DonViCungCap nhaCungCap;
        private long tongTien;
        private NhanVien nguoiLapPhieu;
        private Vector<ChiTietPhieuNhap> chiTietPhieuNhap = new Vector<>();
    }

    // ====== Main để test ======
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SanPham sp = new SanPham();
        sp.input(sc);
        sp.output();

        NhanVien nv = new NhanVien();
        nv.input(sc);
        nv.output();
    }
}
