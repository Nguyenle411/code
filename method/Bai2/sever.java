package Bai2;
import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;
public class sever {
    public static void main(String argv[]) throws Exception
    {
        String sentence_from_client;
        ServerSocket welcomeSocket = new ServerSocket(1234);
        while(true) {
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient =
                new BufferedReader(new
                    InputStreamReader(connectionSocket.getInputStream())); 
            DataOutputStream outToClient =
                new DataOutputStream(connectionSocket.getOutputStream());
            sentence_from_client = inFromClient.readLine();
            Sapxep sapxep = new Sapxep(sentence_from_client);
            String m = sapxep.xep(sentence_from_client);
            m = m +'\n';
            outToClient.writeBytes(m); 
        }
        
    }
}