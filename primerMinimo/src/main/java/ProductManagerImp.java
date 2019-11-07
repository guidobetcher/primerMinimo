import java.util.Arrays;
import java.util.logging.Logger;

public class ProductManagerImp implements ProductManager {
    //private static Logger log = Logger.getLogger(String.valueOf(ProductManagerImp.class));

    private static Logger log = Logger.getLogger(ProductManagerImp.class.getName());

    /* Creamos atributos privados para implementar Singleton */
    private Product[] store;
    private Order[] historyOrder;
    private Product[] sales;

    private static ProductManagerImp instance;

    /*Constructor privado*/
    private ProductManagerImp(Product[]store, Order[] historyOrder, Product[] sales) {
        this.setStore(store);
        this.setHistoryOrder(historyOrder);
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

    public Order[] getHistoryOrder() {
        return historyOrder;
    }

    public void setHistoryOrder(Order[] historyOrder) {
        this.historyOrder = historyOrder;
    }

    public Product[] getSales() {
        return sales;
    }

    public void setSales(Product[] sales) {
        this.sales = sales;
    }

    /*-------------------------------------------------------------------*/
    /*MÉTODOS*/

    public void sortProducts(Product[] pList) {

    }

    public void newOrder(Order order, User user) {

    }

    public void serveOrder(Order[] waitingOrders) {

    }

    public Order listOrder(User user) {
        return null;
    }

    public void productList() {

    }

    /*-------------------------------------------------------------------*/

}