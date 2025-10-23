import java.util.*;
import java.util.Scanner;
public class SanPham implements Ihanghoa {
    private String maSanPham;
    private String tenSanPham;
    private int giaBan;
    private int giaMua;
    private int tonKho;
    private int daBan;
    
    @Override
    public void input(Scanner sc) {
        System.out.print("Nhap ma SP: ");
        maSanPham = sc.nextLine();
        System.out.print("Nhap ten SP: ");
        tenSanPham = sc.nextLine();
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
        System.out.println("Gia ban: " + giaBan);
        System.out.println("Gia mua: " + giaMua);
        System.out.println("Ton kho: " + tonKho);
        System.out.println("Da ban: " + daBan);
    }
}
