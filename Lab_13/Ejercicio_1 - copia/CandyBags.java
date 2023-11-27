package Ejercicio_1;

import java.util.Arrays;

public class CandyBags extends Bag<Goodies> {

    public CandyBags(int n) {
        super(n);
    }

    @Override
    public void add(Goodies obj) throws IsFullException {
        // Verificar si el objeto no ha sido incluido previamente
        if (!contains(obj)) {
            super.add(obj);
        }
    }
    public Goodies cheapest() throws IsEmptyException {
        Goodies[] candies = getObjects();

        if (candies.length == 0) {
            throw new IsEmptyException("La bolsa de golosinas está vacía.");
        }

        // Inicializar con la primera golosina
        Goodies cheapestCandy = candies[0];

        // Encontrar la golosina más económica
        for (Goodies candy : candies) {
            if (candy.getPrice() < cheapestCandy.getPrice()) {
                cheapestCandy = candy;
            }
        }

        return cheapestCandy;
    }


    public CandyBags mostExpensive(int n) throws IsEmptyException, IsFullException {
        Goodies[] candies = getObjects();

        if (candies.length == 0) {
            throw new IsEmptyException("La bolsa de golosinas está vacía.");
        }

        // Ordenar golosinas por precio de forma descendente
        Arrays.sort(candies, (candy1, candy2) -> Float.compare(candy2.getPrice(), candy1.getPrice()));

        // Tomar las n golosinas más caras
        CandyBags expensiveCandiesBag = new CandyBags(n);
        for (int i = 0; i < Math.min(n, candies.length); i++) {
            expensiveCandiesBag.add(candies[i]);
        }

        return expensiveCandiesBag;
    }
}
