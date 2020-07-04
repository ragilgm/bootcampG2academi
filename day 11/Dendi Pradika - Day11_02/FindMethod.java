import java.io.*;
import java.util.*;

public class FindMethod{

  public static InputStreamReader r = new InputStreamReader(System.in);
  public static BufferedReader br = new BufferedReader(r);
  public static ArrayList<Mahasiswa> mahasiswa = new ArrayList<Mahasiswa>();
  Scanner in = new Scanner(System.in);  
   
  public void createData(int id, String nama, double inggris, double fisika, double algoritma) {
    ArrayList<Double> getNilai = new ArrayList<Double>();
    getNilai.add(inggris);
    getNilai.add(fisika);
    getNilai.add(algoritma);

    try {
      Mahasiswa mhs = new Mahasiswa(id, nama, getNilai);
      mahasiswa.add(mhs);
        
      System.out.println("\nSukses.");
      System.out.println("-------------------------------------------------");
      System.out.println(" ID | \t NAMA \t | Inggris | Fisika | Algoritma |");
      System.out.println("-------------------------------------------------");
                        
      for(Mahasiswa loop:mahasiswa) {
        System.out.println(" "+loop.getId()+" | \t "+loop.getNama()+" \t | "+loop.getDataNilai().get(0)+" | "+loop.getDataNilai().get(1)+" | "+loop.getDataNilai().get(2)+" |");
      System.out.println("-------------------------------------------------");
      }
    } catch (Exception e) {
      System.err.println("Gagal, cek kembali :\n "+e);
    } 
  }
  
  public void editNama(int id, String nama) {
    int left = 0;
    int middle;
    int right = mahasiswa.size() - 1;
    try{
      while (left <= right) {
        middle = (left + right) / 2;
        if (mahasiswa.get(middle).getId() == id) {
          mahasiswa.get(middle).setNama(nama);
          System.out.println("Sukses, nama mahasiswa berhasil di ganti");
          break;
        } else if (mahasiswa.get(middle).getId() < id) {
            left = middle + 1;
        } else if (mahasiswa.get(middle).getId() > id) {
            right = middle - 1;
        }
      }
    } catch (Exception e) {
      System.err.println("Gagal, cek kembali :\n "+e);
    }
  }
  
  public void editNilaiInggris(int id, double inggris) {
    int left = 0;
    int middle;
    int right = mahasiswa.size() - 1;
    try{
      while (left <= right) {
        middle = (left + right) / 2;
        if (mahasiswa.get(middle).getId() == id) {
          mahasiswa.get(middle).getDataNilai().set(0, inggris);
          System.out.println("Sukses, nilai bahasa inggris berhasil di ganti");
          break;
        } else if (mahasiswa.get(middle).getId() < id) {
            left = middle + 1;
        } else if (mahasiswa.get(middle).getId() > id) {
            right = middle - 1;
        }
      }
    } catch (Exception e) {
      System.err.println("Gagal, cek kembali :\n "+e);
    }
  }
  
  public void editNilaiFisika(int id, double fisika) {
    int left = 0;
    int middle;
    int right = mahasiswa.size() - 1;
    try{
      while (left <= right) {
        middle = (left + right) / 2;
        if (mahasiswa.get(middle).getId() == id) {
        mahasiswa.get(middle).getDataNilai().set(1, fisika);
          System.out.println("Sukses, nilai fisika berhasil di ganti");
            break;
        } else if (mahasiswa.get(middle).getId() < id) {
            left = middle + 1;
        } else if (mahasiswa.get(middle).getId() > id) {
            right = middle - 1;
        }
      }
    } catch (Exception e) {
      System.err.println("Gagal, cek kembali :\n "+e);
    }
  }
  
  public void editNilaiAlgoritma(int id, double algoritma) {
    int left = 0;
    int middle;
    int right = mahasiswa.size() - 1;
    try{
      while (left <= right) {
        middle = (left + right) / 2;
        if (mahasiswa.get(middle).getId() == id) {
          mahasiswa.get(middle).getDataNilai().set(2, algoritma);
          System.out.println("Sukses, nilai algoritma berhasil di ganti");
            break;
        } else if (mahasiswa.get(middle).getId() < id) {
            left = middle + 1;
        } else if (mahasiswa.get(middle).getId() > id) {
            right = middle - 1;
        }
      }
    } catch (Exception e) {
      System.err.println("Gagal, cek kembali :\n "+e);
    }
  }
  
  public void delete(int id) {
    int left = 0;
    int middle;
    int right = mahasiswa.size() - 1;
    try {
      while (left <= right) {
        middle = (left + right) / 2;
        if (mahasiswa.get(middle).getId() == id) {
          mahasiswa.remove(middle);
          System.out.println("Sukses, ID Mahasiswa "+id+" berhasil di hapus");
          break;
        } else if (mahasiswa.get(middle).getId() < id) {
            left = middle + 1;
        } else if (mahasiswa.get(middle).getId() > id) {
            right = middle - 1;
        }
      }
    } catch (Exception e) {
      System.err.println("Gagal, cek kembali :\n "+e);
    }
  }

  public void laporan() {
    System.out.println("-------------------------------------------------");
    System.out.println(" ID | \t NAMA \t | Inggris | Fisika | Algoritma |");
    System.out.println("-------------------------------------------------");

    Mahasiswa temp = new Mahasiswa();
    int n = mahasiswa.size();

    for (int i =0;i<n;i++) {
      for (int j = 1; j < n-i; j++) {
        if (mahasiswa.get(j-1).getId() > mahasiswa.get(j).getId()) {
          temp = mahasiswa.get(j-1);
          mahasiswa.set(j-1, mahasiswa.get(j));
          mahasiswa.set(j, temp);
        }
      }
    }
    
    for(Mahasiswa loop:mahasiswa) {
        System.out.println(" "+loop.getId()+" | \t "+loop.getNama()+" \t | "+loop.getDataNilai().get(0)+" | "+loop.getDataNilai().get(1)+" | "+loop.getDataNilai().get(2)+" |");
      System.out.println("-------------------------------------------------");
    }
  }
}
