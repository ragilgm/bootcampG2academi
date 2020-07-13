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
				String username;
				String password = null;
				System.out.println("Masukan Username : ");
				username = input.nextLine();

				if (!login.checkValidUsername(username)) {
					checkRegex = false;
				} else {
					System.out.println("Masukan Password : ");
					password = input.nextLine();

					if (!login.checkValidPassword(password)) {
						checkRegex = false;
					} else {
						login.createConfigProperties(argument, username, password);
						System.out.println("file berhasil di buat\n");
						checkRegex = true;
					}
				}

			}

			System.out.println("test login");

			System.out.println("LOGIN REGEX....");

			String konfirmasi = "";
			while (!konfirmasi.equals("n")) {
				System.out.println("Login test.. \n");

				System.out.println("Masukan Username : ");
				String username = input.nextLine();

				if (!login.checkValidUsername(username)) {
					System.out.println(
							"\nApakah anda akan mencoba lagi ? tekan <enter> juka ya dan tekan (n) jika tidak");
					konfirmasi = input.nextLine();

				} else {
					System.out.println("Masukan Password : ");
					String password = input.nextLine();

					if (!login.checkValidPassword(password)) {

						System.out.println(
								"\nApakah anda akan mencoba lagi ? tekan <enter> juka ya dan tekan (n) jika tidak");
						konfirmasi = input.nextLine();

					} else {
						boolean LoginValidation = login.LoginValidation(username, password);

						if (!LoginValidation) {
							System.out.println(
									"\nApakah anda akan mencoba lagi ? tekan <enter> juka ya dan tekan (n) jika tidak");
							konfirmasi = input.nextLine();
						} else {
							break;
						}
					}

				}

			}
		}

		input.close();

	}

}
