package Actividad_4;

import Actividad_3.IsEmptyException;
import Actividad_3.IsFullException;
import Actividad_3.ObjectNoExistException;

public class Bag<T> {
    private T[] list;
    private int count; // Contador de objetos que hay en la bolsa

    public Bag(int n) {
        this.list = (T[]) new Object[n];
        this.count = 0;
    }

    public void add(T obj) throws IsFullException {
        if (count < list.length) {
            list[count] = obj;
            count++;
        } else {
            throw new IsFullException("La bolsa está llena. No se puede agregar más objetos.");
        }
    }

    public T[] getObjects() throws IsEmptyException {
        if (count > 0) {
            return list;
        } else {
            throw new IsEmptyException("La bolsa está vacía. No hay objetos para obtener.");
        }
    }

    public T remove(T obj) throws ObjectNoExistException {
        for (int i = 0; i < count; i++) {
            if (list[i].equals(obj)) {
                
                for (int j = i; j < count - 1; j++) {
                    list[j] = list[j + 1];
                }
                count--;
                return obj;
            }
        }
        throw new ObjectNoExistException("El objeto no existe en la bolsa.");
    }

    public int getIndex(T obj) {
        for (int i = 0; i < count; i++) {
            if (list[i].equals(obj)) {
                return i;
            }
        }
        return -1; // Retorna -1 si el objeto no está en la bolsa
    }



    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Bag: [");
        for (int i = 0; i < count; i++) {
            result.append(list[i]);
            if (i < count - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }
}

