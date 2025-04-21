import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ProdutoService {
    private static ProdutoService instance;
    private Map<Integer, Produto> produtos;

    private ProdutoService() {
        this.produtos = new HashMap<>();
    }

    public static ProdutoService getInstance() {
        if (instance == null) {
            instance = new ProdutoService();
        }
        return instance;
    }

    public void inserir(Produto produto) {
        produtos.put(produto.getId(), produto);
        System.out.println("Produto inserido com sucesso!");
    }

    public void alterar(int id, String tipo, String descricao, double preco) {
        if (produtos.containsKey(id)) {
            Produto produto = produtos.get(id);
            produto.setTipo(tipo);
            produto.setDescricao(descricao);
            produto.setPreco(preco);
            System.out.println("Produto com ID " + id + " alterado com sucesso!");
        } else {
            System.out.println("Produto com ID " + id + " não encontrado.");
        }
    }

    public void excluir(int id) {
        if (produtos.containsKey(id)) {
            produtos.remove(id);
            System.out.println("Produto com ID " + id + " excluído com sucesso!");
        } else {
            System.out.println("Produto com ID " + id + " não encontrado.");
        }
    }

    public void listar() {
        if (produtos.isEmpty()) {
            System.out.println("Não há produtos cadastrados.");
        } else {
            System.out.println("Lista de Produtos:");
            for (Produto produto : produtos.values()) {
                System.out.println(produto);
            }
        }
    }

    public Produto buscarPorId(int id) {
        return produtos.getOrDefault(id, null);
    }
}
