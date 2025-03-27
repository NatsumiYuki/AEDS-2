package BubbleSort;


public class BubbleSort{
    static int[] arr;
    static int n;
        
    public BubbleSort(int size){
        int[] arr = new int[size];
        int n = 0;
    }

    public static void bubbleSort(int x){
    for(int i = 0 ; i < n-1 ; i++){
            for(int j = i + 1 ; j < n ; j++){
                if(arr[j] > arr[i]){
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
}



