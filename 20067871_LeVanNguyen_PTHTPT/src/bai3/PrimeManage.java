package bai3;

import java.math.BigInteger;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class PrimeManage extends UnicastRemoteObject implements Myinterface {

	protected PrimeManage() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String Prime(String str) throws RemoteException {
		String[] numbers = str.split(" ");

        StringBuilder primeStringBuilder = new StringBuilder();

        for (String number : numbers) {
            if (isPrime(new BigInteger(number))) {
                primeStringBuilder.append(number).append(" ");
            }
        }

        return primeStringBuilder.toString().trim();
		 
	}
	public static boolean isPrime(BigInteger number) {
        return number.isProbablePrime(100);
    }

}
