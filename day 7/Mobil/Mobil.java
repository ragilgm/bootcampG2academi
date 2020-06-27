public class Mobil extends Vehicle {

	private int kecepatan;
	
	public Mobil(String warna, String merek, String jenis, String keluaran) {
		super(warna, merek, jenis, keluaran);
		kecepatan = 0;
	}

	public int tambahKecepatan(int tambah) {
		this.kecepatan += tambah;
		return kecepatan;
	}
	
	public int kurangiKecepatan(int kurangi) {
		this.kecepatan -= kurangi;
		return kecepatan;
	}
	
	public String Status() {
		if(kecepatan > 0) {
			return "Mobil Sedang Berjalan dengan kecepatan "+kecepatan;
		}else {
			return "Mobil Sedang Tidak Berjalan";
		}
	}

	public void printStates() {
		System.out.println(" jenis = "+getJenis()); 
		System.out.println(" Merek =  "+getMerek());
		System.out.println(" dengan warna = "+getWarna());
		System.out.println(" keluaran tahun = "+getKeluaran());
		System.out.println(" status mobil = "+Status());	   
	}
	
	
	
}
