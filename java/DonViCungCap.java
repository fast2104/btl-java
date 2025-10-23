import java.util.Scanner;
import java.util.*;

public class DonViCungCap implements Ihanghoa {
    private String maDonVi;
    private String tenDonVi;
    private String matHang;
    
    @Override
    public void input(Scanner sc) {
        System.out.print("Nhap ma don vi: ");
        maDonVi = sc.nextLine();
        System.out.print("Nhap ten don vi: ");
        tenDonVi = sc.nextLine();
        System.out.print("Nhap mat hang: ");
        matHang = sc.nextLine();
    }
    
    @Override
    public void output() {
        System.out.println("Ma don vi: " + maDonVi);
        System.out.println("Ten don vi: " + tenDonVi);
        System.out.println("Mat hang: " + matHang);
    }
}
