public abstract class Worker {

	
	protected int idKaryawan;
	protected String nama;
	protected int absensi;
	
	public Worker(int idKaryawan, String nama) {
		this.idKaryawan = idKaryawan;
		this.nama = nama;
		this.absensi = 20;
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

	public abstract int setAbsensi();
	
	public int getAbsensi() {
		return absensi;
	}
	
	

}
