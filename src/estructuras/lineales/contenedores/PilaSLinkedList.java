package estructuras.lineales.contenedores;

import interfaces.OperacionesCL1;

import recursos.Nodo;

public class PilaSLinkedList implements OperacionesCL1 {

	protected Nodo pila;
	
	
	public PilaSLinkedList() {
		limpiar();
	}
	
	public void meter(Object elemento) {
		this.pila = new Nodo(elemento, this.pila);
	}

	
	public Object sacar() {
		Object elemento = null;
		
		if(! estaVacia()) {
			elemento = this.pila.getNodoInfo();
			this.pila = this.pila.getNextNodo();
		}
		else
			System.out.println("Error: pila vacia");
		
		return elemento;
	}

	
	public boolean estaVacia() {
		return (this.pila == null);
	}

	
	public void limpiar() {
		this.pila = null;
	}
	
	
	
}
