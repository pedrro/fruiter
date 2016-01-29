package business;

import model.Product;
import model.Register;
import org.junit.Before;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class ProcessTest {

    Product product;
    Register register;
    ArrayList<Register> registerArrayList;


    @Before
    public void setUp() throws Exception {
        product = new Product("goiaba",2.00);
        register = new Register(product,2);
        registerArrayList = new ArrayList<Register>();
    }
}