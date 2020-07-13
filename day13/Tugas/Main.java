import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		
		// membuat object inportdata
		InportData inport = new InportData();
		
		// memnbuat object create data mahasiswa
		createDataMahasiswa create = new createDataMahasiswa();
		
		// membuat object edit mahasiswa berdasarkan nama
		EditDataByName editByName = new EditDataByName();
		
		// membuat object edit mahasiswa berdasarkan id
		EditDataById editID = new EditDataById();
		
		// membuat object delete data mahasiswa
		DeleteDataMahasiswa delete = new DeleteDataMahasiswa();
		
		// membuat object print laporan
		PrintLaporan printLaporan = new PrintLaporan();
		
		// membuat object check duplikat data
		CheckDuplikatData duplikat = new CheckDuplikatData();
		
		// membuat object validasi login
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
			
			inport.inportData();
			
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
					String nama = in.nextLine();  // input user
					
					System.out.println("Masukan Nilai Bhs Inggris : ");
					double inggris = in.nextDouble();  // input user
					
					System.out.println("Masukan Nilai Fisika : ");
					double fisika = in.nextDouble();  // input user
					
					System.out.println("Masukan Nilai Algoritma : ");
					double algoritma = in.nextDouble();  // input user
					in.nextLine();
					
					create.createData(nama, inggris, fisika, algoritma);
					break;
				
				case "2":
					System.out.println("\n 2. Edit or Delete Data Mahasiswa \n");
					System.out.println("1. Edit data");
					System.out.println("2. Hapus Data \n");
			
					System.out.println("Masukan Pilihan : ");
					String editOrRemove = in.nextLine();   // input user
					
					switch (editOrRemove) {
					case "1":
					  // edit data
						System.out.println("Edit data \n");
						
						System.out.println("1. Edit By ID.");
						System.out.println("2. Edit By Nama \n");
						System.out.println("Masukan Pilihan.");
						String idOrName = in.nextLine();
						switch (idOrName) {
							// edit data by id
						case "1":
							System.out.println("Edit data berdasarkan ID \n");
							
							System.out.println("Masukan Id : ");
							int target = in.nextInt(); // the element to be searched
							in.nextLine();

							editID.editMahasiswa(target);
						
							break;
						case "2":
							// edit data by nama
							
							// check duplikat data =true
							boolean checkDuplikatData = true;
							
							// duplikat = true
							while(checkDuplikatData) {
								System.out.println("Masukan Nama : ");
								nama = in.nextLine(); // input user
								in.nextLine();

								// memanggil method boolean duplikat data
								// jika data duplikat = true
								// maka ada duplikasi data
								checkDuplikatData = duplikat.Check(nama);
								
								// jika data tidak duplikat
								if(!checkDuplikatData) {
									
									// maka method edit berdasarkan nama akan di eksekusi
									editByName.editMahasiswa(nama);
									
								}else {
									
									// jika data duplikat = true
									// maka method edit data berdasarkan id akan di eksekusi
									
									// boolean check data duplikat di rubah menjadi false agar tidak terjadi infinite loop
									checkDuplikatData = false;
									System.out.println("Masukan ID : ");
									target = in.nextInt(); // input user
									in.nextLine();

									// memanggil method edit data mahasiswa berdasarkan id
									editID.editMahasiswa(target);
								}	
							
							}
							
							break;
						default:
							// output jika user input tidak sesuai dengan aplikasi
							System.out.println("Inputan anda salah");
							break;
						}
						
						break;
					case "2":
						// hapus data
						System.out.println("2. Hapus Data \n");
						System.out.println("Masukan ID : ");
						int target = in.nextInt(); // input user
						in.nextLine();
						// memanggil method delete data mahasiswa dengan parameter target
						delete.hapusDataMahasiswa(target);
						break;
					
					default:
					// output jika user input tidak sesuai dengan aplikasi
						System.out.println("Inputan anda salah");
						break;
					}
					
					break;
				case "3":
					// menampilkan seluruh data arraylist ke layar
						System.out.println("3. laporan Nilai Data Mahasiswa");
						
						System.out.println("Sorting By :");
						System.out.println("1. Id"); // sort by id
						System.out.println("2. Nama"); // sort by name
						
						System.out.println("Input Pilihan : ");
						String sorting = in.nextLine(); // // input user
						// memanggil method print lapiran mahasiswa dengan parameter sorting
						printLaporan.printLaporan(sorting);
					break;
				case "4":
				// multi threading printLaporan + export data
						System.out.println("4. Tampilkan di Layar & Tulis ke File (Multithreading)");
						
					// membuat object show data -> multithreading -> runnable
						ShowData show = new ShowData();
						
					// membuat abject thread1 dengan parameter 
						Thread t1 = new Thread(show);
						
						// memulai thread1
						t1.start();
						
						
					// membuat object export data -> multithreading -> runnable
					ExportDataMahasiswa export = new ExportDataMahasiswa();
					
					// membuat object thread2 dengan parameter
					Thread t2 = new Thread(export);
					
					// memulai thread2
					t2.start();
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
