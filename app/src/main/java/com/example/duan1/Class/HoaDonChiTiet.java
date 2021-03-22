package com.example.duan1.Class;

public class HoaDonChiTiet {
    private String maHdct;
    private String maHoaDon;
    private String maVatNuoi;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String maHoaDon, String maVatNuoi) {
        this.maHoaDon = maHoaDon;
        this.maVatNuoi = maVatNuoi;
    }

    public HoaDonChiTiet(String maHdct, String maHoaDon, String maVatNuoi) {
        this.maHdct = maHdct;
        this.maHoaDon = maHoaDon;
        this.maVatNuoi = maVatNuoi;
    }

    public String getMaHdct() {
        return maHdct;
    }

    public void setMaHdct(String maHdct) {
        this.maHdct = maHdct;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaVatNuoi() {
        return maVatNuoi;
    }

    public void setMaVatNuoi(String maVatNuoi) {
        this.maVatNuoi = maVatNuoi;
    }
}
