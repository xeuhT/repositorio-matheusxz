package Tests;

import Classes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ControladorCheckoutTest {

    private Pedido pedido;
    private Estoque estoque;
    private Cliente cliente;
    private ControladorCheckout controladorCheckout;

    @BeforeEach
    public void setUp() {
        EstrategiaImposto estrategiaImposto = new EstrategiaImpostoPadrao();
        pedido = new Pedido(estrategiaImposto);
        estoque = new Estoque();
        cliente = new Cliente("João", "Rua A");
        controladorCheckout = new ControladorCheckout(pedido, new CartaoCredito("1234-5678-9012-3456"), new NotaFiscal("1", 100.0), estoque, cliente);
    }

    @Test
    public void testValidarPedido() {
        Produto produto = new Produto("Livro", "Livro de Java", 50.0);
        pedido.addProduto(produto);
        
        assertDoesNotThrow(() -> controladorCheckout.validarPedido(), "O pedido deve ser validado com sucesso.");
    }

    @Test
    public void testCalcularFrete() {
        Produto produto = new Produto("Livro", "Livro de Java", 50.0);
        pedido.addProduto(produto);
        controladorCheckout.calcularFrete();
        
        assertEquals(60.0, pedido.getValorTotal(), 0.01, "O valor total do pedido deve incluir o frete.");
    }

    @Test
    public void testGerarNotaFiscal() {
        Produto produto = new Produto("Livro", "Livro de Java", 50.0);
        pedido.addProduto(produto);
        controladorCheckout.calcularFrete();
        controladorCheckout.gerarNotaFiscal();
        
        assertNotNull(pedido.getNotaFiscal(), "A nota fiscal deve ser gerada.");
    }

    @Test
    public void testAtualizarEstoque() {
        Produto produto = new Produto("Livro", "Livro de Java", 50.0);
        estoque.adicionarProduto(produto, 5);
        pedido.addProduto(produto);
        
        controladorCheckout.atualizarEstoque();
        
        assertEquals(4, estoque.getQuantidade(produto), "A quantidade no estoque deve ser atualizada.");
    }

    @Test
    public void testEnviarNotificacao() {
        controladorCheckout.enviarNotificacao();
        // Verificar a saída do console para confirmação da notificação (simulação)
    }
}
