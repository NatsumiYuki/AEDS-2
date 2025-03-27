import java.util.Scanner;

public class Main {
    public static int lengthOfLongestSubstring(String s) {
        int[] freq = new int[128]; // Vetor para armazenar a frequência dos caracteres (ASCII)
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right)]++; // Marca o caractere atual
            
            // Se o caractere já apareceu antes, reduzimos a janela
            while (freq[s.charAt(right)] > 1) {
                freq[s.charAt(left)]--; // Removemos o caractere da esquerda
                left++; 
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        while (!word.equals("FIM")) {
            System.out.println(lengthOfLongestSubstring(word));
            word = scanner.nextLine();
        }
        scanner.close();
    }
}
