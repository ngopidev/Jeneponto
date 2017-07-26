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

        final TextView keterangan = (TextView) findViewById(R.id.keterangan);

        final String pilihTawar = perikananTawar.getSelectedItem().toString();


        izinPertama.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                final String pilihIzin = izinPertama.getSelectedItem().toString();

                if (pilihIzin.equals("Pilih Jenis Izin")) {
                    //menutup semua view
                    llpertama.setVisibility(View.GONE);
                    llkedua.setVisibility(View.GONE);
                    jenisPerikanan.setVisibility(View.GONE);
                    perikananTawar.setVisibility(View.GONE);
                    perikananPayau.setVisibility(View.GONE);

                    keterangan.setText(null);


                } else if (pilihIzin.equals("Perpanjangan Izin Memperkerjakan Tenaga Kerja Asing")) {
                    //menutup view yang tidak diperlukan
                    llkedua.setVisibility(View.GONE);
                    jenisPerikanan.setVisibility(View.GONE);
                    perikananTawar.setVisibility(View.GONE);
                    perikananPayau.setVisibility(View.GONE);
                    spinRumput.setVisibility(View.GONE);

                    //membuka view yang diperlukan
                    llpertama.setVisibility(View.VISIBLE);

                    keterangan.setText(R.string.ket_tenaga_kerja);
                } else if (pilihIzin.equals("Izin Mendirikan Bangunan")) {
                    //menutup view yang tidak diperlukan
                    llpertama.setVisibility(View.GONE);
                    jenisPerikanan.setVisibility(View.GONE);
                    perikananTawar.setVisibility(View.GONE);

                    //membuka view yang diperlukan
                    llkedua.setVisibility(View.VISIBLE);
                    menuIMB.setVisibility(View.VISIBLE);

                    keterangan.setText(R.string.ket_imb);
                } else if (pilihIzin.equals("Izin Usaha Perikanan")) {

                    //menutup view yang tidak diperlukan
                    llpertama.setVisibility(View.GONE);
                    llkedua.setVisibility(View.GONE);

                    //membuka view yang diperlukan
                    jenisPerikanan.setVisibility(View.VISIBLE);
                    jenisPerikanan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            String pilihPerikanan = jenisPerikanan.getSelectedItem().toString();

                            if (pilihPerikanan.equals("Pilih jenis perikanan")) {
                                //menutup view yang tidak digunakan
                                perikananTawar.setVisibility(View.GONE);
                                perikananPayau.setVisibility(View.GONE);

                            } else if (pilihPerikanan.equals("Ikan air tawar")) {
                                //menutup view yang tidak digunakan
                                perikananPayau.setVisibility(View.GONE);

                                //membuka view yang tidak digunakan
                                perikananTawar.setVisibility(View.VISIBLE);
                                perikananTawar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                        if (pilihTawar.equals("Pilih metode perikanan air tawar")) {

                                        } else if (pilihTawar.equals("Pembenihan ikan dengan luas 0,75 ha atau lebih")) {
                                            //menutup view yang tidak diperlukan
                                        } else if (pilihTawar.equals("Pembenihan ikan dengan luas 2 ha atau lebih")) {
                                            //menutup view yang tidak diperlukan
                                        } else if (pilihTawar.equals("Pembenihan ikan lebih dari 5 unit")) {
                                            //menutup view yang tidak diperlukan
                                        } else if (pilihTawar.equals("Usaha keramba jaring apung lebih dari 4 unit")) {

                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {

                                    }
                                });
                            } else if (pilihPerikanan.equals("Ikan air payau")) {
                                //menutup view yang tidak diperlukan
                                perikananTawar.setVisibility(View.GONE);

                                //membuka view yang diperlukan
                                perikananPayau.setVisibility(View.VISIBLE);
                                perikananPayau.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        String pilihPayau = perikananPayau.getSelectedItem().toString();
                                        if (pilihPayau.equals("Pilih metode perikanan air payau")) {
                                            //menutup semua view
                                            spinRumput.setVisibility(View.GONE);

                                        } else if (pilihPayau.equals("Pembenihan ikan dengan luas 0,5 ha atau lebih")) {
                                            //menutup view yang tidak diperlukan
                                            spinRumput.setVisibility(View.GONE);

                                        } else if (pilihPayau.equals("Pembesaran ikan dengan luas 5 ha atau lebih")) {
                                            //menutup view yang tidak diperlukan
                                            spinRumput.setVisibility(View.GONE);

                                        } else if (pilihPayau.equals("Pembudidayaan rumput laut")) {
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
                                        } else if (pilihPayau.equals("Usaha kerang hijau")) {
                                            //menutup view yang tidak diperlukan
                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {

                                    }
                                });


                            } else if (pilihPerikanan.equals("Usaha perikanan penangkapan ikan")) {

                            } else if (pilihPerikanan.equals("Usaha kapal pengangkutan ikan")) {

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