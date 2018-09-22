package modelo;

import java.io.IOException;
import java.net.UnknownHostException;

public class mainCliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		ClienteSimple c = new ClienteSimple();
		while (true) {
			c.enviarDatos();	
		}
	}

}
