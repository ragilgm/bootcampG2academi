import java.util.ArrayList;

public class MahasiswaCreate {
    public static ArrayList<Mahasiswa> list_mahasiswa = new ArrayList<Mahasiswa>();
    InputScan inputScan = new InputScan();

    public void create_once() {
        System.out.println("Create & Input Data Mahasiswa");

        int id = Integer.parseInt(inputScan.input("id"));
        String nama = inputScan.input("nama");
        ArrayList<Double> nilai = new ArrayList<Double>();

        double inggris = Double.parseDouble(inputScan.input("inggris"));
        double fisika = Double.parseDouble(inputScan.input("fisika"));
        double algoritma = Double.parseDouble(inputScan.input("algoritma"));

        nilai.add(inggris);
        nilai.add(fisika);
        nilai.add(algoritma);


        Mahasiswa mahasiswa = new Mahasiswa(id, nama, nilai);
        list_mahasiswa.add(mahasiswa);
    }
}