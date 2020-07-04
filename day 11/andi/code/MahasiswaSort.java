import java.util.ArrayList;
import java.util.Collections;

public class MahasiswaSort {
    ArrayList<Mahasiswa> list_mahasiswa;

    public MahasiswaSort(ArrayList<Mahasiswa> list_mahasiswa) {
        this.list_mahasiswa = list_mahasiswa;
    }

    public ArrayList<Mahasiswa> getSortedMahasiswaByID() {
        Collections.sort(list_mahasiswa);
        return list_mahasiswa;
    }
}