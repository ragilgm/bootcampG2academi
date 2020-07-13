import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

// method export data implemets dari runnable (thread)
public class ExportDataMahasiswa extends DatabaseMahasiswa implements Runnable {
	
	// override method run dari class runnable
	@Override
	public void run() {
		try {
			
			// memanggil method exportLaporan
			exportLaporan();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// method export laporan -> untuk mengekport data ke dalam file
	public void exportLaporan() throws IOException {
		 
		// path direktori dari file class Mahasiswa.txt
		// URL object dari URL Java Net
		// localPackageLaporan -> variable
		// this.getClass() -> class ini
		// getResource("Mahasiswa.txt") -> mencari resource dengan nama file "Mahasiswa.txt"
		// getPath() -> mendapatkan inpformasi dari direktori file
		// untuk membuat direktori file menjadi dinamis
    	URL localPackageLaporan = this.getClass().getResource("Mahasiswa.txt");
		String direktoriLaporan = localPackageLaporan.getPath();
	 
		// membuat object fileWriter
		// new FileWriter(direktoriLaporan) -> direktori dinamis
       FileWriter writer = new FileWriter(direktoriLaporan);
       
       // menulis ke file
       writer.write("ID,Nama, Bahasa Inggris , fisika, Algoritma");
       // menulist ke file
       // System.lineSeparator() -> baris baru
       writer.write(System.lineSeparator());
       
       // looping arraylist mahasiwa
       for(EntityMahasiswa mahasiswa: mahasiswa) {
        	
        	String dataMahasiswa = mahasiswa.getId()+
        			","+mahasiswa.getNama()+
        			","+mahasiswa.getNilai().get(0)+
        			","+mahasiswa.getNilai().get(1)+
        			","+mahasiswa.getNilai().get(2);
        	
        	// menulis object dari arraylist mahasiswa ke file
        	writer.write(dataMahasiswa);
        	
        	writer.write(System.lineSeparator());
        }
       
      // menutup file
       writer.close();
    	   
}
	
	
}
