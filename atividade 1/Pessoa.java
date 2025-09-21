class Endereco {
    String rua;
    int numero;
    String cidade;

    public Endereco(String rua, int numero, String cidade) {
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
    }
}

class IPessoa {
    String nome;
    int idade;
    Endereco endereco;

    public IPessoa(String nome, int idade, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Endereço: " + endereco.rua + ", " + endereco.numero + " - " + endereco.cidade);
    }
}

public class Pessoa {
    public static void main(String[] args) {
        Endereco endereco = new Endereco("Rua das Flores", 123, "Cidade Exemplo");
        IPessoa pessoa = new IPessoa("Fernanda", 18, endereco);
        pessoa.exibirInformacoes();
    }
}
