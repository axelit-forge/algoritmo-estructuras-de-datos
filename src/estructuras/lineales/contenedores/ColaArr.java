package estructuras.lineales.contenedores;

import interfaces.OperacionesCL1;

public class ColaArr implements OperacionesCL1{

	private Object [] cola;
	protected int frenteC;
	protected int finalC;
	protected int tamCola;
	
	public ColaArr(int tamCola) {
		this.tamCola = tamCola + 1;
		this.cola = new Object[this.tamCola];
		limpiar();
	}
	
	
	public void meter(Object elemento) {
		if (!estaLlena()) {
			
			incrementaFinal(); 
			this.cola[this.finalC] = elemento;
			
		} else {
				System.out.println("Error. Cola llena...");
			}
	}

	
	public Object sacar() {
		Object elemento = null;
		
		if(! estaVacia()) {
			
			incrementaFrente();
			elemento = cola[this.frenteC];
			
		}
		else
			System.out.println("Error: la cola está vacía");
			
		return elemento;
	}

	
	public boolean estaVacia() {
		return (this.finalC == this.frenteC);
	}

	public boolean estaLlena() {
		int p;
		
		if(this.finalC == this.tamCola - 1) {
			p = 0;
		}
		else
			p= this.finalC + 1;
		
		return (p == this.frenteC);
	}
	
	public void limpiar() {
		this.finalC = this.frenteC = tamCola - 1;
	}
	
	private void incrementaFinal() {
		if(this.finalC == tamCola - 1)
			this.finalC = 0;
		else
			this.finalC++;
	}
	
	private void incrementaFrente() {
		if(this.frenteC == tamCola - 1)
			this.frenteC = 0;
		else
			this.frenteC++;
	}

}
