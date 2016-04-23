package business;


import model.Product;
import model.Register;

import java.util.ArrayList;
import java.util.Collections;

public class Process {

    private int sumEqualProducts = 0;
    private double sumTotalValueSelled = 0;
    Register newRegister = null;
    Product newProduct = null;

    public void output(ArrayList<Register> register) {
        sortArray(register);
        compareNamesAndDeleteTheEquals(register);
        returnTotalSelledForEachProduct(register);

        register.forEach(r -> System.out.println("Nome do produto: " + r.getProduct().getProductName() +
                "\n Valor da unidade: R$" +
                r.getProduct().getUnitValue() +
                "\n Unidades Vendidas: " +
                r.getSelledQuantity() +
                "\n Total: R$" +
                r.getTotalSelledQuantity() +
                "\n")
        );

        System.out.println("Total do dia: " + getTotalOfDay(register));
    }

    public Double getTotalOfDay(ArrayList<Register> register) {
        final double[] total = {0};
        register.forEach(r -> total[0] += r.getProduct().getUnitValue() * r.getTotalSelledQuantity() );

        return total[0];
    }

    public void sortArray(ArrayList<Register> register) {
        Collections.sort(register, Register.nameComparator);
    }

    public void compareNamesAndDeleteTheEquals(ArrayList<Register> register) {

        for (int i = 0; i < register.size() - 1; i++) {
            if (register.get(i).getProduct().getProductName().equalsIgnoreCase(register.get(i + 1).getProduct().getProductName())) {
                sumEqualProducts = getSumOfEqualProducts(register.get(i).getSelledQuantity(), register.get(i + 1).getSelledQuantity());
                sumTotalValueSelled = getTotalOfEachProductSelled(register.get(i).getProduct().getUnitValue(), sumEqualProducts);
                newProduct = Product.builder().productName(register.get(i).getProduct().getProductName()).unitValue(register.get(i).getProduct().getUnitValue()).build();
                newRegister = Register.builder().product(newProduct).selledQuantity(sumEqualProducts).totalSelledQuantity(sumTotalValueSelled).build();
                register.set(i, newRegister);
                register.remove(i + 1);
                i--;
            }
        }
    }

    public void returnTotalSelledForEachProduct(ArrayList<Register> register) {

        for (int i = 0; i < register.size(); i++) {
            if (register.get(i).getTotalSelledQuantity() == 0) {
                sumTotalValueSelled = getTotalOfEachProductSelled(register.get(i).getProduct().getUnitValue(), register.get(i).getSelledQuantity());
                newProduct = Product.builder().productName(register.get(i).getProduct().getProductName()).unitValue(register.get(i).getProduct().getUnitValue()).build();
                newRegister = Register.builder().product(newProduct).selledQuantity(register.get(i).getSelledQuantity()).totalSelledQuantity(sumTotalValueSelled).build();
                register.set(i, newRegister);
            }
        }
    }

    public int getSumOfEqualProducts(int productSelledQuantity, int nextProductSelledQuantity) {
        return productSelledQuantity + nextProductSelledQuantity;
    }

    public double getTotalOfEachProductSelled(double valueOfProduct, int quantityOfProductSelled) {
        return valueOfProduct * quantityOfProductSelled;
    }

}
