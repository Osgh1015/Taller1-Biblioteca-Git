
package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {

    static ArrayList<Client> clients = new ArrayList<>();
    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Loan> loans = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    int option;
    do {
        showMainMenu();
        option = readInt("Elija una opcion: ");

        switch (option) {
            case 1:
                clientsMenu();
                break;
            case 2:
                booksMenu();
                break;
            case 3:
                loansMenu();
                break;
            case 0:
                System.out.println("Cerrando el sistema...");
                break;
            default:
                System.out.println("Opción invalida.");
        }
    } while (option != 0);
}

// ==================== MENÚS ====================

// Mostrar menú principal
private static void showMainMenu() {
    System.out.println("\n===== BIBLIOTECA MUNICIPAL DE VALLEDUPAR =====");
    System.out.println("1. Gestion de clientes");
    System.out.println("2. Gestion de libros");
    System.out.println("3. Gestion de prestamos");
    System.out.println("0. Salir");
}

// ==================== MENÚ CLIENTES ====================

private static void clientsMenu() {
    int option;

    do {
        System.out.println("\n--- GESTION DE CLIENTES ---");
        System.out.println("1. Crear cliente");
        System.out.println("2. Listar clientes");
        System.out.println("3. Buscar cliente por ID");
        System.out.println("4. Actualizar cliente");
        System.out.println("5. Eliminar cliente");
        System.out.println("0. Volver al menu principal");

        option = readInt("Elija una opcion: ");

        switch (option) {
            case 1:
                CREATE();
                break;

            case 2:
                READ();
                break;

            case 3:
                findClientById(readText("Ingrese el ID del cliente a buscar: "));
                break;

            case 4:
                UPDATE();
                break;

            case 5:
                DELETE();
                break;

            case 0:
                break;

            default:
                System.out.println("Opcion invalida.");
        }

    } while (option != 0);
}

// ==================== MENÚ LIBROS ====================

private static void booksMenu() {
    int option;

    do {
        System.out.println("\n--- GESTION DE LIBROS ---");
        System.out.println("1. Crear libro");
        System.out.println("2. Listar libros");
        System.out.println("3. Buscar libro por código");
        System.out.println("4. Actualizar libro");
        System.out.println("5. Eliminar libro");
        System.out.println("0. Volver al menu principal");

        option = readInt("Elija una opcion: ");

        switch (option) {
            case 1:
                createBook();
                break;

            case 2:
                listBooks();
                break;

            case 3:
                findBookByCode(readText("Ingrese el código del libro a buscar: "));
                break;

            case 4:
                updateBook();
                break;

            case 5:
                deleteBook();
                break;

            case 0:
                break;

            default:
                System.out.println("Opción invalida.");
        }

    } while (option != 0);
}

// ==================== MENÚ PRÉSTAMOS ====================

private static void loansMenu() {
    int option;

    do {
        System.out.println("\n--- GESTION DE PRESTAMOS ---");
        System.out.println("1. Registrar prestamo");
        System.out.println("2. Registrar devolucion");
        System.out.println("3. Listar préstamos activos");
        System.out.println("0. Volver al menu principal");

        option = readInt("Elija una opcion: ");

        switch (option) {
            case 1:
                createLoan();
                break;

            case 2:
                returnLoan();
                break;

            case 3:
                listActiveLoans();
                break;

            case 0:
                break;

            default:
                System.out.println("Opcion invalida.");
        }

    } while (option != 0);
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

//DELETE 

private static void DELETE() {
    System.out.print("Id del cliente a eliminar: ");
    String id = sc.nextLine();

    Client c = findClientInternal(id);

    if (c == null) {
        System.out.println("Cliente no encontrado.");
        return;
    }

    // Eliminar el cliente de la lista
    clients.remove(c);

    System.out.println("Cliente eliminado correctamente.");
}

//-----------LIBRO---------------

// CREATE
    private static void createBook() {
        System.out.println("\n-- Create book --");
        String code = readText("Code: ");
        if (findBookInternal(code) != null) {
            System.out.println("A book with that code already exists.");
            return;
        }
        String title = readText("Title: ");
        String year = readText("Publication year: ");
        String author = readText("Author: ");
        books.add(new Book(code, title, year, author));
        System.out.println("Book created successfully.");
    }
    // Método auxiliar para buscar un libro por código
private static Book findBookInternal(String code) {
    for (Book b : books) {
        if (b.getCode().equals(code)) {
            return b;
        }
    }

    return null;
}
    // Leer texto ingresado por el usuario
private static String readText(String prompt) {
    System.out.print(prompt);
    return sc.nextLine();
}


// READ (list)
private static void listBooks() {
    System.out.println("\n-- lista de libros  --");

    if (books.isEmpty()) {
        System.out.println("NO hay libros registrados.");
        return;
    }

    for (Book b : books) {
        System.out.println(b);
    }
}
//READ (BUSCAR)
private static void findBookByCode(String code) {
        Book b = findBookInternal(code);
        if (b == null) {
            System.out.println("Book not found.");
        } else {
            System.out.println(b);
        }
    }

// UPDATE
    private static void updateBook() {
        String code = readText("Codigo del libro para actualizar: ");
        Book b = findBookInternal(code);
        if (b == null) {
            System.out.println("libro no encontrado ");
            return;
        }
        b.setTitle(readText("nuevo titulo  (" + b.getTitle() + "): "));
        b.setPublicationYear(readText("nuevo año (" + b.getPublicationYear() + "): "));
        b.setAuthor(readText("nuevo autor (" + b.getAuthor() + "): "));
        System.out.println("libro actualizado exitosamente.");
    }
    
     // DELETE
    private static void deleteBook() {
        String code = readText("Codigo del libro a eliminar: ");
        Book b = findBookInternal(code);
        if (b == null) {
            System.out.println("libro no encontrado.");
            return;
        }
        books.remove(b);
        System.out.println("libro eliminado exitosamente.");
    }
    
     // ==================== LOAN MANAGEMENT ====================
 
    // Register loan
    private static void createLoan() {
        System.out.println("\n-- Register loan --");
        String clientId = readText("Client id: ");
        Client c = findClientInternal(clientId);
        if (c == null) {
            System.out.println("Client not found. The loan cannot be registered.");
            return;
        }
        String bookCode = readText("Book code: ");
        Book b = findBookInternal(bookCode);
        if (b == null) {
            System.out.println("Book not found. The loan cannot be registered.");
            return;
        }
        if (!b.isAvailable()) {
            System.out.println("This book is not currently available.");
            return;
        }
        String loanId = readText("Loan id: ");
        Loan loan = new Loan(loanId, c, b, LocalDate.now());
        loans.add(loan);
        b.setAvailable(false); // the book is now checked out
        System.out.println("Loan registered successfully.");
    }
 
    private static Loan findLoanInternal(String loanId) {
        for (Loan l : loans) {
            if (l.getLoanId().equals(loanId)) {
                return l;
            }
        }
        return null;
    }
    
      // Register return
    private static void returnLoan() {
        String loanId = readText("Id del prestamo para devolver: ");
        Loan l = findLoanInternal(loanId);
        if (l == null) {
            System.out.println("prestamo no encontrado.");
            return;
        }
        if (l.getStatus().equals("DEVUELTO")) {
            System.out.println("Este prestamo ya fue devuelto.");
            return;
        }
        l.setStatus("DEVUELTO");
        l.getBook().setAvailable(true); // the book becomes available again
        System.out.println("devolucion registrada exitosamente.");
    }
    // Listar préstamos activos
private static void listActiveLoans() {
    System.out.println("\n-- Préstamos activos --");
    boolean hayActivos = false;

    for (Loan l : loans) {
        if (l.getStatus().equals("ACTIVE")) {
            System.out.println(l);
            hayActivos = true;
        }
    }

    if (!hayActivos) {
        System.out.println("No hay préstamos activos.");
    }
}

     
    // ==================== INPUT UTILITIES ====================
 
    private static int readInt(String message) {
        System.out.print(message);
        while (!sc.hasNextInt()) {
            System.out.println("Please enter a valid number.");
            sc.next();
            System.out.print(message);
        }
        int value = sc.nextInt();
        sc.nextLine(); // clears the pending newline
        return value;
    }
}
    
