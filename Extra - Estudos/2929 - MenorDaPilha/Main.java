import java.util.*;

class PilhaPresentes {
    int[] presentes; 
    int topo;        
    int capacidade;  

    // Construtor da pilha
    public PilhaPresentes(int capacidade) {
        this.capacidade = capacidade;
        this.presentes = new int[capacidade];
        this.topo = -1; 
    }


    public void pop(){
        if(topo == -1){
            System.out.println("EMPTY");
        } else {
            topo--;
        }
    }
 
    public void push(int valor){
        if(topo < capacidade - 1){
            presentes[++topo] = valor;
        }
    }

    public void min(){
        if(topo == -1){
            System.out.println("EMPTY");
        } else {
            int menor = presentes[0];
            for(int i = 1 ; i <= topo ; i++){
                if(presentes[i] < menor){
                    menor = presentes[i];
                }
            }
            System.out.println(menor);
        }
    }
}

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int numOperacaoes = sc.nextInt();
        sc.nextLine();

        PilhaPresentes pilha = new PilhaPresentes(1000);

        for(int i = 0 ; i < numOperacaoes ; i++){
            String op = sc.nextLine();

            if(op.equals("MIN")){
                pilha.min();
            } else if (op.equals("POP")){
                pilha.pop();
            } else {
                int v = Integer.parseInt(op.substring(5));
                pilha.push(v);
            }
        }


        sc.close();
    }
}
