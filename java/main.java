import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuanTriVien qtv = new QuanTriVien();
        int chon;

        do {
            System.out.println("\n  MENU CHINH");
            System.out.println("1. Quan ly nhan vien");
            System.out.println("2. Nhap thong tin QL, SP, DVCC, PhieuNhapHang");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1 -> bang1(qtv);
                case 2 -> bang2(sc, qtv);
                case 0 -> System.out.println("Thoat chuong trinh.");
                default -> System.out.println("Lua chon khong hop le.");
            }
        } while (chon != 0);
    }

    private static void bang1(QuanTriVien qtv) {
        Scanner sc = new Scanner(System.in);
        int c;
        do {
            System.out.println("\n  MENU QUAN LY");
            System.out.println("1. Them nhan vien");
            System.out.println("2. Xoa nhan vien");
            System.out.println("3. Hien thi tat ca");
            System.out.println("4. Sua nhan vien");
            System.out.println("5. tim nhan vien");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            c = sc.nextInt();
            sc.nextLine();

            switch (c) {
                case 1 -> qtv.themNhanVien();
                case 2 -> qtv.xoaNhanVien();
                case 3 -> qtv.hienThiTatCaNhanVien();
                case 4 -> qtv.suaNhanVien();
                case 5 -> qtv.timnhanvien();
            }
        } while (c != 0);
    }

    private static void bang2(Scanner sc, QuanTriVien qtv) {
        System.out.println("NHAP THONG TIN QUAN LY");
        qtv.input(sc);
        System.out.println("THONG TIN QUAN LY: ");
        qtv.output();

        SanPham sp = new SanPham();
        System.out.println("\nNHAP SAN PHAM:");
        sp.input(sc);
        System.out.println("THONG TIN SAN PHAM:");
        sp.output();

        DonViCungCap dv = new DonViCungCap();
        System.out.println("\nNHAP DV CUNG CAP:");
        dv.input(sc);
        System.out.println("THONG TIN DVCC:");
        dv.output();

        PhieuNhapHang phieu = new PhieuNhapHang();
        System.out.println("\nNHAP PHIEU NHAP HANG:");
        phieu.input(sc);
        System.out.println("THONG TIN PHIEU:");
        phieu.output();
    }
}
