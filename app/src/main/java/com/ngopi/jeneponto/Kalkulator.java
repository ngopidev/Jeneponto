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
        final LinearLayout ketIMB = (LinearLayout) findViewById(R.id.ket_imb);

        //deklarasi ketika memilih izin usaha perikanan
        //khusus spinner
        final Spinner jenisPerikanan = (Spinner) findViewById(R.id.spin_jenis_perikanan);
        final Spinner perikananTawar = (Spinner) findViewById(R.id.spin_perikanan_tawar);
        final Spinner perikananPayau = (Spinner) findViewById(R.id.spin_perikanan_payau);
        final Spinner spinRumput = (Spinner) findViewById(R.id.spin_rumput);
        final Spinner spinKerang = (Spinner) findViewById(R.id.spin_kerang_hijau);
        final Spinner spinPenangkapanIkan = (Spinner) findViewById(R.id.spin_penangkapan_ikan);

        //khusus air tawar
        final TextView ketTawar1 = (TextView) findViewById(R.id.ket_tawar1);
        final TextView rumusTawar1 = (TextView) findViewById(R.id.rumus_tawar1);
        final TextView ketTawar2 = (TextView) findViewById(R.id.ket_tawar2);
        final TextView rumusTawar2 = (TextView) findViewById(R.id.rumus_tawar2);
        final TextView ketTawar3 = (TextView) findViewById(R.id.ket_tawar3);
        final TextView rumusTawar3 = (TextView) findViewById(R.id.rumus_tawar3);
        final TextView ketTawar4 = (TextView) findViewById(R.id.ket_tawar4);
        final TextView rumusTawar4 = (TextView) findViewById(R.id.rumus_tawar4);

        //khusus air payau
        final TextView ketPayau1 = (TextView) findViewById(R.id.ket_payau1);
        final TextView rumusPayau1 = (TextView) findViewById(R.id.rumus_payau1);
        final TextView ketPayau2 = (TextView) findViewById(R.id.ket_payau2);
        final TextView rumusPayau2 = (TextView) findViewById(R.id.rumus_payau2);
        final TextView ketRumputLepas = (TextView) findViewById(R.id.ket_rumput_lepas);
        final TextView rumusRumputLepas = (TextView) findViewById(R.id.rumus_rumput_lepas);
        final TextView ketRumputRakit = (TextView) findViewById(R.id.ket_rumput_rakit);
        final TextView rumusRumputRakit = (TextView) findViewById(R.id.rumus_rumput_rakit);
        final TextView ketRumputLongline = (TextView) findViewById(R.id.ket_rumput_longline);
        final TextView rumusRumputLongline = (TextView) findViewById(R.id.rumus_rumput_longline);


        izinPertama.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                final String pilihIzin = izinPertama.getSelectedItem().toString();

                if (pilihIzin.equals("Pilih Jenis Izin")){
                    //menutup semua view
                    llpertama.setVisibility(View.GONE);
                    ketTenagaKerja.setVisibility(View.GONE);
                    llkedua.setVisibility(View.GONE);
                    ketIMB.setVisibility(View.GONE);
                    jenisPerikanan.setVisibility(View.GONE);
                    perikananTawar.setVisibility(View.GONE);
                    perikananPayau.setVisibility(View.GONE);

                    ketTawar1.setVisibility(View.GONE);
                    ketTawar2.setVisibility(View.GONE);
                    ketTawar3.setVisibility(View.GONE);
                    ketTawar4.setVisibility(View.GONE);
                    rumusTawar1.setVisibility(View.GONE);
                    rumusTawar2.setVisibility(View.GONE);
                    rumusTawar3.setVisibility(View.GONE);
                    rumusTawar4.setVisibility(View.GONE);

                    ketPayau1.setVisibility(View.GONE);
                    rumusPayau1.setVisibility(View.GONE);
                    ketPayau2.setVisibility(View.GONE);
                    rumusPayau2.setVisibility(View.GONE);
                    ketRumputLepas.setVisibility(View.GONE);
                    rumusRumputLepas.setVisibility(View.GONE);
                    ketRumputRakit.setVisibility(View.GONE);
                    rumusRumputRakit.setVisibility(View.GONE);
                    ketRumputLongline.setVisibility(View.GONE);
                    rumusRumputLongline.setVisibility(View.GONE);



                }
                else if (pilihIzin.equals("Perpanjangan Izin Memperkerjakan Tenaga Kerja Asing")){
                    //menutup view yang tidak diperlukan
                    llkedua.setVisibility(View.GONE);
                    ketIMB.setVisibility(View.GONE);
                    jenisPerikanan.setVisibility(View.GONE);
                    perikananTawar.setVisibility(View.GONE);

                    ketTawar1.setVisibility(View.GONE);
                    ketTawar2.setVisibility(View.GONE);
                    ketTawar3.setVisibility(View.GONE);
                    ketTawar4.setVisibility(View.GONE);
                    rumusTawar1.setVisibility(View.GONE);
                    rumusTawar2.setVisibility(View.GONE);
                    rumusTawar3.setVisibility(View.GONE);
                    rumusTawar4.setVisibility(View.GONE);

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
                    ketIMB.setVisibility(View.VISIBLE);
                }

                else if (pilihIzin.equals("Izin Usaha Perikanan")){

                    //menutup view yang tidak diperlukan
                    llpertama.setVisibility(View.GONE);
                    ketTenagaKerja.setVisibility(View.GONE);
                    llkedua.setVisibility(View.GONE);
                    ketIMB.setVisibility(View.GONE);

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
                                    ketTawar1.setVisibility(View.GONE);
                                    rumusTawar1.setVisibility(View.GONE);
                                    ketTawar2.setVisibility(View.GONE);
                                    rumusTawar2.setVisibility(View.GONE);
                                    ketTawar3.setVisibility(View.GONE);
                                    rumusTawar3.setVisibility(View.GONE);
                                    ketTawar4.setVisibility(View.GONE);
                                    rumusTawar4.setVisibility(View.GONE);
                                    perikananPayau.setVisibility(View.GONE);

                                }else if (pilihTawar.equals("Pembenihan ikan dengan luas 0,75 ha atau lebih")){
                                    //menutup view yang tidak diperlukan
                                    ketTawar2.setVisibility(View.GONE);
                                    rumusTawar2.setVisibility(View.GONE);
                                    ketTawar3.setVisibility(View.GONE);
                                    rumusTawar3.setVisibility(View.GONE);
                                    ketTawar4.setVisibility(View.GONE);
                                    rumusTawar4.setVisibility(View.GONE);

                                    //membuka view yang diperlukan
                                    ketTawar1.setVisibility(View.VISIBLE);
                                    rumusTawar1.setVisibility(View.VISIBLE);
                                }else if (pilihTawar.equals("Pembenihan ikan dengan luas 2 ha atau lebih")){
                                    //menutup view yang tidak diperlukan
                                    ketTawar1.setVisibility(View.GONE);
                                    rumusTawar1.setVisibility(View.GONE);
                                    ketTawar3.setVisibility(View.GONE);
                                    rumusTawar3.setVisibility(View.GONE);
                                    ketTawar4.setVisibility(View.GONE);
                                    rumusTawar4.setVisibility(View.GONE);

                                    //membuka view yang diperlukan
                                    ketTawar2.setVisibility(View.VISIBLE);
                                    rumusTawar2.setVisibility(View.VISIBLE);
                                }else if (pilihTawar.equals("Pembenihan ikan lebih dari 5 unit")){
                                    //menutup view yang tidak diperlukan
                                    ketTawar1.setVisibility(View.GONE);
                                    rumusTawar1.setVisibility(View.GONE);
                                    ketTawar2.setVisibility(View.GONE);
                                    rumusTawar2.setVisibility(View.GONE);
                                    ketTawar4.setVisibility(View.GONE);
                                    rumusTawar4.setVisibility(View.GONE);

                                    //membuka view yang tidak diperlukan
                                    ketTawar3.setVisibility(View.VISIBLE);
                                    rumusTawar3.setVisibility(View.VISIBLE);
                                }else if (pilihTawar.equals("Usaha keramba jaring apung lebih dari 4 unit")){
                                    //menutup view yang tidak diperlukan
                                    ketTawar1.setVisibility(View.GONE);
                                    rumusTawar1.setVisibility(View.GONE);
                                    ketTawar2.setVisibility(View.GONE);
                                    rumusTawar2.setVisibility(View.GONE);
                                    ketTawar3.setVisibility(View.GONE);
                                    rumusTawar3.setVisibility(View.GONE);

                                    //membuka view yang diperlukan
                                    ketTawar4.setVisibility(View.VISIBLE);
                                    rumusTawar4.setVisibility(View.VISIBLE);
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
                                    ketPayau1.setVisibility(View.GONE);
                                    rumusPayau1.setVisibility(View.GONE);
                                    ketPayau2.setVisibility(View.GONE);
                                    rumusPayau2.setVisibility(View.GONE);
                                    ketRumputLepas.setVisibility(View.GONE);
                                    rumusRumputLepas.setVisibility(View.GONE);
                                    ketRumputLongline.setVisibility(View.GONE);
                                    rumusRumputLongline.setVisibility(View.GONE);

                                }else if (pilihPayau.equals("Pembenihan ikan dengan luas 0,5 ha atau lebih")){
                                    //menutup view yang tidak diperlukan
                                    ketPayau2.setVisibility(View.GONE);
                                    rumusPayau2.setVisibility(View.GONE);
                                    ketRumputLepas.setVisibility(View.GONE);
                                    rumusRumputLepas.setVisibility(View.GONE);
                                    ketRumputLongline.setVisibility(View.GONE);
                                    rumusRumputLongline.setVisibility(View.GONE);

                                    //membuka view yang diperlukan
                                    ketPayau1.setVisibility(View.VISIBLE);
                                    rumusPayau1.setVisibility(View.VISIBLE);
                                }else if (pilihPayau.equals("Pembesaran ikan dengan luas 5 ha atau lebih")){
                                    //menutup view yang tidak diperlukan
                                    ketPayau1.setVisibility(View.GONE);
                                    rumusPayau1.setVisibility(View.GONE);
                                    ketRumputLepas.setVisibility(View.GONE);
                                    rumusRumputLepas.setVisibility(View.GONE);
                                    ketRumputLongline.setVisibility(View.GONE);
                                    rumusRumputLongline.setVisibility(View.GONE);

                                    //membuka view yang diperlukan
                                    ketPayau2.setVisibility(View.VISIBLE);
                                    rumusPayau2.setVisibility(View.VISIBLE);
                                }else if (pilihPayau.equals("Pembudidayaan rumput laut")){
                                    spinRumput.setVisibility(View.VISIBLE);
                                    spinRumput.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                        @Override
                                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                            String pilihRumput = perikananPayau.getSelectedItem().toString();
                                            if (pilihRumput.equals("pilih metode budidaya rumput laut")) {
                                                ketRumputLepas.setVisibility(View.GONE);
                                                rumusRumputLepas.setVisibility(View.GONE);
                                                ketRumputRakit.setVisibility(View.GONE);
                                                rumusRumputRakit.setVisibility(View.GONE);


                                            } else if (pilihRumput.equals("Lepas dasar")) {
                                                //menutup view yang tidak diperlukan
                                                ketRumputRakit.setVisibility(View.GONE);
                                                rumusRumputRakit.setVisibility(View.GONE);

                                                //membuka view yang diperlukan
                                                ketRumputLepas.setVisibility(View.VISIBLE);
                                                rumusRumputLepas.setVisibility(View.VISIBLE);
                                            } else if (pilihRumput.equals("Rakit apung")) {
                                                //menutup view yang tidak diperlukan
                                                ketRumputLepas.setVisibility(View.GONE);
                                                rumusRumputLepas.setVisibility(View.GONE);

                                                //membuka view yang diperlukan
                                                ketRumputRakit.setVisibility(View.VISIBLE);
                                                rumusRumputRakit.setVisibility(View.VISIBLE);
                                            } else if (pilihRumput.equals("Long line")) {
                                                //menutup view yang tidak diperlukan
                                                ketRumputLepas.setVisibility(View.GONE);
                                                rumusRumputLepas.setVisibility(View.GONE);
                                                ketRumputRakit.setVisibility(View.GONE);
                                                rumusRumputRakit.setVisibility(View.GONE);

                                                //membuka view yang diperlukan
                                                ketRumputLongline.setVisibility(View.VISIBLE);
                                                rumusRumputLongline.setVisibility(View.VISIBLE);

                                            }
                                            //menutup view yang tidak diperlukan
                                            /*ketPayau1.setVisibility(View.GONE);
                                            rumusPayau1.setVisibility(View.GONE);
                                            ketPayau2.setVisibility(View.GONE);
                                            rumusPayau2.setVisibility(View.GONE);
                                            ketRumputLongline.setVisibility(View.GONE);
                                            rumusRumputLongline.setVisibility(View.GONE);

                                            //membuka view yang tidak diperlukan
                                            ketRumputLepas.setVisibility(View.VISIBLE);
                                            rumusRumputLepas.setVisibility(View.VISIBLE);*/
                                        }

                                        @Override
                                        public void onNothingSelected(AdapterView<?> parent) {

                                        }
                                    });
                                }
                                        else if (pilihPayau.equals("Usaha kerang hijau")){
                                    //menutup view yang tidak diperlukan
                                    ketPayau1.setVisibility(View.GONE);
                                    rumusPayau1.setVisibility(View.GONE);
                                    ketPayau2.setVisibility(View.GONE);
                                    rumusPayau2.setVisibility(View.GONE);
                                    ketRumputLepas.setVisibility(View.GONE);
                                    rumusRumputLepas.setVisibility(View.GONE);

                                    //membuka view yang diperlukan
                                    ketRumputLongline.setVisibility(View.VISIBLE);
                                    rumusRumputLongline.setVisibility(View.VISIBLE);
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