package utilidades_matdiscr;

public class Congruencia {
	private final int modulo;
	
	public Congruencia (int modulo) {
		if (modulo <= 0)
	            throw new IllegalArgumentException("El módulo debe ser positivo");
		this.modulo = modulo;
	}
	public int toCongruencia(int a) {
	    return Numero.resto(a, modulo); 
	}
	public int suma(int a, int b) {
	    return toCongruencia(a + b);
	}
	public int resta(int a, int b) {
	    return toCongruencia(a - b );
	}
	public int producto(int a, int b) {
	    return toCongruencia(a * b);
	}
	public int inversoProd(int a) {
		if(Numero.mcd(a, modulo) != 1)
			throw new ArithmeticException("No existe inverso");
		
		ParOrdenado ST = Numero.calculoST(a, modulo);
		
		return toCongruencia(ST.getX());
	}
	public int ecuacionCongruenteInv (int a, int b) {
		if(Numero.mcd(a, modulo) != 1)
			throw new ArithmeticException("No existe solucion unica");
		
		int inv= inversoProd(a);
		
		return producto(inv, b);
	}
	public int[] ecuacionCongruenteCuse (int a, int b) {
		
		int C= Numero.mcd(Numero.mcd(a, b), modulo);
		
		if(C == 0 || Numero.mcd(a, modulo) != C)
			throw new ArithmeticException("No existe solucion");
		
		int tempA = Numero.cociente(a, C);
		int tempB = Numero.cociente(b, C);
		int tempC = Numero.cociente(modulo, C);
		
		Congruencia ModTemp = new Congruencia(tempC);
		
		int sol = ModTemp.ecuacionCongruenteInv(tempA, tempB);
		
		int [] CS = new int[C];
		for(int i=0; i<C ; i++) {
			CS[i]= toCongruencia(sol + i * tempC);
		}
		return CS;
	}
	public int teoremaChino(ParOrdenado[] ecuaciones) {
		int M = 1;
		
		for(ParOrdenado Ec : ecuaciones) 
			M = M* Ec.getY() ;
		
		int X=0;
		for(ParOrdenado Ec : ecuaciones) {
			int Mk= Numero.cociente(M, Ec.getY());
			Congruencia Temp = new Congruencia (Ec.getY());
			int inv = Temp.inversoProd(Temp.toCongruencia(Mk));
		    X += Mk * Ec.getX() * inv;
		}
		
		return Numero.resto(X,M);
	}
	
	public int getM() {
		return modulo;
	}
	
	public String toString() {
	    return "Congruencia módulo " + modulo;
	}
	
}
