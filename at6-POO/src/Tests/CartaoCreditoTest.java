package Tests;

import Classes.CartaoCredito;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartaoCreditoTest {

    @Test
    public void testRealizarPagamento() {
        CartaoCredito cartao = new CartaoCredito("1234-5678-9012-3456");
        boolean resultado = cartao.realizarPagamento(100.0);
        assertTrue(resultado, "Pagamento com cartão de crédito deve ser confirmado.");
    }
}
