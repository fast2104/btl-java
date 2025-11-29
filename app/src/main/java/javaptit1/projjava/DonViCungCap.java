/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaptit1.projjava;

/**
 *
 * @author Admin
 */
public class DonViCungCap {
    private String maDonVi;
    private String tenDonVi;
    private String matHang;
    private String diaChi;

    public DonViCungCap() {}

    public String getMaDonVi() { return maDonVi; }
    public void setMaDonVi(String maDonVi) { this.maDonVi = maDonVi; }

    public String getTenDonVi() { return tenDonVi; }
    public void setTenDonVi(String tenDonVi) { this.tenDonVi = tenDonVi; }

    public String getMatHang() { return matHang; }
    public void setMatHang(String matHang) { this.matHang = matHang; }

    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }

    @Override
    public String toString() {
        return tenDonVi;
    }
}