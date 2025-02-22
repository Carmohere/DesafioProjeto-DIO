import java.util.Scanner;

public class MainContaBancaria {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Cria uma nova conta bancária com o saldo inicial
        double saldoInicial = scanner.nextDouble();
        ContaBancariaa conta = new ContaBancariaa(saldoInicial);

        // Lê a entrada com o valor do depósito e aciona o método "depositar"
        double valorDeposito = scanner.nextDouble();
        conta.depositar(valorDeposito);

        // Lê a entrada com o valor do saque e aciona o método "sacar"
        double valorSaque = scanner.nextDouble();
        conta.sacar(valorSaque);

        // Fechar o scanner para evitar vazamentos de recursos
        scanner.close();
    }
}

class ContaBancaria {
    private double saldo;

    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        // Incrementa o saldo com o valor e imprime "Depósito feito."
        this.saldo += valor;
        System.out.println("Deposito feito.");
        imprimirSaldo();
    }

    public void sacar(double valor) {
        // Verifica se o saldo é suficiente
        if (valor <= this.saldo) {
            // Atualiza o saldo e imprime "Saque feito."
            this.saldo -= valor;
            System.out.println("Saque feito.");
        } else {
            // Imprime "Saldo insuficiente. Saque não realizado."
            System.out.println("Saldo insuficiente. Saque não realizado.");
        }
        imprimirSaldo();
    }

    private void imprimirSaldo() {
        System.out.printf("Saldo atual: %.1f\n", this.saldo);
    }
}
