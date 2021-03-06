

import java.io.IOException;
import java.io.Serializable;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Avion  extends Thread implements Serializable {

	
	//----------- RMI ------------------//
	private InterfazMensajes rmiServidor;
	private Registry registro;
	private String direccionServidor;
	private Integer puertoServidor;
	//------- propios de la clase Avion -------------//
	private Integer nroAvion;

	
	
	//------------- Constructor -----------------------------//
	public Avion(String ip, Integer puerto, Integer numero) throws NotBoundException, UnknownHostException, IOException {
		this.direccionServidor = ip;
		this.puertoServidor = puerto;
		this.setNumero(numero);
		try {
			this.conectarseAlServidor();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	
	//---------- Conecta con el servidor ----------------------//
	public void conectarseAlServidor() throws RemoteException, NotBoundException {
		registro = LocateRegistry.getRegistry(direccionServidor, puertoServidor);
		rmiServidor = (InterfazMensajes)(registro.lookup("rmiServidor"));
	}


	
	//----------- Metodos para pedir pista y aterrizar ------------------//
	
	public void pidePista() throws RemoteException, InterruptedException {
		 rmiServidor.pidePista(this);
	}
	
	public void finaliza() throws RemoteException, InterruptedException {
		rmiServidor.aterriza(this);
	}
	
	
	
	//----------- METODO RUN DE LA CLASE THREAD ------------------------//
	
	@Override
	public void run() {
		try {
		//	Integer random = (int) (Math.random()*10 + 5);
		//	this.wait(random*1000);  // para empezar a pedir
			pidePista();
			finaliza();
		} catch (RemoteException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	//----------------- Getters y Setters --------------------------//
	public Integer getNumero() {
		return nroAvion;
	}

	public void setNumero(Integer numero) {
		this.nroAvion = numero;
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


	public String getDireccionServidor() {
		return direccionServidor;
	}


	public void setDireccionServidor(String direccionServidor) {
		this.direccionServidor = direccionServidor;
	}


	public Integer getPuertoServidor() {
		return puertoServidor;
	}


	public void setPuertoServidor(Integer puertoServidor) {
		this.puertoServidor = puertoServidor;
	}


	
	
}
