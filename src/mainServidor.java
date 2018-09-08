import java.net.UnknownHostException;
import java.rmi.RemoteException;

public class mainServidor {

	public static void main(String[] args) throws UnknownHostException, RemoteException {
		// TODO Auto-generated method stub
		RecursoCompartido rc = new RecursoCompartido(3000);
	}

}
