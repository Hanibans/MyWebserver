import controllers.UserController;
import io.javalin.rendering.template.JavalinThymeleaf;
import io.javalin.Javalin;

public class Main {
    public static void main(String[] args) {

        var app = Javalin.create(config -> {
            UserController.setRoutes(config);
            config.staticFiles.add("/public");
            config.fileRenderer(new JavalinThymeleaf());
        }).start(7070);
    }
}