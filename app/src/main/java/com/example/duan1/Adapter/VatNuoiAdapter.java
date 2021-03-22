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

import com.example.duan1.Class.VatNuoi;
import com.example.duan1.R;
import com.example.duan1.ThemKhachHangAct;

import java.util.ArrayList;

public class VatNuoiAdapter extends BaseAdapter {
    Context context;
    ArrayList<VatNuoi> arrVatNuoi;
    String taiKhoan;
    public VatNuoiAdapter(Context context, ArrayList<VatNuoi> arrVatNuoi,String taiKhoan){
        this.context=context;
        this.arrVatNuoi=arrVatNuoi;
        this.taiKhoan=taiKhoan;
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
        convertView= LayoutInflater.from(context).inflate(R.layout.listview_vatnuoi_layout,parent,false);
        ImageView imgVatNuoi=convertView.findViewById(R.id.imgChoLv);
        TextView tvMaVatNuoi=convertView.findViewById(R.id.tvMaVatNuoiLvCho);
        TextView tvTenVatNuoi=convertView.findViewById(R.id.tvTenVatNuoiLvCho);
        ImageView imgGioHang=convertView.findViewById(R.id.imgGioHangLvCho);
        byte[] anh=arrVatNuoi.get(position).getAnh();
        Bitmap bitmap= BitmapFactory.decodeByteArray(anh,0,anh.length);
        imgVatNuoi.setImageBitmap(bitmap);
        tvMaVatNuoi.setText(arrVatNuoi.get(position).getMaVatNuoi());
        tvTenVatNuoi.setText(arrVatNuoi.get(position).getTenVatNuoi());
        imgGioHang.setImageResource(R.drawable.ic_cart_name);
        imgGioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, ThemKhachHangAct.class);
                Bundle bundle=new Bundle();
                bundle.putString("MAVATNUOI",arrVatNuoi.get(position).getMaVatNuoi());
                bundle.putString("TENTK",taiKhoan);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        return convertView;
    }
}
