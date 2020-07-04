// inport array list dari kelas java/util/ArrayList
import java.util.ArrayList;

// class mahasiswa
public class Mahasiswa {
	private int id; 					 // variable id
	private String nama;				 // variable nama
	private ArrayList<Double> nilai; 	 // variable ArrayList Double
	
	// Constructor mahasiswa
	public Mahasiswa(int id, String nama, ArrayList<Double> nilai) {
		this.id = id;
		this.nama = nama;
		this.nilai = nilai;
	}
	
	// method untuk menampilkan value dari id
	public int getId() {
		return id;
	}
	
	// mehtod untuk merubah value dari id
	public void setId(int id) {
		this.id = id;
	}

	// method untuk menampilkan value dari nama
	public String getNama() {
		return nama;
	}

	// method untuk merubah value dari nama
	public void setNama(String nama) {
		this.nama = nama;
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
