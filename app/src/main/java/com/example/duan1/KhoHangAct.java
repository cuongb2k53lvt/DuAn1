package com.example.duan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.duan1.Adapter.KhoHangAdapter;
import com.example.duan1.Class.VatNuoi;
import com.example.duan1.Sqlite.Sqlite;
import com.example.duan1.Sqlite.VatNuoiSql;

import java.text.ParseException;
import java.util.ArrayList;

public class KhoHangAct extends AppCompatActivity {
    Button btnThem;
    ListView lvKho;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kho_hang);
        btnThem=findViewById(R.id.btnThemKhoAct);
        lvKho=findViewById(R.id.lvKhoAct);
        Sqlite sqlite=new Sqlite(KhoHangAct.this);
        VatNuoiSql vatNuoiSql=new VatNuoiSql(sqlite);
        ArrayList<VatNuoi> arrVatNuoi=new ArrayList<>();
        Toast.makeText(this, ""+arrVatNuoi.size(), Toast.LENGTH_SHORT).show();
        try {
            arrVatNuoi=vatNuoiSql.LayAllVatNuoi();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        KhoHangAdapter khoHangAdapter=new KhoHangAdapter(KhoHangAct.this,arrVatNuoi);
        lvKho.setAdapter(khoHangAdapter);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(KhoHangAct.this,ThemVatNuoiAct.class);
                startActivity(intent);
            }
        });
    }
}