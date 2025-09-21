import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Jogador {
    private String nome;
    private List<Carta> mao;

    public Jogador(String nome) {
        this.nome = nome;
        this.mao = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Carta> getMao() {
        return mao;
    }

    public void comprarCarta(Carta carta) {
        if (carta != null) {
            mao.add(carta);
        }
    }

    public Carta descartarCarta(int indice) {
        if (indice >= 0 && indice < mao.size()) {
            return mao.remove(indice);
        }
        return null;
    }

    public void mostrarMao() {
        mao.sort(Comparator.comparing(Carta::getValor).thenComparing(Carta::getNaipe));
        System.out.println(nome + " tem as cartas: " + mao);
    }
}
