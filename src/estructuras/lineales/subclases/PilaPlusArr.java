package estructuras.lineales.subclases;


import estructuras.lineales.contenedores.PilaArr;

public class PilaPlusArr extends PilaArr {

	public PilaPlusArr(int tamPila) {
		super(tamPila);
	}

	
	public Object topePila() {
		if(estaVacia()) {
			System.out.println("Error : pila vacía");
			return null;
		}
		return this.pila[this.cabeza];
	}

}
