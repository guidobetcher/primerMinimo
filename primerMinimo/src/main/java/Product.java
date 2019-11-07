
 class Product implements Comparable<Product>{
    private String name;
    private double price;
    private int stock;


    public Product(String nom, double preu, int cantitat){
        this.setName(nom);
        this.setPrice(preu);
        this.setStock(cantitat);
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

    public int compareTo(Product p){
        return (int) (this.price-p.price);
    }
}
