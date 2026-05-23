package estructuras.lineales.contenedores;

import interfaces.OperacionesCL5;
import recursos.NodoDoble;

public abstract class ConjuntoDLinkedList implements OperacionesCL5{

	private NodoDoble frenteC;
	private NodoDoble finalC;
	
	
	public ConjuntoDLinkedList() {
		limpiar();
	}
	
	
	public void limpiar() {
		this.frenteC = this.finalC = null;
	}

	public boolean estaVacia() {
		return (this.frenteC == null);
	}

	public boolean esta(Object a) {
		if(estaVacia()) {
			return false;
		}
		
		NodoDoble temp;
		temp = this.frenteC;
		
		while(temp != null) {
			
			if(igualdad(temp.getNodoInfo(), a))
				return true;
			
			temp = temp.getNextNodo();
		}
		return false;
	}

	  public void meter(Object elemento) {
	        if (!esta(elemento)) {
	            NodoDoble nuevo = new NodoDoble(elemento, this.finalC, null);
	            if (this.finalC != null)
	                this.finalC.setNextNodo(nuevo);
	            else
	                this.frenteC = nuevo; 

	            this.finalC = nuevo;
	        } else {
	            System.out.println("Error: el elemento ya pertenece al conjunto");
	        }
	    }

	  public void sacar(Object elemento) {
	        NodoDoble actual = this.frenteC;

	        while (actual != null && !igualdad(actual.getNodoInfo(), elemento)) {
	            actual = actual.getNextNodo();
	        }

	        if (actual == null) return; 

	        if (actual.getPrevNodo() != null)
	            actual.getPrevNodo().setNextNodo(actual.getNextNodo());
	        else
	            this.frenteC = actual.getNextNodo();  // Era el primero

	        if (actual.getNextNodo() != null)
	            actual.getNextNodo().setPrevNodo(actual.getPrevNodo());
	        else
	            this.finalC = actual.getPrevNodo();  // Era el último
	    }

	
	public abstract boolean igualdad(Object a, Object b);
	
}
