package business;

import model.Product;
import model.Register;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class ProcessTest {

    Product p1, p2, p3, p4;
    Register r1, r2, r3, r4;
    ArrayList<Register> registerArrayList;
    Process process;


    @Before
    public void setUp() throws Exception {
        p1 = new Product("goiaba", 2.00);
        p2 = new Product("abacaxi", 2.00);
        p3 = new Product("limão", 2.00);
        p4 = new Product("GOIABA", 2.00);

        r1 = new Register(p1, 2);
        r2 = new Register(p2, 2);
        r3 = new Register(p3, 2);
        r4 = new Register(p4, 2);

        registerArrayList = new ArrayList<Register>();
        registerArrayList.add(r1);
        registerArrayList.add(r2);
        registerArrayList.add(r3);
        registerArrayList.add(r4);

        process = new Process();
    }

    @Test
    public void shouldReturnTheTotalOfSalesOfTheDay() {
        assertEquals(16, process.getTotalOfDay(registerArrayList), 16);
    }

    @Test
    public void shouldReturnTheTotalOfQuantitySelledForEqualProduct() {
        int totalSelled = process.getSumOfEqualProducts(2, 3);
        assertEquals(5, totalSelled);
    }

    @Test
    public void shouldReturnTotalOfEachProductSelled() {
        double totalProductSelled = process.getTotalOfEachProductSelled(2.00, 5);
        assertEquals(10, totalProductSelled, 10);
    }

    @Test
    public void shouldSortTheArrayByNameOfProduct() {
        ArrayList<String> productName = new ArrayList<String>();
        productName.add("abacaxi");
        productName.add("goiaba");
        productName.add("GOIABA");
        productName.add("limão");
        process.sortArray(registerArrayList);
        assertEquals(productName.get(0), registerArrayList.get(0).getProduct().getProductName());
        assertEquals(productName.get(1), registerArrayList.get(1).getProduct().getProductName());
        assertEquals(productName.get(2), registerArrayList.get(2).getProduct().getProductName());
        assertEquals(productName.get(3), registerArrayList.get(3).getProduct().getProductName());

    }

    @Test
    public void shouldCompareTheEqualNameAndDelete() {
        process.sortArray(registerArrayList);
        process.compareNamesAndDeleteTheEquals(registerArrayList);

        ArrayList<String> arrayToCompare = new ArrayList<String>();
        arrayToCompare.add("abacaxi");
        arrayToCompare.add("goiaba");
        arrayToCompare.add("limão");

        assertEquals(arrayToCompare.get(2), registerArrayList.get(2).getProduct().getProductName());
    }

}