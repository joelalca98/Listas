import java.util.*;

//Es una clase que va a implementar el interfaz ProductManager
public class ProductManagerImpl implements ProductManager {

    HashMap<String, User> users;  //Elección de la estructura de datos
    Queue<Order> pendingOrders;
    List<Product> productList;

    public ProductManagerImpl (){
        this.productList = new LinkedList<>();
    }

    @Override
    public List<Product> getProductByPrize() {
     Collections.sort(this.productList, new Comparator<Product>() {
           @Override
            public int compare(Product o1, Product o2) {
    return Double.compare(o2.precio,o1.precio);
            }
        });
        return this.productList;
   }

    @Override
    public void newOrder(Order o) {

    }

    @Override
    public Order processOrder() {
        return null;
    }

    @Override
    public List<Order> getOrderByUser(String idUser) {
        return null;
    }

    @Override
    public List<Product> getProductBySales() {
        return null;
    }

    @Override
    public void addProduct(String id, String description, double precio) {
        Product p = new Product (id, description, precio);
        this.productList.add(p);
    }

    public static void main (String [] args){
        System.out.println("Hola");
        ProductManager pm = new ProductManagerImpl();
        pm.addProduct("Cafe", "blabla",2);
        pm.addProduct("Cafe con Leche", "muy caliente",1);
        pm.addProduct("Coca-Cola", "muy fria",3);

        List<Product> lista = pm.getProductByPrize();
        System.out.println(Arrays.asList(lista.toArray()));
    }
}