public class Worker {

	
	protected int idKaryawan;
	protected String nama;
	protected int absensi;
	protected int tungjanganPulsa;
	
	public Worker(int idKaryawan, String nama, int absensi) {
		this.idKaryawan = idKaryawan;
		this.nama = nama;
		this.absensi = absensi;
	}
	
	public Worker() {

	}

	public int getIdKaryawan() {
		return idKaryawan;
	}

	public void setIdKaryawan(int idKaryawan) {
		this.idKaryawan = idKaryawan;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public int setAbsensi(int absensi) {
		if(this.absensi < 22) {
			return this.absensi = this.absensi + absensi;
		}else {
			this.absensi = 0;
			return this.absensi = this.absensi + absensi;
		}
	}
	
	public int getAbsensi() {
		return absensi;
	}

	public int hitungTungjanganPulsa() {
		int tunjangan = 100000;
		if(this.absensi < 22) {
			return (tunjangan/22)*this.absensi;
		}else{
			return this.tungjanganPulsa = tunjangan;
		}
	}
	
	public int getTungjanganPulsa() {
		return tungjanganPulsa;
	}
	
	

}
