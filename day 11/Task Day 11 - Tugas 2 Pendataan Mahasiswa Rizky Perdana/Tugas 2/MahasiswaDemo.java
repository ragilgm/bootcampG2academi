import java.io.*;
import java.util.*;
import java.util.regex.*;

class Mahasiswa {
    private int iID;
	private String sNama;
	private ArrayList<Double> iNilai;
	
	
	public Mahasiswa(int iID, String sNama, ArrayList<Double> iNilai) {
		this.iID = iID;
		this.sNama = sNama;
		this.iNilai = iNilai;
	}
	
	public Mahasiswa(Mahasiswa mahasiswa) {
		this.iID = mahasiswa.iID;
		this.sNama = mahasiswa.sNama;
		this.iNilai = mahasiswa.iNilai;
	}
	
	public Mahasiswa() {

	}

	public int getiID() {
		return iID;
	}
	public void setiID(int iID) {
		this.iID = iID;
	}

	public String getsNama() {
		return sNama;
	}
	public String setsNama(String sNama) {
		this.sNama = sNama;
		return sNama;
	}

	public ArrayList<Double> getiNilai() {
		return iNilai;
	}
	public void setiNilai(ArrayList<Double> iNilai) {
		this.iNilai = iNilai;
	}
}

class Program {
    public static ArrayList<Mahasiswa> dataMahasiswa = new ArrayList<Mahasiswa>();

    public void createDataMahasiswa(int iID, String sNama, double iBhsIng, double iFisika, double iAlgoritma) {
        ArrayList<Double> nilai = new ArrayList<Double>();
        nilai.add(iBhsIng);
        nilai.add(iFisika);
        nilai.add(iAlgoritma);

        try {
            Mahasiswa mahasiswa = new Mahasiswa(iID, sNama, nilai);
            dataMahasiswa.add(mahasiswa);
        
            System.out.println("\nBerhasi membuat data mahasiswa.");
        } catch (Exception e) {
            System.err.println("Gagal, tolong cek kembali : \n " + e);
        } 
    }

    public void editNama(int iID, String sNama) {
		int left = 0;
        int middle;
        int right = dataMahasiswa.size() - 1;
        try{
            while (left <= right) {
                middle = (left + right) / 2;
                if (dataMahasiswa.get(middle).getiID() == iID) {
                    dataMahasiswa.get(middle).setsNama(sNama);
                    System.out.println("Edit nama berhasil.");
                    break;
                } else if (dataMahasiswa.get(middle).getiID() < iID) {
                    left = middle + 1;
                } else if (dataMahasiswa.get(middle).getiID() > iID) {
                    right = middle - 1;
                }
            }
		} catch(Exception e) {
				System.err.println("Gagal, tolong cek kembali : \n " + e);
		}
	}

    public void editNilaiInggris(int iID, double iBhsIng) {
		int left = 0;
        int middle;
        int right = dataMahasiswa.size() - 1;
        try{
            while (left <= right) {
                middle = (left + right) / 2;
                if (dataMahasiswa.get(middle).getiID() == iID) {
                    dataMahasiswa.get(middle).getiNilai().set(0, iBhsIng);
                    System.out.println("Edit nilai bahasa inggris berhasil.");
                    break;
                } else if (dataMahasiswa.get(middle).getiID() < iID) {
                    left = middle + 1;
                } else if (dataMahasiswa.get(middle).getiID() > iID) {
                    right = middle - 1;
                }
            }
		} catch(Exception e) {
				System.err.println("Gagal, tolong cek kembali : \n " + e);
		}
	}

    public void editNilaiFisika(int iID, double iFisika) {
		int left = 0;
        int middle;
        int right = dataMahasiswa.size() - 1;
        try{
            while (left <= right) {
                middle = (left + right) / 2;
                if (dataMahasiswa.get(middle).getiID() == iID) {
                    dataMahasiswa.get(middle).getiNilai().set(1, iFisika);
                    System.out.println("Edit nilai fisika berhasil.");
                    break;
                } else if (dataMahasiswa.get(middle).getiID() < iID) {
                    left = middle + 1;
                } else if (dataMahasiswa.get(middle).getiID() > iID) {
                    right = middle - 1;
                }
            }
		} catch(Exception e) {
				System.err.println("Gagal, tolong cek kembali : \n " + e);
		}
	}

    public void editNilaiAlgoritma(int iID, double iAlgoritma) {
		int left = 0;
        int middle;
        int right = dataMahasiswa.size() - 1;
        try{
            while (left <= right) {
                middle = (left + right) / 2;
                if (dataMahasiswa.get(middle).getiID() == iID) {
                    dataMahasiswa.get(middle).getiNilai().set(2, iAlgoritma);
                    System.out.println("Edit nilai algoritma berhasil.");
                    break;
                } else if (dataMahasiswa.get(middle).getiID() < iID) {
                    left = middle + 1;
                } else if (dataMahasiswa.get(middle).getiID() > iID) {
                    right = middle - 1;
                }
            }
		} catch(Exception e) {
				System.err.println("Gagal, tolong cek kembali : \n " + e);
		}
	}

    public void hapusDataMahasiswa(int iID) {
        int left = 0;
        int middle;
        int right = dataMahasiswa.size() - 1;
        try{
            while (left <= right) {
                middle = (left + right) / 2;
                if (dataMahasiswa.get(middle).getiID() == iID) {
                    dataMahasiswa.remove(middle);
                    System.out.println("Hapus Data berhasil.");
                    break;
                } else if (dataMahasiswa.get(middle).getiID() < iID) {
                    left = middle + 1;
                } else if (dataMahasiswa.get(middle).getiID() > iID) {
                    right = middle - 1;
                }
            }
		} catch(Exception e) {
				System.err.println("Gagal, tolong cek kembali : \n " + e);
		}
	}

    public void laporanDataMahasiswa() {
		if(!dataMahasiswa.isEmpty()){
			for(Mahasiswa data : dataMahasiswa) {
		        System.out.println("ID  \t\t\t : "+ data.getiID());
		        System.out.println("Nama  \t\t\t : "+ data.getsNama());
                System.out.println("Nilai Bahasa Inggris \t : " + data.getiNilai().get(0));
		        System.out.println("Nilai Fisika \t\t : " + data.getiNilai().get(1));
		        System.out.println("Nilai Algoritma \t : " + data.getiNilai().get(2) + "\n");
		    }
		} else {
			System.out.println("Maaf, data masih kosong.");
		}
	}
}

public class MahasiswaDemo {
    public static void main(String args[]) throws IOException {
        try {
            BufferedReader bruser = new BufferedReader(new FileReader("C:\\Users\\Rizky\\Documents\\My Data\\Belajar Pemrograman\\G2 Academy\\Bootcamp\\2020-07-02 Day 11\\Tugas 2\\username.txt"));
            BufferedReader brpass = new BufferedReader(new FileReader("C:\\Users\\Rizky\\Documents\\My Data\\Belajar Pemrograman\\G2 Academy\\Bootcamp\\2020-07-02 Day 11\\Tugas 2\\password.txt"));

            String usernametxt = bruser.readLine();
            String passwordtxt = brpass.readLine();

            Scanner scn = new Scanner(System.in);

            System.out.println("\tLogin");

		    System.out.print("\nUsername \t: ");
		    String sUsername = scn.nextLine();
					
		    System.out.print("\nPassword \t: ");
	        String sPassword = scn.nextLine();

			boolean regexUsername = Pattern.matches("^(.+)@(.+)$", sUsername);
            boolean regexPassword = Pattern.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).{8,}$", sPassword);
            if(regexUsername == true && regexPassword == true) {
                if(sUsername.equals(usernametxt) && !sPassword.equals(passwordtxt)) {
                    System.out.println("Password anda salah.");
                } else if(!sUsername.equals(usernametxt) && sPassword.equals(passwordtxt)) {
                    System.out.println("Username anda salah.");
                } else if(sUsername.equals(usernametxt) && sPassword.equals(passwordtxt)) {
                    System.out.println("Login berhasil.");

                    Program program = new Program();

                    InputStreamReader r = new InputStreamReader(System.in);
                    BufferedReader br = new BufferedReader(r);

                    int menu = 0;

                    while(menu != 4) {
                        int menu2 = 0;
                        int menu22 = 0;

                        System.out.println("###########################################");
                        System.out.println("\nMenu");
                        System.out.println("1. Create dan Input Data Mahasiswa");
                        System.out.println("2. Edit atau Delete Data Mahasiswa");
                        System.out.println("3. Laporan Data Mahasiswa");
                        System.out.println("4. Exit");

                        try { 
                            System.out.print("Pilih No Menu : ");
                            menu = Integer.parseInt(br.readLine());
                            System.out.println("\nMenu yang anda pilih : " + menu);

                            if(menu == 1) {
                                System.out.println("###########################################");
                                System.out.println("\n\tMasukan Data :");

				                System.out.print("\nID \t\t\t: ");
				                int iID = Integer.parseInt(br.readLine());
					
				                System.out.print("\nNama \t\t\t: ");
				                String sNama = br.readLine();

                                System.out.print("\nBahasa Inggris \t\t: ");
				                double iBhsIng = Integer.parseInt(br.readLine());

                                System.out.print("\nFisika \t\t\t: ");
				                double iFisika = Integer.parseInt(br.readLine());

                                System.out.print("\nAlgoritma \t\t: ");
				                double iAlgoritma = Integer.parseInt(br.readLine());
					
				                program.createDataMahasiswa(iID, sNama, iBhsIng, iFisika, iAlgoritma);
                            } else if(menu == 2) {
                                System.out.println("###########################################");
                                System.out.println("Menu : ");					
					            System.out.println("1. Edit Data");
					            System.out.println("2. Hapus Data \n");
                                System.out.print("Pilih No Menu : ");
                                menu2 = Integer.parseInt(br.readLine());
                                System.out.println("\nMenu yang anda pilih : " + menu2);

                                if(menu2 == 1) {
                                    System.out.println("###########################################");
                                    System.out.print("\nPilih ID yang ingin di-edit : ");
					                int iID = Integer.parseInt(br.readLine());

                                    System.out.println("\nMenu : ");					
					                System.out.println("1. Edit Nama");
					                System.out.println("2. Edit Nilai Bahasa Inggris");
                                    System.out.println("3. Edit Nilai Fisika");
                                    System.out.println("4. Edit Nilai Algoritma \n");
                                    System.out.print("Pilih No Menu : ");
                                    menu22 = Integer.parseInt(br.readLine());
                                    System.out.println("\nMenu yang anda pilih : " + menu22);

						            if(menu22 == 1) {
		                                System.out.print("\nEdit Nama \t\t\t: ");
				                        String sNama = br.readLine();

		                                program.editNama(iID, sNama);
						            } else if(menu22 == 2) {
								        System.out.print("\nEdit Nilai Bahasa Inggris \t: ");
				                        double iBhsIng = Integer.parseInt(br.readLine());
							
		          	                    program.editNilaiInggris(iID, iBhsIng);
						            } else if(menu22 == 3) {
								        System.out.print("\nEdit Nilai Fisika \t\t: ");
				                        double iFisika = Integer.parseInt(br.readLine());
							
		          	                    program.editNilaiFisika(iID, iFisika);
						            } else if(menu22 == 4) {
								        System.out.print("\nEdit Nilai Algoritma \t\t: ");
				                        double iAlgoritma = Integer.parseInt(br.readLine());
							
		                    	        program.editNilaiAlgoritma(iID, iAlgoritma);
						            } else {
								        System.out.println("Salah input. Silahkan coba kembali.");
						            }
                                } else if (menu2 == 2) {
                                    System.out.println("###########################################");
                                    System.out.print("\nPilih ID yang ingin dihapus : ");
					                int iID = Integer.parseInt(br.readLine());
						
					                program.hapusDataMahasiswa(iID);
                                } else {
                                System.out.println("Salah input. Silahkan coba kembali.");
                                }
                            } else if(menu == 3) {
                                program.laporanDataMahasiswa();
                            } else if(menu == 4) {
                                System.out.print("Terima Kasih");
                            } else {
                                System.out.println("Tidak ada di-menu.");
                            }
                        } catch(Exception e) {
                            System.err.println("Gagal, tolong cek kembali : \n " + e);
                        } 
                    }
                    br.close();
                    r.close();
                } else {
                    System.out.println("Username dan Password anda salah.");
                }
            } else {
     	        System.out.println("Regex Salah");
            }
            bruser.close();
            brpass.close();
	    } catch(Exception e) {
			System.err.println("Gagal, tolong cek kembali : \n " + e);
		}
    }
}