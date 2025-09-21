import java.util.ArrayList;
import java.util.Scanner;

public class CadastroCliente {
    ArrayList<Cliente> clientes = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    boolean find = false;

    public void createClient() {
        System.out.println("\nDigite os dados do novo cliente:");

        System.out.print("Nome: ");
        String name = scanner.nextLine();

        System.out.print("Idade: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        Cliente cliente = new Cliente(name, age, email);
        clientes.add(cliente);

        System.out.println("Cliente cadastrado com sucesso!");
    }

    public Cliente getByName(String name) {
        for (Cliente nameClient : clientes) {
            if (nameClient.getName().equalsIgnoreCase(name)) {
                find = true;
                return nameClient;
            }
        }

        return null;
    }

    public void listenClient(String name) {
        Cliente cliente = getByName(name);

        if (cliente != null) {
            System.out.println("Nome: " + cliente.getName());
            System.out.println("Idade: " + cliente.getAge());
            System.out.println("Email: " + cliente.getEmail());
            System.out.println("-------------------------------");
        } else {
            System.out.println("Cliente com o nome '" + name + "' não encontrado.");
        }
    }

    public void alterEmail(String name, String email) {
        Cliente client = getByName(name);
        client.setEmail(email);
    }

    public void getClients() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            for (Cliente cliente : clientes) {
                listenClient(cliente.getName());
            }
        }
    }
}
