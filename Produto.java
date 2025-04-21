import java.util.ArrayList;
import java.util.List;

class Produto {
    private int id;
    private String tipo;
    private String descricao;
    private double preco;

    public Produto(int id, String tipo, String descricao, double preco) {
        this.id = id;
        this.tipo = tipo;
        this.descricao = descricao;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Tipo: " + tipo + ", Descrição: " + descricao + ", Preço: " + preco;
    }
}