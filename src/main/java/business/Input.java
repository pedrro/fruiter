package business;

import model.Product;
import model.Register;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Input {

    public ArrayList<Register> registerList = new ArrayList<Register>();

    public ArrayList<Register> readFile(File file) throws FileNotFoundException {

        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            splitLine(scanner.nextLine());
        }
        scanner.close();
        return registerList;
    }

    public ArrayList<Register> splitLine(String line) {
        Product product = null;
        Register register = null;
        String[] productInformation = line.split(";");
        product = Product.builder().productName(productInformation[0]).unitValue(Double.parseDouble(productInformation[1])).build();
        register = Register.builder().product(product).selledQuantity(Integer.parseInt(productInformation[2])).build();
        registerList.add(register);

        return registerList;
    }


}
