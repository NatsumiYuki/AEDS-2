#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

bool verifyPalindromo(char *word, int esq, int dir){
// OFR THIS SHIT TO WORK WE HAVE TO SEE IF THERE ARE ANY SPACES 
    if(esq <= dir){
        if(word[esq] == ' '){
            esq++;
        }
        if(word[dir] == ' '){
            dir--;
        }
        
    //While esq is smaller than dir
        if(word[esq] != word[dir]){
            return false;
        } else {
            return verifyPalindromo(word, esq + 1, dir - 1);
        }
    }
    return true;
}


int main (){

    char *word;
    //aloca a memoria para ser uma bela string
    word = (char *)malloc(1000*sizeof(char));
    fgets(word, 1000, stdin);

    while(strcmp(word, "FIM\n") != 0){
        int size = strlen(word);
        if(word != NULL){
            if(size > 0 && word[size - 1] == '\n'){
                word[size - 1] = '\0';
                size--;
            }
        }   
        bool isPalindromo = verifyPalindromo(word, 0, size - 1);
        if(isPalindromo){
            printf("SIM\n");
        } else {
            printf("NAO\n");
        }

        fgets(word, 1000, stdin);
    }

    free(word);

    return 0;
}