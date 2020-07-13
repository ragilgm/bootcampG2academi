import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.regex.Pattern;

public class LoginRegex {

	String namaFile = "";

	public boolean checkRegex(String username, String password) {
		boolean LoginUsername = Pattern.matches("^(.+)@(.+)$", username);
		boolean LoginPassword = Pattern.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).{8,}$", password);
		if (LoginUsername && LoginPassword) {
			return true;
		} else {
			return false;
		}
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
		System.out.println(direktoriConfig+namaFile);
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

		// jika Pattern LoginUsername = true && Pattern LoginPassword = true
		if (username.equals(user) && password.equals(pass)) {

			return true;
		} else {

			return false;
		}

	}

}
