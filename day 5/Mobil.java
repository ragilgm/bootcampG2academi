public class Mobil {
private String merek;
private String warna;
private String tahunPembuatan;

public Mobil(String merek, String warna, String tahunPembuatan) {
	this.merek = merek;
	this.warna = warna;
	this.tahunPembuatan = tahunPembuatan;
}

public String getMerek() {
	return merek;
}
public void setMerek(String merek) {
	this.merek = merek;
}
public String getWarna() {
	return warna;
}
public void setWarna(String warna) {
	this.warna = warna;
}
public String getTahunPembuatan() {
	return tahunPembuatan;
}
public void setTahunPembuatan(String tahunPembuatan) {
	this.tahunPembuatan = tahunPembuatan;
}


}
