public class CheckDuplikatData extends DatabaseMahasiswa{
	
public boolean Check(String nama) throws Exception{
	
	boolean duplikat = false;
	nama.toLowerCase();
	int counter = 0;
	for( int i=0; i<mahasiswa.size(); i++) {
	    if(mahasiswa.get(i).getNama().equals(nama)) {
	    	counter++;
	    }
	}
	
	if(counter>1) {
		duplikat = true;
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
		duplikat = false;
		System.out.println("data tidak duplikat");
	}
	return duplikat;
}

}
