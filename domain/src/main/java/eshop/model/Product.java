package eshop.model;

/**
 * Class contains information about product.
 */
public class Product {
    private int id;
    private String name;
    private String imgPath;

    /**
     * Instantiates a new Product.
     */
    public Product() {
    }

    /**
     * Instantiates a new Product.
     * @param id the id of product
     * @param name the name of product
     */
    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }


    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the id
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets path to image by product
     * @return path
     */
    public String getImgPath() {
        return imgPath;
    }

    /**
     * Sets path
     * @param imgPath the path
     */
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
}
