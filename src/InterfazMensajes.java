

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfazMensajes extends Remote {
	public void pidePista(Integer nroAvion) throws RemoteException, InterruptedException;
}
