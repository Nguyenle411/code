package testUDP;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Myinterface extends Remote{
	String xep(String str) throws RemoteException;
}
