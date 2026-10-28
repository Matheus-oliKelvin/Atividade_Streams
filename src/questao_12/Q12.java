package questao_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Q12 {

    static void main() {


        Scanner sc = new Scanner(System.in);
        List<Autonomo> autonomos = new ArrayList<>();

        int opcao;

        do {
            System.out.println("\n===== SISTEMA DE AUTÔNOMOS =====");
            System.out.println("1 - Cadastrar autônomo");
            System.out.println("2 - Cadastrar serviço");
            System.out.println("3 - Consultar serviços por CPF");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {

                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();

                    boolean cpfExiste = autonomos.stream()
                            .anyMatch(a -> a.getCpf().equals(cpf));

                    if (cpfExiste) {
                        System.out.println("CPF já cadastrado!");
                    } else {
                        autonomos.add(new Autonomo(nome, cpf));
                        System.out.println("Autônomo cadastrado!");
                    }

                    break;

                case 2:
                    System.out.print("CPF do autônomo: ");
                    String cpfBusca = sc.nextLine();

                    Autonomo autonomo = autonomos.stream()
                            .filter(a -> a.getCpf().equals(cpfBusca))
                            .findFirst()
                            .orElse(null);

                    if (autonomo == null) {
                        System.out.println("Autônomo não encontrado!");
                        break;
                    }

                    System.out.println("Tipos disponíveis:");

                    for (TipoServico tipo : TipoServico.values()) {
                        System.out.println("- " + tipo);
                    }

                    System.out.print("Tipo do serviço: ");
                    String tipoTexto = sc.nextLine().toUpperCase();

                    TipoServico tipoServico;

                    try {
                        tipoServico = TipoServico.valueOf(tipoTexto);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Tipo de serviço inválido!");
                        break;
                    }

                    System.out.print("Valor do serviço: R$ ");
                    double valor = Double.parseDouble(
                            sc.nextLine().replace(",", ".")
                    );

                    if (!Double.isFinite(valor) || valor < 0) {
                        System.out.println("Valor inválido!");
                        break;
                    }

                    Servico servico = new Servico(tipoServico, valor);

                    autonomo.adicionarServico(servico);

                    System.out.println("Serviço cadastrado!");

                    break;

                case 3:
                    System.out.print("CPF do autônomo: ");
                    String cpfConsulta = sc.nextLine();

                    Autonomo encontrado = autonomos.stream()
                            .filter(a -> a.getCpf().equals(cpfConsulta))
                            .findFirst()
                            .orElse(null);

                    if (encontrado == null) {
                        System.out.println("Autônomo não encontrado!");
                        break;
                    }

                    System.out.println("\n===== DADOS DO AUTÔNOMO =====");
                    System.out.println("Nome: " + encontrado.getNome());
                    System.out.println("CPF: " + encontrado.getCpf());

                    List<Servico> listaServicos =
                            encontrado.getServicos();

                    if (listaServicos.isEmpty()) {
                        System.out.println("Nenhum serviço cadastrado.");
                        break;
                    }

                    System.out.println("\n===== SERVIÇOS CADASTRADOS =====");

                    listaServicos.forEach(System.out::println);

                    Map<TipoServico, List<Servico>> agrupados =
                            listaServicos.stream()
                                    .collect(Collectors.groupingBy(
                                            Servico::getTipo
                                    ));

                    System.out.println("\n===== SERVIÇOS POR TIPO =====");

                    agrupados.forEach((tipo, lista) -> {
                        System.out.println("\n" + tipo + ":");

                        lista.forEach(System.out::println);

                        double subtotal = lista.stream()
                                .mapToDouble(Servico::getValor)
                                .sum();

                        System.out.printf(
                                "Subtotal: R$ %.2f%n",
                                subtotal
                        );
                    });

                    double total = listaServicos.stream()
                            .mapToDouble(Servico::getValor)
                            .sum();

                    System.out.printf(
                            "%nValor total dos serviços: R$ %.2f%n",
                            total
                    );

                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}
