import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nLista de compras: ");
        ArrayList<String> compras = new ArrayList<>();

        compras.add("Pipoca");
        compras.add("Refrigerante");
        compras.add("Salgadinho");
        compras.add("Cookies");
        compras.add("Pão");

        for(String i: compras) {
            System.out.println("  - " + i);
        }


        System.out.println("\n---------------------------");
        System.out.println("\nNomes únicos: ");
        HashSet<String> nomes = new HashSet<>();

        nomes.add("Dauro");
        nomes.add("Nivia");
        nomes.add("Sebastian");
        nomes.add("Fernanda");
        nomes.add("Gabriel");
        nomes.add("Fernanda");
        nomes.add("Gabriel");

        for(String i: nomes) {
            System.out.println("  - " + i);
        }


        System.out.println("\n---------------------------");
        System.out.println("\nContagem de letras: ");
        ArrayList<String> letras = new ArrayList<>();
        letras.add("contagem");
        letras.add("de");
        letras.add("string");

        int totalLetras = 0;
        for (String i : letras) {
            int letra = i.length();
            totalLetras += letra;
            System.out.println("Palavra: " + i + " - Letras: " + letra);
        }

        System.out.println("Número total de letras: " + totalLetras);


        System.out.println("\n---------------------------");
        System.out.println("\nPalavras que começam com 'A': ");
        HashSet<String> comecamA = new HashSet<>();
        List<String> palavrasA = new ArrayList<>();

        comecamA.add("Amora");
        comecamA.add("Pão");
        comecamA.add("Amor");
        comecamA.add("Adão");
        comecamA.add("Brincar");

        for( String i : comecamA ) {
            if ( i.contains("A") ) {
                palavrasA.add(i);
            }
        }
        System.out.println(palavrasA);
        System.out.println("Array original: \n" + comecamA);


        System.out.println("\n---------------------------");
        System.out.println("\nRemoção de duplicatas: ");

        ArrayList<String> duplicatas = new ArrayList<>();

        duplicatas.add("Jogar");
        duplicatas.add("Assistir");
        duplicatas.add("Jogar");
        duplicatas.add("Volei");
        duplicatas.add("VideoGame");
        duplicatas.add("Volei");
        duplicatas.add("Dormir");
        duplicatas.add("Comer");
        duplicatas.add("Dormir");

        HashSet<String> palavrasUnicas = new HashSet<>(duplicatas);

        for (String i : palavrasUnicas) {
            System.out.println("  - " + i);
        }


        System.out.println("\n---------------------------");
        System.out.println("\nLista invertida: ");
        ArrayList<String> listaNomes = new ArrayList<>();

        listaNomes.add("João");
        listaNomes.add("Adão");
        listaNomes.add("Sebastian");
        listaNomes.add("Maria");
        listaNomes.add("Eva");

        ArrayList<String> invertida = new ArrayList<>(listaNomes);
        Collections.reverse(invertida);

        for (String i : invertida) {
            System.out.println("  - " + i);
        }

        System.out.println("\nLista original: " + listaNomes);

        System.out.println("\n---------------------------");
        System.out.println("\nBusca de palavra: ");
        HashSet<String> bancoPalavras = new HashSet<>();
        Scanner input = new Scanner(System.in);

        bancoPalavras.add("javaScript");
        bancoPalavras.add("rubi");
        bancoPalavras.add("java");
        bancoPalavras.add("python");
        bancoPalavras.add("sql");
        bancoPalavras.add("php");

        String nome = input.next().toLowerCase();
        boolean encontrada = false;

        for (String linguagem : bancoPalavras) {
            if (linguagem.contains(nome)) {
                encontrada = true;
                break;
            }
        }

        if (encontrada) {
            System.out.println("Essa linguagem está no banco :) -> " + nome);
        } else {
            System.out.println("Não temos essa linguagem no banco :( -> " + nome);
        }

        input.close();


        System.out.println("\n---------------------------");
        System.out.println("\nConcatenação de strings: ");
        ArrayList<String> concatenar = new ArrayList<>();
        String concatenado = "";

        concatenar.add("java");
        concatenar.add("é");
        concatenar.add("orientado");
        concatenar.add("a objetos");

        for (String i: concatenar) {
            concatenado += i + " ";
        }

        System.out.println("palavras concatenadas: " + concatenado);


        System.out.println("\n---------------------------");
        System.out.println("\nContagem de vogais: ");
        HashSet<String> vogais = new HashSet<>();
        vogais.add("amor");
        vogais.add("arara");
        vogais.add("pedra");
        vogais.add("urso");
        vogais.add("potiza");

        int totalVogais = 0;

        for (String i : vogais) {
            totalVogais += contarVogais(i);
        }

        System.out.println("total de vogais -> " + totalVogais);


        System.out.println("\n---------------------------");
        System.out.println("\nOrdenação de palavras: ");
        ArrayList<String> ordenar = new ArrayList<>();

        ordenar.add("Baixinho");
        ordenar.add("Coração");
        ordenar.add("Amor");
        ordenar.add("Feijão");
        ordenar.add("Dado");

        ArrayList<String> ordenado = new ArrayList<>(ordenar);
        Collections.sort(ordenar);

        for (String i : ordenar){
            System.out.println("  - " + i);
        }

        System.out.println("Ordem Original -> " + ordenado);
    }


    public static int contarVogais(String palavra) {
        int count = 0;
        for (char i : palavra.toCharArray()) {
            if (i == 'a' || i == 'e' || i == 'i' || i == 'o' || i == 'u') {
                count++;
            }
        }
        return count;
    }
}
