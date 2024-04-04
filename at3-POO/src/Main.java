import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaBancario sistema = new SistemaBancario();

        boolean executando = true;
        while (executando) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Realizar operações");
            System.out.println("2 - Consultar Conta");
            System.out.println("3 - Criar conta");
            System.out.println("4 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    menuOperacoes(sistema, scanner);
                    break;
                case 2:
                    menuConsultarConta(sistema, scanner);
                    break;
                case 3:
                    menuCriarConta(sistema, scanner);
                    break;
                case 4:
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        System.out.println("Sistema encerrado.");
        scanner.close();
    }

    public static void menuOperacoes(SistemaBancario sistema, Scanner scanner) {
        System.out.println("Digite o número da conta:");
        int numeroConta = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        Conta conta = sistema.encontrarContaPorNumero(numeroConta);
        if (conta != null) {
            System.out.println("Escolha a operação:");
            System.out.println("1 - Depósito");
            System.out.println("2 - Saque");
            System.out.println("3 - Transferência");
            System.out.println("4 - Pagamento");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.println("Digite o valor do depósito:");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    System.out.println("Depósito de" + valorDeposito + "realizado com sucesso!");
                    break;
                case 2:
                    System.out.println("Digite o valor do saque:");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 3:
                    System.out.println("Digite o número da conta de destino:");
                    int numeroContaDestino = scanner.nextInt();
                    System.out.println("Digite o valor da transferência:");
                    double valorTransferencia = scanner.nextDouble();
                    Conta contaDestino = sistema.encontrarContaPorNumero(numeroContaDestino);
                    if (contaDestino != null) {
                        conta.transferir(contaDestino, valorTransferencia);
                        System.out.println("Transferência de" + valorTransferencia + "realizada com sucesso.");
                    } else {
                        System.out.println("Conta destino não encontrada.");
                    }
                    break;
                case 4:
                    System.out.println("Digite o valor do pagamento:");
                    double valorPagamento = scanner.nextDouble();
                    conta.pagar(valorPagamento);
                    System.out.println("Pagamento de" + valorPagamento + "realizado com sucesso.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public static void menuConsultarConta(SistemaBancario sistema, Scanner scanner) {
        System.out.println("Digite o número da conta:");
        int numeroConta = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        sistema.exibirExtrato(numeroConta);
    }

    public static void menuCriarConta(SistemaBancario sistema, Scanner scanner) {
        System.out.println("Digite o número da conta:");
        int numeroConta = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.println("Digite o titular da conta:");
        String titular = scanner.nextLine();

        System.out.println("Escolha o tipo de conta:");
        System.out.println("1 - Poupança");
        System.out.println("2 - Corrente");
        int tipoConta = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        if (tipoConta == 1) {
            sistema.criarContaPoupanca(numeroConta, titular);
            System.out.println("Conta poupança criada com sucesso.");
        } else if (tipoConta == 2) {
            sistema.criarContaCorrente(numeroConta, titular);
            System.out.println("Conta corrente criada com sucesso.");
        } else {
            System.out.println("Opção inválida. Tente novamente.");
        }
    }

    
}
