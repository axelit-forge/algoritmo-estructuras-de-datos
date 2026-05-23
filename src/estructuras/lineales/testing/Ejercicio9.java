package estructuras.lineales.testing;

import estructuras.lineales.contenedores.PilaSLinkedList;

public class Ejercicio9 {
	
	public static void main (String args[]) {
		
		PilaSLinkedList pila = new PilaSLinkedList();
		
		String texto = ")(Hola pe causa";
		
		int i = 0; 
		boolean flag = true;
		
		while(i< texto.length() && flag ) {
		    
			char c = texto.charAt(i);
		    
		    if(c == '(') {
		    	pila.meter(c);
		    }
		    
		    if(c == ')') {
		    	if(pila.estaVacia()) 
		    		flag = false;
		    	else
		    		pila.sacar();
		    }
		    
		    i++;
		}
		
		if(flag && pila.estaVacia())
			System.out.println("Los parentesis estuvieron balanceados");
		else
			System.out.println("Los parentesis no estuvieron balanceados");
		
		
		return;
	}
	
}
