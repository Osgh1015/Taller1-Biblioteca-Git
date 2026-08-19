
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
private static void create() {
    System.out.println("\n-- Create client --");

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

    System.out.println("Client created successfully.");
}
}