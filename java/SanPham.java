import java.util.Objects;
import java.util.Scanner;

public class SanPham {

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

	public SanPham() {
	}

	public SanPham(String maSanPham, String tenSanPham) {
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
	}

	public SanPham(String maSanPham, String tenSanPham, String loaiSanPham, String nguonGoc, String moTa,
			String donVi, long giaBan, long giaMua, int tonKho, int daBan) {
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.loaiSanPham = loaiSanPham;
		this.nguonGoc = nguonGoc;
		this.moTa = moTa;
		this.donVi = donVi;
		this.giaBan = giaBan;
		this.giaMua = giaMua;
		this.tonKho = tonKho;
		this.daBan = daBan;
	}

	public String getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public String getLoaiSanPham() {
		return loaiSanPham;
	}

	public void setLoaiSanPham(String loaiSanPham) {
		this.loaiSanPham = loaiSanPham;
	}

	public String getNguonGoc() {
		return nguonGoc;
	}

	public void setNguonGoc(String nguonGoc) {
		this.nguonGoc = nguonGoc;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getDonVi() {
		return donVi;
	}

	public void setDonVi(String donVi) {
		this.donVi = donVi;
	}

	public long getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(long giaBan) {
		this.giaBan = giaBan;
	}

	public long getGiaMua() {
		return giaMua;
	}

	public void setGiaMua(long giaMua) {
		this.giaMua = giaMua;
	}

	public int getTonKho() {
		return tonKho;
	}

	public void setTonKho(int tonKho) {
		this.tonKho = tonKho;
	}

	public int getDaBan() {
		return daBan;
	}

	public void setDaBan(int daBan) {
		this.daBan = daBan;
	}

	public void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ma san pham: ");
		this.maSanPham = scanner.nextLine();
		System.out.print("Ten san pham: ");
		this.tenSanPham = scanner.nextLine();
		System.out.print("Loai san pham: ");
		this.loaiSanPham = scanner.nextLine();
		System.out.print("Nguon goc: ");
		this.nguonGoc = scanner.nextLine();
		System.out.print("Mo ta: ");
		this.moTa = scanner.nextLine();
		System.out.print("Don vi: ");
		this.donVi = scanner.nextLine();
		System.out.print("Gia ban: ");
		this.giaBan = Long.parseLong(scanner.nextLine());
		System.out.print("Gia mua: ");
		this.giaMua = Long.parseLong(scanner.nextLine());
		System.out.print("Ton kho: ");
		this.tonKho = Integer.parseInt(scanner.nextLine());
		System.out.print("Da ban: ");
		this.daBan = Integer.parseInt(scanner.nextLine());
	}

	public void output() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "SanPham{" +
				"maSanPham='" + maSanPham + '\'' +
				", tenSanPham='" + tenSanPham + '\'' +
				", loaiSanPham='" + loaiSanPham + '\'' +
				", nguonGoc='" + nguonGoc + '\'' +
				", moTa='" + moTa + '\'' +
				", donVi='" + donVi + '\'' +
				", giaBan=" + giaBan +
				", giaMua=" + giaMua +
				", tonKho=" + tonKho +
				", daBan=" + daBan +
				'}';
	}

// 	@Override
// 	public boolean equals(Object o) {
// 		if (this == o) return true;
// 		if (o == null || getClass() != o.getClass()) return false;
// 		SanPham sanPham = (SanPham) o;
// 		return Objects.equals(maSanPham, sanPham.maSanPham);
// 	}

// 	@Override
// 	public int hashCode() {
// 		return Objects.hash(maSanPham);
// 	}
// }