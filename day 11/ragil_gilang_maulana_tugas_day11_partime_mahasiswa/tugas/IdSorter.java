import java.util.Comparator;

// class IdSorter
public class IdSorter implements Comparator<Mahasiswa>{

	// overide dari Class Comparator
	@Override
	
	// method untuk sorting id berdasarkan nilai terkecil ke besar
	public int compare(Mahasiswa o1, Mahasiswa o2) {
		return o1.getId() - o2.getId();
	}

}
