package Ejercicio_1;

import java.util.ArrayList;
import java.util.Arrays;

public class Bag<T> {
    private T[] list;
    private int count;

    public Bag(int n) {
        this.list = (T[]) new Object[n];
        this.count = 0;
    }

    public void add(T obj) throws IsFullException {
        // Verificar si la bolsa está llena
        if (count < list.length) {
            list[count++] = obj;
        } else {
            throw new IsFullException("La bolsa está llena.");
        }
    }

    public boolean contains(T obj) {
        // Convertir directamente el arreglo a un ArrayList de tipo Goodies
        ArrayList<T> arrayList = new ArrayList<>(Arrays.asList(Arrays.copyOf(list, count)));
        return arrayList.contains(obj);
    }

    public T[] getObjects() {
        return Arrays.copyOf(list, count);
    }

    // Otros métodos según sea necesario

    @Override
    public String toString() {
        return "Bag: " + Arrays.toString(list);
    }
}

