import java.util.*;

public class Main {

    public static int countUpperCase(String word){
        int count = 0;
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for(int i = 0 ; i < word.length() ; i++){
            char c = word.charAt(i);
            for(int j = 0 ; j < upperCase.length() ; j++){
                char up = upperCase.charAt(j);
                if(c == up){
                    count++;
                }
            }
        }
        return count;
    }


    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();

        while(!word.equals("FIM")){
            int upperCase = countUpperCase(word);
            System.out.println(upperCase);
            word = sc.nextLine();
        }

        sc.close();
    }    
}
