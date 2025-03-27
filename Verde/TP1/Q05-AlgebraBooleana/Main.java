import java.util.*;

public class Main {

    static void indentifyExpression(String word){
        

    }
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        while(!word.equals("FIM")){
            indentifyExpression(word);


        }
        sc.close();
    }
}
