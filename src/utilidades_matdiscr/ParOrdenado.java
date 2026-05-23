package utilidades_matdiscr;

public class ParOrdenado {
    private int x;
    private int y;
    
    // Constructor principal
    public ParOrdenado(int x, int y) {
        this.x = x;
        this.y = y;
    }
     
    // Getters directos
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    public void setX(int valor) {
    	this.x= valor;
    }
    public void setY(int valor) {
    	this.y= valor;
    }
    
    public String toString(){
        return ("("+x+","+y+")");
    }
}