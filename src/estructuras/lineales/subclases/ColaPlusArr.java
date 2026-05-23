package estructuras.lineales.subclases;


import estructuras.lineales.contenedores.ColaArr;
import estructuras.lineales.contenedores.PilaArr;

public class ColaPlusArr extends ColaArr {
	
	public ColaPlusArr(int tamCola) {
		super(tamCola);
	}

	public int cardinal() {
        ColaPlusArr aux = new ColaPlusArr(100);  
        int contador = 0;

        while (! estaVacia()) {
            Object elem = sacar();
            aux.meter(elem);
            contador++;
        }

        while (!aux.estaVacia())
            meter(aux.sacar());

        return contador;
    }

    public void invertir() {
    	
        PilaArr pila = new PilaArr(100);
            pila.meter(sacar());
        
        while (!pila.estaVacia()) 
            meter(pila.sacar());
        
    }

    public void concatenar(ColaArr c2) {
        ColaArr aux = new ColaArr(100);
        ColaArr aux2 = new ColaArr(100);

        while (! estaVacia())
            aux.meter(sacar());

        while (!c2.estaVacia()) {
            Object elem = c2.sacar();
            aux.meter(elem);
            aux2.meter(elem); 
        }
        
        while (!aux2.estaVacia())
            c2.meter(aux2.sacar()); 

        while (!aux.estaVacia())
            meter(aux.sacar());
    }
}