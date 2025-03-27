import java.util.*;

public class Main{

    public static boolean verifyString(String word){
        int size = word.length();
        int count = 0;
        for(int i = 0 ; i < size ; i++){
            char c = word.charAt(i);
            if(c == '('){
                count++;
            } else if(c == ')'){
                count--;
                if(count < 0){
                    return false;
                }
            }   
            
        }
        return count == 0;
    }



    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        while(sc.hasNextLine()){
            String word = sc.nextLine();

            boolean isTrue = verifyString(word); 
            if(isTrue){
                System.out.println("correct");
            } else {
                System.out.println("incorrect");
            }


        }

        sc.close();
    }
}