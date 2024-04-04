public class ContaPoupanca extends Conta {
    private double taxaJuros;

    public ContaPoupanca(int numeroConta, String titular) {
        super(numeroConta, titular);
        this.taxaJuros = 0.05; // Exemplo de taxa de juros
    }

    public void atualizarSaldo() {
        this.saldo += this.saldo * this.taxaJuros;
    }
}