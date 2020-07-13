import java.util.Comparator;

// class IdSorter
public class IdSorter implements Comparator<EntityMahasiswa>{

	// overide dari Class Comparator
	@Override
	
	// method untuk sorting id berdasarkan nilai terkecil ke besar
	public int compare(EntityMahasiswa o1, EntityMahasiswa o2) {
		return o1.getId() - o2.getId();
	}

}
