public class ShowData extends DatabaseMahasiswa implements Runnable{
	
	@Override
	public void run() {
		try {
			printLaporan();	
		} catch (Exception e) {
		}
	}
	
	public void printLaporan(){
		System.out.println("Print Laporan Mahasiswa \n");
		System.out.println("ID \t Nama \t Bhs Inggris \t fisika \t Algoritma");
	
		
				// forEach
                 for(EntityMahasiswa mhs : mahasiswa) {	
                	 System.out.println(""+mhs.getId()+" \t "+
                			 mhs.getNama()+" \t "+
                			 mhs.getNilai().get(0)+" \t \t "+
                			 mhs.getNilai().get(1)+" \t \t "+
                			 mhs.getNilai().get(2));
                 			}
         		}

}
