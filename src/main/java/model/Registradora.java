package model;

import java.util.Comparator;

public class Registradora {

    private Produto produto;
    private int quantidadeVendida;
    private double totalQuantidadeVendida;


    public Registradora(Produto produto, int quantidadeVendida, double totalQuantidadeVendida) {
        this.produto = produto;
        this.quantidadeVendida = quantidadeVendida;
        this.totalQuantidadeVendida = totalQuantidadeVendida;
    }

    public Registradora(Produto produto, int quantidadeVendida) {
        this.produto = produto;
        this.quantidadeVendida = quantidadeVendida;
        this.totalQuantidadeVendida = 0;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public double getTotalQuantidadeVendida() {
        return totalQuantidadeVendida;
    }

    public static Comparator<Registradora> nameComparator = new Comparator<Registradora>() {

        public int compare(Registradora r1, Registradora r2) {
            String productName1 = r1.getProduto().getNomeProduto();
            String productName2 = r2.getProduto().getNomeProduto();

            return productName1.compareToIgnoreCase(productName2);
        }};


}
