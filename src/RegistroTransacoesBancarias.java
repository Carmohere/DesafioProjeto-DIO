import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegistroTransacoesBancarias {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lê a Entrada que informa o saldo inicial da conta
        double saldo = scanner.nextDouble();

        // Lê a Entrada com a quantidade total de transações
        int quantidadeTransacoes = scanner.nextInt();

        // Listas para armazenar as transações de depósitos e saques
        List<String> depositos = new ArrayList<>();
        List<String> saques = new ArrayList<>();

        // Loop para iterar sobre as transações
        for (int i = 1; i <= quantidadeTransacoes; i++) {
            // Lê a Entrada com o tipo de transação (D para depósito ou S para saque)
            // O método "toUpperCase" padroniza o tipo de transação com a letra maiúscula
            char tipoTransacao = scanner.next().toUpperCase().charAt(0);
            // Lê a Entrada com o valor da transação
            double valorTransacao = scanner.nextDouble();

            // Atualiza o saldo da conta e adicionar a transação à lista apropriada
            if (tipoTransacao == 'D') {
                saldo += valorTransacao;
                depositos.add("Deposito de " + valorTransacao);
            } else if (tipoTransacao == 'S') {
                saldo -= valorTransacao;
                saques.add("Saque de " + valorTransacao);
            } else {
                System.out.println("Opção inválida. Utilize D para depósito ou S para saque.");
                i--; // Decrementa o índice para repetir a iteração
            }
        }

        // Exibir o saldo final
        System.out.println("Saldo: " + saldo);

        // Exibir as transações de depósito
        System.out.println("Transacoes:");
        int index = 1;
        for (String deposito : depositos) {
            System.out.println(index + ". " + deposito);
            index++;
        }

        // Exibir as transações de saque
        for (String saque : saques) {
            System.out.println(index + ". " + saque);
            index++;
        }

        // Fechar o scanner para evitar vazamentos de recursos
        scanner.close();
    }
}
