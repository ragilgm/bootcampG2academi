package auth;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Pattern;

public class Validation {

	String namaFile = "";

	public boolean checkRegex(String username, String password) {
		if (checkValidUsername(username)) {
			if (checkValidPassword(password)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean checkValidUsername(String username) {
		boolean check;
		boolean LoginUsername = Pattern.matches("^(.+)@(.+)$", username);
		if (LoginUsername) {
			check = true;
		} else {
			System.out.println("username tidak valid");
			check = false;
		}
		return check;
	}

	public boolean checkValidPassword(String password) {
		boolean check;
		boolean LoginPassword = Pattern.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).{8,}$", password);
		if (LoginPassword) {
			check = true;
		} else {
			System.out.println("password tidak valid");
			check = false;
		}
		return check;
	}

	public boolean LoginValidation(String username, String password) throws IOException {

		Properties prop = new Properties();

		FileInputStream input = null;

		try {
			input = new FileInputStream("C:\\Users\\ragil\\eclipse-workspace\\JavaFTP\\src\\config.properties");

		} catch (Exception e) {
			// TODO: handle exception
		}
		prop.load(input);

		String user = prop.getProperty("loginUsername");
		String pass = prop.getProperty("loginPassword");

		boolean login;
		
		if(checkRegex(username, password)) {
			if(username.equals(user) && password.equals(pass)) {
				login = true;
				System.out.println("Login Successfull");
			}else {
				login = false;
				System.out.println("Login Failed");
			}
		}else {
			login = false;
			System.out.println("login failed");
		}
		
		return login;
	}

}
