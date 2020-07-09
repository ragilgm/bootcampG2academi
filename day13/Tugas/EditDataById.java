import java.io.IOException;
import java.util.Collections;



public class EditDataById extends DatabaseMahasiswa{
	

	// edit data mahasisa berdasarkan nama
	public void editMahasiswa(int target) throws IOException{
		
		int index = Collections.binarySearch(mahasiswa, new EntityMahasiswa(target, null, null), new IdSorter());
		if(index<=-1) {
			System.out.println("data tidak di temukan");
		}else {
			
		System.out.println("Masukan Nama Baru : ");
		String nama = in.nextLine(); // the element to be searched
			
		mahasiswa.get(index).setNama(nama);	
		
		System.out.println("data berhasil di rubah");
		}

	}
	
	
}
