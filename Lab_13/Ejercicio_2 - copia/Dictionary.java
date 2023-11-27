package Ejercicio_2;

import java.util.ArrayList;

public class Dictionary<K, V> {
    private ArrayList<Pair<K, V>> pairs;

    public Dictionary() {
        this.pairs = new ArrayList<>();
    }

    public void add(K key, V value) {
        Pair<K, V> newPair = new Pair<>(key, value);
        pairs.add(newPair);
    }

    public boolean delete(K key) {
        for (Pair<K, V> pair : pairs) {
            if (pair.getKey().equals(key)) {
                pairs.remove(pair);
                return true;
            }
        }
        return false;
    }

    public V getValue(K key) throws ObjectNoExistException {
        for (Pair<K, V> pair : pairs) {
            if (pair.getKey().equals(key)) {
                return pair.getValue();
            }
        }
        throw new ObjectNoExistException("No se encontró un objeto con la clave proporcionada.");
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Dictionary: [");
        for (Pair<K, V> pair : pairs) {
            result.append(pair).append(", ");
        }
        if (!pairs.isEmpty()) {
            // Eliminar la coma adicional al final
            result.delete(result.length() - 2, result.length());
        }
        result.append("]");
        return result.toString();
    }

    private static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "(" + key + ", " + value + ")";
        }
    }

    public static class ObjectNoExistException extends Exception {
        public ObjectNoExistException(String message) {
            super(message);
        }
    }


}

