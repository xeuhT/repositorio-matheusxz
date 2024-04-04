import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Conta {
    private int numeroConta;
    private String titular;
    protected double saldo;
    private List<Transacao> transacoes;

    public Conta(int numeroConta, String titular) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = 0;
        this.transacoes = new ArrayList<>();
    }

    // Getters e Setters
    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }

    public void depositar(double valor) {
        this.saldo += valor;
        registrarTransacao("Depósito", valor);
    }

    public void sacar(double valor) {
        if (valor <= this.saldo) {
            this.saldo -= valor;
            registrarTransacao("Saque", -valor);
        } else {
            System.out.println("Impossível realizar o saque de " + valor + ". Saldo insuficiente");
        }
    }

    public void transferir(Conta destino, double valor) {
        if (valor <= this.saldo) {
            this.saldo -= valor;
            destino.saldo += valor;
            registrarTransacao("Transferência", -valor);
            destino.registrarTransacao("Transferência", valor);
        } else {
            System.out.println("Saldo insuficiente para transferência de " + valor);
        }
    }

    public void pagar(double valor) {
        if (valor <= this.saldo) {
            this.saldo -= valor;
            registrarTransacao("Pagamento", -valor);
        } else {
            System.out.println("Saldo insuficiente para pagamento de " + valor);
        }
    }

    private void registrarTransacao(String tipo, double valor) {
        Transacao transacao = new Transacao(tipo, valor, LocalDateTime.now(), this.numeroConta);
        this.transacoes.add(transacao);
    }

    public void exibirExtrato() {
        System.out.println("Extrato:");
        for (Transacao transacao : transacoes) {
            System.out.println(transacao);
        }
    }

    @Override
    public String toString() {
        return "Conta [numeroConta=" + numeroConta + ", titular=" + titular + ", saldo=" + saldo + "]";
    }
}