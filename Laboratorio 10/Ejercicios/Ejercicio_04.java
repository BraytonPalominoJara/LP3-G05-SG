package Ejercicios;

import java.util.ArrayList;

public class Ejercicio_04 {
    public static void main(String[] args) {
        // Crear un ArrayList para almacenar los objetos
        ArrayList<Producto> productos = new ArrayList<>();
        ArrayList<Persona> personas = new ArrayList<>();
        ArrayList<Estudiante> estudiantes = new ArrayList<>();

        // Agregar elementos a los ArrayList
        productos.add(new Producto("001", "Producto 1", 10.5));
        productos.add(new Producto("002", "Producto 2", 20.3));

        personas.add(new Persona("12345678", "Juan Perez", "Calle A"));
        personas.add(new Persona("87654321", "Maria Lopez", "Calle B"));

        estudiantes.add(new Estudiante("11223344", "Carlos Ramirez", "Calle C", "Ingeniería Informática"));
        estudiantes.add(new Estudiante("44332211", "Luisa Martinez", "Calle D", "Medicina"));

        // Realizar búsquedas
        String codigoProductoABuscar = "002";
        int posicionProducto = buscarElemento(productos, codigoProductoABuscar);
        System.out.println("El producto con código " + codigoProductoABuscar + " se encuentra en la posición: " + posicionProducto);

        String nombrePersonaABuscar = "Maria Lopez";
        int posicionPersona = buscarElemento(personas, nombrePersonaABuscar);
        System.out.println("La persona con nombre " + nombrePersonaABuscar + " se encuentra en la posición: " + posicionPersona);

        String nombreEstudianteABuscar = "Luisa Martinez";
        String carreraEstudianteABuscar = "Medicina";
        int posicionEstudiante = buscarEstudiante(estudiantes, nombreEstudianteABuscar, carreraEstudianteABuscar);
        System.out.println("El estudiante con nombre " + nombreEstudianteABuscar + " que estudia " + carreraEstudianteABuscar + " se encuentra en la posición: " + posicionEstudiante);
    }

    public static <T> int buscarElemento(ArrayList<T> arreglo, String elemento) {
        for (int i = 0; i < arreglo.size(); i++) {
            if (arreglo.get(i).equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    public static int buscarEstudiante(ArrayList<Estudiante> arreglo, String nombre, String carrera) {
        for (int i = 0; i < arreglo.size(); i++) {
            if (arreglo.get(i).getNombres().equals(nombre) && arreglo.get(i).getCarrera().equals(carrera)) {
                return i;
            }
        }
        return -1;
    }
}

class Producto {
    private String codigo;
    private String descripcion;
    private double precio;

    public Producto(String codigo, String descripcion, double precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    // Getters y setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}

class Persona {
    private String dni;
    private String nombres;
    private String direccion;

    public Persona(String dni, String nombres, String direccion) {
        this.dni = dni;
        this.nombres = nombres;
        this.direccion = direccion;
    }

    // Getters y setters
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}

class Estudiante extends Persona {
    private String carrera;

    public Estudiante(String dni, String nombres, String direccion, String carrera) {
        super(dni, nombres, direccion);
        this.carrera = carrera;
    }

    // Getter y setter para carrera
    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}