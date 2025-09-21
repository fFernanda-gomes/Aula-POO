public class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public Produto(String nome) {
        this.nome = nome;
        this.preco = 0;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void exibirInfo() {
        System.out.println("Nome: " + getNome());
        System.out.println("Preço: R$ " + getPreco());
    }

    public static void main(String[] args) {
        Produto produto1 = new Produto("Notebook", 3500.00);
        System.out.println("Nome do produto: " + produto1.getNome());
        System.out.println("Preço do produto: R$ " + produto1.getPreco());

        Produto produto2 = new Produto("Mouse");
        System.out.println("Nome do produto: " + produto2.getNome());
        System.out.println("Preço do produto: R$ " + produto2.getPreco());
    }
}
