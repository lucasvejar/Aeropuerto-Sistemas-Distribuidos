package chatClienteServidor;

import java.io.*;  
import java.net.*;
import java.sql.Time;
import java.util.Scanner;
import java.util.logging.*;  


public class Servidor {  
       
	
	//------------- Atributos --------------------------//
    private ServerSocket ss; 
    private Socket socket;
    private int idSession;
    private DataOutputStream dos;  
    private DataInputStream dis;
    private String nombreCliente;
        
    
    //------------- Constructor --------------------------//
    public Servidor(){
    	try {
			ss = new ServerSocket(10578);  //-----> server socket que se utiliza para el chat
			ServerSocket serverS = new ServerSocket(5000);  //--> server socket que se utiliza solo para recibir el nombre del cliente
			obtengoNombreCliente(serverS);   //---> obtiene el nombre del cliente 
			this.conectarServidor();  //-------> inicia el servidor esperando recibir mensajes del cliente
		} catch (IOException ex) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
		} 
    }
    	
    
    //---------- Metodo para obtener el nombre que le envia el cliente ------------//
    public void obtengoNombreCliente(ServerSocket ss) throws IOException {
    	Socket s = ss.accept();
    	DataInputStream dataI = new DataInputStream(s.getInputStream());
    	DataOutputStream dataO = new DataOutputStream(s.getOutputStream());
    	String nombre = dataI.readUTF();
    	if (!nombre.equals("")) {
    		setNombreCliente(nombre);
    	} else {
    		setNombreCliente("Cliente");
    	}
    	dataO.writeUTF("recibido");
    	
    	dataI.close();
    	dataO.close();
    	s.close();
    }
    
    
    	
    //------------ Metodo para conectarse al servidor -------------------//
    public void conectarServidor() throws IOException {
    	 System.out.println("Inicializando servidor...    [OK] "); 
    	 System.out.println(" SERVIDOR ESPERANDO MENSAJE DE "+getNombreCliente());
         idSession = 0; 
         
         while (true) {   
        	 
                socket = ss.accept();
                dos = new DataOutputStream(socket.getOutputStream());  
                dis = new DataInputStream(socket.getInputStream());  
                
                String recibido = dis.readUTF();
                if (!recibido.equals("")) {
                	Time ahora = new Time(System.currentTimeMillis());
                	System.out.println("["+ahora+"] "+getNombreCliente()+": " + recibido);
                	System.out.print("Servidor: ");
                    String mensaje = new Scanner(System.in).nextLine();
                    dos.writeUTF(mensaje);
                } else {
                	System.out.print("Servidor: ");
                    String mensaje = new Scanner(System.in).nextLine();
                    dos.writeUTF(mensaje);
                }
                
         } 
       
    }


    
    //------------ Getter y Setters ------------------//
    
	public ServerSocket getSs() {
		return ss;
	}


	public void setSs(ServerSocket ss) {
		this.ss = ss;
	}


	public Socket getSocket() {
		return socket;
	}


	public void setSocket(Socket socket) {
		this.socket = socket;
	}


	public int getIdSession() {
		return idSession;
	}


	public void setIdSession(int idSession) {
		this.idSession = idSession;
	}


	public DataOutputStream getDos() {
		return dos;
	}


	public void setDos(DataOutputStream dos) {
		this.dos = dos;
	}


	public DataInputStream getDis() {
		return dis;
	}


	public void setDis(DataInputStream dis) {
		this.dis = dis;
	}



	public String getNombreCliente() {
		return nombreCliente;
	}



	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
 	
    	    	
}  