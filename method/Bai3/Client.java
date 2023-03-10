package Bai3;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;
public class Client {
    public static void main(String argv[]) throws Exception
    {
      	String n;
        String m;
        while(true) {
            System.out.print("Enter String: ");
            Scanner sc = new Scanner(System.in);
            n = sc.nextLine();
            Socket clientSocket = new Socket("127.0.0.4", 9999);
            DataOutputStream outToServer =
                new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader inFromServer =
                new BufferedReader(new
                InputStreamReader(clientSocket.getInputStream()));
            outToServer.writeBytes(n + '\n');
            m = inFromServer.readLine();
            System.out.println(m);
            clientSocket.close(); 
        }
    }
}