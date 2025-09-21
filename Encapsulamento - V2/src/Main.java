import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CadastroCliente cadastro = new CadastroCliente();
        int menu = -1;

        while (menu != 5) {
            System.out.println("\n*************** Cadastro de Clientes **************\n");

            System.out.println("1 - Cadastrar novos clientes;");
            System.out.println("2 - Visualizar dados de clientes;");
            System.out.println("3 - Modificar e-mail de clientes;");
            System.out.println("4 - Exibir todos os clientes;");
            System.out.println("5 - Sair;");

            System.out.println("\nEscolha: ");
            menu = scanner.nextInt();
            scanner.nextLine();

            switch (menu) {
                case 1:
                    cadastro.createClient();
                    break;
                case 2:
                    System.out.print("Insira o nome do cliente que deseja visualizar os dados: \n   ");
                    String searchName = scanner.nextLine();

                    cadastro.listenClient(searchName);
                    break;
                case 3:
                    System.out.print("Digite o nome do cliente para alterar o e-mail: ");
                    String searchNameForEmail = scanner.nextLine();

                    System.out.print("Digite o novo e-mail: ");
                    String email = scanner.nextLine();

                    cadastro.alterEmail(searchNameForEmail, email);
                    break;
                case 4:
                    cadastro.getClients();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.\n");
            }
        }
    }
}