import java.util.Scanner;


public class Menu {

	public static void main(String[] args) {
		
		Crud crud = new Crud();
		
		// scanner
		Scanner in = new Scanner(System.in);  
	       String data = "";
	       
	       while(!data.equals("3")) {
			   // menu
	    	   System.out.println("MENU");
	    	   System.out.println("1. Buat Worker.");
	    	   System.out.println("2. Hitung Tunjangan");
	    	   System.out.println("3. Exit");
	    	   
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
						
						System.out.println("Masukan Absensi :");
						int absensi = in.nextInt();
						crud.createStaff(nama, absensi);
						break;
					case "2":
						System.out.println("1. Masukan Nama :");
						nama = in.nextLine();
						
						System.out.println("Masukan Absensi :");
						absensi = in.nextInt();
						crud.createManger(nama, absensi);
						break;
					}
					break;
			case "2":
				System.out.println("1. input id Staff");
				System.out.println("2. input id Manager");
				
				System.out.print("Input Pilihan : ");
				input = in.nextLine();
				switch (input) {
				case "1":
					System.out.println("1. Masukan id :");
					int id = in.nextInt();
					crud.hitungTunjanganStaff(id);
					break;
				case "2":
					System.out.println("1. Masukan id :");
					id = in.nextInt();
					crud.hitungTunjanganManager(id);
					break;
				}
				break;
			case "3":
				break;
			default:
				System.out.println("your input is not exist");
				break;
			}
	  
	       } 

	       in.close();


	}
}
