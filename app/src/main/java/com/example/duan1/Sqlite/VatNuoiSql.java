package com.example.duan1.Sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import com.example.duan1.Class.VatNuoi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class VatNuoiSql {
    Sqlite sqlite;
    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
    public VatNuoiSql(Sqlite sqlite){
        this.sqlite=sqlite;
    }
    public int ThemVatNuoi(String maVatNuoi,String tenVatNuoi,String tenLoai,String gioiTinh,String tuoi,String moTa,byte[] anh,Date ngayNhap,Double giaTien){
        SQLiteDatabase sqLiteDatabase=sqlite.getWritableDatabase();
        String insert="INSERT INTO vatnuoi VALUES(?,?,?,?,?,?,?,?,?)";
        SQLiteStatement sqLiteStatement=sqLiteDatabase.compileStatement(insert);
        sqLiteStatement.clearBindings();
        sqLiteStatement.bindString(1,maVatNuoi);
        sqLiteStatement.bindString(2,tenVatNuoi);
        sqLiteStatement.bindString(3,tenLoai);
        sqLiteStatement.bindString(4,gioiTinh);
        sqLiteStatement.bindString(5,tuoi);
        sqLiteStatement.bindString(6,moTa);
        sqLiteStatement.bindBlob(7,anh);
        sqLiteStatement.bindString(8,simpleDateFormat.format(ngayNhap));
        sqLiteStatement.bindDouble(9,giaTien);
        sqLiteStatement.executeInsert();
        return 1;
    }
    public ArrayList<VatNuoi> LayAllVatNuoi() throws ParseException {
        SQLiteDatabase sqLiteDatabase=sqlite.getReadableDatabase();
        String select="SELECT * FROM vatnuoi";
        Cursor cursor=sqLiteDatabase.rawQuery(select,null);
        ArrayList<VatNuoi> arrVatNuoi=new ArrayList<>();
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            while (cursor.isAfterLast()==false){
                VatNuoi vatNuoi=new VatNuoi();
                vatNuoi.setMaVatNuoi(cursor.getString(0));
                vatNuoi.setTenVatNuoi(cursor.getString(1));
                vatNuoi.setTenLoai(cursor.getString(2));
                vatNuoi.setGioiTinh(cursor.getString(3));
                vatNuoi.setTuoi(cursor.getString(4));
                vatNuoi.setMoTa(cursor.getString(5));
                vatNuoi.setAnh(cursor.getBlob(6));
                vatNuoi.setNgayNhap(simpleDateFormat.parse(cursor.getString(7)));
                vatNuoi.setGiaTien(cursor.getDouble(8));
                arrVatNuoi.add(vatNuoi);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return arrVatNuoi;
    }
    public ArrayList<VatNuoi> LayAllCho() throws ParseException {
        SQLiteDatabase sqLiteDatabase=sqlite.getReadableDatabase();
        String select="SELECT * FROM vatnuoi WHERE tenloai=?";
        Cursor cursor=sqLiteDatabase.rawQuery(select,new String[]{"Chó"});
        ArrayList<VatNuoi> arrVatNuoi=new ArrayList<>();
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            while (cursor.isAfterLast()==false){
                VatNuoi vatNuoi=new VatNuoi();
                vatNuoi.setMaVatNuoi(cursor.getString(0));
                vatNuoi.setTenVatNuoi(cursor.getString(1));
                vatNuoi.setTenLoai(cursor.getString(2));
                vatNuoi.setGioiTinh(cursor.getString(3));
                vatNuoi.setTuoi(cursor.getString(4));
                vatNuoi.setMoTa(cursor.getString(5));
                vatNuoi.setAnh(cursor.getBlob(6));
                vatNuoi.setNgayNhap(simpleDateFormat.parse(cursor.getString(7)));
                vatNuoi.setGiaTien(cursor.getDouble(8));
                arrVatNuoi.add(vatNuoi);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return arrVatNuoi;
    }
    public ArrayList<VatNuoi> LayAllMeo() throws ParseException {
        SQLiteDatabase sqLiteDatabase=sqlite.getReadableDatabase();
        String select="SELECT * FROM vatnuoi WHERE tenloai=?";
        Cursor cursor=sqLiteDatabase.rawQuery(select,new String[]{"Mèo"});
        ArrayList<VatNuoi> arrVatNuoi=new ArrayList<>();
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            while (cursor.isAfterLast()==false){
                VatNuoi vatNuoi=new VatNuoi();
                vatNuoi.setMaVatNuoi(cursor.getString(0));
                vatNuoi.setTenVatNuoi(cursor.getString(1));
                vatNuoi.setTenLoai(cursor.getString(2));
                vatNuoi.setGioiTinh(cursor.getString(3));
                vatNuoi.setTuoi(cursor.getString(4));
                vatNuoi.setMoTa(cursor.getString(5));
                vatNuoi.setAnh(cursor.getBlob(6));
                vatNuoi.setNgayNhap(simpleDateFormat.parse(cursor.getString(7)));
                vatNuoi.setGiaTien(cursor.getDouble(8));
                arrVatNuoi.add(vatNuoi);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return arrVatNuoi;
    }
    public VatNuoi LayVatNuoiTheoMa(String maVatNuoi) throws ParseException {
        SQLiteDatabase sqLiteDatabase=sqlite.getReadableDatabase();
        String select="SELECT * FROM vatnuoi WHERE mavatnuoi=?";
        Cursor cursor=sqLiteDatabase.rawQuery(select,new String[]{maVatNuoi});
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            VatNuoi vatNuoi=new VatNuoi();
            vatNuoi.setMaVatNuoi(cursor.getString(0));
            vatNuoi.setTenVatNuoi(cursor.getString(1));
            vatNuoi.setTenLoai(cursor.getString(2));
            vatNuoi.setGioiTinh(cursor.getString(3));
            vatNuoi.setTuoi(cursor.getString(4));
            vatNuoi.setMoTa(cursor.getString(5));
            vatNuoi.setAnh(cursor.getBlob(6));
            vatNuoi.setNgayNhap(simpleDateFormat.parse(cursor.getString(7)));
            vatNuoi.setGiaTien(cursor.getDouble(8));
            cursor.close();
            return vatNuoi;
        } else {
            cursor.close();
            return null;
        }
    }
}
