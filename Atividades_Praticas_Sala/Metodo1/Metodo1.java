import javax.swing.JOptionPane;
// Possui no máximo "1"

public class Metodo1 {
    //matriz de transição; alfabeto; estados(iniciais e finais).
    static int [][] transicao = {{0,1},{1,0}};
    static int estadoInicial = 0;
    static int [] aceitacao = {1};
    public static void main(String[] args) {
        // Programa possui: entrada --> processamento --> saida

        //entrada:
        String cadeia = JOptionPane.showInputDialog("Digite uma cadeia");
        
        //processamento:
        //prepração-processamento:
        int estadoAtual = estadoInicial;
        int posicao = 0;
        
        //processamento:
        while(posicao < cadeia.length()) {
            char elemento = cadeia.charAt(posicao);
            int elementoInt = Integer.parseInt(elemento+"");
            estadoAtual = transicao[estadoAtual][elementoInt];
            posicao++;
            
        }

        boolean aceita = false;
        for(int i:aceitacao) {
            if(estadoAtual == i) {
                aceita = true;

            }

        }

        if(aceita == true) {
            System.out.println("Cadeia Válida");

        }else{
            System.out.println("Cadeia Inválida");
            
        }

    }
    
}
