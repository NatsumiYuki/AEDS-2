import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextInt()){
            int N = sc.nextInt();
            sc.nextLine();

            String[] X = new String[200];

            for(int i = 0 ; i < N ; i++) {
                X[i] = sc.nextLine();
            }
           

            int total = 0;

            for(int i = 1; i < N ; i++) {
                String a = X[i - 1];
                String b = X[i]; 
                
                int cont = 0;
            
                for(int j = 0 ; j < a.length() ; j++) {
                    if (a.charAt(j) == b.charAt(j)) {
                        cont++;
                    } else {
                        break;
                    }

                }
                total += cont;
            }
            System.out.println(total);
        }

        sc.close();
    }
}
