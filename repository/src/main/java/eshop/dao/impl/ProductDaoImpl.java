package eshop.dao.impl;

import eshop.dao.DBConnection;
import eshop.dao.ProductDao;
import eshop.model.Product;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Product dao.
 *
 * @author Alexandr Shinkevich on 15/03/2018.
 */
public class ProductDaoImpl implements ProductDao {

    @Override
    public List<Product> getProductsByName(String name) {
        Product product = null;
        List<Product> products = new ArrayList<>();

        try (Connection connection = DBConnection.getConnectionToDatabase()) {

            String query = "select * from products where product_name like ?";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, "'%" + name + "%'");

                try (ResultSet set = statement.executeQuery(query)) {


                    while (set.next()) {
                        product = new Product();
                        product.setId(set.getInt("product_id"));
                        product.setImgPath(set.getString("image_path"));
                        product.setName(set.getString("product_name"));
                        products.add(product);

                    }
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return products;
    }
}
