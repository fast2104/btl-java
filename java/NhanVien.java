// java
package javaptit1.projjava;

import java.util.Scanner;

public class NhanVien extends connguoi {
    private String vaitro;
    private String trangthai;
    private String user;
    private String password;
    private String quyenhan;
    private String maNhanVien;
    private long luong;

    @Override
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
        System.out.print("Nhap vai tro: ");
        vaitro = sc.nextLine();
        System.out.print("Nhap trang thai: ");
        trangthai = sc.nextLine();
        System.out.print("Nhap user: ");
        user = sc.nextLine();
        System.out.print("Nhap password: ");
        password = sc.nextLine();
        System.out.print("Nhap quyen han: ");
        quyenhan = sc.nextLine();
        System.out.print("Nhap ma nhan vien: ");
        maNhanVien = sc.nextLine();
        System.out.print("Nhap luong: ");
        luong = Long.parseLong(sc.nextLine());
    }

    @Override
    public void output() {
        System.out.println("Ho ten: " + hoTen);
        System.out.println("CCCD: " + cccd);
        System.out.println("Dia chi: " + diaChi);
        System.out.println("SDT: " + soDienThoai);
        System.out.println("Ngay sinh: " + doB);
        System.out.println("Gioi tinh: " + gioiTinh);
        System.out.println("Vai tro: " + vaitro);
        System.out.println("Trang thai: " + trangthai);
        System.out.println("User: " + user);
        System.out.println("Password: " + password);
        System.out.println("Quyen han: " + quyenhan);
        System.out.println("Ma nhan vien: " + maNhanVien);
        System.out.println("Luong: " + luong);
    }

    // Getters and setters for fields previously accessed directly
    public String getVaitro() { return vaitro; }
    public void setVaitro(String vaitro) { this.vaitro = vaitro; }

    public String getTrangthai() { return trangthai; }
    public void setTrangthai(String trangthai) { this.trangthai = trangthai; }

    public String getUser() { return user; }
    public void setUser(String user) { this.user = user; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getQuyenhan() { return quyenhan; }
    public void setQuyenhan(String quyenhan) { this.quyenhan = quyenhan; }

    public String getMaNhanVien() { return maNhanVien; }
    public void setMaNhanVien(String maNhanVien) { this.maNhanVien = maNhanVien; }

    public long getLuong() { return luong; }
    public void setLuong(long luong) { this.luong = luong; }
}
