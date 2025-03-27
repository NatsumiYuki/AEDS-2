#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void reverseString(char *word, int size, int esq){
    char tmp;
    if(esq >= size){
        return;
    }

    tmp = word[esq];
    word[esq] = word[size];
    word[size] = tmp;
    return reverseString(word, size - 1, esq + 1);
}

int main (){
    char *word = (char*)malloc(1000);
    if(word == NULL){
        return 1;
    }

    fgets (word, 1000, stdin);
    while(strcmp(word, "FIM\n") != 0){
        int size = strlen(word);
        if(size > 0 && word[size - 1] == '\n'){
            word[size - 1] = '\0';
            size--;
        }

        reverseString(word, size - 1, 0);
        printf("%s\n", word);

        fgets (word, 1000, stdin);
    }

    free(word);
    return 0;
}