package controller;
import model.Dados;
import services.ClienteService;
import services.VendasService;
import services.VendedorService;
import java.util.Scanner;

public class SistemaController extends Dados {
    Scanner sc = new Scanner(System.in);
    private int opcao;
    private int qtdC = 0;
    private int qtdCpf = 0;
    private int qtdEmail = 0;
    private int qtdV = 0;
    ClienteService cadastroService = new ClienteService();
    VendasService vendasService = new VendasService();
    VendedorService vendedorService = new VendedorService();

    public void menu() {
        do {
            sistema();
            opcao = sc.nextInt();
            switch (opcao) {
                case 0:
                    System.out.println("Programa Encerrado! ");
                    System.exit(0);
                    break;
                case 1:
                    cadastroService.cadastrar();
                    qtdC++;
                    qtdCpf++;
                    break;
                case 2:
                    cadastroService.listardados();
                    break;
                case 3:
                    if (qtdC == 0) {
                        System.out.println("É preciso ter um Cliente cadastrado! ");
                        System.exit(0);
                    }
                    if (qtdV == 0) {
                        System.out.println("É preciso ter um Vendedor cadastrado! ");
                        System.exit(0);
                    }
                    vendasService.cadastrarProduto();
                    break;
                case 4:
                    vendasService.listarProdutos();
                    break;
                case 5:
                    if (qtdCpf == 0) {
                        System.out.println("É preciso ter um CPF preenchido no Banco ");
                        System.exit(0);
                    }
                    cadastroService.pesquisarCpf();
                    break;
                case 6:
                    vendedorService.cadastrar();
                    qtdV++;
                    qtdEmail++;
                    break;
                case 7:
                    vendedorService.listardados();
                    break;
                case 8:
                    if (qtdEmail == 0) {
                        System.out.println("É preciso ter um Email preenchido no Banco ");
                        System.exit(0);
                    }
                    vendedorService.pesquisarEmail();
                    break;
                default:
                    System.out.println("Opção inválida!");
                    System.exit(0);
            }
        } while (opcao != 0);
    }

}
