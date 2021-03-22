package com.example.duan1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.duan1.Adapter.ThanhToanAdapter;
import com.example.duan1.Class.HoaDonChiTiet;
import com.example.duan1.Class.VatNuoi;
import com.example.duan1.Sqlite.HoaDonCtSql;
import com.example.duan1.Sqlite.Sqlite;
import com.example.duan1.Sqlite.VatNuoiSql;

import java.text.ParseException;
import java.util.ArrayList;

public class ThanhToanAct extends AppCompatActivity {
    Button btnThem, btnThanhToan;
    ListView lvVatNuoi;
    TextView tvTongTien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_toan);
        String maVatNuoi=getIntent().getExtras().getString("MAVATNUOI");
        String maHoaDon=getIntent().getExtras().getString("MAHOADON");
        btnThem=findViewById(R.id.btnThemThanhToanAct);
        btnThanhToan=findViewById(R.id.btnThanhToan);
        lvVatNuoi=findViewById(R.id.lvVatNuoiThanhToanAct);
        tvTongTien=findViewById(R.id.tvTongTien);
        Sqlite sqlite=new Sqlite(ThanhToanAct.this);
        HoaDonChiTiet hdct=new HoaDonChiTiet("",maHoaDon,maVatNuoi);
        HoaDonCtSql hoaDonCtSql=new HoaDonCtSql(sqlite);
        hoaDonCtSql.ThemHdct(hdct);
        ArrayList<HoaDonChiTiet> arrHdct=new ArrayList<>();
        arrHdct.add(hdct);
        ThanhToanAdapter thanhToanAdapter=new ThanhToanAdapter(ThanhToanAct.this,arrHdct);
        lvVatNuoi.setAdapter(thanhToanAdapter);
        btnThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VatNuoiSql vatNuoiSql=new VatNuoiSql(sqlite);
                double tongtien=0;
                for (int i=0;i<arrHdct.size();i++){
                    try {
                        VatNuoi vatNuoi=vatNuoiSql.LayVatNuoiTheoMa(arrHdct.get(i).getMaVatNuoi());
                        tongtien+=vatNuoi.getGiaTien();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                tvTongTien.setText("Tổng tiền:"+tongtien+"vnđ");
            }
        });
    }
}