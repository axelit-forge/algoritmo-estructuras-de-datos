package estructuras.lineales.testing;

import estructuras.lineales.contenedores.ColaArr;
import estructuras.lineales.contenedores.PilaArr;

import java.util.Random;

public class Ejercicio11 {
	
	public static void main(String []args) {
		
		PilaArr pila = new PilaArr(20);
		PilaArr pilaAux = new  PilaArr(20);
		ColaArr cola = new ColaArr(20);
		
		Random rand = new Random();
		
		for(int i = 0 ; i< 20; i++) {
			int numero = rand.nextInt(1000) + 1;
			System.out.println("Número aleatorio: " + numero);
			
			pila.meter(numero);
		}
		
		while(! pila.estaVacia()) {
			int auxiliar = (int) pila.sacar();
			if(esCapicua(auxiliar)) 
				cola.meter(auxiliar);
			else
				pilaAux.meter(auxiliar);
			
		}
		while(!pilaAux.estaVacia()) {
			pila.meter(pilaAux.sacar());
		}
		
		
		System.out.print("No capicuas : ");
		while( ! pila.estaVacia()) {
			System.out.print("Elemento : " + pila.sacar());
			
		}
		
		System.out.print("Capicuas : ");
		while( ! cola.estaVacia()) {
			 System.out.println("Elemento: " + cola.sacar());
		}
		
	}
	
	public static boolean esCapicua(int a) {
		int copia = a, reverso = 0;
		while (copia>0) {
			reverso = reverso*10 + copia%10;
			copia = copia/10;
		}
	
		return (reverso == a);
	}
	
}
