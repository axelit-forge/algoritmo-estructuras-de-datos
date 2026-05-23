package estructuras.no_lineales.contenedores;


import estructuras.no_lineales.recursos.NodoAVL;

public abstract class ArbolAVL {
	protected NodoAVL root;

	public abstract boolean mayor(Object nodoA, Object nodoB);
	public abstract boolean menor(Object nodoA, Object nodoB);
	public abstract boolean iguales(Object nodoA, Object nodoB);

	public abstract void imprimir(Object nodoInfo);

	public void meterAVL(Object nodoInfo) {
		System.out.println("intentando meter " + nodoInfo.toString());
		this.root = meterR(this.root, nodoInfo);
	}

	public boolean estaVacio() {
		return this.root == null;
	}

	public void muestraInOrder() {
		if (estaVacio()) {
			System.out.println("Arbol AVL vacio");
		} else {
			inOrder(this.root);
		}
	}

	private void inOrder(NodoAVL nodo) {
		if (nodo != null) {
			inOrder(nodo.getLeftChild());
			imprimir(nodo.getNodoInfo());
			inOrder(nodo.getRightChild());
		}
	}

	public void muestraPreOrder() {
		if (estaVacio()) {
			System.out.println("Arbol AVL vacio");
		} else {
			preOrder(this.root);
		}
	}

	private void preOrder(NodoAVL nodo) {
		if (nodo != null) {
			imprimir(nodo.getNodoInfo());
			preOrder(nodo.getLeftChild());
			preOrder(nodo.getRightChild());
		}
	}

	private NodoAVL meterR(NodoAVL nodo, Object nodoInfo) {
		int b, izq, der;
		if (nodo == null) {
			nodo = new NodoAVL(nodoInfo);
		} else {
			
			if (!iguales(nodo.getNodoInfo(), nodoInfo)) {
				if (mayor(nodo.getNodoInfo(), nodoInfo)) {
					nodo.setLeftChild(meterR(nodo.getLeftChild(), nodoInfo));
				} else {
					// es menor
					nodo.setRightChild(meterR(nodo.getRightChild(), nodoInfo));
				}
				nodo = balancear(nodo);
				
				izq = height(nodo.getLeftChild());
				der = height(nodo.getRightChild());

				b = max(izq, der) + 1;
				nodo.setHeight(b);
			}
		}
		return nodo;
	}

	public NodoAVL balancear(NodoAVL nodo) {

		if (height(nodo.getLeftChild()) - height(nodo.getRightChild()) == 2) {
			System.out.println("hay desequilibrio a izquierda >");
			// desequilibrio a izquierda, puede ser simple o doble

			if (height(nodo.getLeftChild().getLeftChild()) > height(nodo.getLeftChild().getRightChild())) {
				System.out.println("-> Rot. Simple a Derecha");
				return rotacionSimple(nodo, false);
			} else {
				System.out.println("-> Rot. Doble a Derecha");
				return rotacionDoble(nodo, false);
			}
		} else {
			if (height(nodo.getRightChild()) - height(nodo.getLeftChild()) == 2) {
				System.out.println("hay desequilibrio a derecha >");
				// desequilibrio a derecha
				if (height(nodo.getRightChild().getRightChild()) > height(nodo.getRightChild().getLeftChild())) {
					System.out.println("> Rot. Simple a izquierda");
					return rotacionSimple(nodo, true);

				} else {
					System.out.println("> Rot. Doble a izquierda");
					return rotacionDoble(nodo, true);
				}
			} else {
				return nodo;
			}
		}

	}

	public NodoAVL rotacionSimple(NodoAVL nodo, boolean esAIzquierda) {
		NodoAVL temp;
		if (esAIzquierda) {
			temp = nodo.getRightChild();
			nodo.setRightChild(temp.getLeftChild());
			temp.setLeftChild(nodo);

			nodo.setHeight(max(height(nodo.getLeftChild()),
					height(nodo.getRightChild())) + 1);
			temp.setHeight(max(height(temp.getRightChild()), nodo.getHeight()) + 1);

		} else {
			temp = nodo.getLeftChild();
			nodo.setLeftChild(temp.getRightChild());
			temp.setRightChild(nodo);

			nodo.setHeight(max(height(nodo.getLeftChild()),
					height(nodo.getRightChild())) + 1);
			temp.setHeight(max(height(temp.getLeftChild()), nodo.getHeight()) + 1);

		}

		return temp;
	}

	public NodoAVL rotacionDoble(NodoAVL nodo, boolean esAIzquierda) {
		if (esAIzquierda) {
			// rotacion simple a derecha sobre el hijo derecho del nodo
			// desequilibrado
			// rotacion simple a izquierda sobre el nodo desequilibrado
			nodo.setRightChild(rotacionSimple(nodo.getRightChild(), false));
			return rotacionSimple(nodo, true);

		} else {
			// rotacion simple a izquierda sobre el hijo izquierdo del nodo
			// desequilibrado
			// ahora rotacion simple a derecha sobre el nodo desequilibrado
			nodo.setLeftChild(rotacionSimple(nodo.getLeftChild(), true));
			return rotacionSimple(nodo, false);

		}
	}

	private static int height(NodoAVL nodo) {
		if (nodo == null) {
			return -1;
		} else {
			return nodo.getHeight();
		}
	}

	private static int max(int a, int b) {
		if (a > b) {
			return a;
		} else {
			return b;
		}
	}

}
