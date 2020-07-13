package Thread;

import java.io.FileWriter;
import java.io.IOException;
import Karyawan.Crud;
import Karyawan.Staff;

public class ExportDataKaryawan extends Crud implements Runnable {
	
	@Override
	public void run() {
		try {
			exportLaporan();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void exportLaporan() throws IOException {
	 
       FileWriter writer = new FileWriter("C:\\Users\\ragil\\eclipse-workspace\\JavaFTP\\src\\FileKaryawan\\LaporanKaryawan.txt");
       
       writer.write("	ID,Nama,JmlAbsensi,JmlCutiTerpakai,JmlTanpaKabar,TotalGaji");
     writer.write(System.lineSeparator());
       for(Staff staf : staff) {
        	
        	String dataStaff = staf.getId()+
        			","+staf.getNama()+
        			","+staf.getAbsensi()+
        			","+staf.getJumlahCuti()+
        			","+staf.getTanpaKabar()+
        			","+staf.hitungTotalGaji();
        	writer.write(dataStaff);
        	writer.write(System.lineSeparator());
        }
  	writer.close();
    	   
}
	
	
}
