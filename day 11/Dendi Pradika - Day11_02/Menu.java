import java.util.*;

public class Menu {
	public void pilihMenu() {
		FindMethod method = new FindMethod();
		Scanner in = new Scanner(System.in);  

	  int data = 0;
	       
	  while(data != 99) {
			System.out.println("\nMENU");
	    System.out.println("1. Input Data Mahasiswa.");
	    System.out.println("2. Edit Data Mahasiswa");
	    System.out.println("3. Delete Data Mahasiswa");
	    System.out.println("4. Tampilkan Laporan Nilai Data Mahasiswa");
	    System.out.println("99. EXIT");

	    try {
	    	System.out.print("\nMasukan Pilihan : ");
  			data = in.nextInt();
	    	   
		    if(data==1) {
		    	System.out.print("\n## Masukan Data ##\n");

					System.out.print("\nID Mahasiswa : ");
					int id =in.nextInt();
					
					System.out.print("Nama Mahasiswa: ");
					in.nextLine();
					String nama = in.nextLine();
					
					System.out.print("Nilai Bahasa Inggris : ");
					double inggris = in.nextDouble();
					
					System.out.print("Nilai Fisika : ");
					double fisika = in.nextDouble();
					
					System.out.print("Nilai Algoritma : ");
					double algoritma = in.nextDouble();
					
					method.createData(id, nama, inggris, fisika, algoritma);
						
				} else if(data==2) {
		        System.out.println("\n## Edit Data ##");
		    		System.out.print("Masukkan ID Mahasiswa : ");
						int pilihId = in.nextInt();

		    		System.out.println("\n## Pilih data yang akan di edit : ");
		        System.out.println("1. Edit Nama");
		        System.out.println("2. Edit Nilai Bahasa Inggris");
		        System.out.println("3. Edit Nilai Fisika");
		        System.out.println("4. Edit Nilai Algoritma\n");

		        System.out.print("Pilihan anda : ");
						int pilihEdit = in.nextInt();

						if(pilihEdit==1){
		          System.out.print("Masukkan Nama Baru : ");
		          in.nextLine();
		          String nama = in.nextLine();

		          method.editNama(pilihId, nama);
						} else if(pilihEdit==2){
								System.out.print("Masukkan Nilai Bahasa Inggris : ");
								double inggris = in.nextDouble();
							
		          	method.editNilaiInggris(pilihId, inggris);
						} else if(pilihEdit==3){
								System.out.print("Nilai Fisika : ");
								double fisika = in.nextDouble();
							
		          	method.editNilaiFisika(pilihId, fisika);
						} else if(pilihEdit==4){
								System.out.print("Nilai Algoritma : ");
								double algoritma = in.nextDouble();
							
		          	method.editNilaiAlgoritma(pilihId, algoritma);
						} else {
								System.out.println("Maaf, anda salah input.");
						}
				} else if(data==3) {
		        System.out.println("\n## Delete Data ##");
		    		System.out.print("Masukkan ID Mahasiswa : ");
						int pilihId = in.nextInt();

						method.delete(pilihId); 
				} else if(data==4) {
					method.laporan();
				} else if(data==99) {
						System.out.println("Terima kasih.");
				} else {
						System.out.println("Maaf, anda salah input.");
				}
			} catch(InputMismatchException exception) {
					System.out.println("Maaf, anda salah input.");
			  in.next();
			}
	 	}
	}
}
