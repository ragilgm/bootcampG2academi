import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class EditDataByName extends DatabaseMahasiswa{
	
	public void editMahasiswa(String nama) throws IOException{
		
		Map<String,Integer> map = new HashMap<String,Integer>();
        for (EntityMahasiswa temp : mahasiswa){
            map.put(temp.getNama(), temp.getId());
        }
        
		// pada kesempatan kali saya menggunakan method binary search dari class collections java
        int index = Collections.binarySearch(mahasiswa, new EntityMahasiswa(map.get(nama), nama, null), new IdSorter());
		if(index<=-1) {			
			System.out.println("data tidak di temukan");
			
		}else {
        	System.out.println("Masukan Nama baru : ");
			nama = in.nextLine();
        	
        	mahasiswa.get(index).setNama(nama);
        	System.out.println("nama berhasil di ubah");
        
	}

					
					
}
	

		
}
	

