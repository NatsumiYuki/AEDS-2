import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int E = sc.nextInt();
        int D = sc.nextInt();

        if(E > D){
            System.out.println(E + D);
        } else {
            System.out.println((D - E)*2);
        }



        sc.close();
    }
}
