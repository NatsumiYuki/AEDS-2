import java.util.*;
public class Main {

    public static int sortPokemons(String[] p, int cap){

        int iguais = 0;
        for(int i = 0; i < cap - 1; i++){
            int menor = i;
            for(int j = i + 1 ; j < cap ; j++){
                if(p[j].compareTo(p[menor]) < 0){
                    menor = j;
                } else if(p[i].compareTo(p[i + 1]) == 0){
                    iguais++;
                }
            }
            if(menor != i){
                String tmp = p[i]; 
                p[i] = p[menor];
                p[menor] = tmp;
            }
        }
        return iguais;

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int capturados = sc.nextInt();
        sc.nextLine();

        String[] pokemon = new String[capturados];

        for(int i = 0 ; i < capturados ; i++){
            String nomePokemon = sc.nextLine();
            pokemon[i] = nomePokemon;
        }

        int same = sortPokemons(pokemon, capturados);

       int pokemonNaoRepetidos = capturados - same;
       int resp = 151 - pokemonNaoRepetidos;

       System.out.println("Falta(m) " + resp + " pomekon(s).");


        sc.close();
    }
    
}
