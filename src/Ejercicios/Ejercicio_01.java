package Ejercicios;

public class Ejercicio_01 {
    public static void main(String[] args) throws Exception {
        String[] stringArray = {"Uno", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Ocho"};

        System.out.println("Array de cadenas contiene:");
        imprimirArray(stringArray);

        System.out.println("\nArray de cadenas en formato tabular ordenado:");
        imprimirArrayTabular(stringArray);
    }

    public static <T> void imprimirArray(T[] inputArray) {
        for (T elemento : inputArray)
            System.out.printf("%s ", elemento);
        System.out.println();
    }

    // Método no genérico específico para imprimir array de tipo String en formato tabular ordenado
    public static void imprimirArrayTabular(String[] stringArray) {
        int columnas = 4; // Número de columnas en el formato tabular
        int elementosPorColumna = stringArray.length / columnas;

        for (int i = 0; i < elementosPorColumna; i++) {
            for (int j = 0; j < columnas; j++) {
                int indice = i + j * elementosPorColumna;
                System.out.printf("%-10s", stringArray[indice]);
            }
            System.out.println();
        }
    }
}
