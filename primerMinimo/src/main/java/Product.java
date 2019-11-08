import java.util.Comparator;

public class Product {
    private String name;
    private double price;
    private int stock;
    private int sells;

    public Product(String n, double p, int s){
        this.setName(n);
        this.setPrice(p);
        this.setStock(s);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setSells(int sells) { this.sells = sells; }

    public int getSells() { return sells; }

}

