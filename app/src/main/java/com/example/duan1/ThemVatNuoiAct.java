package com.example.duan1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.duan1.Class.VatNuoi;
import com.example.duan1.Sqlite.Sqlite;
import com.example.duan1.Sqlite.VatNuoiSql;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ThemVatNuoiAct extends AppCompatActivity {
    EditText edtMaVatNuoi, edtTenVatNuoi, edtLoai, edtGioiTinh, edtTuoi, edtMota, edtNgayNhap, edtGiatien;
    ImageView img;
    Button btnAnh, btnAdd, btnHuy,btnChonNgay;
    int requestCodeFolder=111;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_vat_nuoi);
        edtMaVatNuoi=findViewById(R.id.edtMaVatNuoiThemAct);
        edtTenVatNuoi=findViewById(R.id.edtTenVatNuoiThemAct);
        edtLoai=findViewById(R.id.edtLoaiThemAct);
        edtGioiTinh=findViewById(R.id.edtGioiTinhThemAct);
        edtTuoi=findViewById(R.id.edtTuoiThemAct);
        edtMota=findViewById(R.id.edtMotaThemAct);
        edtNgayNhap=findViewById(R.id.edtNgayNhapThemAct);
        edtGiatien=findViewById(R.id.edtGiaThemAct);
        img=findViewById(R.id.imgThemAct);
        btnAnh=findViewById(R.id.btnAnhThemAct);
        btnAdd=findViewById(R.id.btnAddThemAct);
        btnHuy=findViewById(R.id.btnHuyThemAct);
        btnChonNgay=findViewById(R.id.btnChonNgayThemAct);
        btnChonNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar=Calendar.getInstance();
                DatePickerDialog datePickerDialog=new DatePickerDialog(ThemVatNuoiAct.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/MM/dd");
                        Calendar cal=new GregorianCalendar(year,month,dayOfMonth);
                        edtNgayNhap.setText(simpleDateFormat.format(cal.getTime()));
                    }
                },calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ThemVatNuoiAct.this,KhoHangAct.class);
                startActivity(intent);
            }
        });
        btnAnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,requestCodeFolder);
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/MM/dd");
                Sqlite sqlite=new Sqlite(ThemVatNuoiAct.this);
                VatNuoiSql vatNuoiSql=new VatNuoiSql(sqlite);
                BitmapDrawable bitmapDrawable=(BitmapDrawable)img.getDrawable();
                Bitmap bitmap=bitmapDrawable.getBitmap();
                ByteArrayOutputStream byteArray=new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG,0,byteArray);
                byte[] anh=byteArray.toByteArray();
                String maVatNuoi=edtMaVatNuoi.getText().toString();
                String tenVatNuoi=edtTenVatNuoi.getText().toString();
                String tenLoai=edtLoai.getText().toString();
                String gioiTinh=edtGioiTinh.getText().toString();
                String tuoi=edtTuoi.getText().toString();
                String moTa=edtMota.getText().toString();
                String date=edtNgayNhap.getText().toString();
                Double giaTien=Double.parseDouble(edtGiatien.getText().toString());
                try {
                    vatNuoiSql.ThemVatNuoi(maVatNuoi,tenVatNuoi,tenLoai,gioiTinh,tuoi,moTa,anh,simpleDateFormat.parse(date),giaTien);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Toast.makeText(ThemVatNuoiAct.this, "", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==requestCodeFolder&&resultCode==RESULT_OK&&data!=null){
            Uri uri=data.getData();
            try {
                InputStream inputStream=getContentResolver().openInputStream(uri);
                Bitmap bitmap=BitmapFactory.decodeStream(inputStream);
                img.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}