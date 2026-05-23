package estructuras.lineales.testing;


import estructuras.lineales.contenedores.PilaArr;

public class PilaEnteros {
	
	public static void main (String args[]) {
		
		PilaArr pila = new PilaArr(10);
		
		pila.meter(new Integer(3));
		pila.meter(new Integer(4));
		pila.meter(new Integer(7));
		pila.meter(new Integer(2));
		
		
		Integer primero;
		Integer segundo;
		primero = (Integer) pila.sacar();
		segundo = (Integer) pila.sacar();
		pila.meter(primero);
		pila.meter(segundo);
		
		while( ! pila.estaVacia()) {
			System.out.print("Elemento : "); System.out.println(pila.sacar());
			
		}
		
		
		return;
	}
}
