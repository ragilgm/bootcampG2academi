public class Staff extends Worker{



	public Staff(int id, String nama, int gajiPokok, int absensi, int jumlahCuti) {
		super(id, nama, gajiPokok, absensi, jumlahCuti);
	}


	private int tMakan;
	private int tTransport;
	private int tGaji;
	

	public int gettMakan() {
		return tMakan;
	}

	public int HitungTunjanganMakan() {
		int tunjangan = 220000;
		if(getTanpaKabar()>0) {
			return tunjangan-(tunjangan/22)*getTanpaKabar();
		}
		return tunjangan;
	}


	public int gettTransport() {
		return tTransport;
	}


	public int HitungTunjanganTransport() {
		int tunjangan = 440000;
		if(getTanpaKabar()>0) {
		return tunjangan-(tunjangan/22)*getTanpaKabar();
		}else {
		return tunjangan;
		}

	}


	public int gettGaji() {
		return tGaji;
	}

	public int hitungTotalGaji() {
		return HitungTunjanganMakan()+HitungTunjanganTransport()+hitungGajiPokok();
	}

	@Override
	public int hitungGajiPokok() {
		return (getGajiPokok()/22)*getAbsensi();
	}

}
