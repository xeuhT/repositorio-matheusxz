package model;

import java.time.LocalDate;

public class Produto {
    private String nome;
    private String descricao;
    private int quantidadeEmEstoque;
    private double preco;
    private LocalDate validade;

    public Produto(String nome, String descricao, int quantidadeEmEstoque, double preco, LocalDate validade) {
        this.nome = nome;
        this.descricao = descricao;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.preco = preco;
        this.validade = validade;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public double getPreco() {
        return preco;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

}
