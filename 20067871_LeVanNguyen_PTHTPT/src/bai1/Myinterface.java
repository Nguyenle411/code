package bai1;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Myinterface extends Remote {
	public String sendInfo(String mess) throws RemoteException;
}
