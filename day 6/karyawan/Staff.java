public class Staff extends Worker{
	
	private int tunjanganMakan;
	private int Transport;
	private int totalGaji;
	
	public Staff(int id, String nama, int gajiPokok, int absensi, int jumlahCuti, int tunjanganMakan, int transport,
			int totalGaji) {
		super(id, nama, gajiPokok, absensi, jumlahCuti);
		this.tunjanganMakan = tunjanganMakan;
		Transport = transport;
		this.totalGaji = totalGaji;
	}

	
	
	public Staff() {
	}

	
	public Staff(int id, String nama, int gajiPokok, int absensi, int jumlahCuti) {
		super(id, nama, gajiPokok, absensi, jumlahCuti);
	}


	public int hitungTunjanganMakan() {
		int tunjangan = 220000;
		if(getJumlahCuti() >= 1) {
			return (tunjangan/22)*getAbsensi();
		}else if(getAbsensi() <= 22){
			return (tunjangan/22)*getAbsensi();
		}else {
		return tunjangan;
		}
	}
	
	public int hitungTransport() {
		int tunjangan = 440000;
		if(getJumlahCuti() >= 1) {
			return (tunjangan/22)*getAbsensi();
		}else if (getAbsensi() <= 22) {
			return (tunjangan/22)*getAbsensi();
		}else {
		return tunjangan;
		}
	}
	
	public int hitungTotalGaji() {
		return totalGaji;
	}
	
	
	public int getTunjanganMakan() {
		return tunjanganMakan;
	}


	public int getTotalGaji() {
		return totalGaji;
	}

	public int getTunjanganTransport() {
		return Transport;
	}


}
