package Karyawan;

	public abstract class Worker {
		
		
		private int id;
		private String nama;
		private int gajiPokok;
		private int absensi;
		private int jumlahCuti;
		private int tanpaKabar;
		private int day = 20;
		
		public Worker(int id, String nama, int gajiPokok, int absensi, int jumlahCuti) {
			this.id = id;
			this.nama = nama;
			this.gajiPokok = gajiPokok;
			this.absensi = absensi;
			this.jumlahCuti = jumlahCuti;
			this.tanpaKabar = getTanpaKabar();
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
		public int setAbsensi(int absen) {
			if((this.day) <=0) {
				this.day = this.day - absen;
				return this.absensi += absen;
			}else {
				return this.day = 20;
			}
		}
		
		public int getJumlahCuti() {
			int cuti = 1;	
			if(this.jumlahCuti>1) {
				this.tanpaKabar = this.jumlahCuti-cuti;
			}
			return cuti;
		}
		
		public int setJumlahCuti(int cuti) {
			this.day = this.day-cuti;
			return this.jumlahCuti+=cuti;
		}
		
		public int getTanpaKabar() {
			return tanpaKabar;
		}
		
		public void setTanpaKabar(int tanpaKabar) {
			this.day = this.day-tanpaKabar;
			this.tanpaKabar = tanpaKabar;
		}

		public abstract int hitungGajiPokok();
		
		

	

	
}
