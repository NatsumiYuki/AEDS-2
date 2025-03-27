package SelectionSort.Normal;



import java.util.*; 



public class Main {
    
    public static void selectionSort(int[] arr) { 
        int x = arr.length; // Obtém o tamanho do array

        for (int i = 0; i < x - 1; i++) { // Percorre o array até a penúltima posição
            int menor = i; // Assume que o menor elemento está na posição atual (i)
            for (int j = i + 1; j < x; j++) { // Percorre os elementos à frente de 'i' para encontrar o menor elemento
                if (arr[j] < arr[menor]) { // Se encontrar um elemento menor, atualiza 'menor'
                    menor = j; 
                } 
            } 
            // Troca o menor elemento encontrado com o elemento na posição 'i'
            int tmp = arr[i]; 
            arr[i] = arr[menor]; 
            arr[menor] = tmp; 
        } 
    }

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        
        int[] arr = {3, 2, 4, 1, 5};


        selectionSort(arr);

        System.out.println(Arrays.toString(arr));



        sc.close();
    }
    
}
