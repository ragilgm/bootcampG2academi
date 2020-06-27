import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;


public class Menu {

	public int menghitungLuasPersegi(int panjang, int lebar) {
		 int luas = panjang * lebar;
		 return luas;
	 }
	 public double menghitungLingkaran(double r) {
		 double phi = 3.14;
		 double luas = phi * (r * r);
		 return luas;
	 } 
	 
	 public void createText(String title, String text) {
			String argument = title;
			String isi = text;
		    
		    try{    
		       FileWriter writer = new FileWriter("D:\\bootcamp\\bootcamp G2ACADEMY\\materi\\day 6\\"+argument+".txt");
		        BufferedWriter buffer = new BufferedWriter(writer);
		        buffer.write(isi);
		        buffer.close();    
		        System.out.println("success...");    
		       }catch(Exception e){System.out.println(e);}    
	 }
	 
	 public static void main(String[] args) {
		 Menu menu = new Menu();
	       Scanner in = new Scanner(System.in);  
	       String data = "";
	       
	       while(!data.equals("4")) {
	    	   System.out.println("MENU");
	    	   System.out.println("1. Luas Persegi Panjang");
	    	   System.out.println("2. Luas Lingkaran");
	    	   System.out.println("3. Tulis Data ke File");
	    	   System.out.println("4. EXIT");
	    	   
	    	   System.out.print("Input Data: ");  
	    	   data = in.nextLine();
	    	   switch (data) {
			case "1":
				System.out.print("masukan panjang :");
				int panjang = Integer.parseInt(in.nextLine());
				System.out.print("Masukan Lebar : ");
				int lebar = Integer.parseInt(in.nextLine());
				int hasil = menu.menghitungLuasPersegi(panjang, lebar);
				System.out.println("luas persegi : "+hasil);
				break;
			case "2":
				System.out.print("Masukan Luas Lingkaran :");
				double luas = Double.parseDouble(in.nextLine());
				double luas1 = menu.menghitungLingkaran(luas);
				System.out.println("luas Linkaran : "+luas1);
				break;
			case "3":
				System.out.print("Masukan title : ");
				String title = in.nextLine();
				System.out.print("Masukan Text : ");
				String text = in.nextLine();
				menu.createText(title, text);
				break;
			}
	  
	       }
	          in.close();      
		 
		
	}
	

}