import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baralho {
    private List<Carta> cartas;

    public Baralho(String caminhoCSV) {
        cartas = new ArrayList<>();
        carregarCartasDoCSV(caminhoCSV);
    }

    private void carregarCartasDoCSV(String caminhoCSV) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoCSV))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length == 2) {
                    cartas.add(new Carta(partes[0].trim(), partes[1].trim()));
                }
            }
        } catch (IOException e) {
            System.out.println("erro ao carregar cartas: " + e.getMessage());
        }
    }

    public void embaralhar() {
        Collections.shuffle(cartas);
    }

    public Carta distribuirCarta() {
        return cartas.isEmpty() ? null : cartas.remove(0);
    }
}
