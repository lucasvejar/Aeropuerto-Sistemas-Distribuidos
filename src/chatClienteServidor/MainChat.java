package chatClienteServidor;

import java.util.Scanner;

public class MainChat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-------------------------------");
		System.out.println("-------------------------------");
		System.out.println("  Chat Cliente-Servidor");
		System.out.println("-------------------------------");
		System.out.println("-------------------------------");
		System.out.println();
		System.out.print("--> Ingrese su nombre: ");
		String nombre = new Scanner(System.in).nextLine();
		
		ClienteSimple c = new ClienteSimple(nombre);
		c.enviarDatos();
		
	}

}
