import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyInterface extends Remote {
	public int add(LibaryLan li) throws RemoteException;
	public int update(LibaryLan vietnam) throws RemoteException;
	public int delete(String vietnam) throws RemoteException;
	public LibaryLan select(String vocabulary) throws RemoteException;
	public LibaryLan select2(String vietnam) throws RemoteException;
}
