import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ProductorUno extends Thread {
	
	private Integer nroAvion;
	private InterfazMensajes rmiServidor;
	private Registry registro;
	private String direccion;
	private Integer puerto;
	
	public ProductorUno(Integer nroAvion,String ip,Integer puerto)
	{
	
		this.setNroAvion(nroAvion);
		this.direccion = ip;
		this.puerto = puerto;
		try {
			this.conectarseAlServidor();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void conectarseAlServidor() throws RemoteException, NotBoundException {
		registro = LocateRegistry.getRegistry(direccion, puerto);
		rmiServidor = (InterfazMensajes)(registro.lookup("rmiServidor"));
	}
	
	
	public void pidePista() throws RemoteException, InterruptedException {
		rmiServidor.produccionNro(nroAvion);
	}
	
	public void aterriza() throws RemoteException, InterruptedException {
		rmiServidor.consumirNro(nroAvion);
	}
	
	public void run()
	{
	
		try {

			try {
				this.pidePista();
				this.aterriza();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

	}



	public Integer getNroAvion() {
		return nroAvion;
	}

	public void setNroAvion(Integer nroAvion) {
		this.nroAvion = nroAvion;
	}



	public InterfazMensajes getRmiServidor() {
		return rmiServidor;
	}



	public void setRmiServidor(InterfazMensajes rmiServidor) {
		this.rmiServidor = rmiServidor;
	}



	public Registry getRegistro() {
		return registro;
	}



	public void setRegistro(Registry registro) {
		this.registro = registro;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public Integer getPuerto() {
		return puerto;
	}



	public void setPuerto(Integer puerto) {
		this.puerto = puerto;
	}
	
}	
