package aplicacion;

import java.io.IOException;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;


public class mainAvion {

	public static void main(String[] args) throws NotBoundException, UnknownHostException, IOException, InterruptedException {
		
		
		Avion s = new Avion("127.0.0.1", 2000,1);	
		s.setName("Avion uno");
		Avion a = new Avion("127.0.0.1", 2000,2);
		a.setName("Avion dos");
		Avion d= new Avion("127.0.0.1", 2000,3);
		d.setName("Avion tres");
		Avion r = new Avion("127.0.0.1", 2000,4);	
		r.setName("Avion cuatro");
		Avion g = new Avion("127.0.0.1", 2000,5);	
		g.setName("Avion cinco");
		Avion q = new Avion("127.0.0.1", 2000,6);	
		q.setName("Avion seis");
		Avion o = new Avion("127.0.0.1", 2000,7);	
		o.setName("Avion siete");
		Avion l = new Avion("127.0.0.1", 2000,8);	
		l.setName("Avion ocho");
		Avion ou = new Avion("127.0.0.1", 2000,9);
		ou.setName("Avion nueve");
		Avion om = new Avion("127.0.0.1", 2000,10);
		om.setName("Avion diez");
		
		s.run();
		a.run();
		d.run();
		r.run();
		g.run();
		q.run();
		o.run();
		l.run();
		ou.run();
		om.run();
		
		
	}
	
}
