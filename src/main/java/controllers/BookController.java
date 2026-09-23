package controllers;

import entities.Book;
import io.javalin.config.JavalinConfig;
import io.javalin.http.Context;
import services.BookService;

import java.util.List;

public class BookController {
    private static BookService bookService = new BookService();

    public static void setRoutes(JavalinConfig config) {
        config.routes.post("/books", ctx -> showAllBooks(ctx));
    }

    private static void showAllBooks(Context ctx) {
        List<Book> books = bookService.getAllBooks();
        ctx.attribute("books", books);
        ctx.render("books");
    }
}
