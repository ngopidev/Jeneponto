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

    private Spinner izinPertama;

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
        final TextView indeks = (TextView) findViewById(R.id.text_100_Tk);
        final EditText tk = (EditText) findViewById(R.id.input_Tk);
        final Spinner spinHsbg = (Spinner) findViewById(R.id.HSbg);

        //deklarasi ketika memilih izin usaha perikanan
        //khusus spinner
        final Spinner jenisPerikanan = (Spinner) findViewById(R.id.spin_jenis_perikanan);
        final Spinner perikananTawar = (Spinner) findViewById(R.id.spin_perikanan_tawar);
        final Spinner perikananPayau = (Spinner) findViewById(R.id.spin_perikanan_payau);
        final Spinner spinRumput = (Spinner) findViewById(R.id.spin_rumput);
        final Spinner spinKerang = (Spinner) findViewById(R.id.spin_kerang_hijau);
        final Spinner spinPenangkapanIkan = (Spinner) findViewById(R.id.spin_penangkapan_ikan);

        izinPertama.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                final String pilihIzin = izinPertama.getSelectedItem().toString();

                if (pilihIzin.equals("Pilih Jenis Izin")){
                    //menutup semua view
                    llpertama.setVisibility(View.GONE);
                    ketTenagaKerja.setVisibility(View.GONE);
                    llkedua.setVisibility(View.GONE);
                    jenisPerikanan.setVisibility(View.GONE);
                    perikananTawar.setVisibility(View.GONE);
                    perikananPayau.setVisibility(View.GONE);

                }
                else if (pilihIzin.equals("Perpanjangan Izin Memperkerjakan Tenaga Kerja Asing")){
                    //menutup view yang tidak diperlukan
                    llkedua.setVisibility(View.GONE);
                    jenisPerikanan.setVisibility(View.GONE);
                    perikananTawar.setVisibility(View.GONE);

                    //membuka view yang diperlukan
                    llpertama.setVisibility(View.VISIBLE);
                    ketTenagaKerja.setVisibility(View.VISIBLE);
                }
                else if (pilihIzin.equals("Izin Mendirikan Bangunan")){
                    //menutup view yang tidak diperlukan
                    llpertama.setVisibility(View.GONE);
                    ketTenagaKerja.setVisibility(View.GONE);
                    jenisPerikanan.setVisibility(View.GONE);
                    perikananTawar.setVisibility(View.GONE);

                    //membuka view yang diperlukan
                    llkedua.setVisibility(View.VISIBLE);
                    menuIMB.setVisibility(View.VISIBLE);
                }

                else if (pilihIzin.equals("Izin Usaha Perikanan")){

                    //menutup view yang tidak diperlukan
                    llpertama.setVisibility(View.GONE);
                    ketTenagaKerja.setVisibility(View.GONE);
                    llkedua.setVisibility(View.GONE);

                    //membuka view yang diperlukan
                    jenisPerikanan.setVisibility(View.VISIBLE);
                    jenisPerikanan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String pilihPerikanan = jenisPerikanan.getSelectedItem().toString();

                    if (pilihPerikanan.equals("Pilih jenis perikanan")){
                        perikananTawar.setVisibility(View.GONE);

                    }else if (pilihPerikanan.equals("Ikan air tawar")){
                        perikananTawar.setVisibility(View.VISIBLE);
                        perikananTawar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                String pilihTawar = perikananTawar.getSelectedItem().toString();
                                if (pilihTawar.equals("Pilih metode perikanan air tawar")){
                                    perikananPayau.setVisibility(View.GONE);

                                }else if (pilihTawar.equals("Pembenihan ikan dengan luas 0,75 ha atau lebih")){
                                    //menutup view yang tidak diperlukan
                                }else if (pilihTawar.equals("Pembenihan ikan dengan luas 2 ha atau lebih")){
                                    //menutup view yang tidak diperlukan
                                }else if (pilihTawar.equals("Pembenihan ikan lebih dari 5 unit")){
                                    //menutup view yang tidak diperlukan
                                }else if (pilihTawar.equals("Usaha keramba jaring apung lebih dari 4 unit")){
                                    //menutup view yang tidak diperlukan
                                }
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                    }else if (pilihPerikanan.equals("Ikan air payau")){
                        perikananPayau.setVisibility(View.VISIBLE);
                        perikananPayau.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                String pilihPayau = perikananPayau.getSelectedItem().toString();
                                if (pilihPayau.equals("Pilih metode perikanan air payau")){

                                }else if (pilihPayau.equals("Pembenihan ikan dengan luas 0,5 ha atau lebih")){
                                    //menutup view yang tidak diperlukan
                                }else if (pilihPayau.equals("Pembesaran ikan dengan luas 5 ha atau lebih")){
                                    //menutup view yang tidak diperlukan
                                }else if (pilihPayau.equals("Pembudidayaan rumput laut")){
                                    spinRumput.setVisibility(View.VISIBLE);
                                    spinRumput.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                        @Override
                                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                            String pilihRumput = perikananPayau.getSelectedItem().toString();
                                            if (pilihRumput.equals("pilih metode budidaya rumput laut")) {

                                            } else if (pilihRumput.equals("Lepas dasar")) {
                                                //menutup view yang tidak diperlukan
                                            } else if (pilihRumput.equals("Rakit apung")) {
                                                //menutup view yang tidak diperlukan
                                            } else if (pilihRumput.equals("Long line")) {
                                                //menutup view yang tidak diperlukan
                                            }
                                        }

                                        @Override
                                        public void onNothingSelected(AdapterView<?> parent) {

                                        }
                                    });
                                }
                                        else if (pilihPayau.equals("Usaha kerang hijau")){
                                    //menutup view yang tidak diperlukan
                                }
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });


                    }else if (pilihPerikanan.equals("Usaha perikanan penangkapan ikan")){

                    }else if (pilihPerikanan.equals("Usaha kapal pengangkutan ikan")){

                    }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
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