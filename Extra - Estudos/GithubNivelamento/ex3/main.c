#include <stdio.h>

int biggestNumber(int size, int arr[], int m){
    m = arr[0];                                        //Posicao 0
    for(int i = 0; i < size; i++){
        if(m < arr[i]){
            m = arr[i];
        }
    }
     return m;
}

int smallestNumber(int size, int arr[], int s){
    s = arr[0];
    for(int i = 0; i < size; i++){
        if(s > arr[i]){
            s = arr[i];
        }
    }
    return s;
}


int main(){
    int array[100], size;
    int big, small;

    scanf("%d", &size);

    for(int i = 0 ; i < size ; i++){
        scanf("%d", &array[i]);
    }

    int bigger = biggestNumber(size, array, big);
    int smallest = smallestNumber(size, array, small);
    printf("O maior número é: %d\n", bigger);
    printf("O menor número é: %d\n", smallest);
    return 0;
}