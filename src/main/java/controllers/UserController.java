package controllers;

import entities.User;
import io.javalin.config.JavalinConfig;
import io.javalin.http.Context;
import services.UserService;

import java.util.List;

public class UserController {
    static UserService userService = new UserService();

    public static void setRoutes(JavalinConfig config){
        config.routes.post("/login", ctx -> login(ctx));
        config.routes.get("/finduser", ctx -> findUser(ctx));
        config.routes.post("/createuser", ctx -> createUser(ctx));
        config.routes.get("/myloans", ctx -> ctx.render("loans"));
        config.routes.get("/users", ctx -> {
            List<User> users = userService.getAllUsers();
            ctx.attribute("users", users);
            ctx.render("users");
        });
    }

    public static void createUser(Context ctx){
        String username = ctx.formParam("username");
        String password = ctx.formParam("password");

        User user = userService.createUser(username, password);
        if(user != null){
            ctx.sessionAttribute("user", user);
            ctx.render("welcome");
        }
        else{
            ctx.status(404);
            ctx.result("Brugeren kunne ikke oprettes");
        }
    }

    public static void findUser(Context ctx){
        String username = ctx.queryParam("username");
        User user = userService.getUser(username);
        if(user != null){
            ctx.attribute("user", user);
            ctx.render("userinfo");
        }
        else{
            ctx.status(404);
            ctx.result("Brugeren findes ikke");
        }
    }

    public static void login(Context ctx){
        String username = ctx.formParam("username");
        String password = ctx.formParam("password");

        User user = userService.login(username, password);
        if(user != null){
            ctx.sessionAttribute("user", user);
            ctx.render("welcome");
        }
        else{
            ctx.status(404);
            ctx.result("Brugeren findes ikke");
        }

    }




}
