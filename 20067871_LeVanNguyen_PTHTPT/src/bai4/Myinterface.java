package bai4;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Myinterface extends Remote {
	public String Count(String mess) throws RemoteException;
}
