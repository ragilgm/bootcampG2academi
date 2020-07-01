public class Manager extends Worker {
	
	protected int tunjanganTransport;
	protected int tunjanganEntertaiment;
	


	public Manager(int idKaryawan, String nama, int absensi) {
		super(idKaryawan, nama, absensi);
		hitungTungjanganPulsa();
		hitungTunjanganTransport();
		hitungTunjanganEntertainment();
	}


	public int getTunjanganTransport() {
		return tunjanganTransport;
	}


	public int hitungTunjanganTransport() {
		int transport = 220000;
		if(super.absensi < 22) {
			return (tunjanganTransport/22)*super.absensi;
		}else {
			return this.tunjanganTransport = transport;
		}
	}


	public int getTunjanganEntertaiment() {
		return tunjanganEntertaiment;
	}


	public int hitungTunjanganEntertainment() {
		int entertainment = 400000;
		if(super.absensi<22) {
			return (tunjanganEntertaiment/22)*super.absensi;
		}else {
			return this.tunjanganEntertaiment = entertainment;
		}
	}
	
	
	


}
