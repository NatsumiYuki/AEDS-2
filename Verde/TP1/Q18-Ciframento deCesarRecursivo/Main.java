import java.util.*;

public class Main {

    private static String newWord(String word, int esq) {
        if (esq >= word.length()) {
            return ""; // Retorna string vazia quando atinge o final
        }

        char c = word.charAt(esq);
        if (c > 0 && c <= 127) {
            c = (char) (c + 3); // Soma 3 ao valor ASCII do caractere
        }

        return Character.toString(c) + newWord(word, esq + 1); // Concatena o caractere modificado com o resto da string
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String word = sc.nextLine();

        while (!word.equals("FIM")) { 
            String encryptedWord = newWord(word, 0); 
            System.out.println(encryptedWord); 
            word = sc.nextLine(); 
        }

        sc.close();
    }
}
