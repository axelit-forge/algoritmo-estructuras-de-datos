package estructuras.lineales.contenedores;

public class ColaPlusSLinkedList extends ColaSLinkedList {

    public ColaPlusSLinkedList() {
        super(); 
    }

    public int cardinal() {
        ColaPlusSLinkedList aux = new ColaPlusSLinkedList();
        int contador = 0;

        while (!this.estaVacia()) {
            Object elem = this.sacar();
            aux.meter(elem);
            contador++;
        }

        while (!aux.estaVacia())
            this.meter(aux.sacar());

        return contador;
    }

    public void invertir() {
        PilaSLinkedList pila = new PilaSLinkedList();

        while (!this.estaVacia())
            pila.meter(this.sacar());

        while (!pila.estaVacia())
            this.meter(pila.sacar());
    }

    public void concatenar(ColaSLinkedList c2) {
        ColaPlusSLinkedList aux = new ColaPlusSLinkedList();
        ColaPlusSLinkedList aux2 = new ColaPlusSLinkedList(); 

        while (!this.estaVacia())
            aux.meter(this.sacar());

        while (!c2.estaVacia()) {
            Object elem = c2.sacar();
            aux.meter(elem);
            aux2.meter(elem); 
        }

        while (!aux2.estaVacia())
            c2.meter(aux2.sacar()); 

        while (!aux.estaVacia())
            this.meter(aux.sacar());
    }
}
