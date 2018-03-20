package eshop.controller;

import eshop.model.User;
import eshop.service.UserService;
import eshop.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.stream.Stream;

/**
 * Controller for user register
 */
@WebServlet("/registerUser")
public class RegisterUserServlet extends HttpServlet {

    private static final long serialVersionUID = -5506160903496813336L;

    /**
     * Register a user
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // collect all form data
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String firstName = req.getParameter("fname");
        String lastName = req.getParameter("lname");
        String activity = req.getParameter("activity");
        int age = Integer.parseInt(req.getParameter("age"));


        // fill it up in a User bean
        User user = new User(username, password, firstName, lastName, age, activity);

        System.out.println(user);
        // call Service layer and save the user object to DB
        UserService userService = new UserServiceImpl();
        int rows = userService.registerUser(user);

        // prepare an information message for user about the success or failure of the operation
        String infoMessage = null;
        if (rows == 0) {
            infoMessage = "Sorry, an error occurred!";
        } else {
            infoMessage = "User registered successfully!";
        }

        // write the message back to the page in client browser\
        String page = getHTMLString(req.getServletContext().getRealPath("/html/register.html"), infoMessage);
        resp.getWriter().write(page);
    }

    /**
     * change placeholder in a static text
     *
     * @param filePath
     * @param message
     * @return
     * @throws IOException
     */
    private String getHTMLString(String filePath, String message) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {

            StringBuilder buffer = new StringBuilder();
            stream.forEach(buffer::append);

            String page = buffer.toString();

            page = MessageFormat.format(page, message);

            return page;
        }
    }

    /**
     * prepare static page
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = getHTMLString(req.getServletContext().getRealPath("/html/register.html"), "");
        resp.getWriter().write(page);
    }

}
