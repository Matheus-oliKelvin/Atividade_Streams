import java.util.List;

public class Q4 {
    static void main() {
        List<Integer> numeros = List.of(4,25,32,5,45,13,8,77,58,2,52);

        Long numerosMaioresQue10 = numeros.stream().filter(n-> n > 10).count();

        System.out.println("Numeros maiores que 10: " + numerosMaioresQue10);

    }
}
