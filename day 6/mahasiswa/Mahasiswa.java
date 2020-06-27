import java.util.ArrayList;

public class Mahasiswa {
	
	private int id;
	private String nama;
	private ArrayList<Integer> data;
	
	
	public Mahasiswa(int id, String nama, ArrayList<Integer> data) {
		this.id = id;
		this.nama = nama;
		this.data = data;
	}

	
	public Mahasiswa(Mahasiswa mahasiswa) {
		this.id = mahasiswa.id;
		this.nama = mahasiswa.nama;
		this.data = mahasiswa.data;
	}
	
	public Mahasiswa() {

	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNama() {
		return nama;
	}
	public String setNama(String nama) {
		this.nama = nama;
		return nama;
	}
	public ArrayList<Integer> getData() {

		return data;
	}
	public void setData(ArrayList<Integer> data) {
		this.data = data;
	}

	public static void main(String[] args) {
		
	}

}
