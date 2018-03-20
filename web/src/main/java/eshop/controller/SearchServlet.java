package eshop.controller;

import eshop.model.Product;
import eshop.service.ProductService;
import eshop.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Stream;

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
        String page = getHTMLString(req.getServletContext().getRealPath("/html/searchResults.html"), productList);
        resp.getWriter().write(page);

    }

    /**
     * this methods reads the HTML template as a String, replaces placeholders
     * with the values and returns the entire page as a String
     *
     * @param filePath file path
     * @param products products for replacing
     * @return the entire page as a String
     * @throws IOException exception
     */
    public String getHTMLString(String filePath, List<Product> products) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            StringBuffer buffer = new StringBuffer();
            stream.forEach(line -> {
                buffer.append(line);
            });

            String page = buffer.toString();

            page = MessageFormat.format(page, products.get(0).getImgPath(),
                    products.get(1).getImgPath(), products.get(2).getImgPath(),
                    products.get(0).getName(), products.get(1).getName(),
                    products.get(2).getName(), 0);

            return page;
        }
    }
}
