import java.util.Queue;

public interface ProductManager {
    /*Ordena los productos por precio (de menor a mayor)*/
    void sortPriceProducts (Product[] pList);
    /*Se añade a la cola de pedidos la comanda hecha por el usuario*/
    void newOrder (Product[] products, User user);
    /*Es atendido el pedido que toca (el mas antiguo)*/
    void serveOrder (Queue<Order> waitingOrders);
    /*Devuelve la lista de pedidos que se le han servido a un usuario*/
    Order listOrder(User user);
    /*Ordena los pedidos de mas vendido a menos*/
    void sortSellProducts (Product[] pList);
    void productList();
}
