/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package arman.library_management_system;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author arman
 */
public class Library_Management_System {

    private static Scanner sc = new Scanner(System.in);
    private static Library library = new Library();

    public static void main(String[] args) {
        loadAllBooksFromFile();

        try {
            int userMenuSelection;
            do {
                userMenuSelection = showMainMenu();

                switch (userMenuSelection) {
                    case 1 -> {
                        System.out.println("What is the title of the book?");
                        String bookTitle = sc.next().trim().toLowerCase();
                        System.out.println("Who is the author of the book?");
                        String bookAuthor = sc.next().trim().toLowerCase();
                        addBook(new Book(bookTitle, bookAuthor), true);
                    }
                    case 2 -> {
                        System.out.println("Provide the keyword for the book title.");
                        String bookKeyword = sc.next().trim().toLowerCase();
                        searchBookByTitle(bookKeyword);
                        break;
                    }
                    case 3 -> {
                        printAllBooks();
                        System.out.println("What book you like to get? Enter the book number");
                        int bookIndex = sc.nextInt();
                        bookCheckout(bookIndex);
                    }
                    case 4 -> {
                        System.out.println("What is the title of the book you want to return?");
                        String bookReturnTitle = sc.next().trim().toLowerCase();
                        bookReturn(bookReturnTitle);

                    }

                    case 5 -> {
                        System.out.println("Bye....");
                    }
                    default ->
                        System.out.println("Invalid choose 1-4 only");
                }

            } while (userMenuSelection != 5);

        } catch (InputMismatchException e) {
            System.out.println("Invalid entry");
        }

    }

    private static int showMainMenu() throws InputMismatchException {
        System.out.printf("Choose one:"
                + "\n 1. Add Book"
                + "\n 2. Search Book"
                + "\n 3. Checkout Book"
                + "\n 4. Return book"
                + "\n 5. Exit Program "
                + "\n Enter you choice: ");
        return sc.nextInt();
    }

    private static void addBook(Book book, Boolean showSuccessNotification) {

        if (!showSuccessNotification) {
            library.addBook(book);
        } else {
            System.out.println(library.addBook(book));
        }

    }

    private static void searchBookByTitle(String title) {
        ArrayList<Book> booksFound = library.searchBookByTitle(title);

        if (booksFound.size() != 0) {
            for (Book book : booksFound) {
                System.out.println(book);

            }
        } else {
            System.out.println("Sorry no book found with this name");
        }
    }

    private static void bookCheckout(int bookIndex) {

        if (bookIndex < library.getAvailableBooks().size()) {
            Book book = library.getAvailableBooks().get(bookIndex);
            System.out.println(library.bookCheckout(book));

            // if the book is issued the add it to file.
            try {
                addCheckedoutBookToFile(book);
            } catch (IOException e) {
                System.err.print("Book issuing file cannot be created");
            }

        } else {
            System.out.println("No book at this number");
        }
    }

    private static void addCheckedoutBookToFile(Book book) throws IOException {
        String filename = "issuedBook.txt";
        FileWriter fs = new FileWriter(filename, true);
        fs.write(book.getTitle() + " " + book.getAuthor() + "\n");

        System.out.println("File Successfully Created.");
        fs.close();
    }

    private static void bookReturn(String bookTitle) {

        Book returningBook = null;
        if (library.getIssuedBooks().size() > 0) {
            for (int i = 0; i < library.getIssuedBooks().size(); i++) {
                if (library.getIssuedBooks().get(i).getTitle().equals(bookTitle)) {
                    returningBook = library.getIssuedBooks().get(i);
                }
            }
        } else {
            System.out.println("No Book Found: We did not issed any book yet.");
        }

        System.out.println(library.bookReturned(returningBook));
    }

    private static void printAllBooks() {

        for (int i = 0; i < library.getAvailableBooks().size(); i++) {
            System.out.println(i + ". " + library.getAvailableBooks().get(i));
        }
    }

    private static void loadAllBooksFromFile() {

        try {

            FileReader fr = new FileReader("allAvailableBook.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;

            //If the stream is read and the file is not null.
            if (br.ready()) {
                while ((line = br.readLine()) != null) {
                    String[] titleAndAuth = line.split(" ");

                    Book newBook = new Book(titleAndAuth[0], titleAndAuth[1]);
                    addBook(newBook, false);
                }

            }
        } catch (IOException e) {
            System.out.println("Books from allAvailableBooks cannot be loaded");
        }
    }
}
