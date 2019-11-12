
import dsa.models.Product;
import dsa.main.ProductManagerImp;
import org.junit.Before;
import org.junit.Test;
import java.util.LinkedList;
import java.util.List;

public class TestInit {
    @Before
    @Test
    public void setUp(){
        //ProductManagerImp p1 = new ProductManagerImp().getInstance();
        ProductManagerImp p1 = new ProductManagerImp();

        //dsa.models.Product[]store; dsa.models.Order[] historyOrder; dsa.models.Product[] sales;

        /*El listado de productos tiene que ser una lista para poder poder add*/
        List<Product> listadoProductos = null;
        Product productoprueba = null;

        p1.addProduct("Caña de pescar", 14.6, 10);

        p1.addProduct("Mapa", 10, 2);

        p1.addProduct("Botas de agua", 25.5879,1);


    }

}
