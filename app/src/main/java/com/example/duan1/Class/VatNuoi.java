package com.example.duan1.Class;

import java.util.Date;

public class VatNuoi {
    private String maVatNuoi;
    private String tenVatNuoi;
    private String tenLoai;
    private String gioiTinh;
    private String tuoi;
    private String moTa;
    private byte[] anh;
    private Date ngayNhap;
    private Double giaTien;

    public VatNuoi() {
    }

    public VatNuoi(String maVatNuoi, String tenVatNuoi, String tenLoai, String gioiTinh, String tuoi, String moTa, byte[] anh, Date ngayNhap, Double giaTien) {
        this.maVatNuoi = maVatNuoi;
        this.tenVatNuoi = tenVatNuoi;
        this.tenLoai = tenLoai;
        this.gioiTinh = gioiTinh;
        this.tuoi = tuoi;
        this.moTa = moTa;
        this.anh = anh;
        this.ngayNhap = ngayNhap;
        this.giaTien = giaTien;
    }

    public String getMaVatNuoi() {
        return maVatNuoi;
    }

    public void setMaVatNuoi(String maVatNuoi) {
        this.maVatNuoi = maVatNuoi;
    }

    public String getTenVatNuoi() {
        return tenVatNuoi;
    }

    public void setTenVatNuoi(String tenVatNuoi) {
        this.tenVatNuoi = tenVatNuoi;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getTuoi() {
        return tuoi;
    }

    public void setTuoi(String tuoi) {
        this.tuoi = tuoi;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public byte[] getAnh() {
        return anh;
    }

    public void setAnh(byte[] anh) {
        this.anh = anh;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public Double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(Double giaTien) {
        this.giaTien = giaTien;
    }
}
