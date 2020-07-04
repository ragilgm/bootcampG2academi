import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

public class Crud {

	// membuat object mahasiswa dengan arraylist
	ArrayList<Mahasiswa> mahasiswa;
	
	public Crud() {
		
		// instansiasi arraylist mahasiswa
		mahasiswa = new ArrayList<Mahasiswa>();
	}
	
	// method untuk validasi username dan password, method ini mereturn kan value true or false
	public boolean Validation(String username, String password) throws IOException {
		
		// membaca file dari direktori "D:\\bootcamp\\bootcamp G2ACADEMY\\materi\\day 11\\tugas\\username.txt"
        FileReader fileUsername = new FileReader("D:\\bootcamp\\bootcamp G2ACADEMY\\materi\\day 11\\tugas\\username.txt");
        
        // membaca isi dari file username.txt
        BufferedReader BufferUsername = new BufferedReader(fileUsername);
        
        // membaca file dari direktori "D:\\bootcamp\\bootcamp G2ACADEMY\\materi\\day 11\\tugas\\password.txt"
        FileReader filePassword = new FileReader("D:\\bootcamp\\bootcamp G2ACADEMY\\materi\\day 11\\tugas\\password.txt");
       
        // membaca isi dari file password.txt
        BufferedReader BufferPassword = new BufferedReader(filePassword);
        
        // variable untuk membaca file username.txt baris pertama
        String user = BufferUsername.readLine();
        
        // variable untuk membaca file password.txt baris pertama
        String pass = BufferPassword.readLine();

        // regex validation = "^(.+)@(.+)$"
        // keterangan :
        // 1. username mengandung @
        //  akan bernilai false jika user input sebagai berikut :      	 
        // 		- @yahoo.com
        //		- ragil.yahoo.com
        // 	akan bernilai true jika user input sebagai berikut :
        // 		- ragilnamasaya@gmail.com
        // 		- ragil@gmail.com dst
		boolean LoginUsername = Pattern.matches("^(.+)@(.+)$", username);
		
		// regex validation = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).{8,}$"
		// keterangan :
		// password harus di awali dengan huruf kapital, dan di iringi huruf kecil, harus mengandung angka dari 0-9,
		// panjang password minimal 8 karacter
		// akan bernilai false jika user input sebagai berikut
		// 		- ragilMaulana
		// 		- ragil404* dst
		// akan bernilai true jika user input sebagai berikut
		// 		- Ragil123*
		// 		- Ragil404#
		boolean LoginPassword = Pattern.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).{8,}$", password);
		
		// menutup file username.txt
		BufferUsername.close();
		
		// menutup file password.txt
		BufferPassword.close();
		
		// jika Pattern LoginUsername = true && Pattern LoginPassword = true
		if(LoginUsername && LoginPassword) {
			
			// jika kondisi di atas sudah terpenuhi maka akan masuk ke pengkondisian selanjutnya
			// jika parameter username = isi dari file username.txt && parameter password = isi dari file password.txt
			if(username.equals(user) && password.equals(pass)) {
				
				// jika kondisi terpenuhi
				return true;
			}else {
				
				// jika kondisi tidak terpenuhi
				return false;
			}
		}else {
			
			// kondisi tidak terpenuhi
			return false;
		}
		
	}
	
	// method untuk create data mahasiswa
	public void createDataMahasiswa(String nama, double bhs_ing, double fisika, double algoritma) throws IOException{
		
		// variable counter
		int counter = 0;
		
		// jika panjang dari arraylist mahasiswa tidak sama dengan 0
		if(mahasiswa.size()!=0) {
			
			// counter = panjang mahasiswa + 1
			counter = mahasiswa.size()+1;
		}else {
			
			// counter akan bertambah 1
			counter++;
		}
			
		// arraylist untuk menampung parameter dari bhs_inggris, fisika, algoritma
			ArrayList<Double> nilai = new ArrayList<Double>();
			
			// add value bahasa inggris
			nilai.add(bhs_ing);
			
			// add value fisika
			nilai.add(fisika);
			
			// add value algoritma
			nilai.add(algoritma);
			
			// memasukan object mahasiswa ke arraylist mahasiswa
			mahasiswa.add(new Mahasiswa(counter, nama, nilai));
			
			// outuput ke layar
			System.out.println("data mahasiswa berhasil di tambahkan");
	}
	
	// edit data mahasiswa berdasarkan id
	public void editIdMahasiswa(int id1,int id2) throws IOException{
		int target = id1; 
		int left = 0; 
		int middle;
		int right = mahasiswa.size() - 1;
		while (left <= right) {
		    middle = (left + right) / 2;
		    if (mahasiswa.get(middle).getId() == target) {
				mahasiswa.get(middle).setId(id2);
				System.out.println("id mahasiwa berhasil di update");
		        break;
		    } else if (mahasiswa.get(middle).getId() < target) {
		        left = middle + 1;
		    } else if (mahasiswa.get(middle).getId() > target) {
		        right = middle - 1;
		    }
		}
	}
	
	// edit data mahasisa berdasarkan nama
	public void editNamaMahasiswa(int id,String nama) throws IOException{
		int target = id; // the element to be searched
		int left = 0;
		int middle;
		int right = mahasiswa.size() - 1;
		while (left <= right) {
		    middle = (left + right) / 2;
		    if (mahasiswa.get(middle).getId() == target) {
				mahasiswa.get(middle).setNama(nama);
				System.out.println("nama mahasiwa berhasil di update");
		        break;
		    } else if (mahasiswa.get(middle).getId() < target) {
		        left = middle + 1;
		    } else if (mahasiswa.get(middle).getId() > target) {
		        right = middle - 1;
		    }
		}
	}
	
	// edit data mahasiswa berdasarkan nilai bahasa inggris
	public void editNilaiB_Inggris(int id,double nilai) throws IOException{
		int target = id; // the element to be searched
		int left = 0;
		int middle;
		int right = mahasiswa.size() - 1;
		while (left <= right) {
		    middle = (left + right) / 2;
		    if (mahasiswa.get(middle).getId() == target) {
				mahasiswa.get(middle).getNilai().set(0, nilai);
				System.out.println("nama mahasiwa berhasil di update");
		        break;
		    } else if (mahasiswa.get(middle).getId() < target) {
		        left = middle + 1;
		    } else if (mahasiswa.get(middle).getId() > target) {
		        right = middle - 1;
		    }
		}
	}
	
	// edit data mahasiswa berdasarkan nilai fisika
	public void editNilaiFisika(int id,double nilai) throws IOException{
		int target = id; // the element to be searched
		int left = 0;
		int middle;
		int right = mahasiswa.size() - 1;
		while (left <= right) {
		    middle = (left + right) / 2;
		    if (mahasiswa.get(middle).getId() == target) {
				mahasiswa.get(middle).getNilai().set(1, nilai);
				System.out.println("nama mahasiwa berhasil di update");
		        break;
		    } else if (mahasiswa.get(middle).getId() < target) {
		        left = middle + 1;
		    } else if (mahasiswa.get(middle).getId() > target) {
		        right = middle - 1;
		    }
		}
	}
	
	// edit data mahasiswa berdasarkan nilai algoritma
	public void editNilaiAlgoritma(int id,double nilai) throws IOException{
		int target = id; // the element to be searched
		int left = 0;
		int middle;
		int right = mahasiswa.size() - 1;
		while (left <= right) {
		    middle = (left + right) / 2;
		    if (mahasiswa.get(middle).getId() == target) {
				mahasiswa.get(middle).getNilai().set(2, nilai);
				System.out.println("nama mahasiwa berhasil di update");
		        break;
		    } else if (mahasiswa.get(middle).getId() < target) {
		        left = middle + 1;
		    } else if (mahasiswa.get(middle).getId() > target) {
		        right = middle - 1;
		    }
		}
	}
	
	// hapus data mahasiswa
	public void hapusDataMahasiswa(int id) throws IOException{
		int target = id; // the element to be searched
		int left = 0;
		int middle;
		int right = mahasiswa.size() - 1;
		while (left <= right) {
		    middle = (left + right) / 2;
		    if (mahasiswa.get(middle).getId() == target) {
				mahasiswa.remove(middle);
		        break;
		    } else if (mahasiswa.get(middle).getId() < target) {
		        left = middle + 1;
		    } else if (mahasiswa.get(middle).getId() > target) {
		        right = middle - 1;
		    }
		}
	}
	
	
	// method untuk menampilkan isi dari arraylist mahasiswa
	public void printLaporan(String sorting){
		System.out.println("Print Laporan Mahasiswa \n");
		System.out.println("ID \t Nama \t Bhs Inggris \t fisika \t Algoritma");
	
		// jika parameter sorting sama dengan 1
		if(sorting.equals("1")) {
			
			// sorting mahasiswa berdasarkan id akan di jalankan 
			Collections.sort(mahasiswa, new IdSorter());
		}else {
			
			// sorting mahasiswa berdasarkan nama akan di jalankan
			Collections.sort(mahasiswa, new NameSorter());
		}
		
				// forEach
                 for(Mahasiswa mhs : mahasiswa) {	
                	 System.out.println(""+mhs.getId()+" \t "+
                			 mhs.getNama()+" \t "+
                			 mhs.getNilai().get(0)+" \t \t "+
                			 mhs.getNilai().get(1)+" \t \t "+
                			 mhs.getNilai().get(2));
                 			}
         		}
	
	}
	
	

