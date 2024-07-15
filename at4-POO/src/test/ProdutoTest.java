package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import model.*;


public class ProdutoTest {

    @Test
    public void testCriacaoProduto() {
        Produto produto = new Produto("Arroz", "Arroz branco", 100, 5.99, LocalDate.of(2023, 12, 31));
        assertEquals("Arroz", produto.getNome());
        assertEquals("Arroz branco", produto.getDescricao());
        assertEquals(100, produto.getQuantidadeEmEstoque());
        assertEquals(5.99, produto.getPreco());
        assertEquals(LocalDate.of(2023, 12, 31), produto.getValidade());
    }

    @Test
    public void testSetQuantidadeEmEstoque() {
        Produto produto = new Produto("Arroz", "Arroz branco", 100, 5.99, LocalDate.of(2023, 12, 31));
        produto.setQuantidadeEmEstoque(50);
        assertEquals(50, produto.getQuantidadeEmEstoque());
    }
}