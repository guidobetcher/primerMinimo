package dsa.main;

import dsa.models.Order;
import dsa.models.Product;
import dsa.models.User;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.logging.Logger;


public class ProductManagerImp implements ProductManager {
    /*Creamos la clase logger*/
    private static Logger log = Logger.getLogger(ProductManagerImp.class.getName());

    /* Creamos atributos privados para implementar Singleton */
    private List<Product> store;
    private Queue<Order> waitingOrders;
    private static ProductManagerImp instance=null;

    /*Constructor privado
    private ProductManagerImp(Product[] store, Queue<Order> waitingOrders) {
        this.setStore(store);
        this.setWaitingOrders(waitingOrders);
    }*/

    /*En SINGLETON ESTÁ VACÍO????*/
    public ProductManagerImp(){
    }

    /*El método de getInstance debe ser public*/
    public static ProductManagerImp getInstance(){
        if (instance==null) {
            instance=new ProductManagerImp();
        }
        return instance;
    }

    /*-------------------------------------------------------------------*/
    /*GETTER AND SETTER*/

    public List<Product> getStore() {

        return store;
    }

    public void setStore(List<Product> store) {

        this.store = store;
        log.info("Valor despues"+store.toString());
    }

    public Queue<Order> getWaitingOrders() {
        return waitingOrders;
    }

    public void setWaitingOrders(Queue<Order> waitingOrders) {
        this.waitingOrders = waitingOrders;
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
            return (int)(p.getSales()-o.getSales());
        }
    }

    @Override
    public int size() {
        return this.store.size();
    }

    public void sortPriceProducts(Product[] pList) { Arrays.sort(pList, new SortByPrice()); }

    public void newOrder(Product[] products, User user) {
        int cancellOrder = 0;
        /*Miro la disponibilidad de los productos*/
        for (Product p:
             products) {
            if (p.getStock() == 0){
                /*Se le dice que ese producto esta agotado*/
                cancellOrder = 1;
                break;
            }
            else{
                p.setStock(p.getStock() - 1);
            }
        }
        if(cancellOrder == 0) {
            /*El pedido se ha realizado correctamente*/
            Order order = new Order(products, user);
            this.waitingOrders.add(order);
        }
    }

    public void serveOrder() {
        Order servedOrder = this.waitingOrders.element();
        /*Le sumo una venta al producto y añado la orden al historial del usuario*/
        for (Product p:servedOrder.products) {
            p.setSales(p.getSales() + 1);
            User u = servedOrder.getUser();
            u.historyOrders.add(servedOrder);
        }
    }

    public List<Order> listOrder(User user) {
        List<Order> resList = null;
        for (Order o:user.historyOrders) {
            resList.add(o);
        }
        return resList;
    }

    public void sortSellProducts (Product[] pList) {Arrays.sort(pList, new SortBySells());}

    @Override
    public void addProduct(Product p0) {

    }

    public void addProduct(String name, double price, int cantidad) {
        Product p0 = new Product(name, price,cantidad);
        this.store.add(p0);
        log.info("Añadido nuevo producto"+this.store);
    }

    @Override
    public List<Product> findAll() {
        Product List<Product>
        return null;
    }



    /*-------------------------------------------------------------------*/

}