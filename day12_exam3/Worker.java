	public abstract class Worker {
		
		
		private int id;
		private String nama;
		private int gajiPokok;
		private int absensi;
		private int jumlahCuti;
		private int tanpaKabar;
		
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
			if((this.absensi+this.jumlahCuti+tanpaKabar) <=22) {
				return this.absensi += absen;
			}else {
				this.absensi = 0;
				this.jumlahCuti = 0;
				this.tanpaKabar = 0;
				return this.absensi += absen;
			}
		}
		
		public int getJumlahCuti() {
			int cuti = 1;
			if(this.jumlahCuti>1) {
				this.tanpaKabar = this.jumlahCuti-cuti;
			}
			return cuti;
		}
		
		public int setJumlahCuti() {
			int cuti = 1;
			return this.jumlahCuti+=cuti;
			
		}
		
		public int getTanpaKabar() {
			return tanpaKabar;
		}
		
		public abstract int hitungGajiPokok();
		
		

	

	
}
