package estructuras.lineales.subclases;


import estructuras.lineales.contenedores.PilaSLinkedList;

public class PilaPlusLinked extends PilaSLinkedList {
	
	public Object topePila() {
		
		if(estaVacia()) {
			System.out.println("Error : Pila vacía");
			return null;
		}
		return pila.getNodoInfo();
	}

}
