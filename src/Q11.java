import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q11 {
    static void main() {
        List<String> palavras = List.of(
                "casa", "sol", "carro", "lua",
                "mesa", "oi", "computador", "mar"
        );

        Map<Integer, List<String>> agrupadas = palavras.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(agrupadas);
    }
}
