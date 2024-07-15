package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import service.*;
import model.*;

public class RelatorioServiceTest {

    @Test
    public void testExportarRelatorioCSV() {
        Estoque estoque = new Estoque();
        Produto produto = new Produto("Arroz", "Arroz branco", 100, 5.99, LocalDate.of(2023, 12, 31));
        estoque.adicionarProduto(produto);

        RelatorioService relatorioService = new RelatorioService();
        String relatorio = relatorioService.exportarRelatorioCSV(estoque);
        assertTrue(relatorio.contains("Arroz,Arroz branco,100,5.99,2023-12-31"));
    }
}
