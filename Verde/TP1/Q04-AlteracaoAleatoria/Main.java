import java.util.*;

public class Main{
    public static void findRandom(String word, Random gerador){
        char o, n;
        //Using the code that VERDE gives
        o = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
        n = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
        subsCharacter(o, n, word);
    }

    public static void subsCharacter(char o, char n, String word){
        int size = word.length();
        char[] answer = new char[size];
        for(int i = 0; i < size ; i++){
            char c = word.charAt(i);
            if(c == o){
                 answer[i]= n;
            } else {
                answer[i] = c;
            }
        }
        System.out.println(new String(answer));
    }

    
     public static void main(String[] args){
        Scanner sc =  new Scanner(System.in);
        String word = sc.nextLine();
        //O SEED TEM QUE ESTAR NA MAIN FORA DA FUNCAO PQ SE NAO A SEED FICA REGENARANDO O TEMPO TODO
        Random gerador = new Random();
        gerador.setSeed(4);
        while(word.compareTo("FIM") != 0){
            //Find the two characters
            findRandom(word, gerador);
            word = sc.nextLine();
        }
        sc.close();
    }
}