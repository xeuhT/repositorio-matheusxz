package Tests;

import Classes.Estoque;
import Classes.Produto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EstoqueTest {

    @Test
    public void testAdicionarProduto() {
        Estoque estoque = new Estoque();
        Produto produto = new Produto("Livro", "Livro de Java", 50.0);
        
        estoque.adicionarProduto(produto, 10);
        
        assertEquals(10, estoque.getQuantidade(produto), "A quantidade de produto no estoque deve ser 10.");
    }

    @Test
    public void testRemoverProduto() {
        Estoque estoque = new Estoque();
        Produto produto = new Produto("Livro", "Livro de Java", 50.0);
        
        estoque.adicionarProduto(produto, 10);
        estoque.removerProduto(produto);
        
        assertEquals(9, estoque.getQuantidade(produto), "A quantidade de produto no estoque deve ser 9.");
    }

    @Test
    public void testRemoverProdutoNaoDisponivel() {
        Estoque estoque = new Estoque();
        Produto produto = new Produto("Livro", "Livro de Java", 50.0);
        
        assertThrows(IllegalStateException.class, () -> estoque.removerProduto(produto), "Deve lançar uma exceção se o produto não estiver disponível no estoque.");
    }
}