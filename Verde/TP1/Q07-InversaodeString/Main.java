import java.util.*;

public class Main {

     /*public static String reverseWord(String word) {
        StringBuilder sb = new StringBuilder(word);
        String reverseString = sb.reverse().toString();
        return reverseString;

    }*/

    public static String reverseString(String word){
        int size = word.length();
        char[] newWord = new char[size];
        for( int i = 0 ; i < size ; i++){
            newWord[i] = word.charAt(size - 1 - i);
        }
        return new String(newWord); //Converte char pra String
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        while (word.compareTo("FIM") != 0) {
        reverseString(word);
        System.out.println(reverseString(word));
        word = sc.nextLine();
        } 
        sc.close();
    }
}
