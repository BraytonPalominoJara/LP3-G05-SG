package Actividades;

public class Actividad_03 {
	    public static void main(String[] args) throws Exception {
	        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	        System.out.println("Imprimir subarray:");
	        imprimirArray(intArray, 4, 8);
	    }

	    public static <T> void imprimirArray(T[] inputArray, int limiteInferior, int limiteSuperior) throws LimiteInvalidoException {
	        if (limiteInferior < 0 || limiteSuperior >= inputArray.length || limiteInferior > limiteSuperior) {
	            throw new LimiteInvalidoException("Límites inválidos");
	        }

	        for (int i = limiteInferior; i <= limiteSuperior; i++) {
	            System.out.printf("%s ", inputArray[i]);
	        }
	        System.out.println("\nNúmero de elementos en el rango: " + (limiteSuperior - limiteInferior + 1));
	    }
	}

 class LimiteInvalidoException extends Exception {

	public LimiteInvalidoException(String mensaje) {
        super(mensaje);
    }
}


