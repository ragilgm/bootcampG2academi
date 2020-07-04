import java.util.ArrayList;

public class MahasiswaEditDelete {
    MahasiswaCreate create = new MahasiswaCreate();
    InputScan inputScan = new InputScan();

    public void edit_or_delete() {
        System.out.println("1. Edit");
        System.out.println("2. Delete");
        String pilihan = inputScan.input("pilihan");

        System.out.println("\n");
        int index = cari_id(create.list_mahasiswa);

        if (pilihan.equals("1")) {
            Mahasiswa data = create.list_mahasiswa.get(index);
            String new_nama = inputScan.input("nama");

            ArrayList<Double> new_nilai = new ArrayList<Double>();

            double inggris = Double.parseDouble(inputScan.input("inggris"));
            double fisika = Double.parseDouble(inputScan.input("fisika"));
            double algoritma = Double.parseDouble(inputScan.input("algoritma"));

            new_nilai.add(inggris);
            new_nilai.add(fisika);
            new_nilai.add(algoritma);

            Mahasiswa newMahasiswa = new Mahasiswa(data.getId(), new_nama, new_nilai);
            create.list_mahasiswa.set(index, newMahasiswa);
            System.out.println("data berhasil diedit");
        } else if (pilihan.equals("2")) {
            String yakin_hapus = inputScan.input("hapus (y/N)");

            if (yakin_hapus.toLowerCase().equals("y")){
                create.list_mahasiswa.remove(index);
                System.out.println("data berhasil dihapus");
            } else {
                System.out.println("operasi dibatalkan");
            }

        } else {
            System.out.println("Inputan anda salah !");
        }
    }

    public int cari_id(ArrayList<Mahasiswa> list_mahasiswa) {
        int indexFindArrayList = -1;
        int inputID = Integer.parseInt(inputScan.input("id mahasiswa"));

        for (int i = 0; i < list_mahasiswa.size(); i++) {
            if (list_mahasiswa.get(i).getId() == inputID) {
                indexFindArrayList = i;
                break;
            }
        }
        return indexFindArrayList;
    }

}