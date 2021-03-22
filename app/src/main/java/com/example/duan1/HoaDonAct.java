package com.example.duan1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.duan1.Class.HoaDon;
import com.example.duan1.Sqlite.HoaDonSql;
import com.example.duan1.Sqlite.Sqlite;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class HoaDonAct extends AppCompatActivity {
    EditText edtMaHd,edtTenTk,edtMaKh,edtNgayMua;
    Button btnChonNgay,btnThem,btnHuy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don);
        edtMaHd=findViewById(R.id.edtMaHoaDonHdAct);
        edtTenTk=findViewById(R.id.edtTenTkHdAct);
        edtMaKh=findViewById(R.id.edtMaKhHdAct);
        edtNgayMua=findViewById(R.id.edtNgayMuaHdAct);
        btnChonNgay=findViewById(R.id.btnChonNgayHdAct);
        btnThem=findViewById(R.id.btnThemHdAct);
        btnHuy=findViewById(R.id.btnHuyHdAct);
        String tentk=getIntent().getExtras().getString("TENTK");
        String makh=getIntent().getExtras().getString("MAKH");
        String maVatNuoi=getIntent().getExtras().getString("MAVATNUOI");
        Sqlite sqlite=new Sqlite(HoaDonAct.this);
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HoaDonAct.this,ThemKhachHangAct.class);
                startActivity(intent);
            }
        });
        edtTenTk.setText(tentk);
        edtMaKh.setText(makh);
        btnChonNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar=Calendar.getInstance();
                DatePickerDialog datePickerDialog=new DatePickerDialog(HoaDonAct.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/MM/dd");
                        Calendar cal=new GregorianCalendar(year,month,dayOfMonth);
                        edtNgayMua.setText(simpleDateFormat.format(cal.getTime()));
                    }
                },calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/MM/dd");
                HoaDonSql hoaDonSql=new HoaDonSql(sqlite);
                HoaDon hoaDon=new HoaDon();
                hoaDon.setMaHoaDon(edtMaHd.getText().toString());
                hoaDon.setTenTk(edtTenTk.getText().toString());
                hoaDon.setMaKh(edtMaKh.getText().toString());
                try {
                    hoaDon.setNgayMua(simpleDateFormat.parse(edtNgayMua.getText().toString()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                hoaDonSql.ThemHoaDon(hoaDon);
                Intent intent=new Intent(HoaDonAct.this,ThanhToanAct.class);
                Bundle bundle=new Bundle();
                bundle.putString("MAVATNUOI",maVatNuoi);
                bundle.putString("MAHOADON",hoaDon.getMaHoaDon());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}