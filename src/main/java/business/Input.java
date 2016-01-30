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
        Product product;
        Register register;
        String[] productInformation = line.split(";");
        product = new Product(productInformation[0], Double.parseDouble(productInformation[1]));
        register = new Register(product, Integer.parseInt(productInformation[2]));
        registerList.add(register);

        return registerList;
    }


}
