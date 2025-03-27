import java.util.*;

public class Main {

    public static boolean onlyVowels(String word, int size){
         for (int i = 0 ; i < size ; i++){
            char c = word.charAt(i);
            if(c != 'A' && c != 'a' && c != 'I' && c != 'i' && c != 'U' &&  c != 'u' && c != 'E' && c != 'e' && c != 'O' && c != 'o'){
                return false;
            }
         }
         return true;
    }

    public static boolean onlyConsonants(String word, int size){
        
        for(int i = 0 ; i < size ; i++){
            char c = word.charAt(i);
            if(c == 'A' || c == 'a' || c == 'I' || c == 'i' || c == 'U' ||  c == 'u' || c == 'E' || c == 'e' || c == 'O' || c == 'o' || c <= 57 && c >= 43){
                return false;
            }
        }
        return true;
    }
    
    public static boolean onlyIntegers(String word, int size) {
        for (int i = 0; i < size; i++) {
            char c = word.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

   
    public static boolean onlyRealNumbers(String word, int size) {
        boolean hasDigit = false; 
        boolean hasDot = false;
        for (int i = 0; i < size; i++) {
            char c = word.charAt(i);
            if (c >= '0' && c <= '9') {
                hasDigit = true;
            } 
            // Allow only one decimal point
            else if (c == '.' && !hasDot || c == ',' && !hasDot) {
                hasDot = true;
            } 
            // Allow a minus sign only at the start
            else if (c == '-' && i == 0 || c == '+' && i == 0 ) {
                continue;
            }
            else {
                return false;
            }
        }
        return hasDigit;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        while(word.compareTo("FIM") != 0){
            int size = word.length();
            boolean oV = onlyVowels(word, size);
            boolean oC = onlyConsonants(word, size); 
            boolean oI = onlyIntegers(word, size);
            boolean oR = onlyRealNumbers(word, size);


            System.out.println((oV ? "SIM" : "NAO") + " " +
            (oC ? "SIM" : "NAO") + " " +
            (oI ? "SIM" : "NAO") + " " +
            (oR ? "SIM" : "NAO"));


            word = sc.nextLine();
        }

        sc.close();
    }
}
