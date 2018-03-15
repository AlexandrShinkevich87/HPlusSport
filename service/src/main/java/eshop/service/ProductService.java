package eshop.service;

import eshop.model.Product;

import java.util.List;

/**
 * Service for Product
 *
 * @author Alexandr Shinkevich on 15/03/2018.
 */
public interface ProductService {
    /**
     * Return products by name.
     * @param name product name
     * @return List of products
     */
    List<Product> getProductsByName(String name);
}
