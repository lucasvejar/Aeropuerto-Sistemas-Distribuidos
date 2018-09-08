
public class mainCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		ProductorUno p1 = new ProductorUno(1,"127.0.0.1",3000);
		p1.setName("Avion Uno");
		ProductorUno p2 = new ProductorUno(2,"127.0.0.1",3000);
		p2.setName("Avion Dos");
		ProductorUno p3 = new ProductorUno(3,"127.0.0.1",3000);
		p3.setName("Avion Tres");
		ProductorUno p4 = new ProductorUno(4,"127.0.0.1",3000);
		p4.setName("Avion Cuatro");
		ProductorUno p5 = new ProductorUno(5,"127.0.0.1",3000);
		p5.setName("Avion Cinco");
		ProductorUno p6 = new ProductorUno(6,"127.0.0.1",3000);
		p5.setName("Avion Seis");
		ProductorUno p7 = new ProductorUno(7,"127.0.0.1",3000);
		p5.setName("Avion Siete");
		ProductorUno p8 = new ProductorUno(8,"127.0.0.1",3000);
		p5.setName("Avion Ocho");
		ProductorUno p9 = new ProductorUno(9,"127.0.0.1",3000);
		p5.setName("Avion  Nueve");
		ProductorUno p10 = new ProductorUno(10,"127.0.0.1",3000);
		p10.setName("Avion Diez");
		
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
		p6.start();
		p7.start();
		p8.start();
		p9.start();
		p10.start();
		
	
		
		
	}

}
