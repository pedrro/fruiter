package business;

import model.Product;
import model.Register;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.*;


public class InputTest {

    File file;
    Input input;
    Product product;
    Register register;
    ArrayList<Register> registerlist;


    @Before
    public void setUp() throws Exception {
        product = new Product("goiaba",2.00);
        register = new Register(product,2);
        registerlist = new ArrayList<Register>();
        file = new File("src//test//resources//teste.txt");
        input = new Input();

        registerlist.add(register);


    }

    @Test
    public void testReadFile() throws Exception {
        ArrayList<Register> registerTest = input.readFile(file);
        assertEquals(registerlist.get(0).getProduct().getProductName(),registerTest.get(0).getProduct().getProductName());
        assertEquals(registerlist.get(0).getProduct().getUnitValue(),registerTest.get(0).getProduct().getUnitValue(), 2);
        assertEquals(registerlist.get(0).getSelledQuantity(),registerTest.get(0).getSelledQuantity());
    }

    @Test
    public void shouldSplitAListAndReturnAnArrayList() throws Exception {
        String line = "goiaba;2;2";
        ArrayList<Register> registerTest = input.splitLine(line);

        assertEquals(registerlist.get(0).getProduct().getProductName(),registerTest.get(0).getProduct().getProductName());
        assertEquals(registerlist.get(0).getProduct().getUnitValue(),registerTest.get(0).getProduct().getUnitValue(), 2);
        assertEquals(registerlist.get(0).getSelledQuantity(),registerTest.get(0).getSelledQuantity());
    }
}