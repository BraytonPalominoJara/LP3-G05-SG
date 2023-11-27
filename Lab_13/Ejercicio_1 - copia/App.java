package Ejercicio_1;


public class App {
    public static void main(String[] args) {
        try {
            // Crear bolsa de golosinas
            CandyBags candyBag = new CandyBags(5);

            // Agregar golosinas a la bolsa
            candyBag.add(new Goodies(1, "Golosina 1", 10.99f));
            candyBag.add(new Goodies(2, "Golosina 2", 5.99f));
            candyBag.add(new Goodies(3, "Golosina 3", 3.49f));
            candyBag.add(new Goodies(4, "Golosina 4", 2.99f));
            candyBag.add(new Goodies(5, "Golosina 5", 4.99f));

            // Mostrar el contenido de la bolsa de golosinas
            System.out.println("Bolsa de golosinas: " + candyBag);

            // Encontrar la golosina más económica
            System.out.println("Golosina más económica: " + candyBag.cheapest());

            // Encontrar las 2 golosinas más caras
            CandyBags expensiveCandiesBag = candyBag.mostExpensive(2);
            System.out.println("Bolsa de las 2 golosinas más caras: " + expensiveCandiesBag);
        } catch (IsFullException | IsEmptyException e) {
            e.printStackTrace();
        }
    }
}
