package com.example.duan1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.duan1.Sqlite.HoaDonSql;
import com.example.duan1.Sqlite.Sqlite;

public class DoanhThuAct extends AppCompatActivity {
    TextView tvDoanhThu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doanh_thu);
        tvDoanhThu=findViewById(R.id.tvDoanhThuThang);
        Sqlite sqlite=new Sqlite(DoanhThuAct.this);
        HoaDonSql hoaDonSql=new HoaDonSql(sqlite);
        double doanhthu=hoaDonSql.LayDoanhThuThang();
        tvDoanhThu.setText("Doanh thu: "+doanhthu+" vnd");
    }
}