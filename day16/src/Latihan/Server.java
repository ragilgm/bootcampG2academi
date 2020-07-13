package Latihan;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server {
    private static void parseEmployeeObject(JSONObject employee) {
        //Get employee object within list
        JSONObject employeeObject = (JSONObject) employee.get("employee");

        //Get employee first name
        String firstName = (String) employeeObject.get("firstName");
        System.out.println(firstName);

        //Get employee last name
        String lastName = (String) employeeObject.get("lastName");
        System.out.println(lastName);

        //Get employee website name
        String website = (String) employeeObject.get("website");
        System.out.println(website);
    }d

    public static void main(String[] args) {

        try {
            ServerSocket ss = new ServerSocket(6666);
            Socket s = ss.accept();// establishes connection
            DataInputStream dis = new DataInputStream(s.getInputStream());

            {
                //JSON parser object to parse read file
                JSONParser jsonParser = new JSONParser();

                try {
                    //Read JSON file
                    String str = (String) dis.readUTF();
                    Object obj = jsonParser.parse(str);

                    JSONArray employeeList = (JSONArray) obj;
                    System.out.println(employeeList);

                    //Iterate over employee array
                    employeeList.forEach(emp -> parseEmployeeObject((JSONObject) emp));

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
