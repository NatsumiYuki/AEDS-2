import java.util.*;

class Seres{
    String nome;
    int poder;
    int matou;
    int mortes;

    public Seres(String nome, int poder, int matou, int mortes){
        this.nome = nome;
        this.poder = poder;
        this.matou = matou;
        this.mortes = mortes;
    }
}


public class Main {
    public static void sortWinner(Seres[] seres, int n){
        for(int i = 0; i < n - 1 ; i++){
            int maior = i;
            for(int j = i + 1; j < n ; j++){
                if(seres[maior].poder < seres[j].poder){
                    maior = j;
                } else if (seres[maior].poder == seres[j].poder){
                    if(seres[maior].matou < seres[j].matou){
                        maior = j;
                    } else if (seres[maior].matou == seres[j].matou){
                        if(seres[maior].mortes > seres[j].mortes){
                            maior = j;
                        } else if (seres[maior].mortes == seres[j].mortes){
                            if(seres[j].nome.compareTo(seres[maior].nome) < 0){
                                maior = j;
                            }
                        }
                    }
                }
            }
            Seres tmp = seres[i];
            seres[i] = seres[maior];
            seres[maior] = tmp;

        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int numPlayers = sc.nextInt();
        sc.nextLine();

        Seres[] seres = new Seres[numPlayers];

        for(int i = 0 ; i < numPlayers ; i++){
            String nome = sc.next();
            int poder = sc.nextInt();
            int matou = sc.nextInt();
            int mortes = sc.nextInt();
            seres[i] = new Seres(nome, poder, matou, mortes);
        }

        sortWinner(seres, numPlayers);
        System.out.println(seres[0].nome);

        sc.close();
    }
}
