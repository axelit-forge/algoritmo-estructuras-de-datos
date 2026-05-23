package estructuras.lineales.contenedores;

import interfaces.OperacionesCL3;
import recursos.NodoDoble;

public abstract class Lista1DLinkedList extends Lista0DLinkedL implements OperacionesCL3 {
	
	public Lista1DLinkedList() {
		limpiar();
	}
	
	
	public void ingresar(Object elemento, int posicion) {
		NodoDoble nodo;
		if(posicion > tamanio() || posicion < 0) {
			System.out.println("Error : La posicion no existe");
			return;
		}
		
		if(posicion == 0) {
			if(!estaVacia()) {
				this.frenteL = new NodoDoble (elemento, null, this.frenteL);
				this.frenteL.getNextNodo().setPrevNodo(this.frenteL);
			}
			else
				this.frenteL = this.finalL = new NodoDoble (elemento);
			
			this.ultimo++;
			return;
		}
		
		if(posicion == tamanio()) {
			this.finalL = new NodoDoble (elemento, this.finalL, null);
			this.finalL.getPrevNodo().setNextNodo(this.finalL);
			
			this.ultimo++;
			return;
		}
		
		NodoDoble prev, next;
		prev = this.frenteL;
		next = this.frenteL.getNextNodo();
		
		for(int counter = 1; counter < posicion ; counter++) {
			prev = prev.getNextNodo();
			next = next.getNextNodo();
		}
		nodo = new NodoDoble(elemento,prev,next);
		prev.setNextNodo(nodo); 
		next.setPrevNodo(nodo);	
		
		this.ultimo++;
	}
	public void reemplazar(Object elemento, int posicion) {
		
		if(posicion > tamanio() || posicion < 0) {
			System.out.println("Error : La posicion no existe");
			return;
		}
		
		if(posicion == 0) {
			this.frenteL.setNodoInfo(elemento);
		}
		
		if(posicion == tamanio()) {
			this.finalL.setNodoInfo(elemento);
		}
		
		NodoDoble temp;
		temp = this.frenteL;
		
		for(int counter = 1; counter < posicion ; counter++) 
			temp = temp.getNextNodo();
		
		temp.setNodoInfo(elemento);
			
	}
	
}
