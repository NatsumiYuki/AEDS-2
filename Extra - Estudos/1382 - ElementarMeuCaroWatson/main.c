#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int contarTrocas(int sequencia[], int tam){
    int count = 0;
    for(int i = 0 ; i < tam -1 ; i++){
        int menor = i;
        for(int j = i + 1 ; j < tam ; j++){
            if(sequencia[menor] > sequencia[j]){
                menor = j;
            }
        }
        if(menor != i){
            int tmp = sequencia[i];
            sequencia[i] = sequencia[menor];
            sequencia[menor] = tmp;
            count++;
        }

    }
    return count;

}

int main(){
    int instancia;
    int tam;
    int sequencia[100];


    scanf("%d", &instancia);

    for(int i = 0 ; i < instancia ; i++){
        scanf("%d", &tam);
        for(int j = 0 ; j < tam ; j++){
            scanf("%d", &sequencia[j]);
        }
        int count = contarTrocas(sequencia, tam);
        printf("%d\n", count);
    }



    return 0;
}