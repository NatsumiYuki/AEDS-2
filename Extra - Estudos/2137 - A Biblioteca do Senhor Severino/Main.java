import java.util.*;

class Main{

    static void sortBooks(int n, int[] code){
        for (int i = 1 ; i < n - 1; i++) {
            int maior = code[i];
            for(int j = i - 1 ; j < n ; j++){
                if (j > maior) {
                    maior = j;
                }
            }
            int tmp = i;
            i = maior;
            maior = tmp;
        }
    }



    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextInt()){
        int n = sc.nextInt();
        int[] code = new int[n];
        for (int i = 0 ; i < n ; i++) {
            int num = sc.nextInt();
            code[i] = num;
        }
        sortBooks(n, code);
        
        for(int i = 0 ; i < n ; i++){
            System.out.printf("%04d\n", code[i]);
        }
    }

        sc.close();
    }
}