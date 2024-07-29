package Tests;

import Classes.BoletoBancario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoletoBancarioTest {

    @Test
    public void testRealizarPagamento() {
        BoletoBancario boleto = new BoletoBancario("1234567890");
        boolean resultado = boleto.realizarPagamento(100.0);
        assertTrue(resultado, "Pagamento com boleto bancário deve ser confirmado.");
    }
}
