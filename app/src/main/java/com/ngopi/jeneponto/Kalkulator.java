package com.ngopi.jeneponto;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.StringTokenizer;

public class Kalkulator extends Home {

    private Spinner izinPertama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.FContent); //Remember this is the FrameLayout area within your activity_main.xml
        getLayoutInflater().inflate(R.layout.layout_kalkulator, contentFrameLayout);

        //deklarasi view utama di activity kalkulator
        izinPertama = (Spinner) findViewById(R.id.izin_pertama);
        final Button tombolHasil = (Button) findViewById(R.id.button_hitung);
        final TextView hasilHitung = (TextView) findViewById(R.id.hasil_hitung);
        final TextView keterangan = (TextView) findViewById(R.id.keterangan);

        //deklarasi ketika memilih perpanjangan izin tenaga kerja asing
        final LinearLayout llpertama = (LinearLayout) findViewById(R.id.linear_asing);
        final EditText tenagaKerja = (EditText) findViewById(R.id.jumlah_tenaga_kerja);
        final TextView ketTenagaKerja = (TextView) findViewById(R.id.ket_tenaga_kerja);
        final TextView usd = (TextView) findViewById(R.id.textUSD);

        //deklarasi ketika memilih izin mendirikan bangunan
        final LinearLayout llkedua = (LinearLayout) findViewById(R.id.linear_imb);
        final Spinner menuIMB = (Spinner) findViewById(R.id.menu_imb);
        final TextView lv = (TextView) findViewById(R.id.text_L_V);
        final TextView ItI = (TextView) findViewById(R.id.text_It_I);
        final TextView indeks = (TextView) findViewById(R.id.text_index);
        final EditText inputLV = (EditText) findViewById(R.id.input_L_V);
        final EditText inputItI = (EditText) findViewById(R.id.input_It_I);
        final Spinner spinTk = (Spinner) findViewById(R.id.spin_Tk);
        final Spinner spinHsbg = (Spinner) findViewById(R.id.HSbg);

        //deklarasi ketika memilih izin usaha perikanan
        //khusus spinner
        final TextView teksLuas = (TextView) findViewById(R.id.text_luas);
        final EditText inputLuas = (EditText) findViewById(R.id.input_luas);
        final Spinner jenisPerikanan = (Spinner) findViewById(R.id.spin_jenis_perikanan);
        final Spinner perikananTawar = (Spinner) findViewById(R.id.spin_perikanan_tawar);
        final Spinner perikananPayau = (Spinner) findViewById(R.id.spin_perikanan_payau);
        final Spinner spinRumput = (Spinner) findViewById(R.id.spin_rumput);
        final Spinner spinKerang = (Spinner) findViewById(R.id.spin_kerang_hijau);

        //deklarasi ketika memilih penangkapan ikan
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
                    spinRumput.setVisibility(View.GONE);
                    spinHsbg.setVisibility(View.GONE);
                    spinKerang.setVisibility(View.GONE);
                    spinPenangkapanIkan.setVisibility(View.GONE);
                    hasilHitung.setText("");
                    inputLuas.setVisibility(View.GONE);
                    teksLuas.setVisibility(View.GONE);

                }
                else if (pilihIzin.equals("Perpanjangan Izin Memperkerjakan Tenaga Kerja Asing")){
                    //menutup view yang tidak diperlukan
                    llkedua.setVisibility(View.GONE);
                    jenisPerikanan.setVisibility(View.GONE);
                    perikananTawar.setVisibility(View.GONE);
                    spinRumput.setVisibility(View.GONE);
                    spinHsbg.setVisibility(View.GONE);
                    spinKerang.setVisibility(View.GONE);
                    spinPenangkapanIkan.setVisibility(View.GONE);
                    hasilHitung.setText("");
                    inputLuas.setVisibility(View.GONE);
                    teksLuas.setVisibility(View.GONE);

                    //membuka view yang diperlukan
                    llpertama.setVisibility(View.VISIBLE);
                    ketTenagaKerja.setVisibility(View.VISIBLE);

                    usd.setVisibility(View.VISIBLE);


                    tombolHasil.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View v) {

                            String tenagaKerjaNull = tenagaKerja.getText().toString();
                            if(TextUtils.isEmpty(tenagaKerjaNull)) {
                                tenagaKerja.setError("nilai tidak boleh kosong");
                                return;
                            }

                            String hitungAsing = tenagaKerja.getText().toString();
                            int a = Integer.parseInt(hitungAsing);
                            int b = 100;
                            String hasilA = String.valueOf(a * b);
                            hasilHitung.setText(hasilA);
                        }
                    });
                    }
                else if (pilihIzin.equals("Izin Mendirikan Bangunan")) {
                    //menutup view yang tidak diperlukan
                    llpertama.setVisibility(View.GONE);
                    ketTenagaKerja.setVisibility(View.GONE);
                    jenisPerikanan.setVisibility(View.GONE);
                    perikananTawar.setVisibility(View.GONE);
                    spinRumput.setVisibility(View.GONE);
                    spinHsbg.setVisibility(View.GONE);
                    spinKerang.setVisibility(View.GONE);
                    spinPenangkapanIkan.setVisibility(View.GONE);
                    hasilHitung.setText(null);
                    inputLuas.setVisibility(View.GONE);
                    teksLuas.setVisibility(View.GONE);

                    //membuka view yang diperlukan
                    llkedua.setVisibility(View.VISIBLE);
                    menuIMB.setVisibility(View.VISIBLE);

                    keterangan.setText(R.string.ket_imb);

                    menuIMB.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            String pilihIMB = menuIMB.getSelectedItem().toString();
                            if (pilihIMB.equals("Pilih Jenis Retribusi")) {
                                //menghilangkan view yang tidak diperlukan
                                lv.setText("");
                                inputLV.setText("");
                                ItI.setText("");
                                inputItI.setText("");
                                indeks.setVisibility(View.GONE);
                                hasilHitung.setText("");
                                spinTk.setVisibility(View.GONE);
                                spinRumput.setVisibility(View.GONE);
                                spinHsbg.setVisibility(View.GONE);
                                spinKerang.setVisibility(View.GONE);
                                spinPenangkapanIkan.setVisibility(View.GONE);


                            } else if (pilihIMB.equals("Retribusi pembangunan gedung baru")) {

                                lv.setText("L");
                                ItI.setText("It");
                                indeks.setVisibility(View.VISIBLE);
                                spinTk.setVisibility(View.GONE);
                                hasilHitung.setText("");
                                spinRumput.setVisibility(View.GONE);
                                spinHsbg.setVisibility(View.GONE);
                                spinKerang.setVisibility(View.GONE);
                                spinPenangkapanIkan.setVisibility(View.GONE);

                                spinHsbg.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        String pilihHsbg = spinHsbg.getSelectedItem().toString();
                                        if (pilihHsbg.equals("Pilih Jenis Bangunan")) {
                                            //menutup view yang tidak diperlukan
                                            hasilHitung.setText("");
                                        } else if (pilihHsbg.equals("Bangunan gedung tidak bertingkat sederhana (Rp. 6000 permeter persegi)")) {
                                            //menutup view yang tidak diperlukan
                                            hasilHitung.setText("");

                                            //membuka view yang diperlukan
                                            tombolHasil.setOnClickListener(new View.OnClickListener() {

                                                @Override
                                                public void onClick(View v) {

                                                    String lvNull = inputLV.getText().toString();
                                                    String ItINull = inputItI.getText().toString();

                                                    if(TextUtils.isEmpty(lvNull)) {
                                                        inputLV.setError("nilai tidak boleh kosong");
                                                        return;
                                                    }
                                                    if (TextUtils.isEmpty(ItINull)){
                                                        inputItI.setError("nilai tidak boleh kosong");
                                                        return;
                                                    }

                                                    String strlv = inputLV.getText().toString();
                                                    String strItI = inputItI.getText().toString();
                                                    double lv = Double.parseDouble(strlv);
                                                    double ItI = Double.parseDouble(strItI);

                                                    String hasil = String.valueOf(lv * ItI * 1 * 6000);
                                                    hasilHitung.setText(hasil);
                                                    keterangan.setText(R.string.ket_gedung_baru);
                                                }
                                            });

                                        } else if (pilihHsbg.equals("Bangunan gedung tidak bertingkat (Rp. 12.000 permeter persegi)")) {
                                            //menutup view yang tidak diperlukan
                                            hasilHitung.setText("");

                                            //membuka view yang diperlukan
                                            tombolHasil.setOnClickListener(new View.OnClickListener() {

                                                @Override
                                                public void onClick(View v) {

                                                    String lvNull = inputLV.getText().toString();
                                                    String ItINull = inputItI.getText().toString();

                                                    if(TextUtils.isEmpty(lvNull)) {
                                                        inputLV.setError("nilai tidak boleh kosong");
                                                        return;
                                                    }
                                                    if (TextUtils.isEmpty(ItINull)){
                                                        inputItI.setError("nilai tidak boleh kosong");
                                                        return;
                                                    }

                                                    String strlv = inputLV.getText().toString();
                                                    String strItI = inputItI.getText().toString();
                                                    double lv = Double.parseDouble(strlv);
                                                    double ItI = Double.parseDouble(strItI);

                                                    String hasil = String.valueOf(lv * ItI * 1 * 12000);
                                                    hasilHitung.setText(hasil);
                                                    keterangan.setText(R.string.ket_gedung_baru);
                                                }
                                            });

                                        } else if (pilihHsbg.equals("Bangunan gedung bertingkat (Rp. 18.000 permeter persegi)")) {
                                            //menutup view yang tidak diperlukan
                                            hasilHitung.setText("");

                                            //membuka view yang diperlukan
                                            tombolHasil.setOnClickListener(new View.OnClickListener() {

                                                @Override
                                                public void onClick(View v) {

                                                    String lvNull = inputLV.getText().toString();
                                                    String ItINull = inputItI.getText().toString();

                                                    if(TextUtils.isEmpty(lvNull)) {
                                                        inputLV.setError("nilai tidak boleh kosong");
                                                        return;
                                                    }
                                                    if (TextUtils.isEmpty(ItINull)){
                                                        inputItI.setError("nilai tidak boleh kosong");
                                                        return;
                                                    }

                                                    String strlv = inputLV.getText().toString();
                                                    String strItI = inputItI.getText().toString();
                                                    double lv = Double.parseDouble(strlv);
                                                    double ItI = Double.parseDouble(strItI);

                                                    String hasil = String.valueOf(lv * ItI * 1 * 18000);
                                                    hasilHitung.setText(hasil);
                                                    keterangan.setText(R.string.ket_gedung_baru);
                                                }
                                            });
                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {

                                    }
                                });
                            }else if (pilihIMB.equals("Retribusi rehabilitasi/renovasi bangunan gedung")){
                                //menutup view yang tidak diperlukan
                                lv.setText("L");
                                inputLV.setText("");
                                ItI.setText("It");
                                inputItI.setText("");
                                indeks.setVisibility(View.GONE);
                                hasilHitung.setText("");
                                spinRumput.setVisibility(View.GONE);
                                spinHsbg.setVisibility(View.GONE);
                                spinKerang.setVisibility(View.GONE);
                                spinPenangkapanIkan.setVisibility(View.GONE);

                                //membuka view yang diperlukan
                                spinTk.setVisibility(View.VISIBLE);

                                spinTk.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        String pilihTk = spinTk.getSelectedItem().toString();
                                        if (pilihTk.equals("Pilih tingkat kerusakan")){
                                            hasilHitung.setText("");
                                            inputLV.setText("");
                                            inputItI.setText("");
                                        }
                                        else if (pilihTk.equals("0.45")){
                                            //menutup view yang tidak diperlukan
                                            hasilHitung.setText(null);

                                            //membuka view yang diperlukan
                                            spinHsbg.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                @Override
                                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                    String pilihHsbg = spinHsbg.getSelectedItem().toString();

                                                    if (pilihHsbg.equals("Pilih Jenis Bangunan")){
                                                        hasilHitung.setText("");

                                                    }else if (pilihHsbg.equals("Bangunan gedung tidak bertingkat sederhana (Rp. 6000 permeter persegi)")){
                                                        //menutup view yang tidak diperlukan
                                                        hasilHitung.setText("");

                                                        //membuka view yang diperlukan
                                                        tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {

                                                                String lvNull = inputLV.getText().toString();
                                                                String ItINull = inputItI.getText().toString();

                                                                if(TextUtils.isEmpty(lvNull)) {
                                                                    inputLV.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }
                                                                if (TextUtils.isEmpty(ItINull)){
                                                                    inputItI.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }

                                                                String strlv = inputLV.getText().toString();
                                                                String strIt = inputItI.getText().toString();
                                                                double lv = Double.parseDouble(strlv);
                                                                double It = Double.parseDouble(strIt);

                                                                String hasil = String.valueOf(lv * It * 0.45 * 6000);
                                                                hasilHitung.setText(hasil);
                                                                keterangan.setText(R.string.ket_renovasi_gedung);
                                                            }
                                                        });
                                                    }else if (pilihHsbg.equals("Bangunan gedung tidak bertingkat (Rp. 12.000 permeter persegi)")){
                                                        //menutup view yang tidak diperlukan
                                                        hasilHitung.setText("");

                                                        //membuka view yang diperlukan
                                                        tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {

                                                                String lvNull = inputLV.getText().toString();
                                                                String ItINull = inputItI.getText().toString();

                                                                if(TextUtils.isEmpty(lvNull)) {
                                                                    inputLV.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }
                                                                if (TextUtils.isEmpty(ItINull)){
                                                                    inputItI.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }

                                                                String strlv = inputLV.getText().toString();
                                                                String strIt = inputItI.getText().toString();
                                                                double lv = Double.parseDouble(strlv);
                                                                double It = Double.parseDouble(strIt);

                                                                String hasil = String.valueOf(lv * It * 0.45 * 12000);
                                                                hasilHitung.setText(hasil);
                                                                keterangan.setText(R.string.ket_renovasi_gedung);
                                                            }
                                                        });

                                                    }else if (pilihHsbg.equals("Bangunan gedung bertingkat (Rp. 18.000 permeter persegi)")){
                                                        //menutup view yang tidak diperlukan
                                                        hasilHitung.setText("");

                                                        //membuka view yang diperlukan
                                                        tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                String lvNull = inputLV.getText().toString();
                                                                String ItINull = inputItI.getText().toString();

                                                                if(TextUtils.isEmpty(lvNull)) {
                                                                    inputLV.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }
                                                                if (TextUtils.isEmpty(ItINull)){
                                                                    inputItI.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }

                                                                String strlv = inputLV.getText().toString();
                                                                String strIt = inputItI.getText().toString();
                                                                double lv = Double.parseDouble(strlv);
                                                                double It = Double.parseDouble(strIt);

                                                                String hasil = String.valueOf(lv * It * 0.45 * 12000);
                                                                hasilHitung.setText(hasil);
                                                                keterangan.setText(R.string.ket_renovasi_gedung);
                                                            }
                                                        });
                                                    }
                                                }

                                                @Override
                                                public void onNothingSelected(AdapterView<?> parent) {

                                                }
                                            });
                                        }else if (pilihTk.equals("0.65")){
                                            hasilHitung.setText(null);
                                            spinHsbg.getSelectedItem().equals("Pilih Jenis Bangunan");

                                            spinHsbg.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                @Override
                                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                    final String pilihHsbg = spinHsbg.getSelectedItem().toString();

                                                    if (pilihHsbg.equals("Pilih Jenis Bangunan")) {
                                                        hasilHitung.setText("");

                                                    } else if (pilihHsbg.equals("Bangunan gedung tidak bertingkat sederhana (Rp. 6000 permeter persegi)")) {
                                                        //menutup view yang tidak diperlukan
                                                        hasilHitung.setText("");

                                                        //membuka view yang diperlukan
                                                        tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {

                                                                String lvNull = inputLV.getText().toString();
                                                                String ItINull = inputItI.getText().toString();

                                                                if(TextUtils.isEmpty(lvNull)) {
                                                                    inputLV.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }
                                                                if (TextUtils.isEmpty(ItINull)){
                                                                    inputItI.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }

                                                                String strlv = inputLV.getText().toString();
                                                                String strIt = inputItI.getText().toString();
                                                                double lv = Double.parseDouble(strlv);
                                                                double It = Double.parseDouble(strIt);

                                                                String hasil = String.valueOf(lv * It * 0.65 * 6000);
                                                                hasilHitung.setText(hasil);
                                                                keterangan.setText(R.string.ket_renovasi_gedung);
                                                            }
                                                        });
                                                    } else if (pilihHsbg.equals("Bangunan gedung tidak bertingkat (Rp. 12.000 permeter persegi)")) {
                                                        //menutup view yang tidak diperlukan
                                                        hasilHitung.setText("");

                                                        //membuka view yang diperlukan
                                                        tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                String lvNull = inputLV.getText().toString();
                                                                String ItINull = inputItI.getText().toString();

                                                                if(TextUtils.isEmpty(lvNull)) {
                                                                    inputLV.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }
                                                                if (TextUtils.isEmpty(ItINull)){
                                                                    inputItI.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }

                                                                String strlv = inputLV.getText().toString();
                                                                String strIt = inputItI.getText().toString();
                                                                double lv = Double.parseDouble(strlv);
                                                                double It = Double.parseDouble(strIt);

                                                                String hasil = String.valueOf(lv * It * 0.65 * 12000);
                                                                hasilHitung.setText(hasil);
                                                                keterangan.setText(R.string.ket_renovasi_gedung);
                                                            }
                                                        });

                                                    } else if (pilihHsbg.equals("Bangunan gedung bertingkat (Rp. 18.000 permeter persegi)")) {
                                                        //menutup view yang tidak diperlukan
                                                        hasilHitung.setText("");

                                                        //membuka view yang diperlukan
                                                        tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                String lvNull = inputLV.getText().toString();
                                                                String ItINull = inputItI.getText().toString();

                                                                if(TextUtils.isEmpty(lvNull)) {
                                                                    inputLV.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }
                                                                if (TextUtils.isEmpty(ItINull)){
                                                                    inputItI.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }

                                                                String strlv = inputLV.getText().toString();
                                                                String strIt = inputItI.getText().toString();
                                                                double lv = Double.parseDouble(strlv);
                                                                double It = Double.parseDouble(strIt);

                                                                String hasil = String.valueOf(lv * It * 0.65 * 18000);
                                                                hasilHitung.setText(hasil);
                                                                keterangan.setText(R.string.ket_renovasi_gedung);
                                                            }
                                                        });
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

                            }else if (pilihIMB.equals("Retribusi pembangunan bukan gedung baru atau prasarana bangunan gedung")){
                                lv.setText("V");
                                inputLV.setText("");
                                ItI.setText("I");
                                inputItI.setText("");
                                indeks.setVisibility(View.VISIBLE);
                                spinTk.setVisibility(View.GONE);
                                spinRumput.setVisibility(View.GONE);
                                spinHsbg.setVisibility(View.GONE);
                                spinKerang.setVisibility(View.GONE);
                                spinPenangkapanIkan.setVisibility(View.GONE);
                                hasilHitung.setText("");

                                spinHsbg.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        String pilihHsbg = spinHsbg.getSelectedItem().toString();
                                        if (pilihHsbg.equals("Pilih Jenis Bangunan")) {
                                            //menutup view yang tidak diperlukan
                                            hasilHitung.setText("");
                                        } else if (pilihHsbg.equals("Bangunan gedung tidak bertingkat sederhana (Rp. 6000 permeter persegi)")) {
                                            //menutup view yang tidak diperlukan
                                            hasilHitung.setText("");

                                            //membuka view yang diperlukan
                                            tombolHasil.setOnClickListener(new View.OnClickListener() {

                                                @Override
                                                public void onClick(View v) {
                                                    String lvNull = inputLV.getText().toString();
                                                    String ItINull = inputItI.getText().toString();

                                                    if(TextUtils.isEmpty(lvNull)) {
                                                        inputLV.setError("nilai tidak boleh kosong");
                                                        return;
                                                    }
                                                    if (TextUtils.isEmpty(ItINull)){
                                                        inputItI.setError("nilai tidak boleh kosong");
                                                        return;
                                                    }

                                                    String strlv = inputLV.getText().toString();
                                                    String strItI = inputItI.getText().toString();
                                                    double lv = Double.parseDouble(strlv);
                                                    double ItI = Double.parseDouble(strItI);

                                                    String hasil = String.valueOf(lv * ItI * 1 * 6000);
                                                    hasilHitung.setText(hasil);
                                                    keterangan.setText(R.string.ket_gedung_baru);
                                                }
                                            });

                                        } else if (pilihHsbg.equals("Bangunan gedung tidak bertingkat (Rp. 12.000 permeter persegi)")) {
                                            //menutup view yang tidak diperlukan
                                            hasilHitung.setText("");

                                            //membuka view yang diperlukan
                                            tombolHasil.setOnClickListener(new View.OnClickListener() {

                                                @Override
                                                public void onClick(View v) {
                                                    String lvNull = inputLV.getText().toString();
                                                    String ItINull = inputItI.getText().toString();

                                                    if(TextUtils.isEmpty(lvNull)) {
                                                        inputLV.setError("nilai tidak boleh kosong");
                                                        return;
                                                    }
                                                    if (TextUtils.isEmpty(ItINull)){
                                                        inputItI.setError("nilai tidak boleh kosong");
                                                        return;
                                                    }

                                                    String strlv = inputLV.getText().toString();
                                                    String strItI = inputItI.getText().toString();
                                                    double lv = Double.parseDouble(strlv);
                                                    double ItI = Double.parseDouble(strItI);

                                                    String hasil = String.valueOf(lv * ItI * 1 * 12000);
                                                    hasilHitung.setText(hasil);
                                                    keterangan.setText(R.string.ket_gedung_baru);
                                                }
                                            });

                                        } else if (pilihHsbg.equals("Bangunan gedung bertingkat (Rp. 18.000 permeter persegi)")) {
                                            //menutup view yang tidak diperlukan
                                            hasilHitung.setText("");

                                            //membuka view yang diperlukan
                                            tombolHasil.setOnClickListener(new View.OnClickListener() {

                                                @Override
                                                public void onClick(View v) {
                                                    String lvNull = inputLV.getText().toString();
                                                    String ItINull = inputItI.getText().toString();

                                                    if(TextUtils.isEmpty(lvNull)) {
                                                        inputLV.setError("nilai tidak boleh kosong");
                                                        return;
                                                    }
                                                    if (TextUtils.isEmpty(ItINull)){
                                                        inputItI.setError("nilai tidak boleh kosong");
                                                        return;
                                                    }

                                                    String strlv = inputLV.getText().toString();
                                                    String strItI = inputItI.getText().toString();
                                                    double lv = Double.parseDouble(strlv);
                                                    double ItI = Double.parseDouble(strItI);

                                                    String hasil = String.valueOf(lv * ItI * 1 * 18000);
                                                    hasilHitung.setText(hasil);
                                                    keterangan.setText(R.string.ket_gedung_baru);
                                                }
                                            });
                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {

                                    }
                                });
                            }else if(pilihIMB.equals("Retribusi rehabilitasi prasarana bangunan gedung")){
                                //menutup view yang tidak diperlukan
                                lv.setText("V");
                                inputLV.setText("");
                                ItI.setText("I");
                                inputItI.setText("");
                                indeks.setVisibility(View.GONE);
                                hasilHitung.setText("");
                                spinRumput.setVisibility(View.GONE);
                                spinHsbg.setVisibility(View.GONE);
                                spinKerang.setVisibility(View.GONE);
                                spinPenangkapanIkan.setVisibility(View.GONE);

                                //membuka view yang diperlukan
                                spinTk.setVisibility(View.VISIBLE);

                                spinTk.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        String pilihTk = spinTk.getSelectedItem().toString();
                                        if (pilihTk.equals("Pilih tingkat kerusakan")){
                                            hasilHitung.setText("");
                                            inputLV.setText("");
                                            inputItI.setText("");
                                        }
                                        else if (pilihTk.equals("0.45")){
                                            //menutup view yang tidak diperlukan
                                            hasilHitung.setText(null);

                                            //membuka view yang diperlukan
                                            spinHsbg.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                @Override
                                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                    String pilihHsbg = spinHsbg.getSelectedItem().toString();

                                                    if (pilihHsbg.equals("Pilih Jenis Bangunan")){
                                                        hasilHitung.setText("");

                                                    }else if (pilihHsbg.equals("Bangunan gedung tidak bertingkat sederhana (Rp. 6000 permeter persegi)")){
                                                        //menutup view yang tidak diperlukan
                                                        hasilHitung.setText("");

                                                        //membuka view yang diperlukan
                                                        tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                String lvNull = inputLV.getText().toString();
                                                                String ItINull = inputItI.getText().toString();

                                                                if(TextUtils.isEmpty(lvNull)) {
                                                                    inputLV.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }
                                                                if (TextUtils.isEmpty(ItINull)){
                                                                    inputItI.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }

                                                                String strlv = inputLV.getText().toString();
                                                                String strIt = inputItI.getText().toString();
                                                                double lv = Double.parseDouble(strlv);
                                                                double It = Double.parseDouble(strIt);

                                                                String hasil = String.valueOf(lv * It * 0.45 * 6000);
                                                                hasilHitung.setText(hasil);
                                                                keterangan.setText(R.string.ket_renovasi_gedung);
                                                            }
                                                        });
                                                    }else if (pilihHsbg.equals("Bangunan gedung tidak bertingkat (Rp. 12.000 permeter persegi)")){
                                                        //menutup view yang tidak diperlukan
                                                        hasilHitung.setText("");

                                                        //membuka view yang diperlukan
                                                        tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                String lvNull = inputLV.getText().toString();
                                                                String ItINull = inputItI.getText().toString();

                                                                if(TextUtils.isEmpty(lvNull)) {
                                                                    inputLV.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }
                                                                if (TextUtils.isEmpty(ItINull)){
                                                                    inputItI.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }

                                                                String strlv = inputLV.getText().toString();
                                                                String strIt = inputItI.getText().toString();
                                                                double lv = Double.parseDouble(strlv);
                                                                double It = Double.parseDouble(strIt);

                                                                String hasil = String.valueOf(lv * It * 0.45 * 12000);
                                                                hasilHitung.setText(hasil);
                                                                keterangan.setText(R.string.ket_renovasi_gedung);
                                                            }
                                                        });

                                                    }else if (pilihHsbg.equals("Bangunan gedung bertingkat (Rp. 18.000 permeter persegi)")){
                                                        //menutup view yang tidak diperlukan
                                                        hasilHitung.setText("");

                                                        //membuka view yang diperlukan
                                                        tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                String lvNull = inputLV.getText().toString();
                                                                String ItINull = inputItI.getText().toString();

                                                                if(TextUtils.isEmpty(lvNull)) {
                                                                    inputLV.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }
                                                                if (TextUtils.isEmpty(ItINull)){
                                                                    inputItI.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }

                                                                String strlv = inputLV.getText().toString();
                                                                String strIt = inputItI.getText().toString();
                                                                double lv = Double.parseDouble(strlv);
                                                                double It = Double.parseDouble(strIt);

                                                                String hasil = String.valueOf(lv * It * 0.45 * 12000);
                                                                hasilHitung.setText(hasil);
                                                                keterangan.setText(R.string.ket_renovasi_gedung);
                                                            }
                                                        });
                                                    }
                                                }

                                                @Override
                                                public void onNothingSelected(AdapterView<?> parent) {

                                                }
                                            });
                                        }else if (pilihTk.equals("0.65")){
                                            hasilHitung.setText(null);
                                            spinHsbg.getSelectedItem().equals("Pilih Jenis Bangunan");

                                            spinHsbg.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                @Override
                                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                    final String pilihHsbg = spinHsbg.getSelectedItem().toString();

                                                    if (pilihHsbg.equals("Pilih Jenis Bangunan")) {
                                                        hasilHitung.setText("");

                                                    } else if (pilihHsbg.equals("Bangunan gedung tidak bertingkat sederhana (Rp. 6000 permeter persegi)")) {
                                                        //menutup view yang tidak diperlukan
                                                        hasilHitung.setText("");

                                                        //membuka view yang diperlukan
                                                        tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                String lvNull = inputLV.getText().toString();
                                                                String ItINull = inputItI.getText().toString();

                                                                if(TextUtils.isEmpty(lvNull)) {
                                                                    inputLV.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }
                                                                if (TextUtils.isEmpty(ItINull)){
                                                                    inputItI.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }

                                                                String strlv = inputLV.getText().toString();
                                                                String strIt = inputItI.getText().toString();
                                                                double lv = Double.parseDouble(strlv);
                                                                double It = Double.parseDouble(strIt);

                                                                String hasil = String.valueOf(lv * It * 0.65 * 6000);
                                                                hasilHitung.setText(hasil);
                                                                keterangan.setText(R.string.ket_renovasi_gedung);
                                                            }
                                                        });
                                                    } else if (pilihHsbg.equals("Bangunan gedung tidak bertingkat (Rp. 12.000 permeter persegi)")) {
                                                        //menutup view yang tidak diperlukan
                                                        hasilHitung.setText("");

                                                        //membuka view yang diperlukan
                                                        tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                String lvNull = inputLV.getText().toString();
                                                                String ItINull = inputItI.getText().toString();

                                                                if(TextUtils.isEmpty(lvNull)) {
                                                                    inputLV.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }
                                                                if (TextUtils.isEmpty(ItINull)){
                                                                    inputItI.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }

                                                                String strlv = inputLV.getText().toString();
                                                                String strIt = inputItI.getText().toString();
                                                                double lv = Double.parseDouble(strlv);
                                                                double It = Double.parseDouble(strIt);

                                                                String hasil = String.valueOf(lv * It * 0.65 * 12000);
                                                                hasilHitung.setText(hasil);
                                                                keterangan.setText(R.string.ket_renovasi_gedung);
                                                            }
                                                        });

                                                    } else if (pilihHsbg.equals("Bangunan gedung bertingkat (Rp. 18.000 permeter persegi)")) {
                                                        //menutup view yang tidak diperlukan
                                                        hasilHitung.setText("");

                                                        //membuka view yang diperlukan
                                                        tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                String lvNull = inputLV.getText().toString();
                                                                String ItINull = inputItI.getText().toString();

                                                                if(TextUtils.isEmpty(lvNull)) {
                                                                    inputLV.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }
                                                                if (TextUtils.isEmpty(ItINull)){
                                                                    inputItI.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }

                                                                String strlv = inputLV.getText().toString();
                                                                String strIt = inputItI.getText().toString();
                                                                double lv = Double.parseDouble(strlv);
                                                                double It = Double.parseDouble(strIt);

                                                                String hasil = String.valueOf(lv * It * 0.65 * 18000);
                                                                hasilHitung.setText(hasil);
                                                                keterangan.setText(R.string.ket_renovasi_gedung);
                                                            }
                                                        });
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
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
                else if (pilihIzin.equals("Izin Usaha Perikanan")){

                    //menutup view yang tidak diperlukan
                    llpertama.setVisibility(View.GONE);
                    ketTenagaKerja.setVisibility(View.GONE);
                    llkedua.setVisibility(View.GONE);
                    spinRumput.setVisibility(View.GONE);
                    spinHsbg.setVisibility(View.GONE);
                    spinKerang.setVisibility(View.GONE);
                    spinPenangkapanIkan.setVisibility(View.GONE);
                    hasilHitung.setText("");

                    //membuka view yang diperlukan
                    jenisPerikanan.setVisibility(View.VISIBLE);

                    jenisPerikanan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String pilihPerikanan = jenisPerikanan.getSelectedItem().toString();

                    if (pilihPerikanan.equals("Pilih jenis perikanan")){
                        perikananTawar.setVisibility(View.GONE);
                        perikananPayau.setVisibility(View.GONE);
                        teksLuas.setVisibility(View.GONE);
                        inputLuas.setVisibility(View.GONE);
                        hasilHitung.setText("");
                        spinRumput.setVisibility(View.GONE);
                        spinHsbg.setVisibility(View.GONE);
                        spinKerang.setVisibility(View.GONE);
                        spinPenangkapanIkan.setVisibility(View.GONE);

                    }else if (pilihPerikanan.equals("Ikan air tawar")){
                        //menutup view yang tidak diperlukan
                        perikananPayau.setVisibility(View.GONE);
                        hasilHitung.setText("");
                        teksLuas.setVisibility(View.GONE);
                        inputLuas.setVisibility(View.GONE);

                        //membuka view yang diperlukan
                        perikananTawar.setVisibility(View.VISIBLE);
                        perikananTawar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                String pilihTawar = perikananTawar.getSelectedItem().toString();
                                if (pilihTawar.equals("Pilih metode perikanan air tawar")){
                                    perikananPayau.setVisibility(View.GONE);
                                    hasilHitung.setText("");
                                    teksLuas.setVisibility(View.GONE);
                                    inputLuas.setVisibility(View.GONE);


                                }else if (pilihTawar.equals("Pembenihan ikan dengan luas 0,75 ha atau lebih")){
                                    //menutup view yang tidak diperlukan
                                    perikananPayau.setVisibility(View.GONE);
                                    hasilHitung.setText("");

                                    //membuka view yang diperlukan
                                    teksLuas.setVisibility(View.VISIBLE);
                                    inputLuas.setVisibility(View.VISIBLE);
                                    teksLuas.setText(R.string.luas_lahan);
                                    inputLuas.setText("");
                                    tombolHasil.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            String luasNull = inputLuas.getText().toString();

                                            if(TextUtils.isEmpty(luasNull)) {
                                                inputLuas.setError("nilai tidak boleh kosong");
                                                return;
                                            }

                                            String strLuas = inputLuas.getText().toString();
                                            double luas = Double.parseDouble(strLuas);

                                            String hasil = String.valueOf(100000 * luas);
                                            hasilHitung.setText(hasil);
                                            keterangan.setText(R.string.ket_tawar1);
                                        }
                                    });

                                }else if (pilihTawar.equals("Pembenihan ikan dengan luas 2 ha atau lebih")){
                                    //menutup view yang tidak diperlukan
                                    perikananPayau.setVisibility(View.GONE);
                                    hasilHitung.setText("");

                                    //membuka view yang diperlukan
                                    teksLuas.setVisibility(View.VISIBLE);
                                    inputLuas.setVisibility(View.VISIBLE);
                                    teksLuas.setText(R.string.luas_lahan);
                                    inputLuas.setText("");
                                    tombolHasil.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            String luasNull = inputLuas.getText().toString();

                                            if(TextUtils.isEmpty(luasNull)) {
                                                inputLuas.setError("nilai tidak boleh kosong");
                                                return;
                                            }

                                            String strLuas = inputLuas.getText().toString();
                                            double luas = Double.parseDouble(strLuas);

                                            String hasil = String.valueOf(100000 * luas);
                                            hasilHitung.setText(hasil);
                                            keterangan.setText(R.string.ket_tawar2);
                                        }
                                    });
                                }else if (pilihTawar.equals("Pembenihan ikan lebih dari 5 unit")){
                                    //menutup view yang tidak diperlukan
                                    perikananPayau.setVisibility(View.GONE);
                                    hasilHitung.setText("");


                                    //membuka view yang diperlukan
                                    teksLuas.setVisibility(View.VISIBLE);
                                    inputLuas.setVisibility(View.VISIBLE);
                                    teksLuas.setText(R.string.luas_unit);
                                    inputLuas.setText("");
                                    tombolHasil.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            String luasNull = inputLuas.getText().toString();

                                            if(TextUtils.isEmpty(luasNull)) {
                                                inputLuas.setError("nilai tidak boleh kosong");
                                                return;
                                            }

                                            String strLuas = inputLuas.getText().toString();
                                            double luas = Double.parseDouble(strLuas);

                                            String hasil = String.valueOf(150*luas);
                                            hasilHitung.setText(hasil);
                                            keterangan.setText(R.string.ket_tawar3);
                                        }
                                    });
                                }else if (pilihTawar.equals("Usaha keramba jaring apung lebih dari 4 unit")){
                                    //menutup view yang tidak diperlukan
                                    perikananPayau.setVisibility(View.GONE);
                                    hasilHitung.setText("");

                                    //membuka view yang diperlukan
                                    teksLuas.setVisibility(View.VISIBLE);
                                    inputLuas.setVisibility(View.VISIBLE);
                                    teksLuas.setText(R.string.luas_unit);
                                    inputLuas.setText("");
                                    tombolHasil.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            String luasNull = inputLuas.getText().toString();

                                            if(TextUtils.isEmpty(luasNull)) {
                                                inputLuas.setError("nilai tidak boleh kosong");
                                                return;
                                            }

                                            String strLuas = inputLuas.getText().toString();
                                            double luas = Double.parseDouble(strLuas);

                                            String hasil = String.valueOf(15000*luas);
                                            hasilHitung.setText(hasil);
                                            keterangan.setText(R.string.ket_tawar4);
                                        }
                                    });
                                }else if (pilihTawar.equals("Usaha keramba lebih dari 50 unit")){
                                    //menutup view yang tidak diperlukan
                                    hasilHitung.setText("");

                                    //membuka view yang diperlukan
                                    teksLuas.setVisibility(View.VISIBLE);
                                    inputLuas.setVisibility(View.VISIBLE);
                                    teksLuas.setText(R.string.luas_unit);
                                    inputLuas.setText("");
                                    tombolHasil.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            String luasNull = inputLuas.getText().toString();

                                            if(TextUtils.isEmpty(luasNull)) {
                                                inputLuas.setError("nilai tidak boleh kosong");
                                                return;
                                            }

                                            String strLuas = inputLuas.getText().toString();
                                            double luas = Double.parseDouble(strLuas);

                                            String hasil = String.valueOf(150*luas);
                                            hasilHitung.setText(hasil);
                                            keterangan.setText(R.string.ket_tawar5);
                                        }
                                    });
                                }
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                    }else if (pilihPerikanan.equals("Ikan air payau")){
                        //menutup view yang tidak diperlukan
                        perikananTawar.setVisibility(View.GONE);
                        teksLuas.setVisibility(View.GONE);
                        inputLuas.setVisibility(View.GONE);
                        hasilHitung.setText("");

                        //membuka view yang diperlukan
                        perikananPayau.setVisibility(View.VISIBLE);
                        perikananPayau.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                final String pilihPayau = perikananPayau.getSelectedItem().toString();
                                if (pilihPayau.equals("Pilih metode perikanan air payau")){
                                    //menutup view yang tidak diperlukan
                                    spinRumput.setVisibility(View.GONE);
                                    inputLuas.setVisibility(View.GONE);
                                    teksLuas.setVisibility(View.GONE);
                                    hasilHitung.setText("");

                                }else if (pilihPayau.equals("Pembenihan ikan dengan luas 0,5 ha atau lebih")){
                                    //menutup view yang tidak diperlukan
                                    spinRumput.setVisibility(View.GONE);
                                    hasilHitung.setText("");

                                    //membuka view yang tidak digunakan
                                    teksLuas.setVisibility(View.VISIBLE);
                                    inputLuas.setVisibility(View.VISIBLE);
                                    teksLuas.setText(R.string.luas_lahan);
                                    inputLuas.setText("");

                                    tombolHasil.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            String luasNull = inputLuas.getText().toString();

                                            if(TextUtils.isEmpty(luasNull)) {
                                                inputLuas.setError("nilai tidak boleh kosong");
                                                return;
                                            }

                                            String strLuas = inputLuas.getText().toString();
                                            double luas = Double.parseDouble(strLuas);

                                            String hasil = String.valueOf(100000*luas);
                                            hasilHitung.setText(hasil);
                                            keterangan.setText(R.string.ket_payau1);
                                        }
                                    });
                                }else if (pilihPayau.equals("Pembesaran ikan dengan luas 5 ha atau lebih")){
                                    //menutup view yang tidak diperlukan
                                    spinRumput.setVisibility(View.GONE);
                                    hasilHitung.setText("");

                                    //membuka view yang tidak digunakan
                                    teksLuas.setVisibility(View.VISIBLE);
                                    inputLuas.setVisibility(View.VISIBLE);
                                    teksLuas.setText(R.string.luas_lahan);
                                    inputLuas.setText("");

                                    tombolHasil.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            String luasNull = inputLuas.getText().toString();

                                            if(TextUtils.isEmpty(luasNull)) {
                                                inputLuas.setError("nilai tidak boleh kosong");
                                                return;
                                            }

                                            String strLuas = inputLuas.getText().toString();
                                            double luas = Double.parseDouble(strLuas);

                                            String hasil = String.valueOf(100000*luas);
                                            hasilHitung.setText(hasil);
                                            keterangan.setText(R.string.ket_payau2);
                                        }
                                    });
                                }else if (pilihPayau.equals("Pembudidayaan rumput laut")){
                                    //menutup view yang tidak diperlukan
                                    spinKerang.setVisibility(View.GONE);
                                    hasilHitung.setText("");

                                    //membuka view yang dibutuhkan
                                    spinRumput.setVisibility(View.VISIBLE);
                                    spinRumput.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                        @Override
                                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                            String pilihRumput = spinRumput.getSelectedItem().toString();
                                            if (pilihRumput.equals("pilih metode budidaya rumput laut")) {
                                                //menutup view yang tidak diperlukan
                                                hasilHitung.setText("");
                                                teksLuas.setVisibility(View.GONE);
                                                inputLuas.setVisibility(View.GONE);

                                            } else if (pilihRumput.equals("Lepas dasar")) {
                                                //menutup view yang tidak diperlukan
                                                hasilHitung.setText("");

                                                //membuka view yang diperlukan
                                                teksLuas.setVisibility(View.VISIBLE);
                                                inputLuas.setVisibility(View.VISIBLE);
                                                teksLuas.setText(R.string.luas_lepas_dasar);
                                                inputLuas.setText("");

                                                tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        String luasNull = inputLuas.getText().toString();

                                                        if(TextUtils.isEmpty(luasNull)) {
                                                            inputLuas.setError("nilai tidak boleh kosong");
                                                            return;
                                                        }

                                                        String strLuas = inputLuas.getText().toString();
                                                        double luas = Double.parseDouble(strLuas);

                                                        String hasil = String.valueOf(5 * luas);
                                                        hasilHitung.setText(hasil);
                                                        keterangan.setText(R.string.ket_rumput_lepas);
                                                    }
                                                });
                                            } else if (pilihRumput.equals("Rakit apung")) {
                                                //menutup view yang tidak diperlukan

                                                //membuka view yang tidak digunakan
                                                teksLuas.setVisibility(View.VISIBLE);
                                                inputLuas.setVisibility(View.VISIBLE);
                                                teksLuas.setText(R.string.luas_usaha_rakit_apung);
                                                inputLuas.setText("");

                                                tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        String luasNull = inputLuas.getText().toString();

                                                        if(TextUtils.isEmpty(luasNull)) {
                                                            inputLuas.setError("nilai tidak boleh kosong");
                                                            return;
                                                        }

                                                        String strLuas = inputLuas.getText().toString();
                                                        double luas = Double.parseDouble(strLuas);

                                                        String hasil = String.valueOf(5*luas);
                                                        hasilHitung.setText(hasil);
                                                        keterangan.setText(R.string.ket_rumput_rakit);
                                                    }
                                                });
                                            } else if (pilihRumput.equals("Long line")) {
                                                //menutup view yang tidak diperlukan

                                                //membuka view yang tidak digunakan
                                                teksLuas.setVisibility(View.VISIBLE);
                                                inputLuas.setVisibility(View.VISIBLE);
                                                teksLuas.setText(R.string.luas_longline);
                                                inputLuas.setText("");

                                                tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        String luasNull = inputLuas.getText().toString();

                                                        if(TextUtils.isEmpty(luasNull)) {
                                                            inputLuas.setError("nilai tidak boleh kosong");
                                                            return;
                                                        }

                                                        String strLuas = inputLuas.getText().toString();
                                                        double luas = Double.parseDouble(strLuas);

                                                        String hasil = String.valueOf(50000*luas);
                                                        hasilHitung.setText(hasil);
                                                        keterangan.setText(R.string.ket_rumput_longline);
                                                    }
                                                });
                                            }
                                        }

                                        @Override
                                        public void onNothingSelected(AdapterView<?> parent) {

                                        }
                                    });
                                }
                                        else if (pilihPayau.equals("Usaha kerang hijau")){
                                    //menutup view yang tidak diperlukan
                                    spinRumput.setVisibility(View.GONE);
                                    teksLuas.setVisibility(View.GONE);
                                    inputLuas.setVisibility(View.GONE);
                                    hasilHitung.setText("");

                                    //membuka view yang diperlukan
                                    spinKerang.setVisibility(View.VISIBLE);
                                    spinKerang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                        @Override
                                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                            String pilihKerang = spinKerang.getSelectedItem().toString();

                                            if (pilihKerang.equals("pilih metode usaha kerang hijau")){
                                                //menutup view yang tidak diperlukan
                                                inputLuas.setVisibility(View.GONE);
                                                teksLuas.setVisibility(View.GONE);
                                                hasilHitung.setText("");

                                            }else if (pilihKerang.equals("Rakit apung atau rakit tancap")){
                                                //menutup view yang tidak diperlukan
                                                hasilHitung.setText("");
                                                inputLuas.setText("");

                                                //membuka view yang tidak digunakan
                                                inputLuas.setVisibility(View.VISIBLE);
                                                teksLuas.setVisibility(View.VISIBLE);
                                                teksLuas.setText(R.string.luas_usaha_rakit_apung);
                                                inputLuas.setText("");

                                                tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        String luasNull = inputLuas.getText().toString();

                                                        if(TextUtils.isEmpty(luasNull)) {
                                                            inputLuas.setError("nilai tidak boleh kosong");
                                                            return;
                                                        }

                                                        String strLuas = inputLuas.getText().toString();
                                                        double luas = Double.parseDouble(strLuas);

                                                        String hasil = String.valueOf(5*luas);
                                                        hasilHitung.setText(hasil);
                                                        keterangan.setText(R.string.ket_kerang_rakit);
                                                    }
                                                });

                                            }else if(pilihKerang.equals("Long line")){
                                                //menutup view yang tidak diperlukan
                                                inputLuas.setText("");
                                                hasilHitung.setText("");

                                                //membuka view yang tidak digunakan
                                                inputLuas.setVisibility(View.VISIBLE);
                                                teksLuas.setVisibility(View.VISIBLE);
                                                teksLuas.setText(R.string.luas_longline);
                                                inputLuas.setText("");

                                                tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        String luasNull = inputLuas.getText().toString();

                                                        if(TextUtils.isEmpty(luasNull)) {
                                                            inputLuas.setError("nilai tidak boleh kosong");
                                                            return;
                                                        }

                                                        String strLuas = inputLuas.getText().toString();
                                                        double luas = Double.parseDouble(strLuas);

                                                        String hasil = String.valueOf(10*luas);
                                                        hasilHitung.setText(hasil);
                                                        keterangan.setText(R.string.ket_rumput_longline);
                                                    }
                                                });

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


                    }else if (pilihPerikanan.equals("Usaha perikanan penangkapan ikan")){
                        //menutup view yang tidak diperlukan
                        perikananTawar.setVisibility(View.GONE);
                        perikananPayau.setVisibility(View.GONE);
                        teksLuas.setVisibility(View.GONE);
                        inputLuas.setVisibility(View.GONE);
                        hasilHitung.setText("");

                        spinPenangkapanIkan.setVisibility(View.VISIBLE);
                        spinPenangkapanIkan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                String pilihKapal = spinPenangkapanIkan.getSelectedItem().toString();

                                if (pilihKapal.equals("Pilih metode penangkapan ikan")){
                                    //menutup view yang tidak diperlukan
                                    teksLuas.setVisibility(View.GONE);
                                    inputLuas.setVisibility(View.GONE);
                                    hasilHitung.setText("");

                                }else if (pilihKapal.equals("penangkapan ikan dengan kapal bobot dibawah 5 GT")){
                                    //menutup view yang tidak diperlukan
                                    hasilHitung.setText("");
                                    inputLuas.setText("");

                                    //membuka view yang tidak digunakan
                                    inputLuas.setVisibility(View.VISIBLE);
                                    teksLuas.setVisibility(View.VISIBLE);
                                    teksLuas.setText(R.string.jumlah_kapal);
                                    inputLuas.setText("");

                                    tombolHasil.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            String kapalNull = inputLuas.getText().toString();

                                            if(TextUtils.isEmpty(kapalNull)) {
                                                inputLuas.setError("nilai tidak boleh kosong");
                                                return;
                                            }

                                            String strKapal = inputLuas.getText().toString();
                                            double kapal = Double.parseDouble(strKapal);

                                            String hasil = String.valueOf(40000 * kapal);
                                            hasilHitung.setText(hasil);
                                            keterangan.setText(R.string.ket_ikan_kapal);
                                        }
                                    });
                                }else if (pilihKapal.equals("Rawe (long line) dan gill net")){
                                    //menutup view yang tidak diperlukan
                                    hasilHitung.setText("");
                                    inputLuas.setText("");

                                    //membuka view yang tidak digunakan
                                    inputLuas.setVisibility(View.VISIBLE);
                                    teksLuas.setVisibility(View.VISIBLE);
                                    teksLuas.setText(R.string.jumlah_kapal_tahun);
                                    inputLuas.setText("");

                                    tombolHasil.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            String kapalNull = inputLuas.getText().toString();

                                            if(TextUtils.isEmpty(kapalNull)) {
                                                inputLuas.setError("nilai tidak boleh kosong");
                                                return;
                                            }

                                            String strKapal = inputLuas.getText().toString();
                                            double kapal = Double.parseDouble(strKapal);

                                            String hasil = String.valueOf(30000 * kapal);
                                            hasilHitung.setText(hasil);
                                            keterangan.setText(R.string.ket_ikan_longline);
                                        }
                                    });
                                }else if (pilihKapal.equals("mini purse seine")){
                                    //menutup view yang tidak diperlukan
                                    hasilHitung.setText("");
                                    inputLuas.setText("");

                                    //membuka view yang tidak digunakan
                                    inputLuas.setVisibility(View.VISIBLE);
                                    teksLuas.setVisibility(View.VISIBLE);
                                    teksLuas.setText(R.string.jumlah_kapal_tahun);
                                    inputLuas.setText("");

                                    tombolHasil.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            String kapalNull = inputLuas.getText().toString();

                                            if(TextUtils.isEmpty(kapalNull)) {
                                                inputLuas.setError("nilai tidak boleh kosong");
                                                return;
                                            }

                                            String strKapal = inputLuas.getText().toString();
                                            double kapal = Double.parseDouble(strKapal);

                                            String hasil = String.valueOf(35000 * kapal);
                                            hasilHitung.setText(hasil);
                                            keterangan.setText(R.string.ket_ikan_purse);
                                        }
                                    });
                                }else if (pilihKapal.equals("alat lainnya dengan bobot kapal dibawah 5 GT")){
                                    //menutup view yang tidak diperlukan
                                    hasilHitung.setText("");
                                    inputLuas.setText("");

                                    //membuka view yang tidak digunakan
                                    inputLuas.setVisibility(View.VISIBLE);
                                    teksLuas.setVisibility(View.VISIBLE);
                                    teksLuas.setText(R.string.jumlah_kapal_tahun);
                                    inputLuas.setText("");

                                    tombolHasil.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            String kapalNull = inputLuas.getText().toString();

                                            if(TextUtils.isEmpty(kapalNull)) {
                                                inputLuas.setError("nilai tidak boleh kosong");
                                                return;
                                            }

                                            String strKapal = inputLuas.getText().toString();
                                            double kapal = Double.parseDouble(strKapal);

                                            String hasil = String.valueOf(25000 * kapal);
                                            hasilHitung.setText(hasil);
                                            keterangan.setText(R.string.ket_ikan_other);
                                        }
                                    });
                                }
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });

                    }else if (pilihPerikanan.equals("Usaha kapal pengangkutan ikan")){
                        hasilHitung.setText("");
                        teksLuas.setVisibility(View.VISIBLE);
                        teksLuas.setText(R.string.jumlah_kapal);
                        inputLuas.setVisibility(View.VISIBLE);
                        inputLuas.setText("");

                        tombolHasil.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String kapalNull = inputLuas.getText().toString();

                                if(TextUtils.isEmpty(kapalNull)) {
                                    inputLuas.setError("nilai tidak boleh kosong");
                                    return;
                                }

                                String strKapal = inputLuas.getText().toString();
                                double kapal = Double.parseDouble(strKapal);

                                String hasil = String.valueOf(40000 * kapal);
                                hasilHitung.setText(hasil);
                                keterangan.setText(R.string.ket_pengangkutan_ikan);
                            }
                        });
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