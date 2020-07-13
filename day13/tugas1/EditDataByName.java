import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class EditDataByName extends DatabaseMahasiswa{
	
	// method edit data mahasiswa
	public void editMahasiswa(String nama) throws IOException{
		
		// Membuat Object HashMap
		// Map<String,Integer> -> key = String , value = integer
		Map<String,Integer> map = new HashMap<String,Integer>();
		
		// looping untuk memasukan data ke dalam HashMap
		// (key) nama dari arraylist mahasiswa
		// (value) id dari arraylist mahasiswa
		// map.put -> method untuk memasukan arraylist ke dalam hashmap
		// temp.getNama() -> nama dari mahasiswa
		// temp.getId() -> id dari mahasiswa
        for (EntityMahasiswa temp : mahasiswa){
            map.put(temp.getNama(), temp.getId());
        }
        
		// method binary seach dari kelas Collaction java
		// variable index -> mendapatkan value index arraylist mahasiswa yang telah di dapatkan oleh binary seach (class collection binary seach)
		// -> mahasiswa = list dari mahasiswa (arraylist)
		// -> new EntityMahasiswa(map.get(nama), nama, null) -> membuat object baru untuk acuan seaching
        // -> map.get(nama) -> value dari (key) nama -> value nya berarti index nya
		// -> nama -> nama dari parameter yang akan di cari
		// -> null -> nilai default
		// -> new IdSorter -> membuat object comparable by Id dari kelas IdSorter
        int index = Collections.binarySearch(mahasiswa, new EntityMahasiswa(map.get(nama), nama, null), new IdSorter());
		
        // jika index <= -1 -> index tidak di temukan
        if(index<=-1) {			
			System.out.println("data tidak di temukan");
			
		}else {
			
		// jika value idex != -1 -> index di temukan	
        	System.out.println("Masukan Nama baru : ");
			nama = in.nextLine();  // input user
        	
		// memanggil method get dari class arraylist mahasiswa
		// get(index) -> index dari arraylist mahasiswa
		// setNama(nama) -> method untuk merubah nama
        	mahasiswa.get(index).setNama(nama);
        	System.out.println("nama berhasil di ubah");
        
	}

					
					
}
	

		
}
	

