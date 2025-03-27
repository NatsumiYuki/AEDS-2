package BubbleSort;

public class BubbleBetter {
    static int[] arr;
    static int n;

    public BubbleBetter(int size){
        int[] arr = new int[size];
        int n = 0;
    }

    public static void bubbleMelhorada(int[] arr) {
        int n = arr.length;
        boolean trocou = true;
    
        for (int i = n - 1; i > 0 && trocou; i--) {  // Percorre de trás para frente
            trocou = false;
            
            for (int j = 0; j < i; j++) {  // Compara elementos adjacentes
                if (arr[j] > arr[j + 1]) {  // Ordenação crescente
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    trocou = true;
                }
            }
        }
    }


    
}
