import java.util.ArrayList;
import java.util.List;

class Pedido {
    private int id;
    private String descricao;
    private List<ItemPedido> itens;

    public Pedido(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
        this.itens = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public int getQuantidadeTotalItens() {
        return itens.stream().mapToInt(ItemPedido::getQuantidade).sum();
    }

    public double getPrecoTotal() {
        return itens.stream().mapToDouble(ItemPedido::getSubtotal).sum();
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void adicionarItem(ItemPedido item) {
        this.itens.add(item);
    }

    public void removerItem(int produtoId) {
        this.itens.removeIf(item -> item.getProduto().getId() == produtoId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ID: " + id + ", Descrição: " + descricao + "\nItens do Pedido:\n");
        for (ItemPedido item : itens) {
            sb.append("- ").append(item).append("\n");
        }
        sb.append("Quantidade Total de Itens: ").append(getQuantidadeTotalItens()).append("\n");
        sb.append("Preço Total do Pedido: ").append(String.format("%.2f", getPrecoTotal()));
        return sb.toString();
    }
}