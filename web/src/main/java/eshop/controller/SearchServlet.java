package eshop.controller;

import eshop.model.Product;
import eshop.service.ProductService;
import eshop.service.impl.ProductServiceImpl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Search controller
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    private static final long serialVersionUID = -3819705083311959856L;

    /**
     * Search products
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //collect search string from the form
        String searchString = req.getParameter("search");


        //call Service layer and get all products for search criteria
        ProductService productService = new ProductServiceImpl();
        List<Product> productList = productService.getProductsByName(searchString);
        if (productList.size() > 0) {
            System.out.println("more than zero");
        }
        //write the products data back to the client browser

    }

}
