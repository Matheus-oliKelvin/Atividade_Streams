import java.util.List;

public class Q9 {
    static void main() {

        List<Integer> numeros = List.of(10, 5, 25, 8, 17, 30);

        boolean todosPositivos = numeros.stream()
                .allMatch(n -> n > 0);

        System.out.println("Todos são positivos : " + todosPositivos);


    }
}
