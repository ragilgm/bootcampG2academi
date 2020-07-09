import java.util.Collections;

public class PrintLaporan extends DatabaseMahasiswa{

	// method untuk menampilkan isi dari arraylist mahasiswa
	public void printLaporan(String sorting){
	
		System.out.println("Print Laporan Mahasiswa \n");
		System.out.println("ID \t Nama \t Bhs Inggris \t fisika \t Algoritma");
		
		// jika parameter sorting sama dengan 1
		if(sorting.equals("1")) {
			
			// sorting mahasiswa berdasarkan id akan di jalankan 
			Collections.sort(mahasiswa, new IdSorter());
		}else {
			
			// sorting mahasiswa berdasarkan nama akan di jalankan
			Collections.sort(mahasiswa, new NameSorter());
		}
		
				// forEach
                 for(EntityMahasiswa mhs : mahasiswa) {	
                	 System.out.println(""+mhs.getId()+" \t "+
                			 mhs.getNama()+" \t "+
                			 mhs.getNilai().get(0)+" \t \t "+
                			 mhs.getNilai().get(1)+" \t \t "+
                			 mhs.getNilai().get(2));
                 			}
      
	}
	
}
