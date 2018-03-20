package eshop.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Home controller
 */
public class HomeServlet extends HttpServlet {

    private static final long serialVersionUID = -3009993516674880490L;

    /**
     * forward the control to the index.html
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        why are we including the request and response objects when we forward the call?
        That's because, let's say the current resource wants to utilize request and response,
        the other resource where you're forwarding to, that may also need to use both of these objects
        for let's say extracting the request data, writing some more response, etc.
        So even if this login/home servlets were not doing anything with these objects,
        the next resource in line would definitely need these.
        That's exactly why the specification itself dictates that whenever you forward the control to another resource,
        make sure that the requested response objects always go along.
         */
        req.getRequestDispatcher("html/index.html").forward(req, resp);
    }
}
