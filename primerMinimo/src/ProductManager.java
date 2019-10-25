public interface ProductManager {
    void sortProducts (Product[] pList);
    void newOrder (Order order);
    void serveOrder (Order[] waitingOrders);
}
