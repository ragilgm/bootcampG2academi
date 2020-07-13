import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		
		InportData inport = new InportData();
		createDataMahasiswa create = new createDataMahasiswa();
		EditDataByName editByName = new EditDataByName();
		EditDataById editID = new EditDataById();
		DeleteDataMahasiswa delete = new DeleteDataMahasiswa();
		PrintLaporan printLaporan = new PrintLaporan();
		ShowData show = new ShowData();
		ExportDataMahasiswa export = new ExportDataMahasiswa();
		CheckDuplikatData duplikat = new CheckDuplikatData();
		Validasi isValidLogin = new Validasi();

		
		// scanner
		Scanner in = new Scanner(System.in);
	
		System.out.println("APLIKASI MAHASISWA");
		System.out.println("==================\n");
		
		System.out.println("Silahkan Login..");
		
		// validasi username & password
		boolean validasi = isValidLogin.Validation();
		
		// jika validasi terpenuhi
		if(validasi) {

			// thread import otomatis akan di jalankan ketika user berhasil login
			// Thread t0 = new Thread(inport); -> membuat object thread dengan parameter runnable
			// t0.start(); -> t0 di start
			Thread t0 = new Thread(inport);
			t0.start();
			
			// menu akan di jalankan
			System.out.println("Selamat Anda Berhasil Login...");
			
			String input = "";
			
			while (!input.equals("5")) {
				// menu
		    	   System.out.println("MENU");
		    	   System.out.println("1. Create & Input Data Mahasiswa");
		    	   System.out.println("2. Edit or Delete Data Mahasiswa");
		    	   System.out.println("3. laporan Nilai Data Mahasiswa");
		    	   System.out.println("4. Tampilkan di Layar & Tulis ke File (Multithreading)");
		    	   System.out.println("5. Exit \n");
		    	   
		    	   System.out.println("Masukan Pilihan");
		    	   input = in.nextLine();
		    	   
		    	   switch (input) {
				case "1":
					System.out.println("\n 1. Create & Input Data Mahasiswa \n");
					
					System.out.println("Masukan Nama : ");
					String nama = in.nextLine();
					
					System.out.println("Masukan Nilai Bhs Inggris : ");
					double inggris = in.nextDouble();
					
					System.out.println("Masukan Nilai Fisika : ");
					double fisika = in.nextDouble();
					
					System.out.println("Masukan Nilai Algoritma : ");
					double algoritma = in.nextDouble();
					in.nextLine();
					create.createData(nama, inggris, fisika, algoritma);
					break;
				
				case "2":
					System.out.println("\n 2. Edit or Delete Data Mahasiswa \n");
					System.out.println("1. Edit data");
					System.out.println("2. Hapus Data \n");
			
					System.out.println("Masukan Pilihan : ");
					String editOrRemove = in.nextLine();
					
					switch (editOrRemove) {
					case "1":
						System.out.println("Edit data \n");
						
						System.out.println("1. Edit By ID.");
						System.out.println("2. Edit By Nama \n");
						System.out.println("Masukan Pilihan.");
						String idOrName = in.nextLine();
						switch (idOrName) {
						case "1":
							System.out.println("Edit data berdasarkan ID \n");
							
							System.out.println("Masukan Id : ");
							int target = in.nextInt(); // the element to be searched
							in.nextLine();
							editID.editMahasiswa(target);
						
							break;
						case "2":
							// boolean dubpikat
							boolean checkDuplikatData = true;
							// selama boolean duplikat = true
							// looping akan berjalan
							while(checkDuplikatData) {
								System.out.println("Masukan Nama : ");
								nama = in.nextLine(); // input user
								
								// check duplikat data
								// checkDuplikatData -> boolean duplikat
								// duplikat.Check(nama); -> method check duplikat dengan parameter nama
								checkDuplikatData = duplikat.Check(nama);
								
								// jika data tidak duplikat
								if(!checkDuplikatData) {
									
									// method edit berdasarkan nama akan di eksekusi
									editByName.editMahasiswa(nama);
									
								}else {
									// jika terdapat data duplikat
									// method edit berdasarkan nama akan di eksekusi
									System.out.println("Masukan ID : ");
									target = in.nextInt();
									in.nextLine();
									editID.editMahasiswa(target);
									
									// boolean = false -> untuk memberhentikan looping
									checkDuplikatData = false;
								}	
							
							}
							
							break;
						default:
							System.out.println("Inputan anda salah");
							break;
						}
						
						break;
					case "2":
						// delete data mahasiswa
						System.out.println("2. Hapus Data \n");
						System.out.println("Masukan ID : ");
						int target = in.nextInt(); // the element to be searched
						in.nextLine();
						
						// memanggil method delete data mahasiswa
						delete.hapusDataMahasiswa(target);
						break;
					
					default:
						System.out.println("Inputan anda salah");
						break;
					}
					
					break;
				case "3":
						// menampilkan data mahasiswa
						System.out.println("3. laporan Nilai Data Mahasiswa");
						
						System.out.println("Sorting By :");
						System.out.println("1. Id");
						System.out.println("2. Nama");
						
						System.out.println("Input Pilihan : ");
						String sorting = in.nextLine();
						
						// memanggil method printlaporan
						printLaporan.printLaporan(sorting);
					break;
				case "4":
						System.out.println("4. Tampilkan di Layar & Tulis ke File (Multithreading)");
					// membuat object thread1 = dengan menjalankan class showData
					Thread t1 = new Thread(show);
					// membuat object thread2 = dengan menjalankan class exportLaporan
					Thread t2 = new Thread(export);
					// t1.start(); -> thread 1 running
					t1.start();
					
					// t2.start(); -> thread 2 running
					t2.start();
					in.nextLine();
					break;
				case "5":
					break;
					
				default:
					System.out.println("Inputan anda salah");
					break;
				}
			}
		} else {
			
			// jika validasi tidak terpenuhi
			System.out.println("anda gagal login..");
		}
		
		
		in.close();
	

	}

}
