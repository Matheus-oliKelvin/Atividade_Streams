import java.util.List;
import java.util.stream.Collectors;

public class Q5 {
    static void main() {
        List<String> nomes= List.of("Pedro", "Ana", "José", "Maria", "Antonia", "Augusto", "Carlos", "Francisco");


        List<String> nomesFiltrados = nomes.stream().filter(n-> n.startsWith("A"))
                .sorted()
                .toList();


        System.out.println(nomesFiltrados);
    }
}
