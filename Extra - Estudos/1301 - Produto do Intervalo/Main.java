import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        while(sc.hasNext()){
        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine(); 

        int[] X = new int[N];
        for (int i = 0; i < N; i++) {
            X[i] = sc.nextInt();
        }
        sc.nextLine();
        String resul = "";

        for (; K != 0 ; K--) {
            String comando = sc.nextLine();
            String[] partes = comando.split(" ");   
            String tipo = partes[0];
            
            int i = Integer.parseInt(partes[1]);
            int j = Integer.parseInt(partes[2]);
            int produto = 1;
            
            if (tipo.equals("C")) {
                X[i - 1] = j;
            } else if (tipo.equals("P")) {
               boolean hasZero = false;
                int negCount = 0;
                for (int a = i - 1; a <= j - 1; a++) {
                    if (X[a] == 0) {
                        hasZero = true;
                        break;
                    } else if (X[a] < 0) {
                        negCount++;
                    }
                }
                if (hasZero) {
                    resul += "0";
                } else if (negCount % 2 != 0) {
                    resul += "-";
                } else {
                    resul += "+";
                }
            }
        } 
        System.out.println(resul);
    }
        
        sc.close();
    }
}
