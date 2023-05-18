import javax.swing.JOptionPane;

public class Main {
    static int[][][] transicao = {{{0}, {0, 1}},{{2}, {2}},{{}, {}}};
    static int estadoInicial = 0;
    static int[] aceitacao = {2};

    public static void main(String[] args) {
        String cadeia = JOptionPane.showInputDialog("Digite uma cadeia");
        int[] estadoAtual = {estadoInicial};
        int posicao = 0;
        int[] estadosFinais = verificaEstados(cadeia, estadoAtual, 0);

        boolean aceita = false;
        if (aceita) {
            System.out.println("Cadeia Válida");
        } else {
            System.out.println("Cadeia Inválida");
        }

    }

    private static int[] verificaEstados(String entrada, int[]estados, int posicao) {
        if(posicao == entrada.length()) {
            imprime(entrada, estados[0], posicao);

            if(verifica(estados)){
                return estados;
            }
        System.out.println("Fim da cadeia");
        return null;
        }

        int elemento = Integer.parseInt(entrada.substring(posicao, posicao + 1));
        for(int i:estados) {
            imprime(entrada, i, posicao);
            int[] novosEstados = transicao[i][elemento];
            if (novosEstados.length == 0) {
                System.out.println("Sem opções");
                return null;
            }
            int[]transicoes = verifica(entrada, )
        }
        return null;
    }

    private static boolean verifica(int[] estados) {
        if(estados == null) return false;
        for(int i:estados) {
            for(int j: aceitacao) {
                if(i == j) return true;
            }
        }
        return false;
    }

    public static void imprime(String entrada, int estado, int posicao) {
        System.out.println(entrada.substring(0, posicao));
        System.out.println("[q "+estado+"]");
    }

}
