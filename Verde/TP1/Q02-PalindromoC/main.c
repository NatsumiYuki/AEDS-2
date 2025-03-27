#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

bool verifyPalindromo(char *frase, int tam){
    for(int i = 0, j = tam -1 ; i < tam/2; i++, j--){
        if(frase[i] != frase[j]){
            return false;
        }
    } 
    return true;
}

void printAnswer(bool ePalindromo){
    if(ePalindromo == true){
        printf("SIM\n");
    }else if(ePalindromo == false){
        printf("NAO\n");
     }
}

int main(){
    char *frase;

    frase = (char *)malloc(100*sizeof(char));
    if(frase == NULL){
        return 1;
    }
    fgets(frase, 100, stdin);
    

    while(strcmp(frase, "FIM\n") != 0){
        int n = strlen(frase);
        if (frase != NULL) {
            if(n > 0 && frase[n - 1] == '\n'){
                frase[n - 1] = '\0';
                n--;
            }

            bool ePalindromo = verifyPalindromo(frase, n);
            printAnswer(ePalindromo);
        }

        fgets(frase, 100, stdin);
    }
    free(frase);

    return 0;
}