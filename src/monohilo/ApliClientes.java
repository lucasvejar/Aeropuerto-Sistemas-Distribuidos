package monohilo;


import java.util.Scanner;


public class ApliClientes {

	public static void main(String[] args) {  
	            
		ClienteSimple cs = new ClienteSimple();
		while(true){
			System.out.println("Cliente: \t");
			String mensaje = new Scanner(System.in).nextLine();
			cs.enviarDatos(mensaje);
		}
	}
}
	        

