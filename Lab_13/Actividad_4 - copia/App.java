package Actividad_4;

import Actividad_3.IsEmptyException;
import Actividad_3.IsFullException;
import Actividad_3.ObjectNoExistException;

public class App {
    public static void main(String[] args) {
        try {
            // Crear bolsa de Goodies
            Bag<Goodies> goodiesBag = new Bag<>(5);

            // Agregar objetos a la bolsa
            goodiesBag.add(new Goodies(1, "Goodie 1", 10.99f));
            goodiesBag.add(new Biscuits(2, "Biscuit 1", 5.99f));
            goodiesBag.add(new Chocolates(3, "Chocolate 1", 3.49f));
            goodiesBag.add(new Soda(4, "Soda 1", 2.99f));
            goodiesBag.add(new Sweet(5, "Sweet 1", 4.99f));

            // Mostrar el contenido de la bolsa
            System.out.println("Bolsa de Goodies: " + goodiesBag);
        } catch (IsFullException  e) {
            e.printStackTrace();
        }
    }
}

