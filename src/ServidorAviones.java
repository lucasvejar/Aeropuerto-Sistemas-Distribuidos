

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.security.Timestamp;
import java.sql.Array;
import java.sql.Time;
import java.util.ArrayList;
import java.util.LinkedList;



public class ServidorAviones extends UnicastRemoteObject implements InterfazMensajes,Serializable {

	
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
		this.setRecurso(new ArrayList());
		this.ip = InetAddress.getLocalHost().getHostAddress();
		this.nroPuerto = numeroPuertoRemoto;
		this.registro = LocateRegistry.createRegistry(nroPuerto);
		this.registro.rebind("rmiServidor", this);
		System.err.println("servidor inicializado en ip: " + ip + " port:" + nroPuerto+"\n");
	}


	
	//----------- Metodos de la interfaz ------------------------//

	@Override
	public synchronized void pidePista(Avion avion) throws RemoteException, InterruptedException {
		
		while (this.getRecurso().size() >= this.getCantidadPistasAeropuerto()) {
			System.out.println("---> Avion "+avion.getNumero()+" esperando pista para aterrizar...");
			wait();
		}
		concedePista(avion);
		
	}


	
	public synchronized void concedePista(Avion avion) throws InterruptedException, RemoteException {
		this.getRecurso().add(avion.getNumero());
		System.out.println("Pista :"+getRecurso().indexOf(avion.getNumero()));
		System.out.println("Se asigno la pista al Avion "+avion.getNumero());
		avion.sleep(5000); // 30 segundos
	}
	

	
	public synchronized void aterriza(Avion avion) throws RemoteException, InterruptedException {		
		this.getRecurso().remove(avion.getNumero());
		System.out.println(avion.getNumero()+" aterrizo correctamente!");
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
	public ArrayList getRecurso() {
		return recurso;
	}



	/**
	 * @param linkedList the recurso to set
	 */
	public void setRecurso(ArrayList linkedList) {
		this.recurso = linkedList;
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
