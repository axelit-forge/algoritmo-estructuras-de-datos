package estructuras.no_lineales.testing;

public class TestABB {
	public static void main(String[] args) {
		IntABB miArbol;
		
		miArbol = new IntABB();
		
		miArbol.meter(new Integer(10));
		
/*		
		miArbol.meter(new Integer(7));
		miArbol.meter(new Integer(5));
		miArbol.meter(new Integer(1));
		miArbol.meter(new Integer(6));
		miArbol.meter(new Integer(9));
*/
		
		miArbol.meter(new Integer(20));
		miArbol.meter(new Integer(15));
		miArbol.meter(new Integer(14));
		miArbol.meter(new Integer(30));
		miArbol.meter(new Integer(10));
		
		miArbol.muestraInOrder();
		System.out.println("***");
		
	    miArbol.sacar(new Integer(10));
		miArbol.muestraInOrder();
		System.out.println("***");

		System.out.println("la cantidad de hojas es " + miArbol.cuentaHojas());
		
		System.out.println("la altura es " + miArbol.altura());
		
		System.out.println("la cantidad de nodos es " + miArbol.cuentaNodos());
		
	}

}
