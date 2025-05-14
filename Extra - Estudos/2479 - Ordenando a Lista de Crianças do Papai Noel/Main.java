import java.util.*;

public class Main{

    public static void sortChild(String[] c, int totalCrianca){
        for(int i = 0 ; i < totalCrianca - 1 ; i++){
            int primeiro = i;
            for (int j = i + 1 ; j < totalCrianca ; j++) {
                if (c[i].compareTo(c[j]) > 0) {
                    primeiro = j;
                }
            }
            String tmp = c[i];
            c[i] = c[primeiro];
            c[primeiro] = tmp;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int totalCrianca = sc.nextInt();
        sc.nextLine();

        String[] criancas = new String[totalCrianca];
        int comportaram = 0;
        int naoComportaram = 0;

        for (int i = 0 ; i < totalCrianca ; i++) {
            String nome = sc.nextLine();
            char s = nome.charAt(0);

            String c = nome.substring(2);

            if (s == '-') {
                naoComportaram++;
            } else {
                comportaram++;
            }
            
            criancas[i] = c;
        }

        sortChild(criancas, totalCrianca);

        for (int i = 0 ; i < totalCrianca ; i++) {
            System.out.println(criancas[i]);
        }

        System.out.println("Se comportaram: " + comportaram + "| Nao se comportaram:" + naoComportaram);
       

        sc.close();
    }


}