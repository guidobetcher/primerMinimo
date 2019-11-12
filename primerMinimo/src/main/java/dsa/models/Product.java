package dsa.models;

public class Product {
    private String name;
    private double price;
    private int stock;
    private int sales;

    public Product(String n, double p, int s){
        this.setName(n);
        this.setPrice(p);
        this.setStock(s);
    }
    public Product() {

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

    public void setSales(int sales) { this.sales = sales; }

    public int getSales() { return sales; }

}

