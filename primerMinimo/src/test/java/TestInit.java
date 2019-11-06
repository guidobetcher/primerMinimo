import org.junit.Test;

public class TestInit {
    @Test
    public void setUp(){
        //Product[]store; Order[] historyOrder; Product[] sales;
        Product product1 = new Product("nombre", 14.6, 10);
        Product product2 = new Product("nombre", 15.6, 10);
        Product[] listaStock = new Product[2];
        listaStock[0] = product1;
        listaStock[1] = product2;
        ProductManagerImp p1 = new ProductManagerImp().getInstance();
        p1.setStore(listaStock);

    }
}
