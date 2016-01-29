package business;


import model.Produto;
import model.Registradora;

import java.util.*;

public class Process {

    private int sumEqualProducts =0;
    private double sumTotalValueSelled = 0;

    public void output(ArrayList<Registradora> registradora) {
        sortArray(registradora);
        compareNames(registradora);
        returnTotalSelledForEachProduct(registradora);

        for (Registradora r : registradora) {
            System.out.println( "Nome do produto: "+ r.getProduto().getNomeProduto() + "\n Valor da unidade: R$" + r.getProduto().getValorUnidade() + "\n Unidades Vendidas: " + r.getQuantidadeVendida()+ "\n Total: R$"+ r.getTotalQuantidadeVendida()+ "\n");
        }
        System.out.println("Total do dia: "+getTotalOfDay(registradora));
    }

    public Double getTotalOfDay(ArrayList<Registradora> registradora) {
        double total = 0;
        for (Registradora r : registradora) {
            total += r.getProduto().getValorUnidade() * r.getQuantidadeVendida();
        }
            return total;
    }

    public void sortArray(ArrayList<Registradora> registradora) {
        Collections.sort(registradora, Registradora.nameComparator);
    }

    public void compareNames(ArrayList<Registradora> registradora) {
        Registradora registradoraNew = null;
        Produto produtoNew = null;

        for (int i = 0; i <registradora.size() -1 ; i++) {
                if ( registradora.get(i).getProduto().getNomeProduto().equalsIgnoreCase(registradora.get(i + 1).getProduto().getNomeProduto())) {
                    sumEqualProducts = getSumOfEqualProducts(registradora.get(i).getQuantidadeVendida(), registradora.get(i + 1).getQuantidadeVendida());
                    sumTotalValueSelled = getTotalOfEachProductSelled(registradora.get(i).getProduto().getValorUnidade(),sumEqualProducts);
                    produtoNew = new Produto(registradora.get(i).getProduto().getNomeProduto(), registradora.get(i).getProduto().getValorUnidade());
                    registradoraNew = new Registradora(produtoNew, sumEqualProducts, sumTotalValueSelled);
                    registradora.set(i, registradoraNew);
                    registradora.remove(i+1);
                    i--;
                }
        }
    }

    public void returnTotalSelledForEachProduct(ArrayList<Registradora> registradora ) {
        Registradora registradoraNew = null;
        Produto produtoNew = null;

        for (int i = 0; i < registradora.size(); i++) {
            if (registradora.get(i).getTotalQuantidadeVendida() == 0) {
                sumTotalValueSelled = getTotalOfEachProductSelled(registradora.get(i).getProduto().getValorUnidade(), registradora.get(i).getQuantidadeVendida());
                produtoNew = new Produto(registradora.get(i).getProduto().getNomeProduto(), registradora.get(i).getProduto().getValorUnidade());
                registradoraNew = new Registradora(produtoNew, registradora.get(i).getQuantidadeVendida(), sumTotalValueSelled);
                registradora.set(i, registradoraNew);
            }
        }
    }

    private int getSumOfEqualProducts(int product1, int product2) {
        return product1 + product2;
    }

    private double getTotalOfEachProductSelled(double valueOfProduct, int quantityOfProductSelled) {
        return valueOfProduct * quantityOfProductSelled;
    }

}
