package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import model.*;
import java.time.LocalDate;
public class EstoqueTest {

    @Test
    public void testAdicionarProduto() {
        Estoque estoque = new Estoque();
        Produto produto = new Produto("Arroz", "Arroz branco", 100, 5.99, LocalDate.of(2023, 12, 31));
        estoque.adicionarProduto(produto);
        assertTrue(estoque.getProdutos().contains(produto));
    }

    @Test
    public void testRemoverProduto() {
        Estoque estoque = new Estoque();
        Produto produto = new Produto("Arroz", "Arroz branco", 100, 5.99, LocalDate.of(2023, 12, 31));
        estoque.adicionarProduto(produto);
        estoque.removerProduto(produto);
        assertFalse(estoque.getProdutos().contains(produto));
    }

    @Test
    public void testAtualizarQuantidadeProduto() {
        Estoque estoque = new Estoque();
        Produto produto = new Produto("Arroz", "Arroz branco", 100, 5.99, LocalDate.of(2023, 12, 31));
        estoque.adicionarProduto(produto);
        estoque.atualizarQuantidade(produto, 50);
        assertEquals(50, produto.getQuantidadeEmEstoque());
    }
}
