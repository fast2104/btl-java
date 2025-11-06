import java.util.Optional;
import java.util.Scanner;
import java.util.Vector;

public class QuanTriVien extends NhanVien {
    private Vector<NhanVien> danhSachNhanVien;

    public QuanTriVien() {
        this.danhSachNhanVien = new Vector<>();
    }

    @Override
    public void input(Scanner sc) {
        super.input(sc);
    }

    @Override
    public void output() {
        super.output();
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
        System.out.print("Nhap ma nhan vien nhan vien can xoa: ");
        String ma = sc.nextLine();
        boolean removed = danhSachNhanVien.removeIf(n -> n.maNhanVien != null && n.maNhanVien.equals(ma));
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
    public void suaNhanVien() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma nhan vien can sua: ");
        String ma = sc.nextLine();

        Optional<NhanVien> nv = danhSachNhanVien.stream()
            .filter(n -> n.maNhanVien != null && n.maNhanVien.equals(ma))
            .findFirst();

        if (nv.isPresent()) {
            NhanVien n = nv.get();
            System.out.println("Thong tin hien tai:");
            n.output();

            System.out.print("Nhap ten moi(giu nguyen nhap bo trong): ");
            String tenMoi = sc.nextLine();
            if(!tenMoi.isEmpty()) n.hoTen = tenMoi;
            
            System.out.println("nhap cccd moi(giu nguyen nhap bo trong): ");
            String cccdmoi = sc.nextLine();
            if(!cccdmoi.isEmpty()) n.cccd = cccdmoi;

            System.out.print("Nhap dia chi moi(giu nguyen nhap bo trong): ");
            String diaChiMoi = sc.nextLine();
            if(!diaChiMoi.isEmpty()) n.diaChi = diaChiMoi;
            
            System.out.println("nhap sdt moi(giu nguyen nhap bo trong): ");
            String sdtmoi = sc.nextLine();
            if(!sdtmoi.isEmpty()) n.soDienThoai = sdtmoi;
            
            System.out.println("nhap dob moi(giu nguyen nhap bo trong): ");
            String dobmoi = sc.nextLine();
            if(!dobmoi.isEmpty()) n.doB = dobmoi;
            
            System.out.println("nhap gioi tinh moi(gay?): ");
            String gioitinhmoi = sc.nextLine();
            if(!gioitinhmoi.isEmpty()) n.gioiTinh = gioitinhmoi;

            System.out.print("Nhap luong moi(giu nguyen nhap 0): ");
            double luongMoi = sc.nextDouble();
            if(luongMoi > 0) n.luong = (long) luongMoi;

            System.out.println("da update tt nhan vien");
        } else {
            System.out.println("khong co nhan vien.");
        }
    }
    public void timnhanvien(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma nhan vien: ");
        String mnv = sc.nextLine();
        
        Optional<NhanVien> nv = danhSachNhanVien.stream()
                .filter(n -> n.maNhanVien != null && n.maNhanVien.equalsIgnoreCase(mnv))
                .findFirst();
        if(nv.isPresent()) nv.get().output();
        else System.out.println("ko tim thay nv");
    }
}
