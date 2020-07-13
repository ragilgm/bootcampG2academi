package FTP;

import java.io.InputStream;
import java.util.Scanner;
import org.apache.commons.net.ftp.FTPClient;

public class ReadFtpFileExample {

 public static void main(String[] args) {

  String ftpUrl = "localhost";
  int defaultPort = 21;

  String user = "ragil";
  String pass = "ragil";
  
   try {
           //Opening the FTP connection and logging in
           FTPClient ftpClient = new FTPClient();
           ftpClient.connect(ftpUrl, defaultPort);
           ftpClient.login(user, pass);
           ftpClient.enterLocalPassiveMode();
    
           //if the file is not in root we need to change directory
           ftpClient.changeWorkingDirectory("/MahasiswaGet/");
           InputStream inputStream = ftpClient.retrieveFileStream("Mahasiswa.txt");
           Scanner sc = new Scanner(inputStream);
      
      
           //Reading the file line by line and printing the same
           while (sc.hasNextLine()) 
           System.out.println(sc.nextLine());
      
      
           //Closing the channels
           sc.close();
           inputStream.close();
   }
  
  catch (Exception e) 
  {
   e.printStackTrace();
  } 
  
 }

}