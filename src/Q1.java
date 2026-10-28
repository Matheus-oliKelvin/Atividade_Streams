import java.util.List;

public class Q1 {
    static void main() {
        List <Integer> numeros = List.of(4,25,32,78,45,13,10,77,58,61,52);

        numeros.stream()
                .filter(n-> n % 2 == 0)
                .forEach(System.out::println);
    }
}
