package com.example.duan1.Sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1.Class.HoaDon;
import com.example.duan1.Class.HoaDonChiTiet;

import java.util.ArrayList;

public class HoaDonCtSql {
    Sqlite sqlite;
    public HoaDonCtSql(Sqlite sqlite){
        this.sqlite=sqlite;
    }
    public void ThemHdct(HoaDonChiTiet hdct){
        SQLiteDatabase sqLiteDatabase=sqlite.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("mahd",hdct.getMaHoaDon());
        contentValues.put("mavatnuoi",hdct.getMaVatNuoi());
        sqLiteDatabase.insert("hoadonct",null,contentValues);
    }
    public ArrayList<HoaDonChiTiet> LayAllHdct(){
        SQLiteDatabase sqLiteDatabase=sqlite.getReadableDatabase();
        ArrayList<HoaDonChiTiet> arrHdct=new ArrayList<>();
        String select="SELECT * FROM hoadonct";
        Cursor cursor=sqLiteDatabase.rawQuery(select,null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            while (cursor.isAfterLast()==false){
                HoaDonChiTiet hdct=new HoaDonChiTiet();
                hdct.setMaHdct(Integer.toString(cursor.getInt(0)));
                hdct.setMaHoaDon(cursor.getString(1));
                hdct.setMaVatNuoi(cursor.getString(2));
                arrHdct.add(hdct);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return arrHdct;
    }

    public void XoaHdct(String maHdct){
        SQLiteDatabase sqLiteDatabase=sqlite.getReadableDatabase();
        sqLiteDatabase.delete("hoadonct","mahdct=?",new String[]{maHdct});
    }
    public ArrayList<HoaDonChiTiet> LayAllHdctTheoMaHd(String maHd){
        SQLiteDatabase sqLiteDatabase=sqlite.getReadableDatabase();
        String select="SELECT * FROM hoadonct WHERE mahd=?";
        Cursor cursor=sqLiteDatabase.rawQuery(select,new String[]{maHd});
        ArrayList<HoaDonChiTiet> arrHdct=new ArrayList<>();
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            while (cursor.isAfterLast()==false);
            HoaDonChiTiet hoaDonChiTiet=new HoaDonChiTiet();
            hoaDonChiTiet.setMaHdct("");
            hoaDonChiTiet.setMaHoaDon(cursor.getString(1));
            hoaDonChiTiet.setMaVatNuoi(cursor.getString(2));
            arrHdct.add(hoaDonChiTiet);
            cursor.moveToNext();
        }
        cursor.close();
        return arrHdct;
    }
}
