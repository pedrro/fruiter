package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegistradoraTest {
    Product product;
    Register register;

    @Before
    public void setUp() throws Exception {
        product = new Product("produtoTeste", 1.00);
        register= new Register(product,10);
    }

    @Test
    public void shouldReturnAProductInsideRegister() {
        assertSame(product, register.getProduct());
    }

    @Test
    public void shouldReturnTheQuantityOfUnitSelled() {
        assertEquals(10,register.getSelledQuantity());
    }

    @Test
    public void shouldReturnTotalOfQuantitySelledWhenIsNotDefined() {
        assertEquals(0,register.getTotalSelledQuantity(), 0);
    }

    @Test
    public void shouldReturnTotalOfQuantitySelledWhenIsDefined() {
        register = new Register(product,10,100);
        assertEquals(100,register.getTotalSelledQuantity(),100);
    }
}