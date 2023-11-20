package Actividades;

public class Actividad_01 {
    public static void main(String[] args) throws Exception {
        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5};
        Character[] charArray = {'H', 'O', 'L', 'A'};
        Float[] floatArray = {(float)1.1, (float) 2.2, (float)3.3, (float)4.4, (float) 5.5};
        Boolean[] boolArray = {true, false, true, false};
        Persona[] personaArray = {
            new Persona("76649753", "Brayton", "Calle San Luis"),
            new Persona("76645572", "Marcos", "Calle San Pedro"),
            new Persona("76645572", "Zoila", "Calle San Pedro")
        };

        System.out.println("Array integerArray contiene:");
        imprimirArray(intArray);
        System.out.println("\nArray doubleArray contiene:");
        imprimirArray(doubleArray);
        System.out.println("\nArray charArray contiene:");
        imprimirArray(charArray);
        System.out.println("\nArray floatArray contiene:");
        imprimirArray(floatArray);
        System.out.println("\nArray boolArray contiene:");
        imprimirArray(boolArray);
        System.out.println("\nArray personaArray contiene:");
        imprimirArray(personaArray);
    }

    public static <T> void imprimirArray(T[] inputArray) {
        for (T elemento : inputArray)
            System.out.printf("%s ", elemento);
        System.out.println();
    }

    static class Persona {
        private String dni;
        private String nombres;
        private String direccion;

        public Persona(String dni, String nombres, String direccion) {
            this.dni = dni;
            this.nombres = nombres;
            this.direccion = direccion;
        }

        @Override
        public String toString() {
            return "Persona{" +
                    "dni='" + dni + '\'' +
                    ", nombres='" + nombres + '\'' +
                    ", direccion='" + direccion + '\'' +
                    '}';
        }
    }
}
