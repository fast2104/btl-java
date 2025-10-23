import java.util.Optional;
import java.util.Scanner;
import java.util.Vector;

public class QuanTriVien extends NhanVien {
    private String maQuanTriVien;
    private Vector<NhanVien> danhSachNhanVien;

    public QuanTriVien() {
        this.danhSachNhanVien = new Vector<>();
    }

    @Override
    public void input(Scanner sc) {
        super.input(sc);
        System.out.print("Nhap ma quan tri vien: ");
        maQuanTriVien = sc.nextLine();
    }

    @Override
    public void output() {
        super.output();
        System.out.println("Ma Quan Ly: " + maQuanTriVien);
        System.out.println("So luong nhan vien dang quan ly: " + danhSachNhanVien.size());
    }

    public void themNhanVien() {
        Scanner sc = new Scanner(System.in);
        NhanVien nv = new NhanVien();
        nv.input(sc);

        Optional<NhanVien> existed = danhSachNhanVien.stream()
                .filter(n -> n.cccd != null && n.cccd.equals(nv.cccd))
                .findFirst();
        if (existed.isPresent()) {
            System.out.println("Nhan vien da ton tai");
            return;
        }
        danhSachNhanVien.add(nv);
        System.out.println("Da them nhan vien thanh cong.");
    }

    public void xoaNhanVien() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap CCCD nhan vien can xoa: ");
        String ma = sc.nextLine();
        boolean removed = danhSachNhanVien.removeIf(n -> n.cccd != null && n.cccd.equals(ma));
        System.out.println(removed ? "Da xoa nhan vien." : "Khong tim thay nhan vien.");
    }

    public void hienThiTatCaNhanVien() {
        if (danhSachNhanVien.isEmpty()) {
            System.out.println("Danh sach nhan vien rong");
            return;
        }
        System.out.println("    DANH SACH NHAN VIEN");
        for (NhanVien n : danhSachNhanVien) {
            n.output();
        }
    }
}
