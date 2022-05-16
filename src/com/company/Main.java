package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);
    Scanner intScanner = new Scanner(System.in);
    BookService bookService = new BookService();
    Author author = new Author("David", "Olabode", "Male");

    public static void main(String[] args) {
        System.out.println("Welcome to the bookstore, what would you like to do today!");
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();

        String input = "";

        //Loop to show options as long as the user doesn't enter quit
        do {
            System.out.println("""
                    1. Add Book
                    2. Remove Book
                    3. List Books
                    4. List Books by Fantasy Type
                    5. List Books published before 1999
                    6. Most Expensive book
                    7. Cheapest Book in store
                    8. Add Authors to book
                    9. Book with 3 authors
                    10. Verify a book is on the list
                    11. Return a list of books written by provided author
                    
                   
                    Enter Quit to exit application
                    """);

            //Read input from user
            input = scanner.nextLine();

            switch (input) {
                case "1":
                    main.addBook();
                    break;
                case "2":
                    main.removeBook();
                    break;
                case "3":
                    main.listBooks();
                    break;
                case "4":
                    main.fantasyBooks();
                    break;
                case "5":
                    main.booksBefore1999();
                    break;
                case "6":
                    main.mostExpensiveBook();
                    break;
                case "7":
                    main.cheapestBook();
                    break;
                case "8":
                    main.addAuthors();
                    break;
                case "9":
                    main.bookWith3Authors();
                    break;
                case "10":
                    main.verifyBook();
                    break;
                case "11":
                    main.findBooksByAuthor();
                    break;
                case "QUIT":
                    System.out.println("Exiting Application");
                    break;
                default:
                    System.out.println("Please input a valid option!");
                    break;
            }

        } while(!input.equalsIgnoreCase("quit"));

    }

    //Add book method: responsible reading inputs from user and creating a new book
    void addBook() {
        System.out.println("Add a new book to the store");

        System.out.println("Enter title: ");
        String title = scanner.nextLine();

        System.out.println("Enter Price: ");
        double price = intScanner.nextDouble();

        System.out.println("Enter Year of Release: ");
        int yearOfRelease = intScanner.nextInt();

        System.out.println("Enter Genre (FANTASY, THRILLER, ROMANCE): ");
        String stringGenre = scanner.nextLine();



        Genre genre;

        switch (stringGenre) {
            case "FANTASY":
                genre = Genre.FANTASY;
                break;
            case "THRILLER":
                genre = Genre.THRILLER;
                break;
            case "ROMANCE":
                genre = Genre.ROMANCE;
                break;
            default:
                genre = Genre.FANTASY;
                break;
        }

        Book book = new Book(title, price, yearOfRelease, genre);

//        book.authorList.add(author);
        bookService.addBook(book);

        System.out.println(book.title + " added successfully");
    }

    void listBooks() {
        System.out.println("List of all books in the store");

        //Loop through books returned from the bookstore.listbooks and print them to the console
        for (Book book: bookService.listBooks()) {
            System.out.println(book);
        }
    }

    void removeBook() {
        System.out.println("Remove a book from the store");

        System.out.println("Enter book title:");
        String title = scanner.nextLine();

        Book book = bookService.findByTitle(title);

        //Check if book is in store. if no then tell user book doesn't exist and if yes remove book from store
        if(book == null) {
            System.out.println("Book doesn't exist in store");
            return;
        } else {
            bookService.removeBook(book);
        }

        System.out.println(title + " removed from the store");
    }

    void fantasyBooks() {
        System.out.println("List of fantasy books");

        for (Book book: bookService.listBooksByFantasyType()) {
            System.out.println(book);
        }
    }

    void booksBefore1999() {
        System.out.println("List of books published before 1999");

        for (Book book: bookService.listBooksBefore1999()){
            System.out.println(book);
        }
    }

    void mostExpensiveBook() {
        System.out.println("The most expensive book in the store is: ");

        System.out.println(bookService.mostExpensive());
    }

    void cheapestBook() {
        System.out.println("The cheapest book in the store is: ");

        System.out.println(bookService.cheapestBook());
    }

    void addAuthors() {
        System.out.println("Add authors to book!");

        System.out.println("Enter the title of the book");
        String title = scanner.nextLine();

        Book book = bookService.findByTitle(title);
        int index = bookService.books.indexOf(book);

        ArrayList<Author> authors = new ArrayList<>();

        String input = "";

        do {
            System.out.println("Add a new author");

            System.out.println("Enter authors first name: ");
            String firstName = scanner.nextLine();

            System.out.println("Enter authors last name: ");
            String lastName = scanner.nextLine();

            System.out.println("Enter authors gender: ");
            String gender = scanner.nextLine();

            Author author = new Author(firstName, lastName, gender);
            authors.add(author);

            System.out.println("Enter yes to add another author. and No to continue");
            input = scanner.nextLine();
        } while (!input.equalsIgnoreCase("no"));

        book.authorList = authors;

        bookService.books.set(index, book);
        System.out.println("Authors for " + book.title + " has been updated successfully");

    }

    void bookWith3Authors() {
        System.out.println("Here is a book that was written by 3 authors");

        Book book = bookService.bookBy3Authors();
        if(book == null) {
            System.out.println("Cannot find a book with 3 authors");
//            return;
        } else {
            System.out.println(book);
        }
    }

    void verifyBook() {
        System.out.println("Verify if a book is in the store");

        System.out.println("Enter title");
        String title = scanner.nextLine();

        Book book = bookService.findByTitle(title);

        System.out.println(bookService.verifyBook(book));
    }

    void findBooksByAuthor() {
        System.out.println("Books written by provided author");


        for (Book book: bookService.findBooksByAuthor(author)) {
            System.out.println(book);
        }
    }

}
