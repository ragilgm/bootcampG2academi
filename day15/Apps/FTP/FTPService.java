package FTP;

import java.io.IOException;

public interface FTPService {
	
	public void Login();
	
	public void changeDirectory(String direktory);
	
	public void ftpList();
	
	public void ftpDownolad(String filename) throws IOException;
	
	public void Logout() throws IOException;



	
	
}