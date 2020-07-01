public class Staff extends Worker{
	
	protected int tunjanganMakan;
	

	public Staff(int idKaryawan, String nama, int absensi) {
		super(idKaryawan, nama, absensi);
		hitungTungjanganPulsa();
		hitungTunjanganMakan();
	}

	public int getTunjanganMakan() {
		return tunjanganMakan;
	}

	public int hitungTunjanganMakan() {
		tunjanganMakan = 200000;
		if(this.absensi < 22) {
			return (tunjanganMakan/22)*this.absensi;
		}else{
			return tunjanganMakan;
		}
	}



}
