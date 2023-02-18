package testUDP;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Sapxep extends UnicastRemoteObject implements Myinterface {
	private String str;
	protected Sapxep(String str) throws RemoteException {
		super();
		this.str = str;
	}

	@Override
	public String xep(String str) throws RemoteException {
		char[] arr = str.toCharArray();
		  for (int i = 0; i < arr.length; i++) {
		      for (int j = i + 1; j < arr.length; j++) {
		        if (Integer.parseInt(String.valueOf(arr[i])) > Integer.parseInt(String.valueOf(arr[j]))) {
		          char temp = arr[i];
		          arr[i] = arr[j];
		          arr[j] = temp;
		        }
		      }
		    }
		  String str2 = String.valueOf(arr);
		  return str2;
	}
	
}
