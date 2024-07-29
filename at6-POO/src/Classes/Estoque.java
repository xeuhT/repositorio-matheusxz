package Classes;

import java.util.HashMap;
import java.util.Map;

public class Estoque {
    private Map<Produto, Integer> produtos;

    public Estoque() {
        this.produtos = new HashMap<>();
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        if (produtos.containsKey(produto)) {
            produtos.put(produto, produtos.get(produto) + quantidade);
        } else {
            produtos.put(produto, quantidade);
        }
        System.out.println("Produto adicionado ao estoque: " + produto.getNome() + " - Quantidade: " + quantidade);
    }

    public void removerProduto(Produto produto) {
        if (produtos.containsKey(produto) && produtos.get(produto) > 0) {
            produtos.put(produto, produtos.get(produto) - 1);
            System.out.println("Produto removido do estoque: " + produto.getNome() + " - Quantidade Restante: " + produtos.get(produto));
        } else {
            throw new IllegalStateException("Produto não disponível no estoque.");
        }
    }

    public int getQuantidade(Produto produto) {
        return produtos.getOrDefault(produto, 0);
    }
}
