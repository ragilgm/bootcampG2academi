import java.io.IOException;
import java.util.Collections;

public class DeleteDataMahasiswa extends DatabaseMahasiswa{
	
	// hapus data mahasiswa
	public void hapusDataMahasiswa(int target) throws IOException{
		
		int index = Collections.binarySearch(mahasiswa, new EntityMahasiswa(target, null, null), new IdSorter());
		
		if(index<=-1) {
			System.out.println("data tidak di temukan");
			
		}else {

			mahasiswa.remove(index);
			System.out.println("data berhasil di hapus");
		}

		
	}

}
