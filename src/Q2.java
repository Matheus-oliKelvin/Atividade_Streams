import java.util.List;

public class Q2 {
    static void main() {

        List<String> nomes = List.of("Bjork", "Arca", "Sophie", "Fka Twigs", "Undescore");

        nomes.stream().map(String::toUpperCase).forEach(System.out::println);
    }
}
