package Actividad_2;


public class App {
    public static void main(String[] args) {
        // Crear diferentes pares ordenados
        OrderedPair<Integer, Integer> pair1 = new OrderedPair<>(1, 2);
        OrderedPair<Integer, String> pair2 = new OrderedPair<>(3, "Hola");
        OrderedPair<String, Persona> pair3 = new OrderedPair<>("clave", new Persona("brayton","Matarani","961171764"));

        // Imprimir los pares ordenados
        System.out.println(pair1);
        System.out.println(pair2);
        System.out.println(pair3);
    }
}

