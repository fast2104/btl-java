/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaptit1.projjava;

/**
 *
 * @author Admin
 */
public class SanPham {
    private String maSanPham;
    private String tenSanPham;
    private String loaiSanpham;
    private String nguonGoc;
    private String moTa;
    private String donVi;
    private int giaBan;
    private int giaMua;
    private int tonKho;
    private int daBan;

    public SanPham() {}

    public SanPham(String maSanPham, String tenSanPham, String loaiSanpham, String nguonGoc, String moTa, String donVi, int giaBan, int giaMua, int tonKho, int daBan) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.loaiSanpham = loaiSanpham;
        this.nguonGoc = nguonGoc;
        this.moTa = moTa;
        this.donVi = donVi;
        this.giaBan = giaBan;
        this.giaMua = giaMua;
        this.tonKho = tonKho;
        this.daBan = daBan;
    }

    public String getMaSanPham() { return maSanPham; }
    public void setMaSanPham(String maSanPham) { this.maSanPham = maSanPham; }

    public String getTenSanPham() { return tenSanPham; }
    public void setTenSanPham(String tenSanPham) { this.tenSanPham = tenSanPham; }

    public String getLoaiSanpham() { return loaiSanpham; }
    public void setLoaiSanpham(String loaiSanpham) { this.loaiSanpham = loaiSanpham; }

    public String getNguonGoc() { return nguonGoc; }
    public void setNguonGoc(String nguonGoc) { this.nguonGoc = nguonGoc; }

    public String getMoTa() { return moTa; }
    public void setMoTa(String moTa) { this.moTa = moTa; }

    public String getDonVi() { return donVi; }
    public void setDonVi(String donVi) { this.donVi = donVi; }

    public int getGiaBan() { return giaBan; }
    public void setGiaBan(int giaBan) { this.giaBan = giaBan; }

    public int getGiaMua() { return giaMua; }
    public void setGiaMua(int giaMua) { this.giaMua = giaMua; }

    public int getTonKho() { return tonKho; }
    public void setTonKho(int tonKho) { this.tonKho = tonKho; }

    public int getDaBan() { return daBan; }
    public void setDaBan(int daBan) { this.daBan = daBan; }

    @Override
    public String toString() {
        return maSanPham + " - " + tenSanPham;
    }
}