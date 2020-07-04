import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static boolean isValidEmailId(String username) {
		Pattern checkPatternUser = Pattern.compile("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
    Matcher validPatternUser = checkPatternUser.matcher(username);
    return validPatternUser.matches();
  }

  public static boolean isValidPassword(String password) {		
		Pattern checkPatternPass = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}");
    Matcher validPatternPass = checkPatternPass.matcher(password);
    return validPatternPass.matches();
  }

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);  

    try{
      File usr = new File("D:\\bootcamp\\bootcamp G2ACADEMY\\materi\\day 11\\dendi\\username.txt");
      Scanner scanUsr = new Scanner(usr);
        
      while(scanUsr.hasNextLine()){
        String getDataUsr = scanUsr.nextLine();
    			
    		if(isValidEmailId(getDataUsr)){
          File pwd = new File("D:\\bootcamp\\bootcamp G2ACADEMY\\materi\\day 11\\dendi\\password.txt");
          Scanner scanPwd = new Scanner(pwd);
            
          while(scanPwd.hasNextLine()){
            String getDataPwd = scanPwd.nextLine();

            if(isValidPassword(getDataPwd)){
            	System.out.println("\n## Berhasil Login ##");
							Menu pilihMenu = new Menu();
							pilihMenu.pilihMenu();
            }else{
             	System.out.println("Maaf, Password salah.");
            }
          }
      		scanPwd.close();
        }else{
        	 System.out.println("Maaf, Username salah.");
        }
      }
      scanUsr.close();
    }catch(FileNotFoundException ex){
    	System.out.println("File Tidak Ditemukan"); 
    }
	}
}
 