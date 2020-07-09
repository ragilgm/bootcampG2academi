import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

public class ExportDataMahasiswa extends DatabaseMahasiswa implements Runnable {
	
	@Override
	public void run() {
		try {
			exportLaporan();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void exportLaporan() throws IOException {
		 
    	URL localPackageLaporan = this.getClass().getResource("Mahasiswa.txt");
		String direktoriLaporan = localPackageLaporan.getPath();
	 
       FileWriter writer = new FileWriter(direktoriLaporan);
       
       writer.write("ID,Nama, Bahasa Inggris , fisika, Algoritma");
     writer.write(System.lineSeparator());
       for(EntityMahasiswa mahasiswa: mahasiswa) {
        	
        	String dataMahasiswa = mahasiswa.getId()+
        			","+mahasiswa.getNama()+
        			","+mahasiswa.getNilai().get(0)+
        			","+mahasiswa.getNilai().get(1)+
        			","+mahasiswa.getNilai().get(2);
        	writer.write(dataMahasiswa);
        	writer.write(System.lineSeparator());
        }
  	writer.close();
    	   
}
	
	
}
