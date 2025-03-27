import java.util.*;

class Paises{
    String pais;
    String comoFala;

    public Paises(String pais, String comoFala){
        this.pais = pais;
        this.comoFala = comoFala;
    }
}

class Criancas{
    String nome;
    String lingua;

    public Criancas(String nome, String lingua){
        this.nome = nome;
        this.lingua = lingua;
    }
}


public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int traducao = sc.nextInt();
        sc.nextLine();

        Paises[] p = new Paises[traducao];

        for(int i = 0 ; i < traducao ; i++){
        String pais = sc.nextLine();
        String comoFala = sc.nextLine();
        p[i] = new Paises(pais, comoFala);
        }

        int criancas = sc.nextInt();
        sc.nextLine();
        
        Criancas[] c = new Criancas[criancas];

        for(int i = 0 ; i < criancas ; i++ ){
            String nome = sc.nextLine();
            String lingua = sc.nextLine();
            c[i] = new Criancas(nome, lingua);
        }

        for (int i = 0; i < criancas; i++) {
            for (int j = 0; j < traducao; j++) {
                if (c[i].lingua.equals(p[j].pais)) {

                    System.out.println(c[i].nome);
                    System.out.println(p[j].comoFala);
                    

                }
            }
        }
        sc.close();
    }
}