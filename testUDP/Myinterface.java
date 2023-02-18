package testUDP;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Myinterface extends Remote{
	String NT(String str) throws RemoteException;
}
