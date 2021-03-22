package com.example.duan1.Sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.duan1.Class.HoaDon;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class HoaDonSql {
    Sqlite sqlite;
    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
    public HoaDonSql(Sqlite sqlite){
        this.sqlite=sqlite;
    }
    public void ThemHoaDon(HoaDon hoaDon){
        SQLiteDatabase sqLiteDatabase=sqlite.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("mahoadon",hoaDon.getMaHoaDon());
        contentValues.put("tentk",hoaDon.getTenTk());
        contentValues.put("makh",hoaDon.getMaKh());
        contentValues.put("ngaymua",simpleDateFormat.format(hoaDon.getNgayMua()));
        sqLiteDatabase.insert("hoadon",null,contentValues);
    }
    public ArrayList<HoaDon> LayAllHoaDon() throws ParseException {
        SQLiteDatabase sqLiteDatabase=sqlite.getReadableDatabase();
        String select="SELECT * FROM hoadon";
        Cursor cursor=sqLiteDatabase.rawQuery(select,null);
        ArrayList<HoaDon> arrHoaDon=new ArrayList<>();
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            while (cursor.isAfterLast()==false){
                HoaDon hoaDon=new HoaDon();
                hoaDon.setMaHoaDon(cursor.getString(0));
                hoaDon.setTenTk(cursor.getString(1));
                hoaDon.setMaKh(cursor.getString(2));
                hoaDon.setNgayMua(simpleDateFormat.parse(cursor.getString(3)));
                arrHoaDon.add(hoaDon);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return arrHoaDon;
    }
    public double LayTongTien(String mahd){
        SQLiteDatabase sqLiteDatabase=sqlite.getReadableDatabase();
        double tongtien=0;
        String select_tongtien="SELECT SUM(giatien) FROM vatnuoi "+
                "INNER JOIN hoadonct ON vatnuoi.mavatnuoi=hoadonct.mavatnuoi "+
                "INNER JOIN hoadon ON hoadon.mahoadon=hoadonct.mahd WHERE mahd=?";
        Cursor cursor=sqLiteDatabase.rawQuery(select_tongtien,new String[]{mahd});
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            tongtien=cursor.getDouble(0);
        }
        cursor.close();
        return tongtien;
    }
    public double LayDoanhThuThang(){
        SQLiteDatabase sqLiteDatabase=sqlite.getReadableDatabase();
        double doanhthu=0;
        String select_doanhthu="SELECT SUM(giatien) FROM vatnuoi "+
                "INNER JOIN hoadonct ON vatnuoi.mavatnuoi=hoadonct.mavatnuoi "+
                "INNER JOIN hoadon ON hoadon.mahoadon=hoadonct.mahd WHERE strftime('%m',hoadon.ngaymua)=strftime('%m','now')";
        Cursor cursor=sqLiteDatabase.rawQuery(select_doanhthu,null);
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            doanhthu=cursor.getDouble(0);
        }
        cursor.close();
        return doanhthu;
    }
    public double LayGiaTienTheoMaVatNuoi(String maVatNuoi){
        SQLiteDatabase sqLiteDatabase=sqlite.getReadableDatabase();
        double giaTien=0;
        String selectGiatien="SELECT giatien FROM vatnuoi WHERE maVatNuoi=?";
        Cursor cursor=sqLiteDatabase.rawQuery(selectGiatien,new String[]{maVatNuoi});
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            giaTien=cursor.getDouble(0);
        }
        cursor.close();
        return giaTien;
    }
}
