package estructuras.lineales.contenedores;

import recursos.NodoDoble;

import interfaces.OperacionesCL2;

public abstract class Lista0DLinkedL implements OperacionesCL2 {
	protected NodoDoble frenteL, finalL;
	protected int ultimo;
	
	
	public Lista0DLinkedL() {
		limpiar();
	}
	
	public abstract int buscar(Object elemento);
	
	public Object devolver(int posicion) {
		
		Object elemento = null;
		
		if(estaVacia()) {
			System.out.println("Error : la lista está vacía");
			return elemento;
		}
		
		if(posicion > tamanio() || posicion < 0) {
			System.out.println("Error : la posicion es invalida");
			return elemento;
		}
		
		NodoDoble temp;
		temp = this.frenteL;
		
		for (int counter = 0; counter < posicion; counter++) 						
			temp = temp.getNextNodo();		
		
		elemento = temp.getNodoInfo();						
		return elemento;
		
	}
	
	public void eliminar(int posicion) {
		if(estaVacia()) {
			System.out.println("Error : La lista está vacía");
			return;
		}
		if(posicion > tamanio() || posicion < 0) {
			System.out.println("Error : la posicion es invalida");
			return;
		}
		
		if(posicion == 0) {
			if(this.finalL == this.frenteL)
				limpiar();
			else {
				this.frenteL = this.frenteL.getNextNodo();
				this.frenteL.setPrevNodo(null);
				this.ultimo--;
			}
			return;
		}
		
		if(posicion == tamanio()) {
			this.finalL = this.finalL.getPrevNodo();
			this.finalL.setNextNodo(null);
			this.ultimo--;
			return;
		}
		
		NodoDoble prev, next;
		prev = this.frenteL;
		next = this.frenteL.getNextNodo();
		for(int counter = 1; counter < posicion; counter++) {
			prev = prev.getNextNodo();
			next = next.getNextNodo();
		}
		next = next.getNextNodo();
		prev.setNextNodo(next);
		next.setPrevNodo(prev);
		this.ultimo--;
		
		
	}
	
	public void limpiar() {
		this.frenteL = this.finalL = null;
		ultimo = -1;
	}
	
	public boolean estaVacia() {
		return (this.frenteL == null );
	}
	
	public int tamanio() {
		return this.ultimo + 1;
	}
	
	
	
	
}
