import java.util.*;

public class Main{

    public static boolean FindNumber(int size , int[] arr, int num){
            for(int i = 0 ; i < size; i++){
                if(arr[i] == num){
                    return true;
                }
            }
            return false;
        }
    
        public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
    
        System.out.println ("Digite o tamanho: ");
        int size = sc.nextInt();
    
        System.out.println("Digite o numero a ser encontrado");
        int num = sc.nextInt();
    
        int[] arr = new int[size];
    
        for(int i = 0 ; i < size ; i++ ){
            arr[i] = sc.nextInt();
        }
    
        boolean found = FindNumber(size, arr, num);

        if(found == true){
            System.out.println("sim");
        } else {
            System.out.println("nao");
        }
    }
}
