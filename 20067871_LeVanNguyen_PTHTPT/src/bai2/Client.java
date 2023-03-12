package bai2;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            // Tìm kiếm đối tượng calculator trên server
            Registry registry = LocateRegistry.getRegistry("localhost");
            Myinterface myinterface = (Myinterface) registry.lookup("myinterface");

            // Gọi phương thức add và in kết quả
            Scanner sc = new Scanner(System.in);
            System.out.println("enter String:");
            String n = sc.nextLine();
            System.out.println(myinterface.soft(n));
        } catch (NotBoundException e) {
            System.err.println("CalculatorClient exception: " + e.getMessage());
            e.printStackTrace();
        } catch (RemoteException e) {
            System.err.println("CalculatorClient exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}