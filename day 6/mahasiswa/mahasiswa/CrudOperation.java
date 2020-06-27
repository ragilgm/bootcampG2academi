import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class CrudOperation {
	
	ArrayList<Mahasiswa> mahasiswa;
	
	public CrudOperation() {
		//instansiasi
        mahasiswa = new ArrayList<Mahasiswa>();
	}
	
	public void createData(int id, String nama, int matematika, int b_indo, int fisika) {
		
		ArrayList<Integer> nilai = new ArrayList<Integer>();
		nilai.add(matematika);
		nilai.add(b_indo);
		nilai.add(fisika);
		
		try {
		mahasiswa.add(new Mahasiswa(id, nama, nilai));
		System.out.println("data berhasil di tambahkan..");
		} catch (Exception e) {
			System.err.println("data gagal di tambahkan. kesalahan pada "+e);
		}
			
	}

	
	public void editData(int id, String edit) {
		int target = id;
		for( int i=0; i<mahasiswa.size(); i++) {
		    if(mahasiswa.get(i).getId() == target) {
		    	ArrayList<Integer> nilai = new ArrayList<Integer>();
				nilai.add(mahasiswa.get(i).getData().get(0));
				nilai.add(mahasiswa.get(i).getData().get(1));
				nilai.add(mahasiswa.get(i).getData().get(2));
				mahasiswa.set(mahasiswa.get(i).getId()-1, new Mahasiswa(mahasiswa.get(i).getId(),edit, nilai));
		        break; // break should be omitted if the array contains duplicates
		    }
		}
		
	}
	
	public void deleteData(int id) {
		int target = id;
		for( int i=0; i<mahasiswa.size(); i++) {
		    if(mahasiswa.get(i).getId() == target) {
				mahasiswa.remove(mahasiswa.get(i).getId()-1);
				System.out.println("data berhasil di hapus");
		        break; // break should be omitted if the array contains duplicates
		    
		    }
		}
		
	}
	
	public void showData() {
		if(!mahasiswa.isEmpty()){
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("ID \t | \t NAMA \t | \t MTK \t | \t IND \t | \t FSK \t |");
			System.out.println("--------------------------------------------------------------------------");
			for(Mahasiswa mhs:mahasiswa) {
				
	            System.out.println(" "+mhs.getId()+" \t | \t "+mhs.getNama()+" \t | \t "+mhs.getData().get(0)+" \t | \t "+mhs.getData().get(1)+" \t | \t "+mhs.getData().get(2)+" \t |");
	    		System.out.println("--------------------------------------------------------------------------");
	        }
		}else {
				System.out.println("array list masih kosong");
			}
	}
	
	 public void printText() {
		    try{    
		       FileWriter writer = new FileWriter("D:\\bootcamp\\bootcamp G2ACADEMY\\materi\\day 6\\mahasiswa.txt");
		        BufferedWriter buffer = new BufferedWriter(writer);
		        for(Mahasiswa mhs: mahasiswa) {
		        	String id = "ID  \t \t: "+mhs.getId()+"\n";
		        	String nama = "Nama  \t \t: "+mhs.getNama()+"\n";
		        	String matematika = "Nilai Mtk \t : "+mhs.getData().get(0)+"\n";
		        	String b_indo = "Nilai B. Indo \t : "+mhs.getData().get(1)+"\n";
		        	String fisika = "Nilai Fisika \t : "+mhs.getData().get(2)+"\n";
		        	String isi = ""+id+""+nama+""+matematika+""+b_indo+""+fisika+"\n";
		        	buffer.write(isi);
		        }
		        
		        buffer.close();    
		        System.out.println("success...");    
		       }catch(Exception e){System.out.println(e);}    
	 }

	
}
