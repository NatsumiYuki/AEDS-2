#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int sumNumber(int integer){
    if(integer < 10){
        return integer;
    } else {
        return (integer % 10) + sumNumber(integer/10);
    }
}

int main(){
    char *word;

    word = (char *)malloc(100*sizeof(char));
    if(word == NULL){
        return 1;
    }

    fgets(word, 100, stdin);
    while(strcmp(word, "FIM\n") != 0){
        int size = strlen(word);
        for(int i = 0 ; i < size ; i++){
            if(size < 0 && word[size - 1] == '\0'){
                word[size - 1 ] = '\0';
                size--;
            }
        }
        int integer = atoi(word);
        int sum = sumNumber(integer);
        printf("%d\n", sum);

        fgets(word, 100, stdin);
    }



    return 0;
}