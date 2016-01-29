package business;

import model.Produto;
import model.Registradora;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.*;


public class InputTest {

    File file;
    Input input;
    Produto produto;
    Registradora registradora;
    ArrayList<Registradora> registerlist;


    @Before
    public void setUp() throws Exception {
        produto = new Produto("goiaba",2.00);
        registradora = new Registradora(produto,2);
        registerlist = new ArrayList<Registradora>();
        file = new File("src//test//resources//teste.txt");
        input = new Input();

        registerlist.add(registradora);


    }

    @Test
    public void testReadFile() throws Exception {
        ArrayList<Registradora> registerTest = input.readFile(file);
        assertEquals(registerlist.get(0).getProduto().getNomeProduto(),registerTest.get(0).getProduto().getNomeProduto());
        assertEquals(registerlist.get(0).getProduto().getValorUnidade(),registerTest.get(0).getProduto().getValorUnidade(), 2);
        assertEquals(registerlist.get(0).getQuantidadeVendida(),registerTest.get(0).getQuantidadeVendida());
    }

    @Test
    public void shouldSplitAListAndReturnAnArrayList() throws Exception {
        String line = "goiaba;2;2";
        ArrayList<Registradora> registerTest = input.splitLine(line);

        assertEquals(registerlist.get(0).getProduto().getNomeProduto(),registerTest.get(0).getProduto().getNomeProduto());
        assertEquals(registerlist.get(0).getProduto().getValorUnidade(),registerTest.get(0).getProduto().getValorUnidade(), 2);
        assertEquals(registerlist.get(0).getQuantidadeVendida(),registerTest.get(0).getQuantidadeVendida());
    }
}