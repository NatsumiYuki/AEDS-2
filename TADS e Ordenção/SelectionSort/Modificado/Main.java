package SelectionSort.Modificado;

public class Main {

    public static void selectionSort(int[] arr){
        int n = arr.length;

        for(int i = 0 ; i < n/2 ; i++){
            int menor = i, maior = i;
            for(int j = i + 1 ; j < n - 1 ; j++){
                if(arr[j] < arr[menor]){
                    menor = j;
                }
                if(arr[j] > arr[maior]){
                    maior = j;
                }
            }
            int tmpMenor = arr[i]; 
            arr[i] = arr[menor];
            arr[menor] = tmpMenor;

            if (maior == i) {
                maior = menor;
            }

            int tmp = arr[i];
            arr[i] = arr[maior];
            arr[maior] = tmp;
        }
    
    }


    public static void main (String[] args){

        int[] arr = {29, 10, 14, 37, 13, 5, 26};

        


        selectionSort(arr);



    }
}
