package Main;

import java.util.Scanner;
import Classes.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estoque estoque = new Estoque();
        ServicoNotificacao servicoNotificacao = new ServicoNotificacao();

        System.out.println("Cadastro de Produtos:");
        Produto produto1 = new Produto("Livro", "Livro de Java", 50.0);
        Produto produto2 = new Produto("Notebook", "Notebook Dell", 3000.0);

        produto1.atualizarPreco(55.0);
        
        System.out.println("Produto 1: " + produto1.getNome() + " - " + produto1.getDescricao() + " - R$ " + produto1.getPreco());
        System.out.println("Produto 2: " + produto2.getNome() + " - " + produto2.getDescricao() + " - R$ " + produto2.getPreco());

        EstrategiaImposto estrategiaImposto = new EstrategiaImpostoPadrao();
        Pedido pedido = new Pedido(estrategiaImposto);

        pedido.addProduto(produto1);
        pedido.addProduto(produto2);
        estoque.adicionarProduto(produto1, 10);
        estoque.adicionarProduto(produto2, 5);

        System.out.println("Calculando o total do pedido...");
        double totalPedido = pedido.calcularValorTotal();
        System.out.println("Total do Pedido (com impostos): R$ " + totalPedido);

        System.out.println("Deseja continuar?");
        System.out.println("1. Cartão de Crédito");
        System.out.println("2. Boleto Bancário");
        int opcao = scanner.nextInt();

        Pagamento pagamento;
        if (opcao == 1) {
            pagamento = new CartaoCredito("123456789");
        } else {
            pagamento = new BoletoBancario("987654321");
        }

        if (pagamento.realizarPagamento(totalPedido)) {

            String idPedido = GeradorID.gerarIDUnico();
            NotaFiscal notaFiscal = new NotaFiscal(GeradorID.gerarIDUnico(), totalPedido);
            Cliente cliente = new Cliente("João", "Rua Exemplo, 123");
            ControladorCheckout controlador = new ControladorCheckout(pedido, pagamento, notaFiscal, estoque, cliente);

            controlador.validarPedido();
            controlador.calcularFrete();
            totalPedido = pedido.getValorTotal();
            controlador.atualizarEstoque();
            

            System.out.println("Valor total do pedido com frete: " + totalPedido);

            System.out.println("Pagamento realizado com sucesso!");
            controlador.gerarNotaFiscal();
            servicoNotificacao.enviarEmail(cliente.getNome(), "Seu pedido foi processado com sucesso!");
            controlador.enviarNotificacao();
        } else {
            System.out.println("Falha ao realizar o pagamento.");
        }

        scanner.close();
    }
}
