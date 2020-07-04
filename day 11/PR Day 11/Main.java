import java.io.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.IOException;


public class Main {
    public static ArrayList<Mahasiswa> mahasiswaArrayList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    

    public void main(String[] args) throws FileNotFoundException {
        Crud crud = new Crud();
		System.out.println("Masukan Username :");
		String username = scanner.nextLine();
		
		System.out.println("Masukan Password :");
		String password = scanner.nextLine();
		
		boolean validasi = crud.Validation(username,password);
		
		if(validasi) {
			System.out.println("Selamat Anda Berhasil Login...");{

            boolean flag = false;
            System.out.println("Pilih angka");
            while (!flag){
                printMenu();
                int angka = scanner.nextInt();
                switch (angka){
                    case 1:
                        createMahasiswa();
                        break;
                    case 2:
                        editMahasiswa();
                        break;
                    case 3:
                        hapusMahasiswa();
                        break;
                    case 4:
                        printMahasiswa();
                        break;
                    case 5:
                        printMenu();
                        break;
                    case 6:
                        flag=true;
                        break;
                    default:
                        break;

                }
            }
        }
     } else {
            System.out.println("email atau pasword salah");
        }

    }

    public static void printMenu(){
        System.out.println("1. tambah" +
                "2. edit " + "\n3. hapus" + "\n4. print" + "\n5. print menu" + "\n6. keluar");
    }

    public static void createMahasiswa(){
        System.out.println("Masukkan id");
        int idBaru = scanner.nextInt();
        int indexID = index(idBaru);
        if(indexID < 0){
            System.out.println("Masukkan nama");
            String namaBaru = scanner.next();
            System.out.println("nilai inggris");
            double nilaiBahasaInggris = scanner.nextDouble();
            System.out.println("nilai fisika");
            double nilaiFisika = scanner.nextDouble();
            System.out.println("nilai algoritma");
            double nilaiAlgoritma = scanner.nextDouble();
            Mahasiswa newMahasiswa = new Mahasiswa(idBaru, namaBaru);
            Nilai newNilai = new Nilai(nilaiBahasaInggris, nilaiFisika, nilaiAlgoritma);
            newMahasiswa.tambahNilai(newNilai);
            mahasiswaArrayList.add(newMahasiswa);
            int index = index(newMahasiswa);
        } else{
            System.out.println("Id sudah ada");
        }
     


    }

    public static void editMahasiswa(){
        System.out.println("Masukkan id");
        int indexId = scanner.nextInt();
        int index = index(indexId);
        if (index >= 0){
            System.out.println("Ganti");
            System.out.println("Masukin nama");
            String namaMahasiswaBaru = scanner.next();
            System.out.println("Masukin id");
            int idBaru = scanner.nextInt();
            System.out.println("nilai inggirs");
            double nilaiBahasaInggris = scanner.nextDouble();
            System.out.println("nilai fisika");
            double nilaiFisika = scanner.nextDouble();
            System.out.println("nilai algoritma");
            double nilaiAlgoritma = scanner.nextDouble();
            Mahasiswa mahasiswa = new Mahasiswa(idBaru, namaMahasiswaBaru);
           mahasiswaArrayList.add(mahasiswa);
           Nilai newNilai = new Nilai(nilaiBahasaInggris, nilaiFisika, nilaiAlgoritma);
           mahasiswa.tambahNilai(newNilai);
           int indexBaru = index(mahasiswa);
           mahasiswaArrayList.set(index, mahasiswa);
        } else {
            System.out.println("Id ga ada");
        }
    }

    public static void hapusMahasiswa(){
        System.out.println("input id");
        int id = scanner.nextInt();
        int indexMahasiswa = index(id);
        if (indexMahasiswa >= 0){
            mahasiswaArrayList.remove(indexMahasiswa);
            System.out.println("Berhasil di hapus");
        } else {
            System.out.println("data ga ada");
        }

    }

    public static void printMahasiswa(){
        for (int i = 0; i < mahasiswaArrayList.size(); i++){
            System.out.println("Nama: " + mahasiswaArrayList.get(i).getNama() + "\n" +
                    "Id: " + mahasiswaArrayList.get(i).getId() + "\n" );
            mahasiswaArrayList.get(i).printNilai();
        }
    }
    public static int index(Mahasiswa mahasiswa){
        return mahasiswaArrayList.indexOf(mahasiswa);
    }

    public static int index(int id){
        String idMahasiswa = Integer.toString(id);

        for (int i = 0; i< mahasiswaArrayList.size(); i++){
            Mahasiswa mahasiswa = mahasiswaArrayList.get(i);
            String idMahasiswaYangDicari = Integer.toString(mahasiswa.getId());
            if (idMahasiswaYangDicari.equals(idMahasiswa)){
                return i;
            }
      }
        return -1;
    }

    public static Mahasiswa databaseMahasiswa(int id){
        int indexId = index(id);
        if (indexId >= 0){
            return mahasiswaArrayList.get(indexId);
        }
        return null;
    }

    class Crud {

        ArrayList<Mahasiswa> mahasiswa;
        
        public Crud() {
            mahasiswa = new ArrayList<Mahasiswa>();
        }
        
        public boolean Validation(String username, String password) throws IOException {
            FileReader fileUsername = new FileReader("username.txt");
            BufferedReader BufferUsername = new BufferedReader(fileUsername);
            
            FileReader filePassword = new FileReader("password.txt");
            BufferedReader BufferPassword = new BufferedReader(filePassword);
            
            String user = BufferUsername.readLine();
            String pass = BufferPassword.readLine();
    
            boolean LoginUsername = Pattern.matches("^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$", username);
            boolean LoginPassword = Pattern.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).{8,}$", password);
            
            BufferUsername.close();
            BufferPassword.close();
            
            if(LoginUsername && LoginPassword) {
                if(username.equals(user) && password.equals(pass)) {
                    return true;
                }else {
                    return false;
                }
            }else {
                return false;
            }
            
        }










































    
    }
}
