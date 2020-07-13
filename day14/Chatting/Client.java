import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		try {
			Socket s=new Socket("localhost", 6666); 
			DataInputStream dis = new DataInputStream(s.getInputStream());
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			
			String input = "";
			while (!input.equals("exit")) {
				String str = (String) dis.readUTF();
				System.out.println("Server Says = " + str);
				System.out.println("Masukan Pesan : ");
				input = in.nextLine();
				dout.writeUTF(input);
				dout.flush();
				}
				
			
			s.close();
			in.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}	
	}
}
