package monohilo;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteSimple {
	
	
	//--------- Atributos --------------------//
	protected Socket sk;  
    protected DataOutputStream dos;  
    protected DataInputStream dis;  
   
    //--------------- Constructor ----------------------//
    public ClienteSimple() {  
       
    }  
    
    //----------- Metodo que envia los datos al servidor -------------------//
    public void enviarDatos()
    {
    	 try {  
         
             while(true){
            	 
            	this.setSk(new Socket("127.0.0.1", 10578));   //127.0.0.1   192.168.1.100
                this.setDos(new DataOutputStream(this.getSk().getOutputStream()));  
                this.setDis(new DataInputStream(this.getSk().getInputStream()));  
                
                //----------- Leo el mensaje que se pone por pantalla ---------------//
                System.out.println("Cliente: \t");
                String mensaje = new Scanner(System.in).nextLine();
     			
     			//--------- parte importante ------------------------//
     
                this.getDos().writeUTF(mensaje);  
                String respuesta=""; 
                
                // some other code
                
                respuesta = this.getDis().readUTF(); 
                System.out.println("Servidor: " + respuesta);
                
                
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

}
