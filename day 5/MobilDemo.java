import java.util.ArrayList;
import java.util.Iterator;

public class MobilDemo {

	public static void main(String[] args) {
		
		Mobil mobil = new Mobil("avansa", "merah", "2010");
		Mobil mobil1 = new Mobil("kijang", "biru", "2011");
		Mobil mobil2 = new Mobil("brio", "hitam", "2015");
		
		ArrayList<Mobil> al = new ArrayList<Mobil>();
		al.add(mobil);
		al.add(mobil1);
		al.add(mobil2);
		
		Iterator<Mobil> itr = al.iterator();
		while (itr.hasNext()) {
			Mobil mbl = itr.next();
			System.out.println(mbl.getMerek()+" "+mbl.getWarna()+" "+mbl.getTahunPembuatan());
		}

	}

}
