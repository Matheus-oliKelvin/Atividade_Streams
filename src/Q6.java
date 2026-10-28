import java.util.List;

public class Q6 {
    static void main() {
        List<Integer> numeros = List.of(4,2,3,7,5,13,9,7,8,1,2);

        int maior = numeros.stream().max(Integer::compareTo).get();

        System.out.println(maior);
    }
}
