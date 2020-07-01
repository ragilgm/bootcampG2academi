import java.io.IOException;

import java.util.ArrayList;

public class Crud {

	ArrayList<Manager> manager;
	ArrayList<Staff> staff;
	
	
	public Crud() {
		
		manager = new ArrayList<Manager>();
		staff = new ArrayList<Staff>();
		
	}
	
	
	public void createStaff(String nama) {
		int counter = 0;
		if(staff.size()!=0) {
			counter = staff.size()+1;
		}else {
			counter++;
		}
		try {
			staff.add(new Staff(counter, nama));
		System.out.println("data berhasil di tambahkan..");
		} catch (Exception e) {
			System.err.println("data gagal di tambahkan. kesalahan pada "+e);
		}
			
	}
	
	
	public void createManger(String nama) {
		int counter = 0;
		if(manager.size()!=0) {
			counter = manager.size()+1;
		}else {
			counter++;
		}
		try {
			manager.add(new Manager(counter, nama));
		System.out.println("data berhasil di tambahkan..");
		} catch (Exception e) {
			System.err.println("data gagal di tambahkan. kesalahan pada "+e);
		}
			
	}
	
	public void absenStaff(int id) throws IOException{
		
		for( int i=0; i<staff.size(); i++) {
		    if(staff.get(i).getIdKaryawan() == id) {
		    	System.out.println("Nama : "+ staff.get(i).getNama());
		    	staff.get(i).setAbsensi();
		    	
		    	System.out.println("absen berhasil di update");
		    	break;
		    }else {
		    	System.out.println("absen gagal di update");
		    }
		}
		
	}
	
	public void absenManager(int id) throws IOException{
		
		for( int i=0; i<manager.size(); i++) {
		    if(manager.get(i).getIdKaryawan() == id) {
		    	System.out.println("Nama : "+ manager.get(i).getNama());
		    	manager.get(i).setAbsensi();
		    	
		    	System.out.println("absen berhasil di update");
		    	break;
		    }else {
		    	System.out.println("absen gagal di update");
		    }
		}
		
	}


	
	
	public void printAbsenStaff() {
			for(Staff worker:staff) {
	            System.out.println(" id : "+worker.getIdKaryawan());
	            System.out.println(" nama : "+worker.getNama());
	            System.out.println(" Absensi : "+worker.getAbsensi());
	    		System.out.println("--------------------------------------------------");
	        }

	}
	
	public void printAbsenManager() {
		for(Manager manage:manager) {
            System.out.println(" id : "+manage.getIdKaryawan());
            System.out.println(" nama : "+manage.getNama());
            System.out.println(" Absensi : "+manage.getAbsensi());
    		System.out.println("--------------------------------------------------");
        }




	}
	
}
