import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            char[] resultado = new char[linha.length()];
            int inicio = 0;
            int fim = 0;
            int pos = 0;
            
            for (int i = 0; i < linha.length(); i++) {
                char c = linha.charAt(i);
                
                if (c == '[') {
                    pos = inicio; // Move para o início
                } 
                else if (c == ']') {
                    pos = fim; // Move para o fim
                } 
                else {
                    // Desloca os caracteres para abrir espaço
                    for (int j = fim; j > pos; j--) {
                        resultado[j] = resultado[j-1];
                    }
                    resultado[pos] = c;
                    pos++;
                    fim++;
                }
            }
            
            System.out.println(new String(resultado, 0, fim));
        }
        
        sc.close();
    }
}