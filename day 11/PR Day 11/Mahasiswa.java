import java.util.ArrayList;

public class Mahasiswa{
    private int id;
    private String nama;
    private ArrayList<Nilai> nilais;

    public Mahasiswa(int id, String nama){
        this.id = id;
        this.nama = nama;
        this.nilais = new ArrayList<Nilai>();
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

    public ArrayList<Nilai> getNilais() {
        return nilais;
    }

    public void setNilais(ArrayList<Nilai> nilais) {
        this.nilais = nilais;
    }

    public void tambahNilai(Nilai nilai){
        nilais.add(nilai);
    }

    public void printNilai(){
        for (int i = 0; i<nilais.size(); i++){
            System.out.println("Nilai bahasa Inggris:" + nilais.get(i).getBahasaInggris() + "\n" +
                    "Nilai fisika:" + nilais.get(i).getFisika() + "\n" +
                    "Nilai algoritma: " + nilais.get(i).getFisika() + "\n" );
        }
    }
































}