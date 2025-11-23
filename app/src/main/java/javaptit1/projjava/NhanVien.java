package javaptit1.projjava;
import java.util.*;
import java.util.Scanner;
public class NhanVien extends connguoi {
    protected String hoTen, cccd, diaChi, soDienThoai, doB, gioiTinh, vaitro, trangthai, user, password, quyenhan, maNhanVien;
    protected long luong;
    
    public String getMaNhanVien() { return maNhanVien; }
    public String getHoTen() { return hoTen; }
    public String getCccd() { return cccd; }
    public String getDoB() { return doB; }
    public long getLuong() { return luong; }
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
        luong = sc.nextLong();
    }

    public void output() {
        System.out.println("Ho ten: " + hoTen);
        System.out.println("CCCD: " + cccd);
        System.out.println("Dia chi: " + diaChi);
        System.out.println("SDT: " + soDienThoai);
        System.out.println("Ngay sinh: " + doB);
        System.out.println("Gioi tinh: " + gioiTinh);
        System.out.println("vai tro: " + vaitro);
        System.out.println("trang thai: " + trangthai);
        System.out.println("user: " + user);
        System.out.println("password: " + password);
        System.out.println("quyen han: " + quyenhan);
        System.out.println("Ma nhan vien: " + maNhanVien);
        System.out.println("Luong: " + luong);
    }
    public String toFileString(){
        return hoTen + ";" + cccd + ";" + diaChi + ";" + soDienThoai + ";" +
               doB + ";" + gioiTinh + ";" + vaitro + ";" + trangthai + ";" +
               user + ";" + password + ";" + quyenhan + ";" + maNhanVien + ";" + luong;
    }    
}
