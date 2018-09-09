

import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class mainServidor {
	
	public static void main(String[] args) throws RemoteException, NotBoundException, UnknownHostException {	
		ServidorAviones s = new ServidorAviones(2000);
		
	}
	
	
}
