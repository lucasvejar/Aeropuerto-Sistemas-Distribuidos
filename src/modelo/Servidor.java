package modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;  
import java.net.*;
import java.util.Scanner;
import java.util.logging.*;

import vista.VentanaChat;  


public class Servidor {  
       
	
	//------------- Atributos --------------------------//
    private ServerSocket ss; 
    private Socket socket;
    private int idSession = 0;
    private DataOutputStream dos;  
    private DataInputStream dis; 
    private VentanaChat ventana;   
    
    
    //------------- Constructor --------------------------//
    public Servidor(){
    	setVentana(new VentanaChat());
    	getVentana().setVisible(true);
    	getVentana().getBtnEnviar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()== getVentana().getBtnEnviar()) {
					if(!getVentana().getTextMensaje().getText().equals("")) {
						System.out.println("Se cumplio la condicion Servidor");
						getVentana().getTextMensaje().setText("");
					}
				}
			}
		});
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


    
    //----------- Getters y Setters ----------------------//
    
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


	public VentanaChat getVentana() {
		return ventana;
	}


	public void setVentana(VentanaChat ventana) {
		this.ventana = ventana;
	}
    	
    	    	
}  