package services;
import model.Cliente;
import model.Dados;
import repository.Cadastrar;
import java.util.ArrayList;
import java.util.Scanner;

public class ClienteService implements Cadastrar {
    Scanner sc = new Scanner(System.in);
    protected ArrayList<Cliente> lista = new ArrayList();
    Cliente cliente;
    protected String nome, email, cpf;
    protected int qtd;
    private String[] compras = new String[0];

    public void validarEmail() {
        try {
            if (!email.contains("@")) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.out.println("EMAIL INVÁLIDO! ");
            System.exit(0);
        }

    }

    public void validarEmailRepetido() {
        for (Dados l : lista) {
            while (l.getEmail().equalsIgnoreCase(email)) {
                System.out.println("Email já existente! ");
                System.out.println("Digite o seu Email: ");
                email = sc.next();
                validarEmail();
            }
        }
    }

    public void validarCpf() {
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
        validarCpf();

        System.out.println("Digite o seu Email: ex(example@gmail.com)");
        email = sc.next();
        validarEmail();
        validarEmailRepetido();

        System.out.println("Digite a quantidade de compra: ");
        qtd = sc.nextInt();
        compras = new String[qtd];

        for (int i = 0; i < compras.length; i++) {
            System.out.println("Digite o nome da " + (i + 1) + "°" + " compra: ");
            compras[i] = sc.next();
        }

        cliente = new Cliente(nome, cpf, email, compras);
        lista.add(cliente);
        System.out.println(" Cliente Cadastrado! ");
    }

    public void listardados() {
        System.out.println("Clientes cadastrados:");
        for (Dados l : lista) {
            System.out.println(l.imprimir());
        }
    }

    public void pesquisarCpf() {
        System.out.println("Digite o Cpf para ver a lista de compras " +
                "de um cliente especifico");
        cpf = sc.next();

        for (Cliente l : lista) {
            if (l.getCpf().equalsIgnoreCase(cpf)) {
                System.out.println("Pesquisa feita com sucesso ");
                System.out.println("Cpf -> " + l.getCpf());
                System.out.println("Compras Realizadas por " + l.getNome());

                for (int i = 0; i < l.getCompra().length; i++) {
                    System.out.println(l.getCompra()[i]);
                }

            }

        }

    }

}


