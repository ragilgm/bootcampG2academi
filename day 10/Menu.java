import java.io.IOException;
import java.util.Scanner;


public class Menu {

	public static void main(String[] args) throws IOException {
		
		Crud crud = new Crud();
		
		// scanner
		Scanner in = new Scanner(System.in);  
	       String data = "";
	       
	       while(!data.equals("4")) {
			   // menu
	    	   System.out.println("MENU");
	    	   System.out.println("1. Buat Worker.");
	    	   System.out.println("2. Input Absensi");
	    	   System.out.println("3. Print Absen");
	    	   System.out.println("4. Exit");
	    	   
	    	   System.out.print("Input Pilihan : ");
	    	   data = in.nextLine();
	    	   
	    	   switch (data) {
			case "1":
					System.out.println("1. input Staff");
					System.out.println("2. input Manager");
					
					System.out.print("Input Pilihan : ");
					String input = in.nextLine();
					switch (input) {
					case "1":
						System.out.println("Masukan Nama :");
						String nama = in.nextLine();
						
						crud.createStaff(nama);
						break;
					case "2":
						System.out.println("1. Masukan Nama :");
						nama = in.nextLine();
						
						crud.createManger(nama);
						break;
					}
					break;
			case "2":
				System.out.println("1. absen Staff");
				System.out.println("2. absen Manager");
				
				System.out.print("Input Pilihan : ");
				input = in.nextLine();
				switch (input) {
				case "1":
					System.out.println("1. Masukan id :");
					int id = in.nextInt();
					crud.absenStaff(id);
					break;
				case "2":
					System.out.println("1. Masukan id :");
					id = in.nextInt();
					crud.absenManager(id);
					break;
				}
				break;
			case "3":
				System.out.println("1. print absen Staff");
				System.out.println("2. print absen Manager");
				
				System.out.print("Input Pilihan : ");
				input = in.nextLine();
				switch (input) {
				case "1":
					crud.printAbsenStaff();
					break;
				case "2":
					crud.printAbsenManager();
					break;
				}
				break;
			case "4":
				break;
			default:
				System.out.println("your input is not exist");
				break;
			}
	  
	       } 

	       in.close();


	}
}
