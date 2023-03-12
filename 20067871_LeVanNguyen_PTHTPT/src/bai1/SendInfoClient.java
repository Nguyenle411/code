package bai1;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class SendInfoClient extends UnicastRemoteObject implements Myinterface {

	protected SendInfoClient() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String sendInfo(String mess) throws RemoteException {
		// TODO Auto-generated method stub
		InetAddress ipAddress;
		try {
			ipAddress = InetAddress.getLocalHost();
			String info =  "Client's host name is " + ipAddress.getHostName() + " and IP address is " + ipAddress.getHostAddress();
			System.out.println(info);
			return mess+ "\n" + info;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mess;
		
		
	}

}
