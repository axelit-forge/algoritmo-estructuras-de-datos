package estructuras.lineales.contenedores;

import interfaces.OperacionesCL4;
import recursos.NodoDoble;

public abstract class Lista2DLinkedList extends Lista0DLinkedL implements OperacionesCL4 {
	
	public void insertar (Object elemento) {
		NodoDoble nodo;

		if (estaVacia()) {
			this.frenteL = this.finalL = new NodoDoble(elemento);
			
		} else{
			if (esMenor(elemento, this.frenteL.getNodoInfo())) {		
				this.frenteL = new NodoDoble(elemento, null, this.frenteL); 
				this.frenteL.getNextNodo().setPrevNodo(this.frenteL); 
				
			}else{
				
				if (esMayor(elemento, this.finalL.getNodoInfo()) || iguales(elemento, this.finalL.getNodoInfo())) {	
					this.finalL = new NodoDoble (elemento, this.finalL, null);
					this.finalL.getPrevNodo().setNextNodo(this.finalL);

				}else{				
					
					NodoDoble temp = this.frenteL;
					boolean flag = false;
					while (temp.getNextNodo() != null && !flag) {
						if (esMayor(elemento, temp.getNextNodo().getNodoInfo()) || iguales(elemento, temp.getNextNodo().getNodoInfo())) {
							temp = temp.getNextNodo();
						}else{
							flag = true;
						}
					}				
								
					nodo = new NodoDoble(elemento, temp, temp.getNextNodo());
					temp.getNextNodo().setPrevNodo(nodo);
					temp.setNextNodo(nodo);	
				}
			}
		}
		
		this.ultimo++; 
	}	
	
	
	public abstract boolean iguales(Object elemento1, Object elemento2);
	public abstract boolean esMenor(Object elemento1, Object elemento2);
	public abstract boolean esMayor(Object elemento1, Object elemento2);
	
	
	public int buscar(Object elemento){
		
		if(estaVacia()) {
			return -1;
		}
		
		int pos = 0;
		NodoDoble trav;
		
		trav = this.frenteL;
		while (trav != null) {
			
			if (iguales(elemento, trav.getNodoInfo()))
				return pos;
			
			if (esMayor(elemento, trav.getNodoInfo())) 
				return -1; 
			
			pos++;
			trav = trav.getNextNodo();
		    }

		return -1;
	}
}
