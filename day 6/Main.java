import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		CrudOperation crud = new CrudOperation();
		
		// scanner
		Scanner in = new Scanner(System.in);  
	       String data = "";
	       
	       while(!data.equals("8")) {
			   // menu
	    	   System.out.println("MENU");
	    	   System.out.println("1. Input Data Karyawan.");
	    	   System.out.println("2. Edit Data Karyawan.");
	    	   System.out.println("3. Absensi Karyawan.");
	    	   System.out.println("4. Cuti Karyawan.");
	    	   System.out.println("5. Hitung Total Gaji");
	    	   System.out.println("6. Tampilkan Laporan Perkaryawan");
	    	   System.out.println("7. Print Data Laporan.");
	    	   System.out.println("8. EXIT");
	    	   
	    	   System.out.print("Input Pilihan : ");
	    	   data = in.nextLine();
	    	   
	    	   switch (data) {
			case "1":
				try {
					
				System.out.println("Input Data Karyawan Baru :");
				//input id
				
				System.out.print("masukan id :");
				int id =in.nextInt();
				
				// input nama
				System.out.print("Masukan Nama : ");
				in.nextLine();
				String nama = in.nextLine();
				
				
				// input gaji Pokok
				System.out.print("Masukan Gaji Pokok : ");
				int gajiPokok = in.nextInt();
				in.nextLine();
				
				// create data
					crud.createData(id, nama, gajiPokok);
				} catch (Exception e) {
					System.out.println("kesalaham pada "+e);
				}
				
				break;
			case "2":
				System.out.println("Edit Data Karyawan :");
				try {
				System.out.print("Masukan ID :");
				String idEdit = in.nextLine();
				
				System.out.print("Masukan Nama : ");
				String editNama = in.nextLine();
				
				// memanggil method editData dari kelas CrudOperation
				crud.editData(idEdit, editNama);

				} catch (Exception e) {
					System.err.println("Kesalahan pada "+e);
				}
				
				break;
			case "3":
				System.out.println("Absensi Karyawan :");
				// memangil method showData dari kelas CrudOperation
				System.out.print("Masukan Nama/ID :");
				String absen = in.nextLine();
				
				crud.absensiKaryawan(absen);
				
				break;
			case "4":
				System.out.println("Cuti Karyawan :");
				// memangil method showData dari kelas CrudOperation
				System.out.print("Masukan Nama/ID :");
				String cuti = in.nextLine();
				crud.cutiKaryawan(cuti);
				
				break;
			case "5":
				System.out.println("Hitung Total Gaji Karyawan..");
				crud.hitungTotalGaji();
				
				break;
			case "6":
				System.out.println("Seach Data By ID/Nama :");
				// memangil method showData dari kelas CrudOperation
				System.out.print("Masukan Nama/ID :");
				String karyawanId = in.nextLine();
				crud.ShowDataById(karyawanId);
				break;
			case "7":
				crud.printText();
				break;
			case "8":
				break;
			default:
				System.out.println("your input is not exist");
				break;
			}
	  
	       } 

	}

}