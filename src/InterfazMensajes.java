import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfazMensajes extends Remote{
	public Integer produccionNro(Integer nro) throws RemoteException, InterruptedException;
	public Integer consumirNro(Integer nro) throws RemoteException, InterruptedException;
}
