public interface ProductManager {

    //Listado ordenado ascendente de productos por precio
    void sortProducts (Product[] pList);

    //Realiza un nuevo pedido asociado a un usuario
    void newOrder (Order order, User user);

    //Sirve el pedido, es una cola?
    void serveOrder (Order[] waitingOrders);

    //Listado de pedidos que han sido realizados
    //Debe haber un historico de pedidos
    Order listOrder(User user);

    //Listado de productos ordenado de mas a menos ventas
    void productList();
}
