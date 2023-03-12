package bai2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Myinterface extends Remote {
	public String soft(String mess) throws RemoteException;
}
