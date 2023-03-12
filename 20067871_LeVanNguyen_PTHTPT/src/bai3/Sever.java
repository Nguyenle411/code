package bai3;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Sever {
    public static void main(String[] args) {
        try {
            // Khởi tạo RMI registry tại cổng 1099
            Registry registry = LocateRegistry.createRegistry(1099);

            // Tạo một đối tượng CalculatorImpl và đăng ký nó với tên "calculator"
            Myinterface myinterface = new PrimeManage();
            Naming.rebind("myinterface", myinterface);	

            System.out.println("CalculatorServer is running...");
        } catch (Exception e) {
            System.err.println("CalculatorServer exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}