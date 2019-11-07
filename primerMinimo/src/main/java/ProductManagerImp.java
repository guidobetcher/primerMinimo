
import java.util.*;
import java.util.logging.Logger;

public class ProductManagerImp implements ProductManager {
    //private static Logger log = Logger.getLogger(String.valueOf(ProductManagerImp.class));

    private static Logger log = Logger.getLogger(ProductManagerImp.class.getName());

    /* Creamos atributos privados para implementar Singleton */
    private List<Product> store;
    private List<Order> pedidos;
    private List<Order> historyOrder;
    private Product[] sales;

    private static ProductManagerImp instance;

    /*Constructor privado*/
    private ProductManagerImp(List<Product> store, Order[] historyOrder, Product[] sales) {
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

    public void setHistoryOrder(List<Order> historyOrder) {
        this.historyOrder = historyOrder;
    }

    public static void setInstance(ProductManagerImp instance) {
        ProductManagerImp.instance = instance;
    }

    public List<Product> getStore() {

        return store;
    }

    public void setStore(List<Product> store) {

        this.store = store;
        //log.info(store.toString());
    }

    public List<Order> getHistoryOrder() {
        return historyOrder;
    }

    public void setHistoryOrder(Order[] historyOrder) {
        this.historyOrder = Arrays.asList(historyOrder);
    }

    public Product[] getSales() {
        return sales;
    }

    public void setSales(Product[] sales) {
        this.sales = sales;
    }

    /*-------------------------------------------------------------------*/
    /*MÉTODOS*/

    public List<Product> sortProducts() {
        //Rehusado del Company Manager
        List pList = new LinkedList<Product>();
        pList.addAll(this.store);

        //PODEMOS METER UN MENSAJE EN E MISMO COMANDO?
        log.info(pList.toString());
        log.info(pList);
        Collections.sort(pList);
        return pList;
    }

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