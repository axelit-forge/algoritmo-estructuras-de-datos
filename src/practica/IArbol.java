package practica;

public interface IArbol {

    public void meter(Object nodoInfo);
    public void sacar(Object nodoInfo);
    public boolean esta(Object nodoInfo);

    public void limpiar();
    public boolean estaVacio();

    public Object devuelve(Object nodoInfo);

    public void muestraInOrder();
    public void muestraPreOrder();
    public void muestraPostOrder();

    public int cantHojas();
    public int alturaArbol();
    //faltan operaciones...
}

