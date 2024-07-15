package service;

import model.Estoque;
import model.Produto;

public class RelatorioService {

    public String exportarRelatorioCSV(Estoque estoque) {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome,Descrição,Quantidade,Preço,Validade\n");
        for (Produto produto : estoque.getProdutos()) {
            sb.append(produto.getNome()).append(",");
            sb.append(produto.getDescricao()).append(",");
            sb.append(produto.getQuantidadeEmEstoque()).append(",");
            sb.append(produto.getPreco()).append(",");
            sb.append(produto.getValidade()).append("\n");
        }
        return sb.toString();
    }
}
