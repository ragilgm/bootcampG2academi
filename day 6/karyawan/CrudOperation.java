import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class CrudOperation {

	static ArrayList<Staff> staff;
	
	public CrudOperation() {
		//instansiasi
        staff = new ArrayList<Staff>();

	}
	
	public void createData(String nama, int gajiPokok) {
		Staff karyawan = new Staff();
		int counter = 0;
		if(staff.size()!=0) {
			counter = staff.size()+1;
		}else {
			counter++;
		}
		try {
		staff.add(new Staff(
				counter,
				nama,
				gajiPokok,
				karyawan.getAbsensi(), 
				karyawan.getJumlahCuti(), 
				karyawan.getTunjanganMakan(), 
				karyawan.getTunjanganTransport(), 
				karyawan.getTotalGaji()));
		System.out.println("data berhasil di tambahkan..");
		} catch (Exception e) {
			System.err.println("data gagal di tambahkan. kesalahan pada "+e);
		}
			
	}
	
	public void editData(String input, String namaKaryawan) throws IOException{
		String nama = input.toLowerCase();
		int id = Integer.parseInt(input);
		for( int i=0; i<staff.size(); i++) {
		    if(staff.get(i).getId() == id || staff.get(i).getNama().equals(nama)) {
		    	staff.set(staff.get(i).getId()-1, 
		    			new Staff(
		    					staff.get(i).getId(),
		    					staff.get(i).setNama(namaKaryawan), staff.get(i).getGajiPokok(), 
		    					staff.get(i).getAbsensi(), 
		    					staff.get(i).getJumlahCuti(), 
		    					staff.get(i).getTunjanganMakan(),
		    					staff.get(i).getTunjanganTransport(), 
		    					staff.get(i).getTotalGaji()));
		    	System.out.println("data berhasil di edit..");
		        break;
		    }
		}
		
	}
	
	public void absensiKaryawan(String input) throws IOException{
		int absen = 1;
		String nama = input.toLowerCase();
		int id = Integer.parseInt(input);
		
		for( int i=0; i<staff.size(); i++) {
		    if(staff.get(i).getId() == id || staff.get(i).getNama().equals(nama)) {
		    	System.out.println("Nama : "+ staff.get(i).getNama());
		    	staff.set(staff.get(i).getId()-1, 
		    			new Staff(
		    			staff.get(i).getId(), 
		    			staff.get(i).getNama(), 
		    			staff.get(i).getGajiPokok(), 
		    			staff.get(i).setAbsensi(absen), 
		    			staff.get(i).getJumlahCuti(), 
		    			staff.get(i).getTunjanganMakan(),
		    			staff.get(i).getTunjanganTransport(), 
		    			staff.get(i).getTotalGaji()
		    			));
		    	
		    	System.out.println("absen berhasil di update");
		    	break;
		    }else {
		    	System.out.println("absen gagal di update");
		    }
		}
		
	}
	
	public void cutiKaryawan(String input) throws IOException{
		int cuti = 1;
		String nama = input.toLowerCase();
		int id = Integer.parseInt(input);
		
		for( int i=0; i<staff.size(); i++) {
		    if(staff.get(i).getId() == id || staff.get(i).getNama().equals(nama)) {
		    	staff.set(staff.get(i).getId()-1, 
		    			new Staff(
		    			staff.get(i).getId(),
		    			staff.get(i).getNama(),
		    			staff.get(i).getGajiPokok(), 
		    			staff.get(i).getAbsensi(), 
		    			staff.get(i).setJumlahCuti(cuti),
		    			staff.get(i).getTunjanganMakan(),
		    			staff.get(i).getTunjanganTransport(), 
		    			staff.get(i).getTotalGaji()));
		    	System.out.println("cuti berhasil di update");
		    	break;
		    }else {
		    	System.out.println("cuti gagal di update");
		    }
		}
		
	}
	
	public int totalGaji(int gajiPokok, int makan, int transport) {
		int totalGaji = gajiPokok + makan + transport;
		return totalGaji;
	}
	
	
	public void hitungTotalGaji() {
		System.out.println("PENGHITUNGAN GAJI KARYAWAN PRIODE JUNI 2O20 \n");
		
			for(Staff worker:staff) {
	            System.out.println(" id : "+worker.getId());
	            System.out.println(" nama : "+worker.getNama());
	            System.out.println(" Absensi : "+worker.getAbsensi());
	            System.out.println(" Jumlah Cuti : "+worker.getJumlahCuti());
	            System.out.println(" Tunjangan Makan : "+worker.hitungTunjanganMakan());
	            System.out.println(" Tunjangan Transport : "+worker.hitungTransport());
	            System.out.println(" Gaji Pokok : "+worker.getGajiPokok());
	            System.out.println(" TOTAL GAJI : "+totalGaji(worker.hitungGajiPokok(), worker.hitungTunjanganMakan(), worker.hitungTransport()));
	    		System.out.println("--------------------------------------------------");
	        }

	}
	
	
	public void ShowDataById(String input) throws IOException{
		String nama = input.toLowerCase();
		int id = Integer.parseInt(input);
		for( int i=0; i<staff.size(); i++) {
		    if(staff.get(i).getId() == id || staff.get(i).getNama().equals(nama)) {
		    	System.out.println("Data berhasil di temukan");
		    	System.out.println("Id : "+ staff.get(i).getId());
		    	System.out.println("Nama "+staff.get(i).getNama());
		    	System.out.println("\n");
		    	System.out.println(" id : "+staff.get(i).getId());
	            System.out.println(" nama : "+staff.get(i).getNama());
	            System.out.println(" Absensi : "+staff.get(i).getAbsensi());
	            System.out.println(" Jumlah Cuti : "+staff.get(i).getJumlahCuti());
	            System.out.println(" Tunjangan Makan : "+staff.get(i).getTunjanganMakan());
	            System.out.println(" Tunjangan Transport : "+staff.get(i).getTunjanganTransport());
	            System.out.println(" Gaji Pokok : "+staff.get(i).getGajiPokok());
	            System.out.println(" TOTAL GAJI : "+totalGaji(staff.get(i).hitungGajiPokok(), 
	            											  staff.get(i).hitungTunjanganMakan(), 
	            											  staff.get(i).hitungTransport()));
		    }else {
		    	System.out.println("data tidak di temukan");
		    }
		}
		
	}
	
	
	 public void printText() throws IOException {
 
		       FileWriter writer = new FileWriter("D:\\bootcamp\\bootcamp G2ACADEMY\\materi\\day 6\\karyawan\\kayawan.txt");
		       
		       writer.write("ID,Nama, JmlAbsensi , JmlCutiTerpakai, JmlTanpaKabar, TotalGaji");
	           writer.write(System.lineSeparator());
		       for(Staff karyawan: staff) {
		        	
		        	String dataKaryawan = karyawan.getId()+
		        			","+karyawan.getNama()+
		        			","+karyawan.getAbsensi()+
		        			"."+karyawan.getJumlahCuti()+
		        			","+karyawan.hitungTunjanganMakan()+
		        			","+karyawan.hitungTransport()+
		        			","+karyawan.getGajiPokok()+
		        			","+totalGaji(karyawan.hitungGajiPokok(), 
		        						  karyawan.hitungTunjanganMakan(), 
		        						  karyawan.hitungTransport());
		        	writer.write(dataKaryawan);
		        	writer.write(System.lineSeparator());
		        }
		        
		       System.out.println("data berhasil di export");  
	        	writer.close();
		    	   
	 }
	 
	 

	    public static void readFile() throws Exception {
	        FileReader fr = new FileReader("D:\\bootcamp\\bootcamp G2ACADEMY\\materi\\day 6\\karyawan\\kayawan.txt");
	        BufferedReader br = new BufferedReader(fr);
	        br.readLine();
	        String line;
	        
	        while ((line = br.readLine()) != null) {
	            String[] value = line.split(",");
	            Staff work = new Staff(
	                    Integer.parseInt(value[0]),
	                    value[1].toUpperCase(),
	                    Integer.parseInt(value[2]),
	                    Integer.parseInt(value[3]),
	                    Integer.parseInt(value[4]));
	            staff.add(work);
	        }
	        System.out.println("data berhasil di import");
	        fr.close();
	    }
		
	}

