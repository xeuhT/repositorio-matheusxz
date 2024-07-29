package Tests;

import Classes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    private Pedido pedido;
    private EstrategiaImposto estrategiaImposto;

    @BeforeEach
    public void setUp() {
        estrategiaImposto = new EstrategiaImpostoPadrao();
        pedido = new Pedido(estrategiaImposto);
    }

    @Test
    public void testAdicionarProduto() {
        Produto produto = new Produto("Livro", "Livro de Java", 50.0);
        pedido.addProduto(produto);
        
        assertEquals(1, pedido.getProdutos().size(), "O pedido deve conter um produto.");
        assertEquals(50.0, pedido.getValorTotal(), 0.01, "O valor total do pedido deve ser 50.0.");
    }

    @Test
    public void testCalcularValorTotalComImposto() {
        Produto produto = new Produto("Livro", "Livro de Java", 50.0);
        pedido.addProduto(produto);
        
        double valorTotalComImposto = pedido.calcularValorTotal();
        
        assertEquals(55.0, valorTotalComImposto, 0.01, "O valor total do pedido com imposto deve ser 55.0.");
    }

    @Test
    public void testSetNotaFiscal() {
        NotaFiscal notaFiscal = new NotaFiscal("12345", 100.0);
        pedido.setNotaFiscal(notaFiscal);
        
        assertNotNull(pedido.getNotaFiscal(), "A nota fiscal deve ser definida.");
        assertEquals("12345", pedido.getNotaFiscal().getidNF(), "O ID da nota fiscal deve ser 12345.");
    }
}
