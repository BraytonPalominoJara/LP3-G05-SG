package Ejercicio_3;

import java.util.Scanner;

public class Contacts {
    private Diccionario<String, Person> contacts;
    private Scanner scanner;

    public Contacts() {
        this.contacts = new Diccionario<>();
        this.scanner = new Scanner(System.in);
    }

    public void addContact() {
        System.out.print("Ingrese el DNI del nuevo contacto: ");
        String dni = scanner.nextLine();

        if (!contactsContainsKey(dni)) {
            System.out.print("Ingrese el nombre del nuevo contacto: ");
            String name = scanner.nextLine();
            System.out.print("Ingrese la dirección del nuevo contacto: ");
            String address = scanner.nextLine();
            System.out.print("Ingrese el teléfono del nuevo contacto: ");
            String phone = scanner.nextLine();

            Person newPerson = new Person(name, address, phone);
            contacts.add(dni, newPerson);

            System.out.println("Contacto agregado con éxito.");
        } else {
            System.out.println("Ya existe un contacto con ese DNI.");
        }
    }

    public void deleteContact() {
        System.out.print("Ingrese el DNI del contacto que desea eliminar: ");
        String dni = scanner.nextLine();

        if (contacts.delete(dni)) {
            System.out.println("Contacto eliminado con éxito.");
        } else {
            System.out.println("No se encontró un contacto con ese DNI.");
        }
    }

    public void viewContact() {
        System.out.print("Ingrese el DNI del contacto que desea ver: ");
        String dni = scanner.nextLine();

        try {
            Person person = contacts.getValue(dni);
            System.out.println("Datos del contacto:");
            System.out.println("Nombre: " + person.getName());
            System.out.println("Dirección: " + person.getAddress());
            System.out.println("Teléfono: " + person.getPhone());
        } catch (Diccionario.ObjectNoExistException e) {
            System.out.println("No se encontró un contacto con ese DNI.");
        }
    }

    public void listContacts() {
        System.out.println("Lista de contactos:");
        System.out.println(contacts);
    }

    private boolean contactsContainsKey(String key) {
        try {
            contacts.getValue(key);
            return true;
        } catch (Diccionario.ObjectNoExistException e) {
            return false;
        }
    }

  
}

class Person {
    private String name;
    private String address;
    private String phone;

    public Person(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
    @Override
    public String toString() {
        return  "Nombre ='" + name + '\'' +
                ", Direccion ='" + address + '\'' +
                ", Telefono='" + phone + '\'' 
                ;
    }
}

