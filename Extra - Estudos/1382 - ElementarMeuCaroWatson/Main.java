import java.util.*;

public class Main {

    public static int contarTrocas(int[] arr, int tam){
        int count = 0;
        for(int i = 0 ; i < tam - 1 ; i++){
            int menor = i;
            for(int j = i + 1; j < tam ; j++){
                if(arr[menor] > arr[j]){
                    menor = j;
                }
            }
            if (menor != i) { 
                int tmp = arr[i];
                arr[i] = arr[menor];
                arr[menor] = tmp;
                count++;  
            }
        }
        return count;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int instancias = sc.nextInt();
        
        for(int i = 0; i < instancias ; i++){
            int tamanho = sc.nextInt();
            int[] arr = new int[tamanho];

            for(int j = 0 ; j < tamanho ; j++){
                arr[j] = sc.nextInt();
            }
            int contador = contarTrocas(arr, tamanho);
            System.out.println(contador);
        }
        
        sc.close();
    }
    
}
