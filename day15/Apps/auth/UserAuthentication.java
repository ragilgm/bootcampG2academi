package auth;

import java.io.IOException;
import java.util.Scanner;

public class UserAuthentication {

	public boolean Login() throws IOException {

		Validation login = new Validation();
		boolean validation = false;

		Scanner input = new Scanner(System.in);

		System.out.println("Portal Login..");
		System.out.println("author : ragilnamasaya@gmail.com");
		System.out.println("G2ACADEMY \n");

		String konfirmasi = "";
		while (!konfirmasi.equals("n")) {

			System.out.println("Masukan Username : ");
			String username = input.nextLine();

			if (!login.checkValidUsername(username)) {
				validation = false;
				System.out.println("\nApakah anda akan mencoba lagi ? tekan <enter> juka ya dan tekan (n) jika tidak");
				konfirmasi = input.nextLine();

			} else {
				System.out.println("Masukan Password : ");
				String password = input.nextLine();

				if (!login.checkValidPassword(password)) {
					validation = false;
					System.out.println(
							"\nApakah anda akan mencoba lagi ? tekan <enter> juka ya dan tekan (n) jika tidak");
					konfirmasi = input.nextLine();

				} else {
					boolean LoginValidation = login.LoginValidation(username, password);

					if (!LoginValidation) {
						validation = false;
						System.out.println(
								"\nApakah anda akan mencoba lagi ? tekan <enter> juka ya dan tekan (n) jika tidak");
						konfirmasi = input.nextLine();
					} else {
						validation = true;
						break;
					}
				}

			}

		}
		return validation;

	}
	

}
