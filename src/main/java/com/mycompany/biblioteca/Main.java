
package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Client> clients = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Aquí irá el menú (Fase 8)
    }
    
// Crear un nuevo cliente
private static void CREATE() {
    System.out.println("\n-- Crear cliente --");

    System.out.print("Id: ");
    String id = sc.nextLine();

    System.out.print("Name: ");
    String name = sc.nextLine();

    System.out.print("Phone: ");
    String phone = sc.nextLine();

    System.out.print("Email: ");
    String email = sc.nextLine();

    // Crear el cliente y agregarlo a la lista
    clients.add(new Client(id, name, phone, email));

    System.out.println("cliente creado exitosamente.");
}


//READ (LISTAR Y BUSCAR)
private static void READ () {
    System.out.println("\n-- Lista de clientes --");

    if (clients.isEmpty()) {
        System.out.println("No hay clientes registrados.");
        return;
    }

    for (Client c : clients) {
        System.out.println(c);
    }
}

// Método auxiliar interno, no imprime (se reutiliza en otros métodos)
private static Client findClientInternal(String id) {
    for (Client c : clients) {
        if (c.getId().equals(id)) {
            return c;
        }
    }

    return null;
}
//READ BUSCAR

private static void findClientById(String id) {
        Client c = findClientInternal(id);

        if (c == null) {
            System.out.println("Cliente no encontrado.");
        } else {
            System.out.println(c);
        }
    }

//UPDATE
private static void UPDATE() {
    System.out.print("Id del cliente a actualizar: ");
    String id = sc.nextLine();

    Client c = findClientInternal(id);

    if (c == null) {
        System.out.println("Cliente no encontrado.");
        return;
    }

    System.out.print("Nuevo nombre (" + c.getName() + "): ");
    c.setName(sc.nextLine());

    System.out.print("Nuevo teléfono (" + c.getPhone() + "): ");
    c.setPhone(sc.nextLine());

    System.out.print("Nuevo email (" + c.getEmail() + "): ");
    c.setEmail(sc.nextLine());

    System.out.println("Cliente actualizado correctamente.");
}
}