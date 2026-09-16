import io.javalin.Javalin;

public class Main {

    public static void main(String[] args) {

        var app = Javalin.create(config -> {
            config.routes.get("/", ctx -> ctx.result("Hej verden"));
        }).start(7070);
    }
}