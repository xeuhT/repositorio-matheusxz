package Classes;

public class BoletoBancario implements Pagamento {
    private String codigoBoleto;

    public BoletoBancario(String codigoBoleto) {
        this.codigoBoleto = codigoBoleto;
    }

    @Override
    public boolean realizarPagamento(double valor) {
        System.out.println("Método de pagamento Boleto Bancário Confirmado.");
        return true;
    }
}

