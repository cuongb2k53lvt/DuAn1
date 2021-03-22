package com.example.duan1.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.duan1.Class.HoaDonChiTiet;
import com.example.duan1.Class.VatNuoi;
import com.example.duan1.R;
import com.example.duan1.Sqlite.HoaDonCtSql;
import com.example.duan1.Sqlite.Sqlite;
import com.example.duan1.Sqlite.VatNuoiSql;
import com.example.duan1.ThemKhachHangAct;

import java.text.ParseException;
import java.util.ArrayList;

public class ThanhToanAdapter extends BaseAdapter {
    Context context;
    ArrayList<HoaDonChiTiet> arrHdct;
    public ThanhToanAdapter(Context context, ArrayList<HoaDonChiTiet> arrHdct){
        this.context=context;
        this.arrHdct=arrHdct;
    }
    @Override
    public int getCount() {
        return arrHdct.size();
    }

    @Override
    public Object getItem(int position) {
        return arrHdct.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(R.layout.listview_vatnuoi_layout,parent,false);
        ImageView imgVatNuoi=convertView.findViewById(R.id.imgChoLv);
        TextView tvMaVatNuoi=convertView.findViewById(R.id.tvMaVatNuoiLvCho);
        TextView tvTenVatNuoi=convertView.findViewById(R.id.tvTenVatNuoiLvCho);
        ImageView imgGioHang=convertView.findViewById(R.id.imgGioHangLvCho);
        Sqlite sqlite=new Sqlite(context);
        VatNuoiSql vatNuoiSql=new VatNuoiSql(sqlite);
        VatNuoi vatNuoi=new VatNuoi();
        try {
            vatNuoi=vatNuoiSql.LayVatNuoiTheoMa(arrHdct.get(position).getMaVatNuoi());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        byte[] anh=vatNuoi.getAnh();
        Bitmap bitmap= BitmapFactory.decodeByteArray(anh,0,anh.length);
        imgVatNuoi.setImageBitmap(bitmap);

        tvMaVatNuoi.setText(vatNuoi.getMaVatNuoi());
        tvTenVatNuoi.setText(vatNuoi.getTenVatNuoi());
        imgGioHang.setImageResource(R.drawable.ic_cart_name);
        imgGioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        return convertView;
    }
}
