import java.util.*;

public class Main {
    public static int compareVowel(String word, String vowels){
        int countVolwels = 0;
        
        for(int i = 0 ; i < word.length(); i++){
            char c = word.charAt(i);
            for(int j = 0 ; j < vowels.length() ; j++){
                char v = vowels.charAt(j);
                if(c == v){
                    countVolwels++;
                }
            }
        }
        return countVolwels;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String vowels;
        String word;
        
        while(sc.hasNextLine()){
            vowels = sc.nextLine();
            word = sc.nextLine();
            int answer = compareVowel(word, vowels);
            System.out.println(answer);
        }
        sc.close();
    }
}
