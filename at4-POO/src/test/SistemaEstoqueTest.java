package test;

import main.SistemaEstoque;
import model.*;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class SistemaEstoqueTest {
    private SistemaEstoque sistema;

    @Before
    public void setUp() {
        sistema = new SistemaEstoque();
        sistema.adicionarUsuario("admin", "admin123", true);
        sistema.adicionarUsuario("user", "user123", false);
    }

    @Test
    public void testLoginAdmin() {
        sistema.login("admin", "admin123");
        assertTrue(sistema.verificarisAdmin());
    }

    @Test
    public void testLoginUser() {
        sistema.login("user", "user123");
        assertFalse(sistema.verificarisAdmin());
    }

    @Test
    public void testCadastrarProdutoComoAdmin() {
        sistema.login("admin", "admin123");
        sistema.cadastrarProduto("Produto1", "Descrição Produto1", 100, 10.0, LocalDate.of(2024, 12, 31));
        Produto produto = sistema.encontrarProduto("Produto1");
        assertNotNull(produto);
        assertEquals("Produto1", produto.getNome());
        assertEquals(100, produto.getQuantidadeEmEstoque());
        assertEquals(10.0, produto.getPreco(), 0.01);
    }

    @Test
    public void testCadastrarProdutoComoUsuario() {
        sistema.login("user", "user123");
        sistema.cadastrarProduto("Produto2", "Descrição Produto2", 100, 10.0, LocalDate.of(2024, 12, 31));
        Produto produto = sistema.encontrarProduto("Produto2");
        assertNull(produto);
    }

    @Test
    public void testEfetuarEntradaDeProduto() {
        sistema.login("admin", "admin123");
        sistema.cadastrarProduto("Produto1", "Descrição Produto1", 100, 10.0, LocalDate.of(2024, 12, 31));
        sistema.efetuarEntradaDeProduto("Produto1", 50);
        Produto produto = sistema.encontrarProduto("Produto1");
        assertNotNull(produto);
        assertEquals(150, produto.getQuantidadeEmEstoque());
    }

    @Test
    public void testEfetuarSaidaDeProduto() {
        sistema.login("admin", "admin123");
        sistema.cadastrarProduto("Produto1", "Descrição Produto1", 100, 10.0, LocalDate.of(2024, 12, 31));
        sistema.efetuarSaidaDeProduto("Produto1", 30);
        Produto produto = sistema.encontrarProduto("Produto1");
        assertNotNull(produto);
        assertEquals(70, produto.getQuantidadeEmEstoque());
    }

    @Test
    public void testExportarRelatorioHorizontal() {
        sistema.login("admin", "admin123");
        sistema.cadastrarProduto("Produto1", "Descrição Produto1", 100, 10.0, LocalDate.of(2024, 12, 31));
        sistema.exportarRelatorioHorizontal(); // Aqui, você deve verificar a saída no console
    }

    @Test
    public void testExportarRelatorioVertical() {
        sistema.login("admin", "admin123");
        sistema.cadastrarProduto("Produto1", "Descrição Produto1", 100, 10.0, LocalDate.of(2024, 12, 31));
        sistema.exportarRelatorioVertical(); // Aqui, você deve verificar a saída no console
    }
}
