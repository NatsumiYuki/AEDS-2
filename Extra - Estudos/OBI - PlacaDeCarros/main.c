#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

bool mercoSul(char *entradaPlaca, int sizePlaca){
    bool isMercosul = false;
    bool isDigit = false;
    bool isUpperCase = false;
    int isUpper = 0;
    int hasDigit = 0;

    for(int i = 0 ; i < 3 ; i++){
        if(entradaPlaca[i] >= 'A' && entradaPlaca[i] <= 'Z'){
            isUpper++;
        }
    }

    if(entradaPlaca[3] >= '0' && entradaPlaca[3] <= '9'){
        isDigit = true;
    }

    if(entradaPlaca[4] >= 'A' && entradaPlaca[4] <= 'Z'){
        isUpperCase = true;
    }

    for(int i = 5 ; i < sizePlaca ; i ++){
        if(entradaPlaca[i] >= '0' && entradaPlaca[i] <= '9'){
            hasDigit++;
        }
    }

    if(isUpper == 3 && isDigit == true && isUpperCase == 1 && hasDigit == 2){
        isMercosul = true;
    } else {
        isMercosul = false;
    }
    return isMercosul;

}


bool padraoBrasil(char *entradaPlaca, int sizePlaca){
    bool isPadraoBR = false;
    int answer = 0;
    char *letra = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    int sizeLetra = strlen(letra);
    int isNumero = 0;
    int isUpperCase = 0;

    for(int i = 0 ; i < 3 ; i++){
        for(int j = 0 ; j < sizeLetra ; j++){
            if(entradaPlaca[i] == letra[j]){
                isUpperCase++;
                }
            }
        }

    for(int i = 4; i < sizePlaca ; i++){
        if(entradaPlaca[i] >= '0' && entradaPlaca[i] <= '9'){
            isNumero++;
        }
    }

    if(isUpperCase == 3 && isNumero == 4 && entradaPlaca[3] == '-'){
        isPadraoBR = true;
    } else {
        isPadraoBR = false;
    }
    return isPadraoBR;
}


int main (){
    char entradaPlaca[100];

    while(fgets(entradaPlaca, 100, stdin) != NULL){
        int sizePlaca = strlen(entradaPlaca);
        if(sizePlaca > 0 && entradaPlaca[sizePlaca - 1] == '\n'){
            entradaPlaca[sizePlaca - 1] = '\0';
            sizePlaca--;
        }


        if(sizePlaca == 8){
            bool answer = padraoBrasil(entradaPlaca, sizePlaca);
            if(answer){
                printf("1\n");
            } else {
                printf("0\n");
            }
        } else if(sizePlaca == 7){
            bool answer = mercoSul(entradaPlaca, sizePlaca);
            if(answer){
                printf("2\n");
            } 
        } else {
                printf("0\n");
        }

        
    }


    return 0;
}