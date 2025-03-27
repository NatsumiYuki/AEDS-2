import java.util.*;

public class Main{

    public static int countUpperCase(String word){
        int size = word.length();

        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int count = 0;

        for(int i = 0 ; i < size ; i++){
            char c = word.charAt(i);
            if(upperCase.indexOf(c) != -1){
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args){
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