import java.util.Scanner;
import java.util.regex.Pattern;

public class LoginRegex {
	
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("System Login");
		
		System.out.println("Masukan Email :");
		String email = in.nextLine();
		
		System.out.println("Masukan Password :");
		String pass = in.nextLine();
		
		
		boolean login = Pattern.matches("^(.+)@(.+)$",email);
		
		boolean password = Pattern.matches("^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$", pass);
		
		if(login && password) {
			System.out.println("login berhasil");
		}else {
			System.out.println("login gagal");
		}
		
		
	}

}