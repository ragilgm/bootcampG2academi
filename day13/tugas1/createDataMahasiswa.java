import java.io.IOException;
import java.util.ArrayList;

public class createDataMahasiswa extends DatabaseMahasiswa{
	
	// method untuk create data mahasiswa
	public void createData(String nama, double inggris, double fisika, double algoritma) throws IOException{
		
		// variable counter
		int counter = 0;
		
		// jika panjang dari arraylist mahasiswa tidak sama dengan 0
		if(mahasiswa.size()!=0) {
			
			// counter = panjang mahasiswa + 1
			counter = mahasiswa.size()+1;
		}else {
			
			// counter akan bertambah 1
			counter++;
		}
		
		// arraylist nilai -> arraylist penampung nilai dari arraylist
		ArrayList<Double> nilai = new ArrayList<Double>();
		
		// add value inggris (parameter)
		nilai.add(inggris);
		
		// add value fisika (parameter)
		nilai.add(fisika);
		
		// add value algoritma (parameter)
		nilai.add(algoritma);
			
			// memasukan object mahasiswa ke arraylist mahasiswa
			mahasiswa.add(new EntityMahasiswa(counter, nama,nilai));
			
			// outuput ke layar
			System.out.println("data mahasiswa berhasil di tambahkan");
	}

}
