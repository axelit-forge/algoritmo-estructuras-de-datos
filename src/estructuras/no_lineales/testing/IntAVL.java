package estructuras.no_lineales.testing;


import estructuras.no_lineales.contenedores.ArbolAVL;

public class IntAVL extends ArbolAVL {

	public boolean mayor(Object nodoA, Object nodoB) {
		return ((Integer)nodoA).intValue() > ((Integer)nodoB).intValue();
	}

	public boolean menor(Object nodoA, Object nodoB) {
		return ((Integer)nodoA).intValue() < ((Integer)nodoB).intValue();
	}

	public boolean iguales(Object nodoA, Object nodoB) {
		return ((Integer)nodoA).intValue() == ((Integer)nodoB).intValue();
	}

	public void imprimir(Object nodoInfo) {
		System.out.println("Nodo " + nodoInfo.toString());	
	}

}
