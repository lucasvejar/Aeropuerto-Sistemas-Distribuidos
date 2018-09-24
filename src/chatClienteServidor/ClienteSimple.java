package chatClienteServidor;
import java.awt.Frame;
import java.awt.TrayIcon.MessageType;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.DataTruncation;
import java.sql.Time;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.xml.crypto.Data;

public class ClienteSimple {
	
	
	//--------- Atributos --------------------//
	protected Socket sk;  
    protected DataOutputStream dos;  
    protected DataInputStream dis;  
    private String nombre;
   
   
    //--------------- Constructor ----------------------//
    public ClienteSimple(String nombre) {  
       this.nombre = nombre;
    }  
    
    //----------- Metodo que envia los datos al servidor -------------------//
    public void enviarDatos()
    {
    	try {
			Socket socket = new Socket("127.0.0.1", 5000);
			DataOutputStream dataOutput = new DataOutputStream(socket.getOutputStream());
	        DataInputStream dataInput = new DataInputStream(socket.getInputStream());  
	        
	        //--> le paso el nombre del cliente a el servidor
	        dataOutput.writeUTF(getNombre());
	        
	        //--> recibo contestación recibido
	        String respuesta = dataInput.readUTF();
	        JOptionPane.showMessageDialog(new Frame(), "Mensaje recibido del Servidor:"+respuesta+" / "+socket, "Mensaje de Servidor", 1);

	        dataInput.close();
	        dataOutput.close();
	        socket.close();
	        
		} catch (IOException e) {
			e.printStackTrace();
		}   
     
    	
    	 try {  
    		 System.out.println("--------------------------------------");
    		 System.out.println(" - - - - > Comience a chatear. . .");
    		 System.out.println("--------------------------------------");
    		
    		 
             while(true){
            	 
            	this.setSk(new Socket("127.0.0.1", 10578));   //127.0.0.1   192.168.1.100
                this.setDos(new DataOutputStream(this.getSk().getOutputStream()));  
                this.setDis(new DataInputStream(this.getSk().getInputStream()));  
                
                //----------- Leo el mensaje que se pone por pantalla ---------------//
                System.out.print(getNombre()+": ");
                String mensaje = new Scanner(System.in).nextLine();
     	
                
     			//--------- parte importante ------------------------// 
                this.getDos().writeUTF(mensaje);  
                String respuesta=""; 
             
                respuesta = this.getDis().readUTF();
                if (!respuesta.equals("")) {
                	Time ahora = new Time(System.currentTimeMillis());
                	System.out.println("["+ahora+"] Servidor: " + respuesta);
                }
  
                //------------------------------------------------------//
                
                this.getDis().close();  
                this.getDos().close();  
                this.getSk().close();  
                
     		}
             
     
         } catch (IOException ex) {  
             Logger.getLogger(ClienteSimple.class.getName()).log(Level.SEVERE, null, ex);  
         }  
    }
   
	
    
    //------------ Geters y Seters -----------------------------------//
	public Socket getSk() {
		return sk;
	}
	public void setSk(Socket sk) {
		this.sk = sk;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

}
