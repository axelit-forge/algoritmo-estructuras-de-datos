package estructuras.lineales.contenedores;

import interfaces.OperacionesCL1;
import recursos.Nodo;

public class ColaSLinkedList implements OperacionesCL1 {
	private Nodo frenteC;
	private Nodo finalC;
	
	
	public ColaSLinkedList() {
		limpiar();
	}
	
	
	public void meter(Object elemento) {
		
		Nodo nuevo = new Nodo(elemento);
		
		if(!estaVacia()) {
			this.finalC.setNextNodo(nuevo);
			this.finalC = nuevo;
		}
		else {
			this.frenteC = nuevo;
			this.finalC = nuevo;
		}
		
	}
	
	public Object sacar() {
		Object elemento = null;
		
		if( ! estaVacia()) {
			
			elemento = this.frenteC.getNodoInfo();
			this.frenteC = this.frenteC.getNextNodo();
			
			if(estaVacia())
				this.finalC = null;
			
		}
		else
			System.out.println("Error: cola vacía");
		
		return elemento;
	}
	
	public boolean estaVacia() {
		return (this.frenteC == null);
	}
	
	public void limpiar() {
		this.finalC = this.frenteC = null;
	}
	
	
}
