package modelo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import vista.VentanaChat;

public class ClienteSimple {
	
	
	//--------- Atributos --------------------//
	protected Socket sk;  
    protected DataOutputStream dos;  
    protected DataInputStream dis; 
    private VentanaChat ventana;
   
    //--------------- Constructor ----------------------//
    public ClienteSimple() {  
       setVentana(new VentanaChat());
       getVentana().setVisible(true);
       getVentana().getBtnEnviar().addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==getVentana().getBtnEnviar()) {
				if(!getVentana().getTextMensaje().getText().equals("")) {
					System.out.println("paso por la condicion del if del cliente");
					getVentana().getTextMensaje().setText("");
				}
			}
		}
	});
    }  
    
    //----------- Metodo que envia los datos al servidor -------------------//
    public void enviarDatos() throws UnknownHostException, IOException
    {
    	 
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

	public VentanaChat getVentana() {
		return ventana;
	}

	public void setVentana(VentanaChat ventana) {
		this.ventana = ventana;
	}

}
