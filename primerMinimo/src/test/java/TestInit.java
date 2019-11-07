import org.junit.Before;
import org.junit.Test;
import java.util.LinkedList;
import java.util.List;

public class TestInit {

    @Before
    @Test
    public void setUp(){
        ProductManagerImp p1 = new ProductManagerImp().getInstance();

        //Product[]store; Order[] historyOrder; Product[] sales;
        List<Product> listadoProductos = new LinkedList<Product>();
        Product productoprueba = null;

        productoprueba = new Product("Caña de pescar", 14.6, 10);
        listadoProductos.add(productoprueba);

        productoprueba = new Product("Mapa", 10, 2);
        listadoProductos.add(productoprueba);

        productoprueba = new Product("Botas de agua", 25.5879,1);
        listadoProductos.add(productoprueba);

        p1.setStore(listadoProductos);
        p1.sortProducts();

    }

}
