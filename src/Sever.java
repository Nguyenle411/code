
import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;
public class Sever {
    public static void main(String argv[]) throws Exception
    {
        int n;
        
        ManagerLibary managerLibary = new ManagerLibary();
        LibaryLan libaryLan = new LibaryLan();
        ServerSocket welcomeSocket = new ServerSocket(6543);
        while(true) {
        	while(true) {
                Socket connectionSocket = welcomeSocket.accept();
                BufferedReader inFromClient =
                    new BufferedReader(new
                        InputStreamReader(connectionSocket.getInputStream())); 
                DataOutputStream outToClient =
                    new DataOutputStream(connectionSocket.getOutputStream());
                	n = inFromClient.read();
                	if(n == 1) {
                		String vn = inFromClient.readLine();
                		String ta = inFromClient.readLine();
                		String tu = inFromClient.readLine();
                		String old = inFromClient.readLine();
                		LibaryLan lan = new LibaryLan(vn, ta, tu, old);
                		managerLibary.add(lan);
                	}
                	if(n == 2) {
                		String vn = inFromClient.readLine();
                		String ta = inFromClient.readLine();
                		String tu = inFromClient.readLine();
                		String old = inFromClient.readLine();
                		LibaryLan lan = new LibaryLan(vn, ta, tu, old);
                		managerLibary.update(lan);
                		outToClient.write(managerLibary.update(lan));
                	}
                	if(n == 3) {
                		String vn = inFromClient.readLine();
                		int m = managerLibary.delete(vn);
                			outToClient.write(m);
              	}
                	if(n == 4) {
                		String E = inFromClient.readLine();
                		libaryLan = managerLibary.select(E);
                		if(libaryLan == null) {
                			String m = "1";
                			outToClient.writeBytes(m + "\n");
                		}
                		else {
                			outToClient.writeBytes(libaryLan.getVocabulary() + "\n");
                    		outToClient.writeBytes(libaryLan.getCategory() + "\n");
                    		outToClient.writeBytes(libaryLan.getPast() + "\n");
                    		outToClient.writeBytes(libaryLan.getVietnam() + "\n");
                		}
                	}
                	if(n == 5) {
                		String E = inFromClient.readLine();
                		libaryLan = managerLibary.select2(E);
                		if(libaryLan == null) {
                			String m = "1";
                			outToClient.writeBytes(m + "\n");
                		}
                		else {
                			outToClient.writeBytes(libaryLan.getVocabulary() + "\n");
                    		outToClient.writeBytes(libaryLan.getCategory() + "\n");
                    		outToClient.writeBytes(libaryLan.getPast() + "\n");
                    		outToClient.writeBytes(libaryLan.getVietnam() + "\n");
                		}
                	}
            }
        }
        
    }
}