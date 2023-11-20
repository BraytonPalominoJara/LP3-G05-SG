package Ejercicios;

public class Ejercicio_03 {
    public static void main(String[] args) {
        // Prueba del método isEqualTo con diferentes tipos
        System.out.println(isEqualTo("Hola", "Hola"));      // true
        System.out.println(isEqualTo(5, 5));                // true
        System.out.println(isEqualTo(3.14, 3.14));           // true
        System.out.println(isEqualTo("Hola", "Mundo"));     // false
        System.out.println(isEqualTo(10, 20));               // false
        System.out.println(isEqualTo(2.71, 3.14));           // false

        // También se puede utilizar con tipos más generales como Object
        Object obj1 = "Java";
        Object obj2 = "Java";
        System.out.println(isEqualTo(obj1, obj2));           // true
    }

    public static <T> boolean isEqualTo(T obj1, T obj2) {
        return obj1.equals(obj2);
    }
}
