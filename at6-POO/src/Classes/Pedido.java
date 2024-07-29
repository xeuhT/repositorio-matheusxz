package Classes;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Produto> itens;
    private double valorTotal;
    private EstrategiaImposto estrategiaImposto;
    private NotaFiscal notaFiscal;

    public Pedido(EstrategiaImposto estrategiaImposto) {
        this.itens = new ArrayList<>();
        this.estrategiaImposto = estrategiaImposto;
    }

    public void addProduto(Produto produto) {
        itens.add(produto);
        this.valorTotal += produto.getPreco();
    }

    public double calcularValorTotal() {
        valorTotal = 0;
        for (Produto produto : itens) {
            valorTotal += produto.getPreco();
        }
        valorTotal += estrategiaImposto.calcularImposto(valorTotal);
        
        return valorTotal;
    }


    public List<Produto> getProdutos() {
        return new ArrayList<>(itens);
    }

    public void setItens(List<Produto> itens) {
        this.itens = itens;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double total) {
        this.valorTotal = total;
    }

    public NotaFiscal getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(NotaFiscal notaFiscal) {
        this.notaFiscal = notaFiscal;
    }
}
