package Thread;

import Karyawan.Crud;
import Karyawan.Staff;

public class ShowData extends Crud implements Runnable {

	@Override
	public void run() {
		printLaporan();
	}

	public void printLaporan() {
		System.out.println("Print Laporan Mahasiswa \n");
		System.out.println("ID \t Nama \t Bhs Inggris \t fisika \t Algoritma");

		for (Staff worker : staff) {
			System.out.println(" id : " + worker.getId());
			System.out.println(" nama : " + worker.getNama());
			System.out.println(" Absensi : " + worker.getAbsensi());
			System.out.println(" Jumlah Cuti : " + worker.getJumlahCuti());
			System.out.println("Jumlah Tanpa Kabar : " + worker.getTanpaKabar());
			System.out.println(" Tunjangan Makan : " + worker.HitungTunjanganMakan());
			System.out.println(" Tunjangan Transport : " + worker.HitungTunjanganTransport());
			System.out.println(" Gaji Pokok : " + worker.hitungGajiPokok());
			System.out.println(" TOTAL GAJI : " + worker.hitungTotalGaji());
			System.out.println("--------------------------------------------------");
		}
	}

}
