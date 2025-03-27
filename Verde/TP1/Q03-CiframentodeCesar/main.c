#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void newWord (char *frase, int size){
    for(int i = 0; i < size ; i++){
        if(frase[i] > 0 && frase[i] <= 127){
            frase[i] = frase[i] + 3;
        } else {
        frase[i] = frase[i];
        }
    }
}



int main (){
    char *frase;

    frase = (char *)malloc(100*sizeof(char));
    if (frase == NULL){
        return 1;
    }

    fgets(frase, 100, stdin);

    while(strcmp(frase, "FIM") != 0){
    int size = strlen(frase);
    if(size > 0 && frase[size - 1] == '\n'){
        frase[size - 1] = '\0';
        size--;
    }

    newWord(frase, size);
    printf("%s", frase);

    fgets(frase, 100, stdin);
    }


    return 0;
}