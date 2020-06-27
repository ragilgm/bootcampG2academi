public class Sepeda extends Vehicle{

	private int kecepatan;

	public Sepeda(String warna, String merek, String jenis, String keluaran) {
		super(warna, merek, jenis, keluaran);
		this.kecepatan = 0;
	}
	
	public int tambahKecepatan(int tambah) {
		kecepatan += tambah;
		return kecepatan;
	}
	
	public int kurangiKecepatan(int kurangi) {
		kecepatan -= kurangi;
		return kecepatan;
	}
	
	public String Status() {
		if(kecepatan > 0) {
			return "Sepeda Sedang Berjalan dengan kecepatan "+kecepatan;
		}else {
			return "Sepeda Sedang Tidak Berjalan";
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
