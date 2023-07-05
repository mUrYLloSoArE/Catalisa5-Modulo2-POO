package model;

public class Vendas {

    private String produto, dataRegistro;
    private Number preco;

    public Vendas() {
    }

    public Vendas(String produto, String dataRegistro, Number preco) {
        this.produto = produto;
        this.dataRegistro = dataRegistro;
        this.preco = preco;
    }

    public String imprimir() {
        return "Produto-> " + produto + "\n" + "Preço -> " + preco + "\n" +
                "Data de Registro -> " + dataRegistro;
    }
}
