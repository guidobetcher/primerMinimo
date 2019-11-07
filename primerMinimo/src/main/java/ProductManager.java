public interface ProductManager {
    void sortProducts (Product[] pList);
    void newOrder (Order order, User user);
    void serveOrder (Order[] waitingOrders);
    Order listOrder(User user);
    void productList();
}
