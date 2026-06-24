package practica;

public abstract class ArbolBusquedaBinario implements IArbol{
    protected NodoABB root;

    public abstract void imprimir(Object nodoInfo);
    public abstract boolean iguales(Object nodoA, Object nodoB);
    public abstract boolean menor(Object nodoA, Object nodoB);
    public abstract boolean mayor(Object nodoA, Object nodoB);


    public NodoABB meterRecursivo(NodoABB actual, Object elemento){
        if (actual == null)
            return new NodoABB(elemento);

        if (menor (elemento, actual.getInfoABB())){
            actual.setLeft(meterRecursivo(actual.getLeft(), elemento));
        }
        else
            if (mayor (elemento, actual.getInfoABB())){
                actual.setRight(meterRecursivo(actual.getRight(), elemento));
            }
        // caso que sean iguales
        return actual;
    }

    public void meter(Object nodoInfo) {
        this.root = meterRecursivo(this.root, nodoInfo);
    }


    private Object encontrarMaximo(NodoABB actual) {
        while (actual.getRight() != null) {
            actual = actual.getRight();
        }
        return actual.getInfoABB();
    }

    public NodoABB sacarRecursivo(NodoABB actual, Object elemento){
        if(actual == null)
            return null;

        if (menor (elemento,actual.getInfoABB())){
            actual.setLeft(sacarRecursivo(actual.getLeft(), elemento));
        }
        else
            if (mayor (elemento, actual.getInfoABB())){
              actual.setRight(sacarRecursivo(actual.getRight(), elemento));
            }
            else{
                // ¡Encontramos el nodo a eliminar!

                // Caso 1 y 2: Hoja o un solo hijo
                if (actual.getLeft() == null) {
                    return actual.getRight();
                } else if (actual.getRight() == null) {
                    return actual.getLeft();
                }

                // Caso 3: El nodo tiene DOS hijos
                Object sucesorInfo = encontrarMaximo(actual.getLeft());

                actual.setInfoABB(sucesorInfo);
                actual.setLeft(sacarRecursivo(actual.getLeft(), sucesorInfo));
            }
        return actual;
    }

    public void sacar(Object nodoInfo) {
        this.root = sacarRecursivo(this.root, nodoInfo);
    }

    public void sacarIterativo(Object elemento) {
        if (this.root == null) return;

        NodoABB padre = null;
        NodoABB actual = this.root;

        // 1. BUSCADOR CHATO: Encontramos el nodo y su padre en un solo while corto
        while (actual != null && !iguales(actual.getInfoABB(), elemento)) {
            padre = actual;
            if (menor(elemento, actual.getInfoABB())) {
                actual = actual.getLeft();
            } else {
                actual = actual.getRight();
            }
        }

        // Si no se encontró el elemento, nos vamos inmediatamente
        if (actual == null) return;

        // 2. CASO 3 PRIMERO: Si tiene dos hijos, reducimos el problema a caso 1 o 2
        if (actual.getLeft() != null && actual.getRight() != null) {
            // Buscamos el reemplazo (mínimo del subárbol derecho)
            NodoABB padreSucesor = actual;
            NodoABB sucesor = actual.getLeft();

            while (sucesor.getRight() != null) {
                padreSucesor = sucesor;
                sucesor = sucesor.getRight();
            }

            // Copiamos la info del sucesor al nodo que queríamos borrar
            actual.setInfoABB(sucesor.getInfoABB());

            // ¡Magia! Ahora nuestro "actual" a eliminar físicamente es el sucesor
            // y su padre es "padreSucesor"
            actual = sucesor;
            padre = padreSucesor;
        }

        // 3. CASOS 1 y 2 UNIFICADOS: A esta altura, "actual" seguro tiene 0 o 1 hijo
        NodoABB hijoSustituto = (actual.getLeft() != null) ? actual.getLeft() : actual.getRight();

        // Reenganchamos con el padre
        if (padre == null) {
            this.root = hijoSustituto; // Estábamos borrando la raíz
        } else if (padre.getLeft() == actual) {
            padre.setLeft(hijoSustituto);
        } else {
            padre.setRight(hijoSustituto);
        }
    }

    private NodoABB busquedaRecursiva(NodoABB nodo, Object buscado){
        if (nodo == null)
            return null;

        if(iguales (nodo.getInfoABB(), buscado))
            return nodo;

        if (menor(buscado, nodo.getInfoABB()))
            return busquedaRecursiva(nodo.getLeft(), buscado);
        else
            return busquedaRecursiva(nodo.getRight(), buscado);
    }


    public boolean esta(Object nodoInfo) {
       return busquedaRecursiva (this.root, nodoInfo) != null;
    }




    public void limpiar() {
        this.root = null;
    }

    public boolean estaVacio() {
        return this.root == null;
    }


    public Object devuelve(Object nodoInfo) {
        NodoABB encontrado = busquedaRecursiva(this.root, nodoInfo);
        if (encontrado != null)
            return encontrado.getInfoABB();
        else
            return null;
    }

    private void InOrder (NodoABB actual){
        if (actual != null){
            InOrder (actual.getLeft());
            imprimir(actual.getInfoABB());
            InOrder (actual.getRight());
        }
    }
    public void muestraInOrder() {
        InOrder(this.root);
    }

    private void  PreOrder(NodoABB actual){
        if (actual != null){
            imprimir(actual.getInfoABB());
            PreOrder(actual.getLeft());
            PreOrder(actual.getRight());
        }
    }
    public void muestraPreOrder() {
        PreOrder(this.root);
    }

    private void PostOrder(NodoABB actual){
        if (actual != null){
            PostOrder(actual.getLeft());
            PostOrder(actual.getRight());
            imprimir(actual.getInfoABB());
        }
    }
    public void muestraPostOrder() {
        PostOrder(this.root);
    }



    public int cantHojas(NodoABB nodo) {
        if (nodo == null)
            return 0;

        if (nodo.getLeft() == null && nodo.getRight() == null)
            return 1;
        else
            return cantHojas(nodo.getLeft()) + cantHojas(nodo.getRight());
    }
    public int hojasArbol(){
        return cantHojas(this.root);
    }

    public int alturaArbol(NodoABB nodo) {
        int alturaIzq, alturaDer;

        if(nodo==null)
            return -1;

        alturaIzq = alturaArbol(nodo.getLeft());
        alturaDer = alturaArbol(nodo.getRight());

        if(alturaIzq>alturaDer)
            return alturaIzq + 1;
        else
            return alturaDer + 1;
    }

    public int altura(){
        return alturaArbol(this.root);
    }


    public int cantNodos(NodoABB nodo){
        if (nodo==null)
            return 0;
        else
            return 1 + cantNodos(nodo.getLeft()) + cantNodos(nodo.getRight());

    }

    public int cuentaNodos(){
        return cantNodos(this.root);
    }


    private NodoABB sacarParcial(NodoABB actual, Object N){
        if (actual == null)
            return null;

        if(menor(actual.getInfoABB(), N)){
            return sacarParcial(actual.getRight(), N);
        }
        else{
            actual.setLeft(sacarParcial(actual.getLeft(), N));
            return actual;
        }
    }


    public void parcial(Object N){
        this.root = sacarParcial (this.root, N);
    }
}
