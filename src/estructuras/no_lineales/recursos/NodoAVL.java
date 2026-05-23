package estructuras.no_lineales.recursos;

public class NodoAVL {

	private Object nodoInfo;
	private NodoAVL leftChild, rightChild;
	public int altura;

	public NodoAVL() {
		setNodoInfo(null);
		setLeftChild(null);
		setRightChild(null);
		setHeight(0);
	}

	public NodoAVL(Object nodoInfo) {
		this(nodoInfo, null, null);
	}

	public NodoAVL(Object nodoInfo, NodoAVL leftChild, NodoAVL rightChild) {
		setNodoInfo(nodoInfo);
		setLeftChild(leftChild);
		setRightChild(rightChild);
	}

	public void setNodoInfo(Object nodoInfo) {
		this.nodoInfo = nodoInfo;
	}

	public Object getNodoInfo() {
		return this.nodoInfo;
	}

	public void setLeftChild(NodoAVL leftChild) {
		this.leftChild = leftChild;
	}

	public void setRightChild(NodoAVL rightChild) {
		this.rightChild = rightChild;
	}

	public NodoAVL getLeftChild() {
		return this.leftChild;
	}

	public NodoAVL getRightChild() {
		return this.rightChild;
	}

	public int getHeight() {
		return altura;
	}

	public void setHeight(int altura) {
		this.altura = altura;
	}

}
