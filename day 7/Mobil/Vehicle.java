public class Vehicle {
	
	private String warna;
	private String merek;
	private String jenis;
	private String Keluaran;
	
	public Vehicle(String warna, String merek, String jenis, String keluaran) {
		this.warna = warna;
		this.merek = merek;
		this.jenis = jenis;
		this.Keluaran = keluaran;
	}
	
	public Vehicle() {
	}

	public String getWarna() {
		return warna;
	}

	public void setWarna(String warna) {
		this.warna = warna;
	}

	public String getMerek() {
		return merek;
	}

	public void setMerek(String merek) {
		this.merek = merek;
	}

	public String getJenis() {
		return jenis;
	}

	public void setJenis(String jenis) {
		this.jenis = jenis;
	}

	public String getKeluaran() {
		return Keluaran;
	}

	public void setKeluaran(String keluaran) {
		Keluaran = keluaran;
	}
	

}
