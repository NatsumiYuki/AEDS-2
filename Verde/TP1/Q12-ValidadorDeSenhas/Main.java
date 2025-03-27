import java.util.*;

public class Main {

    public static boolean verifyPassword(String p){
        int size = p.length();

        //contadores para descobrir se tem ou nao os pedidos
        int uppercase = 0;
        int number = 0;
        int lowercase = 0;
        int specialC = 0;

         
        if(size < 8){
            return false;
        }
        
        for(int i = 0 ; i < size ; i++){
            char c = p.charAt(i);
            if(c >= 'A' && c <= 'Z'){
                uppercase++;
            }
            if(c >= 'a' && c <= 'z'){
                lowercase++;
            }
            if(c >= '0' && c <= '9'){
                number++;
            }

            if(c == '!' || c == '#' || c == '$' || c == '%' || c == '&' || c == '*'|| c == '^'|| c == '@'){
                specialC++;
            }
        }
         //retorna vdd se tem
         return (uppercase > 0 && lowercase > 0 && number > 0 && specialC > 0);
         
            
     }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String password = sc.nextLine();

        while(password.compareTo("FIM") != 0){
           boolean answer = verifyPassword(password);
            
           if(answer){
            System.out.println("SIM");
        } else {
            System.out.println("NAO");
        }

            password = sc.nextLine();
        }
        sc.close();
    }
}
