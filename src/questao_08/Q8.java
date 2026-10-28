package questao_08;

import java.util.List;

public class Q8 {
    static void main() {

        List<Pessoa> pessoas = List.of(new Pessoa("Chappel Roan", 16),
                                new Pessoa("Olivia Rodrigo", 17),
                                new Pessoa("Madonna", 999999),
                                new Pessoa("Cher", 8888888)

        );


       List<String> maioresDe18Anos = pessoas.stream().filter(n-> n.getIdade() >= 18)
                .map(Pessoa::getNome).toList();


        System.out.println(maioresDe18Anos);
    }
}
