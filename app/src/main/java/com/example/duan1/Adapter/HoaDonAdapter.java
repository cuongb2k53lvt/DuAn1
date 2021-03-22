package com.example.duan1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.duan1.Class.HoaDon;
import com.example.duan1.R;
import com.example.duan1.Sqlite.HoaDonSql;
import com.example.duan1.Sqlite.Sqlite;

import java.util.ArrayList;

public class HoaDonAdapter extends BaseAdapter {
    Context context;
    ArrayList<HoaDon> arrHoaDon;
    public HoaDonAdapter(Context context, ArrayList<HoaDon> arrHoaDon){
        this.context=context;
        this.arrHoaDon=arrHoaDon;
    }
    @Override
    public int getCount() {
        return arrHoaDon.size();
    }

    @Override
    public Object getItem(int position) {
        return arrHoaDon.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(R.layout.hoadon_tonghop_layout,parent,false);
        TextView tvMaHoaDon=convertView.findViewById(R.id.tvMaHdTongHopLv);
        TextView tvTaiKhoan=convertView.findViewById(R.id.tvTaiKhoanTongHopLv);
        TextView tvTongTien=convertView.findViewById(R.id.tvTongTienTongHopLv);
        ImageView imgClose=convertView.findViewById(R.id.imgCloseTongHopLv);
        Sqlite sqlite=new Sqlite(context);
        HoaDonSql hoaDonSql=new HoaDonSql(sqlite);
        double tongtien=hoaDonSql.LayTongTien(arrHoaDon.get(position).getMaHoaDon());
        tvMaHoaDon.setText(arrHoaDon.get(position).getMaHoaDon());
        tvTaiKhoan.setText(arrHoaDon.get(position).getTenTk());
        tvTongTien.setText("Tổng tiền:"+tongtien+"vnđ");
        return convertView;
    }
}
