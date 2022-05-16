package com.company;

import java.util.ArrayList;

public class Book {
    String title;
    double price;
    int yearOfRelease;
    ArrayList<Author> authorList;
    Genre genre;

    Book(String title, double price, int yearOfRelease, Genre genre){
        this.title = title;
        this.price = price;
        this.yearOfRelease = yearOfRelease;
        this.genre = genre;
        this.authorList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", yearOfRelease=" + yearOfRelease +
                ", authorList=" + authorList +
                ", genre=" + genre +
                '}';
    }



}
