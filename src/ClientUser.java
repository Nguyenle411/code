import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientUser {
	public static void main(String argv[]) throws Exception {

		while (true) {
			LibaryLan libaryLan = new LibaryLan();
			Scanner sc = new Scanner(System.in);
			Socket clientSocket = new Socket("127.0.0.1", 6543);
			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			int n;
			System.out.println("MENU");
			System.out.println("1.them tu");
			System.out.println("2.sua tu");
			System.out.println("3.xoa tu");
			System.out.println("4.Dich tu anh sang viet");
			System.out.println("5.Dich tu viet sang anh");
			System.out.println("enter one for exit");
			System.out.println("enter number");
			n = sc.nextInt();
			sc.nextLine();
			if (n == 1) {
				System.out.println("nhap tu tieng viet");
				String vn = sc.nextLine();
				System.out.println("nhap tu tieng anh");
				String ta = sc.nextLine();
				System.out.println("nhap tu loai");
				String tu = sc.nextLine();
				System.out.println("nhap tu qua khu");
				String old = sc.nextLine();
				outToServer.writeByte(n);
				outToServer.writeBytes(vn + "\n");
				outToServer.writeBytes(ta + "\n");
				outToServer.writeBytes(tu + "\n");
				outToServer.writeBytes(old + "\n");
			} else if (n == 2) {
				System.out.println("nhap tu tieng viet");
				String vn = sc.nextLine();
				System.out.println("nhap tu tieng anh");
				String ta = sc.nextLine();
				System.out.println("nhap tu loai");
				String tu = sc.nextLine();
				System.out.println("nhap tu qua khu");
				String old = sc.nextLine();
				outToServer.writeByte(n);
				outToServer.writeBytes(vn + "\n");
				outToServer.writeBytes(ta + "\n");
				outToServer.writeBytes(tu + "\n");
				outToServer.writeBytes(old + "\n");
				int m = inFromServer.read();
				if(m == 1) {
					System.out.println("not found");
				}
				else {
					System.out.println("sua thanh cong");
				}
			} else if (n == 3) {
				outToServer.writeByte(n);
				System.out.println("nhap tu tieng viet can xoa");
				String vn = sc.nextLine();
				outToServer.writeBytes(vn + "\n");
				int m = inFromServer.read();
				if(m == 1) {
					System.out.println("not found");
				}
				else {
					System.out.println("xoa thanh cong");
				}
			} else if (n == 4) {
				outToServer.writeByte(n);
				System.out.println("nhap tu can dich");
				String E = sc.nextLine();
				outToServer.writeBytes(E + "\n");

				String m = inFromServer.readLine();
				if (m.equals("1")) {
					System.out.println("not found");
				} else {
//					String ta = inFromServer.readLine();
					String tu = inFromServer.readLine();
					String old = inFromServer.readLine();
					String vn = inFromServer.readLine();
					System.out.println(
							"vocabulary : " + m + "  Category : " + tu + "  past : " + old + "  vietnam : " + vn);
				}
			} else if (n == 5) {
				outToServer.writeByte(n);
				System.out.println("nhap tu can dich");
				String E = sc.nextLine();
				outToServer.writeBytes(E + "\n");

				String m = inFromServer.readLine();
				if (m.equals("1")) {
					System.out.println("not found");
				} else {
//					String ta = inFromServer.readLine();
					String tu = inFromServer.readLine();
					String old = inFromServer.readLine();
					String vn = inFromServer.readLine();
					System.out.println(
							"vocabulary : " + m + "  Category : " + tu + "  past : " + old + "  vietnam : " + vn);
				}
			}
			clientSocket.close();
		}
	}
}