package com.ngopi.jeneponto;

public class ModelIzin {

	/*
	 Author : pranadana
	*/
	
	private String id;
	private String kode;
	private String namaIzin;
	private String persyaratan;
	private String lamaProses;
	private String biaya;
	private String jangkaWaktu;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKode() {
		return kode;
	}

	public void setKode(String kode) {
		this.kode = kode;
	}

	public String getNamaIzin(){
		return namaIzin;
	}

	public void setNamaIzin(String namaIzin){
		this.namaIzin = namaIzin;
	}

	public String getPersyaratan(){
		return persyaratan;
	}

	public void setPersyaratan(String persyaratan){
		this.persyaratan = persyaratan;
	}

	public String getLamaProses(){
		return lamaProses;
	}

	public void setLamaProses(String lamaProses){
		this.lamaProses = lamaProses;
	}

	public String getBiaya(){
		return biaya;
	}

	public void setBiaya(String biaya){
		this.biaya = biaya;
	}

	public String getJangkaWaktu(){
		return jangkaWaktu;
	}

	public void setJangkaWaktu(String jangkaWaktu){
		this.jangkaWaktu = jangkaWaktu;
	}
}
