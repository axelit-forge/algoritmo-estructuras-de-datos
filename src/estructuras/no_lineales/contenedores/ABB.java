// implementa las operaciones insercion y eliminacion de nodos sobre un ABB. Sigue siendo abstracto
package estructuras.no_lineales.contenedores;
import estructuras.no_lineales.recursos.NodoArbolBinario;

public abstract class ABB extends ArbolBinario {
		
	public abstract boolean iguales(Object nodoA, Object nodoB);
	public abstract boolean menor(Object nodoA, Object nodoB);
	public abstract boolean mayor(Object nodoA, Object nodoB);
	
	public void meter(Object nodoInfo){
		NodoArbolBinario temp, anterior;
		NodoArbolBinario nodo = new NodoArbolBinario(nodoInfo);
		
		if (estaVacio()){
			this.root=nodo;
		}else{
			temp=this.root;
			anterior=null;
			while (temp!=null){
				anterior=temp;
				if (mayor(temp.getNodoInfo(),nodoInfo)){
					temp=temp.getLeftChild();
				}else{
					if(menor(temp.getNodoInfo(),nodoInfo)) {
						temp=temp.getRightChild();
					}else {//son iguales
						temp=null;
					}
				}
			}
			if(!iguales(anterior.getNodoInfo(),nodoInfo)) {
				if (menor(anterior.getNodoInfo(),nodoInfo)){
					anterior.setRightChild(nodo);
				}else{
					anterior.setLeftChild(nodo);
				}
			}						
		}		
	}
	
	
	
	
	private NodoArbolBinario devuelveNodo(Object nodoInfo){
		NodoArbolBinario nodo=null;
		boolean response=false;
		
		nodo=this.root;
		while (nodo!=null && !response){
			if (iguales(nodo.getNodoInfo(),nodoInfo)){
				response=true;
			}else {
				if (mayor(nodo.getNodoInfo(),nodoInfo)){
					nodo=nodo.getLeftChild();
				}else {
					nodo=nodo.getRightChild();
				}
			}
		}	
		return nodo;
	}
	

	public boolean esta(Object nodoInfo){
		NodoArbolBinario nodo;
		boolean response=false;
		if (!estaVacio()){
			nodo=devuelveNodo(nodoInfo);
			if (nodo!=null){
				response=true;
			}			
		}else{
			System.out.println("Error esta. arbol vacio...");
		}		
		return response;
	}
	
	
	public NodoArbolBinario devuelve(Object nodoInfo){
		NodoArbolBinario nodo=null;
		
		if (!estaVacio()){
			nodo=devuelveNodo(nodoInfo);			
			if (nodo==null){
				System.out.println("Error devuelve. No esta...");
			}			
		}else{
			System.out.println("Error devuelve. arbol vacio...");
		}		
		return nodo;
	}
		
	
	
	public void sacarr(Object nodoInfo){
		NodoArbolBinario temp,anterior, auxiliar;
		boolean response=false;
		
		if (!estaVacio()){
			if (esta(nodoInfo)){
				anterior=null;
				temp=this.root;
				
				while (temp!=null && !response){					
					if (iguales(temp.getNodoInfo(),nodoInfo)){
						response=true;
					}else {
						anterior=temp;
						if (mayor(temp.getNodoInfo(),nodoInfo)){
							temp=temp.getLeftChild();
						}else {
							temp=temp.getRightChild();
						}
					}					
				}
				
				if (temp.getLeftChild()==null && temp.getRightChild()==null){
					// el nodo a eliminar es hoja
					if (anterior==null){
						limpiar();
					}else{
						if (anterior.getLeftChild()==temp){
							anterior.setLeftChild(null);
						}else{
							anterior.setRightChild(null);
						}
					}
				}else{
					if (temp.getLeftChild()!=null && temp.getRightChild()!=null){
						// el nodo a eliminar tiene dos hijos
						anterior=temp;
						auxiliar=temp.getLeftChild(); // tomo hijo izq del nodo a eliminar
						// y busco el mayor de los menores
						while (auxiliar.getRightChild()!=null){
							anterior=auxiliar;
							auxiliar=auxiliar.getRightChild();
						}
						temp.setNodoInfo(auxiliar.getNodoInfo());
						// el nodo a eliminar ahora toma el valor del mayor de los menores
						if (anterior==temp){
							anterior.setLeftChild(auxiliar.getLeftChild());
							// el nuevo hijo izq del nodo eliminado es su nieto izq
						}else{
							// el nuevo hijo derecho del padre del nodo "eliminado" es su nieto izq.
							anterior.setRightChild(auxiliar.getLeftChild());
						}				
						
					}else{
						// el nodo a eliminar tiene un hijo der
						if (temp.getRightChild()!=null){
							if (anterior==null){
								// nodo raiz con hijo der
								this.root=temp.getRightChild();
							}else{
								if (anterior.getRightChild()==temp){
									anterior.setRightChild(temp.getRightChild());
								}else{
									anterior.setLeftChild(temp.getRightChild());
								}
							}
						}else{
							if (anterior==null){
								// nodo raiz con hijo izq
								this.root=temp.getLeftChild();
							}else{
								if (anterior.getRightChild()==temp){
									anterior.setRightChild(temp.getLeftChild());
								}else{
									anterior.setLeftChild(temp.getLeftChild());
								}
							}
						}
					}
				}				
	
			}else{
				System.out.println("Error sacar. No esta elemento..");
			}
		}else{
			System.out.println("Error sacar. arbol vacio...");
		}
		
	}
	public void sacar(Object nodoInfo) {
	    if (estaVacio()) {
	        System.out.println("Error sacar. Árbol vacío...");
	        return;
	    }

	    if (!esta(nodoInfo)) {
	        System.out.println("Error sacar. No está el elemento...");
	        return;
	    }

	    NodoArbolBinario anterior = null;
	    NodoArbolBinario temp = this.root;

	    // Buscar nodo a eliminar
	    while (temp != null && !iguales(temp.getNodoInfo(), nodoInfo)) {
	        anterior = temp;
	        if (mayor(temp.getNodoInfo(), nodoInfo)) {
	            temp = temp.getLeftChild();
	        } else {
	            temp = temp.getRightChild();
	        }
	    }

	    // === Caso 1: nodo hoja ===
	    if (temp.getLeftChild() == null && temp.getRightChild() == null) {
	        if (anterior == null) { // era la raíz
	            limpiar();
	        } else if (anterior.getLeftChild() == temp) {
	            anterior.setLeftChild(null);
	        } else {
	            anterior.setRightChild(null);
	        }
	        return;
	    }

	    // === Caso 2: nodo con dos hijos ===
	    if (temp.getLeftChild() != null && temp.getRightChild() != null) {
	        NodoArbolBinario auxiliar = temp.getLeftChild();
	        NodoArbolBinario padreAux = temp;

	        while (auxiliar.getRightChild() != null) {
	            padreAux = auxiliar;
	            auxiliar = auxiliar.getRightChild();
	        }

	        // Copiamos el valor del predecesor
	        temp.setNodoInfo(auxiliar.getNodoInfo());

	        // Reajustamos el enlace del padre del predecesor
	        if (padreAux == temp) {
	            padreAux.setLeftChild(auxiliar.getLeftChild());
	        } else {
	            padreAux.setRightChild(auxiliar.getLeftChild());
	        }
	        return;
	    }

	    // === Caso 3: nodo con un hijo (izq o der) ===
	    NodoArbolBinario hijo = (temp.getLeftChild() != null) ? temp.getLeftChild() : temp.getRightChild();

	    if (anterior == null) {
	        // caso raíz con un solo hijo
	        this.root = hijo;
	    } else if (anterior.getLeftChild() == temp) {
	        anterior.setLeftChild(hijo);
	    } else {
	        anterior.setRightChild(hijo);
	    }
	}
	
}
