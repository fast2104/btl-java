import java.util.Objects;
import java.util.Vector;

public class DonViCungCap {

	private String maDonVi;
	private String tenDonVi;
	private Vector<String> matHang;
	private String diaChi;

	public DonViCungCap() {
		this.matHang = new Vector<>();
	}

	public DonViCungCap(String maDonVi, String tenDonVi, Vector<String> matHang, String diaChi) {
		this.maDonVi = maDonVi;
		this.tenDonVi = tenDonVi;
		this.matHang = (matHang == null) ? new Vector<>() : matHang;
		this.diaChi = diaChi;
	}

	public String getMaDonVi() {
		return maDonVi;
	}

	public void setMaDonVi(String maDonVi) {
		this.maDonVi = maDonVi;
	}

	public String getTenDonVi() {
		return tenDonVi;
	}

	public void setTenDonVi(String tenDonVi) {
		this.tenDonVi = tenDonVi;
	}

	public Vector<String> getMatHang() {
		return matHang;
	}

	public void setMatHang(Vector<String> matHang) {
		this.matHang = matHang;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	@Override
	public String toString() {
		return "DonViCungCap{" +
				"maDonVi='" + maDonVi + '\'' +
				", tenDonVi='" + tenDonVi + '\'' +
				", matHang=" + matHang +
				", diaChi='" + diaChi + '\'' +
				'}';
	}

// 	@Override
// 	public boolean equals(Object o) {
// 		if (this == o) return true;
// 		if (o == null || getClass() != o.getClass()) return false;
// 		DonViCungCap that = (DonViCungCap) o;
// 		return Objects.equals(maDonVi, that.maDonVi);
// 	}

// 	@Override
// 	public int hashCode() {
// 		return Objects.hash(maDonVi);
// 	}
// }