import java.util.Comparator;

// class NameSorter
public class NameSorter implements Comparator<EntityMahasiswa>{

	// overide method dari class Comparator
	@Override
	
	// method untuk sorting berdasarkan nama dari a - z
	public int compare(EntityMahasiswa o1, EntityMahasiswa o2) {
		return o1.getNama().compareToIgnoreCase(o2.getNama());
	}

}
