package estructuras.lineales.contenedores;

public abstract class ColaPrioridad extends Lista2DLinkedList {

	public ColaPrioridad() {
        super();
    }

    public void encolar(Object elemento) {
        this.insertar(elemento); 
    }

    public Object desencolar() {
        if (estaVacia()) {
            System.out.println("Error : Cola vacía");
            return null;
        }

        Object frente = devolver(0);
        eliminar(0);
        return frente;
    }

    public Object frente() {
        if (estaVacia()) {
            System.out.println("Error : Cola vacía");
            return null;
        }

        return devolver(0);
    }

    public abstract boolean iguales(Object a, Object b);
    public abstract boolean esMayor(Object a, Object b);
    public abstract boolean esMenor(Object a, Object b);

}