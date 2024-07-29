package Tests;

import Classes.HistoricoPreco;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HistoricoPrecoTest {

    @Test
    public void testRegistrarPreco() {
        HistoricoPreco historico = new HistoricoPreco();
        double preco = 100.0;
        Date data = new Date();
        
        historico.registrarPreco(preco, data);
        
        List<HistoricoPreco.RegistroPreco> registros = historico.getRegistros();
        assertEquals(1, registros.size(), "Deve haver um registro de preço.");
        assertEquals(preco, registros.get(0).getPreco(), 0.01, "O preço registrado deve ser 100.0.");
        assertEquals(data, registros.get(0).getData(), "A data registrada deve ser a data atual.");
    }

    @Test
    public void testGetPrecoAtual() {
        HistoricoPreco historico = new HistoricoPreco();
        double preco1 = 100.0;
        double preco2 = 200.0;
        Date data = new Date();
        
        historico.registrarPreco(preco1, data);
        historico.registrarPreco(preco2, data);
        
        assertEquals(preco2, historico.getPrecoAtual(), 0.01, "O preço atual deve ser 200.0.");
    }
}