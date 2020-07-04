import java.util.*;

public class Mahasiswa {
	
	private int id;
	private String nama;
	private ArrayList<Double> nilai;
	
	
	public Mahasiswa(int id, String nama, ArrayList<Double> nilai) {
		this.id = id;
		this.nama = nama;
		this.nilai = nilai;
	}
	
	public Mahasiswa(Mahasiswa mahasiswa) {
		this.id = mahasiswa.id;
		this.nama = mahasiswa.nama;
		this.nilai = mahasiswa.nilai;
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

	public ArrayList<Double> getDataNilai() {
		return nilai;
	}
	public void setDataNilai(ArrayList<Double> nilai) {
		this.nilai = nilai;
	}
}
