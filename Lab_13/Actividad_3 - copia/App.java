package Actividad_3;

import java.util.Arrays;

import javax.management.ObjectName;


public class App {
    public static void main(String[] args) throws ObjectNoExistException {
        try {
            // Crear bolsas de diferentes tipos
            Bag<Integer> integerBag = new Bag<>(5);
            Bag<String> stringBag = new Bag<>(5);
            Bag<Persona> personaBag = new Bag<>(5);

            // Agregar objetos a las bolsas
            integerBag.add(1);
            integerBag.add(2);
            integerBag.add(3);

            stringBag.add("Hola");
            stringBag.add("Mundo");

            personaBag.add(new Persona("Brayton","76649753"));
            personaBag.add(new Persona("Jane","8526"));

            // Mostrar el contenido de las bolsas
            System.out.println("Bolsa de enteros: " + integerBag);
            System.out.println("Bolsa de cadenas: " + stringBag);
            System.out.println("Bolsa de personas: " + personaBag);

            // Obtener arreglo de objetos de las bolsas
            System.out.println("Objetos en la bolsa de enteros: " + Arrays.toString(integerBag.getObjects()));
            System.out.println("Objetos en la bolsa de cadenas: " + Arrays.toString(stringBag.getObjects()));
            System.out.println("Objetos en la bolsa de personas: " + Arrays.toString(personaBag.getObjects()));

            // Remover objetos de las bolsas
            integerBag.remove(2);
            stringBag.remove("Hola");
          //  personaBag.remove(new Persona("John"));

            // Mostrar el contenido actualizado de las bolsas
            System.out.println("Bolsa de enteros después de remover: " + integerBag);
            System.out.println("Bolsa de cadenas después de remover: " + stringBag);
            System.out.println("Bolsa de personas después de remover: " + personaBag);

            // Obtener el índice de un objeto en las bolsas
            System.out.println("Índice de 3 en la bolsa de enteros: " + integerBag.getIndex(3));
            System.out.println("Índice de 'Mundo' en la bolsa de cadenas: " + stringBag.getIndex("Mundo"));
            System.out.println("Índice de 'John' en la bolsa de personas: " + personaBag.getIndex(new Persona("Brayton","76649753")));
        } catch (IsFullException | IsEmptyException | ObjectNoExistException e) {
            (e).printStackTrace();
        }
    }
}
