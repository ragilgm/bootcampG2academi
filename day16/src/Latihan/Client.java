package Latihan;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {

		
		try {
			Socket s=new Socket("localhost", 6666); 
			DataInputStream dis = new DataInputStream(s.getInputStream());
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());

			//First Employee
			JSONObject employeeDetails = new JSONObject();
			employeeDetails.put("firstName", "Lokesh");
			employeeDetails.put("lastName", "Gupta");
			employeeDetails.put("website", "howtodoinjava.com");

			JSONObject employeeObject = new JSONObject();
			employeeObject.put("employee", employeeDetails);

			//Second Employee
			JSONObject employeeDetails2 = new JSONObject();
			employeeDetails2.put("firstName", "Brian");
			employeeDetails2.put("lastName", "Schultz");
			employeeDetails2.put("website", "example.com");

			JSONObject employeeObject2 = new JSONObject();
			employeeObject2.put("employee", employeeDetails2);

			//Add employees to list
			JSONArray employeeList = new JSONArray();
			employeeList.add(employeeObject);
			employeeList.add(employeeObject2);

			StringWriter out = new StringWriter();
			employeeList.writeJSONString(out);
			String jsonText = out.toString();

			//Write JSON file
				dout.writeUTF(jsonText);


			s.close();
			dout.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}	
	}
}
