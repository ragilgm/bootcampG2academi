import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Exam02AndiSyafrianda {

    public static InputStreamReader r = new InputStreamReader(System.in);
    public static BufferedReader br = new BufferedReader(r);
    public static ArrayList<Worker> listKaryawan = new ArrayList<Worker>();

    public static void main(String[] args) throws Exception {


        int paramsMenu = 0;
        while (paramsMenu != 8) {
            System.out.println("Menu");
            System.out.println("1. Input Data Karyawan");
            System.out.println("2. Edit Data Karyawan ");
            System.out.println("3. Absensi Karyawan");
            System.out.println("4. Cuti Karyawan ");
            System.out.println("5. Hitung Total Gaji Karyawan");
            System.out.println("6. Tampilkan Laporan per Karyawan");
            System.out.println("7. Export to File");
            System.out.println("8. Exit");
            System.out.print("Enter Menu: ");
            paramsMenu = Integer.parseInt(br.readLine());
            System.out.println("Anda memilih menu no " + paramsMenu + "\n");
            switchProgram(paramsMenu);
        }
        br.close();
        r.close();

    }

    public static void switchProgram(int params) throws Exception {

        if (params == 1) {
            System.out.println("### Input Data Karyawan ###");
            addKaryawan();

        } else if (params == 2) {
            System.out.println("### Edit Data Karyawan  ###");
            editKaryawan();

        } else if (params == 3) {
            System.out.println("### Absensi Karyawan ###");

        } else if (params == 4) {
//            TODO: Cuti
            System.out.println("### Cuti Karyawan  ###");

        } else if (params == 5) {
//            TODO: Hitung Total Gaji Karyawan
            System.out.println("### Hitung Total Gaji Karyawan  ###");

        } else if (params == 6) {
            System.out.println("### Print Data Karyawan ###");
//            showKaryawan();


        } else if (params == 7) {
            System.out.println("### Export Data Karyawan ###");
            export();
            System.out.println("\nData Sukses Di Export !");
        } else if (params == 9) {
//            TODO: HAPUS INI SEBELUM KUMPULIN
            readFile();
            System.out.println("\nData Sukses Di Import !");
        } else if (params == 0) {
//            TODO: HAPUS INI SEBELUM KUMPULIN
            System.out.println("### LIHAT SEMUA ###");
            lihatSementara();
        } else if (params == 11) {
//            TODO: HAPUS INI SEBELUM KUMPULIN
            listKaryawan.clear();
            System.out.println("\nData Sukses Di Reset !");
        } else {
            System.out.println("Terimakasih ^^");
        }

        if (params != 8) {
            promptEnterKey(); // Press "ENTER" to continue
        }
    }




    public static void addKaryawan() throws Exception {
        int idKaryawan;
        String namaKaryawan;


        System.out.print("ID Karyawan: ");
        idKaryawan = Integer.parseInt(br.readLine());
        System.out.print("Nama Karyawan: ");
        namaKaryawan = br.readLine();

        Worker karyawan = new Worker(idKaryawan, namaKaryawan);

        listKaryawan.add(karyawan);

        System.out.println("\nData Sukses Diinput !");
        System.out.println("------------- \n");
    }

    public static void editKaryawan() throws Exception {
        int findIndex = nameOrID();
        simpanDataEdit(findIndex);
    }

    public static void absenKaryawan() throws Exception {
        int findIndex = nameOrID();
    }


    public static int nameOrID() throws Exception {
        int pilihan;
        int indexFindArrayList = -2;

        System.out.println("Pilih metode pencarian");
        System.out.println("1. Dengan Nama");
        System.out.println("2. Dengan ID");

        System.out.print("Ketik pilihan anda: ");
        pilihan = Integer.parseInt(br.readLine());

        if (pilihan == 1) {
            indexFindArrayList = findByName();
        } else if (pilihan == 2) {
            indexFindArrayList = findByID();
        } else {
            System.out.println("Maaf anda salah input, coba lagi");
        }

        return indexFindArrayList;
    }

    public static int findByName() throws Exception {
        String inputNama;
        int indexFindArrayList = -1;

        System.out.print("Cari Karyawan by NAMA :");
        inputNama = br.readLine().toUpperCase();

        for (int i = 0; i < listKaryawan.size(); i++) {
            if (inputNama.equals(listKaryawan.get(i).nama)) {
                indexFindArrayList = i;
                break;
            }
        }

    return indexFindArrayList;
    }

    public static int findByID() throws Exception {
        int inputID;
        int indexFindArrayList = -1;

        System.out.print("Cari Karyawan by ID :");
        inputID = Integer.parseInt(br.readLine());

        for (int i = 0; i < listKaryawan.size(); i++) {
            if (listKaryawan.get(i).id == inputID) {
                indexFindArrayList = i;
                break;
            }
        }

        return indexFindArrayList;

    }

    public static String simpanDataEdit(int indexFindArrayList) throws Exception {
        if (indexFindArrayList > -1) {
            String newNama;

            System.out.print("Nama Karyawan: ");
            newNama = br.readLine();

            Worker data = listKaryawan.get(indexFindArrayList);
            Worker newKaryawan = new Worker(
                    data.id,
                    newNama,
                    data.gajipokok,
                    data.absensi,
                    data.cuti);

            listKaryawan.set(indexFindArrayList, newKaryawan);

            return "\nData Sukses Diperbarui !";

        } else {
            return "Data Karyawan Tidak ditemukan";
        }
    }

    public static String simpanDataAbsen(int indexFindArrayList) throws Exception {
        if (indexFindArrayList > -1) {
            Worker data = listKaryawan.get(indexFindArrayList);

            System.out.println("Absensi dari:");
            System.out.println("Nama Karyawan: " + data.nama);
            System.out.println("Sekarang Absen ke: " + data;

        }
    }



    public static void lihatSementara() {
        Iterator iterator = listKaryawan.iterator();
        //traversing elements

        System.out.printf("| %2s | %-15s | %-15s | %-15s |%-15s |", "ID", "Nama", "GajiPokok", "Absensi", "cuti");
        while (iterator.hasNext()) {
            Worker karyawan = (Worker) iterator.next();
            System.out.print("\n");
            System.out.printf("| %2s | %-15s | %-15s | %-15s |%-15s |", karyawan.id, karyawan.nama, karyawan.gajipokok, karyawan.absensi, karyawan.cuti);
        }
        System.out.print("\n\n");
    }


    public static void readFile() throws IOException {
        FileReader fr = new FileReader("Karyawan.txt");
        BufferedReader br = new BufferedReader(fr);

        br.readLine(); // skip ke line 2
        String line;

        while ((line = br.readLine()) != null) {
            String[] value = line.split(",");
            Worker karyawan = new Worker(
                    Integer.parseInt(value[0]),
                    value[1].toUpperCase(),
                    Integer.parseInt(value[2]),
                    Integer.parseInt(value[3]),
                    Integer.parseInt(value[4]));
            listKaryawan.add(karyawan);
        }
        fr.close();
    }

    public static void export() throws Exception {
        String namaFile = "LaporanKaryawan";

        FileWriter writer = new FileWriter(namaFile + ".txt");
        for (Worker str : listKaryawan) {
            writer.write("ID :" + str.id + System.lineSeparator());
            writer.write("Nama :" + str.nama + System.lineSeparator());
            writer.write("Absensi :" + str.absensi + System.lineSeparator());
            writer.write("Cuti :" + str.cuti + System.lineSeparator());
            writer.write("Tanpa Kabar :" + str.tanpaKabar + System.lineSeparator());
            writer.write("Total Gaji :" + str.totalGaji + System.lineSeparator());
            writer.write(System.lineSeparator());
        }
        writer.close();
    }

    public static void promptEnterKey() {
        System.out.println("\nPress \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

}

class Worker {
    int id;
    String nama;
    int gajipokok;
    int absensi;
    int cuti;

    //    TODO: Di GENERATE nanti dari staff;
    int tanpaKabar = 0;
    int totalGaji = 0;

    Worker(int id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    Worker(int id, String nama, int gajipokok, int absensi, int cuti) {
        this.id = id;
        this.nama = nama;
        this.gajipokok = gajipokok;
        this.absensi = absensi;
        this.cuti = cuti;
    }

    public static void absensi() {
    }

    public static void hitungAbsen() {
    }

    public static void gajiPokok() {
    }
}

class Staff {
    public static void tunjanganMakan() {
    }

    public static void tunjanganTransport() {
    }

    public static void totalGaji() {
    }
}

