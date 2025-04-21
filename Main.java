import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProdutoService produtoService = ProdutoService.getInstance();
        PedidoService pedidoService = PedidoService.getInstance();
        int opcao;

        do {
            exibirMenuPrincipal();
            System.out.print("Opção escolhida: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            	switch (opcao) {
                case 1 -> menuProdutos(scanner, produtoService);
                case 2 -> menuPedidos(scanner, produtoService, pedidoService);
                case 0 -> System.out.println("Saindo do sistema...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n+-----------------------------------------+");
        System.out.println("|                Menu Principal               |");
        System.out.println("+-----------------------------------------+");
        System.out.println("| 01 - Produtos                             |");
        System.out.println("| 02 - Pedidos                              |");
        System.out.println("| 00 - Sair                                 |");
        System.out.println("+-----------------------------------------+");
    }

    private static void exibirMenuProdutos() {
        System.out.println("\n+-----------------------------------------+");
        System.out.println("|             Menu de Produtos              |");
        System.out.println("+-----------------------------------------+");
        System.out.println("| 01 - Inserir                              |");
        System.out.println("| 02 - Alterar                              |");
        System.out.println("| 03 - Excluir                              |");
        System.out.println("| 04 - Listar                               |");
        System.out.println("| 05 - Pesquisar por ID                     |");
        System.out.println("| 00 - Voltar                               |");
        System.out.println("+-----------------------------------------+");
    }

    private static void exibirMenuPedidos() {
        System.out.println("\n+-----------------------------------------+");
        System.out.println("|              Menu de Pedidos              |");
        System.out.println("+-----------------------------------------+");
        System.out.println("| 01 - Inserir                              |");
        System.out.println("| 02 - Alterar descrição                    |");
        System.out.println("| 03 - Excluir                              |");
        System.out.println("| 04 - Listar                               |");
        System.out.println("| 05 - Pesquisar por ID                     |");
        System.out.println("| 00 - Voltar                               |");
        System.out.println("+-----------------------------------------+");
    }

    private static void menuProdutos(Scanner scanner, ProdutoService produtoService) {
        int opcao;
        do {
            exibirMenuProdutos();
            System.out.print("Opção escolhida: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1 -> {
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Tipo: ");
                    String tipo = scanner.nextLine();
                    System.out.print("Descrição: ");
                    String desc = scanner.nextLine();
                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();
                    scanner.nextLine();
                    produtoService.inserir(ProdutoFactory.criarProduto(id, tipo, desc, preco));
                }
                case 2 -> {
                    System.out.print("ID do produto: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Novo tipo: ");
                    String tipo = scanner.nextLine();
                    System.out.print("Nova descrição: ");
                    String desc = scanner.nextLine();
                    System.out.print("Novo preço: ");
                    double preco = scanner.nextDouble();
                    scanner.nextLine();
                    produtoService.alterar(id, tipo, desc, preco);
                }
                case 3 -> {
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    produtoService.excluir(id);
                }
                case 4 -> produtoService.listar();
                case 5 -> {
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    Produto p = produtoService.buscarPorId(id);
                    System.out.println(p != null ? p : "Produto não encontrado.");
                }
                case 0 -> System.out.println("Voltando ao menu principal...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static void menuPedidos(Scanner scanner, ProdutoService produtoService, PedidoService pedidoService) {
        int opcao;
        do {
            exibirMenuPedidos();
            System.out.print("Opção escolhida: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1 -> {
                    System.out.print("ID do pedido: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Descrição do pedido: ");
                    String desc = scanner.nextLine();
                    Pedido pedido = new Pedido(id, desc);

                    String continuar;
                    do {
                        System.out.print("ID do produto a adicionar: ");
                        int idProd = scanner.nextInt();
                        scanner.nextLine();
                        Produto p = produtoService.buscarPorId(idProd);
                        if (p != null) {
                            System.out.print("Quantidade: ");
                            int qtde = scanner.nextInt();
                            scanner.nextLine();
                            pedido.adicionarItem(new ItemPedido(p, qtde));
                        } else {
                            System.out.println("Produto não encontrado.");
                        }
                        System.out.print("Adicionar outro produto? Digite sim ou não ");
                        continuar = scanner.nextLine();
                    } while (continuar.equalsIgnoreCase("sim"));

                    pedidoService.inserir(pedido);
                }
                case 2 -> {
                    System.out.print("ID do pedido: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nova descrição: ");
                    String novaDesc = scanner.nextLine();
                    pedidoService.alterar(id, novaDesc);
                }
                case 3 -> {
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    pedidoService.excluir(id);
                }
                case 4 -> pedidoService.listar();
                case 5 -> {
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    Pedido p = pedidoService.buscarPorId(id);
                    System.out.println(p != null ? p : "Pedido não encontrado.");
                }
                case 0 -> System.out.println("Voltando ao menu principal...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
}