

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;



public class ServidorAviones extends UnicastRemoteObject implements InterfazMensajes {

	
	//---------- Atributos -------------------//
	private Integer nroPuerto;
	private String ip;
	private Registry registro;
	private static final long serialVersionUID = 1L;
	private ArrayList<Integer> recurso;  //--> el recurso son las pistas
	private Integer cantidadPistasAeropuerto = 5;
	
	
	//----------- Constructor ------------------//
	
	protected ServidorAviones(int numeroPuertoRemoto) throws RemoteException, UnknownHostException {
		super();
		this.setRecurso(new ArrayList<Integer>());
		this.ip = InetAddress.getLocalHost().getHostAddress();
		this.nroPuerto = numeroPuertoRemoto;
		this.registro = LocateRegistry.createRegistry(nroPuerto);
		this.registro.rebind("rmiServidor", this);
		System.err.println("servidor inicializado en ip: " + ip + " port:" + nroPuerto+"\n");
	}


	
	//----------- Metodos de la interfaz ------------------------//

	@Override
	public synchronized void pidePista(Integer nroAvion) throws RemoteException, InterruptedException {
		
		while (this.getRecurso().size() >= this.getCantidadPistasAeropuerto()) {
			System.out.println("---> Avion "+nroAvion+" esperando pista para aterrizar...");
			wait();
		}
		this.getRecurso().add(nroAvion);
		System.out.println("Se asigno una pista al Avion "+nroAvion);
		Thread.currentThread().sleep(10000);
		aterriza(nroAvion);
	}



	public synchronized void aterriza(Integer nroAvion) throws RemoteException, InterruptedException {
		this.getRecurso().remove(nroAvion);
		System.out.println("Avion "+nroAvion+" aterrizo correctamente!");
		notifyAll();
		
	}


	
	//------------- Getters y Setters ------------------------------------//
	
	public Integer getNroPuerto() {
		return nroPuerto;
	}


	public void setNroPuerto(Integer nroPuerto) {
		this.nroPuerto = nroPuerto;
	}

	public String getIP() {
		return ip;
	}

	public void setIP(String iP) {
		ip = iP;
	}

	public Registry getRegistro() {
		return registro;
	}

	public void setRegistro(Registry registro) {
		this.registro = registro;
	}



	/**
	 * @return the recurso
	 */
	public ArrayList<Integer> getRecurso() {
		return recurso;
	}



	/**
	 * @param recurso the recurso to set
	 */
	public void setRecurso(ArrayList<Integer> recurso) {
		this.recurso = recurso;
	}



	/**
	 * @return the cantidadPistasAeropuerto
	 */
	public Integer getCantidadPistasAeropuerto() {
		return cantidadPistasAeropuerto;
	}



	/**
	 * @param cantidadPistasAeropuerto the cantidadPistasAeropuerto to set
	 */
	public void setCantidadPistasAeropuerto(Integer cantidadPistasAeropuerto) {
		this.cantidadPistasAeropuerto = cantidadPistasAeropuerto;
	}
	
	
}
