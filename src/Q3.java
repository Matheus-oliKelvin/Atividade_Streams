import java.util.List;

public class Q3 {
    static void main() {

        List<Integer> numeros = List.of(4,2,3,7,5,13,9,7,8,1,2);

        numeros.stream().map(n-> n * 2).forEach(System.out::println);

    }
}
