import java.util.*;
import java.util.Scanner;
public class SanPham implements Ihanghoa {
    private String maSanPham;
    private String tenSanPham;
    private String loaiSanpham;
    private String nguongoc;
    private String moTa;
    private String donvi;
    private int giaBan;
    private int giaMua;
    private int tonKho;
    private int daBan;
    
    @Override
    public void input(Scanner sc) {
        System.out.print("Nhap ma SP: ");
        maSanPham = sc.nextLine();
        sc.next();
        System.out.print("Nhap ten SP: ");
        tenSanPham = sc.nextLine();
        sc.next();
        System.out.print("nhap loai san pham: ");
        loaiSanpham = sc.nextLine();
        sc.next();
        System.out.print("nhap nguon goc: ");
        nguongoc = sc.nextLine();
        sc.next();
        System.out.print("nhap mo ta: ");
        moTa = sc.nextLine();
        sc.next();
        System.out.print("nhap don vi: ");
        donvi = sc.nextLine();
        sc.next();
        System.out.print("Nhap gia ban: ");
        giaBan = sc.nextInt();
        System.out.print("Nhap gia mua: ");
        giaMua = sc.nextInt();
        System.out.print("Nhap ton kho: ");
        tonKho = sc.nextInt();
        System.out.print("Nhap da ban: ");
        daBan = sc.nextInt();
        sc.nextLine();
    }
    
    @Override
    public void output() {
        System.out.println("Ma SP: " + maSanPham);
        System.out.println("Ten SP: " + tenSanPham);
        System.out.println("loai SP: " + loaiSanpham);
        System.out.println("nguon goc: " + nguongoc);
        System.out.println("mo ta: " + moTa);
        System.out.println("don vi: " + donvi);
        System.out.println("Gia ban: " + giaBan);
        System.out.println("Gia mua: " + giaMua);
        System.out.println("Ton kho: " + tonKho);
        System.out.println("Da ban: " + daBan);
    }
}
