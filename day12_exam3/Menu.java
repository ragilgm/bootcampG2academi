import java.util.Scanner;

public class Menu {

	public static void main(String[] args) throws Exception {
		
		Crud crud = new Crud();
	
		Scanner in = new Scanner(System.in);
		
		String argument = args[0];
		
		if(argument.equals("LoginKaryawan.txt")) {
			
			System.out.println("System Login...");
			
			System.out.print("Masukan Nama : ");
			String username = in.nextLine();
			
			System.out.print("Masukan Password : ");
			String password = in.nextLine();
			
			boolean isValid = crud.Validation(argument,username, password);
			
			if (isValid) {
				
			String pilihan = "";
			
			while (!pilihan.equals("99")) {
				
				System.out.println("MENU.. \n");
				System.out.println("1. Import data karyawan");
				System.out.println("2. Input Data Karyawan");
				System.out.println("3. Edit Data Karyawan");
				System.out.println("4. Absensi Karyawan");
				System.out.println("5. cuti Karyawan");
				System.out.println("6. Hitung Total Gaji Karyawan");
				System.out.println("7. Tampilkan Laporan per Karyawan");
				System.out.println("8. Tampilkan Laporan Seluruh Karyawan");
				System.out.println("9. Export data karyawan");
				System.out.println("99. Exit. \n");
				System.out.println("=========================================");
				System.out.print("Masukan Pilihan :");
				pilihan = in.nextLine();
				
				switch (pilihan) {
				case "1":
					// "1. Import data karyawan" 
					
					crud.inportData();
					
					break;
				case "2":
					// input data karyawan
					
					System.out.println("Masukan Data Karyawan Baru : \n");
					
					System.out.print("Masukan nama :");
					String nama = in.nextLine();
					
					System.out.print("Masukan Gaji Pokok Baru : ");
					int gajiPokok = in.nextInt();
					
					System.out.print("Masukan Absensi : ");
					int absensi = in.nextInt();
					
					System.out.print("masukan Jumlah Cuti : ");
					int cuti = in.nextInt();
					
					crud.createStaff(nama, gajiPokok, absensi, cuti);
					
					break;
				case "3":
					// Edit Data Karyawan
					
					System.out.println("\n1. Cari data By Id");
					System.out.println("2. Cari Data By Nama : \n");
					
					System.out.print("Masukan Pilihan :");
					String edit = in.nextLine();
					
					switch (edit) {
					case "1":
						// edit data by id
						System.out.print("\nMasukan ID :");
						int id = in.nextInt();
						in.nextLine();
						
						System.out.print("Masukan Nama : ");
						nama= in.nextLine();
						
						System.out.print("Masukan Gaji Pokok : ");
						gajiPokok = in.nextInt();
						
						crud.editDataById(id, nama, gajiPokok);
						
						break;
					case "2":
						// edit data by name
						System.out.print("\nMasukan Nama :");
						nama = in.nextLine();
					
						System.out.print("Masukan Nama baru : ");
						String newName = in.nextLine();
					
						System.out.print("Masukan Gaji Pokok : ");
						gajiPokok = in.nextInt();
						
						crud.editDataByName(nama, newName, gajiPokok);
						break;

					default:
						break;
					}
					
					break;
				case "4":
					// Absen Karyawan
					
					System.out.println("1. Masukan Absen By ID : ");
					System.out.println("1. Masukan Absen By Nama : \n");
					System.out.print("Masukan Pilihan :");
					String editAbsen = in.nextLine();
			
					
					switch (editAbsen) {
					case "1":
						// absen Karyawan by Id
						System.out.print("\nMasukan ID :");
						int id = in.nextInt();
						
						crud.setAbsenById(id);
						
						break;
					case "2":
						// absen karyawan by name
						System.out.print("\nMasukan Nama :");
						nama = in.nextLine();
					
						crud.setAbsenByNama(nama);
						break;

					default:
						break;
					}
					
					break;
					case "5":
					// Cuti karyawan
					
						System.out.println("1. Masukan Absen By ID : ");
						System.out.println("1. Masukan Absen By Nama : \n");
						System.out.print("Masukan Pilihan :");
						String editCuti = in.nextLine();
					
					
					switch (editCuti) {
					case "1":
						// Cuti Karyawan by Id
						System.out.print("\nMasukan ID :");
						int id = in.nextInt();
						
						crud.setCutiById(id);
						
						break;
					case "2":
						// cuti karyawan by name
						System.out.print("\nMasukan Nama :");
						nama = in.nextLine();
					
						crud.setCutiByName(nama);
						break;

					default:
						break;
					}
					
					break;
				case "6":
					// hitung total gaji
					
					crud.hitungTotalGaji();
					
					break;
				case "7":
					// tampilkan karyawan by id
					
					System.out.println("\n1. tampilkan berdasarkan id ");
					System.out.println("2. tampilkan berdasarkan nama \n");
					
					System.out.print("Input Pilihan ");
					String showData = in.nextLine();
					
					switch (showData) {
					case "1":
						// show data by id
						System.out.print("Masukan ID : ");
						int id = in.nextInt();
						
						crud.ShowDataById(id);
						
						break;
					case "2":
						// show data by name
						System.out.print("Masukan Nama :");
						nama = in.nextLine();
						
						crud.ShowDataByName(nama);
						
						break;

					default:
						break;
					}
					
					break;
				case "8":
					// print laporan 
					crud.Laporan();
					break;
				case "9":
					// export data
					crud.exportLaporan();
					break;
				case "99":
					
					break;
				default:
					break;
				}
				
			}
				
			}else {
				System.out.println("Username atau password salah ... silahkan ulangi ");
			}
			
			
			
			
			
		} else {
			System.out.println("input argument : "+argument);
		}
		
		in.close();
		
	}

}
