package com.example.duan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.duan1.Class.NhanVien;
import com.example.duan1.Sqlite.NhanVienSql;
import com.example.duan1.Sqlite.Sqlite;

public class ManHinhDangKy extends AppCompatActivity {
    EditText edtTaiKhoan, edtHoTen, edtMatKhau, edtSdt, edtQuequan;
    Button btnDangKy, btnHuy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_dang_ky);
        edtTaiKhoan=findViewById(R.id.edtTaiKhoanDkAct);
        edtHoTen=findViewById(R.id.edtHoTenDkAct);
        edtMatKhau=findViewById(R.id.edtMatKhauDkAct);
        edtSdt=findViewById(R.id.edtSdtDkAct);
        edtQuequan=findViewById(R.id.edtQueQuanDkAct);
        btnDangKy=findViewById(R.id.btnDangKyDkAct);
        btnHuy=findViewById(R.id.btnHuyDkAct);
        Sqlite sqlite=new Sqlite(ManHinhDangKy.this);
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NhanVienSql nhanVienSql=new NhanVienSql(sqlite);
                NhanVien nhanVien=new NhanVien();
                nhanVien.setTenTaiKhoan(edtTaiKhoan.getText().toString());
                nhanVien.setTenNhanVien(edtHoTen.getText().toString());
                nhanVien.setMatKhau(edtMatKhau.getText().toString());
                nhanVien.setSdt(edtSdt.getText().toString());
                nhanVien.setQueQuan(edtQuequan.getText().toString());
                nhanVienSql.addNhanVien(nhanVien);
            }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ManHinhDangKy.this,LoginAct.class);
                startActivity(intent);
            }
        });
    }
}