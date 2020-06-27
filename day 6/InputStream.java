import java.io.FileInputStream;

import java.io.FileInputStream;

public class InputStream {

	public static void main(String[] args) {
		String argument = args[0];
	      try{    
	         FileInputStream fin=new FileInputStream("D:\\bootcamp\\bootcamp G2ACADEMY\\materi\\day 6\\"+argument+".txt");    
	         int i=0;    
	          while((i=fin.read())!=-1){    
	          System.out.print((char)i);    
	            }    
	         fin.close();    
	       }catch(Exception e){System.out.println(e);}    
	    }  
}


