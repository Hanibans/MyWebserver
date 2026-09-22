package factories;

import entities.Author;
import entities.Book;

import java.util.ArrayList;
import java.util.List;

public class BookFactory {

    public static List<Book> createBooks() {

        List<Book> books = new ArrayList<>();

        Author rowling = new Author("J.K. Rowling");
        Author orwell = new Author("George Orwell");
        Author austen = new Author("Jane Austen");
        Author tolkien = new Author("J.R.R. Tolkien");
        Author dickens = new Author("Charles Dickens");
        Author leGuin = new Author("Ursula K. Le Guin");
        Author asimov = new Author("Isaac Asimov");
        Author christie = new Author("Agatha Christie");
        Author shelley = new Author("Mary Shelley");
        Author twain = new Author("Mark Twain");

        Author[] authors = {
                rowling,
                orwell,
                austen,
                tolkien,
                dickens,
                leGuin,
                asimov,
                christie,
                shelley,
                twain
        };

        String[] titles = {
                "The Lost Garden",
                "The Last Kingdom",
                "The Silent House",
                "The Hidden Door",
                "The Long Road",
                "The Forgotten City",
                "The Secret Island",
                "The Empty Room",
                "The Dark Forest",
                "The Winter Garden"
        };

        for (int i = 0; i < 100; i++) {

            String title = titles[i % titles.length] + " " + (i + 1);
            Author author = authors[i % authors.length];

            Book book = new Book(
                    title,
                    "ISBN-" + (1000 + i),
                    author
            );

            books.add(book);
        }

        return books;
    }
}