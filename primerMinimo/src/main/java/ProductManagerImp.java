import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;
import java.util.logging.Logger;

public class ProductManagerImp implements ProductManager {
    //private static Logger log = Logger.getLogger(String.valueOf(ProductManagerImp.class));

    private static Logger log = Logger.getLogger(ProductManagerImp.class.getName());

    /* Creamos atributos privados para implementar Singleton */
    private Product[] store;
    private Queue<Order> waitingOrders;
    private Product[] sales;

    private static ProductManagerImp instance;

    /*Constructor privado*/
    private ProductManagerImp(Product[]store, Queue<Order> waitingOrders, Product[] sales) {
        this.setStore(store);
        this.setWaitingOrders(waitingOrders);
        this.setSales(sales);
    }

    /*En SINGLETON ESTÁ VACÍO????*/
    protected ProductManagerImp(){
    }

    /*El método de getInstance debe ser public*/
    public static ProductManagerImp getInstance(){
        if (instance==null) instance=new ProductManagerImp();
        return instance;
    }

    /*-------------------------------------------------------------------*/
    /*GETTER AND SETTER*/

    public Product[] getStore() {

        return store;
    }

    public void setStore(Product[] store) {

        this.store = store;
        log.info(Arrays.toString(store));
    }

    public Queue<Order> getWaitingOrders() {
        return waitingOrders;
    }

    public void setWaitingOrders(Queue<Order> waitingOrders) {
        this.waitingOrders = waitingOrders;
    }

    public Product[] getSales() {
        return sales;
    }

    public void setSales(Product[] sales) {
        this.sales = sales;
    }

    /*-------------------------------------------------------------------*/
    /*MÉTODOS*/
    class SortByPrice implements Comparator<Product> {
        public int compare(Product o, Product p)  {
            return (int)(p.getPrice()-o.getPrice());
        }
    }
    class SortBySells implements Comparator<Product> {
        public int compare(Product o, Product p)  {
            return (int)(p.getSells()-o.getSells());
        }
    }

    public void sortPriceProducts(Product[] pList) { Arrays.sort(pList, new SortByPrice()); }

    public void newOrder(Product[] products, User user) {
        Order order = new Order(products, user);
        this.waitingOrders.add(order);
    }

    public void serveOrder(Queue<Order> waitingOrders) {
        Order servedOrder = waitingOrders.element();
        /*Le sumo una venta al producto*/
        for (Product p:servedOrder.products) {p.setSells(p.getSells() + 1);}
    }

    public Order listOrder(User user) {
        return null;
    }

    public void sortSellProducts (Product[] pList) {Arrays.sort(pList, new SortBySells());}

    public void productList() {

    }


    /*-------------------------------------------------------------------*/

}