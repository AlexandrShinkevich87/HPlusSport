package eshop.controller;

import eshop.model.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controller for user register
 */
@WebServlet("/registerUser")
public class RegisterUserServlet extends HttpServlet {

    private static final long serialVersionUID = -5506160903496813336L;

    /**
     * Register a user
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
        // call DAO layer and save the user object to DB


        // prepare an information message for user about the success or failure of the operation

        // write the message back to the page in client browser
    }

}
