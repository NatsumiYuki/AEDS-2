#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void sortArray(int arr[], int candidates, int numMin){

    for(int i = 0 ; i < candidates - 1 ; i++){
        int menor = i;
        for(int j = i + 1 ; j < candidates ; j++){
            if(arr[menor] < arr[j]){
                menor = j;
            }
        }
        int tmp = arr[i];
        arr[i] = arr[menor];
        arr[menor] = tmp;
    }
    printf("%d", arr[numMin]);
}

int main (){
    int candidates, numMin;
    int arr[100];
    scanf("%d", &candidates);
    scanf("%d", &numMin);

    for(int i = 0 ; i < candidates ; i++){
        scanf("%d", &arr[i]);
    }

    sortArray(arr, candidates, numMin - 1);
    
    return 0;
}