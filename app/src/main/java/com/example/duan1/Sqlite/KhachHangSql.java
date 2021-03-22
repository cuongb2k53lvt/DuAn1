package com.example.duan1.Sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1.Class.KhachHang;

public class KhachHangSql {
    Sqlite sqlite;
    public KhachHangSql(Sqlite sqlite){
        this.sqlite=sqlite;
    }
    public void ThemKhachHang(KhachHang khachHang){
        SQLiteDatabase sqLiteDatabase=sqlite.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("makh",khachHang.getMaKh());
        contentValues.put("tenkh",khachHang.getTenKh());
        contentValues.put("sdt",khachHang.getSdt());
        sqLiteDatabase.insert("khachhang",null,contentValues);
    }
    public KhachHang LayKhachHangTheoMa(String makh){
        SQLiteDatabase sqLiteDatabase=sqlite.getReadableDatabase();
        String select="SELECT * FROM khachhang WHERE makh=?";
        Cursor cursor=sqLiteDatabase.rawQuery(select,new String[]{makh});
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            KhachHang khachHang=new KhachHang();
            khachHang.setMaKh(cursor.getString(0));
            khachHang.setTenKh(cursor.getString(1));
            khachHang.setSdt(cursor.getString(2));
            cursor.close();
            return khachHang;
        } else {
            cursor.close();
            return null;
        }
    }
}
