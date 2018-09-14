

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfazMensajes extends Remote {
	public void pidePista(Avion avion) throws RemoteException, InterruptedException;
	public void aterriza(Avion avion) throws RemoteException, InterruptedException;
}
