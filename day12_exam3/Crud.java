import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Pattern;


public class Crud {
	
	ArrayList<Staff> staff;
	
	public Crud() {
		staff = new ArrayList<Staff>();
	}
	
	
public boolean Validation(String args,String username, String password) throws IOException {
	
	URL localPackageKaryawan = this.getClass().getResource(args);
	String direktorykaryawan = localPackageKaryawan.getPath();
   
   boolean LoginUsername = Pattern.matches("^(.+)@(.+)$", username);
	boolean LoginPassword = Pattern.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).{8,}$", password);
   
	
    FileReader fr = new FileReader(direktorykaryawan);
    
    BufferedReader br = new BufferedReader(fr);
    String line;
    
    boolean result = false;
    
    if(LoginUsername && LoginPassword) {
    
    while ((line = br.readLine()) != null) {
    	
        String[] value = line.split(",");
        if(value[0].equals(username) && value[1].equals(password)) {
        result = true;
        }else {
        	result = false;
        }
    }
    fr.close();
    }else {
    	result = false;
   
    }
	return result;
    
        
       
        	
  }

        
	
	
	
	
	
    public void inportData() throws Exception {
    	
    	URL localPackageKaryawan = this.getClass().getResource("karyawan.txt");
		String direktoriKaryawan = localPackageKaryawan.getPath();
		
        FileReader fr = new FileReader(direktoriKaryawan);
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
        System.out.println("data berhasil di import");
        fr.close();
    }
    
	public void createStaff(String nama, int gajiPokok, int absensi, int jumlahCuti) {
		int counter = 0;
		if(staff.size()!=0) {
			counter = staff.size()+1;
		}else {
			counter++;
		}
		try {
			staff.add(new Staff(counter, nama.toLowerCase(), gajiPokok, absensi, jumlahCuti));
		System.out.println("data berhasil di tambahkan..");
		} catch (Exception e) {
			System.err.println("data gagal di tambahkan. kesalahan pada "+e);
		}
			
	}
	
	
public void editDataById(int id, String nama, int gajiPokok) throws IOException{
		
		for( int i=0; i<staff.size(); i++) {
		    if(staff.get(i).getId() == id) {
		    	System.out.println("Nama : "+ staff.get(i).getNama());
		    	staff.get(i).setNama(nama);
		    	staff.get(i).setGajiPokok(gajiPokok);
		    	System.out.println("absen berhasil di update");
		    	break;
		    }else {
		    	System.out.println("absen gagal di update");
		    }
		}
		
	}

public void editDataByName(String nama, String newName, int gajiPokok) throws IOException{
	
	for( int i=0; i<staff.size(); i++) {
	    if(staff.get(i).getNama().equals(nama)) {
	    	System.out.println("Nama : "+ staff.get(i).getNama());
	    	staff.get(i).setNama(nama);
	    	staff.get(i).setGajiPokok(gajiPokok);
	    	System.out.println("absen berhasil di update");
	    	break;
	    }else {
	    	System.out.println("absen gagal di update");
	    }
	}
	
}
	
	public void setAbsenById(int id) throws IOException{
		
		for( int i=0; i<staff.size(); i++) {
		    if(staff.get(i).getId() == id) {
		    	System.out.println("Nama : "+ staff.get(i).getNama());
		    	staff.get(i).setAbsensi(1);
		    	System.out.println("absen berhasil di update");
		    	break;
		    }else {
		    	System.out.println("absen gagal di update");
		    }
		}
		
	}
	public void setAbsenByNama(String nama) throws IOException{
		nama.toLowerCase();
		for( int i=0; i<staff.size(); i++) {
		    if(staff.get(i).getNama().equals(nama)) {
		    	System.out.println("Nama : "+ staff.get(i).getNama());
		    	staff.get(i).setAbsensi(1);
		    	System.out.println("absen berhasil di update");
		    	break;
		    }else {
		    	System.out.println("absen gagal di update");
		    }
		}
		
	}
	
	public void setCutiById(int id) throws IOException{
		
		for( int i=0; i<staff.size(); i++) {
		    if(staff.get(i).getId() == id) {
		    	staff.get(i).setJumlahCuti();
		    	System.out.println("cuti berhasil di update");
		    	break;
		    }else {
		    	System.out.println("cuti gagal di update");
		    }
		}
		
	}
	
	public void setCutiByName(String name) throws IOException{
		for( int i=0; i<staff.size(); i++) {
		    if(staff.get(i).getNama().equals(name.toLowerCase())) {
		    	staff.get(i).setJumlahCuti();
		    	System.out.println("cuti berhasil di update");
		    	break;
		    }else {
		    	System.out.println("cuti gagal di update");
		    }
		}
		
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
	
	
	public void ShowDataById(int id) throws IOException{
		for( int i=0; i<staff.size(); i++) {
		    if(staff.get(i).getId() == id) {
		    	System.out.println("Data berhasil di temukan");
		    	System.out.println("Id : "+ staff.get(i).getId());
		    	System.out.println("Nama "+staff.get(i).getNama());
		    	System.out.println("\n");
		    	System.out.println(" id : "+staff.get(i).getId());
	            System.out.println(" nama : "+staff.get(i).getNama());
	            System.out.println(" Absensi : "+staff.get(i).getAbsensi());
	            System.out.println(" Jumlah Cuti : "+staff.get(i).getJumlahCuti());
	            System.out.println(" Jumlah Tanpa Kabar : "+staff.get(i).getTanpaKabar());
	            System.out.println(" Tunjangan Makan : "+staff.get(i).HitungTunjanganMakan());
	            System.out.println(" Tunjangan Transport : "+staff.get(i).HitungTunjanganTransport());
	            System.out.println(" Gaji Pokok : "+staff.get(i).hitungGajiPokok());
	            System.out.println(" TOTAL GAJI : "+staff.get(i).hitungTotalGaji());
		    }else {
		    	System.out.println("data tidak di temukan");
		    }
		}
		
	}
	
	public void ShowDataByName(String name) throws IOException{
		name.toLowerCase();
		for( int i=0; i<staff.size(); i++) {
		    if(staff.get(i).getNama() == name) {
		    	System.out.println("Data berhasil di temukan");
		    	System.out.println("Id : "+ staff.get(i).getId());
		    	System.out.println("Nama "+staff.get(i).getNama());
		    	System.out.println("\n");
		    	System.out.println(" id : "+staff.get(i).getId());
	            System.out.println(" nama : "+staff.get(i).getNama());
	            System.out.println(" Absensi : "+staff.get(i).getAbsensi());
	            System.out.println(" Jumlah Cuti : "+staff.get(i).getJumlahCuti());
	            System.out.println(" Jumlah Tanpa Kabar : "+staff.get(i).getTanpaKabar());
	            System.out.println(" Tunjangan Makan : "+staff.get(i).HitungTunjanganMakan());
	            System.out.println(" Tunjangan Transport : "+staff.get(i).HitungTunjanganTransport());
	            System.out.println(" Gaji Pokok : "+staff.get(i).hitungGajiPokok());
	            System.out.println(" TOTAL GAJI : "+staff.get(i).hitungTotalGaji());
		    }else {
		    	System.out.println("data tidak di temukan");
		    }
		}
		
	}
	
	
	public void Laporan() {
		System.out.println("PENGHITUNGAN GAJI KARYAWAN PRIODE JUNI 2O20 \n");
		
			for(Staff worker:staff) {
	            System.out.println(" id : "+worker.getId());
	            System.out.println(" nama : "+worker.getNama());
	            System.out.println(" Absensi : "+worker.getAbsensi());
	            System.out.println(" Jumlah Cuti : "+worker.getJumlahCuti());
	            System.out.println("Jumlah Tanpa Kabar : "+worker.getTanpaKabar());
	            System.out.println(" TOTAL GAJI : "+worker.hitungTotalGaji());
	    		System.out.println("--------------------------------------------------");
	        }
	}
	
	
	
	
	 	 public void exportLaporan() throws IOException {
		 
	    	URL localPackageLaporan = this.getClass().getResource("LaporanKaryawan.csv");
			String direktoriLaporan = localPackageLaporan.getPath();
		 
	       FileWriter writer = new FileWriter(direktoriLaporan);
	       
	       writer.write("ID,Nama, JmlAbsensi , JmlCutiTerpakai, JmlTanpaKabar, TotalGaji");
         writer.write(System.lineSeparator());
	       for(Staff karyawan: staff) {
	        	
	        	String dataKaryawan = karyawan.getId()+
	        			","+karyawan.getNama()+
	        			","+karyawan.getAbsensi()+
	        			","+karyawan.getJumlahCuti()+
	        			","+karyawan.getTanpaKabar()+
	        			","+karyawan.hitungTotalGaji();
	        	writer.write(dataKaryawan);
	        	writer.write(System.lineSeparator());
	        }
	        
	       System.out.println("data berhasil di export");  
      	writer.close();
	    	   
}
	    	   
}
	
	

