package Classes;
import Classes.*;

public class ControladorCheckout {
    private Pedido pedido;
    private NotaFiscal notaFiscal;
    private Estoque estoque;
    private Cliente cliente;

    public ControladorCheckout(Pedido pedido, Pagamento pagamento, NotaFiscal notaFiscal, Estoque estoque, Cliente cliente) {
        this.pedido = pedido;
        this.notaFiscal = notaFiscal;
        this.estoque = estoque;
        this.cliente = cliente;
    }

    public void validarPedido() {
        if (pedido.getProdutos().isEmpty()) {
            throw new IllegalArgumentException("O pedido não pode estar vazio.");
        }
        System.out.println("Pedido validado com sucesso.");
    }

    public void calcularFrete() {
        double frete = 10;
        double valorTotalComFrete = pedido.getValorTotal() + frete;
        pedido.setValorTotal(valorTotalComFrete);
        System.out.println("Frete de R$ " + frete + " calculado e adicionado ao valor total do pedido.");
    }

    public void gerarNotaFiscal() {
        notaFiscal = new NotaFiscal(GeradorID.gerarIDUnico(), pedido.getValorTotal());
        pedido.setNotaFiscal(notaFiscal);
        System.out.println("Nota Fiscal gerada: Número " + notaFiscal.getidNF() + " - Valor Total: R$ " + pedido.getValorTotal());
    }

    public void atualizarEstoque() {
        for (Produto produto : pedido.getProdutos()) {
            estoque.removerProduto(produto);
        }
        System.out.println("Estoque atualizado.");
    }

    public void enviarNotificacao() {
        ServicoNotificacao servicoNotificacao = new ServicoNotificacao();
        servicoNotificacao.enviarEmail(cliente.getNome(), "Seu pedido foi processado com sucesso!");
        System.out.println("Notificação enviada ao cliente.");
    }

    
}

