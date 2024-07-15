package main;

import model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaEstoque {
    private Estoque estoque;
    private List<Usuario> usuarios;
    private Usuario usuarioLogado;

    public SistemaEstoque() {
        this.estoque = new Estoque();
        this.usuarios = new ArrayList<>();
    }

    public boolean verificarisAdmin() {
        if (usuarioLogado != null && usuarioLogado.isAdmin()) {
            return true;
        } else {
            System.out.println("Acesso negado. Apenas administradores podem usar esse comando.");
            return false;
        }
    }

    public void cadastrarProduto(String nome, String descricao, int quantidade, double preco, LocalDate validade) {
        if (usuarioLogado == null || !usuarioLogado.isAdmin()) {
            System.out.println("Acesso negado. Apenas administradores podem cadastrar produtos.");
            return;
        }

        Produto produto = new Produto(nome, descricao, quantidade, preco, validade);
        estoque.adicionarProduto(produto);
        System.out.println("Produto cadastrado com sucesso.");
    }

    public void efetuarEntradaDeProduto(String nome, int quantidade) {
        Produto produto = encontrarProduto(nome);
        if (produto == null) {
            System.out.println("Produto não encontrado.");
            return;
        }
        estoque.atualizarQuantidade(produto, produto.getQuantidadeEmEstoque() + quantidade);
        System.out.println("Entrada de produto efetuada com sucesso.");
    }

    public void efetuarSaidaDeProduto(String nome, int quantidade) {
        Produto produto = encontrarProduto(nome);
        if (produto == null) {
            System.out.println("Produto não encontrado.");
            return;
        }
        if (produto.getQuantidadeEmEstoque() < quantidade) {
            System.out.println("Quantidade insuficiente em estoque.");
            return;
        }
        estoque.atualizarQuantidade(produto, produto.getQuantidadeEmEstoque() - quantidade);
        System.out.println("Saída de produto efetuada com sucesso.");
    }

    public void adicionarUsuario(String nome, String senha, boolean isAdmin) {
        Usuario usuario = new Usuario(nome, senha, isAdmin);
        usuarios.add(usuario);
        System.out.println("Usuário adicionado com sucesso.");
    }

    public void login(String nome, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nome) && usuario.getSenha().equals(senha)) {
                usuarioLogado = usuario;
                System.out.println("Login realizado com sucesso.");
                return;
            }
        }
        System.out.println("Nome de usuário ou senha incorretos.");
    }

    public void logout() {
        usuarioLogado = null;
        System.out.println("Logout realizado com sucesso.");
    }

    public void exportarRelatorioHorizontal() {
        System.out.println("Relatório Horizontal:");
        for (Produto produto : estoque.getProdutos()) {
            System.out.println(produto.getNome() + " | " + produto.getDescricao() + " | " + produto.getQuantidadeEmEstoque() + " | " + produto.getPreco() + " | " + produto.getValidade());
        }
    }

    public void exportarRelatorioVertical() {
        System.out.println("Relatório Vertical:");
        for (Produto produto : estoque.getProdutos()) {
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Descrição: " + produto.getDescricao());
            System.out.println("Quantidade em Estoque: " + produto.getQuantidadeEmEstoque());
            System.out.println("Preço: " + produto.getPreco());
            System.out.println("Validade: " + produto.getValidade());
            System.out.println("---------------------------");
        }
    }

    public Produto encontrarProduto(String nome) {
        for (Produto produto : estoque.getProdutos()) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                return produto;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        SistemaEstoque sistema = new SistemaEstoque();
        Scanner scanner = new Scanner(System.in);

        sistema.adicionarUsuario("admin", "321", true);
        sistema.adicionarUsuario("user", "123", false);

        boolean executando = true;
        while (executando) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Login");
            System.out.println("2 - Cadastrar Produto");
            System.out.println("3 - Efetuar Entrada de Produto");
            System.out.println("4 - Efetuar Saída de Produto");
            System.out.println("5 - Exportar Relatório Horizontal");
            System.out.println("6 - Exportar Relatório Vertical");
            System.out.println("7 - Logout");
            System.out.println("8 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome de usuário:");
                    String nomeUsuario = scanner.nextLine();
                    System.out.println("Digite a senha:");
                    String senha = scanner.nextLine();
                    sistema.login(nomeUsuario, senha);
                    break;
                case 2:
                    sistema.verificarisAdmin();
                    System.out.println("Digite o nome do produto:");
                    String nomeProduto = scanner.nextLine();
                    System.out.println("Digite a descrição do produto:");
                    String descricao = scanner.nextLine();
                    System.out.println("Digite a quantidade em estoque:");
                    int quantidade = scanner.nextInt();
                    System.out.println("Digite o preço do produto:");
                    double preco = scanner.nextDouble();
                    System.out.println("Digite a validade do produto (aaaa-mm-dd):");
                    String validadeStr = scanner.next();
                    LocalDate validade = LocalDate.parse(validadeStr);
                    sistema.cadastrarProduto(nomeProduto, descricao, quantidade, preco, validade);
                    break;
                case 3:
                    System.out.println("Digite o nome do produto:");
                    String nomeEntrada = scanner.nextLine();
                    System.out.println("Digite a quantidade a ser adicionada:");
                    int quantidadeEntrada = scanner.nextInt();
                    sistema.efetuarEntradaDeProduto(nomeEntrada, quantidadeEntrada);
                    break;
                case 4:
                    System.out.println("Digite o nome do produto:");
                    String nomeSaida = scanner.nextLine();
                    System.out.println("Digite a quantidade a ser removida:");
                    int quantidadeSaida = scanner.nextInt();
                    sistema.efetuarSaidaDeProduto(nomeSaida, quantidadeSaida);
                    break;
                case 5:
                    sistema.exportarRelatorioHorizontal();
                    break;
                case 6:
                    sistema.exportarRelatorioVertical();
                    break;
                case 7:
                    sistema.logout();
                    break;
                case 8:
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        scanner.close();
        System.out.println("Sistema encerrado.");
    }
}
