package services;

import entities.Book;
import entities.Library;

import java.util.List;

public class BookService {

    private Library library = Library.getInstance();

    public Book findBookByISBN(String isbn) {
        for (Book book: library.getBooks()) {
            if (book.getIsbn().equals(isbn))
                return book;
        }
        return null;
    }

    public List<Book> getAllBooks() {
        return library.getBooks();
    }
}
