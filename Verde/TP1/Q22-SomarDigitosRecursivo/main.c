#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int sumOfNumbers(int integer){
    if(integer < 10){
        return integer;
    } 

    return integer % 10 + sumOfNumbers(integer/10);
}



int main (){
    char *word = (char*)malloc(100*sizeof(char));
    fgets(word, 100, stdin);
    if(word == NULL){
        return 1;
    }

    while(strcmp(word, "FIM\n") != 0){
        int size = strlen(word);
        if(size > 0 && word[size - 1] == '\n'){
            word[size - 1] = '\0';
            size--;
        }

        int integer = atoi(word);
        int sum = sumOfNumbers(integer);

        printf("%d\n", sum);
        fgets(word, 100, stdin);

    }
    free(word);
    return 0;
}