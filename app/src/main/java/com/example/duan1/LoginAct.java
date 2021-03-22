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

import java.net.Inet4Address;
import java.util.ArrayList;

public class LoginAct extends AppCompatActivity {
    EditText edtTaiKhoan, edtMatKhau;
    Button btnDangNhap, btnDangKi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtTaiKhoan=findViewById(R.id.edtTaiKhoan);
        edtMatKhau=findViewById(R.id.edtMatKhau);
        btnDangNhap=findViewById(R.id.btnDangNhap);
        btnDangKi=findViewById(R.id.btnDangKi);
        Sqlite sqlite=new Sqlite(LoginAct.this);
        NhanVienSql nhanVienSql=new NhanVienSql(sqlite);
        ArrayList<NhanVien> arrNhanVien=nhanVienSql.getAllNhanVien();
        int k=0;
        for(int i=0;i<arrNhanVien.size();i++){
            if(arrNhanVien.get(i).getTenTaiKhoan().equalsIgnoreCase("admin")){
                k++;
            }
        }
        if(k==0){
            NhanVien nhanVien=new NhanVien("admin","admin","admin","000","");
            nhanVienSql.addNhanVien(nhanVien);
        }
        btnDangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginAct.this,ManHinhDangKy.class);
                startActivity(intent);
            }
        });
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<NhanVien> arrNhanVien=nhanVienSql.getAllNhanVien();
                for(int i=0;i<arrNhanVien.size();i++){
                    if(edtTaiKhoan.getText().toString().equalsIgnoreCase(arrNhanVien.get(i).getTenTaiKhoan())&&edtMatKhau.getText().toString().equalsIgnoreCase(arrNhanVien.get(i).getMatKhau())){
                        Intent intent=new Intent(LoginAct.this,ManHinhChinhAct.class);
                        Bundle bundle=new Bundle();
                        bundle.putString("taikhoan",edtTaiKhoan.getText().toString());
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                }
            }
        });
    }
}