package Classes;

public class CartaoCredito implements Pagamento {
    private String numeroCartao;

    public CartaoCredito(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    @Override
    public boolean realizarPagamento(double valor) {
        System.out.println("Método de pagamento Cartão de Crédito Confirmado.");
        return true;
    }
}
