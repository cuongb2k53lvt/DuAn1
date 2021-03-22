package com.example.duan1.Class;

public class NhanVien {
    private String TenTaiKhoan;
    private String TenNhanVien;
    private String MatKhau;
    private String sdt;
    private String QueQuan;

    public NhanVien(String tenTaiKhoan, String tenNhanVien, String matKhau, String sdt, String queQuan) {
        TenTaiKhoan = tenTaiKhoan;
        TenNhanVien = tenNhanVien;
        MatKhau = matKhau;
        this.sdt = sdt;
        QueQuan = queQuan;
    }

    public NhanVien() {
    }

    public String getTenTaiKhoan() {
        return TenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        TenTaiKhoan = tenTaiKhoan;
    }

    public String getTenNhanVien() {
        return TenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        TenNhanVien = tenNhanVien;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String matKhau) {
        MatKhau = matKhau;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getQueQuan() {
        return QueQuan;
    }

    public void setQueQuan(String queQuan) {
        QueQuan = queQuan;
    }
}
