package questao_10;

public class Pedido {

    private String id;
    private Double valor;

    public Pedido(String id, Double valor) {
        this.id = id;
        this.valor = valor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id='" + id + '\'' +
                ", valor=" + valor +
                '}';
    }
}
