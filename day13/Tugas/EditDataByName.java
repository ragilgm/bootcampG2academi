import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class EditDataByName extends DatabaseMahasiswa{
	
	public void editMahasiswa(String nama) throws IOException{
		
		// method hashmap saya gunakan untuk mengambil value dari id dari arraylist mahasiswa
		
		// membuat object hashmap
		Map<String,Integer> map = new HashMap<String,Integer>();
		
		// memasukan key (nama) dan value (id) dari arraylist mahasiswa kedalam hashmap
        for (EntityMahasiswa temp : mahasiswa){
            map.put(temp.getNama(), temp.getId());
        }
        
		// method binary seach dari kelas Collection java
        int index = Collections.binarySearch(mahasiswa, new EntityMahasiswa(map.get(nama), nama, null), new IdSorter());
		if(index<=-1) {				
			System.out.println("data tidak di temukan");
			
		}else {
        	System.out.println("Masukan Nama baru : ");
			nama = in.nextLine(); // input user
        	
			// memanggil method get dari kelas Arraylist dan mengubah value dari nama
        	mahasiswa.get(index).setNama(nama);
        	System.out.println("nama berhasil di ubah");
        
	}

					
					
}
	

		
}
	

