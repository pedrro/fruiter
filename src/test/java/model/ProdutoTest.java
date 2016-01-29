package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class ProdutoTest {
    Produto produto;
    @Before
    public void setUp() throws Exception {
        produto = new Produto("produtoTeste", 1.00);

    }

    @Test
    public void shouldReturnNameOfProduct() {
        assertEquals("produtoTeste", produto.getNomeProduto());
    }

    @Test
    public void shouldReturnPriceOfProduct() {
        assertEquals(1.00, produto.getValorUnidade(),1.00);
    }
}