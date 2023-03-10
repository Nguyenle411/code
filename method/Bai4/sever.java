package Bai4;
import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;
public class sever {
    public static void main(String argv[]) throws Exception
    {
        String sentence_from_client;
        ServerSocket welcomeSocket = new ServerSocket(9999);
        while(true) {
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient =
                new BufferedReader(new
                    InputStreamReader(connectionSocket.getInputStream())); 
            DataOutputStream outToClient =
                new DataOutputStream(connectionSocket.getOutputStream());
            sentence_from_client = inFromClient.readLine();
            ThongKe TK = new ThongKe();
            String C = TK.thongke(sentence_from_client);
            C = C +'\n';
            System.out.println(C);
            outToClient.writeBytes(C); 
        }
        
    }
}