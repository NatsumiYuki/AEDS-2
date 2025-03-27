#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void newWord(char *word, int size, int esq){
    //STOP
    if (esq >= size || word[esq] == '\0') {
        return;
    }
    
    if(word[esq] > 0 && word[esq] <= 127){
        word[esq] = word[esq] + 3;
    } else {
        word[esq] = word[esq];
    }
    //RECURCAO
    return newWord(word, size, esq + 1);

}


int main(){
    char *word;  

    word = (char*)malloc(1000*sizeof(char));
    if(word == NULL){
        return 1;
    }

    fgets(word, 1000, stdin);

    while(strcmp(word, "FIM\n") != 0){
        int size = strlen(word);
            if(size > 0 && word[size -1] == '\n'){
                word[size - 1] = '\0';
                size--;
            }
        

        newWord(word, size, 0);
        printf("%s\n", word);

        fgets(word, sizeof(word), stdin);

    }

    free(word);
    return 0;
}