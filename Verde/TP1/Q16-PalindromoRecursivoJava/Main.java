import java.util.*;

public class Main{

    public static boolean isPalindromo(String word, int dir, int esq){
        boolean answer = true;
        if(dir <= esq){
            if(word.charAt(esq) == ' '){
                esq--;
            }
            if(word.charAt(dir) == ' '){
                dir++;
            }

            if(word.charAt(esq) != word.charAt(dir)){
                answer = false;
            } else {
                return isPalindromo(word, dir + 1, esq - 1);
            }
        }
        return answer;
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        
        while(!word.equals("FIM")){
            int size = word.length();
            boolean isPalindromo = isPalindromo(word, 0, size - 1);

            if(isPalindromo){
                System.out.println("SIM");
            }else{
                System.out.println("NAO");
            }


            word = sc.nextLine();
        }
        


        sc.close();
    }



}