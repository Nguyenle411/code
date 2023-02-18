package testUDP;
import java.math.BigInteger;
import java.rmi.RemoteException;

public class SoNT implements Myinterface {

	@Override
	public String NT(String str) throws RemoteException {
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