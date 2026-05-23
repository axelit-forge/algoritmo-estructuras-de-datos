package estructuras.lineales.contenedores;

import interfaces.OperacionesCL1;

public class PilaArr implements OperacionesCL1 {
	
	protected Object[] pila;
	protected int cabeza;
	private int tamPila;
	
	public PilaArr(int tamPila) {
		this.tamPila = tamPila;
		this.pila = new Object [tamPila];
		limpiar();
	}
	
	
	public void meter(Object elemento) {
		
		if( ! estaLlena()) {
			incrementaCabeza();
			pila[this.cabeza] = elemento;
			
		}
		else
			System.out.println("Error: pila llena");
		
	}

	
	public Object sacar() {
		Object elemento = null;
		
		if(! estaVacia()) {
			elemento = pila[this.cabeza];
			decrementaCabeza();
		}
		else
			System.out.println("Error : la pila estaba vacía");
		
		return elemento;
	}

	
	public boolean estaVacia() {
		return (this.cabeza == -1);
	}

	public boolean estaLlena() {
		return this.cabeza == this.tamPila-1;
	}
	
	
	public void limpiar() {
		this.cabeza = -1;
	}
	
	private void incrementaCabeza() {
		this.cabeza++;
	}
	
	private void decrementaCabeza() {
		this.cabeza--;
	}

}
