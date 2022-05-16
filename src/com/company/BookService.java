package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class BookService {
    ArrayList<Book> books = new ArrayList<>();

    //Method for add a book
    void addBook(Book book) {
        books.add(book);
    }

    Book findByTitle(String title) {
        for(Book book: books) {
            if(title.equals(book.title)) {
                return book;
            }
        }

        return null;
    }

    void removeBook(Book book) {
        books.remove(book);
    }

    ArrayList<Book> listBooks () {
        return books;
    }

    ArrayList<Book> listBooksByFantasyType () {
        //Create new array list to store books by fantasy type
        ArrayList<Book> fantasyBooks = new ArrayList<>();
        //loop through the books in bookstore and add any book that is of fantasy type to the new array list
        for (Book book: books) {
            if (book.genre == Genre.FANTASY) {
                fantasyBooks.add(book);
            }
        }
        //return the new array list when loop is completed
        return fantasyBooks;
    }

    ArrayList<Book> listBooksBefore1999() {
        ArrayList<Book> booklist = new ArrayList<>();

        //Loop through the books in the store and add any book published before 1999 to the arraylist created
        for (Book book: books) {
            if(book.yearOfRelease < 1999) {
                booklist.add(book);
            }
        }

        return booklist;
    }

    Book mostExpensive() {
        Book mostExpensiveBook = books.get(0);

        for(Book book: books) {
            if(book.price > mostExpensiveBook.price) {
                mostExpensiveBook = book;
            }
        }

        return mostExpensiveBook;
    }

    Book cheapestBook() {
        Book cheapestBookInStore = books.get(0);

        for(Book book: books) {
            if(book.price < cheapestBookInStore.price) {
                cheapestBookInStore = book;
            }
        }

        return cheapestBookInStore;
    }

    Book bookBy3Authors() {
        //Loop through all the books in the arraylist
        //Return any book that has 3 authors
        //Return null if no book does.
        for (Book book: books) {
            if(book.authorList.size() == 3) {
                return book;
            }
        }

        return null;
    }

//    ArrayList<Book> listOfSortedBooks() {
//        Collections.sort(books);
//
//        System.out.println(books);
//        return books;
//    }

    boolean verifyBook(Book book) {
        if(books.contains(book)){
            return true;
        } else {
            return false;
        }
    }

    ArrayList<Book> findBooksByAuthor (Author author) {
        ArrayList<Book> booksByProvidedAuthor = new ArrayList<>();

        //Loop through all books and check if provided author is among the authors for each book.if yes add the book to the new array list of books
        for (Book book: books) {
            if(book.authorList.contains(author)) {
                booksByProvidedAuthor.add(book);
            }
        }

        return booksByProvidedAuthor;
    }
}
