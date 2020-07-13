// kelas check duplikasi data
public class CheckDuplikatData extends DatabaseMahasiswa{
	
// method untuk mengecek data duplikat
// method ini akan mereturn kan value true or false
public boolean Check(String nama) throws Exception{
	
	// variable boolean duplikat
	boolean duplikat = false;
	
	// parameter nama to lowercase
	nama.toLowerCase();
	
	// variabe counter -> untuk menghitung jumlah duplikat data
	int counter = 0;
	
	// looping duplikat data
	for( int i=0; i<mahasiswa.size(); i++) {
	    
		// jika nama (arraylist mahasiswa) = nama (parameter)
		if(mahasiswa.get(i).getNama().equals(nama)) {
	    	
	    	// value counter += 1
	    	counter++;
	    }
	}
	
	// jika value dari variable counter > 1
	if(counter>1) {
		
		// variable duplikat true -> terdapat data duplikat
		duplikat = true;
		
		System.out.println("terdapat duplikasi data");
		System.out.println("ID \t Nama \t");
		
		// looping untuk menampilkan jumlah data duplikat
		for(EntityMahasiswa mhs:mahasiswa) {
			
			// jika nama (arraylist mahasiswa) = nama (parameter)
			if(mhs.getNama().equals(nama)) {
				
				// munculkan id - dan nama
				System.out.println(
						mhs.getId()+" \t "+
						mhs.getNama()+" \t "	
						);
					
			}
		}
	}else {
		
		// duplikat false -> tidak terdapat duplikasi data
		duplikat = false;
	}
	
	// return duplikat
	return duplikat;
}

}
