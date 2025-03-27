
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String palavra = sc.nextLine();

        while (palavra.compareTo("FIM") != 0){
            boolean ePalindromo = verificarPalindromo(palavra);
            if (ePalindromo) {
                System.out.print("SIM\n");
            } else {
                System.out.print("NAO\n");
            }
            palavra = sc.nextLine(); 
        }
        sc.close();
    }

    private static boolean verificarPalindromo(String palavra){
        StringBuilder palavraInversa = new StringBuilder(palavra).reverse();
        return palavra.equals(palavraInversa.toString());
    }
}
    
/*
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String frase = sc.nextLine();

        while(frase.compareTo("FIM") != 0){
            String formatFrase = formatFrase(frase);
            String reverse = reversePalindromo(formatFrase);
            boolean isPalindromo = isPalindromo(reverse, formatFrase);
            if (isPalindromo) {
                System.out.println("SIM");
            } else {
                System.out.println("NAO");
            }
            frase = sc.nextLine();
        };

        sc.close();
    }
        static String formatFrase(String frase){
            String freeFrase = frase.replaceAll("[\\s\\p{Punct}]", "");
            return freeFrase;
        }
            
        static String reversePalindromo(String frase){
            StringBuilder sb = new StringBuilder(frase);
            String reverseFrase = sb.reverse().toString();
            return reverseFrase;
        }
        
        static boolean isPalindromo(String reverse, String frase) {
            return reverse.equals(frase);
        }


}*/