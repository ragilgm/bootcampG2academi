import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.regex.Pattern;

public class Validasi extends DatabaseMahasiswa{

	
	// method untuk validasi username dan password, method ini mereturn kan value true or false
		public boolean Validation() throws IOException {
			
			System.out.println("Masukan Username : ");
			String username = in.nextLine();
			
			System.out.println("Masukan Password : ");
			String password = in.nextLine();
			
		URL localPackageUsername = this.getClass().getResource("username.txt");
		String direktoriUsername = localPackageUsername.getPath();
		
		URL localPackagePassword = this.getClass().getResource("password.txt");
		String direktoriPassword = localPackagePassword.getPath();
		
			// membaca file dari direktori dari lokasi file
	        FileReader fileUsername = new FileReader(direktoriUsername);
	        
	        // membaca isi dari file username.txt
	        BufferedReader BufferUsername = new BufferedReader(fileUsername);
	        
	        // membaca file dari direktori "D:\\bootcamp\\bootcamp G2ACADEMY\\materi\\day 11\\tugas\\password.txt"
	        FileReader filePassword = new FileReader(direktoriPassword);
	       
	        // membaca isi dari file password.txt
	        BufferedReader BufferPassword = new BufferedReader(filePassword);
	        
	        // variable untuk membaca file username.txt baris pertama
	        String user = BufferUsername.readLine();
	        
	        // variable untuk membaca file password.txt baris pertama
	        String pass = BufferPassword.readLine();

			boolean LoginUsername = Pattern.matches("^(.+)@(.+)$", username);

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
		

}
