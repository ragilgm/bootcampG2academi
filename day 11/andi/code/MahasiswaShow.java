import java.util.ArrayList;
import java.util.Iterator;

public class MahasiswaShow {
    public void show_all() {
        MahasiswaSort mahasiswaSort = new MahasiswaSort(MahasiswaCreate.list_mahasiswa);
        ArrayList<Mahasiswa> mahasiswa = mahasiswaSort.getSortedMahasiswaByID();

        Iterator iterator_mahasiswa = mahasiswa.iterator();

        System.out.println("### Mahasiswa ###");
        System.out.printf("| %3s | %-15s | %-10s | %-10s | %-10s |",
                "ID", "Nama", "Inggris", "Fisika","Algoritma");
        while (iterator_mahasiswa.hasNext()) {
            Mahasiswa mhs = (Mahasiswa) iterator_mahasiswa.next();
            System.out.print("\n");
            System.out.printf("| %3s | %-15s | %-10s | %-10s | %-10s |",
                    mhs.getId(), mhs.getNama(),
                    mhs.getNilai().get(0), mhs.getNilai().get(1), mhs.getNilai().get(2));
        }
    }
}