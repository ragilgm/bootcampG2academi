import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Crud {

	ArrayList<Mahasiswa> mahasiswa;
	
	public Crud() {
		mahasiswa = new ArrayList<Mahasiswa>();
	}
	
	public boolean Validation(String username, String password) throws IOException {
        FileReader fileUsername = new FileReader("D:\\bootcamp\\bootcamp G2ACADEMY\\materi\\day 11\\tugas\\username.txt");
        BufferedReader BufferUsername = new BufferedReader(fileUsername);
        
        FileReader filePassword = new FileReader("D:\\bootcamp\\bootcamp G2ACADEMY\\materi\\day 11\\tugas\\password.txt");
        BufferedReader BufferPassword = new BufferedReader(filePassword);
        
        String user = BufferUsername.readLine();
        String pass = BufferPassword.readLine();

		boolean LoginUsername = Pattern.matches("^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$", username);
		boolean LoginPassword = Pattern.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).{8,}$", password);
		
		BufferUsername.close();
		BufferPassword.close();
		
		if(LoginUsername && LoginPassword) {
			if(username.equals(user) && password.equals(pass)) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
		
	}
	
	
	public void createDataMahasiswa(String nama, double bhs_ing, double fisika, double algoritma) throws IOException{
		int counter = 0;
		if(mahasiswa.size()!=0) {
			counter = mahasiswa.size()+1;
		}else {
			counter++;
		}
			ArrayList<Double> nilai = new ArrayList<Double>();
			nilai.add(bhs_ing);
			nilai.add(fisika);
			nilai.add(algoritma);
			
			mahasiswa.add(new Mahasiswa(counter, nama, nilai));
			System.out.println("data mahasiswa dengan id"+mahasiswa.get(0).getId()+" berhasil di tambahkan");
	}
	
	public void editIdMahasiswa(int id1,int id2) throws IOException{
		int target = id1; // the element to be searched
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
	
	
	
	public void printLaporan(){
		System.out.println("Print Laporan Mahasiswa \n");
		System.out.println("ID \t Nama \t Bhs Inggris \t fisika \t Algoritma");
	
		// sorting menggunakan method buble sort
		int n = mahasiswa.size();  
        int temp = 0;  
         for(int i=0; i < n; i++){  
                 for(int j=1; j < (n-i); j++){  
                          if(mahasiswa.get(j-1).getId() > mahasiswa.get(j).getId()){  
                                 temp = mahasiswa.get(j-1).getId();  
                                 int arr1 = mahasiswa.get(j).getId();
                                 int arr2 = mahasiswa.get(j).getId();
                                 arr1 = mahasiswa.get(j+1).getId();
                                 arr2 = temp;  
                         }  
                          
                 }  
	
    
                 for(Mahasiswa mhs : mahasiswa) {
                	 System.out.println(""+mhs.getId()+" \t "+
                			 mhs.getNama()+" \t "+
                			 mhs.getNilai().get(0)+" \t \t "+
                			 mhs.getNilai().get(1)+" \t \t "+
                			 mhs.getNilai().get(2));
                 			}
         		}
	
	}
	
	
}
