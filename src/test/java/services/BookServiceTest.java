package services;

import entities.Book;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {

    @Test
    void findBookByISBN() {
    }

    @Test
    void getAllBooks() {
        BookService bookService = new BookService();
        List<Book> books = bookService.getAllBooks();
        assertEquals(100, books.size());
    }
}