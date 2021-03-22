package com.example.duan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.duan1.Adapter.VatNuoiAdapter;
import com.example.duan1.Class.HoaDonChiTiet;
import com.example.duan1.Class.VatNuoi;
import com.example.duan1.Sqlite.Sqlite;
import com.example.duan1.Sqlite.VatNuoiSql;

import java.text.ParseException;
import java.util.ArrayList;

public class ManHinhChinhAct extends AppCompatActivity {
    EditText edtTimKiem;
    Button btnTimKiem, btnListCho, btnListMeo, btnKho, btnTaiKhoan, btnHoaDon, btnDoanhThu;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_chinh);
        edtTimKiem=findViewById(R.id.edtTimKiemMainAct);
        btnTimKiem=findViewById(R.id.btnTimKiemMainAct);
        btnListCho=findViewById(R.id.btnListChoMainAct);
        btnListMeo=findViewById(R.id.btnListMeoMainAct);
        btnKho=findViewById(R.id.btnKhoMainAct);
        btnTaiKhoan=findViewById(R.id.btnTaiKhoanMainAct);
        btnHoaDon=findViewById(R.id.btnHoaDonMainAct);
        btnDoanhThu=findViewById(R.id.btnDoanhThuMainAct);
        lv=findViewById(R.id.lvManHinhChinh);
        Sqlite sqlite=new Sqlite(ManHinhChinhAct.this);
        VatNuoiSql vatNuoiSql=new VatNuoiSql(sqlite);
        String tenTk=getIntent().getExtras().getString("taikhoan");
        btnKho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ManHinhChinhAct.this,KhoHangAct.class);
                startActivity(intent);
            }
        });
        btnListCho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    ArrayList<VatNuoi> arrVatNuoi=vatNuoiSql.LayAllCho();
                    VatNuoiAdapter listChoAdapter=new VatNuoiAdapter(ManHinhChinhAct.this,arrVatNuoi,tenTk);
                    lv.setAdapter(listChoAdapter);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
        btnListMeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    ArrayList<VatNuoi> arrVatnuoi=vatNuoiSql.LayAllMeo();
                    VatNuoiAdapter listMeoAdapter=new VatNuoiAdapter(ManHinhChinhAct.this,arrVatnuoi,tenTk);
                    lv.setAdapter(listMeoAdapter);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
        btnTimKiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<VatNuoi> arrAllVatNuoi=new ArrayList<>();
                try {
                    arrAllVatNuoi=vatNuoiSql.LayAllVatNuoi();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                ArrayList<VatNuoi> arrSearchVatNuoi=new ArrayList<>();
                for (int i=0;i<arrAllVatNuoi.size();i++){
                    if(edtTimKiem.getText().toString().equalsIgnoreCase(arrAllVatNuoi.get(i).getMaVatNuoi().substring(0,edtTimKiem.getText().toString().length()))){
                        arrSearchVatNuoi.add(arrAllVatNuoi.get(i));
                    }
                }
                if(edtTimKiem.getText().toString().length()!=0){
                    VatNuoiAdapter vatNuoiAdapter=new VatNuoiAdapter(ManHinhChinhAct.this,arrSearchVatNuoi,tenTk);
                    lv.setAdapter(vatNuoiAdapter);
                }else {
                    VatNuoiAdapter vatNuoiAdapter=new VatNuoiAdapter(ManHinhChinhAct.this,arrAllVatNuoi,tenTk);
                    lv.setAdapter(vatNuoiAdapter);
                }
            }
        });
        btnHoaDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ManHinhChinhAct.this, TongHopHoaDonAct.class);
                startActivity(intent);
            }
        });
        btnDoanhThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ManHinhChinhAct.this,DoanhThuAct.class);
                startActivity(intent);
            }
        });
    }
}