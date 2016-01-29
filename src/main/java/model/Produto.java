package model;


public class Produto {
    private String nomeProduto;
    private double valorUnidade;

    public Produto(String nomeProduto, double valorUnidade) {
        this.nomeProduto = nomeProduto;
        this.valorUnidade = valorUnidade;
    }
    public String getNomeProduto() {
        return nomeProduto;
    }

    public double getValorUnidade() {
        return valorUnidade;
    }

}
