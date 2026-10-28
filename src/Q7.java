import java.util.List;

public class Q7 {
    static void main() {
        List<String> palavras = List.of("Hope","is","a", "Muscle", "who","allow","us","to", "connect");

        Long maioresQue5Letras = palavras.stream()
            .filter(n-> n.length() > 5).count();


        System.out.println(maioresQue5Letras);


    }
}
