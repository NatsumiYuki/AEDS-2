import java.util.*;

public class Main {

    // Função para verificar se a palavra contém apenas vogais
    public static boolean onlyVowels(String word) {
        for (char c : word.toCharArray()) {
            if (!isVowel(c)) {
                return false;
            }
        }
        return true;
    }

    // Função para verificar se a palavra contém apenas consoantes
    public static boolean onlyConsonants(String word) {
        for (char c : word.toCharArray()) {
            if (!isConsonant(c)) {
                return false;
            }
        }
        return true;
    }

    // Função para verificar se a palavra contém apenas números inteiros
    public static boolean onlyIntegers(String word) {
        for (char c : word.toCharArray()) {
            if (!isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    // Função para verificar se a palavra contém apenas números reais
    public static boolean onlyRealNumbers(String word) {
        boolean hasDot = false;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (isDigit(c)) {
                continue;
            } else if ((c == '.' || c == ',') && !hasDot) {
                hasDot = true;
            } else {
                return false;
            }
        }
        return true;
    }

    // Função auxiliar para verificar se um caractere é uma vogal
    private static boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }

    // Função auxiliar para verificar se um caractere é uma consoante
    private static boolean isConsonant(char c) {
        return Character.isLetter(c) && !isVowel(c);
    }

    // Função auxiliar para verificar se um caractere é um dígito
    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        while (!word.equals("FIM")) {
            boolean oV = onlyVowels(word);
            boolean oC = onlyConsonants(word);
            boolean oI = onlyIntegers(word);
            boolean oR = onlyRealNumbers(word);

            System.out.println((oV ? "SIM" : "NAO") + " " +
                    (oC ? "SIM" : "NAO") + " " +
                    (oI ? "SIM" : "NAO") + " " +
                    (oR ? "SIM" : "NAO"));

            word = sc.nextLine();
        }
        sc.close();
    }
}