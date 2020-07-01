public class Staff extends Worker{
	
	protected int tunjanganMakan;
	

	public Staff(int idKaryawan, String nama) {
		super(idKaryawan, nama);
		hitungTunjanganMakan();
	}

	public int getTunjanganMakan() {
		return tunjanganMakan;
	}

	public int hitungTunjanganMakan() {
		tunjanganMakan = 200000;
		if(super.absensi < 30) {
			return (tunjanganMakan/30)*super.absensi;
		}else{
			return tunjanganMakan;
		}
	}

	@Override
	public int setAbsensi() {
		int counter = 1;
		if(super.absensi < 30) {
			return super.absensi = super.absensi + counter;
		}else if(super.absensi ==1){
			return super.absensi += counter;
		}else {
			return counter;
		}
				
	}



}
