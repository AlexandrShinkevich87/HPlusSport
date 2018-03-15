package eshop.dao;

import eshop.model.Product;

import java.util.List;

/**
 * Retrieves products
 * from the DataBase.
 *
 * @author Alexandr Shinkevich on 15/03/2018.
 */
public interface ProductDao {
    /**
     * Return products by name.
     * @param name product name
     * @return List of products
     */
    List<Product> getProductsByName(String name);
}
