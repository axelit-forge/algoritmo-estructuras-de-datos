package utilidades_matdiscr;


public class Main {
    public static void main(String[] args) {
    	Congruencia congruencia = new Congruencia(1); 
        
        // Correcta inicialización del array
        ParOrdenado[] ecuaciones = {
            new ParOrdenado(2, 3),  
            new ParOrdenado(3, 5),  
            new ParOrdenado(2, 7)  
        };
        
        try {
            int resultado = congruencia.teoremaChino(ecuaciones);
            System.out.println("La solución es: x ≡ " + resultado + " mod " + 
                             (5*7*11)); // M = 5*7*11 = 385
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Error matemático: " + e.getMessage());
        }
    }
}