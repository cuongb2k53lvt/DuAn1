package com.example.duan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.duan1.Class.KhachHang;
import com.example.duan1.Sqlite.KhachHangSql;
import com.example.duan1.Sqlite.Sqlite;

public class ThemKhachHangAct extends AppCompatActivity {
    EditText edtMakh, edtTenkh, edtSdt;
    Button btnAddKh, btnHuy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_khach_hang);
        edtMakh=findViewById(R.id.edtMaKhThemKhAct);
        edtTenkh=findViewById(R.id.edtTenKhThemKhAct);
        edtSdt=findViewById(R.id.edtSdtThemKhAct);
        btnAddKh=findViewById(R.id.btnThemKh);
        btnHuy=findViewById(R.id.btnHuyThemKhAct);
        String maVatNuoi=getIntent().getExtras().getString("MAVATNUOI");
        String taiKhoan=getIntent().getExtras().getString("TENTK");
        Sqlite sqlite=new Sqlite(ThemKhachHangAct.this);
        btnAddKh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KhachHangSql khachHangSql=new KhachHangSql(sqlite);
                KhachHang khachHang=new KhachHang();
                khachHang.setMaKh(edtMakh.getText().toString());
                khachHang.setTenKh(edtTenkh.getText().toString());
                khachHang.setSdt(edtSdt.getText().toString());
                khachHangSql.ThemKhachHang(khachHang);
                Intent intent=new Intent(ThemKhachHangAct.this,HoaDonAct.class);
                Bundle bundle=new Bundle();
                bundle.putString("MAVATNUOI",maVatNuoi);
                bundle.putString("MAKH",khachHang.getMaKh());
                bundle.putString("TENTK",taiKhoan);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ThemKhachHangAct.this,ManHinhChinhAct.class);
                startActivity(intent);
            }
        });
    }
}