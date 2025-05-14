#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct{
    char nome[100];
    int peso;
    int ranking;
}Pilotos;

void selectionSort(Pilotos pilotos[], int q){
    for(int i = 0 ; i < q - 1 ; i++){
        int menor = i;
        for(int j = i + 1 ; j < q ; j++){
            if(pilotos[menor].peso > pilotos[j].peso){
                menor = j;
            } else if(pilotos[menor].peso == pilotos[j].peso){
                if(pilotos[menor].ranking > pilotos[j].ranking){
                    menor = j;
                } else if(pilotos[menor].ranking == pilotos[j].ranking){
                    if(strcmp (pilotos[menor].nome, pilotos[j].nome) > 0 ){
                        menor = j;
                    }
                }
            }
        }
        if(menor != i){
            Pilotos tmp = pilotos[menor];
            pilotos[menor] = pilotos[i];
            pilotos[i] = tmp;
        }
    }
}

int main(){
    int quantidade;
    scanf("%d", &quantidade);

    Pilotos pilotos[quantidade];

    for(int i = 0 ; i < quantidade ; i++){
        scanf("%s", &pilotos[i].nome);
        scanf("%d", &pilotos[i].peso);
        scanf("%d", &pilotos[i].ranking);
    }

    selectionSort(pilotos, quantidade);

    for(int i = 0 ; i < quantidade ; i++){
        printf("%s %d %d\n", pilotos[i].nome, pilotos[i].peso, pilotos[i].ranking);
    }


    return 0;
}