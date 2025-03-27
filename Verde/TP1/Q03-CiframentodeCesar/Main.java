import java.util.*;

public class Main {

    public static String newWord(String word){
        int size = word.length();
        char[] answer = new char[size];

        for (int i = 0; i < size ; i++){
            char c = word.charAt(i);
            if(c > 0 && c <= 127){
                //soma 3 ao seu valor numérico na tabela ASCII e converte o resultado de volta para um caractere char
                answer[i] =  (char)(c + 3);
            } else {
                //Mantem se nao esta nas delimitacoes
                answer[i] = c;
            }
        }
        return new String(answer);

    }

    static public void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();

        while(!word.equals("FIM")){
            String answer = newWord(word);
            System.out.println(answer);
            word = sc.nextLine();
        }

        sc.close();
    }

}
