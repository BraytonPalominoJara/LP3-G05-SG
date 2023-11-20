package Actividades;

public class Actividad_02 {
    public static void main(String[] args) throws Exception {
        Integer minInt = minimo(1, 3, 8, 2);
        Double minDouble = minimo(0.3, 1.2, 4.8, 0.5);
        String minString = minimo("pera", "manzana", "uva", "Avion");
        Persona minPersona = minimo(
            new Persona("12345678", "Juan", "Calle A"),
            new Persona("87654321", "María", "Calle B"),
            new Persona("23456789", "Carlos", "Calle D"),
            new Persona("98765432", "Ana", "Calle C")
        );

        System.out.println("Mínimo Integer: " + minInt);
        System.out.println("Mínimo Double: " + minDouble);
        System.out.println("Mínimo String: " + minString);
        System.out.println("Mínimo Persona: " + minPersona);
    }

    public static <T extends Comparable<T>> T minimo(T a, T b, T c, T d) {
        T min = a;

        if (b.compareTo(min) < 0)
            min = b;
        if (c.compareTo(min) < 0)
            min = c;
        if (d.compareTo(min) < 0)
            min = d;

        return min;
    }

    static class Persona implements Comparable<Persona> {
        private String dni;
        private String nombres;
        private String direccion;

        public Persona(String dni, String nombres, String direccion) {
            this.dni = dni;
            this.nombres = nombres;
            this.direccion = direccion;
        }

        @Override
        public String toString() {
            return "Persona{" +
                    "dni='" + dni + '\'' +
                    ", nombres='" + nombres + '\'' +
                    ", direccion='" + direccion + '\'' +
                    '}';
        }

        @Override
        public int compareTo(Persona otraPersona) {
            return this.nombres.compareTo(otraPersona.nombres);
        }
    }
}
