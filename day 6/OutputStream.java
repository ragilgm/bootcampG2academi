import java.io.FileOutputStream;
import java.io.IOException;
public class OutputStream {


	public static void main(String[] args) throws IOException {
		
		String argument = args[0];
	    
	    try{    
	        FileOutputStream fout=new FileOutputStream("D:\\bootcamp\\bootcamp G2ACADEMY\\materi\\day 6\\"+argument+".txt");   
	        for(int i = 1; i<args.length;i++){
	            String s= args[i]+" ";    
	            byte b[]=s.getBytes();
	           fout.write(b);    
	           }
	        fout.close();    
	        System.out.println("success...");    
	       }catch(Exception e){System.out.println(e);}    
	 }    


}
