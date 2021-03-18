import java.util.List;

public interface ProductManager {

    public List<Product> getProductByPrize(); // Listado de productos ordenados ascendientemente
    public void newOrder (Order o); //Realizar un pedido
    public Order processOrder(); //Servir un pedido
    public List<Order> getOrderByUser (String idUser); //Listado de productos de un usuario
    public List<Product> getProductBySales(); //Listado e productos ordenados descendientemente
    public void addProduct (String id, String description, double precio);




}
