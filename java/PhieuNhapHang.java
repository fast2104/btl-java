import java.io.*;
import java.util.Scanner;

public class PhieuNhapHang implements Ihanghoa {
    private int maPhieu;
    private String ngayNhap;
    private String nhaCungCap;
    private int tongTien;
    private NhanVien NguoiLapPhieu;
    
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
        System.out.println("nguoi lap phieu");
        NguoiLapPhieu = new NhanVien();
        NguoiLapPhieu.input(sc);
    }
    
    @Override
    public void output() {
        System.out.println("Ma phieu: " + maPhieu);
        System.out.println("Ngay nhap: " + ngayNhap);
        System.out.println("Nha cung cap: " + nhaCungCap);
        System.out.println("Tong tien: " + tongTien);
        System.out.println("Nguoi lap phieu: ");
        NguoiLapPhieu.output();
    }
    
    public String toFileString() {
        return maPhieu + ";" + ngayNhap + ";" + nhaCungCap + ";" + tongTien;
    }

    public void ghiFileAppend(String tenFile) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(tenFile, true))) {
            pw.println(toFileString());
            System.out.println("Da ghi phieu nhap vao file: " + tenFile);
        } catch (IOException e) {
            System.out.println("Loi ghi file phieu nhap: " + e.getMessage());
        }
    }
}
