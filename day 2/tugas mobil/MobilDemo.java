// deklarasi dari class mobil demo
public class MobilDemo {

// method ini adalah sebuah method yang akan di execusi atau 
// method yang akan di jalankan ketika file di compile dan di running
	public static void main(String[] args) {
		
		
// inisialisasi object Mobil bernama avansa
// menggunakan parameter constuctor untuk menginisialisasi value dari variable :
// - merekMobil
// - hargaMobil
// - warnaMobil
	Mobil avansa = new Mobil("avansa", 10000000, "blue");
	
// inisialisasi object Mobil bernama kijang
// menggunakan parameter constuctor untuk menginisialisasi value dari variable :
// - merekMobil
// - hargaMobil
// - warnaMobil
// inisialisasi object Mobil bernama kijang
	Mobil kijang = new Mobil("kijang", 12000000, "red");	
	
// object avansa memanggil method setGear untuk mengubah value dari variable gear menjadi 3
	avansa.setGear(3);
	
// object avansa memanggil method setGear untuk mengubah value dari variable gear menjadi 3
	avansa.speedUp(5);

// object avansa memanggil method printStates untuk menampilkan output berupa nilai nilai dari setiap variable yang sudah di set sebelumnya
// outputnya sebagai berikut : 
// Nama Mobil : avansa
// Harga Mobil : 10000000
// warna mobil : blue
//
// Gigi Saat Ini : 3
// kecepatan saat ini berada di :5
// ===========================================
	avansa.printStates();
	
	
	
// object kijang memanggil method setGear untuk mengubah value dari variable gear menjadi 3	
	kijang.setGear(3);
	
// object avansa memanggil method setGear untuk mengubah value dari variable gear menjadi 5
	kijang.speedUp(5);

// object avansa memanggil method printStates untuk menampilkan output berupa nilai nilai dari setiap variable yang sudah di set sebelumnya
// outputnya sebagai berikut : 
// Nama Mobil : kijang
// Harga Mobil : 12000000
// warna mobil : blue
//
// Gigi Saat Ini : 3
// kecepatan saat ini berada di :5
// ===========================================
	kijang.printStates();
	
// akhir dari main method
	}

// akhir dari program MobilDemo
}
