public class Order {
    User user;
    Product[] products;
    public Order(Product[] products, User user){
        this.user = user;
        this.products = products;
    }

}
