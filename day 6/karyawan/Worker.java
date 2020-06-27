public class Worker {
	
	
	private int id;
	private String nama;
	private int gajiPokok;
	private int absensi;
	private int jumlahCuti;
	
	public Worker(int id, String nama, int gajiPokok, int absensi, int jumlahCuti) {
		this.id = id;
		this.nama = nama;
		this.gajiPokok = gajiPokok;
		this.absensi = absensi;
		this.jumlahCuti = jumlahCuti;
	}
	public Worker(int id, String nama, int gajiPokok) {
		this.id = id;
		this.nama = nama;
		this.gajiPokok = gajiPokok;
	}
	
	public Worker() {
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNama() {
		return nama;
	}
	public String setNama(String nama) {
		return this.nama = nama;
	}
	public int getGajiPokok() {
		return gajiPokok;
	}
	public void setGajiPokok(int gajiPokok) {
		this.gajiPokok = gajiPokok;
	}
	
	public int getAbsensi() {
		return absensi;
	}
	public int setAbsensi(int absensi) {
		if(this.absensi < 22) {
			return this.absensi = this.absensi + absensi;
		}else {
			this.absensi = 0;
			return this.absensi = this.absensi + absensi;
		}
	}
	
	public int getJumlahCuti() {
		return jumlahCuti;
	}
	public int setJumlahCuti(int jumlahCuti) {
		if(this.absensi < 22) {
		return this.jumlahCuti = this.jumlahCuti + jumlahCuti;
		}else {
		return jumlahCuti;
		}
	}
	
	public int hitungGajiPokok() {
		int gaji = (gajiPokok/22)*absensi;
		return gaji;
	}
	
	

}
