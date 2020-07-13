public class CheckDuplikatData extends DatabaseMahasiswa{
	
public boolean Check(String nama) throws Exception{
	
	// variable duplikat akan mereturnkan value = true or false
	boolean duplikat = false;
	
	// convert nama ke dalam huruf kecil semua
	nama.toLowerCase();
	
	// variable counter
	// di buat untuk menghitung jumlah data duplikasi
	// counter di mulai dari 0
	int counter = 0;
	for( int i=0; i<mahasiswa.size(); i++) {
		
		// jika nama dari arraylist mahasiswa = nama yang di input user
		// maka variable counter akan bertambah
	    if(mahasiswa.get(i).getNama().equals(nama)) {
	    	counter++;
	    }
	}
	
	// jika variable counter > 1
	// ada data duplikasi
	if(counter>1) {
		
		// value dari variable duplikat menjadi true
		duplikat = true;
		
		// data duplikasi di tampilkan ke layar
		System.out.println("ada duplikat data");
		System.out.println("ID \t Nama \t");
		for(EntityMahasiswa mhs:mahasiswa) {
			if(mhs.getNama().equals(nama)) {
				System.out.println(
						mhs.getId()+" \t "+
						mhs.getNama()+" \t "	
						);
					
			}
		}
	}else {
		
		// tidak ada data duplikasi
		// value variable duplikat = false
		duplikat = false;
		System.out.println("data tidak duplikat");
	}
	
	// return value dari boolean check duplikat
	return duplikat;
}

}
