class ProdutoFactory {
    public static Produto criarProduto(int id, String tipo, String descricao, double preco) {
        return new Produto(id, tipo, descricao, preco);
    }
}