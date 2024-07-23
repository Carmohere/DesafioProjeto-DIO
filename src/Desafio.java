import java.util.Scanner;

abstract class Cofre {
    protected String tipo;
    protected String metodoAbertura;

    public Cofre(String tipo, String metodoAbertura) {
        this.tipo = tipo;
        this.metodoAbertura = metodoAbertura;
    }

    public void imprimirInformacoes() {
        System.out.println("Tipo: " + this.tipo);
        System.out.println("Metodo de abertura: " + this.metodoAbertura);
    }
}

class CofreDigital extends Cofre {

    private int senha;

    public CofreDigital(int senha) {
        super("Cofre Digital", "Senha");
        this.senha = senha;
    }

    public boolean validarSenha(int confirmacaoSenha) {
        return confirmacaoSenha == this.senha;
    }
}

class CofreFisico extends Cofre {

    public CofreFisico() {
        super("Cofre Fisico", "Chave");
    }

}

public class Desafio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lê o tipo de cofre (primeira linha da entrada)
        System.out.println();
        String tipoCofre = scanner.nextLine().trim().toLowerCase();

        Cofre cofre = null;

        if (tipoCofre.equals("digital")) {
            // Solicita a senha para o cofre digital
            System.out.println();
            int senha = scanner.nextInt();
            cofre = new CofreDigital(senha);

            // Exibe as informações do cofre digital
            cofre.imprimirInformacoes();

            // Solicita a confirmação da senha
            System.out.println();
            int confirmacaoSenha = scanner.nextInt();

            CofreDigital cofreDigital = (CofreDigital) cofre;
            if (cofreDigital.validarSenha(confirmacaoSenha)) {
                System.out.println("Cofre aberto!");
            } else {
                System.out.println("Senha incorreta!");
            }

        } else if (tipoCofre.equals("fisico")) {
            cofre = new CofreFisico();
            cofre.imprimirInformacoes();

        } else {
            System.out.println("Tipo de cofre inválido!");
        }

        scanner.close();
    }
}
