package Classes;

import Classes.*;
import Classes.HistoricoPreco.RegistroPreco;
import java.util.Date;
import java.util.List;

public class Produto {
    private String nome;
    private String descricao;
    private HistoricoPreco historicoPreco;

    public Produto(String nome, String descricao, double precoInicial) {
        this.nome = nome;
        this.descricao = descricao;
        this.historicoPreco = new HistoricoPreco();
        this.historicoPreco.registrarPreco(precoInicial, new Date());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return historicoPreco.getPrecoAtual();
    }

    public void atualizarPreco(double novoPreco) {
        historicoPreco.registrarPreco(novoPreco, new Date());
    }

    public List<RegistroPreco> getHistoricoPrecos() {
        return historicoPreco.getRegistros();
    }
}
