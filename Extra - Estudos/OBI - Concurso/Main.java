import java.util.*;

public class Main {

    public static int sortNotas(int[] notas, int c, int numMin){
        for(int i = 0 ; i < c - 1 ; i++){
            int menor = i;
            for(int j = i + 1 ; j < c ; j++){
                if(notas[j] > notas[menor]){
                    menor = j;
                }
            }

            int tmp = notas[i];
            notas[i] = notas[menor];
            notas[menor] = tmp;
        }
        return notas[numMin];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int candidates = sc.nextInt();
        int numMin = sc.nextInt();

        int[] notas = new int[candidates];

        for(int i = 0 ; i < candidates ; i++){
            int score = sc.nextInt();
            notas[i] = score;
        }

        int answer = sortNotas(notas, candidates, numMin - 1);
        System.out.println(answer);

        sc.close();
    }
}
