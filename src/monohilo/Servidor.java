package monohilo;

import java.io.*;  
import java.net.*;
import java.util.Scanner;
import java.util.logging.*;  


public class Servidor {  
       
	
	//------------- Atributos --------------------------//
    private ServerSocket ss; 
    private Socket socket;
    private int idSession;
    private DataOutputStream dos;  
    private DataInputStream dis; 
        
    
    //------------- Constructor --------------------------//
    public Servidor(){
    	try {
			ss=new ServerSocket(10578);
			this.conectarServidor();
		} catch (IOException ex) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
		} 
    }
    	
    	
    //------------ Metodo para conectarse al servidor -------------------//
    public void conectarServidor() throws IOException {
    	 System.out.print("Inicializando servidor... "); 
    	 System.out.println("\t[OK]");  
            idSession = 0;  
            while (true) {    
                socket = ss.accept();
                dos = new DataOutputStream(socket.getOutputStream());  
                dis = new DataInputStream(socket.getInputStream());  
                idSession++; 
                System.out.println("Cliente: " + dis.readUTF());
                System.out.println("Servidor: \t");
                String mensaje = new Scanner(System.in).nextLine();
                dos.writeUTF(mensaje);  
            }    		 
    }
    	
    	    	
}  