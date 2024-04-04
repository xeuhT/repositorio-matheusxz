public class ContaCorrente extends Conta {
    private double limiteCredito;
    private double taxaJurosChequeEspecial;

    public ContaCorrente(int numeroConta, String titular) {
        super(numeroConta, titular);
        this.limiteCredito = 1000; // Exemplo de limite de crédito
        this.taxaJurosChequeEspecial = 0.1; // Exemplo de taxa de juros do cheque especial
    }

    @Override
    public void sacar(double valor) {
        if (valor <= this.saldo + this.limiteCredito) {
            this.saldo -= valor;
        } else {
            System.out.println("Limite de crédito excedido");
        }
    }

    public void atualizarSaldo() {
        if (this.saldo < 0) {
            this.saldo += this.saldo * this.taxaJurosChequeEspecial;
        }
    }
}