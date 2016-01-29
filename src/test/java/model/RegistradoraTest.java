package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegistradoraTest {
    Produto produto;
    Registradora registradora;

    @Before
    public void setUp() throws Exception {
        produto = new Produto("produtoTeste", 1.00);
        registradora= new Registradora(produto,10);
    }

    @Test
    public void shouldReturnAProductInsideRegister() {
        assertSame(produto, registradora.getProduto());
    }

    @Test
    public void shouldReturnTheQuantityOfUnitSelled() {
        assertEquals(10,registradora.getQuantidadeVendida());
    }

    @Test
    public void shouldReturnTotalOfQuantitySelledWhenIsNotDefined() {
        assertEquals(0,registradora.getTotalQuantidadeVendida(), 0);
    }

    @Test
    public void shouldReturnTotalOfQuantitySelledWhenIsDefined() {
        registradora = new Registradora(produto,10,100);
        assertEquals(100,registradora.getTotalQuantidadeVendida(),100);
    }
}