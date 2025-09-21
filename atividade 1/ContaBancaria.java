public class ContaBancaria {
    private String titular;
    private double saldo;
    private String senha;

    public ContaBancaria(String titular, String senha) {
        this.titular = titular;
        this.senha = senha;
        this.saldo = 0.0;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$ " + valor + " realizado com sucesso.");
    }

    public void sacar(double valor, String senha) {
        if (!this.senha.equals(senha)) {
            System.out.println("Senha incorreta. Saque não autorizado.");
            return;
        }

        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
        }
    }

    public void exibirSaldo(String senha) {
        if (this.senha.equals(senha)) {
            System.out.println("Saldo atual: R$ " + saldo);
        } else {
            System.out.println("Senha incorreta. Não é possível exibir o saldo.");
        }
    }

    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria("Fernanda", "1234");
        conta.depositar(1000);
        conta.exibirSaldo("1234");
        conta.sacar(500, "1234");
        conta.exibirSaldo("1234");
        conta.sacar(700, "1234");
        conta.exibirSaldo("0000");
    }
}
