package dsa.models;

public class Order {
    public User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Product[] products;
    double orderPrice;

    public Order(Product[] products, User user){
        this.user = user;
        this.products = products;
        for (Product p:products) {
            this.orderPrice =+ p.getPrice();
        }
    }

}
