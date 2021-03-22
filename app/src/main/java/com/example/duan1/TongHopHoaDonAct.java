package com.example.duan1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan1.Adapter.HoaDonAdapter;
import com.example.duan1.Adapter.HoaDonCtAdapter;
import com.example.duan1.Class.HoaDon;
import com.example.duan1.Sqlite.HoaDonCtSql;
import com.example.duan1.Sqlite.HoaDonSql;
import com.example.duan1.Sqlite.Sqlite;

import java.text.ParseException;
import java.util.ArrayList;

public class TongHopHoaDonAct extends AppCompatActivity {
    ListView lvHoaDon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tong_hop_hoa_don);
        lvHoaDon=findViewById(R.id.lvHoaDonTongHopAct);
        Sqlite sqlite=new Sqlite(TongHopHoaDonAct.this);
        HoaDonSql hoaDonSql=new HoaDonSql(sqlite);
        ArrayList<HoaDon> arrHoaDon=new ArrayList<>();
        try {
            arrHoaDon=hoaDonSql.LayAllHoaDon();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        HoaDonAdapter hoaDonAdapter=new HoaDonAdapter(TongHopHoaDonAct.this,arrHoaDon);
        lvHoaDon.setAdapter(hoaDonAdapter);
        ArrayList<HoaDon> finalArrHoaDon = arrHoaDon;
        lvHoaDon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder=new AlertDialog.Builder(TongHopHoaDonAct.this);
                View view1= LayoutInflater.from(TongHopHoaDonAct.this).inflate(R.layout.dialog_hoadonct_layout,null);
                builder.setView(view1);
                TextView tvMaHd=view1.findViewById(R.id.tvMaHdDialogHdct);
                TextView tvTongTien=view1.findViewById(R.id.tvTongTienDialogHdct);
                ListView lvHdct=view1.findViewById(R.id.lvHdctDialogHdct);
                TextView tvTaiKhoan=view1.findViewById(R.id.tvTaiKhoanDialogHdct);
                tvMaHd.setText(finalArrHoaDon.get(position).getMaHoaDon());
                tvTongTien.setText("Tổng tiền: "+hoaDonSql.LayTongTien(finalArrHoaDon.get(position).getMaHoaDon()));
                tvTaiKhoan.setText(finalArrHoaDon.get(position).getTenTk());
                HoaDonCtSql hoaDonCtSql=new HoaDonCtSql(sqlite);
                Toast.makeText(TongHopHoaDonAct.this, ""+hoaDonCtSql.LayAllHdct().size(), Toast.LENGTH_SHORT).show();
                HoaDonCtAdapter hoaDonCtAdapter=new HoaDonCtAdapter(TongHopHoaDonAct.this,hoaDonCtSql.LayAllHdct());
                lvHdct.setAdapter(hoaDonCtAdapter);
//                builder.setNegativeButton("Đóng", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        builder.create().cancel();
//                    }
//                });
                builder.create().show();
            }
        });
    }
}