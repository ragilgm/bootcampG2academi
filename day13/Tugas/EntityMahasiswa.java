// inport array list dari kelas java/util/ArrayList
import java.util.ArrayList;

// class mahasiswa
public class EntityMahasiswa extends Person {
	private int id; 					 // variable id
	private ArrayList<Double> nilai; 	 // variable ArrayList Double
	
	// Constructor mahasiswa
	public EntityMahasiswa(int id, String nama, ArrayList<Double> nilai) {
		this.id = id;
		setNama(nama);
		this.nilai = nilai;
	}
	
	
	
	public EntityMahasiswa() {
		// TODO Auto-generated constructor stub
	}



	// method untuk menampilkan value dari id
	public int getId() {
		return id;
	}
	
	// mehtod untuk merubah value dari id
	public void setId(int id) {
		this.id = id;
	}

	// method untuk menampilkan value dari arraylist nilai
	public ArrayList<Double> getNilai() {
		return nilai;
	}
	
	// method untuk merubah value dari arraylist nilai
	public void setNilai(ArrayList<Double> nilai) {
		this.nilai = nilai;
	}

	
	
}
