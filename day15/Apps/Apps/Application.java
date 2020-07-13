package Apps;

import java.io.IOException;
import java.util.Scanner;

import FTP.FTPImplement;
import Karyawan.Crud;
import Thread.ExportDataKaryawan;
import Thread.ShowData;
import auth.UserAuthentication;

public class Application {

	public static void main(String[] args) throws Exception {

//==============================================================================================		
		// require object

		UserAuthentication authentication = new UserAuthentication();
		FTPImplement service = new FTPImplement();
		Scanner in = new Scanner(System.in);
		Crud method = new Crud();
		ExportDataKaryawan export = new ExportDataKaryawan();
		ShowData show = new ShowData();

//=============================================================================================
		String argument;
		try {
			argument = args[0];
		} catch (Exception e) {
			argument = "";
		}
		if (argument.equals("")) {
			if (argument.equals("")) {
				System.out.println("Silahkan masukan argument config.properties untuk login");
				System.out.println("Contoh : java Application config.properties'");
			} else {
				argument = args[0];
				if (!argument.equals("config.properties")) {
					System.out.println("Argument tidak tersedia");
				} else {
					boolean auth = authentication.Login();

					if (auth) {

						service.Login();

						String pilihan = "";

						while (!pilihan.equals("99")) {

							System.out.println("MENU.. \n");
							System.out.println("1. Download file from ftp server");
							System.out.println("2. Proses hasil file download");
							System.out.println("3. Print Laporan & Export (Multithreading)");
							System.out.println("99. Exit. \n");
							System.out.println("=========================================");
							System.out.print("Masukan Pilihan :");

							pilihan = in.nextLine();
							switch (pilihan) {
							case "1":
								String crud = "";

								while (!crud.equals("0")) {

									// ========================= DOWNLOAD MENU ==========================
									System.out.println("\nDownload file from ftp\n");
									System.out.println("\t1. Show List Directory");
									System.out.println("\t2. Change Directory");
									System.out.println("\t3. Download FIle");
									System.out.println("\t0. back to Menu");

									System.out.println("Masukan Pilihan :");
									crud = in.nextLine();

									switch (crud) {
									case "1":
										service.ftpList();
										System.out.println("\nPress enter ..");
										in.nextLine();
										break;
									case "2":
										System.out.println("\nChange Directory \n");
										System.out.println("Input Directory tujuan");
										System.out.println("contoh : /mahasiswa");
										String dir = in.nextLine();

										service.changeDirectory(dir);
										System.out.println("\nPress enter ..");
										in.nextLine();
										break;
									case "3":
										System.out.println("\nDownload File \n");
										System.out.println("Input File yang akan di donwload beserta extensi nya");
										System.out.println("contoh : project.zip");
										System.out.print("Input nama file : ");
										String filename = in.nextLine();

										service.ftpDownolad(filename);
										System.out.println("\nPress enter ..");
										in.nextLine();
										break;
									case "0":
										System.out.println("  <-- Back To Menu");
										break;

									default:
										break;
									}
								}
								break;
							// ======== END OF DOWNLOAD MENU ===============
							case "2":
								// ============= proses hasil file download =============
								System.out.println("\nProses File \n");
								System.out.println("Input Nama File yang akan di Olah");
								System.out.println("contoh : Mahasiswa.txt");
								System.out.print("Input nama file : ");
								String filename = in.nextLine();
								try {
									method.inportData(filename);
								} catch (Exception e) {
									System.out.println("File Not Found");
								}

								break;
							// ============ end of prose hasil file download ============
							case "3":
								Thread thread1 = new Thread(show);
								thread1.start();
								Thread thread2 = new Thread(export);
								thread2.start();
								break;
							case "4":
								System.out.println("good by");
								service.Logout();
								in.close();
								break;
							default:
								System.out.println("some thing when wrong...!!");
								break;
							}

						}
					} else {
						System.out.println("Good by");
					}

				}
			}
		}
		
	}
}