package com.example.duan1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.duan1.Class.HoaDonChiTiet;
import com.example.duan1.R;
import com.example.duan1.Sqlite.HoaDonSql;
import com.example.duan1.Sqlite.Sqlite;

import java.util.ArrayList;

public class HoaDonCtAdapter extends BaseAdapter {
    Context context;
    ArrayList<HoaDonChiTiet> arrHdct;
    public HoaDonCtAdapter(Context context, ArrayList<HoaDonChiTiet> arrHdct){
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
        convertView= LayoutInflater.from(context).inflate(R.layout.listview_hdct_layout,parent,false);
        TextView tvMaVatNuoi=convertView.findViewById(R.id.tvMaVatNuoiHdct);
        TextView tvGiaTien=convertView.findViewById(R.id.tvMaVatNuoiHdct);
        tvMaVatNuoi.setText(arrHdct.get(position).getMaVatNuoi());
        Sqlite sqlite=new Sqlite(context);
        HoaDonSql hoaDonSql=new HoaDonSql(sqlite);
        tvGiaTien.setText("Giá Tiền: "+hoaDonSql.LayGiaTienTheoMaVatNuoi(arrHdct.get(position).getMaVatNuoi()));
        return convertView;
    }
}
