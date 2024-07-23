import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RegistroTransacoesComStream {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leitura do saldo inicial e quantidade de transações
        double saldo = scanner.nextDouble();
        int quantidadeTransacoes = scanner.nextInt();

        List<Transacao> transacoes = new ArrayList<>();

        // Leitura das transações
        for (int i = 0; i < quantidadeTransacoes; i++) {
            char tipoTransacao = scanner.next().charAt(0);
            double valorTransacao = scanner.nextDouble();

            Transacao transacao = new Transacao(tipoTransacao, valorTransacao);
            transacoes.add(transacao);
        }

        // Atualização do saldo com base nas transações
        saldo = transacoes.stream()
                .mapToDouble(transacao -> {
                    if (Character.toUpperCase(transacao.getTipo()) == 'D') {
                        return transacao.getValor();
                    } else if (Character.toUpperCase(transacao.getTipo()) == 'S') {
                        return -transacao.getValor();
                    }
                    return 0;
                })
                .sum() + saldo;

        // Exibição do saldo final
        System.out.println("Saldo : " + saldo);

        // Exibição das transações formatadas
        System.out.println("Transacoes:");
        transacoes.stream()
                .map(transacao -> {
                    String tipo = Character.toUpperCase(transacao.getTipo()) == 'D' ? "d " : "s ";
                    return String.format("%s de %.1f", tipo, transacao.getValor());
                })
                .forEach(System.out::println);

        // Fechar o scanner para evitar vazamentos de recursos
        scanner.close();
    }
}

class Transacao {
    private char tipo;
    private double valor;

    public Transacao(char tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public char getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }
}
