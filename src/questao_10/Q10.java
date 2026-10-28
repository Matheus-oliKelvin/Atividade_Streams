package questao_10;

import java.util.List;

public class Q10 {
    static void main() {

        List<Pedido> pedidos = List.of(
                new Pedido("1", 150.00),
                new Pedido("2", 200.50),
                new Pedido("3", 75.00),
                new Pedido("4", 100.00)
        );

        double total = pedidos.stream()
                .mapToDouble(Pedido::getValor)
                .sum();

        System.out.println("Valor total: "+ total);
    }
}
