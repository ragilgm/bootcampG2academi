import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;


// method untuk import data implement class runnable (multithreading)
public class InportData extends DatabaseMahasiswa implements Runnable{
	
	// override method run dari class runnable
	@Override
	public void run() {
		try {
			
			// memanggil method inportData
			inportData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// method untuk inport data dari file ke dalam objet arraylist mahasiwa
    public void inportData() throws Exception {
    	
		// path direktori dari file class Mahasiswa.txt
		// URL object dari URL Java Net
		// localPackageLaporan -> variable
		// this.getClass() -> class ini
		// getResource("Mahasiswa.txt") -> mencari resource dengan nama file "Mahasiswa.txt"
		// getPath() -> mendapatkan inpformasi dari direktori file
		// untuk membuat direktori file menjadi dinamis
    	URL localPackageKaryawan = this.getClass().getResource("Mahasiswa.txt");
		String direktoriKaryawan = localPackageKaryawan.getPath();
		
		// membuat object fileReader -> membaca file
        FileReader fr = new FileReader(direktoriKaryawan);
        
        // membuat object BufferReader -> membaca isi file
        BufferedReader br = new BufferedReader(fr);
        
        // membaca 1 baris pertama
        br.readLine();
        
        // variable line
        String line;
        
        // looping untuk membaca seluruh data dari file
        while ((line = br.readLine()) != null) {
        	
        	// memindahkan isi dari file ke dalam array value
        	// line.split(",") -> baris pemotong di tandai dengan delimiter ","
            String[] value = line.split(",");
            
            // arraylist penampung nilai
            ArrayList<Double> nilai = new ArrayList<Double>();
            nilai.add(Double.parseDouble(value[2]));
            nilai.add(Double.parseDouble(value[3]));
            nilai.add(Double.parseDouble(value[4]));
            
            // membuat object entityMahasiwwa
            // Integer.parseInt(value[0]) -> value 1 dirubah dari string ke integer
            // value[1].toLowerCase() -> value ke 2 dirubah menjadi huruf kecil semua
            // Double.parseDouble(value[2]) -> value 3 dirubah dari string ke double
            // Double.parseDouble(value[3]) -> value 4 dirubah dari string ke double
            // Double.parseDouble(value[4]) -> value 5 dirubah dari string ke double
            EntityMahasiswa data = new EntityMahasiswa(
            					  Integer.parseInt(value[0]),
            					  value[1].toLowerCase(), 
            					  nilai
            					  );
            // memasukan data dari file ke dalam object arraylist mahasiwa
            mahasiswa.add(data);
        }
        
        // menutup file
        fr.close();
    }


	
} 
