package Ejercicio_2;

import Ejercicio_2.Dictionary.ObjectNoExistException;

public class App {
    public static void main(String[] args) {
        Dictionary<Object, Object> myDictionary = new Dictionary<>();
        myDictionary.add(1, "hola");
        myDictionary.add("adios", "adios");
        myDictionary.add(3, 3);
        myDictionary.add(4, "fin");

        System.out.println(myDictionary);

        try {
            System.out.println("Valor de 1: " + myDictionary.getValue(1));
            System.out.println("Eliminando : " + myDictionary.delete(1));
            System.out.println(myDictionary);
            System.out.println("Valor de 1 después de eliminar: " + myDictionary.getValue(1));
        } catch (ObjectNoExistException e) {
            System.out.println(e.getMessage());
        }
    }
}

