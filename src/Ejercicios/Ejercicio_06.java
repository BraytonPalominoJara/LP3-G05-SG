package Ejercicios;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Ejercicio_06 {
    public static void main(String[] args) {
        String[] arrayStrings1 = {"uno", "dos", "tres"};
        String[] arrayStrings2 = {"dos", "tres", "cuatro"};

        Producto[] arrayProductos1 = {
                new Producto("001", "Laptop", 1200.00),
                new Producto("002", "Smartphone", 800.00),
                new Producto("003", "Tablet", 400.00)
        };

        Producto[] arrayProductos2 = {
                new Producto("002", "Smartphone", 800.00),
                new Producto("003", "Tablet", 400.00),
                new Producto("004", "Cámara", 300.00)
        };

        Persona[] arrayPersonas1 = {
                new Persona("123", "Juan"),
                new Persona("456", "María"),
                new Persona("789", "Carlos")
        };

        Persona[] arrayPersonas2 = {
                new Persona("456", "María"),
                new Persona("789", "Carlos"),
                new Persona("012", "Laura")
        };

        // Pruebas
        String[] resultStrings = copyArray(arrayStrings1, arrayStrings2);
        System.out.println("Strings sin repetidos: " + Arrays.toString(resultStrings));

        Producto[] resultProductos = copyArray(arrayProductos1, arrayProductos2);
        System.out.println("Productos sin repetidos: " + Arrays.toString(resultProductos));

        Persona[] resultPersonas = copyArray(arrayPersonas1, arrayPersonas2);
        System.out.println("Personas sin repetidos: " + Arrays.toString(resultPersonas));
    }

    public static <T> T[] copyArray(T[] array1, T[] array2) {
        Set<T> set = new HashSet<>(Arrays.asList(array1));
        set.addAll(Arrays.asList(array2));

        // Convierte el conjunto de nuevo a un arreglo
        return set.toArray(Arrays.copyOf(array1, 0));
    }

    static class Producto {
        private String codigo;
        private String descripcion;
        private double precio;

        public Producto(String codigo, String descripcion, double precio) {
            this.codigo = codigo;
            this.descripcion = descripcion;
            this.precio = precio;
        }

        @Override
        public String toString() {
            return "Producto{" +
                    "codigo='" + codigo + '\'' +
                    ", descripcion='" + descripcion + '\'' +
                    ", precio=" + precio +
                    '}';
        }
    }

    static class Persona {
        private String dni;
        private String nombres;

        public Persona(String dni, String nombres) {
            this.dni = dni;
            this.nombres = nombres;
        }

        @Override
        public String toString() {
            return "Persona{" +
                    "dni='" + dni + '\'' +
                    ", nombres='" + nombres + '\'' +
                    '}';
        }
    }
}
