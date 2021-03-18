public class Product {

    double precio;
    String id;
    String description;
    public Product (String id, String description, double precio){
        this.id = id;
        this.description = description;
        this.precio = precio;
    }
    public String toString () {
        return id + " " + description + " " + precio;
    }
}
