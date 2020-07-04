import java.util.ArrayList;

public class Mahasiswa implements Comparable<Mahasiswa> {
    private int id;
    private String nama;
    private ArrayList<Double> nilai;

    public Mahasiswa(int id, String nama, ArrayList<Double> nilai) {
        this.id = id;
        this.nama = nama;
        this.nilai = nilai;
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

    public void setNama(String nama) {
        this.nama = nama;
    }

    public ArrayList<Double> getNilai() {
        return nilai;
    }

    public void setNilai(ArrayList<Double> nilai) {
        this.nilai = nilai;
    }

    @Override
    public int compareTo(Mahasiswa mahasiswa) {
        return (Integer.compare(this.getId(), mahasiswa.getId()));
    }
}

