package com.example.tugasandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    //persiapan variable objek yang ada pada xml
    EditText etNamaDepan, etNamaBelakang, etAlamat, etTelepon;
    Spinner spGender;
    CheckBox cbSMKDwidaya, cbSMUDonBosco, cbSMKMerahPutih, cbSMUSutarmadja;
    RadioGroup rg_lulusan;
    Button btSimpan;
    Button btHapus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //definisi dan sambungkan objek yang ada pada xml
        etNamaDepan = (EditText) findViewById(R.id.et_namadepan);
        etNamaBelakang = (EditText) findViewById(R.id.et_namabelakang);
        etAlamat = (EditText) findViewById(R.id.et_alamat);
        etTelepon = (EditText) findViewById(R.id.et_telepon);
        spGender = (Spinner) findViewById(R.id.sp_gender);
        cbSMKDwidaya = (CheckBox) findViewById(R.id.cb_smkdwidaya);
        cbSMKMerahPutih = (CheckBox) findViewById(R.id.cb_smkmerahputih);
        cbSMUDonBosco = (CheckBox) findViewById(R.id.cb_smudonbosco);
        cbSMUSutarmadja = (CheckBox) findViewById(R.id.cb_smusutarmadja);

        rg_lulusan = findViewById(R.id.rg_lulusan);

        final RadioButton rbSMP = findViewById(R.id.rb_SMP);
        rbSMP.setChecked(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Memanggil Layout menunya
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);

        MenuItem menuItem = menu.findItem(R.id.mn_cari);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                Toast.makeText(getApplicationContext(), newText, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mn_alert:
                Toast.makeText(getApplicationContext(),"ENDAH", Toast.LENGTH_SHORT).show();
                return true;
            case  R.id.mn_snack:
                Intent goProvil = new Intent(MainActivity.this, DetailActivity.class );
                startActivity(goProvil);
                return true;
            case R.id.mn_biodata:
                View view = findViewById(R.id.main_layout);
                String pesan = "ENDAH";
                int durasi = Snackbar.LENGTH_SHORT;
                Snackbar.make(view,pesan,durasi).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}