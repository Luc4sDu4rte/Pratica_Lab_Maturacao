import javax.swing.JOptionPane; 
// Termina com 01

public class Metodo2 {
    static int [][][] transicao = {{{0, 1}, {0}}, {{}, {2}}, {{}, {}}}; //numeros equivalem aos estados: q0 -> 0
    static int estadoInicial = 0;
    static int [] aceitacao = {2};
    
    public static void main(String[] args) {
        //entrada --> processamento --> saida

        //entrada
        String cadeia = JOptionPane.showInputDialog("Digite uma cadeia com 0s e 1s: ");

        //preparacao para pre processamento
        int [] estadoAtuais = {estadoInicial};
        int [] estadosFinais = verifica(cadeia, estadoAtuais, 0);
        int posicao = 0;

        if (verifica(estadosFinais)){
            System.out.println("Aceita");
        }
        else {
            System.out.println("Rejeita");}
        }
    //funcao backtracking recursiva
    private static int[] verifica(String entrada, int[] estados, int posicao) {
        if (posicao == entrada.length()){
            imprime(entrada, estados[0], posicao);
            if (verifica(estados)){
                return estados;
            }
            System.out.println("<<backtrack>> Fim da cadeia");
            return null;
        }
        int elemento = Integer.parseInt(entrada.substring(posicao, posicao + 1));
        for (int i:estados) {
            imprime(entrada, i, posicao);
            int[] novosEstados = transicao[i][elemento];
            if (novosEstados.length == 0){
                System.out.println("<<backtrack>> Sem opções");
                return null;
            }
            int[] transicao = verifica (entrada, novosEstados, posicao + 1) ;
            if(transicao != null) return transicao;
        }
        return null;
    }
    public static void imprime(String entrada, int estado, int posicao){
        System.out.print(entrada.substring(0, posicao));
        System.out.println("[q" + estado + "]");
        System.out.println(entrada.substring(posicao));
    }
    private static boolean verifica (int[] estados){
        if (estados == null) return false;
        for (int i:estados){
            for (int j:aceitacao){
                if (i == j) return true;
            }
        }
        return false;
    }
}