package model;

public class Vendedor extends Dados {
    public Vendedor() {
    }

    private double[] valor = new double[0];

    public Vendedor(String nome, String cpf, String email, double[] valor) {
        super(nome, cpf, email);
        this.valor = valor;
    }

    public double[] getValor() {
        return valor;
    }

    public void setValor(double[] valor) {
        this.valor = valor;
    }

    @Override
    public String imprimir() {
        return "Nome-> " + getNome() + "\n" + "CPF -> " + getCpf() + "\n" +
                "Email -> " + getEmail();
    }

}
