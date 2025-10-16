import java.util.Optional;
import java.util.Scanner;
import java.util.Vector;

public class QuanTriVien extends NhanVien {

	private Vector<NhanVien> danhSachNhanVien;

	public QuanTriVien() {
		this.danhSachNhanVien = new Vector<>();
	}

	public QuanTriVien(Vector<NhanVien> danhSachNhanVien) {
		this.danhSachNhanVien = (danhSachNhanVien == null) ? new Vector<>() : danhSachNhanVien;
	}

	public Vector<NhanVien> getDanhSachNhanVien() {
		return danhSachNhanVien;
	}

	public void setDanhSachNhanVien(Vector<NhanVien> danhSachNhanVien) {
		this.danhSachNhanVien = danhSachNhanVien;
	}

	public void themNhanVien() {
		Scanner scanner = new Scanner(System.in);
		NhanVien nv = new NhanVien();
		nv.input();
		// Tranh trung ma nhan vien
		Optional<NhanVien> existed = danhSachNhanVien.stream()
				.filter(n -> nv.getMaNhanVien() != null && nv.getMaNhanVien().equals(n.getMaNhanVien()))
				.findFirst();
		if (existed.isPresent()) {
			System.out.println("Ma nhan vien da ton tai, khong the them.");
			return;
		}
		danhSachNhanVien.add(nv);
		System.out.println("Da them nhan vien.");
	}

	public void xoaNhanVien() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhap ma nhan vien can xoa: ");
		String ma = scanner.nextLine();
		boolean removed = danhSachNhanVien.removeIf(n -> n.getMaNhanVien() != null && n.getMaNhanVien().equals(ma));
		System.out.println(removed ? "Da xoa nhan vien." : "Khong tim thay nhan vien.");
	}

	public void suaNhanVien() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhap ma nhan vien can sua: ");
		String ma = scanner.nextLine();
		for (int i = 0; i < danhSachNhanVien.size(); i++) {
			NhanVien n = danhSachNhanVien.get(i);
			if (n.getMaNhanVien() != null && n.getMaNhanVien().equals(ma)) {
				System.out.println("Nhap lai thong tin nhan vien (se ghi de):");
				NhanVien capNhat = new NhanVien();
				capNhat.setMaNhanVien(ma);
				capNhat.input();
				// Dam bao khong thay doi ma
				capNhat.setMaNhanVien(ma);
				danhSachNhanVien.set(i, capNhat);
				System.out.println("Da cap nhat nhan vien.");
				return;
			}
		}
		System.out.println("Khong tim thay nhan vien.");
	}

	public NhanVien timKiemNhanVien() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhap ma nhan vien can tim: ");
		String ma = scanner.nextLine();
		for (NhanVien n : danhSachNhanVien) {
			if (n.getMaNhanVien() != null && n.getMaNhanVien().equals(ma)) {
				System.out.println("Tim thay: ");
				n.output();
				return n;
			}
		}
		System.out.println("Khong tim thay nhan vien.");
		return null;
	}
}