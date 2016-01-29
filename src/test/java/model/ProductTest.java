package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class ProductTest {

    Product product;
    @Before
    public void setUp() throws Exception {
        product = new Product("produtoTeste", 1.00);

    }

    @Test
    public void shouldReturnNameOfProduct() {
        assertEquals("produtoTeste", product.getProductName());
    }

    @Test
    public void shouldReturnPriceOfProduct() {
        assertEquals(1.00, product.getUnitValue(),1.00);
    }
}