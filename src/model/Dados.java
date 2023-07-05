package model;

public abstract class Dados {
    private String nome;
    private String cpf;
    private String email;

    public Dados() {
    }

    public Dados(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String imprimir() {
        return "Nome-> " + nome + "\n" + "CPF -> " + cpf + "\n" +
                "Email -> " + email;
    }

    public void sistema() {
        System.out.println("Bem Vindo ao nosso Sistema, digite uma das opções para começar a simulação ");
        System.out.println("0 = Encerrar ");
        System.out.println("1 = Cadastrar cliente ");
        System.out.println("2 = Listar clientes ");
        System.out.println("3 = Cadastrar Produtos ");
        System.out.println("4 = Listar Produtos ");
        System.out.println("5 = Pesquisar compras de cliente por CPF ");
        System.out.println("6 = Cadastrar vendedor ");
        System.out.println("7 = Listar vendedores ");
        System.out.println("8 = Pesquisar vendas de vendedor por Email ");
    }

}
