import java.util.*;

public class Jogo {
    private Baralho baralho;
    private Stack<Carta> descarte;
    private List<Jogador> jogadores;
    private int jogadorAtual;

    public Jogo(String caminhoCSV, List<String> nomesJogadores) {
        this.baralho = new Baralho(caminhoCSV);
        this.descarte = new Stack<>();
        this.jogadores = new ArrayList<>();
        this.jogadorAtual = 0;

        for (String nome : nomesJogadores) {
            jogadores.add(new Jogador(nome));
        }

        iniciarJogo();
    }

    private void iniciarJogo() {
        baralho.embaralhar();
        distribuirCartasIniciais();
        iniciarRodadas();
    }

    private void distribuirCartasIniciais() {
        for (int i = 0; i < 9; i++) {
            for (Jogador jogador : jogadores) {
                jogador.comprarCarta(baralho.distribuirCarta());
            }
        }

        descarte.push(baralho.distribuirCarta());
    }

    private void iniciarRodadas() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Jogador jogador = jogadores.get(jogadorAtual);
            System.out.println("\nVez de " + jogador.getNome());
            jogador.mostrarMao();

            System.out.println("Monte de descarte: " + (descarte.isEmpty() ? "Vazio" : descarte.peek()));

            System.out.println("1. Comprar do baralho");
            System.out.println("2. Comprar do descarte");
            System.out.println("3. Sair do jogo");
            int escolha = scanner.nextInt();

            Carta cartaComprada = null;

            // menu jogo
            if (escolha == 1) {
                cartaComprada = baralho.distribuirCarta();
            } else if (escolha == 2 && !descarte.isEmpty()) {
                cartaComprada = descarte.pop();
            } else if (escolha == 3) {
                System.out.println(jogador.getNome() + " saiu do jogo!");
                break;
            } else {
                System.out.println("Opção invalida.");
                continue;
            }

            // compra
            if (cartaComprada != null) {
                jogador.comprarCarta(cartaComprada);
                System.out.println("Voce comprou: " + cartaComprada);
            } else {
                System.out.println("Nenhuma carta disponivel!");
                break;
            }

            // descarte
            System.out.println("Escolha uma carta para descartar (digite o indice, de 1 a " + jogador.getMao().size() + "):");
            for (int i = 0; i < jogador.getMao().size(); i++) {
                System.out.println((i + 1) + ". " + jogador.getMao().get(i));
            }
            int indiceDescarte = scanner.nextInt() - 1;
            Carta cartaDescartada = jogador.descartarCarta(indiceDescarte);

            if (cartaDescartada != null) {
                descarte.push(cartaDescartada);
                System.out.println(jogador.getNome() + " descartou: " + cartaDescartada);
            } else {
                System.out.println("Índice inválido. Nenhuma carta foi descartada.");
            }

            if (verificarVitoria(jogador)) {
                System.out.println(jogador.getNome() + " venceu o jogo!");
                break;
            }

            jogadorAtual = (jogadorAtual + 1) % jogadores.size();
        }

        scanner.close();
    }


    private boolean verificarVitoria(Jogador jogador) {
        List<Carta> mao = new ArrayList<>(jogador.getMao());
        int grupos = 0;

        grupos += verificarTrincas(mao);

        grupos += verificarSequencias(mao);

        return grupos >= 3;
    }

    private int verificarTrincas(List<Carta> mao) {
        int trincas = 0;
        for (int i = 0; i < mao.size() - 2; i++) {
            if (mao.get(i).getValor().equals(mao.get(i + 1).getValor()) &&
                    mao.get(i).getValor().equals(mao.get(i + 2).getValor())) {
                trincas++;
                i += 2;
            }
        }

        System.out.println("Trincas encontradas no método: " + trincas);
        return trincas;
    }

    private int verificarSequencias(List<Carta> mao) {
        int sequencias = 0;
        for (int i = 0; i < mao.size() - 2; i++) {
            // Verifica se as cartas estão no mesmo naipe
            if (mao.get(i).getNaipe().equals(mao.get(i + 1).getNaipe()) &&
                    mao.get(i).getNaipe().equals(mao.get(i + 2).getNaipe())) {

                // Verifica se os valores são consecutivos
                int valor1 = valorParaNumero(mao.get(i).getValor());
                int valor2 = valorParaNumero(mao.get(i + 1).getValor());
                int valor3 = valorParaNumero(mao.get(i + 2).getValor());

                if (valor1 + 1 == valor2 && valor2 + 1 == valor3) {
                    sequencias++;  // Encontrou uma sequência
                    i += 2;         // Pula as cartas que já formaram a sequência
                }
            }
        }

        // Exibe o número de sequências encontradas
        System.out.println("Sequências encontradas no método: " + sequencias);
        return sequencias;
    }

    private int valorParaNumero(String valor) {
        return switch (valor) {
            case "As" -> 1;
            case "2" -> 2;
            case "3" -> 3;
            case "4" -> 4;
            case "5" -> 5;
            case "6" -> 6;
            case "7" -> 7;
            case "8" -> 8;
            case "9" -> 9;
            case "10" -> 10;
            case "Valete" -> 11;
            case "Dama" -> 12;
            case "Rei" -> 13;
            default -> 0;
        };
    }

    public static void main(String[] args) {
        List<String> nomes = Arrays.asList("Jogador 1", "Jogador 2");
        new Jogo("src/cartas.csv", nomes);
    }
}
