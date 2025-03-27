import java.util.*;

class  Renas{
    String nome;
    int peso;
    int idade;
    double altura;

    public Renas(String nome, int peso, int idade, double altura ){
        this.nome = nome;
        this.peso = peso;
        this.idade = idade;
        this.altura = altura;
    }
}
public class Main{

    public static void sortWinners(Renas[] renas, int total, int escolhidas, int caso){
        
        for(int i = 0 ; i < total - 1 ; i++){
            int maior = i;
            for(int j = i + 1 ; j < total ; j++){
                if (renas[maior].peso < renas[j].peso ) {
                    maior = j;
                } else if (renas[maior].peso == renas[j].peso) {
                    if (renas[maior].idade > renas[j].idade) {
                        maior = j;
                    } else if (renas[maior].idade == renas[j].idade) {
                        if(renas[maior].altura < renas[j].altura){
                            maior = j;
                        } else if (renas[maior].altura == renas[j].altura) {
                          if (renas[maior].nome.compareTo(renas[j].nome) > 0) {
                              maior = j;
                          }  
                        }
                    }
                }
            }
            if(maior != i){
                Renas tmp = renas[i];
                renas[i] = renas[maior];
                renas[maior] = tmp;
            }

        }
        System.out.println("CENARIO {" + (caso + 1) + "}");
        for (int i = 0; i < escolhidas; i++) {
            System.out.printf("%d - %s\n", i + 1, renas[i].nome);
        }        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numCasos = sc.nextInt();

        for(int i = 0 ; i < numCasos ; i++){
            int totalRenas = sc.nextInt();
            int escolhidasRenas = sc.nextInt();
            Renas[] renas = new Renas[totalRenas];
            
            for (int j = 0 ; j < totalRenas ; j++) {
                String nome = sc.next();
                int peso = sc.nextInt();
                int idade = sc.nextInt();
                double altura = sc.nextDouble();
                renas[j] = new Renas(nome, peso, idade, altura);
            }

            sortWinners(renas, totalRenas, escolhidasRenas, i);


        }


        sc.close();
    }


}