import java.util.Scanner;
import java.io.*;

public class DonViCungCap implements Ihanghoa {
    private String maDonVi;
    private String tenDonVi;
    private String matHang;
    private String diachi;
    
    @Override
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
    
    @Override
    public void output() {
        System.out.println("Ma don vi: " + maDonVi);
        System.out.println("Ten don vi: " + tenDonVi);
        System.out.println("Mat hang: " + matHang);
        System.out.println("dia chi: " + diachi);
    }
    
    public String toFileString() {
        return maDonVi + ";" + tenDonVi + ";" + matHang + ";" + diachi;
    }

    public void ghiFileAppend(String tenFile) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(tenFile, true))) {
            pw.println(toFileString());
            System.out.println("Da ghi don vi cung cap vao file: " + tenFile);
        } catch (IOException e) {
            System.out.println("Loi ghi file DVCC: " + e.getMessage());
        }
    }    
}
