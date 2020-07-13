package Karyawan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class Crud {
	
	protected ArrayList<Staff> staff;
	
	public Crud() {
		staff = new ArrayList<Staff>();
	}	
	
    public void inportData(String filename) throws Exception {
        FileReader fr = new FileReader("C:\\Users\\ragil\\eclipse-workspace\\JavaFTP\\src\\FileKaryawan\\"+filename);
        BufferedReader br = new BufferedReader(fr);
        br.readLine();
        String line;
        
        while ((line = br.readLine()) != null) {
            String[] value = line.split(",");
            Staff work = new Staff(Integer.parseInt(value[0]),
            					  value[1].toLowerCase(), 
            					  Integer.parseInt(value[2]), 
            					  Integer.parseInt(value[3]), 
            					  Integer.parseInt(value[4]));
            staff.add(work);	   
        }
        System.out.println("data berhasil di Proses ");
        hitungTotalGaji();
        fr.close();
    }
    
    
	public void hitungTotalGaji() {
		System.out.println("PENGHITUNGAN GAJI KARYAWAN PRIODE JUNI 2O20 \n");
		
			for(Staff worker:staff) {
	            System.out.println(" id : "+worker.getId());
	            System.out.println(" nama : "+worker.getNama());
	            System.out.println(" Absensi : "+worker.getAbsensi());
	            System.out.println(" Jumlah Cuti : "+worker.getJumlahCuti());
	            System.out.println("Jumlah Tanpa Kabar : "+worker.getTanpaKabar());
	            System.out.println(" Tunjangan Makan : "+worker.HitungTunjanganMakan());
	            System.out.println(" Tunjangan Transport : "+worker.HitungTunjanganTransport());
	            System.out.println(" Gaji Pokok : "+worker.hitungGajiPokok());
	            System.out.println(" TOTAL GAJI : "+worker.hitungTotalGaji());
	    		System.out.println("--------------------------------------------------");
	        }
	}

     	   
}
	
	

