package com.ngopi.jeneponto.data;

/**
 * Created by pranadana on 7/21/2017.
 */
public class DataProsedur {
    private String id, namaIzin, persyaratan, lamaProses, biaya, jangkaWaktu;

    public DataProsedur(){

    }

    public DataProsedur(String id, String namaIzin, String persyaratan, String lamaProses, String biaya, String jangkaWaktu){
        this.id = id;
        this.namaIzin = namaIzin;
        this.persyaratan = persyaratan;
        this.lamaProses = lamaProses;
        this.biaya = biaya;
        this.jangkaWaktu = jangkaWaktu;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaIzin() {
        return namaIzin;
    }

    public void setNamaIzin(String namaIzin) {
        this.namaIzin = namaIzin;
    }

    public String getPersyaratan() {
        return persyaratan;
    }

    public void setPersyaratan(String persyaratan) {
        this.persyaratan = persyaratan;
    }

    public String getLamaProses() {
        return lamaProses;
    }

    public void setLamaProses(String lamaProses) {
        this.lamaProses = lamaProses;
    }

    public String getBiaya() {
        return biaya;
    }

    public void setBiaya(String biaya) {
        this.biaya = biaya;
    }

    public String getJangkaWaktu() {
        return jangkaWaktu;
    }

    public void setJangkaWaktu(String jangkaWaktu) {
        this.jangkaWaktu = jangkaWaktu;
    }
}
