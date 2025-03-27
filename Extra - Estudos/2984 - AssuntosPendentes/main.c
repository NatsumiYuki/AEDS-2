#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main (){
    char entrada[100];

    fgets(entrada, 100, stdin);
    if(entrada == NULL){
        return NULL;
    }
    int size = strlen(entrada);
    if(size > 0 && entrada[size - 1] == '\n'){
        entrada[size - 1] = '\0';
        size--;
    }


    int abertas = 0;
    for(int i = 0 ; i < size ; i++){
        if(entrada[i] == '('){
            abertas++;
        } else if (entrada[i] == ')'){
            // Se tivermos uma aberta diminuimos a aberta para fechala se n tiver nao contamos 
            if(abertas > 0){
                abertas--;
            }
        }
    }

    if(abertas == 0){
        printf("Partiu RU!\n");
    } else {
        printf("Ainda temos %d assunto(s) pendente(s)!\n", abertas);
    }

    return 0;
}