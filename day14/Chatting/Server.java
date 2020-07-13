import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		try {
			ServerSocket ss = new ServerSocket(6666);
			Socket s = ss.accept();// establishes connection
			DataInputStream dis = new DataInputStream(s.getInputStream());
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			
			String input = "";
			while (!input.equals("exit")) {
				System.out.println("Masukan Pesan : ");
				input = in.nextLine();
				dout.writeUTF(input);
				dout.flush();
				String str = (String) dis.readUTF();
				System.out.println("Client Says = " + str);
				
			}
			ss.close();
			in.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
