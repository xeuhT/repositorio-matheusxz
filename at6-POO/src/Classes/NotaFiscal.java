package Classes;
public class NotaFiscal {
    private String idNF;
    private double valorTotal;

    public NotaFiscal(String idNF, double valorTotal) {
        this.idNF = idNF;
        this.valorTotal = valorTotal;
    }

    public String getidNF() {
        return idNF;
    }

    public void setidNF(String idNF) {
        this.idNF = idNF;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
