package com.marnes.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Book {
    private String title;
    private String author;
    private String userRating;
    private String reviews;
    private String price;
    private String year;
    private String genre;

    // Constructor
    public Book(String title, String author, String userRating, String reviews, String price, String year, String genre) {
        this.title = title;
        this.author = author;
        this.userRating = userRating;
        this.reviews = reviews;
        this.price = price;
        this.year = year;
        this.genre = genre;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getUserRating() {
        return userRating;
    }

    public String getReviews() {
        return reviews;
    }

    public String getPrice() {
        return price;
    }

    public String getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    // Method to print book details
    public void printDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("User Rating: " + userRating);
        System.out.println("Reviews: " + reviews);
        System.out.println("Price: $" + price);
        System.out.println("Year: " + year);
        System.out.println("Genre: " + genre);
        System.out.println(); // Add a newline for better readability between books
    }

    public int numberOfBookByAuthor(List<Book> livros, String author) {
        int count = 0;

        for (Book book : livros) {
            if(book.getAuthor().equals(author)) {
                count++;
            }
        }
        return count;
    }

    public List<String> getAllAuthors(List<Book> books) {
        List<String> authorExists = new ArrayList<>();

        for (Book book : books) {
            String authors = book.getAuthor();
            if (!authorExists.contains(authors)) {
                authorExists.add(book.author);
            }
        }

        return authorExists;
    }

    public List<String> getBooksByAuthor(List<Book> books, String author) {
        List<String> booksOfAuthor = new ArrayList<>();

        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                if (!booksOfAuthor.contains(title)) {
                    booksOfAuthor.add(book.title);
                }
            }
        }

        return booksOfAuthor;
    }

    public List<String> getBooksByUserRating(List<Book> books, String userRating) {
        List<String> booksUserRating = new ArrayList<>();

        for (Book book : books) {
            if (book.getUserRating().equals(userRating)) {
                String title = book.getTitle();
                String author = book.getAuthor();
                String rating = book.getUserRating();
                booksUserRating.add(title + " de " + author + " avaliação de usuario: " + rating);
            }
        }

        return booksUserRating;
    }

    public List<String> booksWithPrice(List<Book> books, String author) {
        List<String> booksPrice = new ArrayList<>();

        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                String title = book.getTitle();
                String price = book.getPrice();
                booksPrice.add(title + " - " + price);

            }
        }

        return booksPrice;
    }
}