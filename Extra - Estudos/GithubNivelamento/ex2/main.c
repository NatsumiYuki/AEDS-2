#include <stdio.h>
#include <stdbool.h>

bool binarySearch(int array[], int size, int x ){
    bool found = false;
    int dir = size - 1;
    int esq = 0;

    while(esq <= dir){
        int mid = (esq + dir)/2;
        if(x == array[mid]){
            return true;
        } else if (x > array[mid]){
            esq = mid + 1;
        } else {
            dir = mid - 1;
        }
    }
    return false;
}

int main(){
    int array[100], size, num;

    printf("Insira o tamanho da array: ");
    scanf("%d", &size);
    printf("Insira o número a ser encontrado: ");
    scanf("%d", &num);

    for(int i = 0; i < size ; i++){
        scanf("%d", &array[i]);
    }

    bool resul = binarySearch(array, size, num);

    if(resul == true){
        printf("Numero encontrado.\n");
    } else {
        printf("Numero nao encontrado.\n");
    }

    return 0;
}