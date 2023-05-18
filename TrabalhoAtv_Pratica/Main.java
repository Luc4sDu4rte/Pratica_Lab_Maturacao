import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("_________________________________________________________________________________");
        System.out.println("Formato de Nome válido: Primeira letra maiúscula e no máximo 40 caracteres");
        System.out.println("Formato de CPF válido: xxx.xxx.xxx-xx");
        System.out.println("Formato de Número válido: +123(12)1234-1234 ou +123(12)12345-1234");
        System.out.println("Formato de Senha válida: Deve conter letras e números de no mínimo 4 e máximo 10");
        System.out.println("_________________________________________________________________________________\n");

        String nome = validarEntrada(scanner, "Digite um nome válido: ", "Formato de nome inválido. Tente novamente.","^[A-Z][a-zA-Z]{1,39}(?: [A-Z][a-zA-Z]{0,38})?$");
        String cpf = validarEntrada(scanner, "Digite um CPF válido: ", "Tipo de CPF inválido. Tente novamente.","\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
        String telefone = validarEntrada(scanner, "Digite um número válido: ", "Número inválido. Tente novamente.","\\+\\d{3}\\(\\d{2}\\)\\d{4,5}-\\d{4}"); 
        String senha = validarEntrada(scanner, "Digite uma senha válida: ", "Tipo de senha inválida. Tente novamente.","^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z\\d]{4,10}$");
        scanner.close();

        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Telefone: " + telefone);
        System.out.println("Senha: " + senha);
        System.out.println("Fim das operações");
    }

    private static String validarEntrada(Scanner scanner, String mensagem, String mensagemErro, String regex) {
        String entrada = "";
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.print(mensagem);
            entrada = scanner.nextLine();

            if (Pattern.matches(regex, entrada)) {
                System.out.println("Aceito!\n");
                entradaValida = true;
            } else {
                System.out.println(mensagemErro);
            }
        }

        return entrada;
    }
}
