import java.util.*;

public class Main {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        String entrada = sc.nextLine();

        int abertos = 0;
   
        for(int i = 0 ; i < entrada.length() ; i++){
           char c = entrada.charAt(i);
            if(c == '('){
                abertos++;
            } else if (c == ')'){
                if(abertos > 0){
                    abertos--;
                }
            }
        }
        if (abertos == 0) {
            System.out.println("Partiu RU!");
        } else {
            System.out.printf("Ainda temos %d assunto(s) pendente(s)!%n", abertos);
        }

        sc.close();
    }
}
