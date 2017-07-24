package com.ngopi.jeneponto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class Kalkulator extends Home {

    private Spinner izinPertama, subIzin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.FContent); //Remember this is the FrameLayout area within your activity_main.xml
        getLayoutInflater().inflate(R.layout.layout_kalkulator, contentFrameLayout);

        //deklarasi view utama di activity kalkulator
        izinPertama = (Spinner) findViewById(R.id.izin_pertama);
        final Button hasil = (Button) findViewById(R.id.button_hitung);
        final TextView hasil_hitung = (TextView) findViewById(R.id.hasil_hitung);

        //deklarasi ketika memilih perpanjangan izin tenaga kerja asing
        final LinearLayout llpertama = (LinearLayout) findViewById(R.id.linear_asing);
        final EditText tenagaKerja = (EditText) findViewById(R.id.jumlah_tenaga_kerja);
        //final double jumlahTenagaKerja = Double.parseDouble(String.valueOf(tenagaKerja.getText()));
        final TextView ketTenagaKerja = (TextView) findViewById(R.id.ket_tenaga_kerja);

        //deklarasi ketika memilih izin mendirikan bangunan
        final LinearLayout llkedua = (LinearLayout) findViewById(R.id.linear_imb);
        final Spinner menuIMB = (Spinner) findViewById(R.id.menu_imb);
        final TextView lv = (TextView) findViewById(R.id.text_L_V);
        final TextView ItI = (TextView) findViewById(R.id.text_It_I);
        final TextView indeks = (TextView) findViewById(R.id.text_100);
        final EditText tk = (EditText) findViewById(R.id.input_Tk);
        final Spinner spinHsbg = (Spinner) findViewById(R.id.HSbg);
        final LinearLayout ketIMB = (LinearLayout) findViewById(R.id.ket_imb);



        izinPertama.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String pilihIzin = izinPertama.getSelectedItem().toString();

                if (pilihIzin.equals("Pilih Jenis Izin")){
                    //menutup semua view
                    llpertama.setVisibility(View.GONE);
                    ketTenagaKerja.setVisibility(View.GONE);
                    llkedua.setVisibility(View.GONE);
                    ketIMB.setVisibility(View.GONE);

                }
                else if (pilihIzin.equals("Perpanjangan Izin\n Memperkerjakan Tenaga Kerja Asing")){
                    //menutup view yang tidak diperlukan
                    llkedua.setVisibility(View.GONE);
                    ketIMB.setVisibility(View.GONE);

                    //membuka view yang diperlukan
                    llpertama.setVisibility(View.VISIBLE);
                    ketTenagaKerja.setVisibility(View.VISIBLE);
                }
                else if (pilihIzin.equals("Izin Mendirikan Bangunan")){
                    //menutup view yang tidak diperlukan
                    llpertama.setVisibility(View.GONE);
                    ketTenagaKerja.setVisibility(View.GONE);

                    //membuka view yang diperlukan
                    llkedua.setVisibility(View.VISIBLE);
                    menuIMB.setVisibility(View.VISIBLE);
                    ketIMB.setVisibility(View.VISIBLE);


                    String pilihIMB = menuIMB.getSelectedItem().toString();

                    if (pilihIMB.equals("Pilih Jenis Retribusi")){
                        //menutup view yang tidak diperlukan
                        lv.setText(null);
                        ItI.setText(null);
                    }
                    else if (pilihIMB.equals("Retribusi pembangunan gedung baru")){
                        //menutup view yang tidak diperlukan

                        //membuka view yang diperlukan
                        menuIMB.setVisibility(View.VISIBLE);
                        lv.setText("L");
                        ItI.setText("It");
                        indeks.setVisibility(View.VISIBLE);
                        indeks.setText("indeks 1.00");
//                        indeks.setTextSize(R.string.haha);

                        String hsbg = spinHsbg.getSelectedItem().toString();
                        if (hsbg.equals("Bangunan gedung tidak bertingkat sederhana (Rp. 6000 permeter persegi)")){

                        }else if (hsbg.equals("Bangunan gedung tidak bertingkat (Rp. 12.000 permeter persegi)")){

                        }else if (hsbg.equals("Bangunan gedung bertingkat (Rp. 18.000 permeter persegi)")){

                        }
                    }
                }
                else if (pilihIzin.equals("Izin Usaha Perikanan")){

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed2();
    }
}