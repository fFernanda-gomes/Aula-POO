package com.marnes.src;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String [] args) {
        DatasetReader booksFromCSV = new DatasetReader();
        List<Book> books = booksFromCSV.readDataset("src/data.csv");

        Book book = new Book(null, null, null, null, null, null, null);

        String rowling = "J.K. Rowling";
        String martin = "George R. R. Martin";
        String rating = "4.2";
        int qtd = 0;

        for(Book jk: books) {
            qtd = jk.numberOfBookByAuthor(books, rowling);
        }
        System.out.println("Número total de livros de " + rowling + ": " + qtd);

        System.out.println("\n\n List of authors: ");
        List<String> authors = book.getAllAuthors(books);
        for (String author : authors) {
            System.out.println(author);
        }

        System.out.println("\n\n Books by authors: ");
        List<String> booksByAuthor = book.getBooksByAuthor(books, rowling);
        for (String bookTitle : booksByAuthor) {
            System.out.println(bookTitle);
        }

        System.out.println("\n\n Books by user rating: ");
        List<String> booksByUserRating = book.getBooksByUserRating(books, rating);
        for (String bookUserRating: booksByUserRating) {
            System.out.println(bookUserRating);
        }

        System.out.println("\n\n Books with prices: ");
        List<String> booksWithPrices = book.booksWithPrice(books, martin);
        for (String bookInfo : booksWithPrices) {
            System.out.println(bookInfo);
        }
    }
}
