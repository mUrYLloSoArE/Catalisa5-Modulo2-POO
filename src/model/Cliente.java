package model;

public class Cliente extends Dados {
    private String[] compra = new String[0];

    public Cliente(String nome, String cpf, String email, String[] compra) {
        super(nome, cpf, email);
        this.compra = compra;
    }

    public String[] getCompra() {
        return compra;
    }

    @Override
    public String imprimir() {
        return "Nome-> " + getNome() + "\n" + "CPF -> " + getCpf() + "\n" +
                "Email -> " + getEmail();
    }

}
