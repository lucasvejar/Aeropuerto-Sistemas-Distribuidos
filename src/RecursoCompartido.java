import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class RecursoCompartido implements InterfazMensajes {
	
	private ArrayList<Integer> pistas ;  // es un array de Integers que tiene los numeros de los aviones
	private Integer cantidadPistasAeropuerto = 5;
	private Integer nroPuerto;
	private String ip;
	private Registry registro;
	
	//------ Constructor -----------------//
	public RecursoCompartido(Integer nroPuerto) throws UnknownHostException, RemoteException
	{
		this.ip = InetAddress.getLocalHost().getHostAddress();
		this.setRecurso(new ArrayList<Integer>());
		this.nroPuerto = nroPuerto;
		this.registro = LocateRegistry.createRegistry(nroPuerto);
		this.registro.rebind("rmiServidor", this);
		System.err.println("Servidor inicializado en "+ip+"   nro puerto :"+nroPuerto);
	}
	
	
	
	
	
	//-------- Asignar pista ---------------//
	public synchronized Integer produccionNro(Integer nro) throws InterruptedException
	{
		while(this.getRecurso().size()>this.cantidadPistasAeropuerto)
		{
			try {
				System.out.println("---> Avion "+nro+" esperando pista para aterrizar...");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i < this.getRecurso().size(); i++) {
			System.out.println(" ---   Pista "+i+" : Avion "+this.getRecurso().get(i)+"\n");
		}
		System.err.println(" *** tamaño del array:" +this.getRecurso().size());
		this.getRecurso().add(nro);
		Integer pistaAsignada = this.getRecurso().indexOf(nro);
		Integer rdm = (int)(Math.random()*10 + 5);
		Thread.currentThread().sleep(rdm*1000);
		System.out.println("-->> El avion "+nro+" se asigno a la pista "+pistaAsignada);
		return pistaAsignada;
	}
	
	
	public synchronized  Integer consumirNro(Integer nroAvion) throws InterruptedException
	{
		Integer nroPista = this.getRecurso().indexOf(nroAvion);
		System.err.println(" *** valor:" +this.getRecurso().get(this.getRecurso().indexOf(nroAvion))+", indice:"+this.getRecurso().indexOf(nroAvion));
		this.getRecurso().remove(nroAvion);
		System.out.println("--> El Avion "+nroAvion+" aterrizo en "+nroPista);
		notifyAll();
		return nroPista;
	}
	
	
	public ArrayList<Integer> getRecurso() {
		return pistas;
	}
	public void setRecurso(ArrayList<Integer> recurso) {
		this.pistas = recurso;
	}





	public ArrayList<Integer> getPistas() {
		return pistas;
	}





	public void setPistas(ArrayList<Integer> pistas) {
		this.pistas = pistas;
	}





	public Integer getCantidadPistasAeropuerto() {
		return cantidadPistasAeropuerto;
	}





	public void setCantidadPistasAeropuerto(Integer cantidadPistasAeropuerto) {
		this.cantidadPistasAeropuerto = cantidadPistasAeropuerto;
	}





	public Integer getNroPuerto() {
		return nroPuerto;
	}





	public void setNroPuerto(Integer nroPuerto) {
		this.nroPuerto = nroPuerto;
	}





	public String getIp() {
		return ip;
	}





	public void setIp(String ip) {
		this.ip = ip;
	}





	public Registry getRegistro() {
		return registro;
	}





	public void setRegistro(Registry registro) {
		this.registro = registro;
	}
	
	

}
