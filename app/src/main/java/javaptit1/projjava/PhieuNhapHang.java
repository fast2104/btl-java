package javaptit1.projjava;
import java.io.*;
import java.util.Scanner;

public class PhieuNhapHang implements Ihanghoa {
    private int maPhieu;
    private String ngayNhap;
    private String maDonVi;
    private int tongTien;
    private String maNhanVien;
    
    public void input(Scanner sc) {
    System.out.print("Nhap ma phieu: ");
    maPhieu = sc.nextInt();
    sc.nextLine();
    System.out.print("Nhap ngay nhap: ");
    ngayNhap = sc.nextLine();

    System.out.print("Nhap MA DON VI CUNG CAP (maDonVi): "); 
    maDonVi = sc.nextLine();

    System.out.print("Nhap tong tien: ");
    tongTien = sc.nextInt();
    sc.nextLine();

    System.out.print("Nhap MA NHAN VIEN LAP PHIEU (maNhanVien): "); 
    maNhanVien = sc.nextLine(); 
}
    
    public void output() {
        System.out.println("Ma phieu: " + maPhieu);
        System.out.println("Ngay nhap: " + ngayNhap);
        
        System.out.println("Ma Don Vi Cung Cap: " + maDonVi); 
        System.out.println("Ma Nhan Vien Lap Phieu: " + maNhanVien); 
        
        System.out.println("Tong tien: " + tongTien);
    }
}
