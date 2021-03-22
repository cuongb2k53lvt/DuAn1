package com.example.duan1.Class;

import java.util.Date;

public class HoaDon {
    private String maHoaDon;
    private String tenTk;
    private String maKh;
    private Date ngayMua;

    public HoaDon() {
    }

    public HoaDon(String maHoaDon, String tenTk, String maKh, Date ngayMua) {
        this.maHoaDon = maHoaDon;
        this.tenTk = tenTk;
        this.maKh = maKh;
        this.ngayMua = ngayMua;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getTenTk() {
        return tenTk;
    }

    public void setTenTk(String tenTk) {
        this.tenTk = tenTk;
    }

    public String getMaKh() {
        return maKh;
    }

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }

    public Date getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
    }
}
