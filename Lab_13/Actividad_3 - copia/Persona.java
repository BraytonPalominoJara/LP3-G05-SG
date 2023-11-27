package Actividad_3;

import java.util.Objects;

public class Persona {
    private String nombre;
    private String dni;

    public Persona(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Persona persona = (Persona) obj;
        return nombre.equals(persona.nombre) &&
               dni.equals(persona.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, dni);
    }

    @Override
    public String toString() {
        return "Persona{" +
               "nombre='" + nombre + '\'' +
               ", dni='" + dni + '\'' +
               '}';
    }
}
