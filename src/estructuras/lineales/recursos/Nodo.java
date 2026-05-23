package estructuras.lineales.recursos;

public class Nodo {
	private Object nodoInfo;
	private Nodo nextNodo;
	
	
	
	public Nodo(Object nodoInfo) {
		super();
		this.nodoInfo = nodoInfo;
		this.nextNodo = null;
	}
	
	
	public Nodo(Object nodoInfo, Nodo nextNodo) {
		super();
		this.nodoInfo = nodoInfo;
		this.nextNodo = nextNodo;
	}
	public Object getNodoInfo() {
		return nodoInfo;
	}
	public void setNodoInfo(Object nodoInfo) {
		this.nodoInfo = nodoInfo;
	}
	public Nodo getNextNodo() {
		return nextNodo;
	}
	public void setNextNodo(Nodo nextNodo) {
		this.nextNodo = nextNodo;
	}
	
}
