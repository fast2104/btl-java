package javaptit1.projjava;

import java.util.Scanner;

public class PhieuNhapHang implements Ihanghoa {
    private int maPhieu;
    private String ngayNhap;
    private String nhaCungCap;
    private int tongTien;
    
    @Override
    public void input(Scanner sc) {
        System.out.print("Nhap ma phieu: ");
        maPhieu = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhap ngay nhap: ");
        ngayNhap = sc.nextLine();
        System.out.print("Nhap nha cung cap: ");
        nhaCungCap = sc.nextLine();
        System.out.print("Nhap tong tien: ");
        tongTien = sc.nextInt();
        sc.nextLine();
    }
    
    @Override
    public void output() {
        System.out.println("Ma phieu: " + maPhieu);
        System.out.println("Ngay nhap: " + ngayNhap);
        System.out.println("Nha cung cap: " + nhaCungCap);
        System.out.println("Tong tien: " + tongTien);
    }
}
