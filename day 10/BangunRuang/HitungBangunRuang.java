public class HitungBangunRuang extends BangunRuang{

	protected double jari;
	
	public double hitungBangunRuang(double jari) {
		double phi =3.14;
		 double hasil= phi*(jari*jari*jari);
	     return hasil;
	}
	
	public double getBangunRuang() {
		return jari;
	}
	
}
