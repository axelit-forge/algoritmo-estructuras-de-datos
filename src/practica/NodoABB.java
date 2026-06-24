package practica;


public class NodoABB {
    private Object infoABB;
    private NodoABB Left;
    private NodoABB Right;

    public NodoABB(){
        this.infoABB = null;
        this.Left = null;
        this.Right = null;
    }

    public NodoABB(Object dato){
        this(dato, null, null);
    }

    public NodoABB(Object info, NodoABB left, NodoABB right){
        this.infoABB = info;
        this.Left = left;
        this.Right = right;
    }

    //setters y getters
    public Object getInfoABB() {
        return infoABB;
    }

    public void setInfoABB(Object infoABB) {
        this.infoABB = infoABB;
    }

    public NodoABB getLeft() {
        return Left;
    }

    public void setLeft(NodoABB left) {
        Left = left;
    }

    public NodoABB getRight() {
        return Right;
    }

    public void setRight(NodoABB right) {
        Right = right;
    }
}
