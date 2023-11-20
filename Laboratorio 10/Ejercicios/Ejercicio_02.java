package Ejercicios;

public class Ejercicio_02 {
    public static void main(String[] args) throws Exception {
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] stringArray = {"Uno", "Dos", "Tres", "Cuatro", "Cinco"};

        System.out.println("Array original de enteros:");
        imprimirArray(intArray);

        intercambiarElementos(intArray, 1, 3);

        System.out.println("\nArray después de intercambio:");
        imprimirArray(intArray);

        System.out.println("\nArray original de cadenas:");
        imprimirArray(stringArray);

        intercambiarElementos(stringArray, 0, 4);

        System.out.println("\nArray después de intercambio:");
        imprimirArray(stringArray);
    }

    public static <T> void intercambiarElementos(T[] inputArray, int indice1, int indice2) {
        if (indice1 < 0 || indice1 >= inputArray.length || indice2 < 0 || indice2 >= inputArray.length || indice1 == indice2) {
            System.out.println("Índices inválidos o iguales. No se realizó el intercambio.");
            return;
        }

        T temp = inputArray[indice1];
        inputArray[indice1] = inputArray[indice2];
        inputArray[indice2] = temp;
    }

    public static <T> void imprimirArray(T[] inputArray) {
        for (T elemento : inputArray)
            System.out.printf("%s ", elemento);
        System.out.println();
    }
}

