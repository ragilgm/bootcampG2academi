import java.io.IOException;
import java.util.Collections;

public class DeleteDataMahasiswa extends DatabaseMahasiswa{
	
	// hapus data mahasiswa berdasarkan parameter
	public void hapusDataMahasiswa(int target) throws IOException{
		
		// method binary seach 
		int index = Collections.binarySearch(mahasiswa, new EntityMahasiswa(target, null, null), new IdSorter());
		
		// jika value dari index <= -1 maka data no exist
		if(index<=-1) {
			System.out.println("data tidak di temukan");
			
		}else {
			// data exist
			mahasiswa.remove(index);
			System.out.println("data berhasil di hapus");
		}

		
	}

}
