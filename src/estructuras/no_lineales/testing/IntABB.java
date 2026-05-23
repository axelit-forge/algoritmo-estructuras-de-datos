package estructuras.no_lineales.testing;


import estructuras.no_lineales.contenedores.ABB;

public class IntABB extends ABB {
	
	public boolean iguales(Object nodoA, Object nodoB){
		boolean response=false;
		if (((Integer)nodoA).intValue()==((Integer)nodoB).intValue()){
			response=true;
		}		
		return response;
	}
	
	public boolean menor(Object nodoA, Object nodoB){
		boolean response=false;
		if (((Integer)nodoA).intValue()<((Integer)nodoB).intValue()){
			response=true;
		}
		return response;
	}
	
	public boolean mayor(Object nodoA, Object nodoB){
		boolean response=false;
		if (((Integer)nodoA).intValue()>((Integer)nodoB).intValue()){
			response=true;
		}
		return response;		
	}
	
	public void imprimir(Object nodo){
		System.out.println("Nodo " + nodo.toString());	
	}	
}
