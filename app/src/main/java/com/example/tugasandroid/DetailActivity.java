package com.example.tugasandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        final TextView tvNamaDepan = (TextView) findViewById(R.id.tv_namaDepan);
        final TextView tvNamaBelakang = (TextView) findViewById(R.id.tv_namaBelakang);

        Intent i = getIntent();
        tvNamaDepan.setText(i.getStringExtra("i_nama"));
        tvNamaBelakang.setText(i.getStringExtra("i_alamat"));

        getSupportActionBar().setTitle("Biodata");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
