package eshop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Login controller
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 7971796006583788777L;

    /**
     * forwarding to login page
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //dispatch the request to login.jsp resource

        String html = "<html><h3>Please login</h3></html>";
        resp.getWriter().write(html + " ");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/html/login.jsp");
        // whatever happens as a part of login JSP, it's going to combine together,
        // and it's going to get rendered to the client.
        dispatcher.include(req, resp);
    }

}
