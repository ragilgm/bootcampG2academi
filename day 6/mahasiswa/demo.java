import java.util.Scanner;

public class demo {

	public static void main(String[] args) {
		CrudOperation crud = new CrudOperation();
		
		// scanner
		Scanner in = new Scanner(System.in);  
	       String data = "";
	       
	       while(!data.equals("6")) {
			   // menu
	    	   System.out.println("MENU");
	    	   System.out.println("1. Input Data Mahasiswa.");
	    	   System.out.println("2. Edit Data Mahasiswa.");
	    	   System.out.println("3. Print Data Mahasiswa.");
	    	   System.out.println("4. Tulis Data Mahasiswa ke File");
	    	   System.out.println("5. EXIT");
	    	   
	    	   System.out.print("Input Pilihan : ");
	    	   data = in.nextLine();
	    	   
	    	   switch (data) {
			case "1":
				
				//input id
				System.out.print("masukan id :");
				int id =in.nextInt();
				in.hasNextLine();
				
				// input nama
				System.out.print("Masukan Nama : ");
				in.nextLine();
				String nama = in.nextLine();
				
				
				// input nilai matematika
				System.out.print("Masukan Nilai Matematika : ");
				int matematika = in.nextInt();
				in.nextLine();
				
				// input nilai b.indonesia
				System.out.print("Masukan nilai B.Indonesia : ");
				int b_indo = in.nextInt();
				in.nextLine();
				
				// input nilai fisika
				System.out.print("Masukan nilai fisika : ");
				int fisika = in.nextInt();
				in.nextLine();
				
				// create data
					crud.createData(id, nama, matematika, b_indo, fisika);
					
				
				break;
			case "2":
				try {
				System.out.print("Masukan ID :");
				int idEdit = in.nextInt();
				in.nextLine();
				
				System.out.print("Masukan Nama : ");
				String editNama = in.nextLine();
				
				// memanggil method editData dari kelas CrudOperation
				crud.editData(idEdit, editNama);
				
				System.out.println("Data Berhasil di Edit..");
				} catch (Exception e) {
					System.err.println("Kesalahan pada "+e);
				}
				
				break;
			case "3":
				// memangil method showData dari kelas CrudOperation
				crud.showData();
				break;
			case "4":
				// memanggil method printText dari kelas CrudOperation
				crud.printText();
				break;
			case "5":
				System.out.print("Masukan Id : ");
				int deleteId = in.nextInt();
				crud.deleteData(deleteId);
				in
				break;
			default:
				System.out.println("your input is not exist");
				break;
			}
	  
	       } 
	}
	
	

}
