package Ejercicios;

import java.util.ArrayList;
import java.util.Scanner;

		class Main {

		    public static void main(String[] args) {
		        ArrayList<Ejercicio_01> agenda = new ArrayList<>();
		        Scanner sc = new Scanner(System.in);

		        while (true) {
		            System.out.println("\nMenú de Agenda de Contactos:");
		            System.out.println("1 Añadir contacto");
		            System.out.println("2 Buscar contacto");
		            System.out.println("3 Modificar contacto");
		            System.out.println("4 Borrar contacto");
		            System.out.println("5 Eliminar contactos");
		            System.out.println("6 Mostrar contactos");
		            System.out.println("7 Salir");
		            System.out.print("Seleccione una opción: ");

		            int opcion = sc.nextInt();
		            sc.nextLine(); 

		            switch (opcion) {
		                case 1:
		                    
		                    System.out.print("Nombre: ");
		                    String nombre = sc.nextLine();
		                    System.out.print("Teléfono: ");
		                    int telefono = sc.nextInt();
		                    sc.nextLine(); 
		                    System.out.print("Dirección: ");
		                    String direccion = sc.nextLine();

		                    Ejercicio_01 nuevoContacto = new Ejercicio_01(nombre, telefono, direccion);
		                    agenda.add(nuevoContacto);
		                    System.out.println("Contacto agregado exitosamente.");
		                    break;

		                case 2:
		                    
		                    System.out.print("Ingrese el nombre del contacto a buscar: ");
		                    String nombreBusqueda = sc.nextLine();
		                    boolean encontrado = false;

		                    for (Ejercicio_01 contacto : agenda) {
		                        if (contacto.getNombre().equalsIgnoreCase(nombreBusqueda)) {
		                            System.out.println("Nombre: " + contacto.getNombre());
		                            System.out.println("Teléfono: " + contacto.getTelefono());
		                            System.out.println("Dirección: " + contacto.getDireccion());
		                            encontrado = true;
		                            break;
		                        }
		                    }

		                    if (!encontrado) {
		                        System.out.println("Contacto no encontrado.");
		                    }
		                    break;

		                case 3:
		                    // Modificar contacto
		                    System.out.print("Ingrese el nombre del contacto a modificar: ");
		                    String nombreModificacion = sc.nextLine();
		                    boolean modificado = false;

		                    for (Ejercicio_01 contacto : agenda) {
		                        if (contacto.getNombre().equalsIgnoreCase(nombreModificacion)) {
		                            System.out.print("Nuevo nombre: ");
		                            String nuevoNombre = sc.nextLine();
		                            System.out.print("Nuevo teléfono: ");
		                            int nuevoTelefono = sc.nextInt();
		                            sc.nextLine(); // Consumir el salto de línea
		                            System.out.print("Nueva dirección: ");
		                            String nuevaDireccion = sc.nextLine();

		                            contacto.setNombre(nuevoNombre);
		                            contacto.setTelefono(nuevoTelefono);
		                            contacto.setDireccion(nuevaDireccion);

		                            System.out.println("Contacto modificado exitosamente.");
		                            modificado = true;
		                            break;
		                        }
		                    }

		                    if (!modificado) {
		                        System.out.println("Contacto no encontrado.");
		                    }
		                    break;

		                case 4:
		                    // Borrar contacto
		                    System.out.print("Ingrese el nombre del contacto a borrar: ");
		                    String nombreBorrado = sc.nextLine();
		                    boolean borrado = false;

		                    for (Ejercicio_01 contacto : agenda) {
		                        if (contacto.getNombre().equalsIgnoreCase(nombreBorrado)) {
		                            agenda.remove(contacto);
		                            System.out.println("Contacto borrado exitosamente.");
		                            borrado = true;
		                            break;
		                        }
		                    }

		                    if (!borrado) {
		                        System.out.println("Contacto no encontrado.");
		                    }
		                    break;

		                case 5:
		                    // Eliminar todos los contactos
		                    agenda.clear();
		                    System.out.println("Todos los contactos han sido eliminados.");
		                    break;

		                case 6:
		                    // Mostrar contactos
		                    System.out.println("\nLista de Contactos:");
		                    for (Ejercicio_01 contacto : agenda) {
		                        System.out.println("Nombre: " + contacto.getNombre());
		                        System.out.println("Teléfono: " + contacto.getTelefono());
		                        System.out.println("Dirección: " + contacto.getDireccion());
		                        System.out.println();
		                    }
		                    break;

		                case 7:
		                    // Salir
		                    System.out.println("Saliendo de la aplicación. ¡Hasta luego!");
		                    sc.close();
		                    System.exit(0);
		                    break;

		                default:
		                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
		            }
		        }
		    }
		}

		

	


