package com.example.duan1.Sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1.Class.NhanVien;

import java.util.ArrayList;

public class NhanVienSql {
    Sqlite sql;
    public NhanVienSql(Sqlite sqlite){
        this.sql=sqlite;
    }
    public void addNhanVien(NhanVien nhanVien){
        SQLiteDatabase sqLiteDatabase=sql.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("tentk",nhanVien.getTenTaiKhoan());
        contentValues.put("tennv",nhanVien.getTenNhanVien());
        contentValues.put("mk",nhanVien.getMatKhau());
        contentValues.put("sdt",nhanVien.getSdt());
        contentValues.put("quequan",nhanVien.getQueQuan());
        sqLiteDatabase.insert("nhanvien",null,contentValues);
    }
    public ArrayList<NhanVien> getAllNhanVien(){
        SQLiteDatabase sqLiteDatabase=sql.getReadableDatabase();
        String select="SELECT * FROM nhanvien ";
        Cursor cursor=sqLiteDatabase.rawQuery(select,null);
        ArrayList<NhanVien> arrNhanVien=new ArrayList<>();
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            while (cursor.isAfterLast()==false){
                NhanVien nhanVien=new NhanVien();
                nhanVien.setTenTaiKhoan(cursor.getString(0));
                nhanVien.setTenNhanVien(cursor.getString(1));
                nhanVien.setMatKhau(cursor.getString(2));
                nhanVien.setSdt(cursor.getString(3));
                nhanVien.setQueQuan(cursor.getString(4));
                arrNhanVien.add(nhanVien);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return arrNhanVien;
    }
}
