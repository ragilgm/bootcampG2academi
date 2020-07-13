// deklarasi kelas mobil
public class Mobil {  

// variable/attribut yang ada pada mobil
// access modifier yang di gunakan adalah private
	private String merekMobil;  // membuat sebuah variable merekMobil					
	private int tahun; // membuat sebuah variable tahun	
	private int speed = 0; //// membuat sebuah variable speed dan saya beri nilai default 0	
	
// method contstructor
// fungsinya yaitu :
// untuk memanggil suatu variable secara otomatis ketika suatu object di panggil
	public Mobil(String merekMobil, int hargaMobil, String warnaMobil) {
		this.merekMobil = merekMobil;
		this.hargaMobil = hargaMobil;
		this.warnaMobil = warnaMobil;
	}
	
// method ini untuk menangkap/mengambil nilai dari variable merekMobil
	public String getMerekMobil() {
		return merekMobil;
	}
	
// method ini untuk mengubah nilai dari variable merekMobil sesuai dengan parameter
	public void setMerekMobil(String merekMobil) {
		this.merekMobil = merekMobil;
	}
	
	
// method ini untuk menangkap/mengambil nilai dari variable hargaMobil
	public int getHargaMobil() {
		return hargaMobil;
	}
	
// method ini untuk mengubah nilai dari variable hargaMobil berdasarkan parameter
	public void setHargaMobil(int hargaMobil) {
		this.hargaMobil = hargaMobil;
	}
	
// method ini untuk menangkap/mengambil nilai dari variable warnaMobil
	public String getWarnaMobil() {
		return warnaMobil;
	}
	
//method ini untuk mengubah nilai dari variable warnaMobil berdasarkan parameter
	public void setWarnaMobil(String warnaMobil) {
		this.warnaMobil = warnaMobil;
	}
	
// method ini untuk menangkap/mengambil nilai dari variable speed
	public int getSpeed() {
		return speed;
	}
	
// method ini untuk mengubah value kecepatan mobil berdasarkan parameter
	public void speedUp (int increment) {
		this.speed = speed + increment;
	}


// method ini untuk menangkap atau mengambil nilai dari variable gear
	public int getGear() {
		return gear;
	}
	
// method ini untuk mengubah value dari variable gear berdasarkan parameter
	public void setGear(int gear) {
		this.gear = gear;
	}
	
// method ini untuk mengurangi value dari variable speed berdasarkan paramenter
	public void applyBreak(int decrement) {
		this.speed = speed - decrement;
	}
	
// method ini untuk mengeluarkan output berupa nilai nilai dari setiap state pada object
	public void printStates () {
		System.out.println("Nama Mobil : " + getMerekMobil());
		System.out.println("Harga Mobil : " + getHargaMobil());
		System.out.println("warna mobil : " + getWarnaMobil());
		System.out.println("");
		System.out.println("Gigi Saat Ini : " + getGear());
		System.out.println("kecepatan saat ini berada di :" + getSpeed());
		System.out.println("===========================================");
		
	}
	
}