package ex2;

import java.util.*;

public class Main {

    public static boolean FindNumber(int dir, int[] arr, int x){
        int esq = 0;
        
        while(esq <= dir){
            int mid = dir/2;
            if(x == arr[mid]){
                return true;
            }else if(x < arr[mid]){
                dir = mid - 1;
            } else {
                esq = mid + 1;
            }
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int num = sc.nextInt();
        int[] arr = new int[size];  


        for(int i = 0 ; i < size ; i++){
            arr[i] = sc.nextInt();
        }

        boolean resp = FindNumber(size, arr, num);

        if (resp == true) {
            System.out.println("sim");
        } else {
            System.out.println("nao");
        }

    }
    
}
