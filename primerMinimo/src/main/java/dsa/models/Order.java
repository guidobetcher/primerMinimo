package dsa.models;

public class Order {
    public User user;
    public Product[] products;
    public double orderPrice;
    public Order(Product[] products, User user){
        this.user = user;
        this.products = products;
        for (Product p:products) {
            this.orderPrice =+ p.getPrice();
        }
    }

}
