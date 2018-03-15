package eshop.service.impl;

import eshop.dao.ProductDao;
import eshop.dao.impl.ProductDaoImpl;
import eshop.model.Product;
import eshop.service.ProductService;

import java.util.List;

/**
 * Service for Product
 *
 * @author Alexandr Shinkevich on 15/03/2018.
 */
public class ProductServiceImpl implements ProductService {

    private ProductDao productDao = new ProductDaoImpl();

    @Override
    public List<Product> getProductsByName(String name) {
        return productDao.getProductsByName(name);
    }
}
