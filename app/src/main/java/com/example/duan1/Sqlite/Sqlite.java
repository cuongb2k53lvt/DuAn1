package com.example.duan1.Sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Sqlite extends SQLiteOpenHelper {
    Context context;
    public Sqlite(Context context){
        super(context,"sqlvatnuoitest13.sql",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_nhanvien="CREATE TABLE nhanvien "+
                "(tentk varchar(50) primary key not null, "+
                "tennv nvarchar(200), "+
                "mk varchar(50), "+
                "sdt varchar(50), "+
                "quequan nvarchar(250))";
        db.execSQL(create_nhanvien);
        String create_vatnuoi="CREATE TABLE vatnuoi "+
                "(mavatnuoi varchar(50) primary key not null, "+
                "tenvatnuoi nvarchar(250) not null, "+
                "tenloai nvarchar(100) not null, "+
                "gioitinh nvarchar(50), "+
                "tuoi nvarchar(50), "+
                "mota nvarchar(255), "+
                "anh blob not null, "+
                "ngaynhap date not null,"+
                "giatien float not null)";
        db.execSQL(create_vatnuoi);
        String create_khachhang="CREATE TABLE khachhang "+
                "(makh varchar(50) primary key, "+
                "tenkh nvarchar(255) not null, "+
                "sdt varchar(50) not null)";
        db.execSQL(create_khachhang);
        String create_hoadon="CREATE TABLE hoadon "+
                "(mahoadon varchar(50) primary key, "+
                "tentk varchar(50), "+
                "makh varchar(50), "+
                "ngaymua date, "+
                "foreign key(tentk) references nhanvien(tentk),"+
                "foreign key(makh) references khachhang(makh))";
        db.execSQL(create_hoadon);
        String create_hoadonct="CREATE TABLE hoadonct "+
                "(mahdct integer primary key autoincrement, "+
                "mahd varchar(50), "+
                "mavatnuoi varchar(50), "+
                "foreign key(mahd) references hoadon(mahoadon), "+
                "foreign key(mavatnuoi) references vatnuoi(mavatnuoi))";
        db.execSQL(create_hoadonct);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
