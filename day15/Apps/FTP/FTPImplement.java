package FTP;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Properties;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import Karyawan.Staff;

public class FTPImplement implements FTPService {

	FTPClient ftpClient;
	ArrayList<Staff> staff;

	public FTPImplement() {
		ftpClient = new FTPClient();
		staff = new ArrayList<Staff>();
	}

	@Override
	public void Login() {
		Properties prop = new Properties();
		
		String properties = "C:\\Users\\ragil\\eclipse-workspace\\JavaFTP\\src\\config.properties";

		FileInputStream input = null;

		try {
			input = new FileInputStream(properties);
			prop.load(input);
		} catch (Exception e) {
			// TODO: handle exception
		}

		String server = prop.getProperty("serverName");
		int port = Integer.parseInt(prop.getProperty("portNumber"));
		String user = prop.getProperty("FTPuser");
		String pass = prop.getProperty("FTPpass");
		try {
			ftpClient.connect(server, port);
			showServerReply(ftpClient);
			int replyCode = ftpClient.getReplyCode();
			if (!FTPReply.isPositiveCompletion(replyCode)) {
				System.out.println("Operation failed. Server reply code: " + replyCode);
				return;
			}
			boolean success = ftpClient.login(user, pass);
			showServerReply(ftpClient);
			if (!success) {
				System.out.println("Could not login to the server");
				return;
			} else {
				System.out.println("LOGGED IN SERVER");
			}
		} catch (IOException ex) {
			System.out.println("Oops! Something wrong happened");
			ex.printStackTrace();
		}

	}

	@Override
	public void changeDirectory(String direktory) {
		try {

			// Changes working directory
			boolean success = ftpClient.changeWorkingDirectory(direktory);
			showServerReply(ftpClient);

			if (success) {
				System.out.println("Successfully changed working directory.");
				System.out.println("Current Directory " + ftpClient.printWorkingDirectory());
			} else {
				System.out.println("Failed to change working directory. See server's reply.");
			}

		} catch (IOException ex) {
			System.out.println("Oops! Something wrong happened");
			ex.printStackTrace();
		}

	}

	@Override
	public void ftpList() {
		DateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {

			String directory = ftpClient.printWorkingDirectory();
			System.out.println("Current Directory : "+directory);
			// Lists files and directories
			FTPFile[] files1 = ftpClient.listFiles(directory);

			System.out.println("\ndirectory Folder :");
			System.out.format("%20s %20s %30s", "Folder Name", "Size", "date");
			System.out.println();
			for (FTPFile file : files1) {
				String size = "\t" + file.getSize();
				String time = "\t" + dateFormater.format(file.getTimestamp().getTime());

				String filename = "" + file.getName();
				if (file.isDirectory()) {
					filename = "" + filename + "";
				}
				System.out.format("%20s %20s %30s", filename, size, time);
				System.out.println();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public void ftpDownolad(String filename) throws IOException {
		ftpClient.enterLocalPassiveMode();
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		String remoteFile1 = ftpClient.printWorkingDirectory() + "/" + filename;
		System.out.println("Current Directory : "+remoteFile1);
		
		File downloadFile1 = new File("C:\\Users\\ragil\\eclipse-workspace\\JavaFTP\\src\\FileKaryawan\\"+filename);
		OutputStream output = new BufferedOutputStream(new FileOutputStream(downloadFile1));
		boolean success = ftpClient.retrieveFile(remoteFile1, output);
		output.close();

		if (success) {
			System.out.println("File #1 has been downloaded successfully.");
			System.out.println("save in directory : " + downloadFile1);
		}else {
			System.out.println("Download failed");
		}
	}

	@Override
	public void Logout() throws IOException {
		if (ftpClient.isConnected()) {
			ftpClient.logout();
			ftpClient.disconnect();
			System.out.println("Logout successfull");
		}

	}

	private static void showServerReply(FTPClient ftpClient) {
		String[] replies = ftpClient.getReplyStrings();
		if (replies != null && replies.length > 0) {
			for (String aReply : replies) {
				System.out.println("SERVER: " + aReply);
			}
		}
	}
	


}
