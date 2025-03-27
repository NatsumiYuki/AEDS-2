#include <stdio.h>
#include <stdbool.h>

int main(){
    int array[100], size, number;
    
    scanf("%d", &size);

    for(int i = 0; i < size ; i++){
        scanf("%d", &array[i]);
    }

    bool found = false;

    printf("insira um numero?");
    scanf("%d", &number);

    for(int i = 0 ; i < size ; i++){
        if(array[i] == number){
        found = true;
        break;
    } 
}
    if(found){
        printf("Numero encontrado.\n");
    } else {
        printf("Numero nao encontrado.\n");
    }

    return 0;
}