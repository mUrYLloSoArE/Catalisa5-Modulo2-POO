package services;

import model.Dados;
import model.Vendedor;
import repository.Cadastrar;

import java.util.ArrayList;
import java.util.Scanner;

public class VendedorService implements Cadastrar {

    Scanner sc = new Scanner(System.in);

    private ArrayList<Vendedor> lista = new ArrayList();
    private double[] valores = new double[0];
    private double total = 0.0;
    Vendedor vendedor;

    protected String nome, email, cpf;
    protected int qtd;


    public void validarEmailVendedor() {
        try {
            if (!email.contains("@")) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.out.println("EMAIL INVÁLIDO! ");
            System.exit(0);
        }

    }

    public void validarEmailRepetidoVendedor() {
        for (Dados l : lista) {
            while (l.getEmail().equalsIgnoreCase(email)) {
                System.out.println("Email já existente! ");
                System.out.println("Digite o seu Email: ");
                email = sc.next();
                validarEmailVendedor();
            }
        }
    }

    public void validarCpfVendedor() {
        if (!cpf.contains(".") &&
                !cpf.contains("-")
        ) {
            System.out.println("CPF INVALIDO! ");
            System.exit(0);
        }
        for (Dados l : lista) {
            while (l.getCpf().equalsIgnoreCase(cpf)) {
                System.out.println("CPF já existente! ");
                System.out.println("Digite o seu CPF: ");
                cpf = sc.next();
            }
        }

    }

    public void cadastrar() {
        System.out.println("Digite o seu nome: ");
        nome = sc.next();

        System.out.println("Digite o seu CPF: ex(905.726.480-30)");
        cpf = sc.next();
        validarCpfVendedor();

        System.out.println("Digite o seu Email: ex(example@gmail.com)");
        email = sc.next();
        validarEmailVendedor();
        validarEmailRepetidoVendedor();

        System.out.println("Digite a quantidade de vendas: ");
        qtd = sc.nextInt();
        valores = new double[qtd];
        for (int i = 0; i < valores.length; i++) {
            System.out.println("Valor da " + (i + 1) + "°" + " venda: ");
            valores[i] = sc.nextDouble();
            total += valores[i];
        }
        vendedor = new Vendedor(nome, cpf, email, valores);
        lista.add(vendedor);
        System.out.println("Vendedor Cadastrado! ");
    }

    public void listardados() {
        System.out.println("Vendedores cadastrados:");
        for (Dados l : lista) {
            System.out.println(l.imprimir());
        }
    }

    public void pesquisarEmail() {
        System.out.println("Digite o Email para ver a lista de vendas " +
                "de um vendedor especifico");
        email = sc.next();

        for (Vendedor l : lista) {
            if (l.getEmail().equalsIgnoreCase(email)) {
                System.out.println("Pesquisa feita com sucesso ");
                System.out.println("Vendas Realizadas por " + l.getNome());
                System.out.println("Email -> " + l.getEmail());
                System.out.println("Valores: ");
                for (int i = 0; i < l.getValor().length; i++) {
                    System.out.printf("R$ %.2f \n", l.getValor()[i]);
                }
            } else {
                System.out.println("Email não encontrado! ");
            }
        }

        System.out.printf("Total -> R$ %.2f \n", total);
    }
}
