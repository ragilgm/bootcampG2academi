import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.regex.Pattern;

public class LoginRegex {

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

	public void createConfigProperties(String filename, String username, String password) throws IOException {

		namaFile = filename + ".properties";

		URL localPackage = this.getClass().getResource("");
		String direktoriConfig = localPackage.getPath();

		FileWriter writer = new FileWriter(direktoriConfig + namaFile);

		String content = "user=" + username + "\r\n" + "pass=" + password;

		writer.write(content);
		writer.close();

		System.out.println("file config berhasil di buat di dalam direktori");
		System.out.println(direktoriConfig + namaFile);
	}

	// method untuk validasi username dan password, method ini mereturn kan value
	// true or false
	public boolean LoginValidation(String username, String password) throws IOException {

		URL localPackageUsername = this.getClass().getResource(namaFile);
		String direktoriUsername = localPackageUsername.getPath();

		Properties prop = new Properties();

		FileInputStream input = null;

		try {
			input = new FileInputStream(direktoriUsername);

		} catch (Exception e) {
			// TODO: handle exception
		}
		prop.load(input);

		String user = prop.getProperty("user");
		String pass = prop.getProperty("pass");

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
