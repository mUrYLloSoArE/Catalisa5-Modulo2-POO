package services;

import model.Vendas;

import java.util.ArrayList;
import java.util.Scanner;

public class VendasService {
    Scanner sc = new Scanner(System.in);
    private ArrayList<Vendas> lista = new ArrayList();
    Vendas venda;
    private String produto, dataRegistro;
    private double preco;

    public void cadastrarProduto() {

        System.out.println("Digite o  nome do Produto: ");
        produto = sc.next();

        System.out.println("Digite o seu Preço: ");
        preco = sc.nextDouble();

        System.out.println("Digite a Data de Registro (dd/MM/yyyy): ");
        dataRegistro = sc.next();

        venda = new Vendas(produto, dataRegistro, preco);
        lista.add(venda);

        System.out.println(" Produto Cadastrado! ");
    }

    public void listarProdutos() {
        System.out.println("Programa encerrado!");
        System.out.println("Dados cadastrados:");
        for (Vendas l : lista) {
            System.out.println(l.imprimir());
        }

    }

}
