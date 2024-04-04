import java.util.ArrayList;
import java.util.List;

public class SistemaBancario {
    private List<Conta> listaContas;

    public SistemaBancario() {
        this.listaContas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta) {
        listaContas.add(conta);
    }

    public Conta encontrarContaPorNumero(int numeroConta) {
        for (Conta conta : listaContas) {
            if (conta.getNumeroConta() == numeroConta) {
                return conta;
            }
        }
        return null; // Retorna null se a conta não for encontrada
    }

    public void criarContaPoupanca(int numeroConta, String titular) {
        ContaPoupanca conta = new ContaPoupanca(numeroConta, titular);
        adicionarConta(conta);
    }

    public void criarContaCorrente(int numeroConta, String titular) {
        ContaCorrente conta = new ContaCorrente(numeroConta, titular);
        adicionarConta(conta);
    }

    public void exibirExtrato(int numeroConta) {
        Conta conta = encontrarContaPorNumero(numeroConta);
        if (conta != null) {
            conta.exibirExtrato();
        } else {
            System.out.println("Conta não encontrada.");
        }
    }
}
