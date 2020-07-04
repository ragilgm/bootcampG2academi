import java.util.Comparator;

// class NameSorter
public class NameSorter implements Comparator<Mahasiswa>{

	// overide method dari class Comparator
	@Override
	
	// method untuk sorting berdasarkan nama dari a - z
	public int compare(Mahasiswa o1, Mahasiswa o2) {
		return o1.getNama().compareToIgnoreCase(o2.getNama());
	}

}
