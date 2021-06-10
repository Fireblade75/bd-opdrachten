package nl.firepy.basicwebapp.servlets;


import nl.firepy.basicwebapp.model.User;
import nl.firepy.basicwebapp.services.UserManager;

import javax.json.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;


public class BasicServlet extends HttpServlet {

    private static final long serialVersionUID = 6189274384209501437L;

    @Inject
    UserManager userManager;

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JsonArray userList = userManager.getUsers().stream()
                .map(User::toJson)
                .collect(Json::createArrayBuilder, JsonArrayBuilder::add, JsonArrayBuilder::addAll)
                .build();

        JsonObject object = Json.createObjectBuilder().add("users", userList).build();
        resp.setHeader("Content-Type", "application/json");
        resp.getOutputStream().println(object.toString());
        resp.setStatus(200);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JsonObject userObj = Json.createReader(req.getInputStream()).readObject();
        userManager.addUser(new User(userObj));
        resp.setStatus(201);
    }
}
