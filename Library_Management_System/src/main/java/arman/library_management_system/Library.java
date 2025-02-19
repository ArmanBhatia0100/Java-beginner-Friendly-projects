/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arman.library_management_system;

import java.util.ArrayList;

/**
 *
 * @author arman
 */
public class Library {

    private ArrayList<Book> availableBooks = new ArrayList<>();
    private ArrayList<Book> issuedBooks = new ArrayList<>();

//add book    
    public String addBook(Book book) {

        if (availableBooks.add(book)) {
            return "Book Added";
        } else {
            return "Fail to add book";
        }
    }

    public ArrayList<Book> searchBookByTitle(String title) {
        ArrayList<Book> searchedBooks = new ArrayList<>();

        for (Book book : availableBooks) {
            if (book.getTitle().contains(title)) {
                searchedBooks.add(book);
            }
        }
        return searchedBooks;
    }

    public String bookCheckout(Book book) {
        if (availableBooks.contains(book)) {
            availableBooks.remove(book);
            issuedBooks.add(book);
            return "Book: " + book + " issued";
        } else {
            return "Book not available";
        }
    }

    public String bookReturned(Book book) {
        issuedBooks.remove(book);
        availableBooks.add(book);
        return "" + book + " is returned, Thank you";
    }

    public ArrayList<Book> getAvailableBooks() {
        return availableBooks;
    }

    public ArrayList<Book> getIssuedBooks() {
        return issuedBooks;
    }

}
