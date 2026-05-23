package utilidades_matdiscr;

import java.math.BigInteger;

public class Numero {
    // Métodos básicos
    public static int sumar(int a, int b) {
        return a + b;
    }
    
    public static int restar(int a, int b) {
        return a - b;
    }
    
    public static int multiplicar(int a, int b) {
        return a * b;
    }
    
    // División con cociente y resto
    public static int cocienteNatural(int dividendo, int divisor) {
    	if (divisor==0) {
			System.out.println("División por cero no permitida");
			return -1;
		}
    	 int cociente = 0;
    	    int acumulado = dividendo; 
    	    
    	    while (acumulado >= divisor) {
    	        acumulado -= divisor; 
    	        cociente++;
    	    }
    	    return cociente;
    }
    
    public static int restoNatural(int dividendo, int divisor) {
    	if (divisor==0) {
			System.out.println("División por cero no permitida");
			return -1;
		}
    	
    	while (dividendo >= divisor) {
            dividendo -= divisor;
        }
        return dividendo; 
    }
    
    public static ParOrdenado cocienteYResto(int dividendo, int divisor) {
 
        if (divisor== 0) 
            throw new ArithmeticException("División por cero no permitida");

        // Caso base: ambos positivos
        if (dividendo >0 && divisor >0 ) {
            int cociente = cocienteNatural(dividendo, divisor);
            int resto = restoNatural(dividendo, divisor);
            return new ParOrdenado(cociente, resto);
        }

        // Manejo de signos
        if (divisor<0) {
            ParOrdenado resultado = cocienteYResto(dividendo, -divisor);
            return new ParOrdenado(-resultado.getX(), resultado.getY());
        }
        
        // Cuando el dividendo es negativo
        if (dividendo<0) {
            ParOrdenado resultado = cocienteYResto(-dividendo, divisor);
            if (resultado.getY()== 0) {
                return new ParOrdenado(-resultado.getX(), 0);
            } else {
                int nuevoCociente = -resultado.getX() - 1;
                int nuevoResto = divisor - resultado.getY();
                return new ParOrdenado(nuevoCociente, nuevoResto);
            }
        }
        
        return new ParOrdenado(0,0);	
    }
    
    public static int cociente(int dividendo, int divisor) {
    	ParOrdenado Rdo = cocienteYResto(dividendo, divisor);
    	
    	return Rdo.getX();
    }
    public static int resto(int dividendo, int divisor) {
    	ParOrdenado Rdo = cocienteYResto(dividendo, divisor);
    	
    	return Rdo.getY();
    }
    
 // Métodos numéricos avanzados
    public static boolean esPrimo(int numero) {
    	int n = Math.abs(numero);
    	
        if (n <= 1) return false;
        if (n == 2) return true;
        if (resto(n, 2) == 0) return false;
        
        for (int i = 3; multiplicar(i,i) <= n; i += 2) {
            if (resto(n, i) == 0) return false;
        }
        return true;
    }
    
    public static int factorial(int n) {
        if (n < 0) throw new IllegalArgumentException();
        int f= 1;
        
        for(int i =2; i<=n; i++)
        	f= multiplicar(f, i);
        return f;
    }
    
    // Criba de Eratóstenes
    public static int[] cribaIndices(int limite) {
        if (limite < 2) return new int[0];
               
        int [] Vector= new int [limite - 1] ;
    	
		for (int i=0; i < Vector.length; i++)
			Vector[i]= 1;
		
		int d= 2;
		
		while(d*d <= limite) {
			if(Vector[d-2]== 1) {
				for(int i=2; i<= cociente(limite, d);  i++) 
					Vector[d*i-2]= 0;
			}
			d++;
		}
		return Vector;
        
    }
    public static int [] cribaValores(int limite) {
    	int [] Vector = cribaIndices(limite);
    	
    	int cont=0;
		for(int i=0; i < Vector.length; i++) {
			if(Vector[i]==1)
				cont++;
		}
		
		int []Primos = new int [cont];
		int k=0;
		
		for(int i=0; i < Vector.length; i++) {
			if(Vector[i]==1)
				Primos[k++]= i+2;
		}
		return Primos;
    }
    public static int [] cribaIndices (int ini, int fin) {
		
		 if (ini > fin || fin < 2)
		        return new int[0]; 
		
		int[] T= new int [fin-ini+1] ;
		
		for(int i=0; i < T.length; i++)
			T[i]=1;
		
		int []Divisores = cribaValores((int)Math.sqrt(fin));
		
		int j = 0;
		while (j < Divisores.length) {
		    int p = Divisores[j];
		    int primerMultiplo = ((ini + p - 1) / p);
	        for (int i = primerMultiplo; i <= fin/p; i ++) {
	            int index= i*p;
	        	if (index >= ini && index!= Divisores[j]) 
	                T[index - ini] = 0; 
	        }
		    j++;
		}
		
		if(ini==1)
			T[0]=0;
			
		return T;
	}
    public static int [] cribaValores(int ini, int fin) {
    	int [] Vector = cribaIndices(ini, fin);
    	
    	int cont=0;
		for(int i=0; i < Vector.length; i++) {
			if(Vector[i]==1)
				cont++;
		}
		
		int []Primos = new int [cont];
		int k=0;
		
		for(int i=0; i < Vector.length; i++) {
			if(Vector[i]==1)
				Primos[k++]= i+ini;
		}
		return Primos;
    }
    
    // Números compuestos basados en factorial
    public static int[] nCompuestos(int cantidad) {
        int[] compuestos = new int[cantidad];
        int factorial = factorial(cantidad + 1);
        
        for (int i = 0; i < cantidad; i++) {
            compuestos[i] = i + 2 + factorial;
        }
        return compuestos;
    }
    
    
    //TP2 PORFIN mcd, mcm, st
    
    public static int mcd(int a, int b) {
    	a= Math.abs(a);
		b= Math.abs(b);
		
		if(a == 0 && b == 0)
			throw new  IllegalArgumentException(" No existe el multiplo comun divisor cuando a y b son 0");
		
		int aux;
		while( b!= 0) {
			aux = b;
			b= resto(a, b);
			a= aux;
		}
		
		return a;
    }
    public static int mcm(int a, int b) {
    	if (a == 0 || b == 0) return 0;
    	
    	int d = mcd(a,b);
    	
    	return cociente(a*b, d);
    }
    public static ParOrdenado calculoST(int a, int b) {
    	int r0=Math.abs(a); int r1=Math.abs(b);
    	int s0=1; int s1=0;
    	int t0=0; int t1=1;
    	while(r1 != 0) {
    		int c= cociente(r0, r1);
    		// Actualiza r
            int aux = r1;
            r1 = r0 - c * r1;
            r0 = aux;
            // Actualiza s
            aux = s1;
            s1 = s0 - c * s1;
            s0 = aux;
            // Actualiza t
            aux = t1;
            t1 = t0 - c * t1;
            t0 = aux;
    	}
    	if(a<0)
    		s0= s0*-1;

    	if(b<0)
    		t0= t0*-1;	
    	
    	return new ParOrdenado(s0, t0);
    }
    
    //parte2 divisores, factores y aritmetica
    public static ParOrdenado[] factores(int a) {
    	if (a == 0 || a == 1) 
            return new ParOrdenado[0];
    	
    	ParOrdenado[] factores = new ParOrdenado[(int) (Math.log(Math.abs(a)) / Math.log(2)) + 1];
    	
    	 int count = 0; 
    	 int divisor = 2;

   	    while (a != 1) {
  	        if (resto(a, divisor) == 0) {
   	            int exponente = 0;
   	            
    	        while (resto(a, divisor) == 0) {
    	           a = cociente(a, divisor);
    	           exponente++;
    	         }
    	       factores[count++] = new ParOrdenado(divisor, exponente);
    	    }
    	    divisor++;     
    	}
   	    factores[count++] = new ParOrdenado(-1, -1);

   	    return factores;
    }    
    public static int cantDivisores (int a) {
    	ParOrdenado[] factores = factores(a);
    	
    	int i=0;
    	int count=1;
    	
    	while(factores[i].getX() != -1) {
    		count = count  * (factores[i].getY()+1); 
    		i++;
    	}
    	return count;
    }
    public static int sumaDivisores (int a) {
    	ParOrdenado[] factores = factores(a);
    	
    	int i=0;
    	int count=1;
    	
    	while(factores[i].getX() != -1) {
    		int aux= (int) Math.pow(factores[i].getX(), factores[i].getY() + 1);
    		count = count  * (cociente(aux, factores[i].getX()-1)); 
    		i++;
    	}
    	return count;
    }
    public static BigInteger productoDivisores(int a) {
        if (a == 0) 
            return BigInteger.ZERO;
        
        int n = Math.abs(a);
        int cantidadDiv = cantDivisores(n);
        
        BigInteger base = BigInteger.valueOf(n);
        BigInteger exponente = BigInteger.valueOf(cantidadDiv / 2);
        
        return base.pow(exponente.intValue());
    }
    public static int [] divisores (int a) {
    	if (a == 0)
    	        return new int[0];
    	    
    	a = Math.abs(a);
    	ParOrdenado[] factores = factores(a);
    	    
    	if (a == 1)
    		return new int[]{1};
    	int totalDivisores = cantDivisores(a);
        int[] divisores = new int[totalDivisores];
        
        divisores[0] = 1;
        int count = 1;
        
        for (int i = 0; factores[i].getX() != -1; i++) {
            int p = factores[i].getX(); 
            int e = factores[i].getY(); 
            int currentCount = count;
            for (int j = 0; j < currentCount; j++) {
                int currentDivisor = divisores[j];
                for (int k = 1; k <= e; k++) {
                    currentDivisor *= p;
                    divisores[count++] = currentDivisor;
                }
            }
        }
        for(int i=0; i<totalDivisores; i++) {
        	for(int j=i+1; j<totalDivisores; j++) {
        		if(divisores[i]>divisores[j]) {
        			int aux = divisores[i];
        			divisores [i]=divisores[j];
        			divisores [j]=aux;
        		}
        	}
        }
        
        return divisores;
    }
        
    public static boolean coprimos (ParOrdenado A) {
    	int d = mcd (Math.abs(A.getX()), Math.abs(A.getY()));
    	if(d == 1) return true;
    	return false;
    }
    
    public static boolean coprimos (int a, int b) {
    	int d = mcd (Math.abs(a), Math.abs(b));
    	if(d == 1) return true;
    	return false;
    }
    
    public static boolean primosEntreSi(int [] vec){
    	for(int i=0; i<vec.length; i++) {
    		for(int j=i+1; j<vec.length; j++) {
    			
    			if(mcd(vec[i],vec[j]) != 1)
    				return false;
    		}
    	}
    	return true;
    }
    

}
