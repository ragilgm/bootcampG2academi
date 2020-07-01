import java.util.ArrayList;

public class Crud {

	ArrayList<Manager> manager;
	ArrayList<Staff> staff;
	
	
	public Crud() {
		
		manager = new ArrayList<Manager>();
		staff = new ArrayList<Staff>();
		
	}
	
	
	public void createStaff(String nama, int absensi) {
		int counter = 0;
		if(staff.size()!=0) {
			counter = staff.size()+1;
		}else {
			counter++;
		}
		try {
			staff.add(new Staff(counter, nama, absensi));
		System.out.println("data berhasil di tambahkan..");
		} catch (Exception e) {
			System.err.println("data gagal di tambahkan. kesalahan pada "+e);
		}
			
	}
	
	public void createManger(String nama, int absensi) {
		int counter = 0;
		if(manager.size()!=0) {
			counter = manager.size()+1;
		}else {
			counter++;
		}
		try {
			manager.add(new Manager(counter, nama, absensi));
		System.out.println("data berhasil di tambahkan..");
		} catch (Exception e) {
			System.err.println("data gagal di tambahkan. kesalahan pada "+e);
		}
			
	}
	
	public void hitungTunjanganManager(int id) {
		System.out.println("Tunjangan manager\n");
		for( int i=0; i<manager.size(); i++) {
		    if(manager.get(i).getIdKaryawan() == id) {
		    	System.out.println("Id : "+manager.get(i).getIdKaryawan());
		    	System.out.println("Nama : "+manager.get(i).getNama());
		    	System.out.println("Tunjangan Pulsa : "+manager.get(i).hitungTungjanganPulsa());
		    	System.out.println("Tunjangan Transport : "+manager.get(i).hitungTunjanganTransport());
		    	System.out.println("Tunjangan Entertainment : "+manager.get(i).hitungTunjanganEntertainment());
		    	System.out.println("Abasensi : "+manager.get(i).getAbsensi());
		    	int total = manager.get(i).hitungTunjanganTransport()
						+manager.get(i).hitungTunjanganEntertainment()
						+manager.get(i).hitungTungjanganPulsa();
		    	System.out.println("Total Tunjangan : "+total);
		    	break;
		    }else {
		    	System.out.println("id invalid");
		    }
		}

	}
	
	
	public void hitungTunjanganStaff(int id) {
		System.out.println("Tunjangan manager\n");
		for( int i=0; i<staff.size(); i++) {
		    if(staff.get(i).getIdKaryawan() == id) {
		    	System.out.println("Id : "+staff.get(i).getIdKaryawan());
		    	System.out.println("Nama : "+staff.get(i).getNama());
		    	System.out.println("Abasensi : "+staff.get(i).getAbsensi());
		    	System.out.println("Tunjangan Pulsa : "+staff.get(i).hitungTungjanganPulsa());
		    	System.out.println("Tunjangan Makan : "+staff.get(i).hitungTunjanganMakan());
		    	int total = staff.get(i).hitungTungjanganPulsa()
						+staff.get(i).hitungTunjanganMakan();
		    	System.out.println("Total Tunjangan : "+total);
		    	break;
		    }else {
		    	System.out.println("id invalid");
		    }
		}

	}
	
}
