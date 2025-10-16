import java.util.Objects;

public class ChiTietPhieuNhap {

	private SanPham sanPham;
	private int soLuong;
	private long donGia;

	public ChiTietPhieuNhap() {
	}

	public ChiTietPhieuNhap(SanPham sanPham, int soLuong, long donGia) {
		this.sanPham = sanPham;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public long getDonGia() {
		return donGia;
	}

	public void setDonGia(long donGia) {
		this.donGia = donGia;
	}

	@Override
	public String toString() {
		return "ChiTietPhieuNhap{" +
				"sanPham=" + sanPham +
				", soLuong=" + soLuong +
				", donGia=" + donGia +
				'}';
	}

// 	@Override
// 	public boolean equals(Object o) {
// 		if (this == o) return true;
// 		if (o == null || getClass() != o.getClass()) return false;
// 		ChiTietPhieuNhap that = (ChiTietPhieuNhap) o;
// 		return soLuong == that.soLuong && donGia == that.donGia && Objects.equals(sanPham, that.sanPham);
// 	}

// 	@Override
// 	public int hashCode() {
// 		return Objects.hash(sanPham, soLuong, donGia);
// 	}
// }