import java.io.IOException;
import java.util.Collections;

public class DeleteDataMahasiswa extends DatabaseMahasiswa{
	
	// hapus data mahasiswa
	public void hapusDataMahasiswa(int target) throws IOException{
		
		// method binary seach dari kelas Collaction java
		// variable index -> mendapatkan value index arraylist mahasiswa yang telah di dapatkan oleh binary seach (class collection binary seach)
		// -> mahasiswa = list dari mahasiswa (arraylist)
		// -> new EntityMahasiswa(target, null, null) -> membuat object baru untuk acuan seaching
		// -> target -> target dari parameter yang akan di cari
		// -> null -> nilai default
		// -> new IdSorter -> membuat object comparable by Id dari kelas IdSorter
		int index = Collections.binarySearch(mahasiswa, new EntityMahasiswa(target, null, null), new IdSorter());
		
		// jika index <= -1 -> index tidak di temukan
		if(index<=-1) {
			System.out.println("data tidak di temukan");
			
		}else {
			
		// jika index > -1 -> index di temukan
			
			// memangil method remove dari Class Arraylist -> menghapus index mahasiswa (arraylist)
			mahasiswa.remove(index);
			System.out.println("data berhasil di hapus");
		}

		
	}

}
