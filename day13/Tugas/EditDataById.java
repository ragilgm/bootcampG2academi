import java.io.IOException;
import java.util.Collections;



public class EditDataById extends DatabaseMahasiswa{
	

	// edit data mahasisa berdasarkan nama
	public void editMahasiswa(int target) throws IOException{
		
		// method binary search dari kelas Collection java
		int index = Collections.binarySearch(mahasiswa, new EntityMahasiswa(target, null, null), new IdSorter());
		if(index<=-1) {
			
			// data not exist
			System.out.println("data tidak di temukan");
		}else {
			
			// data exist
		System.out.println("Masukan Nama Baru : ");
		String nama = in.nextLine(); // input user
			
		// memanggil methot get dari arraylist untuk merubah nama	
		mahasiswa.get(index).setNama(nama);	
		
		// output ke layar
		System.out.println("data berhasil di rubah");
		}

	}
	
	
}
