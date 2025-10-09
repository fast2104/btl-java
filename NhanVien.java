package javaptit1;
import java.util.*;

// NHANVIEN
class NhanVien {
    private String hoTen;
    private String cccd;
    private String diaChi;
    private String soDienThoai;
    private String doB;
    private String gioiTinh;

    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }

    public String getCccd() { return cccd; }
    public void setCccd(String cccd) { this.cccd = cccd; }

    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }

    public String getSoDienThoai() { return soDienThoai; }
    public void setSoDienThoai(String soDienThoai) { this.soDienThoai = soDienThoai; }

    public String getDoB() { return doB; }
    public void setDoB(String doB) { this.doB = doB; }

    public String getGioiTinh() { return gioiTinh; }
    public void setGioiTinh(String gioiTinh) { this.gioiTinh = gioiTinh; }

    public void input(Scanner sc) {
        System.out.print("Nhap ho ten: ");
        hoTen = sc.nextLine();
        System.out.print("Nhap CCCD: ");
        cccd = sc.nextLine();
        System.out.print("Nhap dia chi: ");
        diaChi = sc.nextLine();
        System.out.print("Nhap so dien thoai: ");
        soDienThoai = sc.nextLine();
        System.out.print("Nhap ngay sinh: ");
        doB = sc.nextLine();
        System.out.print("Nhap gioi tinh: ");
        gioiTinh = sc.nextLine();
    }

    public void output() {
        System.out.println("Ho ten: " + hoTen);
        System.out.println("CCCD: " + cccd);
        System.out.println("Dia chi: " + diaChi);
        System.out.println("SDT: " + soDienThoai);
        System.out.println("Ngay sinh: " + doB);
        System.out.println("Gioi tinh: " + gioiTinh);
    }
}

// QUANLY
class QuanLy extends NhanVien {
    private String maNhanVien;
    private int luong;

    public String getMaNhanVien() { return maNhanVien; }
    public void setMaNhanVien(String maNhanVien) { this.maNhanVien = maNhanVien; }

    public int getLuong() { return luong; }
    public void setLuong(int luong) { this.luong = luong; }

    @Override
    public void input(Scanner sc) {
        super.input(sc);
        System.out.print("Nhap ma nhan vien: ");
        maNhanVien = sc.nextLine();
        System.out.print("Nhap luong: ");
        luong = sc.nextInt();
        sc.nextLine();
    }

    @Override
    public void output() {
        super.output();
        System.out.println("Ma NV: " + maNhanVien);
        System.out.println("Luong: " + luong);
    }
}

// SANPHAM
class SanPham {
    private String maSanPham;
    private String tenSanPham;
    private int giaBan;
    private int giaMua;
    private int tonKho;
    private int daBan;

    public String getMaSanPham() { return maSanPham; }
    public void setMaSanPham(String maSanPham) { this.maSanPham = maSanPham; }

    public String getTenSanPham() { return tenSanPham; }
    public void setTenSanPham(String tenSanPham) { this.tenSanPham = tenSanPham; }

    public int getGiaBan() { return giaBan; }
    public void setGiaBan(int giaBan) { this.giaBan = giaBan; }

    public int getGiaMua() { return giaMua; }
    public void setGiaMua(int giaMua) { this.giaMua = giaMua; }

    public int getTonKho() { return tonKho; }
    public void setTonKho(int tonKho) { this.tonKho = tonKho; }

    public int getDaBan() { return daBan; }
    public void setDaBan(int daBan) { this.daBan = daBan; }

    public void input(Scanner sc) {
        System.out.print("Nhap ma SP: ");
        maSanPham = sc.nextLine();
        System.out.print("Nhap ten SP: ");
        tenSanPham = sc.nextLine();
        System.out.print("Nhap gia ban: ");
        giaBan = sc.nextInt();
        System.out.print("Nhap gia mua: ");
        giaMua = sc.nextInt();
        System.out.print("Nhap ton kho: ");
        tonKho = sc.nextInt();
        System.out.print("Nhap da ban: ");
        daBan = sc.nextInt();
        sc.nextLine();
    }

    public void output() {
        System.out.println("Ma SP: " + maSanPham);
        System.out.println("Ten SP: " + tenSanPham);
        System.out.println("Gia ban: " + giaBan);
        System.out.println("Gia mua: " + giaMua);
        System.out.println("Ton kho: " + tonKho);
        System.out.println("Da ban: " + daBan);
    }
}

// DONVICUNGCAP
class DonViCungCap {
    private String maDonVi;
    private String tenDonVi;
    private String matHang;

    public String getMaDonVi() { return maDonVi; }
    public void setMaDonVi(String maDonVi) { this.maDonVi = maDonVi; }

    public String getTenDonVi() { return tenDonVi; }
    public void setTenDonVi(String tenDonVi) { this.tenDonVi = tenDonVi; }

    public String getMatHang() { return matHang; }
    public void setMatHang(String matHang) { this.matHang = matHang; }

    public void input(Scanner sc) {
        System.out.print("Nhap ma don vi: ");
        maDonVi = sc.nextLine();
        System.out.print("Nhap ten don vi: ");
        tenDonVi = sc.nextLine();
        System.out.print("Nhap mat hang: ");
        matHang = sc.nextLine();
    }

    public void output() {
        System.out.println("Ma don vi: " + maDonVi);
        System.out.println("Ten don vi: " + tenDonVi);
        System.out.println("Mat hang: " + matHang);
    }
}

// PHIEUNHAPHANG
class PhieuNhapHang {
    private int maPhieu;
    private String ngayNhap;
    private String nhaCungCap;
    private int tongTien;

    public int getMaPhieu() { return maPhieu; }
    public void setMaPhieu(int maPhieu) { this.maPhieu = maPhieu; }

    public String getNgayNhap() { return ngayNhap; }
    public void setNgayNhap(String ngayNhap) { this.ngayNhap = ngayNhap; }

    public String getNhaCungCap() { return nhaCungCap; }
    public void setNhaCungCap(String nhaCungCap) { this.nhaCungCap = nhaCungCap; }

    public int getTongTien() { return tongTien; }
    public void setTongTien(int tongTien) { this.tongTien = tongTien; }

    public void input(Scanner sc) {
        System.out.print("Nhap ma phieu: ");
        maPhieu = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhap ngay nhap: ");
        ngayNhap = sc.nextLine();
        System.out.print("Nhap nha cung cap: ");
        nhaCungCap = sc.nextLine();
        System.out.print("Nhap tong tien: ");
        tongTien = sc.nextInt();
        sc.nextLine();
    }

    public void output() {
        System.out.println("Ma phieu: " + maPhieu);
        System.out.println("Ngay nhap: " + ngayNhap);
        System.out.println("Nha cung cap: " + nhaCungCap);
        System.out.println("Tong tien: " + tongTien);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("NHAP THONG TIN QUAN LY");
        QuanLy ql = new QuanLy();
        ql.input(sc);

        System.out.println("\nNHAP THONG TIN SAN PHAM");
        SanPham sp = new SanPham();
        sp.input(sc);

        System.out.println("\nNHAP THONG TIN DON VI CUNG CAP");
        DonViCungCap dv = new DonViCungCap();
        dv.input(sc);

        System.out.println("\nNHAP THONG TIN PHIEU NHAP HANG");
        PhieuNhapHang phieu = new PhieuNhapHang();
        phieu.input(sc);

        System.out.println("\nKET QUA");
        System.out.println("\nQuan ly");
        ql.output();

        System.out.println("\nSan pham");
        sp.output();

        System.out.println("\nDon vi cung cap");
        dv.output();

        System.out.println("\nPhieu nhap hang");
        phieu.output();

    }
}