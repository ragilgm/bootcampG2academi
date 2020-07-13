import java.io.IOException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws IOException {

		LoginRegex login = new LoginRegex();
		boolean checkRegex = false;

		Scanner input = new Scanner(System.in);
		String argument;
		try {
			argument = args[0];
		} catch (Exception e) {
			argument = "";
		}
		if (argument.equals("")) {
			System.out.println("Silahkan masukan argument untuk Membuat File config untuk login");
			System.out.println("Contoh : java App 'config'");
		} else {
			argument = args[0];

			while (!checkRegex) {
				System.out.println("\nbuat username untuk login.");
				System.out.println("Masukan Username :");
				String user = input.nextLine();

				System.out.println("\nbuat password untuk login.");
				System.out.println("Masukan Password :");
				String pass = input.nextLine();

				checkRegex = login.checkRegex(user, pass);
				if(!checkRegex){
				System.out.println("username or password tidak sesusai regex \n");
				}else {
				System.out.println("success \n");	
				}
				if (checkRegex) {
					login.createConfigProperties(argument, user, pass);
					System.out.println("file berhasil di buat\n");
				}

			}

			
			System.out.println("test login");

			System.out.println("LOGIN REGEX....");

			String konfirmasi = "";
			while (!konfirmasi.equals("n")) {
				System.out.println("Login test.. \n");

				System.out.println("Masukan Username : ");
				String username = input.nextLine();

				System.out.println("Masukan Password : ");
				String password = input.nextLine();

				checkRegex = login.checkRegex(username, password);
				
				if(checkRegex) {
					boolean checkLogin = login.LoginValidation(username, password);
					if(checkLogin) {
						System.out.println("Login Successfull");
						break;
					}else {
						System.out.println("Login Failed");
						System.out.println("\nApakah anda akan mencoba lagi ? tekan (n) jika tidak");
						konfirmasi = input.nextLine();
						break;
					}
				}else {
					System.out.println("login failed");
					System.out.println("\nApakah anda akan mencoba lagi ? tekan (n) jika tidak");
					konfirmasi = input.nextLine();
					break;
				}

			}
		}

		input.close();

	}

}
