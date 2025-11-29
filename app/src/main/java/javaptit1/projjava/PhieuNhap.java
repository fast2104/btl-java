/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaptit1.projjava;

/**
 *
 * @author Admin
 */
public class PhieuNhap {
    private int maPhieu;
    private String ngayNhap;
    private int tongTien;
    private String maNhanVien;
    private String maDonVi;
    private String tenNhaCungCap; 

    public PhieuNhap() {}

    public PhieuNhap(int maPhieu, String ngayNhap, int tongTien, String maNhanVien, String maDonVi) {
        this.maPhieu = maPhieu;
        this.ngayNhap = ngayNhap;
        this.tongTien = tongTien;
        this.maNhanVien = maNhanVien;
        this.maDonVi = maDonVi;
    }

    public int getMaPhieu() { return maPhieu; }
    public void setMaPhieu(int maPhieu) { this.maPhieu = maPhieu; }

    public String getNgayNhap() { return ngayNhap; }
    public void setNgayNhap(String ngayNhap) { this.ngayNhap = ngayNhap; }

    public int getTongTien() { return tongTien; }
    public void setTongTien(int tongTien) { this.tongTien = tongTien; }

    public String getMaNhanVien() { return maNhanVien; }
    public void setMaNhanVien(String maNhanVien) { this.maNhanVien = maNhanVien; }

    public String getMaDonVi() { return maDonVi; }
    public void setMaDonVi(String maDonVi) { this.maDonVi = maDonVi; }

    public String getTenNhaCungCap() { return tenNhaCungCap; }
    public void setTenNhaCungCap(String tenNhaCungCap) { this.tenNhaCungCap = tenNhaCungCap; }
}