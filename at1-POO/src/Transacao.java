import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacao {
    private String tipo;
    private double valor;
    private LocalDateTime dataHora;
    private int numeroContaOrigem;

    public Transacao(String tipo, double valor, LocalDateTime dataHora, int numeroContaOrigem) {
        this.tipo = tipo;
        this.valor = valor;
        this.dataHora = dataHora;
        this.numeroContaOrigem = numeroContaOrigem;
    }

    public String formatarDataHora() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return dataHora.format(formatter);
    }

    @Override
    public String toString() {
        return "Transação [tipo=" + tipo + ", valor=" + valor + ", Conta de Origem=" + numeroContaOrigem +
                ", Data e Hora=" + formatarDataHora() + "]";
    }
}