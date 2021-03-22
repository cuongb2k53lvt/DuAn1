package com.example.duan1.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.duan1.Class.VatNuoi;
import com.example.duan1.KhoHangAct;
import com.example.duan1.R;

import java.util.ArrayList;

public class KhoHangAdapter extends BaseAdapter {
    Context context;
    ArrayList<VatNuoi> arrVatNuoi;
    public KhoHangAdapter(Context context,ArrayList<VatNuoi> arrVatNuoi){
        this.context=context;
        this.arrVatNuoi=arrVatNuoi;
    }
    @Override
    public int getCount() {
        return arrVatNuoi.size();
    }

    @Override
    public Object getItem(int position) {
        return arrVatNuoi.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(R.layout.listview_khohang_layout,parent,false);
        ImageView img=convertView.findViewById(R.id.imgLvKho);
        TextView tvMaVatNuoi=convertView.findViewById(R.id.tvMaVatNuoiLvKho);
        TextView tvTenVatNuoi=convertView.findViewById(R.id.tvTenVatNuoiLvKho);
        TextView tvLoai=convertView.findViewById(R.id.tvLoaiLvKho);
        byte[] anh=arrVatNuoi.get(position).getAnh();
        Bitmap bitmap= BitmapFactory.decodeByteArray(anh,0,anh.length);
        img.setImageBitmap(bitmap);
        tvMaVatNuoi.setText(arrVatNuoi.get(position).getMaVatNuoi());
        tvLoai.setText(arrVatNuoi.get(position).getTenLoai());
        tvTenVatNuoi.setText(arrVatNuoi.get(position).getTenVatNuoi());
        return convertView;
    }
}
