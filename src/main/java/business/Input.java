package business;

import model.Produto;
import model.Registradora;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Input {

    public ArrayList<Registradora> registradoraList = new ArrayList<Registradora>();

    public ArrayList<Registradora> readFile(File file) throws FileNotFoundException {

        Scanner scanner = new Scanner(file);

        while(scanner.hasNextLine()) {
            splitLine(scanner.nextLine());
        }
        scanner.close();
        return registradoraList;
    }

    public ArrayList<Registradora> splitLine(String line) {
        Produto produto;
        Registradora registradora;
        String[] productInformation = line.split(";");
        produto = new Produto(productInformation[0],Double.parseDouble(productInformation[1]));
        registradora = new Registradora(produto,Integer.parseInt(productInformation[2]));
        registradoraList.add(registradora);

        return registradoraList;
    }


}
