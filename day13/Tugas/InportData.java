import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;

public class InportData extends DatabaseMahasiswa{
	
    public void inportData() throws Exception {
    	
    	URL localPackageKaryawan = this.getClass().getResource("Mahasiswa.txt");
		String direktoriKaryawan = localPackageKaryawan.getPath();
		
        FileReader fr = new FileReader(direktoriKaryawan);
        BufferedReader br = new BufferedReader(fr);
        br.readLine();
        String line;
        
        while ((line = br.readLine()) != null) {
            String[] value = line.split(",");
            ArrayList<Double> nilai = new ArrayList<Double>();
            nilai.add(Double.parseDouble(value[2]));
            nilai.add(Double.parseDouble(value[3]));
            nilai.add(Double.parseDouble(value[4]));
            EntityMahasiswa data = new EntityMahasiswa(
            					  Integer.parseInt(value[0]),
            					  value[1].toLowerCase(), 
            					  nilai
            					  );
            mahasiswa.add(data);
        }

        fr.close();
    }


	
} 
