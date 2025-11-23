package javaptit1.projjava;
import java.util.Scanner;
import java.io.*;

public class DonViCungCap implements Ihanghoa {
    private String maDonVi;
    private String tenDonVi;
    private String matHang;
    private String diachi;
    
    public void input(Scanner sc) {
        System.out.print("Nhap ma don vi: ");
        maDonVi = sc.nextLine();
        System.out.print("Nhap ten don vi: ");
        tenDonVi = sc.nextLine();
        System.out.print("Nhap mat hang: ");
        matHang = sc.nextLine();
        System.out.print("nhap dia chi: ");
        diachi = sc.nextLine();
    }
    
    public void output() {
        System.out.println("Ma don vi: " + maDonVi);
        System.out.println("Ten don vi: " + tenDonVi);
        System.out.println("Mat hang: " + matHang);
        System.out.println("dia chi: " + diachi);
    }
}
