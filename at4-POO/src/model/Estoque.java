package model;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Produto> produtos;

    public Estoque() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    public void atualizarQuantidade(Produto produto, int novaQuantidade) {
        produto.setQuantidadeEmEstoque(novaQuantidade);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}