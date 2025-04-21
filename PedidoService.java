import java.util.HashMap;
import java.util.Map;

class PedidoService {
    private static PedidoService instance;
    private Map<Integer, Pedido> pedidos;

    private PedidoService() {
        this.pedidos = new HashMap<>();
    }

    public static PedidoService getInstance() {
        if (instance == null) {
            instance = new PedidoService();
        }
        return instance;
    }

    public void inserir(Pedido pedido) {
        pedidos.put(pedido.getId(), pedido);
        System.out.println("Pedido inserido com sucesso!");
    }

    public void alterar(int id, String novaDescricao) {
        if (pedidos.containsKey(id)) {
            Pedido pedido = pedidos.get(id);
            pedido.setDescricao(novaDescricao);
            System.out.println("Pedido com ID " + id + " alterado com sucesso!");
        } else {
            System.out.println("Pedido com ID " + id + " não encontrado.");
        }
    }

    public void excluir(int id) {
        if (pedidos.containsKey(id)) {
            pedidos.remove(id);
            System.out.println("Pedido com ID " + id + " excluído com sucesso!");
        } else {
            System.out.println("Pedido com ID " + id + " não encontrado.");
        }
    }

    public void listar() {
        if (pedidos.isEmpty()) {
            System.out.println("Não há pedidos cadastrados.");
        } else {
            System.out.println("Lista de Pedidos:");
            for (Pedido pedido : pedidos.values()) {
                System.out.println(pedido);
            }
        }
    }

    public Pedido buscarPorId(int id) {
        return pedidos.getOrDefault(id, null);
    }
}