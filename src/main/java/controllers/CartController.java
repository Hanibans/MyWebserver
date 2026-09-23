package controllers;

import entities.Book;
import entities.User;
import io.javalin.config.JavalinConfig;
import io.javalin.http.Context;
import services.BookService;

public class CartController {
    private static BookService bookService = new BookService();

    public static void setRoutes(JavalinConfig config) {
        config.routes.post("/cart/add", ctx -> addBookToCart(ctx));
    }

    private static void addBookToCart(Context ctx) {
        String isbn = ctx.formParam("isbn");
        Book book = bookService.findBookByISBN(isbn);
        User user = ctx.sessionAttribute("user");
        user.addToCart(book);
        ctx.render("books");
    }


}
