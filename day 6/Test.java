import java.io.FileOutputStream;  
public class Test {  
    public static void main(String args[]){    
           try{    
             FileOutputStream fout=new FileOutputStream("D:\\bootcamp\\bootcamp G2ACADEMY\\materi\\day 6\\test.txt");   
             fout.write(65);    
             fout.close();    
             System.out.println("success...");    
            }catch(Exception e){System.out.println(e);}    
      }    
}  
