package bai3;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Myinterface extends Remote {
	public String Prime(String mess) throws RemoteException;
}
